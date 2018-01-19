package wuhao.bwei.com.wuhao11111111111.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import wuhao.bwei.com.wuhao11111111111.R;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private int wh=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tvv1);


        Window window = getWindow();
        //隐藏标题栏
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        final Intent intent = new Intent(MainActivity.this,Main2Activity.class);



            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    //开始运行
                    if (wh==0) {
                        startActivity(intent);
                        finish();
                    }


                }
            };

            timer.schedule(task, 4000);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                wh=1;
                finish();
            }
        });

    }
}
