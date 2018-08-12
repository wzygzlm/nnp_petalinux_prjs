#
# This file is the testlibusb recipe.
#

SUMMARY = "Simple testlibusb application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://testlibusb.c \
	   file://Makefile \
		  "

S = "${WORKDIR}"
 
# Add dependency libraires if any
# for example DEPENDS = "libpcap"
DEPENDS = "libcaer"

do_compile() {
	     oe_runmake
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 testlibusb ${D}${bindir}
}
