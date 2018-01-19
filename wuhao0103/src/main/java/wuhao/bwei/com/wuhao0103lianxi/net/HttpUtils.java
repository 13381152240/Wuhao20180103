package wuhao.bwei.com.wuhao0103lianxi.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alienware on 2018/1/3.
 */

public class HttpUtils {
    private static OkHttpClient okHttpClient;
    private static SersApi sersApi;

    static {
        inits();

    }

    private static void inits() {
        if(okHttpClient==null){
            synchronized (OkHttpClient.class){
                if(okHttpClient==null){
                    okHttpClient = new OkHttpClient.Builder().build();
                }

            }
        }
    }

    public static SersApi getApi(){
        //根据网络请求
        if(sersApi==null){
            synchronized (SersApi.class){
                if(sersApi==null){
                    sersApi = HttpUtils.createApi(SersApi.class,UrlUtils.Host);

                }

            }

        }
        return sersApi;
    }

    public static <T> T createApi(Class<T> clazz,String url){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlUtils.Host)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);

    }





}
