package com.example.dell.a20190212.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.dell.a20190212.fragment.HomeFragment;
import com.example.dell.a20190212.fragment.MineFragment;
import com.example.dell.a20190212.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPageAdapter extends FragmentPagerAdapter {

    private String[] menus = new String[]{
            "预约", "首页", "我的"
    };

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {


        switch (i) {
            case 0:
                return new HomeFragment();
            case 1:
                return new VideoFragment();
            case 2:
                return new MineFragment();
            default:
                return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return menus[position];
    }

    @Override
    public int getCount() {
        return menus.length;
    }
}
