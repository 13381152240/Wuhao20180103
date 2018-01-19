package wuhao.bwei.com.wuhao11111111111.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.bean.UserBean;
import wuhao.bwei.com.wuhao11111111111.newWork.SetOnClicklistener;

/**
 * Created by alienware on 2018/1/5.
 */

public class ClassZuoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<UserBean.DataBean> list;
    private SetOnClicklistener setOnClicklistener;
    private LayoutInflater inflater;

    public ClassZuoAdapter(Context context, List<UserBean.DataBean> list, SetOnClicklistener setOnClicklistener) {
        this.context = context;
        this.list = list;
        this.setOnClicklistener = setOnClicklistener;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //设置布局
        View view = inflater.inflate(R.layout.classzuo_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //绑定布局
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        final UserBean.DataBean dataBean = list.get(position);
        myViewHolder.tv.setText(dataBean.getName());
        myViewHolder.rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnClicklistener.OnClikLinter(dataBean.getCid()+"");
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv;
        private RelativeLayout rel;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            rel = itemView.findViewById(R.id.rel);
        }
    }


}
