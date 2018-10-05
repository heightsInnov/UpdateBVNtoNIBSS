package com.unionbank.core;

import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import nfp.ssm.core.SSMLib;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.http.impl.client.DefaultHttpClient;

public class BatchBVNExecutionNew {

    PBEncrytor Pb = new PBEncrytor();
    private Settings settings = Settings.getInstance("");
    String UpdatekeyLocationPublic = settings.getProperty("UpdatekeyLocationPublic");
    String ValidationkeyLocationPublic = settings.getProperty("ValidationkeyLocationPublic");
    String keyLocationPrivate = settings.getProperty("keyLocationPrivate");
    String password = Pb.PBDecrypt(settings.getProperty("password"));
    private static final String OUTPUT_FILE = "C:\\BVN_link_update\\keys\\phototestFile.png";

    String newBVNWebserviceURL = settings.getProperty("bvnRestWebURL");
    String newBVNWebserviceMethodCall = settings.getProperty("bvnRestMethod");

    private String DB_DRIVER = settings.getProperty("DB_DRIVER");
    private String DB_CONNECTION = settings.getProperty("DB_CONNECTION");
    private String DB_USER = settings.getProperty("DB_USER");
    private String DB_PASSWORD = settings.getProperty("DB_PASSWORD");

//    public static void main(String[] args) throws Exception_Exception {
//      securityInteface sec = new securityInteface();
//      sec.run();
//
//// String bvn = "12941630400";
////        String bvn = "22145625319", OldEmail = "", NewEmail = "", emailReasonForChange = "", OldFirstName = "", NewFirstName = "", fisrtReasonForChange = "", OldGender = "", NewGender = "", genderReasonForChange = "", OldLastName = "", NewLastName = "",
////                lastReasonForChange = "", placeholder = "";
////
////
////        response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
////                + "<UpdateDetail>\n"
////                + "\n"
////                + "	<BVN>22296458679</BVN>	\n"
////                + "	<Email OldEmail=''  NewEmail='OBANDEECHOBU@GMAIL.COM' ReasonForChange='OK' />\n"
////                + "	<FirstName OldFirstName='EBENEZER' NewFirstName='EMMANUEL' ReasonForChange='OK' />\n"
////                + "	<LastName OldLastName='OKANLAWON' NewLastName='OBANDE' ReasonForChange='OK' />\n"
////                + "	<LevelOfAccount OldLevelOfAccount='Level 1'   NewLevelOfAccount='Level 1 - Low Level Accounts'  ReasonForChange='OK'  />\n"
////                + "	<MiddleName OldMiddleName='ADELEKE' NewMiddleName='ECHOBU' ReasonForChange='OK' />\n"
////                + "	<PhoneNumber1 OldPhoneNumber1='08084357777' NewPhoneNumber1='08033322173' ReasonForChange='OK' />\n"
////                + "	<DateOfBirth OldDateOfBirth='22-FEB-1965' NewDateOfBirth='05-MAY-1963' ReasonForChange='OK' />\n"
////                + "\n"
////                + "\n"
////                + "\n"
////                + "\n"
////                + "</UpdateDetail>";
//
//
//    }
    public static void main(String[] args) {
        BatchBVNExecutionNew hh = new BatchBVNExecutionNew();
//    System.out.println("SSMLib :: SSMLib :: UpdatekeyLocationPublic: " + hh.UpdatekeyLocationPublic);
//    System.out.println("SSMLib :: SSMLib :: ValidationkeyLocationPublic: " + hh.ValidationkeyLocationPublic);
//    
//    String encript = "848C03C9DD00356EA9C9390103FF7F71EC3C0A20784F871EADF3C41FE6B0A00E0407116B368D1E7477829AC5C27635F0C87C3FAEDEE2EA3EEF19AD8FB0F41CEB0DE50FE89DAC295397A0326EBE9113C3F9EA0F7870ADF2682E7E2AA34743E5C2B12A22EDAF8CB52E6B1D4AF7BC5D3577583B689CE70388B3ABE0049C78C93A682F7BFFE317B80F204C5BD6A2B64DC9C07AA5081C83D07EDCE2DB407317CDD7074F2ED06417EA0A5D4E596C923F26BCC05B0FF84E9465F576B531F67C7C751CAE3954DE7E1AD6A969C19CBE67452C981FBC56B6889FE02B64E85C7DEA6F7D15F6087DDF152100003D0B5CA1A9E9A1CB9EB27CFE0B3B6ADBFBE1D20B52A1D840FF3A216981789E1B74BF0189216207115C7D79F11A05374A52610F8D4A0C7A232C87E54F96F9A8A81C75E8F5B8046537773400DA295EE3CB863D40DD34304966143FC240AFE9A1309DB5FBF8C0FB7D6E972AFA3C1BB69597E157E56F7F7A7DF98FADD4BD002826BE4C34C9B90B9CD03DD73D21D060D04D9147112FB561CF1C6CD9DFCD7294B7787EE77F5FF4EE84EF71C09488937417521F71A239743672D33E253687B80375AFA316EEEA973AD5D336630428C28F3E563613E427E3B728503FE9F5BC07AE47726886E0ADA7;";
//    
//    System.out.println("SSMLib :: SSMLib :: <<<>>: " + hh.validateBvn("22219069425"));

        //hh.run();
        hh.executeBatchBVNs();
        //    hh.testtest();

    }

    // public void generatePublicAndPrivateKeys() {//C:/Users/aajibade/Documents/BVN_link_update/keys
    //     SSMLib enc = new SSMLib("C:/Users/aajibade/Documents/BVN_link_update/keys/unionbank_public.key", "C:/Users/aajibade/Documents/BVN_link_update/keys/unionbank_private.key");
    //      enc.generateKeyPair("aajibade@unionbankng.com", "***MyRedeemerLives7");
    //  }
    public void testtest() {
        String encryptedValue = "848C03C9DD00356EA9C9390103FE235E96DE45F1CA7D4304977CE697FD62148B135D72F1D3D598781E6A0E2E33C77D05FB4B5C84B0D65146452BBB7D700E79FF8EE588FC1B6B734A266E7CA608AA40E3B54D52349328EFB1938901A33F9E2A136AF4CE70E62E210ADD5DE209A8E670E429346AC91AB37A930D56E136068C75CC5C1BE4676A7778024FB809238C51C9C198287B70F7852FBA25CC3B7883504A2E9F0E1227790F82A31A970F0C889286747B7FC34E307179CB44FE6BF20FD7ED137DC1B906B02A78B9835F520A2435D0E1744D1D3B8B6F575D8E6DD98ED755A2ACB651CF6FBF310D324ED25AE7295D67D48255D4D0369CA09B9FB6D9F7750CF64DF62BDD368F06B0C335DE5EAE98EAC760FB104361A6FE4FE3AEE46E8C19804F2C9C4A2BFC5326B06B580DD7D9429DC3CF8286FABB5B0A72DD793E35001DA7C271CFB68D19D9D86A5A1E2C19381AA204296AE764D411F768DA5BEDBFA6D8B6E8DE1E86234AF5B10BC90B448F563AC43AFDA957F2C6E77DCCA214765FAAB87E48C6467DACCD6988B7C2DEBFB67F1FC94C162A444CC818EC44310D6943545E8D424B3B532CBE5E0DB3332D843F70770FE6306908BAD457AF44CB3CC4C2A71BEAA9EF9553A32BE37177610E7ACCCB6EAFE3D0EFE516BBBD2F58092C859B3EE9F296F40A58FD784F10E0E693197CBB484F553B1D7C97BF2A6C58C29F5CEB1790AC164BA4D45715E6E2E945C1FD0116A495E9AEC4E20F0A323CB82A8D5695675D231704BA1B1B8F63DC343A4927E369DBFA056CE85E3A2E605A5B4ECD90C2046639336A20C3A2BC3067E843FCD3EAB8F73622B10E7755F178070D96E2CC6CFE573BF109AA71BF581D66824D751039BB240692953F0AC650481FF95B1373ECC608A3DD862CD1FCCC2828BD266B5D0102EF078A36F7A3A270278682FA02D9A0C0D518A950506B1B8F8F85A97BCEB038B5763C94584C3A78E5E9EEAA882987019EE3CD3F4AC03577E404912FD77063AF87C87C300B90E9456F9A64CE388729150A3F08FEBAB77FC8688152714640;848C03C9DD00356EA9C9390103FF71B518CAB0898A792CF3E2CCE15B16CBF5C1B8990B421B7719896FF47FE6AC90C4026C5BA0A04770636046ABD212A34DCE9AE1D2FE656D259CA42B79AB345413890916E9A1AFF288F48512BDB7F52BE5C412CAACF3F67D2263EE91396862D4415A69F54E5C153FA601C8A67E15DE686106FBD746830430639C2C01D3E8E882B1C98533B2196CB92AFE79443C8EB8E789BDFFB77E4DA6D5F1DD0A340D8B946CFC56FAC0A4B2DC6212268D33DFA8C13AF3F6701C43CA2471EF5419D40DB41273E1C4D82614D7692CD1C7F2B178A1D99FAD5F6BEAD8FB44750E08A4931A09ACAEE7AEF6DB14FF74077A51BFC0F386A6FA17BCA6F6B4A6C3095776D545E148A7505102D73BC53F160C";
        SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
        System.out.println("Decrypted Xml for Single Validation >> " + enc.decryptFile(encryptedValue, password));

    }

    public String updateencryptRequest(final String dataToEncrypt) {
        //  SSMLib enc = new SSMLib(keyLocation+"/nibss_public.key", "c:/unionbank_private.key");//unionbank_public.key
        SSMLib enc = new SSMLib(UpdatekeyLocationPublic, keyLocationPrivate);//unionbank_public.key
        // enc.generateKeyPair(password, password)
        return enc.encryptMessage(dataToEncrypt);
    }

    public boolean generateKeys(String userId, String password) {
        //  SSMLib enc = new SSMLib(keyLocation+"/nibss_public.key", "c:/unionbank_private.key");//unionbank_public.key
        //SSMLib enc = new SSMLib("C:/BVN_link_update/keys/nibss_val_liv_public.key", "C:/BVN_link_update/keys/unionbank_live_private.key");//unionbank_public.key
        SSMLib enc = new SSMLib(ValidationkeyLocationPublic, "C:/BVN_link_update/keys/unionbank_live_private.key");//unionbank_public.key

        // enc.generateKeyPair(password, password)
        return enc.generateKeyPair(userId, password);
    }

    public String validationencryptRequest(final String dataToEncrypt) {
        System.out.println("dataToEncrypt<<>>>" + dataToEncrypt);
        //  SSMLib enc = new SSMLib(keyLocation+"/nibss_public.key", "c:/unionbank_private.key");//unionbank_public.key
        SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);//unionbank_public.key

        return enc.encryptMessage(dataToEncrypt);
    }

    public String decryptRequest(final String dataToDecrypt) {
        // SSMLib enc = new SSMLib(keyLocation+"c:/nibss_public.key", keyLocation+"c:/unionbank_private.key");
        SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);//unionbank_public.key
        return enc.decryptFile(dataToDecrypt, password);
    }

//    public static DefaultHttpClient wrapClient(DefaultHttpClient base) {
//        try {
//            SSLContext ctx = SSLContext.getInstance("TLS");
//            X509TrustManager tm = new X509TrustManager() {
//
//                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
//                }
//
//                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
//                }
//
//                public X509Certificate[] getAcceptedIssuers() {
//                    return null;
//                }
//            };
//            ctx.init(null, new TrustManager[]{tm}, null);
//            SSLSocketFactory ssf = new SSLSocketFactory(ctx);
//            ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//            ClientConnectionManager ccm = base.getConnectionManager();
//            SchemeRegistry sr = ccm.getSchemeRegistry();
//            sr.register(new Scheme("https", ssf, 443));
//            return new DefaultHttpClient(ccm, base.getParams());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }

    public void executeBatchBVNs() {
        PreparedStatement pstmt = null;
        PreparedStatement pst = null;
        PreparedStatement pst2 = null;
        ResultSet rs = null;
        Connection conn = null;
        BvnLogger bvn = new BvnLogger();
        String BVN = "";
        String FirstName = "";
        String MiddleName = "";
        String LastName = "";
        String DateOfBirth = "";
        String RegistrationDate = "";
        String Nationality = "";
        String PhoneNumber1 = "";
        String PhoneNumber2 = "";
        String email = "";
        String maritalStatus = "";
        String gender = "";
        String stateOfOrigin = "";
        String stateOfResidence = "";
        String title = "";
        String residentialAdd = "";
        String lgaoforigin = "";
        String lgaofresidence = "";
        String bankOfEnrollment = "";
        String branchOfEnrollment = "";
        String vbnResponse = "";
        HttpPost httpPost = null;
        DefaultHttpClient httpclient = null;
        
        HttpResponse response = null;
        StringBuffer result = new StringBuffer();
        String line = "";
        try {
            String url = newBVNWebserviceURL + newBVNWebserviceMethodCall;
            System.out.println("The url is::: " + url);
            conn = getConnection();
            SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
            String query = "SELECT BVN FROM BVNBULKUPLOADTESTTIER1 WHERE STATUS IS NULL";
//            String query = "SELECT BVN FROM BVNEXTRACTFORFESTUS WHERE STATUS IS NULL";
            pstmt = conn.prepareStatement(query);
            if (pstmt.execute()) {
                System.out.println("Executed Successfully!!!");
                rs = pstmt.getResultSet();
                System.out.println("The Query is: " + query);
            } else {
                System.out.println("Empty prepared Statement!!!");
                throw new Exception("Empty Prepared Statement");
            }
            String bvnumber = null;
            int count = 0;
            rs.getFetchSize();
            while (rs.next()) {
                count++;
                bvnumber = rs.getString("BVN");
                System.out.println("The BVN is>>>>>  " + bvnumber);
                String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ValidationRequest><BVN>" + bvnumber.trim() + "</BVN></ValidationRequest>";

                String encBvnSingle = enc.encryptMessage(single);
                System.out.println("Encrypted Single Request is:::::" + encBvnSingle);
                try {
                    httpclient = new DefaultHttpClient();
                    //httpclient = wrapClient(httpclient);
                } catch (Exception ex) {
                    httpclient = new DefaultHttpClient();
                }

                httpPost = new HttpPost(url);
				httpPost.addHeader("Accept", "application/xml; charset=utf8");
                httpPost.addHeader("Content-Type", "application/xml; charset=utf8");
				httpPost.addHeader("Authorization", "032:UnE6zh]T1Bd00Q[%; charset=utf8");
				httpPost.addHeader("SIGNATURE", "6f9961fa868fa7d450e68fea51751879eb6adec96e04ce5501f855a27e11196f; charset=utf8");
				httpPost.addHeader("SIGNATURE_METH", "SHA256");
                httpPost.setEntity(new ByteArrayEntity(encBvnSingle.getBytes("UTF-8")));

                response = httpclient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                int statusCode = response.getStatusLine().getStatusCode();
             
                System.out.println("statusCode " + statusCode);
                if (entity != null) {
                    if (statusCode == 200) {
                        BufferedReader bfr = new BufferedReader(new InputStreamReader(entity.getContent()));

                        while ((line = bfr.readLine()) != null) {
                            result.append(line);
                        }
                        
                        vbnResponse = enc.decryptFile(result.toString(), password);
                        System.out.println("vbnResponse ------ >>> " + vbnResponse);
                        if (vbnResponse.length() > 0) {

                            FirstName = getNodeValue("/BVNSearchResult/FirstName", vbnResponse);
                            String FirstNameCorrect = FirstName.replace("&", "").replace("'", "");
                            System.out.println("First name extracted is>>>>>" + FirstName);
                            MiddleName = getNodeValue("/BVNSearchResult/MiddleName", vbnResponse);
                            String MiddleNameCorrect = MiddleName.replace("&", "").replace("'", "");
                            LastName = getNodeValue("/BVNSearchResult/LastName", vbnResponse);
                            String LastNameCorrect = LastName.replace("&", "").replace("'", "");
                            DateOfBirth = getNodeValue("/BVNSearchResult/DateOfBirth", vbnResponse);
                            RegistrationDate = getNodeValue("/BVNSearchResult/RegistrationDate", vbnResponse);
                            PhoneNumber1 = getNodeValue("/BVNSearchResult/PhoneNumber1", vbnResponse);
                            PhoneNumber2 = getNodeValue("/BVNSearchResult/PhoneNumber2", vbnResponse);
                            email = getNodeValue("/BVNSearchResult/Email", vbnResponse);
                            String emailCorrect = email.replace("&", "").replace("'", "");
                            maritalStatus = getNodeValue("/BVNSearchResult/MaritalStatus", vbnResponse);
                            gender = getNodeValue("/BVNSearchResult/Gender", vbnResponse);
                            stateOfOrigin = getNodeValue("/BVNSearchResult/StateOfOrigin", vbnResponse);
                            stateOfResidence = getNodeValue("/BVNSearchResult/StateOfResidence", vbnResponse);
                            residentialAdd = getNodeValue("/BVNSearchResult/ResidentialAddress", vbnResponse);
                            String residentialAddCorrect = residentialAdd.replace("&", "").replace("'", "");
                            lgaoforigin = getNodeValue("/BVNSearchResult/LgaOfOrigin", vbnResponse);
                            String lgaoforiginCorrect = lgaoforigin.replace("&", "").replace("'", "");
                            lgaofresidence = getNodeValue("/BVNSearchResult/LgaOfResidence", vbnResponse);
                            Nationality = getNodeValue("/BVNSearchResult/Nationality", vbnResponse);
                            title = getNodeValue("/BVNSearchResult/Title", vbnResponse);
                            bankOfEnrollment = getNodeValue("/BVNSearchResult/EnrollmentBank", vbnResponse);
                            branchOfEnrollment = getNodeValue("/BVNSearchResult/EnrollmentBranch", vbnResponse);

                            String lgaofresidenceCorrect = lgaofresidence.replace("&", "").replace("'", "");
                            String branchOfEnrollmentCorrect = branchOfEnrollment.replace("&", "").replace("'", "");
                            String NationalityCorrect = Nationality.replace("&", "").replace("'", "");

                            System.out.println("lgaofresidence === " + lgaofresidenceCorrect);
                            System.out.println("branchOfEnrollment === " + branchOfEnrollmentCorrect);
//                UPDATE BVNBULKUPLOADTESTTIER1
                            String sqlUpdate = "UPDATE BVNBULKUPLOADTESTTIER1 "
//                            String sqlUpdate = "UPDATE BVNEXTRACTFORFESTUS "
                                    + "SET DATE_OF_REGISTRATION = '" + RegistrationDate + "', "
                                                            + "MIDDLE_NAME = '" + MiddleNameCorrect + "', "
                                                            + "LAST_NAME = '" + LastNameCorrect + "', "
                                                            + "DATE_OF_BIRTH = '" + DateOfBirth + "', "
                                                            + "PHONE_NUMBER1 = '" + PhoneNumber1 + "', "
                                                            + "PHONE_NUMBER2 = '" + PhoneNumber2 + "', "
                                                            + "EMAIL_ADD = '" + emailCorrect + "', "
                                                            + "MARITAL_STATUS = '" + maritalStatus + "', "
                                                            + "GENDER = '" + gender + "', "
                                                            + "STATE_ORIGIN = '" + stateOfOrigin + "', "
                                                            + "NATIONALITY = '" + NationalityCorrect + "', "
                                                            + "STATE_RESIDENCE = '" + stateOfResidence + "', "
                                                            + "RESIDENTIAL_ADD = '" + residentialAddCorrect + "', "
                                                            + "LGA_ORIGIN = '" + lgaoforiginCorrect + "', "
                                                            + "LGA_RESIDENCE = '" + lgaofresidenceCorrect + "', "
                                                            + "TITLE = '" + title + "', "
                                                            + "BRANCH_OF_ENROLLMENT = '" + branchOfEnrollmentCorrect + "', "
                                                            + "BANK_OF_ENROLMENT = '" + bankOfEnrollment + "', "
                                    + "STATUS = 'EXTRACTED' "
                                    + "WHERE BVN = '" + bvnumber + "'";

                            pst = conn.prepareStatement(sqlUpdate);
                            System.out.println("Query to update the BVN table back is>>> " + sqlUpdate);
                            pst.executeUpdate();

                        }
                    }
                }
            }
                      if (httpPost != null) {
                        if (httpPost != null) {
                            try {
                                httpPost.releaseConnection();
                                httpPost.reset();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (httpclient != null) {
                            try {
                                httpclient.getConnectionManager().shutdown();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                      }
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (pst != null) {
                        pst.close();
                    }
                    if (pst2 != null) {
                        pst2.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (pst2 != null) {
                    pst2.close();
                }
                if (conn != null) {
                    conn.close();
                    System.out.println("I am closing the connection!!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
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

    private Connection getConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
