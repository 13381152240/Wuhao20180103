package wuhao.bwei.com.wuhao11111111111.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.fragment.ClassifyFragment;
import wuhao.bwei.com.wuhao11111111111.fragment.DiscoverFragment;
import wuhao.bwei.com.wuhao11111111111.fragment.HomePageFragment;
import wuhao.bwei.com.wuhao11111111111.fragment.MyFragment;
import wuhao.bwei.com.wuhao11111111111.fragment.ShoppingFragment;

public class Main2Activity extends AppCompatActivity {
    private BottomTabBar mb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mb = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        mb.init(getSupportFragmentManager())
                .setImgSize(130,130)
                .setFontSize(0)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("",R.mipmap.ac0,HomePageFragment.class)
                .addTabItem("",R.mipmap.abw, ClassifyFragment.class)
                .addTabItem("",R.mipmap.aby, DiscoverFragment.class)
                .addTabItem("",R.mipmap.abu, ShoppingFragment.class)
                .addTabItem("",R.mipmap.ac2, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
