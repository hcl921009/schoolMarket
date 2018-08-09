package com.hcl.dto;

import com.hcl.entity.Shop;
import com.hcl.enums.ShopStateEnum;

import java.util.List;

//用于存储店铺操作的各种状态，比如新建是否成功等
public class ShopExecution {
    private int state;//结果状态信息
    private String stateInfo;//状态信息的文字解释
    private int count;//店铺数量
    private Shop shop;//操作的具体shop（用于增删改店铺时使用）
    private List<Shop> shopList;//shop列表（用于查询店铺使用，可能查询出多个店铺）

    public ShopExecution() {
    }

    //用于操作失败时调用的构造器
    public ShopExecution(ShopStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();

    }

    //用于操作成功时调用的构造器
    public ShopExecution(ShopStateEnum stateEnum,Shop shop) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }

    //用于查询操作成功时调用的构造器
    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
