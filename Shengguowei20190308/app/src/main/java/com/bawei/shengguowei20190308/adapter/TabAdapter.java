package com.bawei.shengguowei20190308.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/8 9:15
 * @Description：描述信息
 */
public class TabAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> listP;
    private ArrayList<String> listT;

    public TabAdapter(FragmentManager fm, ArrayList<Fragment> listP, ArrayList<String> listT) {
        super(fm);
        this.listP = listP;
        this.listT = listT;
    }

    @Override
    public Fragment getItem(int i) {
        return listP.get(i);
    }

    @Override
    public int getCount() {
        return listP.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return  listT.get(position);
    }
}
