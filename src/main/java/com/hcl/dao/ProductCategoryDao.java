package com.hcl.dao;

import com.hcl.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过shopId查询店铺类别
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList(long shopId);
 }