package com.example.dongpeng.myapplication.rxjava.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dongpeng.myapplication.R;
import com.example.dongpeng.myapplication.rxjava.util.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dongpeng on 2016/8/22.
 */
public class FragmentOne extends Fragment {
    private int page=1;
    @BindView(R.id.button)
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rx_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button)
    public void onClick() {
        RxBus.getInstance().post(""+page);
        page+=1;
    }
}
