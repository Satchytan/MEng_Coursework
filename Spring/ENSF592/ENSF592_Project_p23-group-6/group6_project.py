# group6_project.py
# Satchytan Karalasingham, Romil Dhagat
#
'''
A terminal-based application for computing and printing statistics based on given input.
You must include the main listed below. You may add your own additional classes, functions, variables, etc. 
You may import any modules from the standard Python library.
Remember to include docstrings and comments.
'''
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

def merge_data(ticker1, ticker2, fully_merged_df):
    """
    Merge the data for the given tickers.

    Args:
    ticker1 (str): The ticker symbol of the first stock.
    ticker2 (str): The ticker symbol of the second stock.
    fully_merged_df (pandas.DataFrame): The fully merged DataFrame containing data for all stocks.

    Returns:
        pandas.DataFrame: The merged DataFrame of the two stocks' data.

    Raises:
        KeyError: If the provided ticker symbols are invalid or do not exist in the fully_merged_df.
"""

    #use the dictionary in main to get the appropriate file
    grouped_df = fully_merged_df.groupby('Ticker')
    first_df = grouped_df.get_group(ticker1.upper())
    second_df = grouped_df.get_group(ticker2.upper())

    try:
        if first_df is not None and second_df is not None:
            merged_df = pd.merge(first_df,second_df, how = 'outer')
            merged_df = merged_df.loc[:, ~merged_df.columns.duplicated()] 
            merged_df.set_index(['Date'], inplace=True) 
            merged_df.sort_index(inplace=True)
            return merged_df
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

def high_volume(merged_df):
    """
    Filter the data based on high volume.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
    """
    print("\nTrading Days with Volume greater than 50,000,000:")
    high_volume_df = merged_df[(merged_df['Volume'] > 50000000)] #masking operation
    columns = ['Ticker','Volume', 'Open', 'Close']
    high_volume_df = high_volume_df[columns]
    print(high_volume_df)

def create_pivot_table(fully_merged_df,df_goog, df_msft, df_meta, df_tsla):
    """
    Create a pivot table based on the close prices.

    Args:
        fully_merged_df (pandas.DataFrame): The fully merged DataFrame containing data for all stocks.
        df_goog (pandas.DataFrame): DataFrame for Google stock.
        df_msft (pandas.DataFrame): DataFrame for Microsoft stock.
        df_meta (pandas.DataFrame): DataFrame for Meta stock.
        df_tsla (pandas.DataFrame): DataFrame for Tesla stock.
    """
    # Calculate the average daily return per quarter
    full_pivot_table = pd.pivot_table(fully_merged_df, values='Daily Return', index='Quarter', aggfunc=np.mean)
    goog_pivot_table = pd.pivot_table(df_goog, values='Daily Return', index='Quarter', aggfunc=np.mean)
    msft_pivot_table = pd.pivot_table(df_msft, values='Daily Return', index='Quarter', aggfunc=np.mean)
    meta_pivot_table = pd.pivot_table(df_meta, values='Daily Return', index='Quarter', aggfunc=np.mean)
    tsla_pivot_table = pd.pivot_table(df_tsla, values='Daily Return', index='Quarter', aggfunc=np.mean)

    pivot = pd.merge(full_pivot_table, goog_pivot_table, on = 'Quarter', suffixes = ("full","goog"))
    pivot = pd.merge(pivot, msft_pivot_table, on = 'Quarter', suffixes = ("goog","msft"))
    pivot = pd.merge(pivot, meta_pivot_table, on = 'Quarter', suffixes = ("msft","meta"))
    pivot = pd.merge(pivot, tsla_pivot_table, on = 'Quarter', suffixes = ("meta","tsla"))

    pivot.rename(columns= {
        'Daily Returnfull': 'Large CAP Growth',
        'Daily Returngoog': 'Google',
        'Daily Returnmsft': 'Microsoft',
        'Daily Returnmeta': 'Meta',
        'Daily Return': 'Tesla'
    }, inplace=True)

    print("\nPivot Table - Average Daily Return per Quarter:")
    print(pivot)

def create_close_plot(merged_df, ticker1, ticker2):
    """
    Create a plot showing the stock prices.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
        ticker1 (str): The ticker symbol of the first stock.
        ticker2 (str): The ticker symbol of the second stock.
    """
    grouped_df = merged_df.groupby('Ticker')
    first_df = grouped_df.get_group(ticker1.upper())
    second_df = grouped_df.get_group(ticker2.upper())

    plt.figure(figsize=(10, 6))
    plt.plot(first_df.index, first_df['Close'], label=ticker1)
    plt.plot(second_df.index, second_df['Close'], label=ticker2)
    plt.title('Stock Prices')
    plt.xlabel('Date')
    plt.ylabel('Close Price')
    plt.legend()

    # Reduce the number of x-axis labels
    xticks = np.arange(0, len(first_df.index), 10)  # Set the tick positions at every 10th index
    xtick_labels = first_df.index[xticks]  # Get the corresponding dates for the tick positions
    plt.xticks(xticks, xtick_labels, rotation=45)  # Set the x-axis tick positions and labels with rotation

    plt.savefig('stock_prices.png')
    plt.show()

def create_daily_plot(merged_df, ticker1, ticker2):
    """
    Create a plot showing the daily returns.

    Args:
        merged_df (pandas.DataFrame): The merged DataFrame of the two stocks' data.
        ticker1 (str): The ticker symbol of the first stock.
        ticker2 (str): The ticker symbol of the second stock.
    """
    grouped_df = merged_df.groupby('Ticker')
    first_df = grouped_df.get_group(ticker1.upper())
    second_df = grouped_df.get_group(ticker2.upper())

    plt.figure(figsize=(10, 6))
    plt.plot(first_df.index, first_df['Daily Return'], label=ticker1)
    plt.plot(second_df.index, second_df['Daily Return'], label=ticker2)
    plt.title('Daily Returns')
    plt.xlabel('Date')
    plt.ylabel('Daily Returns')
    plt.legend()

    # Reduce the number of x-axis labels
    xticks = np.arange(0, len(first_df.index), 10)  # Set the tick positions at every 10th index
    xtick_labels = first_df.index[xticks]  # Get the corresponding dates for the tick positions
    plt.xticks(xticks, xtick_labels, rotation=45)  # Set the x-axis tick positions and labels with rotation

    plt.savefig('daily_return.png')
    plt.show()

def main():
    """
    Main function to run the program.
    """
    print("ENSF 592 Group 6 Project")

    # Read data from Excel files into pandas DataFrames
    df_goog = pd.read_excel('Google_Data.xlsx')
    df_meta = pd.read_excel('META_Data.xlsx')
    df_msft = pd.read_excel('Microsoft_data.xlsx')
    df_tsla = pd.read_excel('Tesla_Data.xlsx')

    # Add a 'Ticker' column to identify the stock
    df_goog["Ticker"] = "GOOG"
    df_msft["Ticker"] = "MSFT"
    df_tsla["Ticker"] = "TSLA"
    df_meta["Ticker"] = "META"

    # Add an 'Idx' column as a unique identifier for each row
    df_goog["Idx"] = range(1, len(df_goog) + 1)
    df_msft["Idx"] = range(1, len(df_msft) + 1)
    df_tsla["Idx"] = range(1, len(df_tsla) + 1)
    df_meta["Idx"] = range(1, len(df_meta) + 1)

    # Convert 'Dividends' column to float type to avoid mismatch warning message
    df_goog["Dividends"] = df_goog["Dividends"].astype(float)
    df_msft["Dividends"] = df_msft["Dividends"].astype(float)
    df_tsla["Dividends"] = df_tsla["Dividends"].astype(float)
    df_meta["Dividends"] = df_meta["Dividends"].astype(float)

    # Calculate the daily return as the difference between 'Close' and 'Open' prices
    df_goog['Daily Return'] = df_goog['Close'] - df_goog['Open']
    df_msft['Daily Return'] = df_msft['Close'] - df_msft['Open']
    df_meta['Daily Return'] = df_meta['Close'] - df_meta['Open']
    df_tsla['Daily Return'] = df_tsla['Close'] - df_tsla['Open']

    # Convert 'Volume' column to millions
    df_goog['Volume in Millions'] = df_goog['Volume'] / 1000000
    df_msft['Volume in Millions'] = df_msft['Volume'] / 1000000
    df_meta['Volume in Millions'] = df_meta['Volume'] / 1000000
    df_tsla['Volume in Millions'] = df_tsla['Volume'] / 1000000

    # Add a 'Quarter' column and assign the corresponding quarter label based on the date
    df_goog['Quarter'] = np.nan
    df_msft['Quarter'] = np.nan
    df_meta['Quarter'] = np.nan
    df_tsla['Quarter'] = np.nan

    df_goog.loc[df_goog['Date'].between('2022-07-01', '2022-10-01'), 'Quarter'] = 'Q3'
    df_goog.loc[df_goog['Date'].between('2022-10-01', '2023-01-01'), 'Quarter'] = 'Q4'
    df_goog.loc[df_goog['Date'].between('2023-01-01', '2023-04-01'), 'Quarter'] = 'Q1'
    df_goog.loc[df_goog['Date'].between('2023-04-01', '2023-07-01'), 'Quarter'] = 'Q2'

    df_msft.loc[df_msft['Date'].between('2022-07-01', '2022-10-01'), 'Quarter'] = 'Q3'
    df_msft.loc[df_msft['Date'].between('2022-10-01', '2023-01-01'), 'Quarter'] = 'Q4'
    df_msft.loc[df_msft['Date'].between('2023-01-01', '2023-04-01'), 'Quarter'] = 'Q1'
    df_msft.loc[df_msft['Date'].between('2023-04-01', '2023-07-01'), 'Quarter'] = 'Q2'

    df_meta.loc[df_meta['Date'].between('2022-07-01', '2022-10-01'), 'Quarter'] = 'Q3'
    df_meta.loc[df_meta['Date'].between('2022-10-01', '2023-01-01'), 'Quarter'] = 'Q4'
    df_meta.loc[df_meta['Date'].between('2023-01-01', '2023-04-01'), 'Quarter'] = 'Q1'
    df_meta.loc[df_meta['Date'].between('2023-04-01', '2023-07-01'), 'Quarter'] = 'Q2'

    df_tsla.loc[df_tsla['Date'].between('2022-07-01', '2022-10-01'), 'Quarter'] = 'Q3'
    df_tsla.loc[df_tsla['Date'].between('2022-10-01', '2023-01-01'), 'Quarter'] = 'Q4'
    df_tsla.loc[df_tsla['Date'].between('2023-01-01', '2023-04-01'), 'Quarter'] = 'Q1'
    df_tsla.loc[df_tsla['Date'].between('2023-04-01', '2023-07-01'), 'Quarter'] = 'Q2'

    # Select only the relevant columns for each stock
    relevant_columns = ['Idx','Ticker' , 'Date', 'Open', 'High', 'Low', 'Close', 'Volume', 'Volume in Millions','Dividends','Stock Splits', 'Daily Return', 'Quarter']
    df_msft = df_msft[relevant_columns]
    df_goog = df_goog[relevant_columns]
    df_tsla = df_tsla[relevant_columns]
    df_meta = df_meta[relevant_columns]

    # Merge all the DataFrames into a single DataFrame
    fully_merged_df = pd.merge(df_goog, df_msft, how = 'outer')
    fully_merged_df = pd.merge(fully_merged_df, df_tsla, how = 'outer')
    fully_merged_df = pd.merge(fully_merged_df, df_meta, how = 'outer')

    # Remove any duplicated columns resulting from the merge
    fully_merged_df = fully_merged_df.loc[:, ~fully_merged_df.columns.duplicated()] 
    # Create a hierarchical index using two levels (row or column)
    fully_merged_df.set_index(['Idx'], inplace=True) 
    # Sort the data based on the index
    fully_merged_df.sort_index(inplace=True)

    while True:
        print("There are four stocks to compare: GOOG, MSFT, TSLA, META")
        #get ticker inputs from user
        ticker1 = input("Please enter a stock ticker: ").upper()
        ticker2 = input("Please enter another stock ticker: ").upper()

        try:
            # Merge data based on ticker inputs from user
            merged_df = merge_data(ticker1, ticker2, fully_merged_df)
            # Display merged data
            display_data(merged_df)
            # Filter high volume data
            high_volume(merged_df)
            # Create a pivot table
            create_pivot_table(fully_merged_df,df_goog, df_msft, df_meta, df_tsla)
            # Export data to Excel
            merged_df.to_excel('merged_data.xlsx')
            # Create matplotlib plots
            create_close_plot(merged_df, ticker1, ticker2)
            create_daily_plot(merged_df, ticker1, ticker2)
            break
        except KeyError:
            print("Invalid stock ticker combination. Please try again.\n")
            continue

    print("\nProgram finished.")

if __name__ == '__main__':
    main()
            