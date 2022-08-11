SUMMARY = "Configurable embedded Linux firmware update creator and runner"
DESCRIPTION = ""
HOMEPAGE = "https://github.com/fhunleth/fwup"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS = "libconfuse libarchive libsodium zlib pkgconfig-native"


# Modify these as desired
PV = "1.5.1"
# SRC_URI = "https://github.com/fhunleth/fwup/archive/v${PV}.tar.gz"
SRC_URI = "https://github.com/fwup-home/fwup/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "86835a9ee2aceb520b3ba900758c8f90"
SRC_URI[sha256sum] = "6fa3a44b0ca4fe4196f0f486618215cf3fa06fe40963965241f8e82c7494c59c"

S = "${WORKDIR}/fwup-${PV}"

CFLAGS_prepend = "-I${S} "

inherit autotools lib_package pkgconfig
FILES_${PN} += "${datadir}/bash-completion/completions/fwup \
               ${bindir}/fwup \
"

FILES_${PN}-img2fwup = "${bindir}/img2fwup"

PACKAGES = "${PN}-dev ${PN}-dbg ${PN}-img2fwup ${PN}"
BBCLASSEXTEND = "native nativesdk"

RDEPENDS_${PN} += "bash"

do_configure_append () {
  ln -s ${S}/src/fwup.h2m ${WORKDIR}/build/src/fwup.h2m
}
