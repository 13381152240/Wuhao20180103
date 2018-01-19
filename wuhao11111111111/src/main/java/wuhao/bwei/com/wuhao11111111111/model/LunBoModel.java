package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.LunBoBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/4.
 */

public class LunBoModel {
    public void getlunbo(final OnNetListine<LunBoBean> onNetListine){
        RetrofitHolder.getApi().lunbo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LunBoBean>() {
                    @Override
                    public void accept(LunBoBean lunBoBean) throws Exception {
                        onNetListine.onSucc(lunBoBean);

                    }
                });



    }


}
