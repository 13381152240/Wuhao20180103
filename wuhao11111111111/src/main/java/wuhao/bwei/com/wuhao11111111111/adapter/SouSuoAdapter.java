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
import wuhao.bwei.com.wuhao11111111111.bean.SouSuoBean;

/**
 * Created by alienware on 2018/1/4.
 */

public class SouSuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<SouSuoBean.DataBean> list;
    private LayoutInflater inflater;

    public SouSuoAdapter(Context context, List<SouSuoBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.sousou_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SouSuoBean.DataBean dataBean = list.get(position);
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        String[] spild=dataBean.getImages().split("\\|");
        myViewHolder.img.setImageURI(spild[0]);
        myViewHolder.tv_su.setText(dataBean.getSubhead());
        myViewHolder.tv_price.setText(dataBean.getPrice()+"");
        myViewHolder.tv_title.setText(dataBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img;
        private final TextView tv_su;
        private final TextView tv_price;
        private final TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.sousuo_image);
            tv_title = itemView.findViewById(R.id.sousuo_title);
            tv_su = itemView.findViewById(R.id.sousuo_subhead);
            tv_price = itemView.findViewById(R.id.sousuo_price);
        }
    }
}
