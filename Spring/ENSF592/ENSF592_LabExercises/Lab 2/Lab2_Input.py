# ENSF 592 Spring 2023
# May 9 Lab 2
# Exercise 2 - Solutions

# Add comments to explain the functionality of this program

# Input Method 1
print('\n')
print("***METHOD 1***")
input1 = input("Please enter your name: ")
print("This is the first input:", input1)


# Input Method 2d
print('\n' * 2)
print("***METHOD 2***")
input2 = "y"
while input2 != 'x':
    input2 = input("I am looking for specific input. You must type x: ")
print("This is the second input: " + input2)


# Rewrite Input Method 2 so that no break statement is necessary 
