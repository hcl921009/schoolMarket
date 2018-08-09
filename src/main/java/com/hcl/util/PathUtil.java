package com.hcl.util;

public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    //指定图片存储的绝对路径
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "G:/视频教程/项目/77、SSM到Spring Boot 从零开发校园商铺平台/图片仓库";
        }else{
            basePath = "/home/a/image";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }
    public static String getShopImagePath(long shopId){
        String imagePath = "/upload/item/shop/" + shopId +"/";
        return imagePath.replace("/",seperator);
    }
}
