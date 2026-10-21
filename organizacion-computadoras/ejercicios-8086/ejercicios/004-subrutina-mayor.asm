%include "asm_io.inc" 

section .data
    nums dd 1, 2, 3, 4, 5 ; Elems
section .bss

section .text
    global asm_main        

asm_main:     
    ; --- PROLOGO ---             
    enter   0,0            
    pusha                  

    mov eax, 0 ; Acc
    mov ebx, 0 ; indice
    mov ecx, 5 ; Vueltas

    while: 
        mov edx, [nums + ebx * 4]
        call mayor 
        inc ebx
        loop while

    ; --- EPILOGO ---
    popa                   
    leave                  
    xor     eax, eax       
    ret              

; ==================================================
;             ZONA DE SUBRUTINAS
; ==================================================

mayor: 
    cmp eax, edx
    jg bloque_else
    mov eax, edx
    ret

    bloque_else:
    ret