# The max # of GPIOs this release of Linux is configured to support is 1024.  The ZYNQ PS GPIO block has 118 IOs (54 on MIO, 64 on EMIO).  
# 1024-118 = 906, hence "gpiochip906".  In our design, we have BT_REG_ON tied to EMIO[0], which is the first GPIO after all of the MIO, or 906 + 54 = 960.

settings_file=/mnt/emmc/ble/settings.txt
if [ ! -f $settings_file ]
then
  echo "BLE settings.txt file not found."
else
  echo "BLE settings.txt file found.  Changing directory to the BLE demo location."
  #Note that this cd will only work if you run the script as a dot command:#. ble.sh
  cd /mnt/emmc/ble/
fi

BD_ADDR=`cat /sys/class/net/wlan0/address`

# Turn echo of commands on:
set -v
# To turn on BT_REG_ON, which is on EMIO GPIO #0
echo 960 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio960/direction
echo 1 > /sys/class/gpio/gpio960/value
# Set uart0 = 16550 UART in PL = ttyS2 baudrate:
stty -F /dev/ttyS2 115200
stty -F /dev/ttyS2 crtscts
# Initialize the device:
hciattach /dev/ttyS2 -t 10 bcm43xx 3000000 flow nosleep $BD_ADDR
set +v
# Above turns echo off

