/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


/**
 *
 * @author baadedeji
 */
public class AESEncrypDecrypt {
    
  public static byte[] encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string: "+Base64.encodeBase64(encrypted));

            return Base64.encodeBase64(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted.getBytes()));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    
public static String SHA256Hashing(String tobeHashed) throws NoSuchAlgorithmException{
    	String username = "032";
        String password = "UnE6zh]T1Bd00Q[%";
    	String dateNow = "20180530";
        tobeHashed = username+dateNow+password;
        System.out.println("tobeHashed is::::: " +tobeHashed);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(tobeHashed.getBytes());
        
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
     
        System.out.println("Hex format : " + sb.toString());
        
        //convert the byte to hex format method 2
//        StringBuffer hexString = new StringBuffer();
//    	for (int i=0;i<byteData.length;i++) {
//    		String hex=Integer.toHexString(0xff & byteData[i]);
//   	     	if(hex.length()==1) hexString.append('0');
//   	     	hexString.append(hex);
//    	}
//    	System.out.println("Hex format : " + hexString.toString());
        
        return sb.toString();
    }
    
    
    
    public static void main(String[] args) {
   
            //        String key = "Bar12345Bar12345"; // 128 bit key
//        String initVector = "RandomInitVector"; // 16 bytes IV
        
//        String key = "vNndlY7l8JpxOrBK"; // 128 bit key
//        String initVector = "noVZWCq1Jgk+vCyc"; // 16 bytes IV
//        
//        String Request = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ValidationRequest><BVN>22296458679</BVN></ValidationRequest>";
//        
//        System.out.println(encrypt(key, initVector,Request));
				String username = "032";
				String password = "UnE6zh]T1Bd00Q[%";
//				String originalInput = username+":"+password;
				String originalInput = username;
				String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
				System.out.println("The output is:::: " +encodedString);
				String decodedString = new String(Base64.decodeBase64(encodedString.getBytes()));
				System.out.println("Decoded is  >>" + decodedString);
//         System.out.println(decrypt(key, initVector,"dfd6e6dcb72f400385b099750f79c64436c5b97a0f776cebf8ff2f6abf31915f1b4911285229a541a7613487516439457a05d634eb80c2d8e292ed38a2b3b7e515be780018a00066dbe1e28d36580dc435630ded01a70c48eaaf0eb051786e3bd8b0e84645b5811b7e386b71d9a4ee88aa73489ec58341ae9a339714ca7f9751"));

////////        String username = "032";
////////        String password = "UnE6zh]T1Bd00Q[%";
////////        String dateNow = "20180530";
////////        String tobeHashed = username+dateNow+password;
////////
////////        System.out.println("Hash Result is::: " +SHA256Hashing(tobeHashed));
////////                } catch (NoSuchAlgorithmException ex) {
////////                    Logger.getLogger(AESEncrypDecrypt.class.getName()).log(Level.SEVERE, null, ex);
////////                }

//        String key = "vNndlY7l8JpxOrBK"; // 128 bit key
//        String initVector = "noVZWCq1Jgk+vCyc"; // 16 bytes IV
//        String tobeencrypted = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ValidationRequest><BVN>22451797306</BVN></ValidationRequest>";
//
//        System.out.println("The encryption value is:   " + encrypt(key, initVector, tobeencrypted));
        
//        System.out.println(decrypt(key, initVector,
//                encrypt(key, initVector, "Hello World")));

    }    
    
    
    
}
