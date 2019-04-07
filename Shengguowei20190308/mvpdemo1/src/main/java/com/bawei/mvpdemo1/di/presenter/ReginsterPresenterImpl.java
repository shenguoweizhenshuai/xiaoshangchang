package com.bawei.mvpdemo1.di.presenter;

import com.bawei.mvpdemo1.di.model.IReginsterModel;
import com.bawei.mvpdemo1.di.model.ReginsterMedelImpI;
import com.bawei.mvpdemo1.di.view.IRegisterView;

import java.lang.ref.SoftReference;

/**
 * @Author：苏羡c
 * @E-mail：
 * @Date：2019/3/15 13:48
 * @Description：描述信息
 */
public class ReginsterPresenterImpl implements IRegisterPresenter{
    IRegisterView iRegisterView;
    private IReginsterModel model;
    private SoftReference<IReginsterModel> softReference;

    @Override
    public void attahView(IRegisterView iRegisterView) {
        //实例化
        this.iRegisterView=iRegisterView;
    //创建M层请求数据
        model = new ReginsterMedelImpI();
        //声明软引用
        softReference = new SoftReference<>(model);
    }

    @Override
    public void detachView(IRegisterView iRegisterView) {
        //把引用的对象回收
        softReference.clear();
    }

    @Override
    public void requsetData(String userName, String pwd) {
        model.getData(userName, pwd, new IReginsterModel.CallBack() {
            @Override
            public void responseData(String resposne) {
                iRegisterView.showData(resposne);
            }
        });
    }
}
