package com.wk.entity.vo;

/**
 * @className: com.wk.entity.vo.ProductInfoVo
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-25 12:33
 */
public class ProductInfoVo {
    //商品名称条件的封装
    private String pName;
    //商品类型条件的封装
    private Integer typeId;
    //最低价格的封装
    private Integer lPrice;
    //最高价格的封装
    private Integer hPrice;
    //设置页码
    private Integer page=1;

    public ProductInfoVo() {
    }

    public ProductInfoVo(String pName, Integer typeId, Integer lPrice, Integer hPrice, Integer page) {
        this.pName = pName;
        this.typeId = typeId;
        this.lPrice = lPrice;
        this.hPrice = hPrice;
        this.page = page;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getlPrice() {
        return lPrice;
    }

    public void setlPrice(Integer lPrice) {
        this.lPrice = lPrice;
    }

    public Integer gethPrice() {
        return hPrice;
    }

    public void sethPrice(Integer hPrice) {
        this.hPrice = hPrice;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "ProductInfoVo{" +
                "pName='" + pName + '\'' +
                ", typeId=" + typeId +
                ", lPrice=" + lPrice +
                ", hPrice=" + hPrice +
                ", page=" + page +
                '}';
    }
}
