package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.LoginBean;
import wuhao.bwei.com.wuhao11111111111.bean.ZhuceBean;
import wuhao.bwei.com.wuhao11111111111.model.LModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.ILogin;

/**
 * Created by alienware on 2018/1/8.
 */

public class LPresenter {

    //实例化m层和v层
    ILogin iLogin;
    LModel lModel;

    public LPresenter(ILogin iLogin) {
        this.iLogin = iLogin;
        lModel = new LModel();
    }

    public void getL(String mobile,String password){
        lModel.Login(mobile, password, new OnNetListine<LoginBean>() {
            @Override
            public void onSucc(LoginBean loginBean) {
                iLogin.getlogin(loginBean);
            }

            @Override
            public void onFile(String str) {

            }
        });

    }

    public void getZ(String mobile,String password){
        lModel.Zhuce(mobile, password, new OnNetListine<ZhuceBean>() {
            @Override
            public void onSucc(ZhuceBean zhuceBean) {
                iLogin.getzhuce(zhuceBean);
            }

            @Override
            public void onFile(String str) {

            }
        });

    }



}
