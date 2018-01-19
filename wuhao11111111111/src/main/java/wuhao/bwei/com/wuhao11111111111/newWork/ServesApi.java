package wuhao.bwei.com.wuhao11111111111.newWork;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wuhao.bwei.com.wuhao11111111111.bean.AddSBean;
import wuhao.bwei.com.wuhao11111111111.bean.CartBean;
import wuhao.bwei.com.wuhao11111111111.bean.DeleteCartBean;
import wuhao.bwei.com.wuhao11111111111.bean.GoodsBean;
import wuhao.bwei.com.wuhao11111111111.bean.LoginBean;
import wuhao.bwei.com.wuhao11111111111.bean.LunBoBean;
import wuhao.bwei.com.wuhao11111111111.bean.SouSuoBean;
import wuhao.bwei.com.wuhao11111111111.bean.UserBean;
import wuhao.bwei.com.wuhao11111111111.bean.XiangQingBean;
import wuhao.bwei.com.wuhao11111111111.bean.ZhuceBean;
import wuhao.bwei.com.wuhao11111111111.bean.ZiFenLeiXiangBean;

import static wuhao.bwei.com.wuhao11111111111.newWork.UrlUtils.zhuce;

/**
 * Created by alienware on 2018/1/3.
 */

public interface ServesApi {
    @GET(UrlUtils.TAG)
    Flowable<UserBean> tags();

    @GET(UrlUtils.ZUO)
    Flowable<GoodsBean> goods(@Query("cid")String cid);

    @GET(UrlUtils.XIANG)
    Flowable<XiangQingBean> xiang(@Query("pscid") String pscid);

    @GET(UrlUtils.FEN)
    Flowable<ZiFenLeiXiangBean> ZiFenLeiXiang(@Query("pid") String pid,@Query("source") String str);//传公共参数

    @GET(UrlUtils.LUNBO)
    Flowable<LunBoBean> lunbo();

    @GET(UrlUtils.SOU)
    Flowable<SouSuoBean> sou(@Query("keywords") String keywords, @Query("source") String str);

    @GET(UrlUtils.ADD)
    Flowable<AddSBean> adds(@Query("pid") String pid, @Query("source") String str);

    @GET(UrlUtils.SELECT)
    Flowable<CartBean> selects(@Query("source") String str);

    @GET(UrlUtils.LOGIN)
    Flowable<LoginBean> login(@Query("mobile") String mo, @Query("password") String pas);

    @GET(UrlUtils.DELETETAG)
    Flowable<DeleteCartBean> delete(@Query("pid") String pid);

    @GET(zhuce)
    Flowable<ZhuceBean> zhuce(@Query("mobile") String mo, @Query("password") String pas);


}
