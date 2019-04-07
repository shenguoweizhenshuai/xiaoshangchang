package com.bawei.shengguowei20190308.bean;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/7 11:04
 * @Description：描述信息
 */
public class Three {
    private Two mlss;
    private Two pzsh;
    private Two rxxp;

    public Three(Two mlss, Two pzsh, Two rxxp) {
        this.mlss = mlss;
        this.pzsh = pzsh;
        this.rxxp = rxxp;
    }

    public Two getMlss() {
        return mlss;
    }

    public void setMlss(Two mlss) {
        this.mlss = mlss;
    }

    public Two getPzsh() {
        return pzsh;
    }

    public void setPzsh(Two pzsh) {
        this.pzsh = pzsh;
    }

    public Two getRxxp() {
        return rxxp;
    }

    public void setRxxp(Two rxxp) {
        this.rxxp = rxxp;
    }

    @Override
    public String toString() {
        return "Three{" +
                "mlss=" + mlss +
                ", pzsh=" + pzsh +
                ", rxxp=" + rxxp +
                '}';
    }
}
