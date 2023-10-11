# ENSF 592 Spring 2023
# May 16 Lab 4
# Working with List Comprehensions and Generator Expressions


# Solve each question below using comprehensions or generator expressions.

from itertools import count

# 1. Construct a list consisting of the double of n for each n up to 50 that is divisible by 5. Print the list.

L = [n * 2 for n in range(50) if n %5 == 0]
print(L)

# 2. Construct a generator expression for calculating all the powers of 8. Print the first 8 values of the expression.

G = (8 ** i for i in count())

for i, val in enumerate(G):
    print(val, end=" ")
    if i >7: break
print()

for i, val in enumerate(G):
    print(val, end=" ")
    if i >7: break
print()

# 3. Given the list of complex numbers below, construct a dictionary that holds the real component as the key and imaginary component as the value.
# Print the final dictionary.

values = [2 + 4j, 6 + 3j, -5 + 1j, 3 + 5j, 4 + 2j]
D = {val.real:val.imag for val in values}
print(D)


# 4. Construct a generator expression for calculating the first ten triangular numbers, starting with 0. Print the results.
# Hint: 0, 0 + 1 = 1, 0 + 1 + 2 = 3, 0 + 1 + 2 + 3 = 6, etc.

G = (int(n * (n+1)/2) for n in range(10))
print(*G)

def my_generator():
    for n in range(10):
        yield (n * (n +1) /2)
    
print(*my_generator())
print(*G)


# 5. Given the list of coordinate tuples below, create a single set that lists each number that appears at least once.

coord = [(0, 1), (1, 2), (3, 4), (4, 1), (5, 2), (3, 6), (-1, 9), (7, 5), (4, 8), (6, 1), (0, 2)]

x, y = zip(*coord)
s1 = set(x)
s2 = set(y)
my_set = s1.union(s2)
print(my_set)

rezip = zip(x, y)
print(*rezip)