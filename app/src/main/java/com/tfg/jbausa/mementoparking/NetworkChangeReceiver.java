package com.tfg.jbausa.mementoparking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.webkit.WebView;

public class NetworkChangeReceiver extends BroadcastReceiver {
    /*
     * Variables iniciales
     */
    private WebView myWebView;

    @Override
    public void onReceive(final Context context, final Intent intent) {
        final ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        final android.net.NetworkInfo wifi = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        final android.net.NetworkInfo mobile = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        myWebView  = MainActivity.getMyWebView();

        if (wifi.isConnected() || mobile.isConnected()) {
            Log.d("Netowk Available ", "Flag No 1");
            LoadUrl.load(myWebView, Url.OK_PAGE);
        }
        else{
            Log.d("Netowk Unavailable ", "Flag No 2");
            LoadUrl.load(myWebView, Url.ERROR_PAGE);
        }
    }
}
