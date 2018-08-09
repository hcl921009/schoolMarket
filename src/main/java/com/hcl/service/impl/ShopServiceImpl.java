package com.hcl.service.impl;

import com.hcl.dao.ShopDao;
import com.hcl.dto.ShopExecution;
import com.hcl.entity.Shop;
import com.hcl.enums.ShopStateEnum;
import com.hcl.exceptions.ShopOperationException;
import com.hcl.service.ShopService;
import com.hcl.util.ImageUtil;
import com.hcl.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }

    /**
     * 需要判断是否处理图片，如果是，则删除原来的图片
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    @Override
    @Transactional
    public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException {
        if(shop == null || shopDao.queryByShopId(shop.getShopId()) == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }else {
            try {
                //1.判断是否需要处理图片
                if (shopImgInputStream != null && fileName != null && !fileName.equals("")) {
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if (tempShop.getShopImg() != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                //2.更新店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS, shop);
                }
            }catch (Exception e){
                throw new ShopOperationException("modifyShop error:" + e.getLocalizedMessage());
            }
        }
    }

    /**
     *添加商店，包括添加商店信息和商店图片
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName)throws ShopOperationException {
        //执行前判断传入的信息是否为空
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        if(shop.getShopCategory() == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOPCATEGORY);
        }
        if(shop.getArea() == null){
            return new ShopExecution(ShopStateEnum.NULL_AREA);
        }

        try{
            //开始初始化店铺信息
            shop.setEnableStatus(0);//初始化时店铺状态为审核中
            shop.setCreateTime(new Date());//创建时间为当前时刻
            shop.setLastEditTime(new Date());//最终修改时间为当前时刻
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if(effectedNum <= 0){
                throw new ShopOperationException("店铺创建失败");//运行时异常才支持事物特性，就是终止和回滚
            }else {
                if(shopImgInputStream != null){
                    //将图片处理为缩略图，并保存在指定位置,然后执行set方法保存图片地址，最后update到数据库
                    try {
                        addShopImg(shop, shopImgInputStream,fileName);//处理缩略图并执行set方法
                    } catch (Exception e) {
                        throw new ShopOperationException("addShopImg error"+e.getMessage());
                    }
                    effectedNum = shopDao.updateShop(shop);//执行update方法
                    if(effectedNum <= 0){
                        throw new ShopOperationException("更新图片地址失败：");
                    }
                }
            }
        }catch (Exception e){
            throw new ShopOperationException("addShop error:"+e.getMessage());
        }

        return new ShopExecution(ShopStateEnum.CHENCK,shop);
    }

    /**
     * 添加商店缩略图并更新到shop实体中
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @throws UnsupportedEncodingException
     */
    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) throws UnsupportedEncodingException {
        //获取shop图片的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
