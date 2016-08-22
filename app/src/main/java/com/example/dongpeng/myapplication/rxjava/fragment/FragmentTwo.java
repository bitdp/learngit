package com.example.dongpeng.myapplication.rxjava.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dongpeng.myapplication.R;
import com.example.dongpeng.myapplication.rxjava.util.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by dongpeng on 2016/8/22.
 */
public class FragmentTwo extends Fragment {
    @BindView(R.id.button)
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rx_layout, container, false);
        RxBus.getInstance().toObservable(String.class).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                button.setText(s);
                Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
            }
        });
        ButterKnife.bind(this, view);
        return view;
    }
}
