package com.bawei.shengguowei20190308.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bawei.shengguowei20190308.R;


import java.util.ArrayList;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/8 11:30
 * @Description：描述信息
 */
public class GridAdapter extends BaseAdapter {

    private ArrayList<String> list;
    private Context context;

    public GridAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item,null);
        TextView textView = convertView.findViewById(R.id.text1);
        textView.setText(list.get(position));
        return convertView;
    }
}
