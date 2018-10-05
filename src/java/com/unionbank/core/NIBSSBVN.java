/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author aajibade
 */
@WebService(serviceName = "NIBSSBVN")
public class NIBSSBVN {

  //  @WebMethod(operationName = "VerifySingleBVN")
//    public String VerifySingleBVN(@WebParam(name = "BVN") String bvn) throws IOException, IllegalBlockSizeException, BadPaddingException {
//        securityInteface sd = new securityInteface();
//        String vbnResponse = "";
//        try {
//            System.out.println(".BvNumber<<>>" + bvn);
//            vbnResponse = sd.validateBvn(bvn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("vbnResponse<<>>" + vbnResponse);
//        return vbnResponse;
//    }
//    
//    @WebMethod(operationName = "updateBvnToCBA")
//    public String updateBvnToCBA(@WebParam(name = "BVN") String bvn, @WebParam(name = "customerid") String customerid) throws IOException, IllegalBlockSizeException, BadPaddingException {
//        securityInteface sd = new securityInteface();
//        String vbnResponse = "";
//        try {
//            System.out.println(".BvNumber<<>>" + bvn);
//            vbnResponse = sd.updatebvntoCBA(customerid,bvn);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("vbnResponse<<>>" + vbnResponse);
//        return vbnResponse;
//    }    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidateSingleBVN")
    public String ValidateSingleBVN(@WebParam(name = "BVN") String bvn) throws IOException, IllegalBlockSizeException, BadPaddingException {
        securityInteface sd = new securityInteface();
        String vbnResponse = "";
        try {
            System.out.println(".BvNumber<<>>" + bvn);
            vbnResponse = sd.validateBvn(bvn);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        System.out.println("vbnResponse<<>>" + vbnResponse);
        return vbnResponse;
    }    
}