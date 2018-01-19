package wuhao.bwei.com.wuhao11111111111.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import wuhao.bwei.com.wuhao11111111111.R;

public class WebActivity extends AppCompatActivity {
    private WebView mWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        String  mpath= getIntent().getStringExtra("path");
        mWeb =(WebView) findViewById(R.id.mwebview);
        if(mpath!=null){
            mWeb.loadUrl(mpath);
        }


    }
}
