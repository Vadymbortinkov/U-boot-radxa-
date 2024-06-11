SUMMARY = "radxa-cm3-raspcm4io-pcie2x1 Device Tree Overlay"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


inherit deploy


SRC_URI = "file://radxa-cm3-raspcm4io-pcie2x1.dts"

S = "${WORKDIR}"

DEPENDS:append = " dtc-native"

do_compile() {
    dtc -I dts -O dtb -o radxa-cm3-raspcm4io-pcie2x1.dtbo radxa-cm3-raspcm4io-pcie2x1.dts
}

do_install() {
    install -d ${D}/boot/overlays
    install -m 0644 ${S}/radxa-cm3-raspcm4io-pcie2x1.dtbo ${D}/boot/overlays
}


KERNEL_DEVICETREE += "radxa-cm3-raspcm4io-pcie2x1.dtbo"

KERNEL_FEATURES:append = " cfg/of_overlay.cfg"

FILES:${PN} += "/boot/overlays/radxa-cm3-raspcm4io-pcie2x1.dtbo"
