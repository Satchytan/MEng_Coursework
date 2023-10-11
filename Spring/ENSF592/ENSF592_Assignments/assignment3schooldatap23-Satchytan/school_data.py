# school_data.py
# Satchytan Karalasingham
#
# A terminal-based application for computing and printing statistics based on given input.
# Detailed specifications are provided via the Assignment 3 git repository.
# You must include the main listed below. You may add your own additional classes, functions, variables, etc. 
# You may import any modules from the standard Python library.
# Remember to include docstrings and comments.


import numpy as np
from given_data import year_2013, year_2014, year_2015, year_2016, year_2017, year_2018, year_2019, year_2020, year_2021, year_2022

#Create a tuple and store raw data within
raw_data = year_2013, year_2014, year_2015, year_2016, year_2017, year_2018, year_2019, year_2020, year_2021, year_2022
# Declare any global variables needed to store the data here


# You may add your own additional classes, functions, variables, etc.


def main():
    """
    Entry point of the program.
    Computes various statistics regarding enrollment in Calgary high schools.
    Asks for user to input school code or name and computes various enrollment statistics specific to the school.
    Also prints some general statistics related to all 20 schools.
    """

    print("ENSF 592 School Enrollment Statistics")
    
    # Print Stage 1 requirements here
    # Create a 3-dimensional array using the provided high school enrollment data. You must use a NumPy array, but you may choose how to arrange the size in each dimension.

    # Reshape the raw data into a 3-dimensional array with dimensions (10, 20, 3).
    # The first dimension represents the 10 years of data from 2013 to 2022(inclusive).
    # The second dimension represents the 20 schools.
    # The third dimension represents the three grades of enrollments (10, 11, 12).
    school_data = np.reshape(raw_data, (10,20,3))

    # Define a dictionary to map school codes to names and to their respective indices in the school_data array.
    schools = {

        "1224": {"name": "Centennial High School", "index": 0},
        "1679": {"name": "Robert Thirsk School", "index": 1},
        "9626": {"name": "Louise Dean School", "index": 2},
        "9806": {"name": "Queen Elizabeth High School", "index": 3},
        "9813": {"name": "Forest Lawn High School", "index": 4},
        "9815": {"name": "Crescent Heights High School", "index": 5},
        "9816": {"name": "Western Canada High School", "index": 6},
        "9823": {"name": "Central Memorial High School", "index": 7},
        "9825": {"name": "James Fowler High School", "index": 8},
        "9826": {"name": "Ernest Manning High School", "index": 9},
        "9829": {"name": "William Aberhart High School", "index": 10},
        "9830": {"name": "National Sport School", "index": 11},
        "9836": {"name": "Henry Wise Wood High School", "index": 12},
        "9847": {"name": "Bowness High School", "index": 13},
        "9850": {"name": "Lord Beaverbrook High School", "index": 14},
        "9856": {"name": "Jack James High School", "index": 15},
        "9857": {"name": "Sir Winston Churchill High School", "index": 16},
        "9858": {"name": "Dr. E. P. Scarlett High School", "index": 17},
        "9860": {"name": "John G Diefenbaker High School", "index": 18},
        "9865": {"name": "Lester B. Pearson High School", "index": 19}
    }

    # Print the shape and dimensions of the array.
    print("Shape of full data array:", school_data.shape)
    print("Dimensions of full data array:", school_data.ndim)

    # Prompt for user input
    
    while True:
        # Prompt the user to enter either the name or numerical code of a school. 
        user_input = input("Please enter the high school name or school code: ")
        # Check if the user input exists in the schools dictionary.        
        try:
            if user_input in schools:
                school_code = user_input
                school = schools[user_input]
                school_name = school["name"]
                school_index = school["index"]
                break
            # Check if the user input matches any school names (case-insensitive).
            elif any(user_input.lower() == school["name"].lower() for school in schools.values()):
                for code, school in schools.items():
                    if user_input.lower() == school["name"].lower():
                        school_name = school["name"]
                        school_code = code
                        school_index = school["index"]
                break
            # If the name or code do not exist within the given data, raise a ValueError to print “You must enter a valid school name or code.”
            else:
                raise ValueError
        except ValueError:
            print("You must enter a valid school name or code.")


    # Print Stage 2 requirements here
    print("\n***Requested School Statistics***\n")

    print("School Name:", school_name, ", School Code:", school_code)
    
    # Extract the enrollment data for the selected school and assign this sub-array to school_array
    # New array is 2-dimensional taking in year and grade respectively
    school_array = school_data[ :, school_index, : ]

    # Compute and print the mean enrollment for each grade.
    grade_10_mean = int(np.nanmean(school_array[:,0]))
    grade_11_mean = int(np.nanmean(school_array[:,1]))
    grade_12_mean = int(np.nanmean(school_array[:,2]))
    print("Mean enrollment for Grade 10:", grade_10_mean)
    print("Mean enrollment for Grade 11:", grade_11_mean)
    print("Mean enrollment for Grade 12:", grade_12_mean)

    # Compute and print the highest and lowest enrollment for a single grade.
    max_enrollment = int(np.nanmax(school_array))
    min_enrollment = int(np.nanmin(school_array))
    print("Highest enrollment for a single grade:", max_enrollment)
    print("Lowest enrollment for a single grade:", min_enrollment)

    # Initialize an empty list which will hold each year's total enrollment data for mean_total_enrollment calculation later
    annual_list = []
    for year in range(10):
        # Compute the total enrollment for each year and print it.
        annual_enrollment = int(np.nansum(school_array[year,:]))
        print("Total enrollment for", 2013+year, ":", annual_enrollment)
        annual_list.append(annual_enrollment)       #append each annual_enrollment to annual_list for mean_total_enrollment calculation

    # Compute and print the total enrollment over 10 years.
    total_enrollment = int(np.nansum(school_array))
    print("Total ten year enrollment:", total_enrollment)

    # Compute and print the mean total enrollment over 10 years. 
    # annual_list created during annual_enrollment computation loop above.
    mean_total_enrollment = int(np.nanmean(annual_list))
    print("Mean total enrollment over 10 years:", mean_total_enrollment)
                           
    # Check if any enrollments over 500 exist for the school. max_enrollment already computed earlier.
    if max_enrollment > 500:
        # Compute the median of enrollments over 500 and print it.
        # Using a masking operation to filter enrollment values greater than 500.
        over_500 = school_array[school_array > 500]
        median_over_500 = int(np.nanmedian(over_500))
        print("For all enrollments over 500, the median value was:", median_over_500)
    else:
        print("No enrollments over 500.")

    # Print Stage 3 requirements here
    print("\n***General Statistics for All Schools***\n")

    # Compute and print the mean enrollment in 2013 and 2022 across all schools.
    mean_2013 = int(np.nanmean(year_2013))
    mean_2022 = int(np.nanmean(year_2022))
    print("Mean enrollment in 2013:", mean_2013)
    print("Mean enrollment in 2022:", mean_2022)

    # Compute and print the total graduating class of 2022 across all schools.
    grad_2022 = int(np.nansum(school_data[9,:,2]))
    print("Total graduating class of 2022:", grad_2022)

    # Compute and print the highest and lowest enrollment for a single grade across all schools.
    max_all = int(np.nanmax(school_data))
    min_all = int(np.nanmin(school_data))
    print("Highest enrollment for a single grade:", max_all)
    print("Lowest enrollment for a single grade:", min_all)

    


if __name__ == '__main__':
    main()

