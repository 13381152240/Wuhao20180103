package wuhao.bwei.com.wuhao11111111111.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import wuhao.bwei.com.wuhao11111111111.view.DingActivity;
import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.view.LoginActivity;

/**
 * Created by alienware on 2018/1/4.
 */

public class MyFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView mXiaoxi;
    private ImageView mTou;
    /**
     * 登录/注册 >
     */
    private SharedPreferences message;
    private TextView mLogin;
    private ImageView mZhi;
    private ImageView mWei;
    private ImageView mMyddd;

    @Override
    public void onResume() {
        super.onResume();
        message = getActivity().getSharedPreferences("Message", Context.MODE_PRIVATE);
        String uname = message.getString("uname", "登录/注册>");
        mLogin.setText(uname);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm05, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
        mTou = (ImageView) view.findViewById(R.id.tou);
        mLogin = (TextView) view.findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mMyddd = (ImageView) view.findViewById(R.id.myddd);
        mMyddd.setOnClickListener(this);
    }

    //实例化P层,P层和m层可以写到一个类里面,因为m层和p层不需要继承它们,可以把方法都写在m层和p层中,想要调用的时候直接.出来即可
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.myddd:
                final Intent intent1 = new Intent(getActivity(), DingActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
