# 1 "/home/petalinux/nnp_petalinux_prjs/custom_nnp_2017_2/build/../components/plnx_workspace/device-tree-generation/system-top.dts"
# 1 "<built-in>"
# 1 "<command-line>"
# 1 "/home/petalinux/nnp_petalinux_prjs/custom_nnp_2017_2/build/../components/plnx_workspace/device-tree-generation/system-top.dts"







/dts-v1/;
/include/ "zynq-7000.dtsi"
/include/ "pl.dtsi"
/include/ "pcw.dtsi"
/ {
 chosen {
  bootargs = "earlycon";
  stdout-path = "serial0:115200n8";
 };
 aliases {
  ethernet0 = &gem0;
  serial0 = &uart1;
  spi0 = &qspi;
 };
 memory {
  device_type = "memory";
  reg = <0x0 0x40000000>;
 };
 cpus {
 };
};
# 1 "/home/petalinux/nnp_petalinux_prjs/custom_nnp_2017_2/build/tmp/work/plnx_arm-xilinx-linux-gnueabi/device-tree-generation/xilinx+gitAUTOINC+43551819a1-r0/system-user.dtsi" 1
/include/ "system-conf.dtsi"

&qspi {
 #address-cells = <1>;
 #size-cells = <0>;
 flash0: flash@0 {
  compatible = "micron,m25p80";
  reg = <0x0>;
  #address-cells = <1>;
  #size-cells = <1>;
  spi-max-frequency = <50000000>;
  partition@0x00000000 {
   label = "boot";
   reg = <0x00000000 0x00ff0000>;
  };
 };
};

/{
 usb_phy0: usb_phy@0 {
  compatible = "ulpi-phy";
  #phy-cells = <0>;
  reg = <0xe0002000 0x1000>;
  view-port = <0x0170>;
  drv-vbus;
 };
};

&usb0 {
 dr_mode = "otg";
 usb-phy = <&usb_phy0>;
} ;



&uart1 {
    status = "okay";
 current-speed = <115200>;
 port-number = <0>;
};
# 29 "/home/petalinux/nnp_petalinux_prjs/custom_nnp_2017_2/build/../components/plnx_workspace/device-tree-generation/system-top.dts" 2
