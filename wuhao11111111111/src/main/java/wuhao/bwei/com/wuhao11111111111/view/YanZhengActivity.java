package wuhao.bwei.com.wuhao11111111111.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mob.MobSDK;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import wuhao.bwei.com.wuhao11111111111.R;

public class YanZhengActivity extends AppCompatActivity {


    @BindView(R.id.editPhoneNumber)
    EditText editPhoneNumber;
    @BindView(R.id.editCode)
    EditText editCode;
    @BindView(R.id.buttonCode)
    Button buttonCode;
    @BindView(R.id.buttonRegister)
    Button buttonRegister;
    private Boolean isPhoneNumberOk;
    private Boolean isCodeOk;
    private Boolean isPasswordOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yan_zheng);
        ButterKnife.bind(this);
        MobSDK.init(YanZhengActivity.this, "23a7286818901", "04bf56f24f66acca1cc6d31393cb606a");
        initData();
        initUI();
        initEvent();

    }

    private void initEvent() {
        //绑定监听器
        editPhoneNumber.addTextChangedListener(phoneNumberWatcher);
        editCode.addTextChangedListener(codeWatecher);
    }

    private void initUI() {
    }

    //初始数据
    private void initData() {
        //初始注册按钮无法点击
        isPhoneNumberOk = false;
        isCodeOk = false;
        buttonRegister.setEnabled(false);
    }

    //设置注册按钮是否可以点击
    private void setButtonEnable() {
        if (isCodeOk & isPhoneNumberOk) {
            buttonRegister.setEnabled(true);
            buttonRegister.setBackgroundColor(Color.parseColor("#00BB00"));
            buttonRegister.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            buttonRegister.setEnabled(false);
            buttonRegister.setBackgroundColor(Color.parseColor("#E0E0E0"));
        }

    }

    @OnClick(R.id.buttonCode)
    public void onButtonCodeClicked() {
        sendCode();
        //SMSSDK.getSupportedCountries();
        SMSSDK.getVerificationCode("86", editPhoneNumber.getText().toString());
    }

    private void sendCode() {

        EventHandler eventHandler = new EventHandler() {
            //初始化接口
            @Override
            public void afterEvent(int i, int i1, Object o) {
                super.afterEvent(i, i1, o);
                //成功接收到验证码时提醒用户
                if (i1 == SMSSDK.RESULT_COMPLETE) {
                    if (i == SMSSDK.EVENT_GET_VERIFICATION_CODE) {//发送验证码函数被调用
                        // Log.d("RegisterActivity","11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
                        //Log.d("RegisterActivity",""+i);
                        // Toast.makeText(RegisterActivity.this,"验证码已送达",Toast.LENGTH_SHORT).show();
                    } else if (i == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //支持发送验证码的国家列表方法被调用
                        //Toast.makeText(RegisterActivity.this, "验证码已送达", Toast.LENGTH_SHORT).show();
                        Log.d("RegisterActivity", "这个函数有执行：" + o);
                    } else if (i == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码被调用
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(YanZhengActivity.this, "验证成功", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(YanZhengActivity.this, Main2Activity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                }

            }
        };
        //注册监听器
        SMSSDK.registerEventHandler(eventHandler);


    }

    @OnClick(R.id.buttonRegister)
    public void onButtonRegisterClicked() {
        //三个形参依次代表：国家代号、手机号、输入的验证码
        SMSSDK.submitVerificationCode("86", editPhoneNumber.getText().toString(), editCode.getText().toString());
    }

    //监听手机号码格式是否正确
    TextWatcher phoneNumberWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String inputStr = editable.toString().trim();
            if (!TextUtils.isEmpty(inputStr) && inputStr.getBytes().length == 11) {
                isPhoneNumberOk = true;
            } else {
                isPhoneNumberOk = false;

            }
            setButtonEnable();
        }
    };
    //监听验证码格式是否正确
    TextWatcher codeWatecher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            String code = editable.toString().trim();
            if (!TextUtils.isEmpty(code)) {
                isCodeOk = true;
            } else {
                isCodeOk = false;
            }
            setButtonEnable();
        }
    };
    //监听密码是否正确
//    TextWatcher passwordWatecher = new TextWatcher() {
//        @Override
//        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//        }
//
//        @Override
//        public void afterTextChanged(Editable editable) {
//            String inputStr = editable.toString().trim();
//            if (!TextUtils.isEmpty(inputStr) && inputStr.getBytes().length >= 6) {
//                isPasswordOk = true;
//            } else {
//                isPasswordOk = false;
//
//            }
//            setButtonEnable();
//        }
//    };


}