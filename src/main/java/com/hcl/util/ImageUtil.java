package com.hcl.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();//获取classpath下的图片路径
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random random = new Random();

    /**
     * 将用户上传的图片变为缩略图并保存在指定位置
     * @param thumbnailInputStream
     * @param fileName
     * @param targetAddr
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String fileName,String targetAddr) throws UnsupportedEncodingException {
        //为缩略图的文件进行初始化，包括命名、扩展名识别、建立存储路径上的文件夹、构造文件绝对路径
        String realFileName = getRandomFileName();//获取随机名，因为用户上传的可能会有重名
        String extension = getFileEtension(fileName);//获取扩展名

        makeDirPath(targetAddr);//有可能文件夹为空，所以建立文件夹，如果已有则自动不建立

        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is:" + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is:" + PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("basePath is:" + basePath + "watermark.png");
        basePath = URLDecoder.decode(basePath, "utf8");
        try {
            Thumbnails.of(thumbnailInputStream).size(200,200).
            watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.png")),0.25f).
            outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+5位随机数
     * @return
     */
    public static String getRandomFileName() {
        int randnum = random.nextInt(89999) + 10000;//随机数在0到89999,加上10000，即为10000~99999
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + randnum;

    }

    /**
     * 获取扩展名
     * @param fileName
     * @return
     */
    private static String getFileEtension(String fileName) {
        String originalFileName = fileName;
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/hcl/xxx.jpg就意味着要创建路径上所有文件夹
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 通过判断参数是文件路径还是目录路径来确定是否删除文件，如果有文件则删除文件和路径，否则删除路径
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if(fileOrPath.exists()){
            if(fileOrPath.isDirectory()){
                File files[] = fileOrPath.listFiles();
                for(int i = 0;i<files.length;i++){
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }

    /**
     * 测试一下怎么用
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("C:\\Users\\Huo Chenlong\\Desktop\\工具\\蓝底大龙.JPG")).size(200, 200).
                watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.png")), 0.25f).
                outputQuality(0.8f).toFile("C:\\Users\\Huo Chenlong\\Desktop\\工具\\蓝底大龙水印.jpg");
    }

}
