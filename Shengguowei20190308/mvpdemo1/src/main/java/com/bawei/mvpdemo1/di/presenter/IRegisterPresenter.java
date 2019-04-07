package com.bawei.mvpdemo1.di.presenter;

import com.bawei.mvpdemo1.di.view.IRegisterView;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/14 20:58
 * @Description：描述信息
 */
public interface IRegisterPresenter {
    //接收v层对象
    public void attahView(IRegisterView iRegisterView);
    //解绑v层对象
    public void detachView(IRegisterView iRegisterView);
    //交给M层进行数据请求
    public void requsetData(String userName,String pwd);
}
