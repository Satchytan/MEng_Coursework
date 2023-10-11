# input_processing.py
# Satchytan Karalasingham, ENSF 592 P23
# A terminal-based program for processing computer vision changes detected by a car.
# Detailed specifications are provided via the Assignment 2 git repository.
# You must include the code provided below but you may delete the instructional comments.
# You may add your own additional classes, functions, variables, etc. as long as they do not contradict the requirements (i.e. no global variables, etc.). 
# You may import any modules from the standard Python library.
# Remember to include your name and comments.



# No global variables are permitted


# You do not need to provide additional commenting above this class, just the user-defined functions within the class
class Sensor:

    # Must include a constructor that uses default values
    # You do not need to provide commenting above the constructor
    def __init__(self):
        #initialize class attributes
        self.light = "green"
        self.pedestrian = "no"
        self.vehicle = "no"

    # updates the environmental status detected by the vision system Sensor based on user inputs in the terminal
    def update_status(self): 
        
        #provide instructions to user and ask for input to change environmental status, using strip to remove any whitespaces in input
        print("Are changes detected in the vision input?")

        #Raise value error and return invalid to main() if input other than 0, 1, 2 or 3 entered by user
        try:
            user_input = input("Select 1 for light, 2 for pedestrian, 3 for vehicle, or 0 to end the program: ").strip()
            if user_input not in ["0", "1", "2", "3"]:
                raise ValueError
        except ValueError as err:
            print("You must select either 1, 2, 3 or 0.\n")
            return "invalid"

        #change environmental status based on user input, per input instructions stated in user_input variable above
        #invalid input detection included in update_status function due to simplicity of program 
        #but if more input options available could be implemented in separate function

        #assingned messages to variables to facilitate modifying them
        change_prompt = "What change has been identified? "
        invalid_response = "Invalid vision change."

        if user_input == "1":
            input_1 = input(change_prompt)                  #assign to temporary variable and validate first
            if input_1 in ["green", "yellow", "red"]:       #only allows green, yellow, red as inputs
                self.light = input_1
            else:                                           
                print(invalid_response)                     #error message thrown if another input given
        elif user_input == "2":
            input_2 = input(change_prompt)
            if input_2 in ["yes", "no"]:                    #only allows yes or no as valid inputs
                self.pedestrian = input_2
            else:                                           
                print(invalid_response)                     #error message thrown if another input given
        elif user_input == "3":
            input_3 = input(change_prompt)
            if input_3 in ["yes", "no"]:                    #only allows yes or no as valid inputs
                self.vehicle = input_3
            else:                                           
                print(invalid_response)                     #error message thrown if another input given
        elif user_input == "0":
            return user_input                               #return to main to allow program to abort
    


# The sensor object should be passed to this function to print the action message and current status
# If no hazards are present, print Proceed when green light or Caution when yellow light
def print_message(Sensor):
        
    #If light is red or any hazards are present, print STOP
    if Sensor.light == "red" or Sensor.pedestrian == "yes" or Sensor.vehicle == "yes":
        print("\nSTOP")
    #If no hazards are present, print Proceed when green light or Caution when yellow light
    elif Sensor.light == "green":
        print("\nProceed")
    elif Sensor.light == "yellow":
        print("\nCaution")



# Complete the main function below
def main():
    print("\n***ENSF 592 Car Vision Detector Processing Program***\n")
    #print instructions and ask for user input
    
    sensor_1 = Sensor()                             #initialize object sensor1 of class Sensor
    check_input = " "                             #initialize variable for checking for end program input

    while check_input != "0":                     #runs program until 0 entered
        check_input = sensor_1.update_status()    #get input from the update.status function
        if check_input == "0":                    #ends program if 0 entered
            break
        elif check_input != "invalid":            #won't print message or environmental states if invalid menu input given
                                                    #to match ExampleRun.pdf
            print_message(sensor_1)                 #call the print_message function

            #prints the current state of environmental inputs: light, pedestrain, vehicle
            print("\nLight = " + sensor_1.light + " , Pedestrian = " + sensor_1.pedestrian + " , Vehicle = " + sensor_1.vehicle + " .\n")

    




# Conventional Python code for running main within a larger program
# No additional code should be included below this
if __name__ == '__main__':
    main()

