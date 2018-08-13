DESCRIPTION = "Custom user files"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"
SECTION = "kernel"

PACKAGE_ARCH = "all"

SRC_URI += "file://wpa_supplicant.conf \
	    file://add_custom_path.sh \
	    file://wifi.sh \
	    file://format_emmc.sh \
	    file://delete_emmc.sh \
	    file://update_from_usb.sh \
	    file://mount_drives.sh \
	    file://i2c_test.sh \
	    file://shield_test.sh \
	    file://program_qspi_from_usb.sh \
	    file://onetest.sh \
"
inherit update-rc.d
INITSCRIPT_NAME = "wifi.sh"
INITSCRIPT_PARAMS = "start 99 S ."

do_install() {
	install -d ${D}/usr/local/bin/
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/wpa_supplicant.conf ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/wifi.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/wifi.sh ${D}${sysconfdir}/init.d/wifi.sh
	install -m 755 ${WORKDIR}/format_emmc.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/delete_emmc.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/update_from_usb.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/mount_drives.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/i2c_test.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/shield_test.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/program_qspi_from_usb.sh ${D}/usr/local/bin/
	install -m 755 ${WORKDIR}/onetest.sh ${D}/usr/local/bin/
}

FILES_${PN} += "/usr/local/bin/wpa_supplicant.conf \
		/usr/local/bin/wifi.sh \
                ${sysconfdir}/* \
		/usr/local/bin/format_emmc.sh \
		/usr/local/bin/delete_emmc.sh \
		/usr/local/bin/update_from_usb.sh \
		/usr/local/bin/mount_drives.sh \
		/usr/local/bin/i2c_test.sh \
		/usr/local/bin/shield_test.sh \
		/usr/local/bin/program_qspi_from_usb.sh \
		/usr/local/bin/onetest.sh \
"
