package wuhao.bwei.com.wuhao0103lianxi.net;

/**
 * Created by alienware on 2018/1/3.
 */

public interface OnNerliner<T> {
    void onSuccess(T t);
    void onFailed(String str);
}
