package com.bawei.a314day02;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/14 13:46
 * @Description：描述信息
 */
public class Presenter {
    //创建接口
    public interface Awei{
        void initData(String aaa);
    }
    public Awei awei;

    public void setAwei(Awei awei) {
        this.awei = awei;
    }
    public void sss(){
        String ss = "落叶未央";
        awei.initData(ss);
    }
}
