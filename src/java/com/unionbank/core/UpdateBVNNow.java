/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.unionbank.webpay.db.dao.BVNformData;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.Mailer;
import com.unionbank.webpay.utils.PBEncrytor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aojinadu
 */
public class UpdateBVNNow {

    PBEncrytor Pb = new PBEncrytor();
    Mailer mail = new Mailer();
    private Settings settings = Settings.getInstance("");
    String message = null;
    String user = this.settings.getProperty("user-user");
    String password = this.Pb.PBDecrypt(this.settings.getProperty("password-password"));
    String host_host = this.settings.getProperty("host-host");
    String user_live = this.settings.getProperty("user-live");
    String password_live = this.Pb.PBDecrypt(this.settings.getProperty("password-live"));
    String host_live = this.settings.getProperty("host-live");
    String user_alert = this.settings.getProperty("user-alert");
    String password_alert = this.Pb.PBDecrypt(this.settings.getProperty("password-alert"));
    String host_alert = this.settings.getProperty("host-alert");

    public boolean processBVNUpdateRequest(BVNformData obj, String BvNumber, String txnId, String maker, String branch) {
        Boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String MESSAGE_ID = "";

        String mainTxID = obj.getMainTxID();
        String displayname = obj.getDisplayname();
        String Branch = obj.getBranch();
        String oldBvNumber = obj.getOldBvNumber();
        String oldFirstName = obj.getOldFirstName();
        String newFirstName = obj.getNewFirstName();
        String firstNameComment = obj.getFirstNameComment();
        String oldMiddleName = obj.getOldMiddleName();
        String newMiddleName = obj.getNewMiddleName();
        String MiddleComment = obj.getMiddleComment();
        String oldLastName = obj.getOldLastName();
        String newLastName = obj.getNewLastName();
        String LastComment = obj.getLastComment();
        String oldDOBName = obj.getOldDOBName();
        String newDOBName = obj.getNewDOBName();
        String DOBComment = obj.getDOBComment();
        String oldPhoneNumber = obj.getOldPhoneNumber();
        String newPhoneNumber = obj.getNewPhoneNumber();
        String phoneNOComment = obj.getPhoneNOComment();
        String oldEmailAdd = obj.getOldEmailAdd();
        String newEmailAdd = obj.getNewEmailAdd();
        String emailComment = obj.getEmailComment();
        String oldStateOfOrigin = obj.getOldStateOfOrigin();
        String newStateOfOrigin = obj.getNewStateOfOrigin();
        String stateOfOriginComment = obj.getStateOfOriginComment();
        String oldLGA = obj.getOldLGA();
        String newLGA = obj.getNewLGA();
        String lgaComment = obj.getLgaComment();
        String oldMaritalStatus = obj.getOldMaritalStatus();
        String newMaritalStatus = obj.getNewMaritalStatus();
        String maritalStatusComment = obj.getMaritalStatusComment();
        String oldResidentialStatus = obj.getOldResidentialStatus();
        String newResidentialStatus = obj.getNewResidentialStatus();
        String residentialStatusComment = obj.getResidentialStatusComment();
        String oldGender = obj.getOldGender();
        String newGender = obj.getNewGender();
        String commentGender = obj.getCommentGender();
        String bankOfEnrollment = obj.getBankOfEnrollment();
        String branchOfEnrollment = obj.getBranchOfEnrollment();
        String title = obj.getTitle();
        String newTitle = obj.getNewTitle();
        String commentTitle = obj.getCommentTitle();
        String watchlisted = obj.getWatchlisted();
        String fFirstName = obj.getfFirstName();
        String fMiddleName = obj.getfMiddleName();
        String fLastName = obj.getfLastName();
        String fDob = obj.getfDob();
        String fPhoneNumber = obj.getfPhoneNumber();
        String fEmail = obj.getfEmail();
        String fStateOrigin = obj.getfStateOrigin();
        String fLga = obj.getfLga();
        String fMaritalstat = obj.getfMaritalstat();
        String fResidentialadd = obj.getfResidentialadd();
        String fGender = obj.getfGender();
        String userEmail = obj.getUserEmail();
        String PicsPath1 = obj.getPicsPath1();
		String PicsPath2 = obj.getPicsPath2();
		String PicsPath3 = obj.getPicsPath3();

        java.sql.Date oldDateConverted = obj.getOldDateConverted();
        java.sql.Date newDateConverted = obj.getNewDateConverted();

        java.util.Date date1 = null;
        java.util.Date date2 = null;

        try {
            System.out.println("got mainTxID 33 <<>> " + mainTxID);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);

            String query = "INSERT INTO customer_update_req  ( oldFirstName,newFirstName,oldMiddleName, newMiddleName,oldLastName,newLastName,oldPhoneNumber,newPhoneNumber,oldEmailAdd,newEmailAdd,BvNumber,newDateOfBirth,oldDateOfBirth,firstNameComment,MiddleComment,LastnameComment,DOBComment,phoneNOComment,emailComment, REQUEST_ID,MARKER,MARKERBRANCHCODE,TXNID,oldStateOfOrigin,newStateOfOrigin,stateOfOriginComment,oldLGA,newLGA,lgaComment,oldMaritalStatus,newMaritalStatus,maritalStatusComment,oldResidentialStatus,newResidentialStatus,residentialStatusComment,oldGender,newGender,commentGender,ffirstname, fmiddlename,flastname,fdob,fmaritalstatus,fgender,fphonenumber,femail,flga,fresidentialadd,fstateoforigin,MAKEREMAILADD, title, watchlisted, newtitle, commenttitle, uploadpath1, uploadpath2, uploadpath3)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, oldFirstName);
            pstmt.setString(2, newFirstName);
            pstmt.setString(3, oldMiddleName);
            pstmt.setString(4, newMiddleName);
            pstmt.setString(5, oldLastName);
            pstmt.setString(6, newLastName);
            pstmt.setString(7, oldPhoneNumber);
            pstmt.setString(8, newPhoneNumber);
            pstmt.setString(9, oldEmailAdd);
            pstmt.setString(10, newEmailAdd);
            pstmt.setString(11, oldBvNumber);

            pstmt.setDate(12, newDateConverted);
            pstmt.setDate(13, oldDateConverted);
            System.out.println("newDateConverted 4 <<>>>" + newDateConverted);
            System.out.println("oldDateConverted 4 <<>>>" + oldDateConverted);
            pstmt.setString(14, firstNameComment);
            pstmt.setString(15, MiddleComment);
            pstmt.setString(16, LastComment);
            pstmt.setString(17, DOBComment);
            pstmt.setString(18, phoneNOComment);
            pstmt.setString(19, emailComment);
            pstmt.setString(20, mainTxID);
            pstmt.setString(21, displayname);
            pstmt.setString(22, Branch);
            pstmt.setString(23, gettxnRefsqquences());
            pstmt.setString(24, oldStateOfOrigin);
            pstmt.setString(25, newStateOfOrigin);
            pstmt.setString(26, stateOfOriginComment);
            pstmt.setString(27, oldLGA);
            pstmt.setString(28, newLGA);
            pstmt.setString(29, lgaComment);
            pstmt.setString(30, oldMaritalStatus);
            pstmt.setString(31, newMaritalStatus);
            pstmt.setString(32, maritalStatusComment);
            pstmt.setString(33, oldResidentialStatus);
            pstmt.setString(34, newResidentialStatus);
            pstmt.setString(35, residentialStatusComment);
            pstmt.setString(36, oldGender);
            pstmt.setString(37, newGender);
            pstmt.setString(38, commentGender);

            pstmt.setString(39, fFirstName);
            pstmt.setString(40, fMiddleName);
            pstmt.setString(41, fLastName);
            pstmt.setString(42, fDob);
            pstmt.setString(43, fMaritalstat);
            pstmt.setString(44, fGender);
            pstmt.setString(45, fPhoneNumber);
            pstmt.setString(46, fEmail);
            pstmt.setString(47, fLga);
            pstmt.setString(48, fResidentialadd);
            pstmt.setString(49, fStateOrigin);
            pstmt.setString(50, userEmail);
            pstmt.setString(51, title);
            pstmt.setString(52, watchlisted);
            pstmt.setString(53, newTitle);
            pstmt.setString(54, commentTitle);
            pstmt.setString(55, PicsPath1);
			pstmt.setString(56, PicsPath2);
			pstmt.setString(57, PicsPath3);

            System.out.println("query 222<<>>" + query);
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = Boolean.valueOf(true);
            }
            System.out.println("isupdate " + isupdate);
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception ex) {
            System.out.println("got exception ");
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();

                e.printStackTrace();
            }
        }
        return isupdate;
    }
    
    public String gettxnRefsqquences()
  {
    String refsequence = "";
    PreparedStatement pstmt = null;
    Connection conn = null;
    ResultSet rs = null;
    try
    {
      String query = "SELECT BVNUP_T_SEQ.NEXTVAL refsequence FROM DUAL";
      System.out.println("The Host-Host " + this.host_host);
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
      conn = DriverManager.getConnection(this.host_host, this.user, this.password);
      pstmt = conn.prepareStatement(query);
      if (pstmt.execute()) {
        rs = pstmt.getResultSet();
      } else {
        throw new Exception("Empty Prepared Statement");
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    int count = 0;
    try
    {
      while (rs.next())
      {
        System.out.println("In The While Loop " + this.host_host);
        count++;
        refsequence = rs.getString("refsequence");
      }
      if (pstmt != null) {
        pstmt.close();
      }
      if (rs != null) {
        rs.close();
      }
      if (conn != null) {
        conn.close();
      }
     
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      try
      {
        if (pstmt != null) {
          pstmt.close();
        }
        if (rs != null) {
          rs.close();
        }
        if (conn != null) {
          conn.close();
        }
      }
      catch (SQLException ex)
      {
        ex.printStackTrace();
      }
    }
     return refsequence;
  }
}
