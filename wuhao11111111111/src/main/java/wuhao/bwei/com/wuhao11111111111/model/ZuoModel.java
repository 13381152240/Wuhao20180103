package wuhao.bwei.com.wuhao11111111111.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import wuhao.bwei.com.wuhao11111111111.bean.GoodsBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.RetrofitHolder;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZuoModel {
    public void getzuo(String cid, final OnNetListine<GoodsBean> onNetListine){
        RetrofitHolder.getApi().goods(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoodsBean>() {
                    @Override
                    public void accept(GoodsBean goodsBean) throws Exception {
                        onNetListine.onSucc(goodsBean);
                    }
                });

    }



}
