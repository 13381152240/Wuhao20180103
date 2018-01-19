package wuhao.bwei.com.wuhao11111111111.presenter;

import wuhao.bwei.com.wuhao11111111111.bean.OrderBean;
import wuhao.bwei.com.wuhao11111111111.model.OrderModel;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.view.ISecondActivity;

/**
 * Created by alienware on 2018/1/18.
 */

public class OrderPresenter {
    private ISecondActivity iSecondActivity;
    private final OrderModel orderModel;

    public OrderPresenter(ISecondActivity iSecondActivity) {
        this.iSecondActivity = iSecondActivity;
        orderModel = new OrderModel();
    }

    public void getOrder(final boolean isRefresh, String status, String page){
        orderModel.getOrder(status, page, new OnNetListine<OrderBean>() {
            @Override
            public void onSucc(OrderBean orderBean) {
                iSecondActivity.showData(isRefresh,orderBean.getData());
            }

            @Override
            public void onFile(String str) {

            }
        });

    }
}