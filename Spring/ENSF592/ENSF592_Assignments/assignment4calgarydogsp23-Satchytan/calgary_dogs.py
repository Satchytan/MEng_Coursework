# calgary_dogs.py
# Satchytan Karalasingham
#
'''
A terminal-based application for computing and printing statistics based on given input.
Detailed specifications are provided via the Assignment 4 git repository.
You must include the main listed below. You may add your own additional classes, functions, variables, etc. 
You may import any modules from the standard Python library.
Remember to include docstrings and comments.
'''

def main():

    import pandas as pd

    # Stage 1: DataFrame Creation
    # Import the provided data into a Pandas DataFrame. 
    df = pd.read_excel('CalgaryDogBreeds.xlsx')
    df.set_index(['Year', 'Breed'], inplace=True)               #MultiIndex Object

    print("ENSF 592 Dogs of Calgary")

    # Stage 2: User Input
    # Prompt the user to enter a dog breed.
    while True:
        breed = input("Please enter a dog breed: ")
        breed = breed.upper()  # Convert input to uppercase to match data in xlsx file
        
        try:
            breed_data = df.loc[pd.IndexSlice[:, breed], :]     #Index Slice Object
            if breed in df.index.get_level_values("Breed"):
                break
            else: raise KeyError                                #If the name does not exist within the given data, raise a KeyError
        except KeyError:
            print("Dog breed not found in the data. Please try again.")

    # Stage 3: Data Anaylsis
    years = breed_data.index.get_level_values('Year').unique()
    total_registrations = breed_data['Total'].sum()
    total_percentage = (total_registrations / df['Total'].sum()) * 100
    # Find and print all years where the selected breed was listed in the top breeds
    print(f"The {breed} was found in the top breeds for years:", ' '.join(map(str, years)))
    # Calculate and print the total number of registrations of the selected breed found in the dataset
    print("There have been", total_registrations, breed, "dogs registered total.")

    # Calculate and print the percentage of selected breed registrations out of the total percentage for each year (2021, 2022, 2023)
    for year in [2021, 2022, 2023]:
        if year in years:
            year_data = breed_data.xs(year, level='Year')
            year_percentage = (year_data['Total'].sum() / df.xs(year, level='Year')['Total'].sum()) * 100
            print(f"The {breed} was {year_percentage:.6f}% of top breeds in {year}.")
        else:
            print(f"The {breed} was 0.0% of the top breeds in {year}.")

    # Calculate and print the percentage of selected breed registrations out of the total three-year percentage.
    print(f"The {breed} was {total_percentage:.6f}% of top breeds across all years.")

    # Find and print the months that were most popular for the selected breed registrations. Print all months that tie.
    months_data = breed_data.groupby('Month')['Total'].count()      # grouping operation
    max_months = months_data.max()
    popular_months = months_data[months_data == max_months].index.to_list()

    print(f"Most popular month for {breed} dogs: {' '.join(popular_months)}\n")


if __name__ == '__main__':
    main()
