package com.hcl.service;

import com.hcl.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 查询指定店铺下的所有商品类别信息
     * @param shopId
     * @return  List<ProductCategory>
     */
    List<ProductCategory> getProductCategoryList(long shopId);
}
