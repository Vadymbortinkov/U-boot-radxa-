SUMMARY = "radxa-cm3-raspcm4io-pcie2x1 Device Tree Overlay"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://flash-api.py file://flash-api.service"

inherit systemd

S = "${WORKDIR}"

RDEPENDS:${PN} = "bash"

SYSTEMD_AUTO_ENALBE = "enable"
SYSTEMD_SERVICE:${PN} = "flash-api.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/flash-api.py ${D}${bindir}

    install -d ${D}${sysconfdir}/systemd/system
    install -m 0644 ${S}/flash-api.service ${D}${sysconfdir}/systemd/system   
}