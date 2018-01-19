package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.SouSuoBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/4.
 */

public class SouSouModel {
    public void getsousou(String keywords, final OnNetListine<SouSuoBean> onNetListine){
        RetrofitHolder.getApi().sou(keywords,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SouSuoBean>() {
                    @Override
                    public void accept(SouSuoBean souSuoBean) throws Exception {
                        onNetListine.onSucc(souSuoBean);
                    }
                });


    }



}
