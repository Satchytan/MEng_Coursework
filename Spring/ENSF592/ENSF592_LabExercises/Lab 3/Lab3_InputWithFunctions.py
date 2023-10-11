# ENSF 592 Spring 2023
# May 11 Lab 3
# Input With Functions (continued from Lab 2)

# Add comments to explain the functionality of this program


def get_user_input(n): #get user input
    entry = input("Please type any entry #" + str(n + 1) + ": ")
    return entry, type(entry)

def process_user_input(n, entry, type): 
    print("This is entry #" + str(n + 1) + ":", entry) #restate user inputs
    print("The type of entry #" + str(n + 1) + " is :", str(type)) #prints the type of the input


# Input Method 3
print('\n' * 2) #adds 2 new lines
print("***METHOD 3***")
num_of_repeats = 3 #define show many times it repeats
results = [] #define results as empty list
results_types = [] #define results types as empty list

for i in range(num_of_repeats): #appends each input to the empty lists containing inputs and input types
    a, b = get_user_input(i)
    results.append(a)
    results_types.append(b)

for i in range(num_of_repeats): #for loop runs code defined number of times and lists each input and type
    process_user_input(i,results[i], results_types[i])

