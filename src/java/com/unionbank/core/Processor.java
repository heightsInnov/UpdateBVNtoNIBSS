package com.unionbank.core;

import com.unionbank.ADService.UserProfile;
import com.unionbank.webpay.db.dao.AuditDAO;
import com.unionbank.webpay.db.dao.CustomerData;
import com.unionbank.webpay.db.dao.MerchantsDAO;
import com.unionbank.webpay.db.dao.TransactionQueryResponse;
import com.unionbank.webpay.db.dao.TransactionsDAO;
import com.unionbank.webpay.db.dao.fileUploadData;
import com.unionbank.webpay.db.dao.vwTransactionsDAO;
import com.unionbank.webpay.parameters.ApplicationSettings;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.Mailer;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Processor {

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

    public static void mainn(String[] args) {
        Processor pp = new Processor();
        String hash = "";
        String SHA512hash = "";

        String tnx_ref = "3228282288";
        String product_id = "6205";
        String pay_item_id = "101";
        String amount = "5000";
        String site_redirect_url = "http://localhost:8080/UBNIntegrationToWebPay/UBNWebPayRedirect.jsp";
        String data = "<TransactionQueryResponse xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">\n\t<ResponseCode>00</ResponseCode>\n\t<ResponseDescription>Approved Successful</ResponseDescription>\n\t<Amount>5000</Amount>\n\t<CardNumber>0095</CardNumber>\n\t<MerchantReference>UBN/20150715172758</MerchantReference>\n\t<PaymentReference>FBN|WEB|WEBP|15-07-2015|132132</PaymentReference>\n\t<RetrievalReferenceNumber>000000076416</RetrievalReferenceNumber>\n\t<SplitAccounts />\n\t<TransactionDate>2015-07-15T17:31:14.987</TransactionDate>\n</TransactionQueryResponse>";

        processTxnRequest(data);
    }

    public String generateTxnID() {
        String txnid = "";
        String refseq = "";
        SimpleDateFormat sformatter_check2 = new SimpleDateFormat("yyyy");
        SimpleDateFormat sformatter_check = new SimpleDateFormat("yyyyMMddHHmmss");
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

    public String getNodeValue(String nodeElementPath, String message) {
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
            if (nod.getNodeType() == 1) {
                nodeValue = nod.getFirstChild() != null ? nod.getFirstChild().getNodeValue() : "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nodeValue;
    }

    public TransactionsDAO getBVNdetails(String BvNumber)
            throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {
        String savedHash = "";
        TransactionsDAO mert = new TransactionsDAO();
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        Connection conn = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        String vbnResponse = "";
        String xx = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<SearchResult>\n\t<ResultStatus>00</ResultStatus>\n\t<BvnSearchResult>\n\t\t<Bvn>12941630400</Bvn>\n\t\t<FirstName>Ayodeji</FirstName>\n\t\t<MiddleName>_</MiddleName>\n\t\t<LastName>Ajibade</LastName>\n\t\t<DateOfBirth>19-FEB-81</DateOfBirth>\n\t\t<PhoneNumber>08034930062</PhoneNumber>\n\t\t<RegistrationDate>21-MAR-14</RegistrationDate>\n\t\t<EnrollmentBank>900</EnrollmentBank>\n\t\t<EnrollmentBranch>_</EnrollmentBranch>\n\t\t<ImageBase64/>\n\t</BvnSearchResult>\n</SearchResult>";

        String Title = "";
        String FirstName = "";
        String MiddleName = "";
        String LastName = "";
        String DateOfBirth = "";
        String PhoneNumber = "";
        String responseCode = "";

        String email = "";
        String maritalStatus = "";
        String gender = "";
        String stateOfOrigin = "";
        String residentialAdd = "";
        String lga = "";

        String fFirstName = "";
        String fMiddleName = "";
        String fLastName = "";
        String fDateOfBirth = "";
        String fPhoneNumber = "";

        String femail = "";
        String fmaritalStatus = "";
        String fgender = "";
        String fstateOfOrigin = "";
        String fresidentialAdd = "";
        String flga = "";
        String BankEnroll = "";
        String BranchEnroll = "";
        String customerid = "";
        String WatchListed = "";

        byte[] image = null;

        securityInteface sd = new securityInteface();
        try {
            System.out.println("BvNumber<<>>" + BvNumber);
            vbnResponse = sd.validateBvn2(BvNumber);
//      vbnResponse = sd.validateBvn(BvNumber);
            System.out.println("vbnResponse<<>>" + vbnResponse);

//      FirstName = getNodeValue("/BVNSearchResult/FirstName", vbnResponse);
//      System.out.println("First name extracted is>>>>>" + FirstName);
//      MiddleName = getNodeValue("/BVNSearchResult/MiddleName", vbnResponse);
//      LastName = getNodeValue("/BVNSearchResult/LastName", vbnResponse);
//      DateOfBirth = getNodeValue("/BVNSearchResult/DateOfBirth", vbnResponse);
//      PhoneNumber = getNodeValue("/BVNSearchResult/PhoneNumber1", vbnResponse);
//      BankEnroll = getNodeValue("/BVNSearchResult/EnrollmentBank", vbnResponse);
//      BranchEnroll = getNodeValue("/BVNSearchResult/EnrollmentBranch", vbnResponse);
//      email = getNodeValue("/BVNSearchResult/Email", vbnResponse);
//      maritalStatus = getNodeValue("/BVNSearchResult/MaritalStatus", vbnResponse);
//      gender = getNodeValue("/BVNSearchResult/Gender", vbnResponse);
//      stateOfOrigin = getNodeValue("/BVNSearchResult/StateOfOrigin", vbnResponse);
//      residentialAdd = getNodeValue("/BVNSearchResult/ResidentialAddress", vbnResponse);
//      lga = getNodeValue("/BVNSearchResult/LgaOfOrigin", vbnResponse);
            Title = getNodeValue("/BVNSearchResult/Title", vbnResponse);
            WatchListed = getNodeValue("/BVNSearchResult/WatchListed", vbnResponse);
            FirstName = getNodeValue("/BVNSearchResult/FirstName", vbnResponse);
            System.out.println("First name extracted is>>>>>" + FirstName);
            MiddleName = getNodeValue("/BVNSearchResult/MiddleName", vbnResponse);
            LastName = getNodeValue("/BVNSearchResult/LastName", vbnResponse);
            DateOfBirth = getNodeValue("/BVNSearchResult/DateOfBirth", vbnResponse);
            PhoneNumber = getNodeValue("/BVNSearchResult/PhoneNumber1", vbnResponse);
            BankEnroll = getNodeValue("/BVNSearchResult/EnrollmentBank", vbnResponse);
            BranchEnroll = getNodeValue("/BVNSearchResult/EnrollmentBranch", vbnResponse);
            email = getNodeValue("/BVNSearchResult/Email", vbnResponse);
            maritalStatus = getNodeValue("/BVNSearchResult/MaritalStatus", vbnResponse);
            gender = getNodeValue("/BVNSearchResult/Gender", vbnResponse);
            stateOfOrigin = getNodeValue("/BVNSearchResult/StateOfOrigin", vbnResponse);
            residentialAdd = getNodeValue("/BVNSearchResult/ResidentialAddress", vbnResponse);
            lga = getNodeValue("/BVNSearchResult/LgaOfOrigin", vbnResponse);
            String imageNow = getNodeValue("/BVNSearchResult/ImageHashValue", vbnResponse);

            System.out.println("Image value is>>>>> " + imageNow);

            System.out.println("BankEnroll>>>>" + BankEnroll);
            System.out.println("BranchEnroll" + BranchEnroll);
//        
//      System.out.println("nodeList.SessionId<<>>" + vbnResponse.indexOf("<FirstName>"));
//      FirstName = vbnResponse.substring(vbnResponse.indexOf("<FirstName>"), vbnResponse.indexOf("</FirstName>"));
//      MiddleName = vbnResponse.substring(vbnResponse.indexOf("<MiddleName>"), vbnResponse.indexOf("</MiddleName>"));
//      LastName = vbnResponse.substring(vbnResponse.indexOf("<LastName>"), vbnResponse.indexOf("</LastName>"));
//      DateOfBirth = vbnResponse.substring(vbnResponse.indexOf("<DateOfBirth>"), vbnResponse.indexOf("</DateOfBirth>"));
//      PhoneNumber = vbnResponse.substring(vbnResponse.indexOf("<PhoneNumber>"), vbnResponse.indexOf("</PhoneNumber>"));
//     // responseCode = vbnResponse.substring(vbnResponse.indexOf("<ResultStatus>"), vbnResponse.indexOf("</ResultStatus>"));
            //  responseCode = "00";
            responseCode = getNodeValue("/BVNSearchResult/ResponseCode", vbnResponse);

            System.out.println("responseCode<<>>" + responseCode);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
            String qry = "select substr(REC_KEY, 1,9) as rec_key "
                    + "from cstm_function_userdef_fields "
                    + "where FUNCTION_ID ='STDCIF' AND field_val_1 ='" + BvNumber + "'";
            System.out.println("Query to get the customer id using bvn is>>>" + qry);

            pstmt1 = conn.prepareStatement(qry);
            if (pstmt1.execute()) {
                rs1 = pstmt1.getResultSet();
                if (rs1.next()) {
                    customerid = rs1.getString(1);
                    System.out.println("The customer id is ======" + customerid);
                }
            }
            System.out.println("-----Trying to get FCUBS data now--------");
            String query = "select a.first_name, "
                    + "a.middle_name, "
                    + "a.last_name ,  "
                    + "TRIM(a.date_of_birth), "
                    + "nvl(a.TELEPHONE,a.mobile_number) as phoneNumber, "
                    + "a.e_mail,  "
                    + "DECODE(c.marital_status, 'S','SINGLE', 'M' , 'MARRIED', 'D' , 'DIVORCED') as MaritalStatus, "
                    + "DECODE(a.sex, 'M','MALE', 'F' , 'FEMALE') as Gender, "
                    + "(a.d_address1||',' || a.d_address2 || ',' || a.d_address3) as address  "
                    + "from sttm_cust_personal a join sttm_customer b on B.CUSTOMER_NO = A.CUSTOMER_NO join sttm_cust_domestic c on B.CUSTOMER_NO = C.CUSTOMER_NO "
                    + "where B.CUSTOMER_NO = '" + customerid + "'";

            System.out.println("The query to get other details ia>>>>>" + query);
            pstmt = conn.prepareStatement(query);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
                if (rs.next()) {
                    fFirstName = rs.getString(1);
                    fMiddleName = rs.getString(2);
                    fLastName = rs.getString(3);
                    fDateOfBirth = rs.getString(4).trim();
                    System.out.println("date of birth is?????" + fDateOfBirth);
                    fPhoneNumber = rs.getString(5);
                    femail = rs.getString(6);
                    fmaritalStatus = rs.getString(7);
                    fgender = rs.getString(8);
                    fresidentialAdd = rs.getString(9);
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
            if (pstmt1 != null) {
                pstmt1.close();
            }
            if (rs1 != null) {
                rs1.close();
            }
        } catch (Exception e) {
            mert.setResponseCode("01");
            e.printStackTrace();
        }
        System.out.println("In The While Loop " + host_host);
        if (!BvNumber.equals("")) {
            mert.setResponseCode(responseCode);
            mert.setOldBvNumber(BvNumber);
            mert.setTitle(Title);
            mert.setWatchlisted(WatchListed);
            mert.setOldDateOfBirth(DateOfBirth);
            //mert.setOldEmailAdd("");
            mert.setOldEmailAdd(email);
            mert.setOldFirstName(FirstName);
            mert.setOldMiddleName(MiddleName);
            mert.setOldLastName(LastName);
            mert.setOldPhoneNumber(PhoneNumber);
//      mert.setOldMaritalStatus(maritalStatus);
//      mert.setOldGender(gender);
//      mert.setBankEnroll(BankEnroll);
//      mert.setBranchEnroll(BranchEnroll);
//      mert.setOldStateOfOrigin(stateOfOrigin);
//      mert.setOldResidentialStatus(residentialAdd);
//      mert.setOldLGA(lga);
//      mert.setImage(image);
//      
//      mert.setfFirstName(fFirstName);
//      mert.setfMiddleName(fMiddleName);
//      mert.setfLastName(fLastName);
//      mert.setfDoB(fDateOfBirth);
//      mert.setfMobileNumber(fPhoneNumber);
//      mert.setfEmailAdd(femail);
//      mert.setfMaritalStatus(fmaritalStatus);
//      mert.setfSex(fgender);
//      mert.setfResidentAddress(fresidentialAdd);

            mert.setOldMaritalStatus(maritalStatus);
            mert.setOldGender(gender);
            mert.setBankEnroll(BankEnroll);
            mert.setBranchEnroll(BranchEnroll);
            mert.setOldStateOfOrigin(stateOfOrigin);
            mert.setOldResidentialStatus(residentialAdd);
            mert.setOldLGA(lga);
            mert.setImage(image);

            mert.setfFirstName(fFirstName);
            mert.setfMiddleName(fMiddleName);
            mert.setfLastName(fLastName);
            mert.setfDoB(fDateOfBirth);
            mert.setfMobileNumber(fPhoneNumber);
            mert.setfEmailAdd(femail);
            mert.setfMaritalStatus(fmaritalStatus);
            mert.setfSex(fgender);
            mert.setfResidentAddress(fresidentialAdd);
        }
        return mert;
    }

    public TransactionsDAO getBVNdetailsold(String BvNumber) {
        String savedHash = "";
        TransactionsDAO mert = new TransactionsDAO();
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;

        System.out.println("In The While Loop " + this.host_host);
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
        double d;
        try {
            d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {

            return false;
        }
        return true;
    }

    public boolean processBVNAction(String message, String BVNNUmber, String BRANCH_CODE, String BRANCH_NAME, String E_MAIL, String TELEPHONE, String CUSTOMER_NO, String SEX, java.util.Date DATE_OF_BIRTH, String CUST_AC_NO, String AC_DESC, String ACCOUNT_CLASS, String RECORD_STAT, String AUTH_STAT, String BANKCODE) {
        Boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String MESSAGE_ID = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);

            String query = "INSERT INTO RECEIVED_BVN_LINK_RQS  ( MESSAGE_ID,BVNNUMBER,CUSTNO, BRANCH_CODE,BRANCH_NAME,E_MAIL,TELEPHONE,SEX,DATE_OF_BIRTH,CUST_AC_NO,AC_DESC,ACCOUNT_CLASS,RECORD_STAT,AUTH_STAT,CUSTNAME,bank_Code  ) VALUES ( ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, message);
            pstmt.setString(2, BVNNUmber);
            pstmt.setString(3, CUSTOMER_NO);
            pstmt.setString(4, BRANCH_CODE);
            pstmt.setString(5, BRANCH_NAME);
            pstmt.setString(6, E_MAIL);
            pstmt.setString(7, TELEPHONE);
            pstmt.setString(8, SEX);
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

    public boolean logAuditTrail(String auditCode, String userid) {
        Boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String Date_time = "";
        String MESSAGE_ID = "";

        System.out.println("got here auditCode <<>>>" + auditCode);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);

            String query = "INSERT INTO BVN_AUDIT_TRAIL (TXDID, AUDITCODE, USERID) VALUES (?,?,?)";

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
        Boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String Date_time = "";
        String MESSAGE_ID = "";
        String userEmail = "";
        String address = "";
        String department = "";
        String displayName = "";
        String employeeId = "";
        String firstName = "";
        String gradeLevel = "";
        String initials = "";
        String lastName = "";
        String mobileNumber = "";
        String telephoneNumber = "";
        String branchCode = "";
        String branchName = "";
        try {
            userEmail = (String) ursP.getEmail().getValue();
            if (userEmail == null) {
                userEmail = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            address = (String) ursP.getAddress().getValue();
            if (address == null) {
                address = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            department = (String) ursP.getDepartment().getValue();
            if (department == null) {
                department = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            displayName = (String) ursP.getDisplayName().getValue();
            if (displayName == null) {
                displayName = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            employeeId = (String) ursP.getEmployeeId().getValue();
            if (employeeId == null) {
                employeeId = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            firstName = (String) ursP.getFirstName().getValue();
            if (firstName == null) {
                firstName = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            gradeLevel = (String) ursP.getGradeLevel().getValue();
            if (gradeLevel == null) {
                gradeLevel = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            initials = (String) ursP.getInitials().getValue();
            if (initials == null) {
                initials = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            lastName = (String) ursP.getLastName().getValue();
            if (lastName == null) {
                lastName = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mobileNumber = (String) ursP.getMobileNumber().getValue();
            if (mobileNumber == null) {
                mobileNumber = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            telephoneNumber = (String) ursP.getTelephoneNumber().getValue();
            if (telephoneNumber == null) {
                telephoneNumber = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            branchCode = (String) ursP.getBranchCode().getValue();
            if (branchCode == null) {
                branchCode = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            branchName = (String) ursP.getBranchName().getValue();
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
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);

            String query = "INSERT INTO BVN_AUDIT_TRAIL  (AUDITCODE,USERID,displayName,employeeId,firstName,gradeLevel,initials,lastName,mobileNumber,telephoneNumber,branchCode,branchName,requestID  ) VALUES (  ?, ?,?,?,?,?,?,?,?,?,?,?,?)";

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
            String query = "select AC_DESC  from sttm_cust_account  where  CUST_AC_NO='" + acctNumber.trim() + "'\n" + "                      ";

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
            String query = "select * from file_upload_cach  where  field='" + parameter.trim() + "' and request_id ='" + requestid.trim() + "' " + "                      ";

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
        String BRANCH_CODE = "";
        String BRANCH_NAME = "";
        String E_MAIL = "";
        String TELEPHONE = "";
        String CUSTOMER_NO = "";
        String SEX = "";
        String CUST_AC_NO = "";
        String ACCOUNT_CLASS = "";
        String RECORD_STAT = "";
        String AUTH_STAT = "";
        int count = 0;

        boolean which = false;
        try {
            String query = "select d.BRANCH_CODE,d.BRANCH_NAME, b.E_MAIL,nvl(b.TELEPHONE,b.mobile_number) telephone,b.CUSTOMER_NO,b.SEX, b.DATE_OF_BIRTH, c.CUST_AC_NO,c.AC_DESC,c.ACCOUNT_CLASS,c.RECORD_STAT, c.AUTH_STAT\n                    \n                    \n                    from  sttm_cust_personal b,  sttm_cust_account c , sttm_branch d   \n                     where   b.CUSTOMER_NO = c.CUST_NO \n                      and  d.BRANCH_CODE = c.BRANCH_CODE\n                      \n                      and c.CUST_AC_NO='" + accountnumber + "'\n" + "                      ";

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
            System.out.println("This query <<>>" + query);
            pstmt = conn.prepareStatement(query);
            if (pstmt.execute()) {
                rs = pstmt.getResultSet();
                while (rs.next()) {
                    count++;
                    which = true;
                    System.out.println("This count <<>>" + count);

                    BRANCH_CODE = rs.getString("BRANCH_CODE");
                    BRANCH_NAME = rs.getString("BRANCH_NAME");
                    E_MAIL = rs.getString("E_MAIL");
                    TELEPHONE = rs.getString("telephone");
                    CUSTOMER_NO = rs.getString("CUSTOMER_NO");
                    SEX = rs.getString("SEX");
                    java.sql.Date DATE_OF_BIRTH = rs.getDate("DATE_OF_BIRTH");
                    CUST_AC_NO = rs.getString("CUST_AC_NO");
                    String AC_DESC = rs.getString("AC_DESC");
                    ACCOUNT_CLASS = rs.getString("ACCOUNT_CLASS");
                    RECORD_STAT = rs.getString("RECORD_STAT");
                    AUTH_STAT = rs.getString("AUTH_STAT");

                    boolean check = false;

                    check = processBVNAction("", bvn, BRANCH_CODE, BRANCH_NAME, E_MAIL, TELEPHONE, CUSTOMER_NO, SEX, DATE_OF_BIRTH, CUST_AC_NO, AC_DESC, ACCOUNT_CLASS, RECORD_STAT, AUTH_STAT, bankcode);
                    if (check) {
                        System.out.println("WAS OK PALY:");
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

            e.printStackTrace();
        }
    }

    public void UpdateNOTsucessful(String srcID) {
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
            String query = "UPDATE DUAL_MESSAGES_RECEIVED SET status = 'X', PROCESSED_DATE = sysdate WHERE MESSAGE_ID = '" + srcID + "'";

            pstmt = conn.prepareStatement(query);
            System.out.println("query " + query);
            pstmt.execute();
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            return;
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

    public void approveDenieFunction(String requestID, String decision, String checker, String checkerBRNcode, String tComment)
            throws SQLException {
        PreparedStatement pstmt = null;
        PreparedStatement pstmt2 = null;
        ResultSet result = null;
        Connection conn = null;
        String query = "";
        String query2 = "";
        String makeremail = "";
        String approverejectcomment = "";
        String bvn = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            System.out.println("I am about entering the query now ooo");
            System.out.println("decision is>>> " + decision);
            if (decision.equals("APPROVE")) {
                query = "UPDATE customer_update_req "
                        + "SET APPROVALSTATUS = 'Y', "
                        + "approve_reject_date = sysdate, "
                        + "checker  = '" + checker + "',"
                        + "checkerbranchcode  = '" + checkerBRNcode + "',"
                        + "TCOMMENT = '" + tComment + "' " + " "
                        + "WHERE REQUEST_ID = '" + requestID + "'";
                System.out.println("The query to update is " + query);
                pstmt = conn.prepareStatement(query);
                System.out.println("query " + query);
                pstmt.execute();
                query2 = "Select marker, tcomment,BVNUMBER "
                        + "from customer_update_req "
                        + "where APPROVALSTATUS = 'Y' "
                        + "and checker  = '" + checker + "' "
                        + "and REQUEST_ID = '" + requestID + "'";

                System.out.println("The query to select is " + query2);
                conn = DriverManager.getConnection(this.host_host, this.user, this.password);
                pstmt2 = conn.prepareStatement(query2);
                if (pstmt2.execute()) {
                    result = pstmt2.getResultSet();
                    while (result.next()) {
                        makeremail = result.getString("MARKER");
                        approverejectcomment = result.getString("TCOMMENT");
                        bvn = result.getString("BVNUMBER");
                        System.out.println("makeremail is>>>" + makeremail);
                        System.out.println("approvalcoment is>>>" + approverejectcomment);
                        System.out.println("bvn is>>>" + bvn);
                        //message = ("<html><body><div style=\"font-family:tahoma;font-size:12px;\"><p>Dear Team</p><br><p>Your request with BVN - " + bvn + " and Request ID: " + requestID + " has been approved by:</p><p>" + checker + "," + "<p>with the following comment: " + approverejectcomment + "" + "<br>" + "<br>" + "<p><strong>Thank you</strong><p>" + "<p>" + "</div>" + "</body>" + "</html>");
						message = composeMail(makeremail, bvn, requestID, "APPROVED", checker, approverejectcomment);
                    }
                    mail.Send(null, "info@unionbankng.com", makeremail, null, null, "REQUEST HAS BEEN APPROVED", this.message, null, null);
                }
            } else if (decision.equals("REJECT")) {
                query = "UPDATE customer_update_req "
                        + "SET APPROVALSTATUS = 'X', "
                        + "approve_reject_date = sysdate, "
                        + "checker  = '" + checker + "',"
                        + "checkerbranchcode   = '" + checkerBRNcode + "',"
                        + "TCOMMENT = '" + tComment + "' " + " "
                        + "WHERE REQUEST_ID = '" + requestID + "'";
                System.out.println("The query to update is " + query);
                pstmt = conn.prepareStatement(query);
                pstmt.execute();
                conn = DriverManager.getConnection(host_host, user, password);
				query2 = "Select marker, tcomment,BVNUMBER "
                        + "from customer_update_req "
                        + "where APPROVALSTATUS = 'X' "
                        + "and checker  = '" + checker + "' "
                        + "and REQUEST_ID = '" + requestID + "'";
                pstmt2 = conn.prepareStatement(query2);
                if (pstmt2.execute()) {
                    result = pstmt2.getResultSet();
                    while (result.next()) {
                        makeremail = result.getString("MARKER");
                        approverejectcomment = result.getString("TCOMMENT");
                        bvn = result.getString("BVNUMBER");
                        System.out.println("makeremail is>>>" + makeremail);
                        System.out.println("approvalcoment is>>>" + approverejectcomment);
                        //this.message = ("<html><body><div style=\"font-family:tahoma;font-size:12px;\"><p>Dear Team</p><br><p>Your request with BVN - " + bvn + " and Request ID: " + requestID + " has been rejected by:</p><p>" + checker + "," + "<p>with the following comment: " + approverejectcomment + "" + "<br>" + "<br>" + "<p><strong>Thank you</strong><p>" + "<p>" + "</div>" + "</body>" + "</html>");
						this.message = composeMail(makeremail, bvn, requestID, "REJECTED", checker, approverejectcomment);
                    }
                    this.mail.Send(null, "info@unionbankng.com", makeremail, null, null, "REQUEST HAS BEEN REJECTED", this.message, null, null);
                }
            }
            //}
            if (pstmt != null) {
                pstmt.close();
            }
            if (pstmt2 != null) {
                pstmt2.close();
            }
            if (conn != null) {
                conn.close();
            }
            return;
        } catch (Exception ex) {
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
	
	private String composeMail(String marker, String bvn, String requestID, String decision, String checker, String approverejectcomment) {
		
		if (marker.contains("@")) {
			marker = marker.substring(0, marker.indexOf("@")).toUpperCase();
			System.out.println("Substringed marker is >>" + marker);
		}
		String body = "";

		body += "<html>\n"
				+ "\n"
				+ "<head>\n"
				+ "\n"
				+ "    <style>\n"
				+ "        /* Style Definitions */\n"
				+ "        p.MsoNormal, li.MsoNormal, div.MsoNormal {\n"
				+ "            mso-style-unhide: no;\n"
				+ "            mso-style-qformat: yes;\n"
				+ "            mso-style-parent: '';\n"
				+ "            margin: 0in;\n"
				+ "            margin-bottom: .0001pt;\n"
				+ "            mso-pagination: widow-orphan;\n"
				+ "            font-size: 11.0pt;\n"
				+ "            font-family: 'Calibri','sans-serif';\n"
				+ "            mso-fareast-font-family: Calibri;\n"
				+ "            mso-fareast-theme-font: minor-latin;\n"
				+ "            mso-bidi-font-family: 'Times New Roman';\n"
				+ "        }\n"
				+ "\n"
				+ "        a:link, span.MsoHyperlink {\n"
				+ "            mso-style-noshow: yes;\n"
				+ "            mso-style-priority: 99;\n"
				+ "            color: #0563C1;\n"
				+ "            text-decoration: underline;\n"
				+ "            text-underline: single;\n"
				+ "        }\n"
				+ "\n"
				+ "        a:visited, span.MsoHyperlinkFollowed {\n"
				+ "            mso-style-noshow: yes;\n"
				+ "            mso-style-priority: 99;\n"
				+ "            color: #954F72;\n"
				+ "            text-decoration: underline;\n"
				+ "            text-underline: single;\n"
				+ "        }\n"
				+ "\n"
				+ "        p.msonormal0, li.msonormal0, div.msonormal0 {\n"
				+ "            mso-style-name: msonormal;\n"
				+ "            mso-style-unhide: no;\n"
				+ "           mso-margin-top-alt: auto;\n"
				+ "            margin-right: 0in;\n"
				+ "            mso-margin-bottom-alt: auto;\n"
				+ "            margin-left: 0in;\n"
				+ "            mso-pagination: widow-orphan;\n"
				+ "           font-size: 12.0pt;\n"
				+ "            font-family: 'Times New Roman','serif';\n"
				+ "            mso-fareast-font-family: Calibri;\n"
				+ "            mso-fareast-theme-font: minor-latin;\n"
				+ "        }\n"
				+ "    </style>\n"
				+ "\n"
				+ "</head>\n"
				+ "\n"
				+ "<body>\n"
				+ "\n"
				+ "    <div>\n"
				+ "\n"
				+ "\n"
				+ "        <p class=MsoNormal>\n"
				+ "            <span style='color:black'></span>\n"
				+ "        </p>\n"
				+ "\n"
				+ "        <div align=center>\n"
				+ "\n"
				+ "            <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width=600\n"
				+ "                   style='width:6.25in;border-collapse:collapse;'>\n"
				+ "                <tr>\n"
				+ "                    <td style='background:#009FDF;padding:0in 0in 0in 0in'>\n"
				+ "                        <p class=MsoNormal style='line-height:105%'><span style='color:black'>&nbsp;</span><span style='font-size:12.0pt;line-height:105%;'></span></p>\n"
				+ "                        <table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width=\"100%\">\n"
				+ "                            <tr>\n"
				+ "                                <td style='padding:11.25pt 11.25pt 22.5pt 0in'>\n"
				+ "                                    <p class=MsoNormal align=right style='text-align:right;line-height:105%'>\n"
				+ "                                        <span style='font-size:12.0pt;line-height:105%;'>\n"
				+ "\n"
				+ "\n"
				+ "                                            <img width=\"113\" height=\"47\" src=\"..\\images\\ubn.gif\" />\n"
				+ "                                            <!--<img width=\"113\" height=\"47\" src=\"cid:stallion\" />-->\n"
				+ "\n"
				+ "                                        </span>\n"
				+ "                                    </p>\n"
				+ "                                </td>\n"
				+ "                            </tr>\n"
				+ "                            <tr>\n"
				+ "                                <td style='padding:0in 0in 7.5pt 15.0pt'>\n"
				+ "                                    <p class=MsoNormal>\n"
				+ "                                        <b>\n"
				+ "                                            <span style='font-family:\"Arial\",\"sans-serif\";color:white'>\n"
				+ "                                                BVN UPDATE PORTAL\n"
				+ "                                            </span>\n"
				+ "                                        </b><b>\n"
				+ "                                            <span style='font-family:\"Arial\",\"sans-serif\"'></span>\n"
				+ "                                        </b>\n"
				+ "                                    </p>\n"
				+ "                                </td>\n"
				+ "                            </tr>\n"
				+ "                        </table>\n"
				+ "                    </td>\n"
				+ "                </tr>\n"
				+ "                <tr>\n"
				+ "                    <td style='background:#E5E5E5;padding:30.0pt 30.0pt 30.0pt 30.0pt'>\n"
				+ "                        <table class=MsoNormalTable border=0 cellspacing=3 cellpadding=0>\n"
				+ "                            <tr>\n"
				+ "                                <td style='padding:.75pt .75pt .75pt .75pt'>\n"
				+ "                                <p>Dear " + marker + ",</p>\n"
				+ "                                <p>\n"
				+ "                                   Your request with BVN - <strong>" + bvn + "</strong> and Request ID: <strong>" + requestID + "</strong> <br/>"
				+ "									has been <strong>" + decision + "</strong> by: "+ checker +" with the following comment: "+approverejectcomment+".\n"
				+ "                                </p>\n"
				+ "								   <p>\n"
				+ "									<strong>Thank you. </strong></p> \n"
				+ "                                <!--<p>Plan : Auto Comprehensive</p>              \n"
				+ "                               table border='0' cellpadding='0' cellspacing='0' width='100%'>\n"
				+ "                                <tr>\n"
				+ "                                    <td>\n"
				+ "                                        <p>Has been {ApprovalState} by your supervisor {SupervisorFullName}</p>\n"
				+ "                                        <p><a href=\"{Link}\">{Link}</a></p>\n"
				+ "                                        <p><br/></p>                   \n"
				+ "                                        <p><br/><br/>\n"
				+ "                                        Regards,</p>\n"
				+ "                                    </td>\n"
				+ "                                </tr>\n"
				+ "                                </table-->\n"
				+ "\n"
				+ "                                    <p class=MsoNormal style='text-align:justify'>\n"
				+ "                                        <span style='font-family:\n"
				+ "    \"Arial\",\"sans-serif\"'></span>\n"
				+ "                                    </p>\n"
				+ "                                    <p class=MsoNormal style='text-align:justify'>\n"
				+ "                                        <i>\n"
				+ "                                            <span style='font-family:\n"
				+ "    \"Arial\",\"sans-serif\"'>&nbsp;</span>\n"
				+ "                                        </i><span style='font-family:\"Arial\",\"sans-serif\"'></span>\n"
				+ "                                    </p>\n"
				+ "\n"
				+ "                                </td>\n"
				+ "\n"
				+ "                            </tr>\n"
				+ "                            <tr>\n"
				+ "                                <td style='padding:.75pt .75pt .75pt .75pt'>\n"
				+ "                                    <table class=MsoNormalTable border=0 cellspacing=3 cellpadding=0>\n"
				+ "                                        <tr>\n"
				+ "                                           <td style='padding:.75pt .75pt .75pt .75pt'>\n"
				+ "                                                <p class=MsoNormal style='text-align:justify;line-height:105%'>\n"
				+ "                                                    <a href=\"https://www.facebook.com/UnionBankng\">\n"
				+ "                                                        <span style='font-size:7.5pt;\n"
				+ "      line-height:105%;font-family:\"Arial\",\"sans-serif\";color:black;text-decoration:\n"
				+ "      none;text-underline:none'>\n"
				+ "\n"
				+ "                                                            <img border=0 width=7 height=12 src=\"cid:facebook\">\n"
				+ "\n"
				+ "                                                        </span><span style='font-size:7.5pt;line-height:105%;font-family:\"Arial\",\"sans-serif\";\n"
				+ "      color:black'>unionbankng</span>\n"
				+ "                                                    </a><span style='font-size:12.0pt;\n"
				+ "      line-height:105%;font-family:\"Times New Roman\",\"serif\"'></span>\n"
				+ "                                                </p>\n"
				+ "                                            </td>\n"
				+ "                                            <td style='padding:.75pt .75pt .75pt .75pt'>\n"
				+ "                                                <p class=MsoNormal style='text-align:justify;line-height:105%'>\n"
				+ "                                                    <a href=\"https://twitter.com/UNIONBANK_NG\">\n"
				+ "                                                        <span style='font-size:7.5pt;\n"
				+ "      line-height:105%;font-family:\"Arial\",\"sans-serif\";color:black;text-decoration:\n"
				+ "      none;text-underline:none'>\n"
				+ "\n"
				+ "                                                            <img border=0 width=12 height=10 src=\"cid:twitter\">\n"
				+ "\n"
				+ "                                                        </span><span style='font-size:7.5pt;line-height:105%;font-family:\"Arial\",\"sans-serif\";\n"
				+ "      color:black'>unionbank_ng</span>\n"
				+ "                                                    </a><span style='font-size:12.0pt;\n"
				+ "      line-height:105%;font-family:\"Times New Roman\",\"serif\"'><o:p></o:p></span>\n"
				+ "                                                </p>\n"
				+ "                                            </td>\n"
				+ "                                            <td style='padding:.75pt .75pt .75pt .75pt'>\n"
				+ "                                                <p class=MsoNormal style='text-align:justify;line-height:105%'>\n"
				+ "                                                    <a href=\"https://www.youtube.com/user/UnionBankNG\">\n"
				+ "                                                        <span style='font-size:\n"
				+ "      7.5pt;line-height:105%;font-family:\"Arial\",\"sans-serif\";color:black;\n"
				+ "      text-decoration:none;text-underline:none'>\n"
				+ "\n"
				+ "                                                            <img border=0 width=13 height=12 src=\"cid:youtube\">\n"
				+ "\n"
				+ "                                                        </span><span style='font-size:7.5pt;line-height:105%;font-family:\"Arial\",\"sans-serif\";\n"
				+ "      color:black'>unionbankng</span>\n"
				+ "                                                    </a><span style='font-size:12.0pt;\n"
				+ "      line-height:105%;font-family:\"Times New Roman\",\"serif\"'></span>\n"
				+ "                                                </p>\n"
				+ "                                            </td>\n"
				+ "                                            <td width=235 style='width:176.5pt;padding:.75pt .75pt .75pt .75pt'>\n"
				+ "                                                <p class=MsoNormal style='text-align:justify;line-height:105%'>\n"
				+ "                                                    <a href=\"https://instagram.com/unionbankng\">\n"
				+ "                                                        <span style='font-size:7.5pt;\n"
				+ "      line-height:105%;font-family:\"Arial\",\"sans-serif\";color:black;text-decoration:\n"
				+ "      none;text-underline:none'>\n"
				+ "\n"
				+ "                                                            <img border=0 width=11 height=12 src=\"cid:instagram\">\n"
				+ "\n"
				+ "                                                        </span><span style='font-size:7.5pt;line-height:105%;font-family:\"Arial\",\"sans-serif\";\n"
				+ "      color:black'>unionbankng</span>\n"
				+ "                                                    </a><span style='font-size:12.0pt;\n"
				+ "      line-height:105%;font-family:\"Times New Roman\",\"serif\"'></span>\n"
				+ "                                                </p>\n"
				+ "                                            </td>\n"
				+ "                                        </tr>\n"
				+ "                                    </table>\n"
				+ "                                </td>\n"
				+ "                            </tr>\n"
				+ "                        </table>\n"
				+ "                    </td>\n"
				+ "                </tr>\n"
				+ "                <tr>\n"
				+ "                    <td style='background:#009FDF;padding:22.5pt 22.5pt 22.5pt 22.5pt'></td>\n"
				+ "                </tr>\n"
				+ "            </table>\n"
				+ "\n"
				+ "        </div>\n"
				+ "\n"
				+ "       <p class=MsoNormal></p>\n"
				+ "\n"
				+ "        <p class=MsoNormal><span style='color:#1F497D'></span></p>\n"
				+ "\n"
				+ "    </div>\n"
				+ "\n"
				+ "</body>\n"
				+ "\n"
				+ "</html>";

		return body;
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
            conn = DriverManager.getConnection(this.host_alert, this.user_alert, this.password_alert);
            String message = "";
            if (serviceType.equalsIgnoreCase("BVN")) {
                message = "Union>>>Your request to link BVN NO: " + otheritem + " was received and is being processed.\nThank You.";
            } else {
                message = "Union>>>Service Request \n" + serviceType + " on Acct No: " + acctNo + "\nWas Successful ";
            }
            String query1 = "insert into sms_message_queue(MESSAGE_ID, MESSAGE_PART_NO, QUEUE_DATE, MOBILE_NO, MESSAGE_TEXT, RETRY_COUNT, STATUS, REQUESTOR_ID, QUEUE_GROUP, MESSAGE_TYPE, CHECKSUM,ACCOUNT_NO,SOURCE) values('" + messID + "', '1', sysdate, '" + srcPhone + "', " + "'" + message + "', '0', 'NEW', '" + custid + "', '0', 'SMS', '" + messID + "','" + acctNo + "','SMSBANK')";

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
            return;
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
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
            String query = "UPDATE DUAL_MESSAGES_RECEIVED "
                    + "SET status = 'Y', "
                    + "PROCESSED_DATE = sysdate "
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
            return;
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
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
            String query = "UPDATE DUAL_MESSAGES_RECEIVED SET status = 'Y', PROCESSED_DATE = sysdate WHERE MESSAGE_ID = '" + srcID + "'";

            pstmt = conn.prepareStatement(query);
            System.out.println("query " + query);
            pstmt.execute();
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            return;
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

        List<vwTransactionsDAO> tTransactionsList = new ArrayList<vwTransactionsDAO>();
        vwTransactionsDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select * from vwMerchtTransList WHERE  rownum <=250 order by DATE_CREATED desc";
            System.out.println("The Host-Host " + this.host_host);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
                count++;
                mert.setTxnId(rs.getLong("TXN_ID"));
                mert.setAmountLc(rs.getString("amount_local"));

                java.util.Date taskStartDate = rs.getTimestamp("date_created");
                mert.setDateCreated(taskStartDate);

                mert.setResponseUpdateDate(taskStartDate);
                mert.setMerchantName(rs.getString("merchant_name"));
                mert.setPayRef(rs.getString("pay_ref"));
                mert.setResponseCode(rs.getString("response_code"));
                mert.setResponseDesc(rs.getString("response_desc"));

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
            String query = "select * from UBNPAY_Merchants WHERE pay_item_id ='" + itemId + "'  and AUTH_FLAG='Y'  and DISABLE_FLAG='N' ";
            System.out.println("The Host-Host " + this.host_host);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
                System.out.println("In The While Loop " + this.host_host);
                count++;
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

    public boolean validateAmount(String amount) {
        double amount_t = 0.0D;
        boolean ok = false;
        try {
            if (amount.contains(".")) {
                ok = false;
            } else {
                amount_t = Double.valueOf(amount).doubleValue();
                if (amount_t <= 0.0D) {
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

    public static TransactionQueryResponse processTxnRequest(String data) {
        TransactionQueryResponse TransnQueryResponse = new TransactionQueryResponse();
        try {
            String MessageId = "";
            String LongCode = "";
            String MessageBody = "";
            String SourcePhone = "";
            String ProcessedDate = "";
            String Status = "";
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
                if (nNode.getNodeType() == 1) {
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
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TransnQueryResponse;
    }

    public String gettxnRefsqquence() {
        String refsequence = "";
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = 0;
        try {
            while (rs.next()) {
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

        List<TransactionsDAO> tTransactionsList = new ArrayList<TransactionsDAO>();
        TransactionsDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select * from customer_update_req WHERE APPROVALSTATUS='" + decision.trim() + "'   ORDER BY RECEIVED_DATE  DESC";

            System.out.println("The Host-Host " + this.host_host);
            System.out.println("The query<<>>> " + query);

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
                count++;
				mert.setRequestID(rs.getString("REQUEST_ID"));
				
				mert.setTitle(rs.getString("TITLE"));
				mert.setNewTitle(rs.getString("NEWTITLE"));
				mert.setCommentTitle(rs.getString("COMMENTTITLE"));
				
				mert.setOldFirstName(rs.getString("OLDFIRSTNAME"));
				mert.setfFirstName(rs.getString("FFIRSTNAME"));
				mert.setNewFirstName(rs.getString("NEWFIRSTNAME"));
				mert.setFirstNameComment(rs.getString("FIRSTNAMECOMMENT"));
				
				mert.setOldMiddleName(rs.getString("OLDMIDDLENAME"));
				mert.setfMiddleName(rs.getString("FMIDDLENAME"));
				mert.setNewMiddleName(rs.getString("NEWMIDDLENAME"));
				mert.setMiddleNameComment(rs.getString("MIDDLECOMMENT"));
				
				mert.setOldLastName(rs.getString("OLDLASTNAME"));
				mert.setfLastName(rs.getString("FLASTNAME"));
				mert.setNewLastName(rs.getString("NEWLASTNAME"));
				mert.setLastNameComment(rs.getString("LASTNAMECOMMENT"));
				
				mert.setOldDateOfBirth(rs.getString("OLDDATEOFBIRTH"));
				mert.setfDoB(rs.getString("FDOB"));
				mert.setNewDateOfBirth(rs.getString("NEWDATEOFBIRTH"));
				mert.setDobComment(rs.getString("DOBCOMMENT"));
				
				mert.setOldMaritalStatus(rs.getString("OLDMARITALSTATUS"));
				mert.setfMaritalStatus(rs.getString("FMARITALSTATUS"));
				mert.setNewMaritalStatus(rs.getString("NEWMARITALSTATUS"));
				mert.setMaritalStatusComment(rs.getString("MARITALSTATUSCOMMENT"));
				System.out.println("Names and aname >>"+ mert.getOldMaritalStatus());
				
				
				mert.setOldGender(rs.getString("OLDGENDER"));
				mert.setfGender(rs.getString("FGENDER"));
				mert.setNewGender(rs.getString("NEWGENDER"));
				mert.setCommentGender(rs.getString("COMMENTGENDER"));
				
				mert.setOldStateOfOrigin(rs.getString("OLDSTATEOFORIGIN"));
				mert.setfStateOfOrigin(rs.getString("FSTATEOFORIGIN"));
				mert.setNewStateOfOrigin(rs.getString("NEWSTATEOFORIGIN"));
				mert.setStateOfOriginComment(rs.getString("STATEOFORIGINCOMMENT"));
				
				mert.setOldResidentialStatus(rs.getString("OLDRESIDENTIALSTATUS"));
				mert.setfResidentAddress(rs.getString("FRESIDENTIALADD"));
				mert.setNewResidentialStatus(rs.getString("NEWRESIDENTIALSTATUS"));
				mert.setResidentialStatusComment(rs.getString("RESIDENTIALSTATUSCOMMENT"));
				
				mert.setOldLGA(rs.getString("OLDLGA"));
				mert.setfLga(rs.getString("FLGA"));
				mert.setNewLGA(rs.getString("NEWLGA"));
				mert.setLgaComment(rs.getString("LGACOMMENT"));
				
				mert.setOldPhoneNumber(rs.getString("OLDPHONENUMBER"));
				mert.setfMobileNumber(rs.getString("FPHONENUMBER"));
				mert.setNewPhoneNumber(rs.getString("NEWPHONENUMBER"));
				mert.setPhoneNoComment(rs.getString("PHONENOCOMMENT"));
				
				mert.setOldEmailAdd(rs.getString("OLDEMAILADD"));
				mert.setfEmailAdd(rs.getString("FEMAIL"));
				mert.setNewEmailAdd(rs.getString("NEWEMAILADD"));
				mert.setEmailComment(rs.getString("EMAILCOMMENT"));
				
				mert.setBvNumber(rs.getString("BVNUMBER"));
				
				mert.setRecieveDate(rs.getString("RECEIVED_DATE"));
				mert.setApprovalStatus(rs.getString("APPROVALSTATUS"));
				mert.setApprovedate(rs.getString("APPROVE_REJECT_DATE"));
				
				mert.setMaker(rs.getString("MARKER"));
				mert.setChecker(rs.getString("CHECKER"));
				mert.setRejectComment(rs.getString("TCOMMENT"));
				
				mert.setFileAddress(rs.getString("UPLOADPATH1"));
				mert.setFileAddress2(rs.getString("UPLOADPATH2"));
				mert.setFileAddress3(rs.getString("UPLOADPATH3"));

                System.out.println("The title obtained is====== " + mert.getTitle());
//        mert.setfLga(rs.getString("WATCHLISTED"));

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

    public List<TransactionsDAO> getBVNList() {
        String savedHash = "";

        List<TransactionsDAO> tTransactionsList = new ArrayList<TransactionsDAO>();
        TransactionsDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "SELECT BVN FROM BVNBULKUPLOADTEST WHERE STATUS IS NULL";

            System.out.println("The Host-Host " + this.host_host);
            System.out.println("The query<<>>> " + query);

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
                count++;
                mert.setBvNumber(rs.getString("BVN"));

                System.out.println("The bvn obtained is====== " + mert.getTitle());
//        mert.setfLga(rs.getString("WATCHLISTED"));

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

        List<AuditDAO> tTransactionsList = new ArrayList();
        AuditDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            //String query = "select b.AUDITDESC, a.* from BVN_AUDIT_TRAIL  a , BVN_AUDIT_DESC b \nwhere \n b.AUDITCODE =a.AUDITCODE\n \n \n order by DATETIME desc";
            String query = "select * from BVN_AUDIT_TRAIL";

            System.out.println("The Host-Host " + this.host_host);
            System.out.println("The query<<>>> " + query);

            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
                count++;
                mert.setUserId(rs.getString("USERID"));
//        mert.setDateTime(rs.getString("DATETIME"));
//        mert.settAddress(rs.getString("ADDRESS"));
                // mert.settDepartment(rs.getString("DEPARTMENT"));
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
                //mert.setAuditDesc(rs.getString("AUDITDESC"));
                mert.setAuditDesc(rs.getString("AUDITCODE"));
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

        List<TransactionsDAO> tTransactionsList = new ArrayList();
        TransactionsDAO mert = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String query = "select * from customer_update_req WHERE  APPROVALSTATUS='" + decision.trim() + "'   and REQUEST_ID = '" + requestid.trim() + "'  ORDER BY RECEIVED_DATE  DESC";
            System.out.println("The Host-Host " + this.host_host);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);
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
                count++;
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
                mert.setNewDateOfBirth(rs.getString("NEWDATEOFBIRTH") == null ? "" : rs.getString("NEWDATEOFBIRTH").trim());

                //invoice.setSendingCorrespSeqID(rs.getString("SendingCorrespSeqID") == null ? "" : rs.getString("SendingCorrespSeqID").trim());
                mert.setOldDateOfBirth(rs.getString("OLDDATEOFBIRTH").trim());
                mert.setApprovalStatus(rs.getString("APPROVALSTATUS"));
                mert.setBvNumber(rs.getString("BVNUMBER"));
                mert.setFirstNameComment(rs.getString("FIRSTNAMECOMMENT"));
                mert.setMiddleNameComment(rs.getString("MIDDLECOMMENT"));
                mert.setLastNameComment(rs.getString("LASTNAMECOMMENT"));
                mert.setDobComment(rs.getString("DOBCOMMENT"));
                mert.setPhoneNoComment(rs.getString("PHONENOCOMMENT"));
                mert.setEmailComment(rs.getString("EMAILCOMMENT"));
                mert.setfFirstName(rs.getString("FFIRSTNAME"));
                mert.setfMiddleName(rs.getString("FMIDDLENAME"));
                mert.setfLastName(rs.getString("FLASTNAME"));
                mert.setfDoB(rs.getString("FDOB"));
                mert.setfMobileNumber(rs.getString("FPHONENUMBER"));
                mert.setfEmailAdd(rs.getString("FEMAIL"));
                mert.setMaker(rs.getString("MARKER"));

                mert.setOldMaritalStatus(rs.getString("OLDMARITALSTATUS"));
                mert.setNewMaritalStatus(rs.getString("NEWMARITALSTATUS"));
                mert.setMaritalStatusComment(rs.getString("MARITALSTATUSCOMMENT"));
                mert.setfMaritalStatus(rs.getString("FMARITALSTATUS"));

                mert.setOldGender(rs.getString("OLDGENDER"));
                mert.setNewGender(rs.getString("NEWGENDER"));
                mert.setCommentGender(rs.getString("COMMENTGENDER"));
                mert.setfSex(rs.getString("FGENDER"));

                mert.setOldStateOfOrigin(rs.getString("OLDSTATEOFORIGIN"));
                mert.setNewStateOfOrigin(rs.getString("NEWSTATEOFORIGIN"));
                mert.setStateOfOriginComment(rs.getString("STATEOFORIGINCOMMENT"));
                mert.setfStateOfOrigin(rs.getString("FSTATEOFORIGIN"));

                mert.setOldResidentialStatus(rs.getString("OLDRESIDENTIALSTATUS"));
                mert.setNewResidentialStatus(rs.getString("NEWRESIDENTIALSTATUS"));
                mert.setResidentialStatusComment(rs.getString("RESIDENTIALSTATUSCOMMENT"));
                mert.setfResidentAddress(rs.getString("FRESIDENTIALADD"));

                mert.setOldLGA(rs.getString("OLDLGA"));
                mert.setNewLGA(rs.getString("NEWLGA"));
                mert.setLgaComment(rs.getString("LGACOMMENT"));
                mert.setfLga(rs.getString("FLGA"));
                mert.setTitle(rs.getString("TITLE"));
                mert.setFileAddress(rs.getString("UPLOADPATH1"));
                System.out.println("The title obtained 222 is======> " + mert.getTitle());

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

    public boolean processBVNUpdateRequest(CustomerData[] obj, String BvNumber, String txnId, String maker, String branch) {
        Boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        String MESSAGE_ID = "";

        String mainTxID = "";
        String displayname = "";
        String Branch = "";
        String oldBvNumber = "";
        String oldFirstName = "";
        String newFirstName = "";
        String firstNameComment = "";
        String oldMiddleName = "";
        String newMiddleName = "";
        String MiddleComment = "";
        String oldLastName = "";
        String newLastName = "";
        String LastComment = "";
        String oldDOBName = "";
        String newDOBName = "";
        String DOBComment = "";
        String oldPhoneNumber = "";
        String newPhoneNumber = "";
        String phoneNOComment = "";
        String oldEmailAdd = "";
        String newEmailAdd = "";
        String emailComment = "";
        String oldStateOfOrigin = "";
        String newStateOfOrigin = "";
        String stateOfOriginComment = "";
        String oldLGA = "";
        String newLGA = "";
        String lgaComment = "";
        String oldMaritalStatus = "";
        String newMaritalStatus = "";
        String maritalStatusComment = "";
        String oldResidentialStatus = "";
        String newResidentialStatus = "";
        String residentialStatusComment = "";
        String oldGender = "";
        String newGender = "";
        String commentGender = "";
        String bankOfEnrollment = "";
        String branchOfEnrollment = "";
        String title = "";
        String newTitle = "";
        String commentTitle = "";
        String watchlisted = "";
        String fFirstName = "";
        String fMiddleName = "";
        String fLastName = "";
        String fDob = "";
        String fPhoneNumber = "";
        String fEmail = "";
        String fStateOrigin = "";
        String fLga = "";
        String fMaritalstat = "";
        String fResidentialadd = "";
        String fGender = "";
        String userEmail = "";

        java.sql.Date oldDateConverted = null;
        java.sql.Date newDateConverted = null;

        java.util.Date date1 = null;
        java.util.Date date2 = null;
        try {
            System.out.println("obj.length<<>> " + obj.length);
            for (int i = 0; i < obj.length; i++) {
                System.out.println("obj[i].getField" + obj[i].getField());
                if (obj[i].getField().trim().equalsIgnoreCase("Bank Of Enrollment")) {
                    System.out.println("obj Bank Of Enrollment" + obj[i].getNIBSS());
                    bankOfEnrollment = obj[i].getNIBSS();
                    System.out.println("The bank of enrollmnet value is>>>>" + bankOfEnrollment);
                }

                if (obj[i].getField().trim().equalsIgnoreCase("Watchlisted?")) {
                    System.out.println("obj Watchlisted" + obj[i].getNIBSS());
                    watchlisted = obj[i].getNIBSS();
                    System.out.println("The Watchlisted value is>>>>" + watchlisted);
                }
                if (obj[i].getField().trim().equalsIgnoreCase("Title")) {
                    System.out.println("obj Title" + obj[i].getNIBSS());
                    title = obj[i].getNIBSS();
                    System.out.println("The Title value is>>>>" + title);
                    newTitle = obj[i].getModification();
                    System.out.println("The new title is >>>>" + newTitle);
                    commentTitle = obj[i].getComment();
                    System.out.println("The title is>>> " + commentTitle);
                }

                if (obj[i].getField().equalsIgnoreCase("Branch Of Enrollment")) {
                    System.out.println("obj Branch Of Enrollment " + obj[i].getNIBSS());
                    branchOfEnrollment = obj[i].getNIBSS();
                    System.out.println("The branch of enrollment is>>>>" + branchOfEnrollment);
                }
                if (obj[i].getField().equalsIgnoreCase("First Name")) {
                    System.out.println("obj First Name " + obj[i].getNIBSS());
                    oldFirstName = obj[i].getNIBSS();
                    System.out.println("The oldFirstName is>>>>" + oldFirstName);
                    fFirstName = obj[i].getFCUBS();
                    newFirstName = obj[i].getModification();
                    System.out.println("The new first name is >>>>" + newFirstName);
                    firstNameComment = obj[i].getComment();
                    System.out.println("The firstname comment is>>> " + firstNameComment);
                }
                if (obj[i].getField().equalsIgnoreCase("Middle Name")) {
                    System.out.println("obj Middle Name " + obj[i].getNIBSS());
                    oldMiddleName = obj[i].getNIBSS();
                    System.out.println("The oldMiddleName is>>>" + oldMiddleName);
                    fMiddleName = obj[i].getFCUBS();
                    newMiddleName = obj[i].getModification();
                    System.out.println("The newMiddleName is >>>>" + newMiddleName);
                    MiddleComment = obj[i].getComment();
                }
                if (obj[i].getField().equalsIgnoreCase("Last Name")) {
                    System.out.println("obj Last name" + obj[i].getNIBSS());
                    oldLastName = obj[i].getNIBSS();
                    System.out.println("The oldLastName is>>>>" + oldLastName);
                    fLastName = obj[i].getFCUBS();
                    newLastName = obj[i].getModification();
                    System.out.println("The newLastName is>>>" + newLastName);
                    LastComment = obj[i].getComment();
                }
                if (obj[i].getField().equalsIgnoreCase("State Of Origin")) {
                    System.out.println("obj State Of Origin" + obj[i].getNIBSS());
                    oldStateOfOrigin = obj[i].getNIBSS();
                    System.out.println("The oldStateOfOrigin is>>>>" + oldStateOfOrigin);
                    fStateOrigin = obj[i].getFCUBS();
                    newStateOfOrigin = obj[i].getModification();
                    System.out.println("The newStateOfOrigin is >>>>" + newStateOfOrigin);
                    stateOfOriginComment = obj[i].getComment();
                }
                if (obj[i].getField().equalsIgnoreCase("Residential Address")) {
                    System.out.println("obj residential add" + obj[i].getNIBSS());
                    oldResidentialStatus = obj[i].getNIBSS();
                    System.out.println("The oldResidentialStatus is >>>" + oldResidentialStatus);
                    fResidentialadd = obj[i].getFCUBS();
                    newResidentialStatus = obj[i].getModification();
                    System.out.println("The new residential status is>>>>>" + newResidentialStatus);
                    residentialStatusComment = obj[i].getComment();
                    System.out.println("The residentialStatusComment is>>>>" + residentialStatusComment);
                }
                if (obj[i].getField().equalsIgnoreCase("Local Government Area")) {
                    System.out.println("obj LGA" + obj[i].getNIBSS());
                    oldLGA = obj[i].getNIBSS();
                    System.out.println("The oldLGA is>>>>>" + oldLGA);
                    fLga = obj[i].getFCUBS();
                    newLGA = obj[i].getModification();
                    System.out.println("The newLGA is>>>>>" + newLGA);
                    lgaComment = obj[i].getComment();
                }
                if (obj[i].getField().equalsIgnoreCase("Marital Status")) {
                    System.out.println("obj marital status" + obj[i].getNIBSS());
                    oldMaritalStatus = obj[i].getNIBSS();
                    System.out.println("The oldMaritalStatus is>>>" + oldMaritalStatus);
                    fMaritalstat = obj[i].getFCUBS();
                    newMaritalStatus = obj[i].getModification();
                    System.out.println("The newMaritalStatus is>>>>>" + newMaritalStatus);
                    maritalStatusComment = obj[i].getComment();
                }
                if (obj[i].getField().equalsIgnoreCase("Gender")) {
                    System.out.println("obj gender" + obj[i].getNIBSS());
                    oldGender = obj[i].getNIBSS();
                    System.out.println("The oldGender is >>>" + oldGender);
                    fGender = obj[i].getFCUBS();
                    newGender = obj[i].getModification();
                    System.out.println("The newGender is>>>" + newGender);
                    commentGender = obj[i].getComment();
                }
                if (obj[i].getField().equalsIgnoreCase("Date Of Birth")) {
                    System.out.println("obj date of Birth" + obj[i].getNIBSS());
                    oldDOBName = obj[i].getNIBSS();
                    fDob = obj[i].getFCUBS();
                    newDOBName = obj[i].getModification();
                    System.out.println("The newDOBName is>>>>" + newDOBName);
                    DOBComment = obj[i].getComment();
                    try {
                        SimpleDateFormat oldsdf = new SimpleDateFormat("dd-MMM-yyyy");
                        SimpleDateFormat newsdf = new SimpleDateFormat("dd-MMM-yyyy");
                        System.out.println("current <<>>>" + oldsdf.format(new java.util.Date()).split("-")[2]);
                        System.out.println("Given <<>>>" + oldDOBName.split("-")[2]);
                        int compareyear = Integer.parseInt(oldsdf.format(new java.util.Date()).split("-")[2]);
                        int currentYear = Integer.parseInt(oldDOBName.split("-")[2]);
                        if (compareyear < currentYear) {
                            System.out.println("newDOBName <<>>>" + newDOBName);
                            System.out.println("oldDOBName <<>>>" + oldDOBName);
                            oldDOBName = oldDOBName.split("-")[0] + "-" + oldDOBName.split("-")[1] + "-19" + oldDOBName.split("-")[2];
                            date1 = newsdf.parse(oldDOBName);
                            System.out.println("newsdf.format(date1)3 <<>>>" + date1);
                            oldDateConverted = new java.sql.Date(date1.getTime());
                            date2 = newsdf.parse(newDOBName);
                            newDateConverted = new java.sql.Date(date2.getTime());
                            System.out.println("oldDateConverted <<>>>" + oldDateConverted);
                            System.out.println("newDateConverted <<>>>" + newDateConverted);
                        } else {
                            System.out.println("newDOBName <<>>>" + newDOBName);
                            System.out.println("oldDOBName <<>>>" + oldDOBName);
                            date1 = oldsdf.parse(oldDOBName);
                            System.out.println("newsdf.format(date1) <<>>>" + newsdf.format(date1));

                            System.out.println("newsdf.format(date1)3 <<>>>" + date1);
                            oldDateConverted = new java.sql.Date(date1.getTime());
                            date2 = newsdf.parse(newDOBName);
                            newDateConverted = new java.sql.Date(date2.getTime());
                            System.out.println("oldDateConverted <<>>>" + oldDateConverted);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                try {
                    if (obj[i].getField().equalsIgnoreCase("Phone Number")) {
                        System.out.println("obj PhoneNUmber" + obj[i].getNIBSS());
                        oldPhoneNumber = obj[i].getNIBSS();
                        fPhoneNumber = obj[i].getFCUBS();
                        newPhoneNumber = obj[i].getModification();
                        System.out.println("The newPhoneNoName is >>>>>" + newPhoneNumber);
                        phoneNOComment = obj[i].getComment();
                    }
                    if (obj[i].getField().equalsIgnoreCase("Email")) {
                        System.out.println("obj ok Email2" + obj[i].getNIBSS());
                        oldEmailAdd = obj[i].getNIBSS();
                        fEmail = obj[i].getFCUBS();
                        newEmailAdd = obj[i].getModification();
                        System.out.println("The newEmailName is >>>>" + newEmailAdd);
                        emailComment = obj[i].getComment();
                        System.out.println("The email comment is>>>>" + emailComment);
                    }
                    if (obj[i].getField().equalsIgnoreCase("Transaction ID")) {
                        System.out.println("obj ok Transaction ID" + obj[i].getNIBSS());
                        mainTxID = obj[i].getNIBSS();
                    }
                    if (obj[i].getField().equalsIgnoreCase("Maker")) {
                        System.out.println("obj ok Maker " + obj[i].getNIBSS());
                        displayname = obj[i].getNIBSS();
                    }
                    if (obj[i].getField().equalsIgnoreCase("Email Address")) {
                        System.out.println("obj user email add " + obj[i].getNIBSS());
                        userEmail = obj[i].getNIBSS();
                    }
                    if (obj[i].getField().equalsIgnoreCase("Branch")) {
                        System.out.println("obj ok Branch " + obj[i].getNIBSS());
                        Branch = obj[i].getNIBSS();
                    }
                    if (obj[i].getField().equalsIgnoreCase("BVN")) {
                        System.out.println("obj ok BVN " + obj[i].getNIBSS());
                        oldBvNumber = obj[i].getNIBSS();
                        System.out.println("BVN getter is>>>>>>" + oldBvNumber);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("got mainTxID 33 <<>> " + mainTxID);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);

            String query = "INSERT INTO customer_update_req  ( oldFirstName,newFirstName,oldMiddleName, newMiddleName,oldLastName,newLastName,oldPhoneNumber,newPhoneNumber,oldEmailAdd,newEmailAdd,BvNumber,newDateOfBirth,oldDateOfBirth,firstNameComment,MiddleComment,LastnameComment,DOBComment,phoneNOComment,emailComment, REQUEST_ID,MARKER,MARKERBRANCHCODE,TXNID,oldStateOfOrigin,newStateOfOrigin,stateOfOriginComment,oldLGA,newLGA,lgaComment,oldMaritalStatus,newMaritalStatus,maritalStatusComment,oldResidentialStatus,newResidentialStatus,residentialStatusComment,oldGender,newGender,commentGender,ffirstname, fmiddlename,flastname,fdob,fmaritalstatus,fgender,fphonenumber,femail,flga,fresidentialadd,fstateoforigin,MAKEREMAILADD, title, watchlisted, newtitle, commenttitle)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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

    public String gettxnRefsqquences() {
        String refsequence = "";
        PreparedStatement pstmt = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = 0;
        try {
            while (rs.next()) {
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
        Boolean isupdate = false;

        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(this.host_host, this.user, this.password);

            String query = "INSERT INTO file_upload_cach (field,URL,REQUEST_ID,ID) VALUES ( ?, ?, ?,?)";

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
            String query = "select * from UBNPAY_Transactions WHERE TXN_ID ='" + id + "' ";
            System.out.println("The Host-Host " + this.host_host);
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, this.user, this.password);
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
                System.out.println("In The While Loop " + this.host_host);
                count++;
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

    public String generateDateTime() {
        String txnid = "";

        SimpleDateFormat sformatter_check = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date_check = sformatter_check.format(new java.util.Date());
        txnid = current_date_check;
        return txnid;
    }

    public String generateSHA512(String password) {
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte[] byteData = md.digest();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
            }
            hexString = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                String hex = Integer.toHexString(0xFF & byteData[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return hexString.toString();
    }

    public String generateHashValue(String msg, String secret_key) {
        MessageDigest m = null;
        String hashText = null;
        msg = msg + secret_key;
        try {
            m = MessageDigest.getInstance("SHA-512");
            try {
                m.update(msg.getBytes("UTF-8"), 0, msg.length());
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            hashText = new BigInteger(1, m.digest()).toString(16);
            if (hashText.length() < 64) {
                int numberOfZeroes = 64 - hashText.length();
                String zeroes = "";
                for (int i = 0; i < numberOfZeroes; i++) {
                    zeroes = zeroes + "0";
                }
                hashText = zeroes + hashText;
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        hashText = hashText.toUpperCase();
        System.out.println("CPAY calculated Merchant intial request hash::::::" + hashText);
        return hashText;
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

    public static void main(String[] args) {
        try {
            Processor pp = new Processor();

            TransactionsDAO mert = new TransactionsDAO();
            mert = pp.getBVNdetails("22319972418");

            System.out.println("<<>>getOldDateOfBirth " + pp.gettxnRefsqquences());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public String getCalculatedHashForTxnQuery(String productId, String transactionReference, String amount, String hashkey) {
        String calHash = "";
        try {
            calHash = generateSHA512(productId + transactionReference + hashkey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return calHash;
    }
}
