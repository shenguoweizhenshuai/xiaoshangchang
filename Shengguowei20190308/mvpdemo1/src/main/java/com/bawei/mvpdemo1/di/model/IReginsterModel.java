package com.bawei.mvpdemo1.di.model;

/**
 * @Author：苏羡c
 * @E-mail：
 * @Date：2019/3/15 13:40
 * @Description：描述信息
 */
public interface IReginsterModel {
    //获取数据
    public void getData(String name,String pswd,CallBack callBack);
    public interface CallBack{
        public void responseData(String resposne);
    }

}
