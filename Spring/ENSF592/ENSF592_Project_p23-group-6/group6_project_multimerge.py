# group6_project.py
# Satchytan Karalasingham, Romil Dhagat
#
'''
A terminal-based application for computing and printing statistics based on given input.
You must include the main listed below. You may add your own additional classes, functions, variables, etc. 
You may import any modules from the standard Python library.
Remember to include docstrings and comments.
'''

import pandas as pd
import matplotlib.pyplot as plt

def merge_data(data_dict, ticker1, ticker2):
    """
    Merge the data for the given tickers.

    Args:
        data_dict (dict): A dictionary containing the data for each stock.
        ticker1 (str): The ticker symbol of the first stock.
        ticker2 (str): The ticker symbol of the second stock.

    Returns:
        pandas.DataFrame: The merged DataFrame of the two stocks' data.
        
    Raises:
        KeyError: If the provided ticker symbols are invalid or do not exist in the data_dict.
    """

    #use the dictionary in main to get the appropriate file
    data1 = data_dict.get(ticker1)
    data2 = data_dict.get(ticker2)
    df_goog = pd.read_excel('Google_Data.xlsx')
    df_meta = pd.read_excel('META_Data.xlsx')
    df_msft = pd.read_excel('Microsoft_data.xlsx')
    df_tsla = pd.read_excel('Tesla_Data.xlsx')

    try:
        if data1 is not None and data2 is not None:
            # Merge the four DataFrames based on a common column
            merged_df = pd.merge(df_goog, df_meta, on='Date')
            merged_df = pd.merge(merged_df, df_msft, on='Date')
            merged_df = pd.merge(merged_df, df_tsla, on='Date')
            #merged_df = pd.merge(data1, data2, on='Date')
            merged_df = merged_df.loc[:, ~merged_df.columns.duplicated()] 
            merged_df.set_index(['Date'], inplace=True) 
            merged_df.sort_index(inplace=True)
            filtered_df = merged_df.loc[(slice(None), [ticker1, ticker2]), :]

            return filtered_df
        else:
            raise KeyError('Invalid ticker combination.')
    except KeyError:
        raise KeyError('Please try again.')

def display_data(merged_df):
    """
    Display the merged data and aggregate statistics.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
    """
    print("\nFiltered Data:")
    print(merged_df)
    print("\nAggregate Statistics:")
    print(merged_df.describe())

def calculate_returns(merged_df):
    """
    Calculate the daily returns and volume in millions.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
    """
    merged_df['Daily Return_x'] = merged_df['Close_x'] - merged_df['Open_x']
    merged_df['Daily Return_y'] = merged_df['Close_y'] - merged_df['Open_y']
    merged_df['Volume in Millions'] = merged_df['Volume_x'] / 1000000
    print(merged_df['Daily Return_x'])

def filter_high_volume(merged_df):
    """
    Filter the data based on high volume.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
    """
    high_volume_df = merged_df[merged_df['Volume_x'] > 50000000] #masking operation
    print("\nData with Volume > 50,000,000:")
    print(high_volume_df)

def group_data(merged_df):
    """
    Group the data by date and calculate the mean values per stock.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
    """
    grouped_df = merged_df.groupby('Date').mean()   #groupby operation
    print("\nGrouped Data (Mean values per stock):")
    print(grouped_df)

def create_pivot_table(merged_df):
    """
    Create a pivot table based on the close prices.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
    """
    pivot_table = pd.pivot_table(merged_df, values='Close_x', index='Date')
    print("\nPivot Table:")
    print(pivot_table)

def export_data(merged_df):
    """
    Export the merged DataFrame to an Excel file.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
    """
    merged_df.to_excel('merged_data.xlsx')

def create_plot(merged_df, ticker1, ticker2):
    """
    Create a plot showing the stock prices.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
        ticker1 (str): The ticker symbol of the first stock.
        ticker2 (str): The ticker symbol of the second stock.
    """
    plt.figure(figsize=(10, 6))
    plt.plot(merged_df.index, merged_df['Close_x'], label=ticker1)
    plt.plot(merged_df.index, merged_df['Close_y'], label=ticker2)
    plt.title('Stock Prices')
    plt.xlabel('Date')
    plt.ylabel('Close Price')
    plt.legend()
    plt.savefig('stock_prices.png')
    plt.show()

def main():
    """
    Main function to run the program.
    """
    print("ENSF 592 Group 6 Project")

    df_goog = pd.read_excel('Google_Data.xlsx')
    df_meta = pd.read_excel('META_Data.xlsx')
    df_msft = pd.read_excel('Microsoft_data.xlsx')
    df_tsla = pd.read_excel('Tesla_Data.xlsx')

    data_dict = {
        'GOOG': df_goog,
        'META': df_meta,
        'MSFT': df_msft,
        'TSLA': df_tsla
    }

    while True:
        print("There are four stocks to compare: GOOG, MSFT, TSLA, META")
        #get ticker inputs from user
        ticker1 = input("Please enter a stock ticker: ").upper()
        ticker2 = input("Please enter another stock ticker: ").upper()

        try:
            #merge data based on ticker inputs from user
            merged_df = merge_data(data_dict, ticker1, ticker2)
            #display merged data
            display_data(merged_df)
            #calculate the returns
            calculate_returns(merged_df)
            #filter high volume data
            filter_high_volume(merged_df)
            group_data(merged_df)
            #create pivot
            create_pivot_table(merged_df)
            export_data(merged_df)
            #create matplotlib plots
            create_plot(merged_df, ticker1, ticker2)
            break
        except KeyError as e:
            print("Invalid stock ticker combination. Please try again.\n")
            continue

    print("\nProgram finished.")

if __name__ == '__main__':
    main()


