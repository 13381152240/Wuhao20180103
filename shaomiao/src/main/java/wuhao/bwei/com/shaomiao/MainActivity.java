package wuhao.bwei.com.shaomiao;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG= "MainActivity";
    /**
     * 扫描二维码
     */
    private Button mSmbut;
    private EditText mEdittext;
    private ImageView image1;
    public static final int REQUEST_CODE = 001;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    1);}
        mSmbut.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick:");
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);

            }
        });

    }

    private void initView() {
        mSmbut = (Button) findViewById(R.id.smbutton);
        mSmbut.setOnClickListener(this);
        mEdittext = (EditText) findViewById(R.id.mtextstring);
        image1 = (ImageView) findViewById(R.id.mimage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.smbutton:
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE){
            if(null!=data){
                Bundle bundle = data.getExtras();
                if(bundle==null){
                    return;
                }
                if(bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                    String result = bundle.getString(CodeUtils.RESULT_STRING);


                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, WebActivity.class);
                    intent.putExtra("path",result);
                    startActivity(intent);

                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }

            }


        }

    }



}
