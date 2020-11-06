require recipes-core/images/voltumna-sre.bb
require include/imrf.inc
require include/imrf-sxe.inc

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="IMRF (Runtime)"
	MACHINE="${MACHINE}"
	__EOF__
}
