package service;

import com.google.gson.Gson;
import model.Stock;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaurav on 12-Mar-17.
 */
public class GoogleFinanceImpl implements GoogleFinance {
    public Stock getStockDetails(String exchange, String ticker) throws IOException {
        Stock stock = new Stock();
        //Rest call to google finance API
        URL url = new URL("http://finance.google.com/finance/info?client=ig&q="+exchange+"%3A"+ticker);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        StringBuilder stringBuilder = new StringBuilder(readFullyAsString(conn.getInputStream(), "UTF-8"));
        for (int index = 0; index < stringBuilder.length(); index++) {
            if (stringBuilder.charAt(index) == '/' || stringBuilder.charAt(index) == ']' || stringBuilder.charAt(index) == '['){
                stringBuilder.setCharAt(index, ' ');
            }
        }
        String stockJson = stringBuilder.toString();
        Gson gson = new Gson();
        stock = gson.fromJson(stockJson, Stock.class);
        return stock;
    }

    public List<Stock> getStockDetails(String exchange, String[] tickers) throws IOException {
        List<Stock> stocks = new ArrayList<Stock>();
        Stock stock = new Stock();
        //Rest call to google finance API
        for(int i=1;i<tickers.length;i++)
            tickers[0]+=","+tickers[i];
        URL url = new URL("http://finance.google.com/finance/info?client=ig&q="+exchange+"%3A"+tickers[0]);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }
        StringBuilder stringBuilder = new StringBuilder(readFullyAsString(conn.getInputStream(), "UTF-8"));
        for (int index = 0; index < stringBuilder.length(); index++) {
            if (stringBuilder.charAt(index) == '/' || stringBuilder.charAt(index) == ']' || stringBuilder.charAt(index) == '['){
                stringBuilder.setCharAt(index, ' ');
            }
        }
        String string = stringBuilder.toString();
        string = string.replaceAll("\\s","");
        String s[] = string.split("},");
        for (int o=0;o<s.length-1;o++)
        {
            s[o]+="}";  //add the } we removed in the previous step
        }
        Gson gson = new Gson();
        for (String str:s) {
            stock = gson.fromJson(str,Stock.class);
            stocks.add(stock);
        }
        return stocks;
    }

    public String readFullyAsString(InputStream inputStream, String encoding) throws IOException {
        return readFully(inputStream).toString(encoding);
    }

    private ByteArrayOutputStream readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, length);
        }
        return baos;
    }
}
