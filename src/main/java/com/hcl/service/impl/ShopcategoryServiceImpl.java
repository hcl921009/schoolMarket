package com.hcl.service.impl;

import com.hcl.dao.ShopCategoryDao;
import com.hcl.entity.ShopCategory;
import com.hcl.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopcategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory ShopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(ShopCategoryCondition);

    }
}
