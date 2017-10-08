package com.romanrudenko.stockwatcher.client;

import java.io.Serializable;

/**
 * Created by roman.rudenko on 30-Dec-15.
 */
public class DelistedException extends Exception implements Serializable {

    private String symbol;

    public DelistedException() {
    }

    public DelistedException(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
