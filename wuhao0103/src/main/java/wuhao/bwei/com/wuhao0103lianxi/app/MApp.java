package wuhao.bwei.com.wuhao0103lianxi.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by alienware on 2018/1/3.
 */

public class MApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
