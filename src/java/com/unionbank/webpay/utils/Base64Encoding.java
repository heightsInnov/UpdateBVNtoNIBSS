/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;


/**
 *
 * @author baadedeji
 */
public class Base64Encoding {
    
    
    public static void main(String[] args){
        
        // Encode data on your side using BASE64
//        String str = "032";
        String username = "032";
        String password = "UnE6zh]T1Bd00Q[%";
//        String tobeEncoded = username+":"+password;
//        byte[] bytesEncoded = Base64.encodeBase64(tobeEncoded.getBytes());
//        System.out.println("encoded value is " + new String(bytesEncoded));
//
//// Decode data on other side, by processing encoded data
//        byte[] valueDecoded = Base64.decodeBase64(bytesEncoded);
//        System.out.println("Decoded value is " + new String(valueDecoded));
		String auth = username +":"+ password;
        Date day = new Date();
        SimpleDateFormat datePartFormatter4 = new SimpleDateFormat("yyyyMMdd");
        System.out.println("Default Date is:::::  " + day);
        System.out.println("Formatted date is:::::  " + datePartFormatter4.format(day));
        String dateNow = datePartFormatter4.format(day);
        String signature = username+"20180727"+password;
        Base64Encoding benc = new Base64Encoding();
        benc.generateSHA256(signature);
		System.out.println("Authorisation is>>  "+auth);
    }
    
    
      public String generateSHA256(String password) {

        StringBuffer hexString = new StringBuffer();
       // String key = "7ACBD9E597D513B09D5FC0C985BE06BA";
        String tobehashed = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
           // tobehashed = key + password;
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            //   System.out.println("Hex format : " + sb.toString());
            //convert the byte to hex format method 2
            hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xff & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            //  System.out.println("Hex format : " + hexString.toString());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        System.out.println("Result>>>>> " + hexString.toString());
        return hexString.toString();

    }
}
