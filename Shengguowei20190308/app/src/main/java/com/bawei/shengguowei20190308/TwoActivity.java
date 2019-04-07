package com.bawei.shengguowei20190308;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioGroup;

import com.bawei.shengguowei20190308.R;
import com.bawei.shengguowei20190308.adapter.GridAdapter;
import com.bawei.shengguowei20190308.base.BaseActivity;


import java.util.ArrayList;

public class TwoActivity extends BaseActivity implements View.OnClickListener {


    private GridView G1,G2;
    private ArrayList<String> list1,list2;
    private GridAdapter adapter1,adapter2;

    @Override
    public int bindLayout() {
        return R.layout.activity_two;
    }

    @Override
    protected void initView() {
        G1 = bindView(R.id.G1);
        G2 = bindView(R.id.G2);
        bindView(R.id.finish).setOnClickListener(this);
        bindView(R.id.backs).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        //g1的数据
        list1 = intent.getStringArrayListExtra("key");
        //g2的数据
        list2 = new ArrayList<>();
        for (int t=0;t<10;t++){
            list2.add("申国威"+t);
        }
        list2.removeAll(list1);
        //适配器
        adapter1 = new GridAdapter(list1,TwoActivity.this);
        adapter2 = new GridAdapter(list2,TwoActivity.this);
        G1.setAdapter(adapter1);
        G2.setAdapter(adapter2);
    }

    @Override
    protected void bindEvent() {
        G1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = list1.get(position);
                //删除内容
                list1.remove(position);
                list2.add(str);
                //刷新两个适配器
                adapter1.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();
            }
        });
        G2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = list2.get(position);
                //删除内容
                list2.remove(position);
                list1.add(str);
                //刷新两个适配器
                adapter1.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finish:
            case R.id.backs:
                Intent intent = new Intent();
                intent.putStringArrayListExtra("key",list1);
                setResult(200,intent);
                finish();
                break;
        }
    }
}
