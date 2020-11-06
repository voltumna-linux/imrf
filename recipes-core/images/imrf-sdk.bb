require recipes-core/images/voltumna-sdk.bb
require recipes-devtools/quartus/include/quartus_18.1.1.646-std.inc
require include/imrf.inc

POPULATE_SDK_POST_TARGET_COMMAND += " install_quartus_into_sdk;"

append_to_osrelease() {
	cat <<-__EOF__ >> ${IMAGE_ROOTFS}/etc/os-release
	VARIANT_ID="${BPN}"
	VARIANT="IMRF (Cross Development)"
	MACHINE="${MACHINE}"
	__EOF__
}
