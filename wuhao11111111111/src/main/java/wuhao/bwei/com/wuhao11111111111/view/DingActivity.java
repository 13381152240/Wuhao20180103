package wuhao.bwei.com.wuhao11111111111.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.adapter.MyAdapter;
import wuhao.bwei.com.wuhao11111111111.bean.OrderBean;
import wuhao.bwei.com.wuhao11111111111.presenter.OrderPresenter;

public class DingActivity extends AppCompatActivity implements ISecondActivity,View.OnClickListener{
    private ImageView mIvPop;
    /**
     * 待支付
     */
    private RadioButton mRb1;
    /**
     * 已支付
     */
    private RadioButton mRb2;
    /**
     * 已取消
     */
    private RadioButton mRb3;
    private RadioGroup mRg;
    private XRecyclerView mXrv;
    private int page = 1;
    private List<OrderBean.DataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;
    private OrderPresenter orderPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding);
        initView();
        mXrv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, list);
        mXrv.setAdapter(myAdapter);
        orderPresenter = new OrderPresenter(this);
        orderPresenter.getOrder(true, "1", page + "");
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                orderPresenter.getOrder(true, "1", page + "");
            }

            @Override
            public void onLoadMore() {
                //加载更多
                page++;
                orderPresenter.getOrder(false, "1", page + "");
            }
        });

    }
    private void initView() {
        mIvPop = (ImageView) findViewById(R.id.iv_pop);
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        mIvPop.setOnClickListener(this);
    }

    public void showData(boolean isRefresh, List<OrderBean.DataBean> newlist) {
        if (isRefresh) {
            list.clear();
            list.addAll(newlist);
            mXrv.refreshComplete();
        } else {
            list.addAll(newlist);
            mXrv.setLoadingMoreEnabled(false);
        }
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_pop:
                View view = View.inflate(DingActivity.this, R.layout.pop_item, null);
                TextView tv1 = view.findViewById(R.id.tv1);
                TextView tv2 = view.findViewById(R.id.tv2);
                TextView tv3 = view.findViewById(R.id.tv3);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                final PopupWindow popupWindow = new PopupWindow(view, layoutParams.width, layoutParams.height);
                popupWindow.showAsDropDown(mIvPop, 0, 30);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DingActivity.this, "待支付", Toast.LENGTH_SHORT).show();
                        orderPresenter.getOrder(true, "0", "1");
                    }
                });
                tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DingActivity.this, "已支付", Toast.LENGTH_SHORT).show();
                        orderPresenter.getOrder(true, "1", "1");
                    }
                });
                tv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DingActivity.this, "已取消", Toast.LENGTH_SHORT).show();
                        orderPresenter.getOrder(true, "2", "1");
                    }
                });
                break;
        }
    }


}
