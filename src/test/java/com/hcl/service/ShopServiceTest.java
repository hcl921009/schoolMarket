package com.hcl.service;

import com.hcl.BaseTest;
import com.hcl.dto.ShopExecution;
import com.hcl.entity.Area;
import com.hcl.entity.PersonInfo;
import com.hcl.entity.Shop;
import com.hcl.entity.ShopCategory;
import com.hcl.enums.ShopStateEnum;
import com.hcl.exceptions.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test

    public void testModifyShop()throws ShopOperationException,FileNotFoundException{
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的店铺名称");
        File shopImg = new File("C:\\Users\\Huo Chenlong\\Desktop\\工具\\1521099155830.jpg");
        InputStream shopImgInputStream = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.modifyShop(shop,shopImgInputStream,shopImg.getName());
        System.out.println("修改后的图片地址为：" + shopExecution.getShop().getShopImg());

    }
    @Test

    public void testAddShop() throws FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        //shop.setShopId(3L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试店铺1");
        shop.setShopDesc("test1");
        shop.setShopAddr("testLocation1");
        shop.setPhone("testNum1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHENCK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("C:\\Users\\Huo Chenlong\\Desktop\\工具\\Test_V0_x1_y25.png");
        InputStream shopImgInputStream = new FileInputStream(shopImg);
        ShopExecution se =  shopService.addShop(shop,shopImgInputStream,shopImg.getName());
        assertEquals(ShopStateEnum.CHENCK.getState(),se.getState());
    }

}
