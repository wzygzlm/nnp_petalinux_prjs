#for Magnetometer:
echo "insmod /lib/modules/4.6.0-xilinx/extra/lis3mdl_mag.ko"
insmod /lib/modules/4.6.0-xilinx/extra/lis3mdl_mag.ko
echo "cat /proc/modules"
cat /proc/modules

#for Motion and Temperature sensor:
#echo "insmod /lib/modules/4.6.0-xilinx/extra/lis2dw12_core.ko"
#insmod /lib/modules/4.6.0-xilinx/extra/lis2dw12_core.ko
#echo "insmod /lib/modules/4.6.0-xilinx/extra/lis2dw12_i2c.ko"
#insmod /lib/modules/4.6.0-xilinx/extra/lis2dw12_i2c.ko
#echo "cat /proc/modules"
#cat /proc/modules

#Wait a moment for .ko to install
echo "sleep 1"
sleep 1

#Run user application:
echo "/usr/bin/shieldtest"
/usr/bin/shieldtest


