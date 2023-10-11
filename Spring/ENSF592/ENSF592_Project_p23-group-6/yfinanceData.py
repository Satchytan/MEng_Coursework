#
######################################### DO NOT RUN #####################################################
############################ Unless if you want to reset the data ################################
import yfinance as yf
import pandas as pd

msft = yf.Ticker("MSFT")
goog = yf.Ticker("GOOG")
meta = yf.Ticker("META")
tsla = yf.Ticker("TSLA")

msft_hist = msft.history(period= "1y")
msft_hist.index = msft_hist.index.strftime('%Y-%m-%d')
msft_holders = msft.get_institutional_holders()

with pd.ExcelWriter("Mircosoft_Data.xlsx") as writer:
    msft_hist.to_excel(writer, sheet_name = "MSFT Data")

with pd.ExcelWriter("MSFT_holders.xlsx") as writer:
    msft_holders.to_excel(writer, sheet_name = "MSFT Holders")

goog_hist = goog.history(period= "1y")
goog_hist.index = goog_hist.index.strftime('%Y-%m-%d')
goog_holders = goog.get_institutional_holders()

with pd.ExcelWriter("Google_Data.xlsx") as writer:
    goog_hist.to_excel(writer, sheet_name = "GOOGLE Data")

with pd.ExcelWriter("GOOG_holders.xlsx") as writer:
    goog_holders.to_excel(writer, sheet_name = "GOOGLE Holders")

meta_hist = meta.history(period= "1y")
meta_hist.index = meta_hist.index.strftime('%Y-%m-%d')
meta_holders = meta.get_institutional_holders()

with pd.ExcelWriter("META_Data.xlsx") as writer:
    meta_hist.to_excel(writer, sheet_name = "META Data")

with pd.ExcelWriter("META_holders.xlsx") as writer:
    meta_holders.to_excel(writer, sheet_name = "META Holders")

tsla_hist = tsla.history(period= "1y")
tsla_hist.index = tsla_hist.index.strftime('%Y-%m-%d')
tsla_holders = tsla.get_institutional_holders()

with pd.ExcelWriter("Tesla_Data.xlsx") as writer:
    tsla_hist.to_excel(writer, sheet_name = "TSLA Data")

with pd.ExcelWriter("TSLA_holders.xlsx") as writer:
    tsla_holders.to_excel(writer, sheet_name = "SP500 Holders")