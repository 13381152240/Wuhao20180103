package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.XiangQingBean;
import wuhao.bwei.com.wuhao11111111111.model.ZiFenLeiModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.IXiangQing;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZiFenLeiPrenester {
    //实例化p层和view层
    private IXiangQing iXiangQing;
    private ZiFenLeiModel ziFenLeiModel;

    public ZiFenLeiPrenester(IXiangQing iXiangQing) {
        this.iXiangQing = iXiangQing;
        ziFenLeiModel = new ZiFenLeiModel();
    }

    public void zishow(String pscid){
        ziFenLeiModel.getZi(pscid, new OnNetListine<XiangQingBean>() {
            @Override
            public void onSucc(XiangQingBean xiangQingBean) {
                iXiangQing.showzi(xiangQingBean);

            }

            @Override
            public void onFile(String str) {

            }
        });


    }



}
