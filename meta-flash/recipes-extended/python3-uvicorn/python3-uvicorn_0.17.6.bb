# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "The lightning-fast ASGI server."
HOMEPAGE = "https://www.uvicorn.org/"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE.md
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=206119e27d6b034e7ce70d73063c82a8"

SRC_URI = "https://files.pythonhosted.org/packages/6d/7d/b97c120cad5fd1f66462afb0d5ddd043078f2380b89fccd8a97ef5c95b5c/uvicorn-${PV}.tar.gz"
SRC_URI[md5sum] = "02ecb0a4dab4c84017c8ad7ecdff61b0"
SRC_URI[sha1sum] = "e5cc458191df0c3351e77d7a3781dcc403a8bde8"
SRC_URI[sha256sum] = "5180f9d059611747d841a4a4c4ab675edf54c8489e97f96d0583ee90ac3bfc23"
SRC_URI[sha384sum] = "e7df2440574dbcc14e8bf4970bcffaab56176faeef000c9a462b3c7775df796dbda85bc6b2dc302b1e070b80427ec97a"
SRC_URI[sha512sum] = "a86cf51119e161999dd82b414a18140a42004a48e419bab0d5a5c32e5a1332e84d47eef7f91edef558b7fabe334073d7b10ce5e2474c6b2726a4457800945ccf"

S = "${WORKDIR}/uvicorn-${PV}"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
# The configs are might not correct, since PACKAGECONFIG does not support expressions as may used in requires.txt - they are just replaced by text.
#
# Uncomment this line to enable all the optional features.
PACKAGECONFIG ?= "standard"
PACKAGECONFIG[python-version-smaller-3-dot-8] = ",,,python3-typing-extensions"
PACKAGECONFIG[standard] = ",,,python3-pyyaml python3-httptools python3-python-dotenv python3-watchgod python3-websockets"
PACKAGECONFIG[standardsys-platform-not--equals-win32andsys-platform-not--equals-cygwinandplatform-python-implementation-not--equals-pypy] = ",,,python3-uvloop!"
PACKAGECONFIG[standardsys-platform-equals--equals-win32] = ",,,python3-colorama"

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "python3-asgiref python3-click python3-h11"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-asyncio python3-core python3-email python3-html python3-io python3-json python3-logging python3-multiprocessing python3-netclient python3-typing-extensions"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    asgiref.typing
#    dotenv
#    gunicorn.arbiter
#    gunicorn.workers.base
#    websockets.extensions.permessage_deflate
#    wsproto
#    wsproto.connection
#    wsproto.extensions
#    wsproto.utilities
#    yaml
