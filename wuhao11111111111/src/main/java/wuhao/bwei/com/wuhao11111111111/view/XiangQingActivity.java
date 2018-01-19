package wuhao.bwei.com.wuhao11111111111.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.adapter.ZiFenLeiAdapter;
import wuhao.bwei.com.wuhao11111111111.bean.XiangQingBean;
import wuhao.bwei.com.wuhao11111111111.presenter.ZiFenLeiPrenester;

public class XiangQingActivity extends AppCompatActivity implements IXiangQing{
    private String pscid;
    private RecyclerView mZiFenLeiRv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        initView();
        Intent intent = getIntent();
        pscid = intent.getStringExtra("pscid");
        Toast.makeText(XiangQingActivity.this, pscid, Toast.LENGTH_LONG);
        ZiFenLeiPrenester ziFenLeiPrenester = new ZiFenLeiPrenester(this);
        ziFenLeiPrenester.zishow(pscid);


    }

    private void initView() {
        mZiFenLeiRv = (RecyclerView) findViewById(R.id.ZiFenLeiRv);
        //设置成线性布局
        mZiFenLeiRv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public String getpscid() {
        return pscid;
    }

    @Override
    public void showzi(XiangQingBean xiangQingBean) {
        ZiFenLeiAdapter ziFenLeiAdapter = new ZiFenLeiAdapter(this,xiangQingBean.getData());
        mZiFenLeiRv.setAdapter(ziFenLeiAdapter);
    }
}
