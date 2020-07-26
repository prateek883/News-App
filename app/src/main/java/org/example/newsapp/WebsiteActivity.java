package org.example.newsapp;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class WebsiteActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        Intent intent = getIntent();
        if(null != intent){
            String url = intent.getStringExtra("url");
            if(null != url){
                webView = findViewById(R.id.webView);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            getObbDir();
        }else {
            super.onBackPressed();
        }
    }
}
