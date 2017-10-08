package com.GWTSample0.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GWTSample0ServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
