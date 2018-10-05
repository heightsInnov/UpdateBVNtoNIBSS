/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.unionbank.ADService.ArrayOfstring;
import com.unionbank.ADService.UserProfile;

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
      // System.out.println("got here>>>>>>>>"+ cc.IsAuthenticate("aajibade", "Mayor=1234%", "moneygram"));
       String ee= cc.getUsrRolegetRolesForUser("baadedeji","bvnupdate");
        System.out.println("got here>>>>>>>>"+ee);
    }
    
    public String getUsrRolegetRolesForUser(java.lang.String user, java.lang.String moduleId) {
        boolean yes = false;
        String role="";
        ArrayOfstring arrayofUserRole = new ArrayOfstring();
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
        
        UserProfile Urs = new UserProfile();
        try {
          Urs=getUserProfile(user,  moduleId) ;
          
           System.out.println("got here>>>>>>>>"+role);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Urs;
    }
       
    private static Boolean adAuthenticate(java.lang.String user, java.lang.String password, java.lang.String moduleId) {
        com.unionbank.ADService.UBNSMSService_Service service = new com.unionbank.ADService.UBNSMSService_Service();
        com.unionbank.ADService.UBNSMSService port = service.getBasicHttpBindingUBNSMSService();
        return port.adAuthenticate(user, password, moduleId);
    }

    private static ArrayOfstring getRolesForUser(java.lang.String user, java.lang.String moduleId) {
        com.unionbank.ADService.UBNSMSService_Service service = new com.unionbank.ADService.UBNSMSService_Service();
        com.unionbank.ADService.UBNSMSService port = service.getBasicHttpBindingUBNSMSService();
        return port.getRolesForUser(user, moduleId);
    }

    private static UserProfile getUserProfile(java.lang.String user, java.lang.String moduleId) {
        com.unionbank.ADService.UBNSMSService_Service service = new com.unionbank.ADService.UBNSMSService_Service();
        com.unionbank.ADService.UBNSMSService port = service.getBasicHttpBindingUBNSMSService();
        return port.getUserProfile(user, moduleId);
    }

    private static Boolean isUserExist(java.lang.String user, java.lang.String moduleId) {
        com.unionbank.ADService.UBNSMSService_Service service = new com.unionbank.ADService.UBNSMSService_Service();
        com.unionbank.ADService.UBNSMSService port = service.getBasicHttpBindingUBNSMSService();
        return port.isUserExist(user, moduleId);
    }

    private static void removeUserFromRoles(java.lang.String user, com.unionbank.ADService.ArrayOfstring role, java.lang.String moduleId) {
        com.unionbank.ADService.UBNSMSService_Service service = new com.unionbank.ADService.UBNSMSService_Service();
        com.unionbank.ADService.UBNSMSService port = service.getBasicHttpBindingUBNSMSService();
        port.removeUserFromRoles(user, role, moduleId);
    }

    private static void addUserToRole(java.lang.String user, java.lang.String role, java.lang.String maker, java.lang.String checker, java.lang.String moduleId) {
        com.unionbank.ADService.UBNSMSService_Service service = new com.unionbank.ADService.UBNSMSService_Service();
        com.unionbank.ADService.UBNSMSService port = service.getBasicHttpBindingUBNSMSService();
        port.addUserToRole(user, role, maker, checker, moduleId);
    }

    private static String authorizeUserRole(java.lang.String user, java.lang.String role, java.lang.String checker, java.lang.Boolean isAuthorized, java.lang.String moduleId) {
        com.unionbank.ADService.UBNSMSService_Service service = new com.unionbank.ADService.UBNSMSService_Service();
        com.unionbank.ADService.UBNSMSService port = service.getBasicHttpBindingUBNSMSService();
        return port.authorizeUserRole(user, role, checker, isAuthorized, moduleId);
    }
 
}