array: 		
	.space 11   #reserves space for a 10 elem array
	
char:
	.space 2
	
prompt:
 	.asciiz "Please enter 10 numbers, then press ENTER:  \n"
	
null: 
	.asciiz ""
	
space: 		
	.ascii " "
	
newline: 	
	.asciiz "\n"

main:	
	j readInt           	#jump to readInt function to get user input string
	nop

gets:           			#read multiple chars from keyboard buffer until ENTER key,
							#add NULL char and store into buffer pointed to by *array
							#passed to the subroutine
	li $s1, array       	#set base address of array to s1
							#then, fall-through to loop label.
	
loop:           			#start of read loop
	jal getc        		#jump to getc subroutine
	lb $t0, char        	#load the char from char buffer into t0, stripping null
	sb $t0, 0($s1)      	#store the char into the nth elem of array
	lb $t1, newline     	#load newline char into t1
	beq $t0, $t1, done  	#end of string?  jump to done
	addi $s1, $s1, 1    	#increments base address of array
	j loop          		#jump to start of read loop
	nop

getc:						#getc reads from the keyboard. I want to read from the UART.						
	li $v0, 8 				#syscall function number 8, read char from keyboard 
							#buffer and return ascii value. Needs 2 arguments.
							#call code for read string
	li $a0, char        	#load address of char for read, first argument
	li $a1, 2       		#length of string is 1byte char and 1byte for null, second argument
	syscall         		#store the char byte from input buffer into char
	jr $ra          		#jump-register to calling function
	nop
	
readInt:        			#read string of ascii digits, store into a local variable and  
							#convert into integer, return that int unless string contains 
							#non-integers 
	j gets          		
	nop
done:						#let s1 be top address of array, let s0 be the digitcounter
							#let s2 be the sum total
	addi $s1, $s1, -1   	#reposition array pointer to last char before newline char
	li $s0, array       	#set base address of array to s0 for use as counter
	addi $s0, $s0, -1   	#reposition base array to read leftmost char in string
	add $s2, $zero, $zero   #initialize sum to 0
	li $t0, 10      		#set t0 to be 10, used for decimal conversion
	li $t3, 1
	lb $t1, 0($s1)      	#load char from array into t1
	blt $t1, 48, error  	#check if char is not a digit (ascii<'0')
	nop
	bgt $t1, 57, error  	#check if char is not a digit (ascii>'9')
	nop
	addi $t1, $t1, -48  	#converts t1's ascii value to dec value
	add $s2, $s2, $t1   	#add dec value of t1 to sumtotal
	addi $s1, $s1, -1   	#decrement array address
lp:         				#loop for all digits preceeding the LSB
	mul $t3, $t3, $t0   	#multiply power by 10
	beq $s1, $s0, FIN   	#exit if beginning of string is reached
	nop
	lb $t1, ($s1)       	#load char from array into t1
	blt $t1, 48, error  	#check if char is not a digit (ascii<'0')
	nop
	bgt $t1, 57, error  	#check if char is not a digit (ascii>'9')
	nop
	addi $t1, $t1, -48  	#converts t1's ascii value to dec value
	mul $t1, $t1, $t3   	#t1*10^(counter)
	add $s2, $s2, $t1   	#sumtotal=sumtotal+t1
	addi $s1, $s1, -1   	#decrement array address
	j lp            		#jump to start of loop
	nop

error:          		#if non digit chars are entered, readInt returns 0
	add $s2, $zero, $zero
	j FIN
	nop

FIN:
	li $v0, 1			#print integer out (syscall function)
	add $a0, $s2, $zero #adds zero to $s2 and store in argument register $a0
	syscall				#print the integer value from $a0 out		 
	li $v0, 10      	#exits, terminates execution (syscall function)
	syscall				#just exit, nothing in the argument register