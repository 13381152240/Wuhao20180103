package wuhao.bwei.com.wuhao11111111111.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import wuhao.bwei.com.wuhao11111111111.R;
import wuhao.bwei.com.wuhao11111111111.view.XiangQingActivity;
import wuhao.bwei.com.wuhao11111111111.bean.GoodsBean;

/**
 * Created by alienware on 2018/1/5.
 */

public class ZuoAdapter extends BaseExpandableListAdapter{
    private Context context;
    private List<GoodsBean.DataBean> grouplist;
    private List<List<GoodsBean.DataBean.ListBean>> childlist;
    private LayoutInflater inflater;

    public ZuoAdapter(Context context, List<GoodsBean.DataBean> grouplist, List<List<GoodsBean.DataBean.ListBean>> childlist) {
        this.context = context;
        this.grouplist = grouplist;
        this.childlist = childlist;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return grouplist.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childlist.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grouplist.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childlist.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view;
        GroupViewHolder holder;
        if(convertView==null){
            holder=new GroupViewHolder();
            view=inflater.inflate(R.layout.group_item,null );
            holder.tv_group=view.findViewById(R.id.tv_group);
            view.setTag(holder);
        }else{
            view=convertView;
            holder= (GroupViewHolder) view.getTag();
        }
        GoodsBean.DataBean dataBean = grouplist.get(groupPosition);
        holder.tv_group.setText(dataBean.getName());
        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view;
        ChildViewHolder holder;
        if(convertView==null){
            holder=new ChildViewHolder();
            view=inflater.inflate(R.layout.child_item,null);
            holder.rv=view.findViewById(R.id.rv);
            view.setTag(holder);
        }else{
            view=convertView;
            holder= (ChildViewHolder) view.getTag();
        }
        List<GoodsBean.DataBean.ListBean> listBeans = childlist.get(groupPosition);
        holder.rv.setLayoutManager(new GridLayoutManager(context,3));//设置布局管理器
        //设置适配器
        ElvRvAdapter elvRvAdapter = new ElvRvAdapter(context, listBeans);
        holder.rv.setAdapter(elvRvAdapter);
        elvRvAdapter.setOnItemClickListener(new ElvRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(GoodsBean.DataBean.ListBean listBean) {
                Intent intent = new Intent(context, XiangQingActivity.class);
                intent.putExtra("pscid",listBean.getPscid()+"");
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupViewHolder{
        TextView tv_group;
    }
    class ChildViewHolder{
        RecyclerView rv;
    }


}
