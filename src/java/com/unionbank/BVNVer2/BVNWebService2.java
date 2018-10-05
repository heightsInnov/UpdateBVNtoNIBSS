/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unionbank.BVNVer2;

import com.unionbank.core.securityInteface;
import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author baadedeji
 */
@WebService(serviceName = "BVNWebService2")
public class BVNWebService2 {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
   //  @WebMethod(operationName = "updateBvnToCBA")
//    public String updateBvnToCBA(@WebParam(name = "BVN") String bvn, @WebParam(name = "customerid") String customerid) throws IOException, IllegalBlockSizeException, BadPaddingException {
//        securityInteface sd = new securityInteface();
//        String vbnResponse = "";
//        try {
//            System.out.println(".BvNumber<<>>" + bvn);
//            vbnResponse = sd.updatebvntoCBA(customerid,bvn);
//        } catch (java.lang.Exception e) {
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
            vbnResponse = sd.validateBvn2(bvn);
           // vbnResponse = sd.validateBvn(bvn);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        System.out.println("vbnResponse<<>>" + vbnResponse);
        return vbnResponse;
    }    
}
