package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.ZiFenLeiXiangBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZiFenLeiXiangModel {
    public void getFen(String pid, final OnNetListine<ZiFenLeiXiangBean> onNetListine){
        RetrofitHolder.getApi().ZiFenLeiXiang(pid,"android")//传入公共参数
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZiFenLeiXiangBean>() {
                    @Override
                    public void accept(ZiFenLeiXiangBean ziFenLeiXiangBean) throws Exception {
                        onNetListine.onSucc(ziFenLeiXiangBean);
                    }
                });
    }
}
