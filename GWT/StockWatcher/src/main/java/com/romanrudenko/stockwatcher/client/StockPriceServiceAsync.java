package com.romanrudenko.stockwatcher.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by roman.rudenko on 30-Dec-15.
 */
public interface StockPriceServiceAsync {

    void getPrices(String[] symbols, AsyncCallback<StockPrice[]> callback);

}
