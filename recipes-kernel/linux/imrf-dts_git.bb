SUMMARY = "The device tree for TMU"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit devicetree 

SRCREV = "f60cfebbb40a2a8126191d0533811459247bdf3f"
SRC_URI = "git://gitlab.elettra.eu/alessio.bogani/imrf-dts.git;protocol=https;"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = "sockit"

KERNEL_INCLUDE_append = " \
        ${STAGING_KERNEL_DIR}/include \
        "

FILES_${PN} += "${sysconfdir} usr"

do_install_append() {
	install -d ${D}/usr/boot/
	install -m 0644 ${D}/boot/devicetree/*.dtb ${D}/usr/boot/
	rm  -fr ${D}/boot/
        
	install -d ${D}${sysconfdir}/udev/rules.d/
        install -m 0644 ${S}/90-imrf.rules ${D}${sysconfdir}/udev/rules.d
}

