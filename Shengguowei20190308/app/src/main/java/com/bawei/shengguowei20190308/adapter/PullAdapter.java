package com.bawei.shengguowei20190308.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.shengguowei20190308.R;
import com.bawei.shengguowei20190308.bean.One;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/8 10:05
 * @Description：描述信息
 */
public class PullAdapter extends BaseAdapter {

    private List<One> list;
    private Context context;

    public PullAdapter(ArrayList<One> list, Context context) {
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
        int type = getItemViewType(position);
        switch (type){
            case 0:
                ViewHolder1 holder1 = null;
                if (convertView==null){
                    convertView = View.inflate(context, R.layout.item_list,null);
                    holder1 = new ViewHolder1();
                    holder1.textView1 = convertView.findViewById(R.id.textview1);
                    holder1.imageView1 = convertView.findViewById(R.id.imageview1);
                    convertView.setTag(holder1);
                }else {
                    holder1 = (ViewHolder1) convertView.getTag();
                }
                One one = list.get(position);
                holder1.textView1.setText(one.getCommodityName());
                Glide.with(context).load("http://img.365jia.cn/uploads/special/tuku/201806/5b247f05646c345194.jpg").into(holder1.imageView1);
                break;
            case 1:
                ViewHolder2 holder2 = null;
                if (convertView==null){
                    convertView = View.inflate(context, R.layout.item2_list,null);
                    holder2 = new ViewHolder2();
                    holder2.textView2 = convertView.findViewById(R.id.textview2);
                    holder2.imageView2 = convertView.findViewById(R.id.imageview2);
                    convertView.setTag(holder2);
                }else {
                    holder2 = (ViewHolder2) convertView.getTag();
                }
                One one2 = list.get(position);
                holder2.textView2.setText(one2.getCommodityName());
                Glide.with(context).load("http://img.365jia.cn/uploads/special/tuku/201806/5b247f05646c345194.jpg").into(holder2.imageView2);
                break;
            case 2:
                ViewHolder3 holder3 = null;
                if (convertView==null){
                    convertView = View.inflate(context, R.layout.item3_list,null);
                    holder3 = new ViewHolder3();
                    holder3.textView3 = convertView.findViewById(R.id.textview3);
                    convertView.setTag(holder3);
                }else {
                    holder3 = (ViewHolder3) convertView.getTag();
                }
                One one3 = list.get(position);
                holder3.textView3.setText(one3.getCommodityName());
                break;
        }
        return convertView;
    }
   class ViewHolder1{
        private TextView textView1;
        private ImageView imageView1;
   }
    class ViewHolder2{
        private TextView textView2;
        private ImageView imageView2;
    }
    class ViewHolder3{
        private TextView textView3;
        private ImageView imageView3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }
}
