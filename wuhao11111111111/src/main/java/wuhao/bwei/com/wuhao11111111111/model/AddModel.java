package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.AddSBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/5.
 */

public class AddModel {
    public void getadd(String pid, final OnNetListine<AddSBean> onNetListine){
        RetrofitHolder.getApi().adds(pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddSBean>() {
                    @Override
                    public void accept(AddSBean addSBean) throws Exception {
                        onNetListine.onSucc(addSBean);
                    }
                });
    }
}
