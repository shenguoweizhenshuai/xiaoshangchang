package com.bawei.shengguowei20190308.frag;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.bawei.shengguowei20190308.R;
import com.bawei.shengguowei20190308.TwoActivity;
import com.bawei.shengguowei20190308.adapter.TabAdapter;
import com.bawei.shengguowei20190308.base.BaseFragment;
import com.bawei.shengguowei20190308.tab.Tab01;
import com.bawei.shengguowei20190308.tab.Tab02;
import com.bawei.shengguowei20190308.tab.Tab03;
import com.bawei.shengguowei20190308.tab.Tab04;
import com.bawei.shengguowei20190308.tab.Tab05;

import java.util.ArrayList;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/8 8:52
 * @Description：描述信息
 */
public class Frag01 extends BaseFragment {

    private TabLayout tabLayout;
    private ViewPager pager;
    private ArrayList<Fragment> listP;
    private ArrayList<String> listT;
    private TabAdapter adapter;
    private ImageView image;

    @Override
    protected int bindLayout() {
        return R.layout.frag01;
    }

    @Override
    protected void initView() {
        tabLayout = bindView(R.id.tab);
        pager = bindView(R.id.pager);
        image = bindView(R.id.image);
    }

    @Override
    protected void initData() {
        listP = new ArrayList<>();
        listP.add(new Tab01());
        listP.add(new Tab02());
        listP.add(new Tab03());
        listP.add(new Tab04());
        listP.add(new Tab05());
        listT = new ArrayList<>();
        listT.add("热点栏目");
        listT.add("视频");
        listT.add("隔离");
        listT.add("空心");
        listT.add("新时代");
        listT.add("全民的召唤");
        adapter = new TabAdapter(getActivity().getSupportFragmentManager(),listP,listT);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    protected void bindEvent() {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TwoActivity.class);
                intent.putStringArrayListExtra("key",listT);
                startActivityForResult(intent,100);
            }
        });
    }
}
