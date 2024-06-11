# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "The little ASGI library that shines."
HOMEPAGE = "https://github.com/encode/starlette"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE.md
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=11e8c8dbfd5fa373c703de492140ff7a"

SRC_URI = "https://files.pythonhosted.org/packages/2b/18/405f4fb59119b8efa203c10a04a32a927976b5450cf649c8b4c9d079d21e/starlette-${PV}.tar.gz"
SRC_URI[md5sum] = "553700ae92d793173f0f8633b9e969d6"
SRC_URI[sha1sum] = "4e4b80cd5bf5988f9cde3dbb8e7b7c96ca32c13d"
SRC_URI[sha256sum] = "c6d21096774ecb9639acad41b86b7706e52ba3bf1dc13ea4ed9ad593d47e24c7"
SRC_URI[sha384sum] = "d7111cc9acc227d3413da12b1387e127d51f5c10fdc4eace71b98a097a5593992923dd5f1c36d0eb9d9953776c3ec54d"
SRC_URI[sha512sum] = "d7e7344a6c4346ae435cd60f1f9a49cadf6a75fe384e67f4fd37af9f3f8c4da657fce766a0dd0a532c7e9de1aa0a673c3ee4d2d551961a93e14e6e2210308f6b"

S = "${WORKDIR}/starlette-${PV}"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
# The configs are might not correct, since PACKAGECONFIG does not support expressions as may used in requires.txt - they are just replaced by text.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "python-version-smaller-3-dot-10 python-version-smaller-3-dot-7 full"
PACKAGECONFIG[python-version-smaller-3-dot-10] = ",,,python3-typing_extensions"
PACKAGECONFIG[python-version-smaller-3-dot-7] = ",,,python3-contextlib2"
PACKAGECONFIG[full] = ",,,python3-itsdangerous python3-jinja2 python3-python-multipart python3-pyyaml python3-requests"

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "python3-anyio"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-asyncio python3-core python3-crypt python3-email python3-html python3-io python3-json python3-netclient python3-shell python3-threading python3-typing-extensions"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    anyio.abc
#    anyio.streams.stapled
#    itsdangerous.exc
#    multipart
#    multipart.multipart
#    yaml
