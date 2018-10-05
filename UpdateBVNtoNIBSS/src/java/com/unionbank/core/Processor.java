/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.unionbank.webpay.db.dao.AuditDAO;
import com.unionbank.webpay.db.dao.CustomerData;
import com.unionbank.webpay.db.dao.MerchantsDAO;
import com.unionbank.webpay.db.dao.TransactionQueryResponse;
import com.unionbank.webpay.db.dao.TransactionsDAO;
import com.unionbank.webpay.db.dao.fileUploadData;
import com.unionbank.webpay.db.dao.vwTransactionsDAO;
import com.unionbank.webpay.parameters.ApplicationSettings;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.ByteArrayInputStream;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.datacontract.schemas._2004._07.ubn_security.UserProfile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author aajibade
 */
public class Processor {

    PBEncrytor Pb = new PBEncrytor();
    private Settings settings = Settings.getInstance("");
    String user = settings.getProperty("user-user");
    String password = Pb.PBDecrypt(settings.getProperty("password-password"));
    String host_host = settings.getProperty("host-host");
    String user_live = settings.getProperty("user-live");
    String password_live = Pb.PBDecrypt(settings.getProperty("password-live"));
    String host_live = settings.getProperty("host-live");
    String user_alert = settings.getProperty("user-alert");
    String password_alert = Pb.PBDecrypt(settings.getProperty("password-alert"));
    String host_alert = settings.getProperty("host-alert");

    public Processor() {
    }

    public static void mainn(String args[]) {
        Processor pp = new Processor();
        String hash = "", SHA512hash = "";

        String tnx_ref = "3228282288";
        String product_id = "6205";
        String pay_item_id = "101";
        String amount = "5000";
        String site_redirect_url = "http://localhost:8080/UBNIntegrationToWebPay/UBNWebPayRedirect.jsp";
        String data = "<TransactionQueryResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n"
                + "	<ResponseCode>00</ResponseCode>\n"
                + "	<ResponseDescription>Approved Successful</ResponseDescription>\n"
                + "	<Amount>5000</Amount>\n"
                + "	<CardNumber>0095</CardNumber>\n"
                + "	<MerchantReference>UBN/20150715172758</MerchantReference>\n"
                + "	<PaymentReference>FBN|WEB|WEBP|15-07-2015|132132</PaymentReference>\n"
                + "	<RetrievalReferenceNumber>000000076416</RetrievalReferenceNumber>\n"
                + "	<SplitAccounts />\n"
                + "	<TransactionDate>2015-07-15T17:31:14.987</TransactionDate>\n"
                + "</TransactionQueryResponse>";
        pp.processTxnRequest(data);
        //   hash = pp.generateHashValue(tnx_ref + product_id + pay_item_id + amount + site_redirect_url, "D3D1D05AFE42AD50818167EAC73C109168A0F108F32645C8B59E897FA930DA44F9230910DAC9E20641823799A107A02068F7BC0F4CC41D2952E249552255710F");
        //   SHA512hash = pp.generateSHA512(tnx_ref + product_id + pay_item_id + amount + site_redirect_url + "D3D1D05AFE42AD50818167EAC73C109168A0F108F32645C8B59E897FA930DA44F9230910DAC9E20641823799A107A02068F7BC0F4CC41D2952E249552255710F");
        //   System.out.println(":::::::::::::hashing  :::::::::::" + hash);
        //  System.out.println(":::::::::::::hashing SHA512hash :::::::::::" + SHA512hash);
    }

    public String generateTxnID() {
        String txnid = "";
        String refseq = "";
        java.text.SimpleDateFormat sformatter_check2 = new java.text.SimpleDateFormat("yyyy");
        java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        String current_date_check = sformatter_check.format(new java.util.Date());
        String yesr = sformatter_check2.format(new java.util.Date());
        try {
            refseq = gettxnRefsqquence();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (!refseq.equals("")) {
            txnid = "WP\\" + yesr + "\\" + refseq;
        } else {
            txnid = "WP\\" + yesr + "\\" + current_date_check;
        }

        return txnid;
    }

    public String getProductCode() {
        String productCode = "";
        try {
            productCode = ApplicationSettings.PORDUCT_CODE;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return productCode;

    }

    public  String getNodeValue(String nodeElementPath, String message) {
        String nodeValue = "";
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(new ByteArrayInputStream(message.getBytes()));
            builder = builderFactory.newDocumentBuilder();
            XPath xPath = XPathFactory.newInstance().newXPath();
            String email = xPath.compile(nodeElementPath).evaluate(xmlDocument);
            Node node = (Node) xPath.compile(nodeElementPath).evaluate(xmlDocument, XPathConstants.NODE);
            NodeList nodeList = (NodeList) xPath.compile(nodeElementPath).evaluate(xmlDocument, XPathConstants.NODESET);
            Node nod = nodeList.item(0);
            System.out.println("nodeList.getLength<<>>" + nodeList.getLength());
            if (nod.getNodeType() == Node.ELEMENT_NODE) {
                nodeValue = (nod.getFirstChild() != null) ? nod.getFirstChild().getNodeValue() : "";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nodeValue;
    }

    public TransactionsDAO getBVNdetails(String BvNumber) {
        String savedHash = "";
        TransactionsDAO mert = new TransactionsDAO();
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String vbnResponse = "";
        String xx = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<SearchResult>\n"
                + "	<ResultStatus>00</ResultStatus>\n"
                + "	<BvnSearchResult>\n"
                + "		<Bvn>12941630400</Bvn>\n"
                + "		<FirstName>Ayodeji</FirstName>\n"
                + "		<MiddleName>_</MiddleName>\n"
                + "		<LastName>Ajibade</LastName>\n"
                + "		<DateOfBirth>19-FEB-81</DateOfBirth>\n"
                + "		<PhoneNumber>08034930062</PhoneNumber>\n"
                + "		<RegistrationDate>21-MAR-14</RegistrationDate>\n"
                + "		<EnrollmentBank>900</EnrollmentBank>\n"
                + "		<EnrollmentBranch>_</EnrollmentBranch>\n"
                + "		<ImageBase64/>\n"
                + "	</BvnSearchResult>\n"
                + "</SearchResult>";
        String FirstName = "", MiddleName = "", LastName = "", DateOfBirth = "", PhoneNumber = "", responseCode = "";
        securityInteface sd = new securityInteface();
        try {
            System.out.println(".BvNumber<<>>" + BvNumber);
            vbnResponse = sd.validateBvn(BvNumber);
            System.out.println(".vbnResponse<<>>" + vbnResponse);
            //System.out.println("nodeList.SessionId<<>>" + xx.indexOf("<ResultStatus>"));
            FirstName = getNodeValue("/SearchResult/BvnSearchResult/FirstName", vbnResponse);
            MiddleName = getNodeValue("/SearchResult/BvnSearchResult/MiddleName", vbnResponse);
            LastName = getNodeValue("/SearchResult/BvnSearchResult/LastName", vbnResponse);
            DateOfBirth = getNodeValue("/SearchResult/BvnSearchResult/DateOfBirth", vbnResponse);
            PhoneNumber = getNodeValue("/SearchResult/BvnSearchResult/PhoneNumber", vbnResponse);
            responseCode = getNodeValue("/SearchResult/ResultStatus", vbnResponse);

            //  LastName = vbnResponse.substring(vbnResponse.indexOf("<LastName>"), vbnResponse.indexOf("</LastName>"));
            //  DateOfBirth = vbnResponse.substring(vbnResponse.indexOf("<DateOfBirth>"), vbnResponse.indexOf("</DateOfBirth>"));
            //  PhoneNumber = vbnResponse.substring(vbnResponse.indexOf("<PhoneNumber>"), vbnResponse.indexOf("</PhoneNumber>"));
            //  responseCode = vbnResponse.substring(vbnResponse.indexOf("<ResultStatus>"), vbnResponse.indexOf("</ResultStatus>"));
            //  System.out.println(".FirstName2<<>>" + FirstName2);
           /* FirstName = vbnResponse.substring(vbnResponse.indexOf("<FirstName>"), vbnResponse.indexOf("</FirstName>"));
             MiddleName = vbnResponse.substring(vbnResponse.indexOf("<MiddleName>"), vbnResponse.indexOf("</MiddleName>"));
             LastName = vbnResponse.substring(vbnResponse.indexOf("<LastName>"), vbnResponse.indexOf("</LastName>"));
             DateOfBirth = vbnResponse.substring(vbnResponse.indexOf("<DateOfBirth>"), vbnResponse.indexOf("</DateOfBirth>"));
             PhoneNumber = vbnResponse.substring(vbnResponse.indexOf("<PhoneNumber>"), vbnResponse.indexOf("</PhoneNumber>"));
             responseCode = vbnResponse.substring(vbnResponse.indexOf("<ResultStatus>"), vbnResponse.indexOf("</ResultStatus>"));*/
            System.out.println(".responseCode<<>>" + responseCode);
        } catch (Exception e) {
            mert.setResponseCode("01");
            e.printStackTrace();
        }
        System.out.println("In The While Loop " + host_host);
        if (!BvNumber.equals("")) {
            mert.setResponseCode(responseCode);
            mert.setOldBvNumber(BvNumber);
            mert.setOldDateOfBirth(DateOfBirth);
            mert.setOldEmailAdd("");
            mert.setOldFirstName(FirstName);
            mert.setOldMiddleName(MiddleName);
            mert.setOldLastName(LastName);
            mert.setOldPhoneNumber(PhoneNumber);
        }


        return mert;
    }

    public TransactionsDAO getBVNdetailsold(String BvNumber) {
        String savedHash = "";
        TransactionsDAO mert = new TransactionsDAO();
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("In The While Loop " + host_host);
        if (BvNumber.equals("22153140604")) {
            mert.setResponseCode("00");
            mert.setOldBvNumber("22153140604");
            mert.setOldDateOfBirth("19-FEB-1997");
            mert.setOldEmailAdd("unwanyanwu@nibss.com");
            mert.setOldFirstName("CHIJIOKE");
            mert.setOldMiddleName("JJC");
            mert.setOldLastName("OKECHUKWU");
            mert.setOldPhoneNumber("08146703440");
        }


        return mert;
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean processBVNAction(String message, String BVNNUmber, String BRANCH_CODE, String BRANCH_NAME, String E_MAIL,
            String TELEPHONE, String CUSTOMER_NO, String SEX, Date DATE_OF_BIRTH, String CUST_AC_NO,
            String AC_DESC, String ACCOUNT_CLASS, String RECORD_STAT, String AUTH_STAT, String BANKCODE) {
        // public boolean processBVNAction(String MESSAGE_ID, String BVNNUMBER, String CUSTNO, String CUSTNAME) {
        boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String MESSAGE_ID = "";
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);

            String query = "INSERT INTO RECEIVED_BVN_LINK_RQS  ("
                    + " MESSAGE_ID,"
                    + "BVNNUMBER,"
                    + "CUSTNO,"
                    + " BRANCH_CODE,"
                    + "BRANCH_NAME,"
                    + "E_MAIL,"
                    + "TELEPHONE,"
                    + "SEX,"
                    + "DATE_OF_BIRTH,"
                    + "CUST_AC_NO,"
                    + "AC_DESC,"
                    + "ACCOUNT_CLASS,"
                    + "RECORD_STAT,"
                    + "AUTH_STAT,"
                    + "CUSTNAME,"
                    + "bank_Code"
                    + "  ) VALUES ("
                    + " ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, message);
            pstmt.setString(2, BVNNUmber);
            pstmt.setString(3, CUSTOMER_NO);
            pstmt.setString(4, BRANCH_CODE);
            pstmt.setString(5, BRANCH_NAME);
            pstmt.setString(6, E_MAIL);
            pstmt.setString(7, TELEPHONE);
            pstmt.setString(8, SEX);
            pstmt.setDate(9, DATE_OF_BIRTH);
            pstmt.setString(10, CUST_AC_NO);
            pstmt.setString(11, AC_DESC);
            pstmt.setString(12, ACCOUNT_CLASS);
            pstmt.setString(13, RECORD_STAT);
            pstmt.setString(14, AUTH_STAT);
            pstmt.setString(15, AC_DESC);
            pstmt.setString(16, BANKCODE);

          
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = true;
            }
            System.out.println("isupdate " + isupdate);
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            // LoggingUtil.logError(ex, logger);
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
                //  LoggingUtil.logError(e, logger);
                e.printStackTrace();
            }
        }
        return isupdate;
    }

    //logAuditTrail(String auditCode, String userid) {
    public boolean logAuditTrail(String auditCode, String userid) {

        boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String Date_time = "";
        String MESSAGE_ID = "";
        // java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("dd-MMM-YYYY");
        // String current_date = sformatter_check.format();

        System.out.println("got here auditCode <<>>>" + auditCode);
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);

            String query = "INSERT INTO BVN_AUDIT_TRAIL  ("
                    + "TXDID,"
                    + "AUDITCODE,"
                    + "USERID"
                    // + " DATETIME"

                    + "  ) VALUES ("
                    + "  ?,?, ?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, gettxnRefsqquences());
            pstmt.setString(2, auditCode);
            pstmt.setString(3, userid);

            System.out.println("query " + query);
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = true;
            }
            System.out.println("isupdate " + isupdate);
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {

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

    public boolean logAuditTrail(String auditCode, UserProfile ursP, String requestID) {

        boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String Date_time = "";
        String MESSAGE_ID = "";
        String userEmail = "";
        String address = "", department = "", displayName = "", employeeId = "", firstName = "",
                gradeLevel = "", initials = "", lastName = "", mobileNumber = "", telephoneNumber = "",
                branchCode = "", branchName = "";

        // java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("dd-MMM-YYYY");
        // String current_date = sformatter_check.format();


        // ursP.get
        try {
            userEmail = ursP.getEmail().getValue();
            if (userEmail == null) {
                userEmail = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            address = ursP.getAddress().getValue();
            if (address == null) {
                address = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            department = ursP.getDepartment().getValue();
            if (department == null) {
                department = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            displayName = ursP.getDisplayName().getValue();

            if (displayName == null) {
                displayName = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            employeeId = ursP.getEmployeeId().getValue();
            if (employeeId == null) {
                employeeId = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            firstName = ursP.getFirstName().getValue();
            if (firstName == null) {
                firstName = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gradeLevel = ursP.getGradeLevel().getValue();
            if (gradeLevel == null) {
                gradeLevel = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            initials = ursP.getInitials().getValue();
            if (initials == null) {
                initials = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            lastName = ursP.getLastName().getValue();
            if (lastName == null) {
                lastName = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mobileNumber = ursP.getMobileNumber().getValue();
            if (mobileNumber == null) {
                mobileNumber = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            telephoneNumber = ursP.getTelephoneNumber().getValue();
            if (telephoneNumber == null) {
                telephoneNumber = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            branchCode = ursP.getBranchCode().getValue();
            if (branchCode == null) {
                branchCode = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            branchName = ursP.getBranchName().getValue();
            if (branchName == null) {
                branchName = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            if (requestID == null) {
                requestID = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("got here auditCode <<>>>" + auditCode);
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);

            /*String address = "", department = "", displayName = "", employeeId = "", firstName = "",
             gradeLevel = "", initials = "", lastName = "", mobileNumber = "", telephoneNumber = "",
             branchCode = "", branchName = "";
             *///requestID
            String query = "INSERT INTO BVN_AUDIT_TRAIL  ("
                    //  + " TXDID,"
                    + "AUDITCODE,"
                    + "USERID,"
                    + "displayName,"
                    + "employeeId,"
                    + "firstName,"
                    + "gradeLevel,"
                    + "initials,"
                    + "lastName,"
                    + "mobileNumber,"
                    + "telephoneNumber,"
                    + "branchCode,"
                    + "branchName,"
                    + "requestID"
                    // + " DATETIME"

                    + "  ) VALUES ("
                    + "  ?, ?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, auditCode);
            pstmt.setString(2, userEmail);
            pstmt.setString(3, displayName);
            pstmt.setString(4, employeeId);
            pstmt.setString(5, firstName);
            pstmt.setString(6, gradeLevel);
            pstmt.setString(7, initials);
            pstmt.setString(8, lastName);
            pstmt.setString(9, mobileNumber);
            pstmt.setString(10, telephoneNumber);
            pstmt.setString(11, branchCode);
            pstmt.setString(12, branchName);
            pstmt.setString(13, requestID);
            // pstmt.setDate(3, new java.util.Date());
            System.out.println("query " + query);
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = true;
            }
            System.out.println("isupdate " + isupdate);
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            System.out.println("isupdate  error ");
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

    public String getaccountName(String acctNumber) {
        String acctName = "";
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select AC_DESC  from sttm_cust_account  where  CUST_AC_NO='" + acctNumber.trim() + "'\n"
                    + "                      ";
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            System.out.println("This query <<>>" + query);
            pstmt = conn.prepareStatement(query);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();

                while (rs.next()) {
                    acctName = rs.getString("AC_DESC");
                }

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
        } catch (Exception e) {
            UpdateUnsucessful("");
            e.printStackTrace();
            //  LoggingUtil.logError(e, logger);
            e.printStackTrace();
        }
        return acctName;
    }

    public fileUploadData getparameter(String parameter, String requestid) {
        String acctName = "";
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        fileUploadData dd = new fileUploadData();

        try {
            String query = "select *  from file_upload_cach  where  field='" + parameter.trim() + "'      and   request_id ='" + requestid.trim() + "' "
                    + "                      ";
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            System.out.println("This query <<>>" + query);
            pstmt = conn.prepareStatement(query);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();

                while (rs.next()) {
                    dd.setField(rs.getString("field"));
                    dd.setRequestId(rs.getString("REQUEST_ID"));
                    dd.setUrlID(rs.getString("URL"));
                }

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
        } catch (Exception e) {
            UpdateUnsucessful("");
            e.printStackTrace();
            //  LoggingUtil.logError(e, logger);
            e.printStackTrace();
        }
        return dd;
    }

    public void processBVNRequest(String accountnumber, String bvn, String bankcode) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        String custId = null;
        String custname = null;
        String refPhone = null;
        String BRANCH_CODE = "", BRANCH_NAME = "", E_MAIL = "", TELEPHONE = "", CUSTOMER_NO = "", SEX = "", CUST_AC_NO = "", AC_DESC, ACCOUNT_CLASS = "", RECORD_STAT = "", AUTH_STAT = "";
        int count = 0;
        Date DATE_OF_BIRTH;
        boolean which = false;

        try {

            String query = "select d.BRANCH_CODE,d.BRANCH_NAME, b.E_MAIL,nvl(b.TELEPHONE,b.mobile_number) telephone,b.CUSTOMER_NO,b.SEX, b.DATE_OF_BIRTH, c.CUST_AC_NO,c.AC_DESC,c.ACCOUNT_CLASS,c.RECORD_STAT, c.AUTH_STAT\n"
                    + "                    \n"
                    + "                    \n"
                    + "                    from  sttm_cust_personal b,  sttm_cust_account c , sttm_branch d   \n"
                    + "                     where   b.CUSTOMER_NO = c.CUST_NO \n"
                    + "                      and  d.BRANCH_CODE = c.BRANCH_CODE\n"
                    + "                      \n"
                    + "                      and c.CUST_AC_NO='" + accountnumber + "'\n"
                    + "                      ";
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            System.out.println("This query <<>>" + query);
            pstmt = conn.prepareStatement(query);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();

                while (rs.next()) {
                    count++;
                    which = true;
                    System.out.println("This count <<>>" + count);
                    // custId = rs.getString("BRANCH_CODE");
                    //custname = rs.getString(2);
                    BRANCH_CODE = rs.getString("BRANCH_CODE");
                    BRANCH_NAME = rs.getString("BRANCH_NAME");
                    E_MAIL = rs.getString("E_MAIL");
                    TELEPHONE = rs.getString("telephone");
                    CUSTOMER_NO = rs.getString("CUSTOMER_NO");
                    SEX = rs.getString("SEX");
                    DATE_OF_BIRTH = rs.getDate("DATE_OF_BIRTH");
                    CUST_AC_NO = rs.getString("CUST_AC_NO");
                    AC_DESC = rs.getString("AC_DESC");
                    ACCOUNT_CLASS = rs.getString("ACCOUNT_CLASS");
                    RECORD_STAT = rs.getString("RECORD_STAT");
                    AUTH_STAT = rs.getString("AUTH_STAT");

                    boolean check = false;

                    check = processBVNAction("", bvn, BRANCH_CODE, BRANCH_NAME, E_MAIL, TELEPHONE, CUSTOMER_NO, SEX, DATE_OF_BIRTH, CUST_AC_NO, AC_DESC, ACCOUNT_CLASS, RECORD_STAT, AUTH_STAT, bankcode);

                    if (check) {
                        System.out.println("WAS OK PALY:");

                    } else {
                    }


                }

            }
            if (which) {
                UpdateSucessful("");
                processCardResponse(CUSTOMER_NO, "", TELEPHONE, "", CUST_AC_NO, bvn);
            } else {
                UpdateNOTsucessful("");
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
        } catch (Exception e) {
            UpdateUnsucessful("");
            e.printStackTrace();
            //  LoggingUtil.logError(e, logger);
            e.printStackTrace();
        }
    }

    public void UpdateNOTsucessful(String srcID) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            String query = "UPDATE DUAL_MESSAGES_RECEIVED SET status = 'X', PROCESSED_DATE = sysdate "
                    + "WHERE MESSAGE_ID = '" + srcID + "'";
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

    public void approveDenieFunction(String requestID, String decision, String checker, String checkerBRNcode) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        String query = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            if (decision.equals("APPROVE")) {
                query = "UPDATE customer_update_req SET APPROVALSTATUS = 'Y', approve_reject_date = sysdate, checker  = '" + checker + "',checkerbranchcode  = '" + checkerBRNcode + "' "
                        + "WHERE REQUEST_ID = '" + requestID + "'";
            } else if (decision.equals("REJECT")) {
                query = "UPDATE customer_update_req SET APPROVALSTATUS = 'X', approve_reject_date = sysdate, checker  = '" + checker + "',checkerbranchcode  = '" + checkerBRNcode + "' "
                        + "WHERE REQUEST_ID = '" + requestID + "'";
            }

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

    public void processCardResponse(String custid, String messID, String srcPhone, String serviceType, String acctNo, String otheritem) {
        PreparedStatement pstmt1 = null;
        Connection conn = null;
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss");
        String myDate = formatter.format(ts);



        try {
            if (srcPhone.substring(0, 1).equalsIgnoreCase("0")) {
                srcPhone = "234" + srcPhone.substring(1);
                System.out.println("refPhone 2 " + srcPhone);
            } else {
                srcPhone = "234" + srcPhone;
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_alert, user_alert, password_alert);
            String message = "";
            if (serviceType.equalsIgnoreCase("BVN")) {
                message = "Union>>>Your request to link BVN NO: " + otheritem + " was received and is being processed.\nThank You.";
            } else {
                message = "Union>>>Service Request " + "\n" + serviceType + " on Acct No: " + acctNo + "\nWas Successful ";
            }

            String query1 = "insert into sms_message_queue(MESSAGE_ID, MESSAGE_PART_NO, "
                    + "QUEUE_DATE, MOBILE_NO, MESSAGE_TEXT, RETRY_COUNT, STATUS, "
                    + "REQUESTOR_ID, QUEUE_GROUP, MESSAGE_TYPE, CHECKSUM,ACCOUNT_NO,SOURCE) "
                    + "values('" + messID + "', '1', sysdate, '" + srcPhone + "', "
                    + "'" + message + "', '0', 'NEW', '" + custid + "', '0', 'SMS', '" + messID + "','" + acctNo + "','SMSBANK')";
            pstmt1 = conn.prepareStatement(query1);
            System.out.println("sql1 " + query1);
            pstmt1.execute();
            UpdateUnsucessful(messID);
            if (pstmt1 != null) {
                pstmt1.close();
                pstmt1 = null;
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            UpdateUnsucessful(messID);
        } finally {
            try {
                if (pstmt1 != null) {
                    pstmt1.close();
                    pstmt1 = null;
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void UpdateUnsucessful(String srcID) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            String query = "UPDATE DUAL_MESSAGES_RECEIVED SET status = 'Y', PROCESSED_DATE = sysdate "
                    + "WHERE MESSAGE_ID = '" + srcID + "'";
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

    public void UpdateSucessful(String srcID) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            String query = "UPDATE DUAL_MESSAGES_RECEIVED SET status = 'Y', PROCESSED_DATE = sysdate "
                    + "WHERE MESSAGE_ID = '" + srcID + "'";
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

    public List<vwTransactionsDAO> getTransactionList() {

        String savedHash = "";
        // List<vwTransactionsDAO> tTransactionsList = new (ArrayList<vwTransactionsDAO>) ;

        List<vwTransactionsDAO> tTransactionsList = new ArrayList<vwTransactionsDAO>();
        vwTransactionsDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select * from vwMerchtTransList WHERE  rownum <=250 order by DATE_CREATED desc";
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
        }
        int count = 0;
        try {
            while (rs.next()) {
                mert = new vwTransactionsDAO();
                count = count + 1;
                mert.setTxnId(rs.getLong("TXN_ID"));
                mert.setAmountLc(rs.getString("amount_local"));
                //   java.sql.Date sqlDate = rs.getDate("date_created");
                // java.util.Date javaDate = new java.util.Date(sqlDate.getTime());
                // mert.setDateCreated(rs.getDate("date_created"));
                java.util.Date taskStartDate = rs.getTimestamp("date_created");
                mert.setDateCreated(taskStartDate);


                //java.util.Date ponseUpdateDate = rs.getTimestamp("date_created");
                mert.setResponseUpdateDate(taskStartDate);
                mert.setMerchantName(rs.getString("merchant_name"));
                mert.setPayRef(rs.getString("pay_ref"));
                mert.setResponseCode(rs.getString("response_code"));
                mert.setResponseDesc(rs.getString("response_desc"));
                //mert.setTxnId(rs.getString("amount_local"));
                mert.setTxnRef(rs.getString("tnx_ref"));
                tTransactionsList.add(mert);
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


        return tTransactionsList;
    }

    public MerchantsDAO getMerchantdetails(String itemId) {
        PreparedStatement pstmt = null;
        MerchantsDAO mert = new MerchantsDAO();
        Connection conn = null;
        ResultSet rs = null;

        try {
            String query = "select * from UBNPAY_Merchants WHERE  pay_item_id ='" + itemId + "'  and AUTH_FLAG='Y'  and DISABLE_FLAG='N' ";
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
        }
        int count = 0;
        try {
            while (rs.next()) {
                System.out.println("In The While Loop " + host_host);
                count = count + 1;
                mert.setMerchantName(rs.getString("MERCHANT_NAME"));
                mert.setSiteRedirectUrl(rs.getString("SITE_REDIRECT_URL"));
                mert.setPayItemId(rs.getString("PAY_ITEM_ID"));
                mert.setMacKey(rs.getString("MAC_KEY"));
                mert.setAuthFlag(rs.getString("AUTH_FLAG"));
                mert.setDisableFlag(rs.getString("DISABLE_FLAG"));

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

        return mert;
    }

    /*public MerchantsDAO retrieveMerchantDetails(String itemId) {
     String savedHash = "";
     MerchantsDAO mert = new MerchantsDAO();
     //Date today = new Date();
     try {
     String whereCaluse = "where pay_item_id ='" + itemId + "'  and AUTH_FLAG='Y'  and DISABLE_FLAG='N' ";
     List<MerchantsDAO> AgentsList = PersistenceAgent.loadTableRecords("MerchantsDAO", whereCaluse);
     if (AgentsList != null && AgentsList.size() > 0) {
     mert = AgentsList.get(0);
     savedHash = mert.getMacKey();
     }
     } catch (Exception ex) {
     ex.printStackTrace();
     }

     return mert;
     }*/
    public boolean validateAmount(String amount) {
        double amount_t = 0;
        boolean ok = false;
        try {
            if (amount.contains(".")) {
                ok = false;
            } else {
                amount_t = Double.valueOf(amount);
                if (amount_t <= 0) {
                    ok = false;
                } else {
                    ok = true;
                }
            }




        } catch (Exception ex) {
            ok = false;
            ex.printStackTrace();

        }
        return ok;
    }

    /*public String retrieveMerxchantName(String itemId) {
     String savedHash = "";
     MerchantsDAO mert = new MerchantsDAO();
     //Date today = new Date();
     try {
     String whereCaluse = "where pay_item_id ='" + itemId + "'  and AUTH_FLAG='Y'  and DISABLE_FLAG='N'";
     List<MerchantsDAO> AgentsList = PersistenceAgent.loadTableRecords("MerchantsDAO", whereCaluse);
     if (AgentsList != null && AgentsList.size() > 0) {
     mert = AgentsList.get(0);
     savedHash = mert.getMerchantName();
     }
     } catch (Exception ex) {
     ex.printStackTrace();
     }

     return savedHash;
     }*/
    public static TransactionQueryResponse processTxnRequest(String data) {
        TransactionQueryResponse TransnQueryResponse = new TransactionQueryResponse();
        try {

            String MessageId = "", LongCode = "", MessageBody = "", SourcePhone = "", ProcessedDate = "", Status = "";
            System.out.println("recived  Value  " + data);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(data));
            Document doc = builder.parse(is);
            doc.getDocumentElement().normalize();
            boolean whichWay = false;
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("TransactionQueryResponse");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    TransnQueryResponse.setResponseCode(eElement.getElementsByTagName("ResponseCode").item(0).getTextContent());
                    if (eElement.getElementsByTagName("ResponseCode").item(0).getTextContent().equals("00")) {
                        TransnQueryResponse.setResponseCode(eElement.getElementsByTagName("ResponseCode").item(0).getTextContent());
                        TransnQueryResponse.setResponseDescription(eElement.getElementsByTagName("ResponseDescription").item(0).getTextContent());
                        TransnQueryResponse.setRetrievalReferenceNumber(eElement.getElementsByTagName("RetrievalReferenceNumber").item(0).getTextContent());
                        TransnQueryResponse.setAmount(eElement.getElementsByTagName("Amount").item(0).getTextContent());
                        TransnQueryResponse.setCardNumber(eElement.getElementsByTagName("CardNumber").item(0).getTextContent());
                        TransnQueryResponse.setMerchantReference(eElement.getElementsByTagName("MerchantReference").item(0).getTextContent());
                        TransnQueryResponse.setPaymentReference(eElement.getElementsByTagName("PaymentReference").item(0).getTextContent());
                        TransnQueryResponse.setTransactionDate(eElement.getElementsByTagName("TransactionDate").item(0).getTextContent());
                    } else {
                        TransnQueryResponse.setResponseCode(eElement.getElementsByTagName("ResponseCode").item(0).getTextContent());
                        TransnQueryResponse.setResponseDescription(eElement.getElementsByTagName("ResponseDescription").item(0).getTextContent());
                    }



                    // 





                    /*<TransactionQueryResponse xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
                     <ResponseCode>00</ResponseCode>
                     <ResponseDescription>Approved Successful</ResponseDescription>
                     <Amount>5000</Amount>
                     <CardNumber>0095</CardNumber>
                     <MerchantReference>UBN/20150715172758</MerchantReference>
                     <PaymentReference>FBN|WEB|WEBP|15-07-2015|132132</PaymentReference>
                     <RetrievalReferenceNumber>000000076416</RetrievalReferenceNumber>
                     <SplitAccounts />
                     <TransactionDate>2015-07-15T17:31:14.987</TransactionDate>
                     </TransactionQueryResponse>*/
                    /*   System.out.println("ResponseDescription : " + eElement.getElementsByTagName("ResponseCode").item(0).getTextContent());
                     System.out.println("ResponseDescription : " + eElement.getElementsByTagName("ResponseDescription").item(0).getTextContent());
                     System.out.println("Amount : " + eElement.getElementsByTagName("Amount").item(0).getTextContent());
                     System.out.println("CardNumber : " + eElement.getElementsByTagName("CardNumber").item(0).getTextContent());
                     System.out.println("MerchantReference : " + eElement.getElementsByTagName("MerchantReference").item(0).getTextContent());*/


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TransnQueryResponse;
    }

    /* public TransactionsDAO gettransaction(String trans_id) {
     String savedHash = "";
     TransactionsDAO mert = new TransactionsDAO();
     try {
     String whereCaluse = "where TNX_REF ='" + trans_id + "'";
     List<TransactionsDAO> AgentsList = PersistenceAgent.loadTableRecords("TransactionsDAO", whereCaluse);
     if (AgentsList != null && AgentsList.size() > 0) {
     mert = AgentsList.get(0);
     }
     } catch (Exception ex) {
     ex.printStackTrace();
     }

     return mert;
     }*/
    /* SELECT webpay_ref_SEQ.NEXTVAL  
     FROM DUAL;*/
    public String gettxnRefsqquence() {
        String refsequence = "";
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "SELECT BVNUp_T_SEQ.NEXTVAL refsequence   FROM DUAL";
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
        }
        int count = 0;
        try {
            while (rs.next()) {
                System.out.println("In The While Loop " + host_host);
                count = count + 1;
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
        } catch (Exception ex) {
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
        return refsequence;
    }

    public List<TransactionsDAO> getPendingList(String decision) {

        String savedHash = "";
        // List<vwTransactionsDAO> tTransactionsList = new (ArrayList<vwTransactionsDAO>) ;
        List<TransactionsDAO> tTransactionsList = new ArrayList<TransactionsDAO>();
        TransactionsDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
           String query = "select * from customer_update_req WHERE  APPROVALSTATUS='" + decision.trim() + "'   ORDER BY RECEIVED_DATE  DESC";
          //  String query = "select * from customer_update_req WHERE  APPROVALSTATUS='" + decision.trim() + "'   ";


            System.out.println("The Host-Host " + host_host);
            System.out.println("The query<<>>> " + query);

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
        }
        int count = 0;

        try {
            while (rs.next()) {
                mert = new TransactionsDAO();
                count = count + 1;
                mert.setRequestID(rs.getString("REQUEST_ID"));
                mert.setOldFirstName(rs.getString("OLDFIRSTNAME"));
                mert.setNewFirstName(rs.getString("NEWFIRSTNAME"));
                mert.setOldMiddleName(rs.getString("OLDMIDDLENAME"));
                mert.setNewMiddleName(rs.getString("NEWMIDDLENAME"));
                mert.setOldLastName(rs.getString("OLDLASTNAME"));
                mert.setNewLastName(rs.getString("NEWLASTNAME"));
                mert.setOldPhoneNumber(rs.getString("OLDPHONENUMBER"));
                mert.setNewPhoneNumber(rs.getString("NEWPHONENUMBER"));
                mert.setOldEmailAdd(rs.getString("OLDEMAILADD"));
                mert.setNewEmailAdd(rs.getString("NEWEMAILADD"));
                mert.setRecieveDate(rs.getString("RECEIVED_DATE"));
                mert.setNewDateOfBirth(rs.getString("NEWDATEOFBIRTH"));
                mert.setOldDateOfBirth(rs.getString("OLDDATEOFBIRTH"));
                mert.setApprovalStatus(rs.getString("APPROVALSTATUS"));
                mert.setBvNumber(rs.getString("BVNUMBER"));
                mert.setFirstNameComment(rs.getString("FIRSTNAMECOMMENT"));
                mert.setMiddleNameComment(rs.getString("MIDDLECOMMENT"));
                mert.setLastNameComment(rs.getString("LASTNAMECOMMENT"));
                mert.setDobComment(rs.getString("DOBCOMMENT"));
                mert.setPhoneNoComment(rs.getString("PHONENOCOMMENT"));
                mert.setEmailComment(rs.getString("EMAILCOMMENT"));
                mert.setApprovedate(rs.getString("APPROVE_REJECT_DATE"));
                mert.setMaker(rs.getString("MARKER"));
                mert.setChecker(rs.getString("CHECKER"));
                tTransactionsList.add(mert);
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

        return tTransactionsList;
    }

    public List<AuditDAO> getAuditLog() {

        String savedHash = "";

        List<AuditDAO> tTransactionsList = new ArrayList<AuditDAO>();
        AuditDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select b.AUDITDESC, a.* from BVN_AUDIT_TRAIL  a , BVN_AUDIT_DESC b \n"
                    + "where \n"
                    + " b.AUDITCODE =a.AUDITCODE\n"
                    + " \n"
                    + " \n"
                    + " order by DATETIME desc";


            System.out.println("The Host-Host " + host_host);
            System.out.println("The query<<>>> " + query);

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
        }
        int count = 0;

        try {
            while (rs.next()) {
                mert = new AuditDAO();
                count = count + 1;
                mert.setUserId(rs.getString("USERID"));
                mert.setDateTime(rs.getString("DATETIME"));
                mert.settAddress(rs.getString("ADDRESS"));
                mert.settDepartment(rs.getString("DEPARTMENT"));
                mert.settDisplayName(rs.getString("DISPLAYNAME"));
                mert.settEmployeeId(rs.getString("EMPLOYEEID"));
                mert.setFirstName(rs.getString("FIRSTNAME"));
                mert.setGradeLevel(rs.getString("GRADELEVEL"));
                mert.settInitial(rs.getString("INITIALS"));
                mert.settLastName(rs.getString("LASTNAME"));
                mert.setModileNumber(rs.getString("MOBILENUMBER"));
                mert.settTelephone(rs.getString("TELEPHONENUMBER"));
                mert.setBranchname(rs.getString("BRANCHNAME"));
                mert.setRequestId(rs.getString("REQUESTID"));
                mert.setBranchcode(rs.getString("BRANCHCODE"));
                mert.setAuditDesc(rs.getString("AUDITDESC"));
                mert.setRequestId(rs.getString("REQUESTID"));

                tTransactionsList.add(mert);
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

        return tTransactionsList;
    }

    public List<TransactionsDAO> getPendingListOne(String decision, String requestid) {

        String savedHash = "";
        // List<vwTransactionsDAO> tTransactionsList = new (ArrayList<vwTransactionsDAO>) ;
        List<TransactionsDAO> tTransactionsList = new ArrayList<TransactionsDAO>();
        TransactionsDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select * from customer_update_req WHERE  APPROVALSTATUS='" + decision.trim() + "'   and REQUEST_ID = '" + requestid.trim() + "'  ORDER BY RECEIVED_DATE  DESC";
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
        }
        int count = 0;

        try {
            while (rs.next()) {
                mert = new TransactionsDAO();
                count = count + 1;
                mert.setRequestID(rs.getString("REQUEST_ID"));
                mert.setOldFirstName(rs.getString("OLDFIRSTNAME"));
                mert.setNewFirstName(rs.getString("NEWFIRSTNAME"));
                mert.setOldMiddleName(rs.getString("OLDMIDDLENAME"));
                mert.setNewMiddleName(rs.getString("NEWMIDDLENAME"));
                mert.setOldLastName(rs.getString("OLDLASTNAME"));
                mert.setNewLastName(rs.getString("NEWLASTNAME"));
                mert.setOldPhoneNumber(rs.getString("OLDPHONENUMBER"));
                mert.setNewPhoneNumber(rs.getString("NEWPHONENUMBER"));
                mert.setOldEmailAdd(rs.getString("OLDEMAILADD"));
                mert.setNewEmailAdd(rs.getString("NEWEMAILADD"));
                mert.setRecieveDate(rs.getString("RECEIVED_DATE"));
                mert.setNewDateOfBirth(rs.getString("NEWDATEOFBIRTH"));
                mert.setOldDateOfBirth(rs.getString("OLDDATEOFBIRTH"));
                mert.setApprovalStatus(rs.getString("APPROVALSTATUS"));
                mert.setBvNumber(rs.getString("BVNUMBER"));
                mert.setFirstNameComment(rs.getString("FIRSTNAMECOMMENT"));
                mert.setMiddleNameComment(rs.getString("MIDDLECOMMENT"));
                mert.setLastNameComment(rs.getString("LASTNAMECOMMENT"));
                mert.setDobComment(rs.getString("DOBCOMMENT"));
                mert.setPhoneNoComment(rs.getString("PHONENOCOMMENT"));
                mert.setEmailComment(rs.getString("EMAILCOMMENT"));
                tTransactionsList.add(mert);
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

        return tTransactionsList;
    }

    public boolean processBVNUpdateRequest(CustomerData[] obj, String BvNumber, String txnId, String marker, String branch) {



        boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String MESSAGE_ID = "";
        String mainTxID = "";
        String displatname = "", Branch = "", oldBvNumber = "";
        String oldFirstName = "", newFirstName = "", firstNameComment = "",
                oldMiddleName = "", newMiddleName = "", MiddleComment = "",
                oldLastName = "", newLastName = "", LastComment = "",
                oldDOBName = "", newDOBName = "", DOBComment = "",
                oldPhoneNoName = "", newPhoneNoName = "", phoneNOComment = "",
                oldEmailName = "", newEmailName = "", emailComment = "";
        try {
            //   txnId = gettxnRefsqquence();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // if (txnId == null) {
        //     txnId = "";
        // }
        try {
            System.out.println("obj.length<<>> " + obj.length);
            for (int i = 0; i < obj.length; i++) {

                // obj[i] = new CustomerData();
                System.out.println("obj[i].getField " + obj[i].getField());
                if (obj[i].getField().equalsIgnoreCase("First Name")) {
                    System.out.println("obj ok 1 " + obj[i].getOldValue());
                    oldFirstName = obj[i].getOldValue();
                    newFirstName = obj[i].getNewValue();
                    firstNameComment = obj[i].getComment();

                }
                if (obj[i].getField().equalsIgnoreCase("Middle Name")) {
                    System.out.println("obj ok 2 " + obj[i].getOldValue());
                    oldMiddleName = obj[i].getOldValue();
                    newMiddleName = obj[i].getNewValue();
                    MiddleComment = obj[i].getComment();

                }
                if (obj[i].getField().equalsIgnoreCase("Last Name")) {
                    System.out.println("obj Last name" + obj[i].getOldValue());
                    oldLastName = obj[i].getOldValue();
                    newLastName = obj[i].getNewValue();
                    LastComment = obj[i].getComment();

                }
                if (obj[i].getField().equalsIgnoreCase("Date Of Birth")) {
                    System.out.println("obj date of Bith" + obj[i].getOldValue());
                    oldDOBName = obj[i].getOldValue();
                    newDOBName = obj[i].getNewValue();
                    DOBComment = obj[i].getComment();

                }
                if (obj[i].getField().equalsIgnoreCase("Phone Number")) {
                    System.out.println("obj PhoneNUmber" + obj[i].getOldValue());
                    oldPhoneNoName = obj[i].getOldValue();
                    newPhoneNoName = obj[i].getNewValue();
                    phoneNOComment = obj[i].getComment();

                }
                if (obj[i].getField().equalsIgnoreCase("Email")) {
                    System.out.println("obj ok Email2 " + obj[i].getOldValue());
                    oldEmailName = obj[i].getOldValue();
                    newEmailName = obj[i].getNewValue();
                    emailComment = obj[i].getComment();

                }

                if (obj[i].getField().equalsIgnoreCase("Transaction ID")) {
                    System.out.println("obj ok Email2 " + obj[i].getOldValue());
                    mainTxID = obj[i].getOldValue();


                }

                if (obj[i].getField().equalsIgnoreCase("Maker")) {
                    System.out.println("obj ok Email2 " + obj[i].getOldValue());
                    displatname = obj[i].getOldValue();


                }
                if (obj[i].getField().equalsIgnoreCase("Branch")) {
                    System.out.println("obj ok Email2 " + obj[i].getOldValue());
                    Branch = obj[i].getOldValue();


                }

                if (obj[i].getField().equalsIgnoreCase("BVN")) {
                    System.out.println("obj ok Email2 " + obj[i].getOldValue());
                    oldBvNumber = obj[i].getOldValue();


                }

            }
            //oldBvNumber

            System.out.println("got mainTxID   <<>> " + mainTxID);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);

            String query = "INSERT INTO customer_update_req  ("
                    + " oldFirstName,"
                    + "newFirstName,"
                    + "oldMiddleName,"
                    + " newMiddleName,"
                    + "oldLastName,"
                    + "newLastName,"
                    + "oldPhoneNumber,"
                    + "newPhoneNumber,"
                    + "oldEmailAdd,"
                    + "newEmailAdd,"
                    + "BvNumber,"
                    + "newDateOfBirth,"
                    + "oldDateOfBirth,"
                    + "firstNameComment,"
                    + "MiddleComment,"
                    + "LastnameComment,"
                    + "DOBComment,"
                    + "phoneNOComment,"
                    + "emailComment,"
                    + "REQUEST_ID,"//branchcode   username
                    + "MARKER,"//branchcode   username
                    + "MARKERBRANCHCODE,"//branchcode   usernameTXNID
                    + "TXNID"//branchcode   username
                    + "  ) VALUES ("
                    + " ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, oldFirstName);
            pstmt.setString(2, newFirstName);
            pstmt.setString(3, oldMiddleName);
            pstmt.setString(4, newMiddleName);
            pstmt.setString(5, oldLastName);
            pstmt.setString(6, newLastName);
            pstmt.setString(7, oldPhoneNoName);
            pstmt.setString(8, newPhoneNoName);
            pstmt.setString(9, oldEmailName);
            pstmt.setString(10, newEmailName);
            pstmt.setString(11, oldBvNumber);
            pstmt.setString(12, newDOBName);
            pstmt.setString(13, oldDOBName);
            pstmt.setString(14, firstNameComment);
            pstmt.setString(15, MiddleComment);
            pstmt.setString(16, LastComment);
            pstmt.setString(17, DOBComment);
            pstmt.setString(18, phoneNOComment);
            pstmt.setString(19, emailComment);
            pstmt.setString(20, mainTxID);
            pstmt.setString(21, displatname);
            pstmt.setString(22, Branch);//marker  branch
            pstmt.setString(23, gettxnRefsqquences());
            System.out.println("query " + query);
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = true;
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
//                LoggingUtil.logError(e, logger);
                e.printStackTrace();
            }
        }
        return isupdate;
    }

    public String gettxnRefsqquences() {
        String refsequence = "";
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "SELECT BVNUP_T_SEQ.NEXTVAL refsequence   FROM DUAL";
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
        }
        int count = 0;
        try {
            while (rs.next()) {
                System.out.println("In The While Loop " + host_host);
                count = count + 1;
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
        } catch (Exception ex) {
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
        return refsequence;
    }

    public boolean updateFileuploadUrl(String field, String transactionid, String url) {
        System.out.println("isupdate field " + field);
        System.out.println("isupdate transactionid " + transactionid);
        System.out.println("isupdate url " + url);
        boolean isupdate = false;

        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
///            System.out.println("obj.length<<>> " + obj.length);//BVNUP_T_SEQ

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);

            String query = "INSERT INTO file_upload_cach  ("
                    + " field,"
                    + "URL,"
                    + "REQUEST_ID,"
                    + "ID"
                    + "  ) VALUES ("
                    + " ?, ?, ?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, field);
            pstmt.setString(2, url);
            pstmt.setString(3, transactionid);
            pstmt.setString(4, gettxnRefsqquences());


            System.out.println("query<> " + query);
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = true;
            }
            System.out.println("isupdate upload " + isupdate);
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
//                LoggingUtil.logError(e, logger);
                e.printStackTrace();
            }
        }
        return isupdate;
    }

    public TransactionsDAO gettransactionByID(String id) {
        String savedHash = "";
        TransactionsDAO mert = new TransactionsDAO();
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select * from UBNPAY_Transactions WHERE  TXN_ID ='" + id + "' ";
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
        }
        int count = 0;
        try {
            while (rs.next()) {
                System.out.println("In The While Loop " + host_host);
                count = count + 1;
//                mert.setPayItemId(rs.getString("PAY_ITEM_ID"));
                //    mert.setAmountLocal(rs.getBigDecimal("AMOUNT_LOCAL"));
                //    mert.setTnxRef(rs.getString("TNX_REF"));
                // mert.setPayItemId(rs.getString("PAY_ITEM_ID"));
                // mert.setMacKey(rs.getString("MAC_KEY"));
                // mert.setAuthFlag(rs.getString("AUTH_FLAG"));
                // mert.setDisableFlag(rs.getString("DISABLE_FLAG"));

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
        return mert;
    }

    /* public TransactionsDAO gettransactionByID(String id) {
     String savedHash = "";
     TransactionsDAO mert = new TransactionsDAO();
     try {
     String whereCaluse = "where TXN_ID ='" + id + "'";
     List<TransactionsDAO> AgentsList = PersistenceAgent.loadTableRecords("TransactionsDAO", whereCaluse);
     if (AgentsList != null && AgentsList.size() > 0) {
     mert = AgentsList.get(0);
     }
     } catch (Exception ex) {
     ex.printStackTrace();
     }

     return mert;
     }*/
    public String generateDateTime() {
        String txnid = "";

        java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date_check = sformatter_check.format(new java.util.Date());
        txnid = current_date_check;
        return txnid;
    }

    public boolean validateHash(String returnedHashvalue, String tnx_ref, String product_id, String pay_item_id, String amount, String site_redirect_url, String savedHashkey) {
        boolean thisValidate = false;
        String myGenHash = "";
        try {
            myGenHash = generateSHA512(tnx_ref + product_id + pay_item_id + amount + site_redirect_url + savedHashkey);
            if (myGenHash.equals(returnedHashvalue)) {
                thisValidate = true;
            }
            System.out.println(":::::::::::::myIngredent  :::::::::::" + tnx_ref + product_id + pay_item_id + amount + site_redirect_url + savedHashkey);
            System.out.println(":::::::::::::myGenHash  :::::::::::" + myGenHash);
            System.out.println(":::::::::::::returnedHashvalue  :::::::::::" + returnedHashvalue);
        } catch (Exception e) {
            thisValidate = false;
            e.printStackTrace();
        }

        return thisValidate;
    }

    public static void main(String args[]) {
        Processor pp = new Processor();
        //  pp.logAuditTrail("01", "aajibade");
        //  System.out.println("gen<<>>>  " + pp.getCalculatedHash("UBN/20150819115455", "6205", "101", "500678", "https://APPSUPPORT-009:8181/UBNIntegrationToWebPay/ubnpaygatereturn", "D3D1D05AFE42AD50818167EAC73C109168A0F108F32645C8B59E897FA930DA44F9230910DAC9E20641823799A107A02068F7BC0F4CC41D2952E249552255710F"));
        //  MerchantsDAO mert = new MerchantsDAO();
        TransactionsDAO mert = new TransactionsDAO();
       // mert = pp.getBVNdetails("12941630400");
        //  mert = pp.getBVNdetails("101");
           
        System.out.println("<<>>getOldDateOfBirth " +  pp.gettxnRefsqquences());

        // System.out.println("<<>>" + pp.generateTxnID());


    }

    public String getCalculatedHash(String tnx_ref, String product_id, String pay_item_id, String amount, String site_redirect_url, String hashkey) {
        String calHash = "";
        System.out.println("Cipher() :" + tnx_ref + product_id + pay_item_id + amount + site_redirect_url + hashkey);
        try {
            calHash = generateSHA512(tnx_ref + product_id + pay_item_id + amount + site_redirect_url + hashkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calHash;

    }
    //(String productId, String transactionReference, String amount,String hash) {  (String productId, String transactionReference, String amount,String hashkey) {

    public String getCalculatedHashForTxnQuery(String productId, String transactionReference, String amount, String hashkey) {
        String calHash = "";
        try {
            calHash = generateSHA512(productId + transactionReference + hashkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calHash;

    }

    public String generateSHA512(String password) {

        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
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

        return hexString.toString();
    }

    public String generateHashValue(String msg, String secret_key) {
        //  System.out.println(":::::::::::::hashing request :::::::::::");
        MessageDigest m = null;
        String hashText = null;
        msg = (new StringBuilder()).append(msg).append(secret_key).toString();
        // System.out.println((new StringBuilder()).append("Value to hash::::::::::").append(msg).toString());
        try {
            m = MessageDigest.getInstance("SHA-512");
            try {
                m.update(msg.getBytes("UTF-8"), 0, msg.length());
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            hashText = (new BigInteger(1, m.digest())).toString(16);
            if (hashText.length() < 64) {
                int numberOfZeroes = 64 - hashText.length();
                String zeroes = "";
                for (int i = 0; i < numberOfZeroes; i++) {
                    zeroes = (new StringBuilder()).append(zeroes).append("0").toString();
                }

                hashText = (new StringBuilder()).append(zeroes).append(hashText).toString();
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        hashText = hashText.toUpperCase();
        System.out.println((new StringBuilder()).append("CPAY calculated Merchant intial request hash::::::").append(hashText).toString());
        return hashText;
    }
}
