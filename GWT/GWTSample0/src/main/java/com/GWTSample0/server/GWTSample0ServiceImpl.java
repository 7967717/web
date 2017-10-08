package com.GWTSample0.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.GWTSample0.client.GWTSample0Service;

public class GWTSample0ServiceImpl extends RemoteServiceServlet implements GWTSample0Service {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: Hello, Server! <br>Server answered: Hello " + msg + "!";
    }
}