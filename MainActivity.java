package com.kosovatv.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;
    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        LinearLayout root=new LinearLayout(this); root.setOrientation(LinearLayout.VERTICAL); root.setBackgroundColor(Color.rgb(11,17,32));
        LinearLayout menu=new LinearLayout(this); menu.setOrientation(LinearLayout.HORIZONTAL); menu.setGravity(Gravity.CENTER); menu.setPadding(8,8,8,8);
        String[][] channels={
          {"RTK","https://www.rtklive.com/"},{"Klan Kosova","https://klankosova.tv/"},{"RTV21","https://rtv21.tv/"},{"T7","https://televizioni7.com/"},
          {"Dukagjini","https://www.dukagjini.com/"},{"Top Channel","https://top-channel.tv/"},{"Klan","https://tvklan.al/"},{"Vizion Plus","https://www.vizionplus.tv/"}
        };
        webView=new WebView(this); webView.getSettings().setJavaScriptEnabled(true); webView.getSettings().setDomStorageEnabled(true); webView.getSettings().setMediaPlaybackRequiresUserGesture(false); webView.setWebViewClient(new WebViewClient()); webView.setWebChromeClient(new WebChromeClient());
        for(String[] c:channels){ Button x=new Button(this); x.setText(c[0]); x.setTextColor(Color.WHITE); x.setOnClickListener(v->webView.loadUrl(c[1])); menu.addView(x); }
        root.addView(menu,new LinearLayout.LayoutParams(-1,-2)); root.addView(webView,new LinearLayout.LayoutParams(-1,0,1)); setContentView(root); webView.loadUrl("https://www.rtklive.com/");
    }
    @Override public void onBackPressed(){ if(webView!=null && webView.canGoBack()) webView.goBack(); else super.onBackPressed(); }
}
