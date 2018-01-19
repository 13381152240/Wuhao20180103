package wuhao.bwei.com.wuhao11111111111.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import wuhao.bwei.com.wuhao11111111111.bean.OrderBean;
import wuhao.bwei.com.wuhao11111111111.net.HttpUtils;
import wuhao.bwei.com.wuhao11111111111.newWork.OnNetListine;
import wuhao.bwei.com.wuhao11111111111.newWork.UrlUtils;
import wuhao.bwei.com.wuhao11111111111.view.IOrderModel;

/**
 * Created by alienware on 2018/1/18.
 */

public class OrderModel implements IOrderModel{
    private Handler handler = new Handler(Looper.getMainLooper());
    @Override
    public void getOrder(String status, String page, final OnNetListine<OrderBean> onNetListener) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid","71");
        map.put("status",status);
        map.put("page",page);
        HttpUtils.getHttpUtils().doPost(UrlUtils.getOrders, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final OrderBean orderBean = new Gson().fromJson(string, OrderBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSucc(orderBean);
                    }
                });

            }
        });



    }
}
