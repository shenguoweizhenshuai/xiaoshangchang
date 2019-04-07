package com.bawei.a313zuoye.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.a313zuoye.R;
import com.bawei.a313zuoye.bean.JsonBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/13 19:13
 * @Description：描述信息
 */
public class PullAdapter extends BaseAdapter {
    private Context context;
    private List<JsonBean.DataBean> list;

    public PullAdapter(Context context, List<JsonBean.DataBean> list) {
        this.context = context;
        this.list = list;
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
        ViewHolder holder;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.item_list,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image1);
            holder.textView = convertView.findViewById(R.id.text1);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        JsonBean.DataBean dataBean = list.get(position);
        holder.textView.setText(dataBean.getBook_info());
        Glide.with(context).load(dataBean.getBook_cover()).into(holder.imageView);
        return convertView;
    }

    class ViewHolder{
        private TextView textView;
        private ImageView imageView;
    }

}
