package com.example.dongpeng.myapplication.fresco;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dongpeng.myapplication.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by dongpeng on 2016/8/19.
 */
public class MyFrescoAdapter extends RecyclerView.Adapter<MyFrescoAdapter.MyViewHolder> {
    List<String> data;
    Context context;
    public MyFrescoAdapter(Context context,List<String> data) {
        this.context=context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fresco_item, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.fresco_view.setImageURI(data.get(position));
        holder.fresco_view.setAspectRatio(2F);
//        FrescoUtils.loadUrl(data.get(position),holder.fresco_view,new BlurPostprocessor(context,10,1),50,50,null);
//        FrescoUtils.loadRes(R.mipmap.b,holder.fresco_view,new BlurPostprocessor(context,50,1),50,50,null);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView fresco_view;
        ImageView fresco_iv;
        public MyViewHolder(View itemView) {
            super(itemView);
            fresco_view = (SimpleDraweeView) itemView.findViewById(R.id.fresco_view);
            fresco_iv= (ImageView) itemView.findViewById(R.id.fresco_iv);
        }
    }
}
