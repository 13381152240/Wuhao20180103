package wuhao.bwei.com.wuhao11111111111.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.bean.LoginBean;
import wuhao.bwei.com.wuhao11111111111.bean.ZhuceBean;
import wuhao.bwei.com.wuhao11111111111.presenter.LPresenter;

public class ZhuCeActivity extends AppCompatActivity implements View.OnClickListener ,ILogin{
    private ImageView mZhuceFan;
    /**
     * 快速注册
     */
    private TextView mZhuceTitle;
    /**
     * 账号
     */
    private TextView mZhuceUser;
    /**
     * 邮箱/手机号/账号
     */
    private EditText mZhuceUserShu;
    /**
     * 密码
     */
    private TextView mZhucePassword;
    /**
     * 请输入密码
     */
    private EditText mEditText4;
    /**
     * 注册
     */
    private Button mZhuceBut;
    private EditText emaill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        initView();

    }
    private void initView() {
        mZhuceFan = (ImageView) findViewById(R.id.zhuce_fan);
        mZhuceFan.setOnClickListener(this);
        mZhuceTitle = (TextView) findViewById(R.id.zhuce_title);
        mZhuceTitle.setOnClickListener(this);
        mZhuceUser = (TextView) findViewById(R.id.zhuce_user);
        mZhuceUser.setOnClickListener(this);
        mZhuceUserShu = (EditText) findViewById(R.id.zhuce_user_shu);
        mZhuceUserShu.setOnClickListener(this);
        mZhucePassword = (TextView) findViewById(R.id.zhuce_password);
        mZhucePassword.setOnClickListener(this);
        mEditText4 = (EditText) findViewById(R.id.editText4);
        mEditText4.setOnClickListener(this);
        mZhuceBut = (Button) findViewById(R.id.zhuce_but);
        mZhuceBut.setOnClickListener(this);
        emaill = (EditText) findViewById(R.id.editText2);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zhuce_fan:
                finish();
                break;
            case R.id.zhuce_title:
                break;
            case R.id.zhuce_user:
                break;
            case R.id.zhuce_user_shu:
                break;
            case R.id.zhuce_password:
                break;
            case R.id.editText4:
                break;
            case R.id.zhuce_but:
                String s = mZhuceUserShu.getText().toString();
                String s1 = mEditText4.getText().toString();
                LPresenter zhuCePresenter = new LPresenter(this);
                zhuCePresenter.getZ(s,s1);




                break;
        }
    }

    @Override
    public void getlogin(LoginBean loginBean) {

    }

    @Override
    public void getzhuce(ZhuceBean zhuceBean) {
        String email = emaill.getText().toString().trim();
        String num = mZhuceUserShu.getText().toString().trim();
        String password = mEditText4.getText().toString().trim();
        Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        boolean matches = m.matches();

        if(zhuceBean.getMsg().equals("注册成功")&&email!=null&&num!=null&&password!=null){
            Toast.makeText(this,zhuceBean.getMsg(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ZhuCeActivity.this,LoginActivity.class);
            startActivity(intent);

            finish();
        }else if(!matches){
            Toast.makeText(this,"邮箱格式不正确",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
        }
    }
}
