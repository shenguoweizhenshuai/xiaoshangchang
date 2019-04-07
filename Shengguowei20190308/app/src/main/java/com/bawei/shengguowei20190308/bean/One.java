package com.bawei.shengguowei20190308.bean;

/**
 * @Author：南方小酒馆°
 * @E-mail：
 * @Date：2019/3/7 11:02
 * @Description：描述信息
 */
public class One {
    private String commodityId;
    private String commodityName;
    private String masterPic;
    private String price;
    private String saleNum;

    public One(String commodityId, String commodityName, String masterPic, String price, String saleNum) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.masterPic = masterPic;
        this.price = price;
        this.saleNum = saleNum;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(String saleNum) {
        this.saleNum = saleNum;
    }

    @Override
    public String toString() {
        return "One{" +
                "commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                ", price='" + price + '\'' +
                ", saleNum='" + saleNum + '\'' +
                '}';
    }
}
