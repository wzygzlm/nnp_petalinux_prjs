DESCRIPTION = "PETALINUX image definition for Xilinx boards"
LICENSE = "MIT"

require recipes-core/images/petalinux-image-common.inc 

inherit extrausers
IMAGE_LINGUAS = " "

IMAGE_INSTALL = "\
		kernel-modules \
		sudo \
		sudo-dev \
		mtd-utils \
		util-linux \
		util-linux-dev \
		util-linux-bash-completion \
		util-linux-mkfs \
		canutils \
		minicom \
		minicom-dev \
		nfs-utils \
		nfs-utils-dev \
		nfs-utils-client \
		openssh-sftp-server \
		wget \
		wget-dev \
		bash-completion \
		bash-completion-dev \
		git \
		git-dev \
		pciutils \
		pkgconfig \
		pkgconfig-dev \
		vim \
		vim-dev \
		autoconf \
		autoconf-dev \
		make \
		make-dev \
		python \
		python-dev \
		python-numpy \
		python-numpy-dev \
		run-postinsts \
		libusb-compat \
		libusb1 \
		libusb1-dev \
		libstdc++ \
		libstdc++-dev \
		glib-2.0 \
		glib-2.0-utils \
		glib-2.0-dev \
		ldd \
		packagegroup-core-boot \
		packagegroup-core-ssh-dropbear \
		tcf-agent \
		bridge-utils \
		dialog-control \
		i2csensor \
		libcaer-lib-and-test \
		myapp \
		myapp-init \
		testlibusb \
		libcaer \
		"
EXTRA_USERS_PARAMS = "usermod -P root root;"
