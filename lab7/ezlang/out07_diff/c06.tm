CALL 0, 0
STWi 0, 0
LDIi 1, 0
LDWi 2, 0
LTHi 3, 1, 2
BOFb 3, 17
LDIi 4, 1
STWi 1, 4
LDWi 5, 1
LDWi 6, 0
MULi 7, 5, 6
STWi 1, 7
LDWi 8, 0
LDIi 9, 1
SUBi 10, 8, 9
STWi 0, 10
LDWi 11, 0
LDIi 12, 0
EQUi 13, 11, 12
BOFb 13, -11
LDWi 14, 1
CALL 4, 14
HALT