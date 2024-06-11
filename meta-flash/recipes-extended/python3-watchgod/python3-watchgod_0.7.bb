# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Simple, modern file watching and code reload in python."
HOMEPAGE = "https://github.com/samuelcolvin/watchgod"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=590816607feed6e9e7663713a5eaab1c"

SRC_URI = "https://files.pythonhosted.org/packages/fc/95/ae723eb1450763e1b2b9e70488054099c661f3b65f0c41d86b868cd6eb16/watchgod-${PV}.tar.gz"
SRC_URI[md5sum] = "a17f6c0f812ca2934c63fdae10d3a360"
SRC_URI[sha1sum] = "850827dfa0c52d8649538b190ebc08c9c342196d"
SRC_URI[sha256sum] = "48140d62b0ebe9dd9cf8381337f06351e1f2e70b2203fa9c6eff4e572ca84f29"
SRC_URI[sha384sum] = "b965e3aa2dec56641fcf46aa92bfd13066b1babe14311a57a410fdd95362210b2d04157f31771e65350d9b92c9bfa861"
SRC_URI[sha512sum] = "1278b6046172853bfa8a4e9bff4bb6aa72dc881e0e068975ccb5251f47130de6aa06affa49eae53cc61e08caa4f68c1788551143da2f4b2ebea143bb39297c94"

S = "${WORKDIR}/watchgod-${PV}"

inherit setuptools3

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-asyncio python3-core python3-logging python3-multiprocessing"
