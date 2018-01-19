package wuhao.bwei.com.wuhao11111111111.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.adapter.ClassZuoAdapter;
import wuhao.bwei.com.wuhao11111111111.adapter.ZuoAdapter;
import wuhao.bwei.com.wuhao11111111111.bean.GoodsBean;
import wuhao.bwei.com.wuhao11111111111.bean.UserBean;
import wuhao.bwei.com.wuhao11111111111.newWork.SetOnClicklistener;
import wuhao.bwei.com.wuhao11111111111.presenter.ShowPresenter;
import wuhao.bwei.com.wuhao11111111111.presenter.ZuoPresenter;
import wuhao.bwei.com.wuhao11111111111.view.IClassActivity;
import wuhao.bwei.com.wuhao11111111111.view.ISuccessActivity;

/**
 * Created by alienware on 2018/1/4.
 */

public class ClassifyFragment extends Fragment implements ISuccessActivity,SetOnClicklistener,IClassActivity{
    private View view;
    private RecyclerView mRv;
    private ExpandableListView elv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fm02, container, false);
        ShowPresenter showPrenester=new ShowPresenter(this);
        showPrenester.getData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rvv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        elv = view.findViewById(R.id.elv);
    }



    @Override
    public void show(UserBean userBean) {

        ClassZuoAdapter classes = new ClassZuoAdapter(getActivity(),userBean.getData(),this);
        mRv.setAdapter(classes);
    }

    @Override
    public void OnClikLinter(String url) {
        //实例化p层
        ZuoPresenter zuop = new ZuoPresenter(this);
        zuop.getzuoshow(url);
        Toast.makeText(getActivity(),url,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showZuo(List<GoodsBean.DataBean> groupList, List<List<GoodsBean.DataBean.ListBean>> childList) {
        ZuoAdapter zuoAdapter = new ZuoAdapter(getActivity(),groupList,childList);
        elv.setAdapter(zuoAdapter);
        elv.setGroupIndicator(null);
        //默认让其全部展开
        for(int i = 0;i<groupList.size();i++){
            elv.expandGroup(i);
        }

    }
}
