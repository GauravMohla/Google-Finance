package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gaurav on 12-Mar-17.
 */
public class Stock {

    @SerializedName("t")
    private String ticker;
    @SerializedName("e")
    private String exchange;
    @SerializedName("ltt")
    private String lastTradeTime;
    @SerializedName("l")
    private String price;
    @SerializedName("lt")
    private String lastTradeTimeFormatted;
    @SerializedName("lt_dts")
    private String lastTradeDateTime;
    @SerializedName("c")
    private String change;
    @SerializedName("cp")
    private String changePercentage;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getLastTradeTime() {
        return lastTradeTime;
    }

    public void setLastTradeTime(String lastTradeTime) {
        this.lastTradeTime = lastTradeTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLastTradeTimeFormatted() {
        return lastTradeTimeFormatted;
    }

    public void setLastTradeTimeFormatted(String lastTradeTimeFormatted) {
        this.lastTradeTimeFormatted = lastTradeTimeFormatted;
    }

    public String getLastTradeDateTime() {
        return lastTradeDateTime;
    }

    public void setLastTradeDateTime(String lastTradeDateTime) {
        this.lastTradeDateTime = lastTradeDateTime;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercentage() {
        return changePercentage;
    }

    public void setChangePercentage(String changePercentage) {
        this.changePercentage = changePercentage;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ticker='" + ticker + '\'' +
                ", exchange='" + exchange + '\'' +
                ", lastTradeTime='" + lastTradeTime + '\'' +
                ", price='" + price + '\'' +
                ", lastTradeTimeFormatted='" + lastTradeTimeFormatted + '\'' +
                ", lastTradeDateTime='" + lastTradeDateTime + '\'' +
                ", change='" + change + '\'' +
                ", changePercentage='" + changePercentage + '\'' +
                '}';
    }
}
