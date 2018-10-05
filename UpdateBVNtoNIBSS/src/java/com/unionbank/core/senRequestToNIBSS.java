package com.unionbank.core;

import com.unionbank.webpay.db.dao.TransactionsDAO;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.LoggingUtil;
import com.unionbank.webpay.utils.PBEncrytor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.log4j.Logger;

public class senRequestToNIBSS extends TimerTask {

    static Logger logger = Logger.getLogger(senRequestToNIBSS.class);
    PBEncrytor Pb = new PBEncrytor();
    private Settings settings = Settings.getInstance("");
    String user = settings.getProperty("user-user");
    String password = Pb.PBDecrypt(settings.getProperty("password-password"));
    String host_host = settings.getProperty("host-host");
    Processor pbt = new Processor();

    private void Process() {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String computeRequest = "";
        String encriptRes = "";
        String clearResponse = "";
        String responseXCode = "";
        String TXNID = "";
        TransactionsDAO txn = new TransactionsDAO();
        securityInteface secInt = new securityInteface();
        try {
            String query = "select * from customer_update_req   where CHECKER is not null and APPROVALSTATUS ='Y'  and ISSENT_TO_NIBSS ='N'";
            System.out.println("The Host-Host " + host_host);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            pstmt = conn.prepareStatement(query);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
            } else {
                throw new Exception("Empty Prepared Statement");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LoggingUtil.logError(e, logger);
            e.printStackTrace();
        }
        int count = 0;
        try {
            while (rs.next()) {
                txn = new TransactionsDAO();
                TXNID = rs.getString("TXNID");
                if (TXNID == null) {
                    TXNID = "";
                }
                /*OLDFIRSTNAME         VARCHAR2(80 BYTE),
                 NEWFIRSTNAME         VARCHAR2(80 BYTE),
                 OLDMIDDLENAME        VARCHAR2(80 BYTE),
                 NEWMIDDLENAME        VARCHAR2(80 BYTE),
                 OLDLASTNAME          VARCHAR2(80 BYTE),
                 NEWLASTNAME          VARCHAR2(80 BYTE),
                 * 
                 OLDPHONENUMBER       VARCHAR2(80 BYTE),
                 NEWPHONENUMBER       VARCHAR2(80 BYTE),
                 * 
                 OLDEMAILADD          VARCHAR2(80 BYTE),
                 NEWEMAILADD          VARCHAR2(80 BYTE),
                 * 
                 BVNUMBER             VARCHAR2(80 BYTE),
                 NEWDATEOFBIRTH       DATE,
                 OLDDATEOFBIRTH       DATE,
                 * 
                 FIRSTNAMECOMMENT     VARCHAR2(250 BYTE),
                 * 
                 MIDDLECOMMENT        VARCHAR2(250 BYTE),
                 * 
                 LASTNAMECOMMENT      VARCHAR2(250 BYTE),
                 * 
                 DOBCOMMENT           VARCHAR2(250 BYTE),
                 * 
                 PHONENOCOMMENT       VARCHAR2(250 BYTE),
                 EMAILCOMMENT         VARCHAR2(250 BYTE),
                 REQUEST_ID           NUMBER(24),
                 RECEIVED_DATE        DATE                     DEFAULT sysdate,
                 APPROVALSTATUS       VARCHAR2(3 BYTE)         DEFAULT 'N',
                 APPROVE_REJECT_DATE  DATE,
                 MARKER               VARCHAR2(200 BYTE),
                 CHECKER              VARCHAR2(200 BYTE),
                 MARKERBRANCHCODE     VARCHAR2(10 BYTE),
                 CHECKERBRANCHCODE    VARCHAR2(10 BYTE),
                 TXNID                NUMBER,
                 ISSENT_TO_NIBSS      VARCHAR2(3 BYTE)         DEFAULT 'N',
                 DATE_SENT_TO_NIBSS   DATE*/
                txn.setBvNumber(rs.getString("BVNUMBER"));
                txn.setOldFirstName(rs.getString("OLDFIRSTNAME"));
                txn.setNewFirstName(rs.getString("NEWFIRSTNAME"));
                txn.setOldMiddleName(rs.getString("OLDMIDDLENAME"));
                txn.setNewMiddleName(rs.getString("NEWMIDDLENAME"));
                txn.setOldLastName(rs.getString("OLDLASTNAME"));
                txn.setNewLastName(rs.getString("NEWLASTNAME"));
                txn.setOldPhoneNumber(rs.getString("OLDPHONENUMBER"));
                txn.setNewPhoneNumber(rs.getString("NEWPHONENUMBER"));
                txn.setOldEmailAdd(rs.getString("OLDEMAILADD"));
                txn.setOldEmailAdd(rs.getString("NEWEMAILADD"));
                txn.setNewEmailAdd(rs.getString("NEWEMAILADD"));
                txn.setNewDateOfBirth(rs.getString("NEWDATEOFBIRTH"));
                txn.setOldDateOfBirth(rs.getString("OLDDATEOFBIRTH"));
                txn.setFirstNameComment(rs.getString("FIRSTNAMECOMMENT"));
                txn.setMiddleNameComment(rs.getString("MIDDLECOMMENT"));
                txn.setLastNameComment(rs.getString("LASTNAMECOMMENT"));
                txn.setDobComment(rs.getString("DOBCOMMENT"));
                txn.setPhoneNoComment(rs.getString("PHONENOCOMMENT"));
                txn.setEmailComment(rs.getString("EMAILCOMMENT"));


                computeRequest = computeRequest(txn);

                System.out.println("computeRequest " + computeRequest);
                /* if (!computeRequest.equals("")) {
                 encriptRes = secInt.updateencryptRequest(computeRequest);
                 clearResponse = secInt.decryptRequest(encriptRes);
                 responseXCode = pbt.getNodeValue("/UpdateResult/ResultStatus", clearResponse);
                 if (responseXCode == null) {
                 responseXCode = "";
                 }
                 System.out.println("responseXCode from NIBSS " + responseXCode);
                 if (responseXCode.trim().equals("00")) {
                 UpdateSucessful(TXNID);
                 }
                 }*/

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
        } catch (Exception ex) {
            ex.printStackTrace();
            LoggingUtil.logError(ex, logger);
            ex.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void UpdateSucessful(String srcID) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            String query = "UPDATE customer_update_req SET ISSENT_TO_NIBSS = 'Y', date_sent_to_nibss = sysdate "
                    + "WHERE TXNID = '" + srcID + "'";
            pstmt = conn.prepareStatement(query);
            System.out.println("query " + query);
            pstmt.execute();
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
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
            }
        }
    }

    public static void maing(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new senRequestToNIBSS(), 0, 500);

    }

    public static void main(String[] args) {
        senRequestToNIBSS gg = new senRequestToNIBSS();
        //gg.computeRequest();
        gg.Process();
        //  System.out.println("Aut<<>>" + gg.computeRequest());
    }
    
    public String dateConvert(String yyyymmdd) {
        Date today = null;
       // System.out.println((new StringBuilder()).append("yyyymmdd").append(yyyymmdd).toString());
       // System.out.println((new StringBuilder()).append("Input = ").append(yyyymmdd).toString());//1962-12-13
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");//05-MAY-1963
        try {
            today = df.parse(yyyymmdd.split(" ")[0]);
            System.out.println((new StringBuilder()).append("Today = ").append(sdf.format(today)).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sdf.format(today);
    }


    public String computeRequest(TransactionsDAO trans) {
        String response = "";

        String OldEmail = "", NewEmail = "", emailReasonForChange = "",
                OldFirstName = "", NewFirstName = "", fisrtReasonForChange = "",
                OldGender = "", NewGender = "", genderReasonForChange = "",
                OldLastName = "", NewLastName = "", lastReasonForChange = "",
                oldbirth = "", newBirth = "", birthReasonForChange = "",
                placeholder = "", newphone = "", oldphone = "", phonereason = "",
                OldMiddleName = "", NewMiddleName = "", middlereason = "";
        String bvn = trans.getBvNumber();
        if (bvn == null) {
            bvn = "";
        }
        OldEmail = trans.getOldEmailAdd();
        if (OldEmail == null) {
            OldEmail = "";
        }
        NewEmail = trans.getNewEmailAdd();
        if (NewEmail == null) {
            NewEmail = "";
        }
        if (oldphone == null) {
            oldphone = "";
        }

        emailReasonForChange = trans.getEmailComment();
        if (emailReasonForChange == null) {
            emailReasonForChange = "";
        }

        OldFirstName = trans.getOldFirstName();
        if (OldFirstName == null) {
            OldFirstName = "";
        }

        NewFirstName = trans.getNewFirstName();
        if (NewFirstName == null) {
            NewFirstName = "";
        }
        fisrtReasonForChange = trans.getFirstNameComment();
        if (fisrtReasonForChange == null) {
            fisrtReasonForChange = "";
        }

        OldGender = trans.getOldGender();
        if (OldGender == null) {
            OldGender = "";
        }

        NewGender = trans.getNewGender();
        if (NewGender == null) {
            NewGender = "";
        }
        genderReasonForChange = trans.getCommentGender();
        if (genderReasonForChange == null) {
            genderReasonForChange = "";
        }

        OldLastName = trans.getOldLastName();
        NewLastName = trans.getNewLastName();
        lastReasonForChange = trans.getLastNameComment();
        oldbirth = trans.getOldDateOfBirth();
        newBirth = trans.getNewDateOfBirth();
        newphone = trans.getNewPhoneNumber();
        oldphone = trans.getOldPhoneNumber();
        phonereason = trans.getPhoneNoComment();
        OldMiddleName = trans.getOldMiddleName();
        NewMiddleName = trans.getNewMiddleName();
        middlereason = trans.getMiddleNameComment();



        if (middlereason == null) {
            middlereason = "OK";
        }
        if (OldLastName == null) {
            OldLastName = "";
        }
        /*OldLastName = "", NewLastName = "", lastReasonForChange = "",
         oldbirth = "", newBirth = "", birthReasonForChange = "",
         placeholder = "", newphone = "", oldphone = "", phonereason = "",
         OldMiddleName = "", NewMiddleName = "", middlereason = "";*/
        if (oldbirth == null) {
            oldbirth = "";
        }
        if (phonereason == null) {
            phonereason = "OK";
        }

        if (lastReasonForChange == null) {
            lastReasonForChange = "OK";
        }
        if (newBirth == null) {
            newBirth = "";
        }
        if (NewLastName == null) {
            NewLastName = "";
        }
        if (NewFirstName == null) {
            NewFirstName = "";
        }
        if (oldphone == null) {
            oldphone = "";
        }
        if (newphone == null) {
            newphone = "";
        }
        if (OldMiddleName == null) {
            OldMiddleName = "";
        }
        if (NewMiddleName == null) {
            NewMiddleName = "";
        }
        if (emailReasonForChange == null) {
            emailReasonForChange = "OK";
        }

        if (emailReasonForChange.equals("")) {
            emailReasonForChange = "OK";
        }

        if (fisrtReasonForChange == null) {
            fisrtReasonForChange = "OK";
        }
        if (fisrtReasonForChange.equals("")) {
            fisrtReasonForChange = "OK";
        }

        if (genderReasonForChange == null) {
            genderReasonForChange = "OK";
        }
        if (lastReasonForChange == null) {
            lastReasonForChange = "OK";
        }
        if (birthReasonForChange == null) {
            birthReasonForChange = "OK";
        }
        if (birthReasonForChange.equals("")) {
            birthReasonForChange = "OK";
        }
        if (phonereason == null) {
            phonereason = "OK";
        }
        if (middlereason == null) {
            middlereason = "OK";
        }



        String level = "", emailLine = "", firstNameLine = "", genderline = "", lastNameline = "", birthdateline = "", phone1line = "", middleline = "";

        if (newBirth.equals("")) {
            newBirth = oldbirth;
        }
        
        
        if (NewLastName.equals("")) {
            NewLastName = OldLastName;
        }
        if (NewFirstName.equals("")) {
            NewFirstName = OldFirstName;
        }
        level = "<LevelOfAccount OldLevelOfAccount='Level 1'   NewLevelOfAccount='Level 1 - Low Level Accounts'  ReasonForChange='OK'  />";
        if (!OldEmail.equals("") && !NewEmail.equals("")) {
            emailLine = "<Email OldEmail='" + OldEmail + "'  NewEmail='" + NewEmail + "' ReasonForChange='" + emailReasonForChange + "' />";
        }
        if (!OldFirstName.equals("") && !NewFirstName.equals("")) {//
            firstNameLine = "<FirstName OldFirstName='" + OldFirstName + "' NewFirstName='" + NewFirstName + "' ReasonForChange='" + fisrtReasonForChange + "' />";
        }
        if (!OldGender.equals("") && !NewGender.equals("")) {
            genderline = "<Gender OldGender='" + OldGender + "' NewGender='" + NewGender + "' ReasonForChange='" + genderReasonForChange + "'/>";
        }
        if (!OldLastName.equals("") && !NewLastName.equals("")) {
            lastNameline = "<LastName OldLastName='" + OldLastName + "' NewLastName='" + NewLastName + "' ReasonForChange='" + lastReasonForChange + "' />";
        }
        if (!oldbirth.equals("") && !newBirth.equals("")) {
            birthdateline = "<DateOfBirth OldDateOfBirth='" + dateConvert(oldbirth) + "' NewDateOfBirth='" + dateConvert(newBirth) + "' ReasonForChange='" + birthReasonForChange + "' />";
        }

        if (!oldphone.equals("") && !newphone.equals("")) {
            phone1line = "<PhoneNumber1 OldPhoneNumber1='" + oldphone + "' NewPhoneNumber1='" + newphone + "' ReasonForChange='" + phonereason + "' />";
        }
        if (!OldMiddleName.equals("") && !NewMiddleName.equals("")) {
            middleline = "<MiddleName OldMiddleName='" + OldMiddleName + "' NewMiddleName='" + NewMiddleName + "' ReasonForChange='" + middlereason + "' />";
        }



        response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "\n"
                + "\n"
                + "<UpdateDetail>\n"
                + "\n"
                + "<BVN>" + bvn + "</BVN>	\n"
                + "" + emailLine + "\n"
                + "\n"
                + "" + firstNameLine + "\n"
                + "" + genderline + "\n"
                + "\n"
                + "" + lastNameline + "\n"
                + "" + level + "\n"
                /*  + "	<LgaOfOrigin OldLgaOfOrigin='' NewLgaOfOrigin='' ReasonForChange='' />\n"
                 + "	<LgaOfResidence OldLgaOfResidence='' NewLgaOfResidence='' ReasonForChange='' />\n"
                 + "	<MaritalStatus OldMaritalStatus='' NewMaritalStatus='' ReasonForChange='' />\n"*/
                + "	" + middleline + "\n"
                /*  + "	<NIN OldNIN='' NewNIN='' ReasonForChange='' />\n"
                 + "	<NameOnCard OldNameOnCard='' NewNameOnCard='' ReasonForChange='' />\n"
                 + "	<Nationality OldNationality='' NewNationality='' ReasonForChange='' />\n"
                 + "	<PhoneNumber1 OldPhoneNumber1='08084357777' NewPhoneNumber1='08033322173' ReasonForChange='OK' />\n"*/
                + "	" + phone1line + "\n"
                /* + "	<ResidentialAddress OldResidentialAddress='' NewResidentialAddress='' ReasonForChange='' />\n"
                 + "	<StateOfOrigin OldStateOfOrigin='' NewStateOfOrigin='' ReasonForChange='' />\n"
                 + "	<StateOfResidence OldStateOfResidence='' NewStateOfResidence='' ReasonForChange='' />\n"
                 + "	<Title OldTitle='' NewTitle='' ReasonForChange='' />\n"*/
                + "	" + birthdateline + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "</UpdateDetail>";

        return response;
    }

    public static void mainm(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new senRequestToNIBSS(), 0, 500);

        // String srcPhone = "2348034930062";
        // String ss="2348034930062";
        // System.out.println("Aut<<>>"+ srcPhone.substring(srcPhone.length() - 10, srcPhone.length()));



    }

    @Override
    public void run() {
        try {
            Process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}