# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Read key-value pairs from a .env file and set them as environment variables"
HOMEPAGE = "https://github.com/theskumar/python-dotenv"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=55ee2c3471d386636a719c8ccac40b31"

SRC_URI = "https://files.pythonhosted.org/packages/49/62/4f25667e10561303a34cb89e3187c35985c0889b99f6f1468aaf17fbb03e/python-dotenv-${PV}.tar.gz"
SRC_URI[md5sum] = "f24cef621cb5c58379ca952817f3703c"
SRC_URI[sha1sum] = "64e2f8fd85845c1d83c95002ceff341916735e8e"
SRC_URI[sha256sum] = "a5de49a31e953b45ff2d2fd434bbc2670e8db5273606c1e737cc6b93eff3655f"
SRC_URI[sha384sum] = "cf7d93a6727bb3862f348c86b4bec26b8874794047057b6286b5711a303ab2bb30ffa9865e2d8625317d517f5aa1194a"
SRC_URI[sha512sum] = "da411fa02326ec7407bbb6760dd4e5f22eaca60d725ade3ac89302ec4e33d00fe8c231e8a64d0bc22698a93701143085c098b6703e598c6d8c2e4c57b9bafa20"

S = "${WORKDIR}/python-dotenv-${PV}"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
# The configs are might not correct, since PACKAGECONFIG does not support expressions as may used in requires.txt - they are just replaced by text.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "cli"
PACKAGECONFIG[cli] = ",,,python3-click"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core"
