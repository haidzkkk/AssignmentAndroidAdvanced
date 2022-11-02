package haidtph20645.fpoly.assignmentandroidadvanced.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;

import haidtph20645.fpoly.assignmentandroidadvanced.R;

public class FacebookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        WebView webView = findViewById(R.id.webview_fb);
        webView.loadUrl("https://www.facebook.com");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient()); //click link trong web thì vẫn trong app
    }
}