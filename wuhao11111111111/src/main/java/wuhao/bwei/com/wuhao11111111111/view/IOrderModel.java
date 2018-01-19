package wuhao.bwei.com.wuhao11111111111.view;

import wuhao.bwei.com.wuhao11111111111.bean.OrderBean;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;

/**
 * Created by alienware on 2018/1/18.
 */

public interface IOrderModel {
    public void getOrder(String status, String page, OnNetListine<OrderBean> onNetListener);
}
