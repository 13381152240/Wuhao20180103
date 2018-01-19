package wuhao.bwei.com.wuhao11111111111.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.view.WebActivity;
import wuhao.bwei.com.wuhao11111111111.adapter.HomeAdapter;
import wuhao.bwei.com.wuhao11111111111.adapter.WeiNiAdapter;
import wuhao.bwei.com.wuhao11111111111.bean.LunBoBean;
import wuhao.bwei.com.wuhao11111111111.bean.UserBean;
import wuhao.bwei.com.wuhao11111111111.presenter.LunBoPresenter;
import wuhao.bwei.com.wuhao11111111111.presenter.ShowPresenter;
import wuhao.bwei.com.wuhao11111111111.view.GlideImageLoader;
import wuhao.bwei.com.wuhao11111111111.view.ISuccessActivity;
import wuhao.bwei.com.wuhao11111111111.view.IlunBo;
import wuhao.bwei.com.wuhao11111111111.view.SuoSuoActivity;

/**
 * Created by alienware on 2018/1/3.
 */

public class HomePageFragment extends Fragment implements IlunBo, ISuccessActivity, View.OnClickListener {
    private View view;
    private Banner mHomeBanner;

    private List<String> listimg = new ArrayList<>();
    private RecyclerView mHomeRev;
    private RecyclerView mWeiniRv;
    private static final String TAG= "MainActivity";

    public static final int REQUEST_CODE = 001;
    /**
     * 请输入关键字
     */
    private EditText mEditText;
    private ImageView mImageView;
    private ImageView mImageView2;
    /**
     * 扫啊扫
     */
    private TextView mTextView3;
    /**
     * 搜索
     */
    private Button mButSou;
    private LunBoPresenter lunBoPrenester;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm01_item, container, false);
        initView(view);
        lunBoPrenester = new LunBoPresenter(this);
        lunBoPrenester.getShowLunNo();

        ShowPresenter showPrenester = new ShowPresenter(this);
        showPrenester.getData();
        return view;

    }

    private void initView(View view) {
        mHomeBanner = (Banner) view.findViewById(R.id.home_banner);
        mHomeRev = (RecyclerView) view.findViewById(R.id.home_rev);
        mHomeRev.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        mWeiniRv = (RecyclerView) view.findViewById(R.id.weini_rv);
        mWeiniRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mEditText = (EditText) view.findViewById(R.id.editText);
        mImageView = (ImageView) view.findViewById(R.id.imageView);
        mImageView2 = (ImageView) view.findViewById(R.id.imageView2);
        mTextView3 = (TextView) view.findViewById(R.id.textView3);
        mButSou = (Button) view.findViewById(R.id.but_sou);
        mButSou.setOnClickListener(this);
        mImageView2.setOnClickListener(this);
    }

    @Override
    public void showLunBo(LunBoBean lunBoBean) {
        WeiNiAdapter weiNiAdapter = new WeiNiAdapter(getActivity(), lunBoBean.getTuijian().getList());
        mWeiniRv.setAdapter(weiNiAdapter);
        List<LunBoBean.DataBean> data = lunBoBean.getData();

        for (int i = 0; i < data.size(); i++) {
            LunBoBean.DataBean dataBean = data.get(i);
            listimg.add(dataBean.getIcon());
        }
        mHomeBanner.setImageLoader(new GlideImageLoader());
        mHomeBanner.setImages(listimg);
        mHomeBanner.start();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
            case R.id.but_sou:
                String s = mEditText.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    Toast.makeText(getActivity(), "搜索框不能为空", Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent(getActivity(), SuoSuoActivity.class);
                    intent.putExtra("sou", s);
                    startActivity(intent);

                }
                break;


            case R.id.imageView2:
                Log.d(TAG,"onClick:");
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);


                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(null!=data){
                Bundle bundle = data.getExtras();
                if(bundle==null){
                    return;
                }
                if(bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                    String result = bundle.getString(CodeUtils.RESULT_STRING);


                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("path",result);
                    startActivity(intent);

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }

            }


        }

    }
    @Override
    public void show(UserBean userBean) {
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), userBean.getData());
        mHomeRev.setAdapter(homeAdapter);

    }





}
