M104 S0  ; turn off hotend heater
M140 S0  ; turn off bed heater
G91  ; set to relative mode
G1 Z10  ; move bed down 10mm
G90  : set to absolute mode
G28 X0 Y0  ; home XY axis
G92 E0  ; zero extruder
M84  ; turn off motors
M107  ; turn off fans