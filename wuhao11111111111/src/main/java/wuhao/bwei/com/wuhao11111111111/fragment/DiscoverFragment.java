package wuhao.bwei.com.wuhao11111111111.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import wuhao.bwei.com.wuhao11111111111.R;

/**
 * Created by alienware on 2018/1/4.
 */

public class DiscoverFragment extends Fragment{
    private WebView webview1;
    private ProgressBar progressBar1;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fm03, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressBar1 = view.findViewById(R.id.progressBar1);
        webview1 = view.findViewById(R.id.webview1);
        WebSettings settings = webview1.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);

        //加载
        webview1.loadUrl("https://c.m.suning.com/channel/higoubq11.html");
        //WebViewClient主要帮助WebView处理各种通知、请求事件的
        webview1.setWebViewClient(new WebViewClient(){});
        //WebChromeClient主要辅助WebView处理JavaScript的对话框、网站图标、网站title、加载进度等比如
        webview1.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                super.onProgressChanged(view, newProgress);
                //显示
                progressBar1.setVisibility(view.VISIBLE);
                progressBar1.setProgress(newProgress);
                if(newProgress==100){
                    //隐藏
                    progressBar1.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
}
