package com.bawei.shengguowei20190308.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/8 8:48
 * @Description：描述信息
 */
public abstract class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        initView();
        initData();
        bindEvent();

    }
    //布局
    public abstract int bindLayout();
    //控件
    protected abstract void initView();
    //数据
    protected abstract void initData();
    //监听事件
    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resid){
        return findViewById(resid);
    }
}
