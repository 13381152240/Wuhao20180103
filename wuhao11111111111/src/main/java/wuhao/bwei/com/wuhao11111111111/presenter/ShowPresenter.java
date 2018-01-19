package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.UserBean;
import wuhao.bwei.com.wuhao11111111111.model.ShowModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.ISuccessActivity;

/**
 * Created by alienware on 2018/1/4.
 */

public class ShowPresenter {
    ISuccessActivity iSuccessActivity;
    ShowModel showModel;

    public ShowPresenter(ISuccessActivity iSuccessActivity) {
        this.iSuccessActivity = iSuccessActivity;
        showModel = new ShowModel();
    }
    public void getData(){
        showModel.shuju(new OnNetListine<UserBean>() {
            @Override
            public void onSucc(UserBean userBean) {
                iSuccessActivity.show(userBean);
            }

            @Override
            public void onFile(String str) {

            }
        });



    }




}
