# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcf6b249c2641540219a727f35d8d2c2"

SRC_URI = "https://files.pythonhosted.org/packages/0c/1d/eb26f5e75100d531d7399ae800814b069bc2ed2a7410834d57374d010d96/typing_extensions-${PV}.tar.gz"
SRC_URI[md5sum] = "2bcafbd6817cb0d7a29ed7a7f1bb1e5d"
SRC_URI[sha1sum] = "c43802607d8b5c1d102401e654fcab70609fb7bc"
SRC_URI[sha256sum] = "23478f88c37f27d76ac8aee6c905017a143b0b1b886c3c9f66bc2fd94f9f5783"
SRC_URI[sha384sum] = "3e04e01c8ac23f523b69f2af1ba77b41fb418534460e537c176c7c0cf2be7ae25d5e7620632dbe01866e120fdb9e9e6a"
SRC_URI[sha512sum] = "b4faea71d6d29b5d23f920c8865edc2a891887308aea984dbae0159b722da6ef0f4062e5d89bd96a0037391e91e87f213f789209dc1f8942e551979539d3ae11"

S = "${WORKDIR}/typing_extensions-${PV}"

inherit python_flit_core

