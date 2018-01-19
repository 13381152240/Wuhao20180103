package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.DeleteCartBean;
import wuhao.bwei.com.wuhao11111111111.model.DModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.IDelete;

/**
 * Created by alienware on 2018/1/6.
 */

public class DPrensenter {
    //实例化v层
    IDelete iDelete;
    DModel dModel;

    public DPrensenter(IDelete iDelete) {
        this.iDelete = iDelete;
        dModel = new DModel();
    }

    public void deleteData(String pid){
        dModel.getDelete(pid, new OnNetListine<DeleteCartBean>() {
            @Override
            public void onSucc(DeleteCartBean deleteCartBean) {
                iDelete.Deletecart(deleteCartBean);

            }

            @Override
            public void onFile(String str) {

            }
        });

    }



}
