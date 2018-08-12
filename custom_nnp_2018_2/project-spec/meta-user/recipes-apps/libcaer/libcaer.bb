#
# This file is the libcaer recipe.
#
 
SUMMARY = "libcaer pre-built library copy to rootfs"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
 
SRC_URI = " \
    file://libcaer.so.2.5.0 \
    file://* \
"
 
S = "${WORKDIR}"
 
# Add dependency libraires if any
# for example DEPENDS = "libpcap"
DEPENDS = "libusb1"
 
# If you need to create a symbolic link using the pre-built libraries you should use oe_soinstall.
# This copies libraries to "{TARGET_ROOTFS}/usr/lib" directory and create a symlink as
# lrwxrwxrwx libcpsample.so.1.0 -> libcpsample.so.1.0.1
# -rwxr-xr-x libcpsample.so.1.0.1
 
do_install() {
    install -d ${D}${libdir}
    oe_soinstall ${S}/libcaer.so.2.5.0 ${D}${libdir}
    install -d -m 0655 ${D}${includedir}/libcaer
    install -d -m 0655 ${D}${includedir}/libcaer/devices
    install -d -m 0655 ${D}${includedir}/libcaer/events
    install -d -m 0655 ${D}${includedir}/libcaer/filters
    install -m 0644 ${S}/include/*.h ${D}${includedir}/libcaer/
    install -m 0644 ${S}/includecpp/*.hpp ${D}${includedir}/libcaer/
    install -m 0644 ${S}/include/devices/*.h ${D}${includedir}/libcaer/devices/
    install -m 0644 ${S}/include/events/*.h ${D}${includedir}/libcaer/events/
    install -m 0644 ${S}/include/filters/*.h ${D}${includedir}/libcaer/filters/
    install -m 0644 ${S}/includecpp/devices/*.hpp ${D}${includedir}/libcaer/devices/
    install -m 0644 ${S}/includecpp/events/*.hpp ${D}${includedir}/libcaer/events/
    install -m 0644 ${S}/includecpp/filters/*.hpp ${D}${includedir}/libcaer/filters/
}
 
# Inhibit warnings about files being stripped
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN} = "already-stripped"
 
# If you don't have .h file to copy to /usr/include add something like below
# FILES_${PN} = "${libdir}/*.so.*"
 
FILES_${PN} = "${libdir}/*.so.* ${includedir}/*"
FILES_${PN}-dev = "${libdir}/*.so"
