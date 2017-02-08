package com.investallign.asynctask;

import android.content.Context;
import android.os.AsyncTask;

import com.investallign.configuration.LoggerConstants;
import com.investallign.interfaces.ParseListener;
import com.investallign.managers.network.NetworkManager;
import com.investallign.utils.Logger;
import com.squareup.okhttp.RequestBody;

public class AsyncTaskForNetworkManager extends
        AsyncTask<RequestBody, String, Object> {
    private Context context;
    private NetworkManager networkManager = NetworkManager.getInstance();
    private String url;
    private ParseListener parseListener;
    private RequestBody requestBody;

    public AsyncTaskForNetworkManager(Context context,String url,ParseListener parseListener, RequestBody requestBody) {
        this.context = context;
        this.url = url;
        this.parseListener = parseListener;
        this.requestBody = requestBody;
    }


    @Override
    protected Object doInBackground(RequestBody... params) {
        Object onParse = new Object();
        String jsonString = "";
        try {
            jsonString = networkManager.postData(url, requestBody);
            onParse = parseListener.onParse(jsonString);
        } catch (Exception e) {
            Logger.printLog(LoggerConstants.ASYNCTASK_FOR_NETWORK_MANAGER, e.toString());
        }
        return onParse;
    }

}