# ENSF 592 Spring 2023
# May 9 Lab 2
# Exercise 2


# Trace through the execution of the following program. 
# Answer the questions in the comments with your group members.
# After discussing, use print statements to confirm your answers.

foo = 100
bar = foo
foo + bar

# POINT 1
# What is the value of foo at this point? 100
# What is the type of foo at this point? int
# What is the value of bar at this point? 100
# What is the type of bar at this point? int

spam = foo + bar
foo += 50
eggs = foo + bar
ham = [1, 2, 3]
baz = ham
ham.append(bar)

# POINT 2
# What is the value of foo at this point? 150
# What is the value of bar at this point? 100
# What is the value of spam at this point? 200
# What is the value of eggs at this point? 250
# What is the value of ham at this point? [1, 2, 3, 100]
# What is the value of baz at this point? [1, 2, 3]

eggs = "Python is very flexible!"
spam = ham
ham = bar
bar += bar
foo = eggs
eggs = bar + ham
baz.append(bar)

# POINT 3
# What is the value of foo at this point? "Python is very flexible"
# What is the value of bar at this point? 200
# What is the value of spam at this point? [1, 2, 3, 100]
# What is the value of eggs at this point? 300
# What is the value of ham at this point? 100
# What is the value of baz at this point? [1, 2, 3, 200]

# Print out the types and final values of each variable.

