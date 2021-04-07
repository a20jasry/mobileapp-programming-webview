package com.example.webviewapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private WebView myWebView;
    private WebViewClient myWebViewClient;


    public void showExternalWebPage(){
        myWebView.loadUrl("https://www.youtube.com"); // load the page with:

    }

    public void showInternalWebPage(){
        myWebView.loadUrl("https://www.instagram.com"); // load the page with:


    }

    @SuppressLint("SetJavaScriptEnabled")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView myWebView = new WebView(this); // Adding a WebView in onCreate
        setContentView(myWebView);

        WebSettings webSettings = myWebView.getSettings(); // Enabling JavaScript
        webSettings.setJavaScriptEnabled (true);

        myWebView.setWebViewClient(myWebViewClient); // Handling page navigation

        //------------- Corrected----------------------//
        //WebViewClient myWebViewClient= new WebViewClient();
        //WebView webView= new WebView(this);
        //setContentView(webView);
        //myWebView.setWebViewClient(myWebViewClient);
        //myWebView.loadUrl("DEFAULT_URL/");
        //-----------------Action Button----------------------//
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_external_web) {
            Log.d("==>","Will display external web page");
            return true;
        }

        if (id == R.id.action_internal_web) {
            Log.d("==>","Will display internal web page");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
