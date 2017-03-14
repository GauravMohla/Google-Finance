package service;

import model.Stock;

import java.io.IOException;
import java.util.List;

/**
 * Created by Gaurav on 12-Mar-17.
 */
public interface GoogleFinance {
    Stock getStockDetails(String exchange, String ticker) throws IOException;
    List<Stock> getStockDetails(String exchange, String[] tickers) throws IOException;
}
