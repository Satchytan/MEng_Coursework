# Some documentation is included as an example (in Google Style). The documentation is not complete!
# All methods should have their own docstrings unless otherwise specified (i.e. __init__ and  properties)
# The specifics of other formats may vary- you may choose whichever format you prefer as long as you are consistent.

class Horse:
    """A class used to create Horse object.

        Attributes:
            age (int): Integer that represents the horse's age
            colour (str): String that represents the horse's colour
            breed (str): String that represents the horse's breed
            ***Note that self is implicit and is not included!

    """

    sci_name = "Equus caballus"
    """sci_name (str): Class variable with default string value of "Equus caballus"
    """

    def __init__(self, age, colour, breed):
        ### __init__ methods don't need docstrings- their information is covered in the class docstring above.

        self.__age = age  # private variable
        self.__colour = colour # private variable
        self.breed = breed # public variable


    def set_age(self, age):
        print("Happy birthday!")
        self.__age = age

    def get_age(self):
        return self.__age


    @property #decorator
    def colour(self):
        return self.__colour

    @colour.setter
    def colour(self, new_val):
        self.__colour = new_val

    @colour.getter
    def colour(self):
        """str: Colour of the horse is stored as a property.
        
            ***Properties are usually only documented in their getter method. 

        Returns:
            colour (str): String that represents the horse's colour
        """
        return self.__colour


    def print_all_stats(self):
        print("""{0} stats: Age = {1}, Colour = {2}, Breed = {3}.""".format(self.sci_name, self.age, self.colour, self.breed))


class Rider:
    
    def __init__(self, age, horse):
        self.age = age
        self.horse = horse

    def print_all_stats(self):
        print("""Rider stats: Age = {0}, Horse Age = {1}, Horse Colour = {2}, Horse Breed = {3}."""
        .format(str(self.age), str(self.horse.get_age()), self.horse.colour, self.horse.breed))        


def main():
    print("Welcome to my program!")

    horse_blaze = Horse(14, "grey", "Arabian")
    rider_alex = Rider(30, horse_blaze)
    
    rider_alex.print_all_stats()


if __name__ == '__main__':  # optional in Python 3
    main()

