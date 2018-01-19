package wuhao.bwei.com.wuhao11111111111.newWork;

/**
 * Created by alienware on 2018/1/3.
 */

public class UrlUtils {
    public static final String HOST = "http://120.27.23.105/";
    public static final String TAG="product/getCatagory";

    public static final String ZUO="product/getProductCatagory";

    public static final String XIANG="product/getProducts";

    //子分类下的详情
    public static final String FEN="product/getProductDetail";

    public static final String LUNBO="ad/getAd";

    //搜索
    public static final String SOU="product/searchProducts";

    //加入购物车
    public static final String ADD="product/addCart?uid=71";

    //查询购物车
    public static final String SELECT="product/getCarts?uid=71";

    //登录
    public static final String LOGIN="user/login";

    //删除购物车

    public static final String DELETETAG = "product/deleteCart?uid=71";

    //更新购物车
    public static final String UPDATA = "product/updateCarts?uid=71&sellerid=1&pid=1&selected=0&num=10";
    //注册
    public static final String zhuce = "user/reg";
    //获取订单列表接口
    public static final String getOrders = "https://www.zhaoapi.cn/product/getOrders";
    //修改订单状态
    public static final String updateOrder = "https://www.zhaoapi.cn/product/updateOrder";
}
