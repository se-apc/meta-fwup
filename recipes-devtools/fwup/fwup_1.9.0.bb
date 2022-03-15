SUMMARY = "Configurable embedded Linux firmware update creator and runner"
DESCRIPTION = ""
HOMEPAGE = "https://github.com/fhunleth/fwup"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS = "libconfuse libarchive libsodium zlib pkgconfig-native"


# Modify these as desired
PV = "1.9.0"
SRC_URI = "https://github.com/fhunleth/fwup/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "9b8691f446ad8f1b3e2605556cab78f4"
SRC_URI[sha256sum] = "18ae6753145cef2fd5f5fc83e29c2d883e570668d8aa064ee6c94d4c5e44d73d"

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
