package wuhao.bwei.com.wuhao11111111111.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.bean.GoodsBean;

/**
 * Created by alienware on 2018/1/5.
 */

public class ElvRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<GoodsBean.DataBean.ListBean> listBeen;
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        public void onItemClick(GoodsBean.DataBean.ListBean listBean);
    }
    //定义点击方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public ElvRvAdapter(Context context, List<GoodsBean.DataBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //设置视图
        View view = LayoutInflater.from(context).inflate(R.layout.elv_rv_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final GoodsBean.DataBean.ListBean listBean = listBeen.get(position);
        myViewHolder.tv.setText(listBean.getName());
        myViewHolder.img.setImageURI(listBean.getIcon());
        myViewHolder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(listBean);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        //获取id
        private SimpleDraweeView img;
        private TextView tv;
        private LinearLayout l1;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            l1 = itemView.findViewById(R.id.ll);
        }
    }

}
