package wuhao.bwei.com.wuhao11111111111.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.Banner;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.bean.AddSBean;
import wuhao.bwei.com.wuhao11111111111.bean.ZiFenLeiXiangBean;
import wuhao.bwei.com.wuhao11111111111.presenter.AddPresenter;
import wuhao.bwei.com.wuhao11111111111.presenter.ZiFenLeiXiangPrenester;

public class ZiFenLeiXiang extends AppCompatActivity implements IZiFenLeiXiang,IAddActivity, View.OnClickListener{
    private String pid;
    private Banner mBanner;
    /**
     * TextView
     */
    private TextView mTextView;
    /**
     * TextView
     */
    private TextView mTextView2;
    /**
     * 加入购物车
     */
    private Button mTvJiaru;
    SimpleDraweeView banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zi_fen_lei_xiang);
        intView();
        Intent intent = getIntent();
        pid =intent.getStringExtra("pid");
        Toast.makeText(ZiFenLeiXiang.this,pid,Toast.LENGTH_SHORT).show();
        //实例化商品详情类
        //实例化P层
        ZiFenLeiXiangPrenester ziFenLeiXiangPrenester = new ZiFenLeiXiangPrenester(this);
        ziFenLeiXiangPrenester.getShowZiFen(pid);



    }

    private void intView() {
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTvJiaru = (Button) findViewById(R.id.tv_jiaru);
        banner = (SimpleDraweeView) findViewById(R.id.banner);
        mTvJiaru.setOnClickListener(this);
    }

    @Override
    public String getpid() {
       return pid;
    }

    @Override
    public void addshow(AddSBean addSBean) {
        Toast.makeText(this,addSBean.getMsg(),Toast.LENGTH_LONG).show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_jiaru:
                AddPresenter addPresenter=new AddPresenter(this);
                addPresenter.getshow(pid);
                break;
        }
    }

    @Override
    public String getid() {
        return pid;
    }

    @Override
    public void showZiFenLeiXiang(ZiFenLeiXiangBean ziFenLeiXiangBean) {
        ZiFenLeiXiangBean.DataBean data = ziFenLeiXiangBean.getData();
        mTextView.setText(data.getTitle());
        mTextView2.setText("¥" + data.getPrice() + "");
//        banner
        final String[] split = data.getImages().split("\\|");
        banner.setImageURI(split[0]+"");


    }
}
