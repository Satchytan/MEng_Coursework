import pandas as pd

def main():

    # Grabbing the data from excel files 
    meta_data = pd.read_excel('META_data.xlsx')
    google_data = pd.read_excel('Google_data.xlsx')
    msft_data = pd.read_excel('Microsoft_data.xlsx')

    


if __name__ == '__main__':
    main()