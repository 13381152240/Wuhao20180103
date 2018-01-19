package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.LunBoBean;
import wuhao.bwei.com.wuhao11111111111.model.LunBoModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.IlunBo;

/**
 * Created by alienware on 2018/1/4.
 */

public class LunBoPresenter {
    IlunBo ilunBo;
    LunBoModel lunBoModel;

    public LunBoPresenter(IlunBo ilunBo) {
        this.ilunBo = ilunBo;
        lunBoModel = new LunBoModel();
    }

    public void getShowLunNo(){
        lunBoModel.getlunbo(new OnNetListine<LunBoBean>(){


            @Override
            public void onSucc(LunBoBean lunBoBean) {
                ilunBo.showLunBo(lunBoBean);
            }

            @Override
            public void onFile(String str) {

            }
        });



    }


}
