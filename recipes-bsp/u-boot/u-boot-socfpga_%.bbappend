do_deploy_append() {
	sed -i -e "s,.*fdtfile.*,fdtfile=sockit_imrf.dtb,g" ${DEPLOY_DIR_IMAGE}/*.uEnv.txt
	sed -i -e "s,\(^optargs.*\),\1 uio_pdrv_genirq.of_id=generic-uio,g" ${DEPLOY_DIR_IMAGE}/*.uEnv.txt
}
