package wuhao.bwei.com.wuhao11111111111.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.bean.LunBoBean;

/**
 * Created by alienware on 2018/1/4.
 */

public class WeiNiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<LunBoBean.TuijianBean.ListBean> list;
    private LayoutInflater inflater;

    public WeiNiAdapter(Context context, List<LunBoBean.TuijianBean.ListBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);

    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.weini_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final LunBoBean.TuijianBean.ListBean listBean = list.get(position);
        final String[] split = listBean.getImages().split("\\|");
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.home_image.setImageURI(split[0]);
        myViewHolder.home_tv.setText(listBean.getTitle());
        myViewHolder.home_tv_price.setText("￥"+listBean.getPrice()+"");

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private  SimpleDraweeView home_image;
        private TextView home_tv;
        private  TextView home_tv_price;

        public MyViewHolder(View itemView) {
            super(itemView);
            home_image = itemView.findViewById(R.id.home_item_image);
            home_tv = itemView.findViewById(R.id.home_item_tv);
            home_tv_price = itemView.findViewById(R.id.weini_tv_price);

        }
    }


}
