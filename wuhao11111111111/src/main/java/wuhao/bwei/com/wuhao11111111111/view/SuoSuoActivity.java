package wuhao.bwei.com.wuhao11111111111.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.adapter.SouSuoAdapter;
import wuhao.bwei.com.wuhao11111111111.bean.SouSuoBean;
import wuhao.bwei.com.wuhao11111111111.presenter.SouSouPresenter;

public class SuoSuoActivity extends AppCompatActivity implements ISuoSuoActivity{
    private String sou;
    private RecyclerView mSousuoRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suo_suo);
        initView();
        Intent intent = getIntent();
        sou = intent.getStringExtra("sou");
        Toast.makeText(this, sou, Toast.LENGTH_LONG).show();
        SouSouPresenter souSouPresenter = new SouSouPresenter(this);
        souSouPresenter.getsou(sou);

    }

    @Override
    public String gets() {
        return sou;
    }

    @Override
    public void getsousou(SouSuoBean souSuoBean) {
        SouSuoAdapter souSuoAdapter = new SouSuoAdapter(this,souSuoBean.getData());
        mSousuoRv.setAdapter(souSuoAdapter);


    }
    private void initView() {
        mSousuoRv = (RecyclerView) findViewById(R.id.sousuo_rv);
        mSousuoRv.setLayoutManager(new LinearLayoutManager(this));
    }


}
