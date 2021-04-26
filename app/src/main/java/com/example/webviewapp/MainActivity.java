package com.example.webviewapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
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
    private WebView myWebView; // declare an object reference
    //private WebViewClient MyWebviewClient;





    public void showExternalWebPage(){
        myWebView.loadUrl("https://www.youtube.com"); // link to the external page
        Log.d("==>","Will display external web page");

    }

    public void showInternalWebPage(){
        myWebView.loadUrl ("file:///android_asset/Jasons-app.html");// link to the internal page
        Log.d("==>","Will display internal web page");
        // myWebView.setWebViewClient(new callback()); // Handling page navigation


    }
    //private class callback extends WebViewClient { // webview client that ove rides the first kode
    //  public boolean shouldOverridKeyevent(WebView view, KeyEvent event){
    //    return false;
    //}
    //}

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myWebView = findViewById(R.id.my_webview); // Reference to my webview object by id
        WebViewClient  myWebViewClient = new  WebViewClient();
        myWebView.setWebViewClient(myWebViewClient);


        WebSettings webSettings = myWebView.getSettings(); //web settings object.
        webSettings.setJavaScriptEnabled (true); //Enabling JavaScript

        // up until this point the code is sett to
        // default open the URL link in an external web page

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
            showExternalWebPage();
            //return true;
        }

        if (id == R.id.action_internal_web) {
            showInternalWebPage();
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

