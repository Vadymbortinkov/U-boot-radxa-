SUMMARY = "Quasar SPA web app"
LICENSE = "MIT"

SRC_URI = "file://dist/spa/*"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/var/www/html
    cp -r ${S}/dist/spa/* ${D}/var/www/html/
}

FILES:${PN} += "/var/www/html/*"
