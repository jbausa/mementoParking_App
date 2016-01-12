package com.tfg.jbausa.mementoparking;

import android.webkit.WebView;

/**
 * Created by juan on 12/01/16.
 */
public class LoadUrl {
    public LoadUrl() { super(); }
    public static void load(WebView myWebView, Url url){
        if(url.equals(Url.OK_PAGE)){
            myWebView.loadUrl("http://mementoparking.herokuapp.com/");
        }
        if(url.equals(Url.ERROR_PAGE)){
            myWebView.loadUrl("file:///android_asset/Error.html");
        }
    }
}


