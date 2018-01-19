package wuhao.bwei.com.wuhao0103lianxi.net;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import wuhao.bwei.com.wuhao0103lianxi.bean.UserBean;

/**
 * Created by alienware on 2018/1/3.
 */

public interface SersApi{
    //定义范型
    @GET(UrlUtils.TAG)
    Flowable<UserBean> tags();

}
