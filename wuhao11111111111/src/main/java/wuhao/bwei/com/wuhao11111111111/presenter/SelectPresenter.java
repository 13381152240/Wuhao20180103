package wuhao.bwei.com.wuhao11111111111.presenter;

import java.util.ArrayList;
import java.util.List;

import wuhao.bwei.com.wuhao11111111111.bean.CartBean;
import wuhao.bwei.com.wuhao11111111111.model.SelectModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.ISelectActivity;

/**
 * Created by alienware on 2018/1/6.
 */

public class SelectPresenter {
    //实例化v层和m层
    ISelectActivity iSelectActivity;
    SelectModel selectModel;

    public SelectPresenter(ISelectActivity iSelectActivity) {
        this.iSelectActivity = iSelectActivity;
        selectModel = new SelectModel();
    }

    public void getselects(){
        selectModel.getselect(new OnNetListine<CartBean>() {
            @Override
            public void onSucc(CartBean cartBean) {
                List<CartBean.DataBean> data = cartBean.getData();
                List<List<CartBean.DataBean.ListBean>> childlist = new ArrayList<List<CartBean.DataBean.ListBean>>();
                for(int i = 0; i <data.size();i++){
                    List<CartBean.DataBean.ListBean> list = data.get(i).getList();
                    childlist.add(list);

                }
                iSelectActivity.getselect(data,childlist);


            }

            @Override
            public void onFile(String str) {

            }
        });



    }



}
