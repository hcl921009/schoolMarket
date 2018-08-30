package com.hcl.dao;

import com.hcl.BaseTest;
import com.hcl.entity.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryDaoTest extends BaseTest {
    @Autowired
    private  ProductCategoryDao productCategoryDao;

    @Test
    public void testQueryByShopId() throws Exception{
        long shopId =1 ;
        List<ProductCategory> productCategoryList = productCategoryDao.queryProductCategoryList(shopId);
        System.out.println("该店铺自定义类别数为：" + productCategoryList.size());
    }
}
