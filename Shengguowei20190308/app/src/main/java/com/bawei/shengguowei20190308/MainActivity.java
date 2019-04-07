package com.bawei.shengguowei20190308;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.shengguowei20190308.base.BaseActivity;
import com.bawei.shengguowei20190308.frag.Frag01;
import com.bawei.shengguowei20190308.frag.Frag02;
import com.bawei.shengguowei20190308.frag.Frag03;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private RadioGroup radio_group;
    private Fragment frag;
    private Frag01 frag01;
    private Frag02 frag02;
    private Frag03 frag03;
    private FragmentManager manager;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        radio_group = bindView(R.id.radio_group);
    }

    @Override
    protected void initData() {
        frag01 = new Frag01();
        frag02 = new Frag02();
        frag03 = new Frag03();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frag,frag01)
                .add(R.id.frag,frag02)
                .add(R.id.frag,frag03)
                .show(frag01)
                .hide(frag02)
                .hide(frag03).commit();
    }

    @Override
    protected void bindEvent() {
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (checkedId){
                    case R.id.rb1:
                        transaction.show(frag01)
                                .hide(frag02)
                                .hide(frag03);
                        break;
                    case R.id.rb2:
                        transaction.show(frag02)
                                .hide(frag01)
                                .hide(frag03);
                        break;
                    case R.id.rb3:
                        transaction.show(frag03)
                                .hide(frag02)
                                .hide(frag01);
                        break;
                }
                transaction.commit();
            }
        });
    }
}
