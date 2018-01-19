package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.LoginBean;
import wuhao.bwei.com.wuhao11111111111.bean.ZhuceBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/8.
 */

public class LModel {
    public void Login(String mobile, String password, final OnNetListine<LoginBean> onNetListine){
        RetrofitHolder.getApi().login(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        onNetListine.onSucc(loginBean);
                    }
                });

    }

    public void Zhuce(String mobilem, String password, final OnNetListine<ZhuceBean> onNetListine){
        RetrofitHolder.getApi().zhuce(mobilem,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhuceBean>() {
                    @Override
                    public void accept(ZhuceBean zhuceBean) throws Exception {
                        onNetListine.onSucc(zhuceBean);
                    }
                });


    }





}
