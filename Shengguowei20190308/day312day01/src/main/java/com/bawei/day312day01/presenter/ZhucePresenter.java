package com.bawei.day312day01.presenter;

import com.bawei.day312day01.Main2Activity;
import com.bawei.day312day01.model.ZhuceModel;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/13 15:03
 * @Description：描述信息
 */
public class ZhucePresenter {

    private final ZhuceModel zhuceModel;

    public ZhucePresenter(Main2Activity main2Activity) {
        zhuceModel = new ZhuceModel();
    }

    public void getData(String ed3, String ed4) {
        zhuceModel.getData(ed3,ed4);
    }
}
