package edu.wit.mobileapp.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init webview
        WebView webview = (WebView)findViewById(R.id.webView1);
        webview.setWebViewClient(new WebViewClient());

        //enable javascript
        webview.getSettings().setJavaScriptEnabled(true);

        // zoome out of the page to fit the display
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);

        //provide pinch zoom operation
        webview.getSettings().setBuiltInZoomControls(true);

        webview.loadUrl("http://www.wit.edu");


    }
}
