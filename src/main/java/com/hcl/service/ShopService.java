package com.hcl.service;

import com.hcl.dto.ShopExecution;
import com.hcl.entity.Shop;
import com.hcl.exceptions.ShopOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;


public interface ShopService {
    /**
     * 通过店铺ID获取店铺信息
     * @param shopId
     * @return
     */
    Shop getByShopId(long shopId);

    /**
     * 更新店铺信息，包括处理缩略图
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopExecution
     */
    ShopExecution modifyShop(Shop shop,InputStream shopImgInputStream,String fileName) throws ShopOperationException;

    /**
     *
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */

    ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName)throws ShopOperationException;
}
