package com.GWTSample0.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("GWTSample0Service")
public interface GWTSample0Service extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use GWTSample0Service.App.getInstance() to access static instance of GWTSample0ServiceAsync
     */
    public static class App {
        private static GWTSample0ServiceAsync ourInstance = GWT.create(GWTSample0Service.class);

        public static synchronized GWTSample0ServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
