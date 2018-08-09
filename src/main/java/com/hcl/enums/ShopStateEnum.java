package com.hcl.enums;

public enum ShopStateEnum {
    CHENCK(0,"审核中"),OFFLINE(-1,"非法店铺"),SUCCESS(1,"操作成功"),
    PASS(2,"通过认证"),INNER_ERROR(-1001,"内部系统错误"), NULL_SHOPID(-1002,"ShopID为空"),
    NULL_SHOP(-1003,"Shop信息为空"),NULL_AREA(-1004,"shopArea信息为空"),NULL_SHOPCATEGORY(-1005,"Shop类别信息为空");
    private int state;//结果状态信息
    private String stateInfo;//状态信息的文字解释

    private ShopStateEnum(int state,String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopStateEnum stateOf(int state){
        for(ShopStateEnum stateEnum : values()){
            if(stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
