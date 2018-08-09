package com.hcl.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request){
        String verfiyCodeExpected = (String)request.getSession().getAttribute(
                Constants.KAPTCHA_SESSION_KEY);
        String verfiyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if(verfiyCodeActual == null||!verfiyCodeActual.equals(verfiyCodeExpected)){
            return false;
        }
        return true;
    }

}
