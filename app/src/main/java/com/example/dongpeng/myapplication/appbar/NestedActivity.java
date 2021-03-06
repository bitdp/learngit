package com.example.dongpeng.myapplication.appbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.example.dongpeng.myapplication.R;
import com.example.dongpeng.myapplication.tab_viewpager.MyFragment;
import com.example.dongpeng.myapplication.tab_viewpager.MyVPAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dongpeng on 2016/8/24.
 */
public class NestedActivity extends Activity {
    List<String> titles=new ArrayList<>();
    List<MyFragment> fragments=new ArrayList<>();
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appbar_layout);
        ButterKnife.bind(this);
        initTitle();
        initFragment();
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        MyVPAdapter myVPAdapter=new MyVPAdapter(getFragmentManager(),titles,fragments);
        vp.setAdapter(myVPAdapter);
        tabLayout.setupWithViewPager(vp);
    }

    private void initFragment() {
        for (int i=0;i<9;i++){
            fragments.add(new MyFragment());
        }
    }

    private void initTitle() {
        for (int i=0;i<3;i++){
            titles.add("苹果");
            titles.add("鸭梨");
            titles.add("大西瓜");
        }
    }
}
