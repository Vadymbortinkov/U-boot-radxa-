# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

SUMMARY = "Data validation and settings management using python type hints"
HOMEPAGE = "https://github.com/pydantic/pydantic"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c02ea30650b91528657db64baea1757"

SRC_URI = "https://files.pythonhosted.org/packages/51/cd/721eb771f3f09f60de0807e240c3acf44c38828d0ced869fe8df7e79801b/pydantic-${PV}.tar.gz"
SRC_URI[md5sum] = "b460e8ac2e9dca984454f231e36c04cf"
SRC_URI[sha1sum] = "cb17c7689a8d497ae19fe391c441f68fb0384286"
SRC_URI[sha256sum] = "32c8b48dcd3b2ac4e78b0ba4af3a2c2eb6048cb75202f0ea7b34feb740efc340"
SRC_URI[sha384sum] = "b52e2ff2381a5d5c534a410fca163b069cc21958e590cd2f628afa7305b4d5b98a188e6251f495e49ebfb6fcec1e45cf"
SRC_URI[sha512sum] = "271ee13c8a4e5605e908c334457a899418d459dba205b6bde425b8cb2f37b63cb436e8b7ae094098d949274accfdeddf9c8ec3deeb90676c06543669e056b59f"

S = "${WORKDIR}/pydantic-${PV}"

inherit setuptools3

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
# The configs are might not correct, since PACKAGECONFIG does not support expressions as may used in requires.txt - they are just replaced by text.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "dotenv email"
PACKAGECONFIG[dotenv] = ",,,python3-python-dotenv"
PACKAGECONFIG[email] = ",,,python3-email-validator"

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "python3-typing-extensions"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-datetime python3-hypothesis python3-image python3-io python3-netclient python3-numbers python3-pickle python3-python-dotenv python3-tomli python3-typing-extensions"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    cython
#    email_validator
#    mypy.errorcodes
#    mypy.nodes
#    mypy.options
#    mypy.plugin
#    mypy.plugins
#    mypy.semanal
#    mypy.server.trigger
#    mypy.types
#    mypy.typevars
#    mypy.util
#    mypy.version
#    toml
#    tomllib
