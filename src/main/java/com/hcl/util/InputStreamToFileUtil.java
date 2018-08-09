package com.hcl.util;

import javax.imageio.IIOException;
import java.io.*;

public class InputStreamToFileUtil {
    public static void inputStreamToFile(InputStream ins,File file){
        FileOutputStream os = null;
        try{
            os = new FileOutputStream(file);
            int byteRead = 0;
            byte[] buffer = new byte[1024];
            while((byteRead = ins.read(buffer)) != -1){
                os.write(buffer,0,byteRead);
            }
        }catch (Exception e){
            throw new RuntimeException("调用inputStreamToFile产生异常：" + e.getMessage());
        }finally {
            {
                try {
                    if(os != null){
                        os.close();
                    }
                    if(ins != null){
                        ins.close();
                    }
                }catch (IOException e){
                    throw  new RuntimeException("inputStreamToFile关闭IO产生异常"+e.getLocalizedMessage());
                }
            }
        }
    }

}
