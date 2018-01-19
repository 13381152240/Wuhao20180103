package wuhao.bwei.com.wuhao11111111111.presenter;

import java.util.ArrayList;
import java.util.List;

import wuhao.bwei.com.wuhao11111111111.bean.GoodsBean;
import wuhao.bwei.com.wuhao11111111111.model.ZuoModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.IClassActivity;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZuoPresenter {
    IClassActivity iClassActivity;
    ZuoModel zuoModel;

    public ZuoPresenter(IClassActivity iClassActivity) {
        this.iClassActivity = iClassActivity;
        zuoModel = new ZuoModel();
    }

    public void getzuoshow(String cid){
        zuoModel.getzuo(cid, new OnNetListine<GoodsBean>() {
            @Override
            public void onSucc(GoodsBean goodsBean) {
                List<GoodsBean.DataBean> data = goodsBean.getData();
                List<List<GoodsBean.DataBean.ListBean>> list = new ArrayList<List<GoodsBean.DataBean.ListBean>>();

                for(int i = 0;i<data.size();i++){
                    List<GoodsBean.DataBean.ListBean> list1 = data.get(i).getList();
                    list.add(list1);
                }

                iClassActivity.showZuo(data,list);

            }

            @Override
            public void onFile(String str) {

            }
        });




    }



}
