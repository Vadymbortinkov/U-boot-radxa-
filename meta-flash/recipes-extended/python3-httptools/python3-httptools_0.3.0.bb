# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "A collection of framework independent HTTP protocol utils."
HOMEPAGE = "https://github.com/MagicStack/httptools"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   vendor/llhttp/LICENSE-MIT
# NOTE: Original package / source metadata indicates license is: MIT
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a2d82955bf3facdf04cb882655e840e \
                    file://vendor/http-parser/LICENSE-MIT;md5=9bfa835d048c194ab30487af8d7b3778 \
                    file://vendor/llhttp/LICENSE-MIT;md5=f5e274d60596dd59be0a1d1b19af7978"

SRC_URI = "https://files.pythonhosted.org/packages/5b/0c/649c671aaf8c22bffd48e2c5e3fdd1fe24be5cb10042073ed6f6183e2cd3/httptools-${PV}.tar.gz"
SRC_URI[md5sum] = "ab8c8611db1de8bc730868dcdb2fe4cd"
SRC_URI[sha1sum] = "c797ec454001bbbce1a26f944ac5d11efb013668"
SRC_URI[sha256sum] = "3f9b4856d46ba1f0c850f4e84b264a9a8b4460acb20e865ec00978ad9fbaa4cf"
SRC_URI[sha384sum] = "43144b3129ddf3c3209c839fbd1cbf75831f18ac2cf4b92fa80415f6949dc7f64cf77dc30b15ba581c0091d575e8fbff"
SRC_URI[sha512sum] = "37a87aadd30b73e4a861599ad9a37edbfaa1bdafbfa0ebf8cda2386272d0eb24b160f106fc283877b1c9992066e31c7fb1f87913e9da4a5a517807b337b7442c"

S = "${WORKDIR}/httptools-${PV}"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
# The configs are might not correct, since PACKAGECONFIG does not support expressions as may used in requires.txt - they are just replaced by text.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "test"
PACKAGECONFIG[test] = ",,,python3-cython"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core"
