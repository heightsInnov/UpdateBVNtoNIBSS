/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import org.datacontract.schemas._2004._07.ubn_security.UserProfile;

/**
 *
 * @author aajibade
 */
public class UserManagement {

    public Boolean IsAuthenticate(java.lang.String user, java.lang.String password, java.lang.String moduleId)  {
        boolean yes = false;
        try {
           yes= adAuthenticate(user,password,moduleId);
           
           isUserExist( user, moduleId) ;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return yes;
    }
    public Boolean IscheckExist(java.lang.String user, java.lang.String moduleId)  {
        boolean yes = false;
        try {
           yes= isUserExist(user,moduleId);           
           //isUserExist(java.lang.String user, java.lang.String moduleId) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return yes;
    }
    
    
    public static void main(String[] args) {
        UserManagement cc = new UserManagement();
       System.out.println("got here>>>>>>>>"+ cc.IsAuthenticate("aajibade", "Mayor=1234%", "moneygram"));
       String ee= cc.getUsrRolegetRolesForUser("baadedeji","moneygram");
      //  System.out.println("got here>>>>>>>>"+ee);
    }
    
    public String getUsrRolegetRolesForUser(java.lang.String user, java.lang.String moduleId) {
        boolean yes = false;
        String role="";
        com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring arrayofUserRole = new ArrayOfstring();
        try {
           arrayofUserRole= getRolesForUser(user,moduleId);
           role= arrayofUserRole.getString().get(0).toLowerCase();
           System.out.println("got here>>>>>>>>"+role);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return role;
    }

    
    public UserProfile getUsrDetails(java.lang.String user, java.lang.String moduleId) {
        boolean yes = false;
        String role="";
        
        org.datacontract.schemas._2004._07.ubn_security.UserProfile Urs = new UserProfile();
        try {
          Urs=getUserProfile(user,  moduleId) ;
          
           System.out.println("got here>>>>>>>>"+role);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Urs;
    }

       

    private static Boolean adAuthenticate(java.lang.String user, java.lang.String password, java.lang.String moduleId) {
       com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService service = new com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService();
        com.unionbankng.applications.ws.UBNSMSService port = service.getBasicHttpBindingUBNSMSServiceQSPort();
        return port.adAuthenticate(user, password, moduleId);
    }

    private static ArrayOfstring getRolesForUser(java.lang.String user, java.lang.String moduleId) {
       com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService service = new com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService();
        com.unionbankng.applications.ws.UBNSMSService port = service.getBasicHttpBindingUBNSMSServiceQSPort();
        return port.getRolesForUser(user, moduleId);
    }

    private static UserProfile getUserProfile(java.lang.String user, java.lang.String moduleId) {
        com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService service = new com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService();
        com.unionbankng.applications.ws.UBNSMSService port = service.getBasicHttpBindingUBNSMSServiceQSPort();
        return port.getUserProfile(user, moduleId);
    }

    private static Boolean adAuthenticate_1(java.lang.String user, java.lang.String password, java.lang.String moduleId) {
       com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService service = new com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService();
        com.unionbankng.applications.ws.UBNSMSService port = service.getBasicHttpBindingUBNSMSServiceQSPort();
        return port.adAuthenticate(user, password, moduleId);
    }

    private static Boolean isUserExist(java.lang.String user, java.lang.String moduleId) {
         com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService service = new com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService();
        com.unionbankng.applications.ws.UBNSMSService port = service.getBasicHttpBindingUBNSMSServiceQSPort();
        return port.isUserExist(user, moduleId);
    }

    private static Boolean adAuthenticate_2(java.lang.String user, java.lang.String password, java.lang.String moduleId) {
        com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService service = new com.unionbankng.applications.ws.BasicHttpBindingUBNSMSServiceQSService();
        com.unionbankng.applications.ws.UBNSMSService port = service.getBasicHttpBindingUBNSMSServiceQSPort();
        return port.adAuthenticate(user, password, moduleId);
    }
}
