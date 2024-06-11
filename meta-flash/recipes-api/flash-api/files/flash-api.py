import uvicorn
from fastapi import FastAPI, HTTPException, status, WebSocket
import subprocess
import asyncio
import os
from typing import List

app = FastAPI()

# Store all active WebSocket connections
connections: List[WebSocket] = []

async def send_log_message(message: str):
    # Send a message to all active connections
    for connection in connections:
        await connection.send_text(message)

@app.websocket("/ws")
async def websocket_endpoint(websocket: WebSocket):
    # Accept the connection
    await websocket.accept()

    # Add the connection to the list of active connections
    connections.append(websocket)

    try:
        while True:
            # Keep the connection open by sending a ping every 10 seconds
            await asyncio.sleep(10)
            await websocket.send_text("ping")
    except:
        # If an error occurs, remove the connection from the list of active connections
        connections.remove(websocket)

def download_file(file_url: str):
    file_name = file_url.split('/')[-1]
    file_path = "/tmp/" + file_name

    # Check if the file exists
    if not os.path.exists(file_path):
        asyncio.run(send_log_message(f"Downloading the Image: {file_name}"))
        try:
            subprocess.run(['wget', file_url, '-O', "/tmp/" + file_url.split('/')[-1]], check=True)
        except subprocess.CalledProcessError:
            error_message = f"Failed to download the image: {file_name}"
            asyncio.run(send_log_message(error_message))
            raise HTTPException(status_code=status.HTTP_500_INTERNAL_SERVER_ERROR, detail=error_message)
    else:
        asyncio.run(send_log_message(f"Image: {file_name} already exists, no need to download"))

def checksum_file(file_path: str, checksum: str):
    # Calculate the checksum of the file
    try:
        file_checksum = subprocess.run(['sha256sum', file_path], stdout=subprocess.PIPE, check=True).stdout.decode('utf-8').split(' ')[0]
    except subprocess.CalledProcessError:
        error_message = f"Failed to calculate the checksum for file {file_path}"
        asyncio.run(send_log_message(error_message))
        raise HTTPException(status_code=status.HTTP_500_INTERNAL_SERVER_ERROR, detail=error_message)

    # Compare the checksum
    if file_checksum != checksum:
        os.remove(file_path)
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail='Invalid checksum')
    asyncio.run(send_log_message(f"Checksum validated for file {file_path}"))

def extract_file(file_path: str):
    try:
        subprocess.run(['unxz', file_path], check=True)
    except subprocess.CalledProcessError:
        error_message = f"Failed to extract file {file_path}"
        asyncio.run(send_log_message(error_message))
        raise HTTPException(status_code=status.HTTP_500_INTERNAL_SERVER_ERROR, detail=error_message)
    asyncio.run(send_log_message(f"Extracted file {file_path}"))

def flash_file(file_path: str):
    try:
        subprocess.run(['dd', 'if=' + file_path[:-3], 'of=/dev/nvme0n1', 'bs=1M', 'status=progress'], check=True)
    except subprocess.CalledProcessError:
        error_message = f"Failed to flash file to NVME drive from {file_path}"
        asyncio.run(send_log_message(error_message))
        raise HTTPException(status_code=status.HTTP_500_INTERNAL_SERVER_ERROR, detail=error_message)
    asyncio.run(send_log_message(f"Flashed file to NVME drive from {file_path}"))

@app.get('/')
async def home():
    return {'message': 'Hello FastAPI OS Flasing'}

@app.post('/flash')
async def flash_image(file_url: str, checksum: str):
    # Download the file
    download_file(file_url)

    asyncio.run(send_log_message(f"Checking the Image: {file_url.split('/')[-1]}"))
    # Validate the checksum
    checksum_file("/tmp/" + file_url.split('/')[-1], checksum)

    asyncio.run(send_log_message(f"Extracting the Image: {file_url.split('/')[-1]}"))
    # Extract the file
    extract_file("/tmp/" + file_url.split('/')[-1])

    asyncio.run(send_log_message(f"Flashing the Image: {file_url.split('/')[-1]}"))
    # Flash the file
    flash_file("/tmp/" + file_url.split('/')[-1])

    return {'message': 'Flashing completed'}

if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8000)