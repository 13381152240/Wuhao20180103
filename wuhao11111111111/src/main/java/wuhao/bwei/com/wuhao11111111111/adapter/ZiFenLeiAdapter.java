package wuhao.bwei.com.wuhao11111111111.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.bean.XiangQingBean;
import wuhao.bwei.com.wuhao11111111111.view.ZiFenLeiXiang;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZiFenLeiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<XiangQingBean.DataBean> list;
    private LayoutInflater inflater;

    public ZiFenLeiAdapter(Context context, List<XiangQingBean.DataBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //设置布局
        View view = inflater.inflate(R.layout.zifenlei_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //绑定视图
        final XiangQingBean.DataBean dataBean = list.get(position);
        //拆分图片
        String[] split = dataBean.getImages().split("\\|");
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.image_zifenlei.setImageURI(split[0]);
        myViewHolder.tv_title.setText(dataBean.getTitle());
        myViewHolder.tv_price.setText(dataBean.getPrice()+"");
        myViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ZiFenLeiXiang.class);
                intent.putExtra("pid",dataBean.getPid()+"");
                context.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private SimpleDraweeView image_zifenlei;
        private TextView tv_title;
        private TextView tv_price;
        private RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            image_zifenlei = itemView.findViewById(R.id.image_zifenlei);
            tv_title = itemView.findViewById(R.id.tv_zifenlei_title);
            tv_price = itemView.findViewById(R.id.tv_zifenlei_price);
            relativeLayout = itemView.findViewById(R.id.rv_zifenlei);
        }
    }




}
