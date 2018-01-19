package wuhao.bwei.com.wuhao11111111111.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;
import java.util.Map;

import wuhao.bwei.com.wuhao11111111111.MyEventBus.MessageEvent;
import wuhao.bwei.com.wuhao11111111111.MyEventBus.PriceAndCountEvent;
import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.adapter.SelectAdapter;
import wuhao.bwei.com.wuhao11111111111.bean.CartBean;
import wuhao.bwei.com.wuhao11111111111.pay.OrderUtils;
import wuhao.bwei.com.wuhao11111111111.pay.PayResult;
import wuhao.bwei.com.wuhao11111111111.presenter.SelectPresenter;
import wuhao.bwei.com.wuhao11111111111.view.ISelectActivity;

/**
 * Created by alienware on 2018/1/4.
 */

public class ShoppingFragment extends Fragment implements ISelectActivity {


    private SharedPreferences message;
    private View view;
    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    final String orderInfo = getorderInfo();   // 订单信息
    private TextView mTvPrice;
    /**
     * 结算(0)
     */
    private TextView mTvNum;
    private SelectAdapter selectAdapter;
    final Runnable payRunnable = new Runnable() {
        @Override
        public void run() {
            PayTask alipay = new PayTask(getActivity());
            Map<String, String> result = alipay.payV2(orderInfo, true);
            Message msg = new Message();
            msg.obj = result;
            handler.sendMessage(msg);
        }
    };
    private String uid;
    private LinearLayout mGoToLogin;
    private LinearLayout mLinerr;

    @Override
    public void onResume() {
        super.onResume();
        message = getActivity().getSharedPreferences("Message", Context.MODE_PRIVATE);
        uid = message.getString("uid", "用户id");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm04, container, false);
        EventBus.getDefault().register(this);
        final SelectPresenter selectPrenester = new SelectPresenter(this);
        selectPrenester.getselects();
        initView(view);
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
        mTvNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(payRunnable);
                thread.start();
            }
        });

        //判断登陆状态
        if (uid == null) {

            //如果在登陆状态
            mGoToLogin.setVisibility(View.GONE);
            mLinerr.setVisibility(View.VISIBLE);



        }else{
            //如果不在登陆状态
            mGoToLogin.setVisibility(View.VISIBLE);

            mLinerr.setVisibility(View.GONE);
        }
        return view;
    }


    @Override
    public void getselect(List<CartBean.DataBean> groupchild, List<List<CartBean.DataBean.ListBean>> childlist) {
        selectAdapter = new SelectAdapter(getActivity(), groupchild, childlist);
        mElv.setAdapter(selectAdapter);
        mElv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < groupchild.size(); i++) {
            mElv.expandGroup(i);
        }
    }

    private void initView(View view) {
        mElv = (ExpandableListView) view.findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        mTvPrice = (TextView) view.findViewById(R.id.tv_price);
        mTvNum = (TextView) view.findViewById(R.id.tv_num);
        mGoToLogin = (LinearLayout) view.findViewById(R.id.go_to_login);
        mLinerr = (LinearLayout) view.findViewById(R.id.linerr);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }


    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("结算(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            PayResult payResult = new PayResult((Map<String, String>) msg.obj);

            /**
             对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
             */
            String resultInfo = payResult.getResult();// 同步返回需要验证的信息
            String resultStatus = payResult.getResultStatus();
            // 判断resultStatus 为9000则代表支付成功
            if (TextUtils.equals(resultStatus, "9000")) {
                // TODO 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                Toast.makeText(getActivity(), "支付成功", Toast.LENGTH_SHORT).show();
            } else {
                //TODO  该笔订单真实的支付结果，需要依赖服务端的异步通知。
                Toast.makeText(getActivity(), "支付失败", Toast.LENGTH_SHORT).show();
            }
        }
    };


    /**
     * 记得要看
     * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
     * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
     * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
     * <p>
     * orderInfo的获取必须来自服务端；
     */
    public String getorderInfo() {
        Map<String, String> params = OrderUtils.buildOrderParamMap(OrderUtils.APPID);
        String orderParam = OrderUtils.buildOrderParam(params);
        String sign = OrderUtils.getSign(params, OrderUtils.RSA_PRIVATE, false);
        final String orderInfo = orderParam + "&" + sign;
        return orderInfo;
    }


}
