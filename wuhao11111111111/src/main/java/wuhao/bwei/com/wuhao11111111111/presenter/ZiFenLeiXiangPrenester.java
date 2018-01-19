package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.ZiFenLeiXiangBean;
import wuhao.bwei.com.wuhao11111111111.model.ZiFenLeiXiangModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.IZiFenLeiXiang;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZiFenLeiXiangPrenester {
    IZiFenLeiXiang iZiFenLeiXiang;
    ZiFenLeiXiangModel ziFenLeiXiangModel;

    public ZiFenLeiXiangPrenester(IZiFenLeiXiang iZiFenLeiXiang) {
        this.iZiFenLeiXiang = iZiFenLeiXiang;
        ziFenLeiXiangModel=new ZiFenLeiXiangModel();
    }
    public void getShowZiFen(String pid){
        ziFenLeiXiangModel.getFen(pid, new OnNetListine<ZiFenLeiXiangBean>() {
            @Override
            public void onSucc(ZiFenLeiXiangBean ziFenLeiXiangBean) {
                iZiFenLeiXiang.showZiFenLeiXiang(ziFenLeiXiangBean);
            }

            @Override
            public void onFile(String str) {

            }
        });
    }
}
