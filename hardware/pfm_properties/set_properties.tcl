##----------------------------------------------------------------------------
##      _____
##     *     *
##    *____   *____
##   * *===*   *==*
##  *___*===*___**  AVNET
##       *======*
##        *====*
##----------------------------------------------------------------------------
##
## This design is the property of Institute of Neuroinformatics, UZH and ETH Zurich. 
## Publication of this design is not authorized without written consent from INI.
##
## Disclaimer:
##    UZH makes no warranty for the use of this code or design.
##    This code is provided  "As Is". Avnet, Inc assumes no responsibility for
##    any errors, which may appear in this code, nor does it make a commitment
##    to update the information contained herein. Avnet, Inc specifically
##    disclaims any implied warranties of fitness for a particular purpose.
##                     Copyright(c) 2018 Avnet, Inc.
##                             All rights reserved.
##
##----------------------------------------------------------------------------
##
## Create Date:         Feb 25, 2018
## File Name:           set_properties.tcl
##
## Tool versions:       Vivado 2018.1
##
## Description:         Platform Tcl file for npp board
##
## Revision:            Feb 25, 2018: 1.00 Initial version
##
##----------------------------------------------------------------------------

### Define the platform
set currentDir [pwd]
set_property PFM_NAME "ini:sensors:npp_board:1.0" [get_files $currentDir/NullHop_Accelerator.srcs/sources_1/bd/NullHop_Accelerator/NullHop_Accelerator.bd]
### Define the platform clocks
set_property PFM.CLOCK { \
FCLK_CLK0 {id "0" is_default "true" proc_sys_reset "proc_sys_reset" } \
} [get_bd_cells /processing_system7_1]

# Define the platform AXI ports
set_property PFM.AXI_PORT { \
  M_AXI_GP1 {memport "M_AXI_GP"} \
  S_AXI_ACP {memport "S_AXI_ACP" sptag "ACP"} \
  S_AXI_HP0 {memport "S_AXI_HP" sptag "HP0"} \
  S_AXI_HP1 {memport "S_AXI_HP" sptag "HP1"} \
  S_AXI_HP2 {memport "S_AXI_HP" sptag "HP2"} \
  S_AXI_HP3 {memport "S_AXI_HP" sptag "HP3"} \
} [get_bd_cells /processing_system7_1]

### Define M_AXI_GP that is output from AXI Interconnect block to replace
### M_AXI_GP0 that is consumed by the counter control interface
#set_property PFM.AXI_PORT { \
#  M01_AXI {memport "M_AXI_GP"} \
#} [get_bd_cells /axi_ic_M_AXI_GP0]

### Define the platform interface to the AXI4-Stream Data FIFO
###set_property PFM.AXIS_PORT { \
###  M_AXIS {type "M_AXIS"} \
###} [get_bd_cells /axis_data_fifo_0]

### Define the platform interrupt ports
###set intVar []
###for {set i 0} {$i < 16} {incr i} {
###  lappend intVar In$i {}
###}

###set_property PFM.IRQ $intVar [get_bd_cells /xlconcat_0]

