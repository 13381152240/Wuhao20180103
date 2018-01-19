package wuhao.bwei.com.wuhao11111111111.net;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by alienware on 2018/1/3.
 */

public class HttpUtils {
    private static HttpUtils httpUtils;
    private final OkHttpClient client;

    public HttpUtils() {
        client = new OkHttpClient.Builder()
                .addInterceptor(new MyInterceptor())
                .build();
    }
    public static HttpUtils getHttpUtils(){
        if (httpUtils == null){
            synchronized (HttpUtils.class){
                if (httpUtils ==null){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    public void doPost(String url, Map<String,String> map, Callback callback){
        if (map == null){
            throw new RuntimeException("参数为空");
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> entry: map.entrySet()) {
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        client.newCall(request).enqueue(callback);
    }
    public void doGet(String url,Callback callback){
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }



}
