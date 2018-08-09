package com.hcl.service;

import com.hcl.BaseTest;
import com.hcl.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.Assert.assertEquals;

public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Test
    public void testGetShopCategory(){
        ShopCategory shopCategoryCondition = new ShopCategory();
        shopCategoryCondition.setShopCategoryName("奶茶咖啡");
        shopCategoryService.getShopCategoryList(shopCategoryCondition).toString();
    }
}
