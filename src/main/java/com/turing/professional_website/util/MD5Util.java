package com.turing.professional_website.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jack
 * @date 2019-03-23-10:45
 */

public class MD5Util {

    public static String getHexPassword(String password){

        //MD5加密密码在数据库进行密码比对
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md5.update(password.getBytes());
        String hexPassword = new BigInteger(1, md5.digest()).toString(16);
        return hexPassword;

    }

}
