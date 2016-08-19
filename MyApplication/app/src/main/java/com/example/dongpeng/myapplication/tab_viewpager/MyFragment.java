package com.example.dongpeng.myapplication.tab_viewpager;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dongpeng.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dongpeng on 2016/8/19.
 */
public class MyFragment extends Fragment {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment_lay, container, false);
        ButterKnife.bind(this, view);
        List<String> data=new ArrayList<>();
        for(int i=0;i<20;i++){
            data.add("HelloWorld");
            data.add("NiHaoShiJie");
        }
        MyRecycleAdapter adapter=new MyRecycleAdapter(data);
        GridLayoutManager manager=new GridLayoutManager(getActivity(),3);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new MyItemTouchHelper(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recycleView);
        return view;
    }
}
