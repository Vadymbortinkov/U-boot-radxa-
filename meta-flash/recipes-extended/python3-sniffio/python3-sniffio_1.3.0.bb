# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Sniff out which async library your code is running under"
HOMEPAGE = "https://github.com/python-trio/sniffio"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
# NOTE: Original package / source metadata indicates license is: Apache-2.0 & MIT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa7b86389e58dd4087a8d2b833e5fe96 \
                    file://LICENSE.APACHE2;md5=3b83ef96387f14655fc854ddc3c6bd57 \
                    file://LICENSE.MIT;md5=e62ba5042d5983462ad229f5aec1576c"

SRC_URI = "https://files.pythonhosted.org/packages/cd/50/d49c388cae4ec10e8109b1b833fd265511840706808576df3ada99ecb0ac/sniffio-${PV}.tar.gz"
SRC_URI[md5sum] = "abb96bcda81817d6c632915c53ac29c8"
SRC_URI[sha1sum] = "bf44677930fc53bd6d42a5049bdd3bbf0498a748"
SRC_URI[sha256sum] = "e60305c5e5d314f5389259b7f22aaa33d8f7dee49763119234af3755c55b9101"
SRC_URI[sha384sum] = "6f4730952105d777bf083f4b02db16c66545fe75e7749ea4de76697ed397ad1620c57f63439faa206bf63b169a7abe58"
SRC_URI[sha512sum] = "88228ec336f331ac32d3bbc1caf57cce417333cb697b44c7028da25380a36e118851d35214b4cddc9e8ab3c737d8c02e15de1374152c0850b344f64493616941"

S = "${WORKDIR}/sniffio-${PV}"

inherit setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-asyncio python3-core python3-numbers python3-pytest"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    curio
#    curio.meta
