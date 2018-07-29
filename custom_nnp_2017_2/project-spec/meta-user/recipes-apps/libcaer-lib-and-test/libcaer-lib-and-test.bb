#
# This file is the libcaer-lib-and-test recipe.
#

SUMMARY = "Simple libcaer test application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
 
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
 
SRC_URI = " \
          file://davis_simple.c \
         "
 
S = "${WORKDIR}"
 
# Add dependency libraires if any
# for example DEPENDS = "libpcap"
DEPENDS = "libcaer"

#This uses libcaer.so (-lcaer)
do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -o libcaer-lib-and-test davis_simple.c -D_DEFAULT_SOURCE=1 -lcaer
}
 
do_install() {
    install -d ${D}${bindir}
    install -m 0755 libcaer-lib-and-test ${D}${bindir}
}
 
FILES_${PN} += "libcaer-lib-and-test"
