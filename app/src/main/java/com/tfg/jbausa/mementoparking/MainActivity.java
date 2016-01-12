package com.tfg.jbausa.mementoparking;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends ActionBarActivity {
    /*
     * Variables iniciales
     */
    private static WebView myWebView;
    private CookieManager cookieManager;
    public static WebView getMyWebView() {
        return myWebView;
    }


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		/*
		 * NetworkChangeReceiver, WebViewClient y WebViewChromeClient
		 */
        myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                LoadUrl.load(myWebView, Url.ERROR_PAGE);
            }
        });
        myWebView.setWebChromeClient(new WebChromeClient());

		/*
		 * CookieManager y comprobar version Android
		 */
        cookieManager = CookieManager.getInstance();
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                cookieManager.setAcceptThirdPartyCookies(myWebView, true);
            }
        }
        catch(Exception e){
            Log.e("Exception", e.toString());
        }

		/*
		 * Comprobar conexi�n red inicial
		 */

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected() || connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected()){
            LoadUrl.load(myWebView, Url.OK_PAGE);
        }
        else{
            LoadUrl.load(myWebView, Url.ERROR_PAGE);
        }
    }


}