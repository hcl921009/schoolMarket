package com.hcl.service.impl;

import com.hcl.dao.ProductCategoryDao;
import com.hcl.entity.ProductCategory;
import com.hcl.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> getProductCategoryList(long shopId) {
        return productCategoryDao.queryProductCategoryList(shopId);
    }
}
