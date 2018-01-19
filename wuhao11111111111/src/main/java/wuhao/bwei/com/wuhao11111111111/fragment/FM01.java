package wuhao.bwei.com.wuhao11111111111.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import wuhao.bwei.com.wuhao11111111111.R;

/**
 * Created by alienware on 2018/1/3.
 */

public class FM01 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fm01_item, container, false);
        return view;
    }
}
