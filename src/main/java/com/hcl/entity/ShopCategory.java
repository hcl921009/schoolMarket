package com.hcl.entity;
/*
    店铺类别实体类
    包括ID、名称、描述、图片、创建时间、修改时间、上级大类ID、权重
 */

import java.util.Date;

public class ShopCategory {
    private Long shopCategoryId;//店铺ID
    private Long shopCategoryImg;//店铺图片链接
    private String shopCategoryName;//店铺名称
    private String shopCategoryDesc;//店铺描述
    private Integer priority;//店铺优先级
    private Date createTime;//创建时间
    private Date lastEditTime;//修改时间
    private ShopCategory parent;//上级大类ID

    public ShopCategory getParent() {
        return parent;
    }

    public void setParent(ShopCategory parent) {
        this.parent = parent;
    }

    public Long getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Long shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public Long getShopCategoryImg() {
        return shopCategoryImg;
    }

    public void setShopCategoryImg(Long shopCategoryImg) {
        this.shopCategoryImg = shopCategoryImg;
    }

    public String getShopCategoryName() {
        return shopCategoryName;
    }

    public void setShopCategoryName(String shopCategoryName) {
        this.shopCategoryName = shopCategoryName;
    }

    public String getShopCategoryDesc() {
        return shopCategoryDesc;
    }

    public void setShopCategoryDesc(String shopCategoryDesc) {
        this.shopCategoryDesc = shopCategoryDesc;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
