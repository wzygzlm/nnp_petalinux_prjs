#The max # of GPIOs this release of Linux is configured to support is 1024.  The ZYNQ PS GPIO block has 118 IOs (54 on MIO, 64 on EMIO).  
#1024-118 = 906, hence “gpiochip906”.  In our design, we have BT_REG_ON tied to EMIO[0], which is the first GPIO after all of the MIO, or 906 + 54 = 960.

#Turn echo of commands on:
set -v

# Get Wi-Fi MAC address and re-use it for bluetooth BDADDR
BD_ADDR=`cat /sys/class/net/wlan0/address`
#To turn on BT_REG_ON, which is on EMIO GPIO #0
echo 960 > /sys/class/gpio/export
echo out > /sys/class/gpio/gpio960/direction
echo 1 > /sys/class/gpio/gpio960/value
#Set uart0 = serial1 = ttyPS1 baudrate:
#(this was for UART0 from PS) stty -F /dev/ttyPS1 115200
#(this was for UART0 from PL) stty -F /dev/ttyS0 115200
stty -F /dev/ttyS2 115200
stty -F /dev/ttyS2 crtscts
# Initialize the device:
hciattach /dev/ttyS2 -t 10 bcm43xx 3000000 flow nosleep $BD_ADDR
sleep 2s

#Configure the right BT device:
hciconfig hci0 up

#The settings below are optional
sleep 1s
hciconfig hci0 reset
hciconfig hci0 class 0x200404
#for no password:
hciconfig hci0 sspmode 1
hciconfig hci0 piscan
hciconfig hci0 leadv
hciconfig -a
#end new

sleep 1s
#Scan for BT devices:
hcitool scan
set +v
#Above turns echo off

#Scan for BLE devices:
#hcitool lescan

#hciconfig -a
#hcitool dev


