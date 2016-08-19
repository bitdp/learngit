package com.example.dongpeng.myapplication.tab_viewpager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dongpeng.myapplication.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by dongpeng on 2016/8/19.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder> {
    List<String> data;
    public MyRecycleAdapter(List<String> data) {
        this.data=data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        holder.tv.setText(data.get(position));
        if (data.get(position).equals("HelloWorld")){
            holder.iv.setImageResource(R.mipmap.a);
        }else {
            holder.iv.setImageResource(R.mipmap.b);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void moveItem(int fromPosition, int toPosition) {
        Collections.swap(data,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv);
            tv= (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
