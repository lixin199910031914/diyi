package com.bawei.as.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.as.R;
import com.bumptech.glide.Glide;


import java.util.List;

public class ListAdapter extends BaseAdapter {
    List<Bean.ResultBean> resultBeans;
    Context context;

    public ListAdapter(List<Bean.ResultBean> resultBeans, Context context) {
        this.resultBeans = resultBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return resultBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if (holder==null){
                view=View.inflate(context, R.layout.item,null);
            holder=new ViewHolder();
            holder.name=view.findViewById(R.id.name);
            holder.img=view.findViewById(R.id.img);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        holder.name.setText(resultBeans.get(position).getCommodityName());
        Glide.with(context).load(resultBeans.get(position).getMasterPic()).into(holder.img);
        return view;
    }

    class ViewHolder{
        ImageView img;
        TextView name;
    }
}
