# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "ASGI specs, helper code, and adapters"
HOMEPAGE = "https://github.com/django/asgiref/"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f09eb47206614a4954c51db8a94840fa"

SRC_URI = "https://files.pythonhosted.org/packages/12/19/64e38c1c2cbf0da9635b7082bbdf0e89052e93329279f59759c24a10cc96/asgiref-${PV}.tar.gz"
SRC_URI[md5sum] = "7cd61836ec3c329f415309f88e92e0e3"
SRC_URI[sha1sum] = "f70499d10248221b252e0b13ab7b121e6d62f4d7"
SRC_URI[sha256sum] = "9e0ce3aa93a819ba5b45120216b23878cf6e8525eb3848653452b4192b92afed"
SRC_URI[sha384sum] = "51e18d6aef17bb639a71e51f32e88e0364c9e27c8a22608b680b4d2895d47a073949a60daa96518c25a8ad97aa706f79"
SRC_URI[sha512sum] = "578ccb54e25869ac9bc7bcd59819d4fc056fdb89a27ec3d7c5b74608984c9d18b41f0b281a3a67bf6b56ad85a7009e336bbdd4a76e2b4a0c8a26c0dfef2687a8"

S = "${WORKDIR}/asgiref-${PV}"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
# The configs are might not correct, since PACKAGECONFIG does not support expressions as may used in requires.txt - they are just replaced by text.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "python-version-smaller-3-dot-11 tests"
PACKAGECONFIG[python-version-smaller-3-dot-11] = ",,,python3-typing_extensions"
PACKAGECONFIG[tests] = ",,,python3-mypy python3-pytest python3-pytest-asyncio"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-asyncio python3-core python3-io python3-logging python3-math python3-numbers python3-stringold python3-threading python3-typing-extensions"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    _typeshed
