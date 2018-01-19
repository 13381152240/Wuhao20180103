package wuhao.bwei.com.wuhao11111111111.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.mob.MobSDK;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by alienware on 2018/1/4.
 */

public class MApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
        Fresco.initialize(this);
        MobSDK.init(this,"23a7286818901","04bf56f24f66acca1cc6d31393cb606a");
    }
}
