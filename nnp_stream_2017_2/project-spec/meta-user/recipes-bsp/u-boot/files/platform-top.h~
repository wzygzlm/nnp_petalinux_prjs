
#include <configs/platform-auto.h>

#undef CONFIG_EXTRA_ENV_SETTINGS

/* Extra U-Boot Env settings */
#define CONFIG_EXTRA_ENV_SETTINGS \
	SERIAL_MULTI \ 
	CONSOLE_ARG \ 
	PSSERIAL0 \ 
	"importbootenv=echo \"Importing environment from SD ...\"; " \ 
		"env import -t ${loadbootenv_addr} $filesize\0" \ 
	"loadbootenv=load mmc $sdbootdev:$partid ${loadbootenv_addr} ${bootenv}\0" \ 
	"sd_uEnvtxt_existence_test=test -e mmc $sdbootdev:$partid /uEnv.txt\0" \ 
	"uenvboot=" \ 
	"if run sd_uEnvtxt_existence_test; then" \ 
		"run loadbootenv" \ 
		"echo Loaded environment from ${bootenv};" \ 
		"run importbootenv; \0" \ 
	"sdboot=echo boot Petalinux; fatload mmc 1 ${netstart} ${kernel_img} && bootm ${netstart}\0" \ 
	"autoload=no\0" \ 
	"clobstart=0x10000000\0" \ 
	"netstart=0x10000000\0" \
	"rdisknetstart=0x15000000\0" \ 
	"dtbnetstart=0xF000000\0" \
	"fpganetstart=0xF100000\0" \ 
	"fpgasize=0x0xF111B\0" \
	"fpga_img=design_1_wrapper.bit\0" \
	"loadaddr=0x10000000\0" \ 
	"bootsize=0x270000\0" \ 
	"bootstart=0x0\0" \ 
	"boot_img=BOOT.BIN\0" \ 
        "dtb_img=system.dtb\0" \
        "rdisk_img=uramdisk.image.gz\0" \
	"rdisk_img_fb=fb.uramdisk.image.gz\0" \
        "kernel_img=image.ub\0" \
	"fbkernel_img=fbimage.ub\0" \
	"sd_update_boot=echo Updating boot from SD; mmcinfo && fatload mmc 0:1 ${clobstart} ${boot_img} && run install_boot\0" \ 
	"install_boot=sf probe 0 && sf erase ${bootstart} ${bootsize} && " \ 
		"sf write ${clobstart} ${bootstart} ${filesize}\0" \ 
	"bootenvsize=0x10000\0" \ 
	"bootenvstart=0xFE0000\0" \ 
	"eraseenv=sf probe 0 && sf erase ${bootenvstart} ${bootenvsize}\0" \ 
	"jffs2_img=rootfs.jffs2\0" \ 
	"sd_update_jffs2=echo Updating jffs2 from SD; mmcinfo && fatload mmc 0:1 ${clobstart} ${jffs2_img} && run install_jffs2\0" \ 
	"install_jffs2=sf probe 0 && sf erase ${jffs2start} ${jffs2size} && " \ 
		"sf write ${clobstart} ${jffs2start} ${filesize}\0" \ 
	"install_kernel=mmcinfo && fatwrite mmc 1 ${clobstart} ${kernel_img} ${filesize}\0" \ 
	"cp_kernel2ram=mmcinfo && fatload mmc 1 ${netstart} ${kernel_img}\0" \ 
	"sd_update_dtb=echo Updating dtb from SD; mmcinfo && fatload mmc 0:1 ${clobstart} ${dtb_img} && run install_dtb\0" \ 
	"fault=echo ${img} image size is greater than allocated place - partition ${img} is NOT UPDATED\0" \ 
	"test_crc=if imi ${clobstart}; then run test_img; else echo ${img} Bad CRC - ${img} is NOT UPDATED; fi\0" \ 
	"test_img=setenv var \"if test ${filesize} -gt ${psize}\\; then run fault\\; else run ${installcmd}\\; fi\"; run var; setenv var\0" \ 
	"kernelsize=0xd80000\0" \ 
	"kernelstart=0x270000\0" \ 
	"default_bootcmd=run sdboot\0" \ 
	"boot_qspi=echo Booting backup kernel from QSPI..; sf probe 0 50000000; sf read ${netstart} ${kernelstart} ${kernelsize}; bootm ${netstart}\0" \ 
	"sdboot_fb=echo boot Petalinux (fallback); fatload mmc 1 ${netstart} ${fbkernel_img} && bootm ${netstart}\0" \
""

