package wuhao.bwei.com.wuhao0103lianxi.presenter;

import wuhao.bwei.com.wuhao0103lianxi.bean.UserBean;
import wuhao.bwei.com.wuhao0103lianxi.model.ShowModel;
import wuhao.bwei.com.wuhao0103lianxi.net.OnNerliner;
import wuhao.bwei.com.wuhao0103lianxi.view.IMainActivity;

/**
 * Created by alienware on 2018/1/3.
 */

public class ShowPresenter {
    //p层将m层和v层相连
    private IMainActivity iMainActivity;
    private ShowModel showModel;

    public ShowPresenter(IMainActivity iMainActivity) {
        this.iMainActivity = iMainActivity;
        showModel = new ShowModel();
    }

    public void show(){
        showModel.getshow(new OnNerliner<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                iMainActivity.show(userBean);
            }

            @Override
            public void onFailed(String str) {

            }
        });



    }



}
