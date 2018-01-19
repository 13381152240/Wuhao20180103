package wuhao.bwei.com.wuhao0103lianxi.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao0103lianxi.bean.UserBean;
import wuhao.bwei.com.wuhao0103lianxi.net.HttpUtils;
import wuhao.bwei.com.wuhao0103lianxi.net.OnNerliner;

/**
 * Created by alienware on 2018/1/3.
 */

public class ShowModel {

    //m层主要为解析gson
    public void getshow(final OnNerliner<UserBean> onNerliner){
        HttpUtils.getApi().tags()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {

                        onNerliner.onSuccess(userBean);

                    }
                });


    }






}
