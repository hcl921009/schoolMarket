package com.hcl.dao;

import com.hcl.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    int insertShop(Shop shop);//插入操作，返回1为成功，-1为失败，由Mybatis自动返回

    int updateShop(Shop shop);//修改操作，返回值定义相同

    Shop queryByShopId(long shopId);//通过shopId来查询店铺信息

    /**
     * 分页查询店铺，检索条件包括：店铺名（模糊查询），店铺状态，店铺类别，区域ID，店铺创建者等
     * @param shopCondition
     * @param rowIndex 从第几行开始取数据
     * @param pageSize 范湖IDE条数
     * @return
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition,@Param("rowIndex") int rowIndex,@Param("pageSize") int pageSize);

    /**
     * 返回queryShopList的总数
     * @param shopConditon
     * @return
     */
    int queryShopCount(@Param("shopCondition")Shop shopConditon);
}



