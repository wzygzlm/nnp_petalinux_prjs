DESCRIPTION = "Custom / Misc files for MiniZed"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://pulseaudio-bluetooth.conf\
            file://minized-mount.sh \
" 


do_install() {
	install -d ${D}/etc/dbus-1/system.d
	install -m 0644 ${WORKDIR}/pulseaudio-bluetooth.conf ${D}/etc/dbus-1/system.d/pulseaudio-bluetooth.conf
	install -d ${D}/etc/rcS.d
	install -m 0755 ${WORKDIR}/minized-mount.sh ${D}/etc/rcS.d/S99minized-mount.sh
}

FILES_${PN} = " \
    /etc/dbus-1/system.d/pulseaudio-bluetooth.conf\
    /etc/rcS.d/S99minized-mount.sh \
"
