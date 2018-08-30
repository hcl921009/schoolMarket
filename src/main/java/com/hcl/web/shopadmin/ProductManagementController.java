package com.hcl.web.shopadmin;

import com.hcl.dto.Result;
import com.hcl.entity.ProductCategory;
import com.hcl.entity.Shop;
import com.hcl.enums.ProductCategoryStateEnum;
import com.hcl.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/shopadmin")
public class ProductManagementController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/getproductcategorylist",method = RequestMethod.GET)
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request){
//        //TOBE REMOVED
//        Shop shop = new Shop();
//        shop.setShopId(1L);
//        request.getSession().setAttribute("currentShop",shop);

        Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
        List<ProductCategory> list = null;
        if(currentShop != null && currentShop.getShopId()>0){
            list = productCategoryService.getProductCategoryList(currentShop.getShopId());
            return new Result<List<ProductCategory>>(true,list);
        }else {
            ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
            return new Result<List<ProductCategory>>(false,ps.getState(),ps.getStateInfo());
        }
    }
}
