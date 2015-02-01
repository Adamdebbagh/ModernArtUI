package modernartuiapp.labs.course.modernartui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MoMaPage extends ActionBarActivity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moma);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));

        //Initialiaze webview Object
        myWebView = (WebView) findViewById(R.id.webview);


        //load MoMa web page in the WebView
        myWebView.loadUrl("http://www.moma.org/collection/object.php?object_id=65715");

        //enable Javascript
        myWebView.getSettings().setJavaScriptEnabled(true);

        //Handle Page Navigation
        myWebView.setWebViewClient(new WebViewClient());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }

}
