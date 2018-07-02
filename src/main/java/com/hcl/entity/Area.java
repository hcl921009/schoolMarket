package com.hcl.entity;


import java.util.Date;

public class Area {
    //成员变量都为引用类型是为了保证某个值为空时不会被设置默认值（例如int默认为0）
    private Integer areaId;//ID
    private String areaName;//区域名称
    private Integer priority;//区域优先级
    private Date creatTime;//创建时间
    private Date lastTime;//更新时间

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
