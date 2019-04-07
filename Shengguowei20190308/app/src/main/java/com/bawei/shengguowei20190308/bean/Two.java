package com.bawei.shengguowei20190308.bean;

import java.util.ArrayList;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/7 11:03
 * @Description：描述信息
 */
public class Two {
    private ArrayList<One> commodityList;

    public Two(ArrayList<One> commodityList) {
        this.commodityList = commodityList;
    }

    public ArrayList<One> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(ArrayList<One> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "Two{" +
                "commodityList=" + commodityList +
                '}';
    }
}
