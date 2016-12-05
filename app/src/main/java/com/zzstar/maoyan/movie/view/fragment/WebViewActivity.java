package com.zzstar.maoyan.movie.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zzstar.maoyan.R;

public class WebViewActivity extends Activity {
    private WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        web_view = (WebView) findViewById(R.id.web_view);

        initData();
    }

    private void initData() {

        String url = getIntent().getStringExtra("url");
        web_view.loadUrl(url);
        web_view.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }
}
