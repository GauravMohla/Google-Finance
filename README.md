# Google-Finance
Fetching stock Data from Google Finance API. This is just for informational purpose as Google does not actively support finance API now. 

# Usage
There are two functions that you should know.
```java
Stock getStockDetails(String exchange, String ticker) throws IOException;
List<Stock> getStockDetails(String exchange, String[] tickers) throws IOException;
```
The data is to be inserted in data.properties file. You can have a single quote or multiple quotes.
For multiple quotes, use comma separated tickers and use java's ```String.split()``` and pass it to ``` getStockDetails(String exchange, String[] tickers)``` to get a list of stocks.
```java
Properties props = new Properties();
String basePath = MainClass.class.getResource("/").getPath();
InputStream is = new FileInputStream(basePath+"data.properties");
props.load(is);
String exchange = props.getProperty("exchange");
String tickers = props.getProperty("ticker");
```
The above code lines will get you the exchange and ticker data from properties file.

