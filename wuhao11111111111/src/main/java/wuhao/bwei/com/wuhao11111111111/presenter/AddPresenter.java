package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.AddSBean;
import wuhao.bwei.com.wuhao11111111111.model.AddModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.IAddActivity;

/**
 * Created by alienware on 2018/1/5.
 */

public class AddPresenter {
    IAddActivity iAddActivity;
    AddModel addModel;

    public AddPresenter(IAddActivity iAddActivity) {
        this.iAddActivity = iAddActivity;
        addModel=new AddModel();
    }

    public void getshow(String pid){
        addModel.getadd(pid, new OnNetListine<AddSBean>() {
            @Override
            public void onSucc(AddSBean addSBean) {
                iAddActivity.addshow(addSBean);
            }

            @Override
            public void onFile(String str) {

            }

        });
    }

}
