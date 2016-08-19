package com.example.dongpeng.myapplication.tab_viewpager;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by dongpeng on 2016/8/19.
 */
public class MyVPAdapter extends FragmentPagerAdapter {
    List<String> titles;
    List<MyFragment> fragments;
    public MyVPAdapter(FragmentManager fm, List<String> titles, List<MyFragment> fragments) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
