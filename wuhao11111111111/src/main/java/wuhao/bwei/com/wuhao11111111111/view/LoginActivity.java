package wuhao.bwei.com.wuhao11111111111.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONObject;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.bean.LoginBean;
import wuhao.bwei.com.wuhao11111111111.bean.ZhuceBean;
import wuhao.bwei.com.wuhao11111111111.presenter.LPresenter;

public class LoginActivity extends AppCompatActivity implements ILogin,View.OnClickListener{
    private ImageView mMyImage;
    /**
     * 京东登录
     */
    private TextView mMyTitle;
    /**
     * 账号
     */
    private TextView mMyUser;
    /**
     * 用户名/邮箱/手机号
     */
    private EditText mMyShu;
    /**
     * 密码
     */
    private TextView mMyPassword;
    /**
     * 请输入密码
     */
    private EditText mEditText3;
    private ImageView mImageView3;
    private ImageView mImageView4;
    /**
     * 登录
     */
    private Button mMyButLogin;
    /**
     * 注册账号
     */
    private TextView mMyTvZhuce;
    /**
     * 忘记密码?
     */
    private TextView mMyTvWang;
    private ImageView mMyQqLogin;
    private ImageView mMyWeixinLogin;
    private String s;
    private String s1;
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        LPresenter lPresenter = new LPresenter(this);
        mTencent = Tencent.createInstance(APP_ID,LoginActivity.this.getApplicationContext());


    }
    private void initView() {
        mMyImage = (ImageView) findViewById(R.id.my_image);
        mMyImage.setOnClickListener(this);
        mMyTitle = (TextView) findViewById(R.id.my_title);
        mMyTitle.setOnClickListener(this);
        mMyUser = (TextView) findViewById(R.id.my_user);
        mMyUser.setOnClickListener(this);
        mMyShu = (EditText) findViewById(R.id.my_shu);
        mMyShu.setOnClickListener(this);
        mMyPassword = (TextView) findViewById(R.id.my_password);
        mMyPassword.setOnClickListener(this);
        mEditText3 = (EditText) findViewById(R.id.editText3);
        mEditText3.setOnClickListener(this);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        mImageView3.setOnClickListener(this);
        mImageView4 = (ImageView) findViewById(R.id.imageView4);
        mImageView4.setOnClickListener(this);
        mMyButLogin = (Button) findViewById(R.id.my_but_login);
        mMyButLogin.setOnClickListener(this);
        mMyTvZhuce = (TextView) findViewById(R.id.my_tv_zhuce);
        mMyTvZhuce.setOnClickListener(this);
        mMyTvWang = (TextView) findViewById(R.id.my_tv_wang);
        mMyTvWang.setOnClickListener(this);
        mMyQqLogin = (ImageView) findViewById(R.id.my_qq_login);
        mMyQqLogin.setOnClickListener(this);
        mMyWeixinLogin = (ImageView) findViewById(R.id.my_weixin_login);
        mMyWeixinLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.my_image:
                Intent intent2=new Intent(LoginActivity.this, MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("account","登录/注册>");
                intent2.putExtras(bundle);
                LoginActivity.this.setResult(11,intent2);
                finish();
                break;
            case R.id.my_title:
                break;
            case R.id.my_user:
                break;
            case R.id.my_shu:
                break;
            case R.id.my_password:
                break;
            case R.id.editText3:
                break;
            case R.id.imageView3:
                break;
            case R.id.imageView4:
                break;
            case R.id.my_but_login:
                s = mMyShu.getText().toString().trim();
                s1 = mEditText3.getText().toString().trim();
                LPresenter lpresenter = new LPresenter(this);
                lpresenter.getL(s,s1);

                break;
            case R.id.my_tv_zhuce:
                Intent intent = new Intent(this, YanZhengActivity.class);
                startActivity(intent);
                break;
            case R.id.my_tv_wang:
                break;
            case R.id.my_qq_login:
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(LoginActivity.this,"all", mIUiListener);

                break;
            case R.id.my_weixin_login:
                break;
        }

    }
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(LoginActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                        final Intent intent = new Intent(LoginActivity.this,YanZhengActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(LoginActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(LoginActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }



    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void getlogin(LoginBean loginBean) {
        if(loginBean.getMsg().equals("登录成功")){
            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
            //将登陆信息存放到SharedPreferences
            SharedPreferences.Editor editor = getSharedPreferences("Message",MODE_PRIVATE).edit();
            editor.putBoolean("istrue",true);
            editor.putString("uname",mMyShu.getText().toString().trim());

            editor.putString("uid",loginBean.getData().getUid()+"");



            editor.commit();
            //登陆成功后跳转
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("account",mMyShu.getText().toString().trim());
            intent.putExtras(bundle);
            LoginActivity.this.setResult(10,intent);
            finish();
        }else{
            Toast.makeText(this,loginBean.getMsg(),Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void getzhuce(ZhuceBean zhuceBean) {

    }
}
