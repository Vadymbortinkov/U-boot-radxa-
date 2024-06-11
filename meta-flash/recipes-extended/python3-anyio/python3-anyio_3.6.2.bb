# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "High level compatibility layer for multiple asynchronous event loop implementations"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c0a769411d2af7894099e8ff75058c9f"


SRC_URI[md5sum] = "2a2b45a9324f7dfd3b351452f8097a3c"
SRC_URI[sha1sum] = "57528c71fbbf1c10d219270082d16fc2a8f89f62"
SRC_URI[sha256sum] = "25ea0d673ae30af41a0c442f81cf3b38c7e79fdc7b60335a4c14e05eb0947421"
SRC_URI[sha384sum] = "b010e9f9160c867f2933dcd7e3c8148b8223a380d1c0bd23c973bcb0f9b25f8a8716354a98ed609a82019e882fbe29ec"
SRC_URI[sha512sum] = "e6e852e682374e7b9cf5e15765fae7f55175504897e044eafc66998411020ccd304d327a640a986fcaab0e7e7aa7566cf1db48ac2408622d0576f4c84b3861e9"

S = "${WORKDIR}/anyio-${PV}"

inherit pypi python_setuptools_build_meta

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-asyncio python3-core python3-io python3-numbers python3-pickle python3-profile python3-pytest python3-typing-extensions python3-unittest"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    anyio
#    anyio._backends._asyncio
#    anyio._core._compat
#    anyio.abc
#    anyio.from_thread
#    anyio.lowlevel
#    anyio.streams.buffered
#    anyio.streams.file
#    anyio.streams.memory
#    anyio.streams.stapled
#    anyio.streams.text
#    anyio.streams.tls
#    anyio.to_thread
#    contextlib2
#    mock
#    pytest_mock.plugin
#    sniffio
#    trustme
#    uvloop
