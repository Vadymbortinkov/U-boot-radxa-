SUMMARY = "Quasar SPA web app with Nginx"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"


SRC_URI = "file://dist/spa/ \
           file://webapp.conf"


RDEPENDS_${PN} += "nginx"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/var/www/html
    install -d ${D}/etc/nginx/conf.d
    cp -r ${S}/dist/spa/* ${D}/var/www/html/
    install -m 0644 ${WORKDIR}/webapp.conf ${D}/etc/nginx/conf.d/
}

FILES:${PN} += "/var/www/html/* \
                /etc/nginx/webapp.conf"