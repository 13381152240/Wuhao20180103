package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.XiangQingBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZiFenLeiModel {
    public void getZi(String pscid, final OnNetListine<XiangQingBean> onNetListine){
        RetrofitHolder.getApi().xiang(pscid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiangQingBean>() {
                    @Override
                    public void accept(XiangQingBean xiangQingBean) throws Exception {
                        onNetListine.onSucc(xiangQingBean);
                    }
                });


    }

}
