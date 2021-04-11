
# Rapport Assignment 2: WebView

The purpose of this assignment was to add un web view element inside my app making
it possible to display one external web page and one internal web page.



I made un ID name in the content_main file and name it my_Webview.
I den connected that to my MainActivity file by writing the code line showing down below.
```
myWebView = findViewById(R.id.my_webview);

```

combined with that i allowed my app to have internet access by adding the following code line in my
AndroidManifest file.
```
    <uses-permission android:name="android.permission.INTERNET" />
```



I added a Web setting and enabled the javascript interface that webview uses to create an
interface between the javascript code and the client side code.

```
  WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled (true);
```


I also setup the code need to have one external page and one internal page.
As much as i understood to make an Internal i had to first make a Html file and then combined it by
make a new data typ called WebViewClient
however i couldn't make myWebViewClient to become active. eventually I declare a new  object reference
called  "private WebViewClient MyWebviewClient;" inside the public class and that made it work.

```
WebViewClient  myWebViewClient = new  WebViewClient();
        myWebView.setWebViewClient(MyWebviewClient);
        myWebView.loadUrl ("file:///android_asset/Jasons-app.html");// link to the internal page
```
For external i  just need a myWebView.loadUrl link.
All of this code was first placed inside the OnCreate function.



We were given a kind of template that made it possible to have both an external and Internal link at the same time,
and witch between them using the dropdown menu code given to us as the template.
i first put only the URL code inside the public void showExternalWebPage and showInternalWebPage
function but I couldn't seem to active the function itself.

I tried a couple of different examples and even made a "private class callback extends WebViewClient"
But nothing really worked. I did some more googling and asked a class mate and eventually figured out
that i have to put all the code for both external and internal inside the public void function and then
call that function inside public boolean onOptionsItemSelected using the If statements.



![](external.png)
![](internal.png)

