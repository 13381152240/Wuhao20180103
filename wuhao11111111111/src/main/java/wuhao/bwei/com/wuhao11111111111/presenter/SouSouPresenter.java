package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.SouSuoBean;
import wuhao.bwei.com.wuhao11111111111.model.SouSouModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.ISuoSuoActivity;

/**
 * Created by alienware on 2018/1/4.
 */

public class SouSouPresenter {
    //实例化m层和v层
    private SouSouModel souSouModel;
    private ISuoSuoActivity iSuoSuoActivity;

    public SouSouPresenter(ISuoSuoActivity iSuoSuoActivity) {
        this.iSuoSuoActivity = iSuoSuoActivity;
        souSouModel = new SouSouModel();

    }

    //定义一个方法
    public void getsou(String str){
        souSouModel.getsousou(str, new OnNetListine<SouSuoBean>() {
            @Override
            public void onSucc(SouSuoBean souSuoBean) {
                iSuoSuoActivity.getsousou(souSuoBean);
            }

            @Override
            public void onFile(String str) {

            }
        });

    }




}
