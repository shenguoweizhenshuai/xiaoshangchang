package com.bawei.shengguowei20190308.bean;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/7 11:05
 * @Description：描述信息
 */
public class Fore {
    private Three result;

    public Fore(Three result) {
        this.result = result;
    }

    public Three getResult() {
        return result;
    }

    public void setResult(Three result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Fore{" +
                "result=" + result +
                '}';
    }
}
