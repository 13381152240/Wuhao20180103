package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.DeleteCartBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/6.
 */

public class DModel {
    public void getDelete(String pid,final OnNetListine<DeleteCartBean> onNetListine){
        RetrofitHolder.getApi().delete(pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DeleteCartBean>() {
                    @Override
                    public void accept(DeleteCartBean deleteCartBean) throws Exception {
                        onNetListine.onSucc(deleteCartBean);
                    }
                });

        

    }


}
