package com.bawei.shengguowei20190308.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/8 8:52
 * @Description：描述信息
 */
public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(),container,false);
    }
    protected abstract int bindLayout();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        bindEvent();
    }

    //控件
    protected abstract void initView();
    //数据
    protected abstract void initData();
    //监听事件
    protected abstract void bindEvent();

    protected <T extends View> T bindView(int resId){
        return (T) getView().findViewById(resId);
    }
}
