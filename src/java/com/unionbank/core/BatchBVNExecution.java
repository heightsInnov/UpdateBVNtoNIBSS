package com.unionbank.core;

import com.nibss.bvn.Exception_Exception;
import com.unionbank.BVNVer2.BVNValidation;
import com.unionbank.BVNVer2.BVNValidationService;
import com.unionbank.BVNVer2.SearchResult;
import com.unionbank.BVNVer2.SearchResults;
import com.unionbank.core.BvnLogger;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.activation.DataHandler;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import nfp.ssm.core.SSMLib;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BatchBVNExecution {

    PBEncrytor Pb = new PBEncrytor();
    private Settings settings = Settings.getInstance("");
    String UpdatekeyLocationPublic = settings.getProperty("UpdatekeyLocationPublic");
    String ValidationkeyLocationPublic = settings.getProperty("ValidationkeyLocationPublic");
    String keyLocationPrivate = settings.getProperty("keyLocationPrivate");
    String password = Pb.PBDecrypt(settings.getProperty("password"));
    private static final String OUTPUT_FILE = "C:\\BVN_link_update\\keys\\phototestFile.png";

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
        BatchBVNExecution hh = new BatchBVNExecution();
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
    
    public void testtest(){
       String encryptedValue = "848C03C9DD00356EA9C9390103FE235E96DE45F1CA7D4304977CE697FD62148B135D72F1D3D598781E6A0E2E33C77D05FB4B5C84B0D65146452BBB7D700E79FF8EE588FC1B6B734A266E7CA608AA40E3B54D52349328EFB1938901A33F9E2A136AF4CE70E62E210ADD5DE209A8E670E429346AC91AB37A930D56E136068C75CC5C1BE4676A7778024FB809238C51C9C198287B70F7852FBA25CC3B7883504A2E9F0E1227790F82A31A970F0C889286747B7FC34E307179CB44FE6BF20FD7ED137DC1B906B02A78B9835F520A2435D0E1744D1D3B8B6F575D8E6DD98ED755A2ACB651CF6FBF310D324ED25AE7295D67D48255D4D0369CA09B9FB6D9F7750CF64DF62BDD368F06B0C335DE5EAE98EAC760FB104361A6FE4FE3AEE46E8C19804F2C9C4A2BFC5326B06B580DD7D9429DC3CF8286FABB5B0A72DD793E35001DA7C271CFB68D19D9D86A5A1E2C19381AA204296AE764D411F768DA5BEDBFA6D8B6E8DE1E86234AF5B10BC90B448F563AC43AFDA957F2C6E77DCCA214765FAAB87E48C6467DACCD6988B7C2DEBFB67F1FC94C162A444CC818EC44310D6943545E8D424B3B532CBE5E0DB3332D843F70770FE6306908BAD457AF44CB3CC4C2A71BEAA9EF9553A32BE37177610E7ACCCB6EAFE3D0EFE516BBBD2F58092C859B3EE9F296F40A58FD784F10E0E693197CBB484F553B1D7C97BF2A6C58C29F5CEB1790AC164BA4D45715E6E2E945C1FD0116A495E9AEC4E20F0A323CB82A8D5695675D231704BA1B1B8F63DC343A4927E369DBFA056CE85E3A2E605A5B4ECD90C2046639336A20C3A2BC3067E843FCD3EAB8F73622B10E7755F178070D96E2CC6CFE573BF109AA71BF581D66824D751039BB240692953F0AC650481FF95B1373ECC608A3DD862CD1FCCC2828BD266B5D0102EF078A36F7A3A270278682FA02D9A0C0D518A950506B1B8F8F85A97BCEB038B5763C94584C3A78E5E9EEAA882987019EE3CD3F4AC03577E404912FD77063AF87C87C300B90E9456F9A64CE388729150A3F08FEBAB77FC8688152714640;848C03C9DD00356EA9C9390103FF71B518CAB0898A792CF3E2CCE15B16CBF5C1B8990B421B7719896FF47FE6AC90C4026C5BA0A04770636046ABD212A34DCE9AE1D2FE656D259CA42B79AB345413890916E9A1AFF288F48512BDB7F52BE5C412CAACF3F67D2263EE91396862D4415A69F54E5C153FA601C8A67E15DE686106FBD746830430639C2C01D3E8E882B1C98533B2196CB92AFE79443C8EB8E789BDFFB77E4DA6D5F1DD0A340D8B946CFC56FAC0A4B2DC6212268D33DFA8C13AF3F6701C43CA2471EF5419D40DB41273E1C4D82614D7692CD1C7F2B178A1D99FAD5F6BEAD8FB44750E08A4931A09ACAEE7AEF6DB14FF74077A51BFC0F386A6FA17BCA6F6B4A6C3095776D545E148A7505102D73BC53F160C";
      SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
      System.out.println("Decrypted Xml for Single Validation >> " + enc.decryptFile(encryptedValue, password));
      
    }
    public void run() {
        try {
            BVNValidation service = new BVNValidation();
            BVNValidationService port = service.getBVNValidationPort();
            SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
            securityInteface hh = new securityInteface();
            System.out.println("SSMLib :: SSMLib :: UpdatekeyLocationPublic: " + hh.UpdatekeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: ValidationkeyLocationPublic: " + hh.ValidationkeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: keyLocationPrivate: " + hh.keyLocationPrivate);

            // String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>22219069425</BVN></SearchRequest>";
            String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>22145625319</BVN></SearchRequest>";

            String encBvnSingle = enc.encryptMessage(single);

            System.out.println("Clear text request Single::::: " + single);
            System.out.println("Encrypted Single Request:::::" + encBvnSingle);

            //Call to web service
            try {
                SearchResult retSingle = port.validateSingleBVN(encBvnSingle);
                System.out.println("I have done port.validateSingleBVN(encBvnSingle) and the output is>>>> " + port.validateSingleBVN(encBvnSingle));
                System.out.println("Output retSingle is>>>> " + retSingle);
                // System.out.println("retSingleretSingleretSingle" +retSingle);

////                DataHandler handlerSingle = retSingle.getBinaryImage();
////                //Some bvns have no image currently
////                if (handlerSingle != null)
////                {
////                    System.out.println("Content Type of Single Validation Image >> " + handlerSingle.getContentType());
////                    System.out.println("Input Stream for Single Validation >> " + handlerSingle.getInputStream());
////                    
////                    InputStream in = handlerSingle.getInputStream();
////                                        
////                    out = new FileOutputStream(OUTPUT_FILE);
////                    byte[] buf = new byte[1024];
////                    int len;
////                    while ((len = in.read(buf)) > 0) {
////                        out.write(buf, 0, len);
////                    }
////                    out.close();
////                    in.close();
////                }
                String encSingle = retSingle.getBvnSearchResult();
                System.out.println("Response for Single Validation using NIBSS getBvnSearchResult >> " + encSingle);
                System.out.println("About to encrypt now------");
                System.out.println("Decrypted Xml for Single Validation >> " + enc.decryptFile(encSingle, password));

                //Print out for multiple
//                SearchResults.ResultList resultList = retMultiple.getResultList();
//                List<SearchResult> list = resultList.getSearchResult();
//                System.out.println("Response Code >> " + retMultiple.getResponseCode());
//                for (SearchResult s : list)
//                {
//                    DataHandler handlerMultiple = s.getBinaryImage();
//                    //Some bvns have no image
//                    if (handlerMultiple != null)
//                    {
//                        System.out.println("Content Type of Multiple Validation Image >> " + handlerMultiple.getContentType());
//                        System.out.println("Input Stream for Multiple Validation >> " + handlerSingle.getInputStream());
//                        String encMultiple = s.getBvnSearchResult();
//                        System.out.println("Encrypted response for Multiple Validation >> " + encMultiple);
//                        System.out.println("Decrypted Xml for Multiple Validation >> " + enc.decryptFile(encMultiple, "password"));
//                    }
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String validateBvn(String bvn) {
        String encripyValue = "";
        String responseEn = "";
        String decrpt = "";
        try {
            System.out.println("BVN<<>>>>>>> :" + bvn.trim() + "<<>>");
            encripyValue = validationencryptRequest(bvn);
            responseEn = verifySingleBVN(encripyValue, "032");
            decrpt = decryptRequest(responseEn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return decrpt;
    }

    //src="img/Picture.png"
    public String validateBvn2(String bvn) throws FileNotFoundException {
        String encryptValueSingle = "";
        String encryptValueMultiple = "";
        String responseEn = "", decrypt = "";
        //C:\UpdateBVNtoNIBSS\web\img

        String OUTPUT_FILE = "C:\\ProjectsJava\\UpdateBVNtoNIBSS\\web\\img\\Picture_"+bvn+".png";
        //String OUTPUT_FILE = "C:\\Users\\baadedeji\\Documents\\NetBeansProjects\\UpdateBVNtoNIBSS\\web\\img\\Picture_" + bvn + ".png";
        // String OUTPUT_FILE = "C:\\UpdateBVNtoNIBSS\\web\\img\\Picture_"+bvn+".png";
        // String OUTPUT_FILE = "C:\\UpdateBVNtoNIBSS\\web\\img\\Picture_22222222222.png";
        OutputStream out = new FileOutputStream(OUTPUT_FILE);
        System.out.println("--Moved out of the Output File----");
//        SearchResult src = new SearchResult();
        String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>" + bvn.trim() + "</BVN></SearchRequest>";
        // String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>22222222222</BVN></SearchRequest>";
        //  String multiple = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequests><BVNS>11111111111,22222222222,33333333340</BVNS></SearchRequests>";

        try {
            System.out.println("BVN<<>>>>>>>::::" + bvn.trim() + "<<>>");

            encryptValueSingle = validationencryptRequest(single);
            System.out.println("Clear Text Request Single::::: " + single);
            System.out.println("encryptedValueSingleBVN<<>>>>>>>::::" + encryptValueSingle);

//            encryptValueMultiple = validationencryptRequest(multiple);
//            System.out.println("Clear text request Multiple::::: " + multiple);
//            System.out.println("encryptedValueMultipleBVN<<>>>>>>>::::" + encryptValueMultiple);
            SearchResult retSingle = validateSingleBVN(encryptValueSingle);
            System.out.println("validateSingleBVN Result>>>>> " + validateSingleBVN(encryptValueSingle));
            //  SearchResults retMultiple = validateMultipleBVNs(encryptValueMultiple);

            DataHandler handlerSingle = retSingle.getBinaryImage();

//            BufferedImage imBuff = ImageIO.read(handlerSingle.getInputStream());
            //  ImageIO.write(imBuff, "png", new File("C:\\BVN_link_update\\keys\\photo\\picture.png"));
            //Some bvns have no image currently
            if (handlerSingle != null) {
                System.out.println("Content Type of Single Validation Image >> " + handlerSingle.getContentType());
                System.out.println("Input Stream for Single Validation >> " + handlerSingle.getInputStream());

                InputStream in = handlerSingle.getInputStream();

                out = new FileOutputStream(OUTPUT_FILE);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            }

            String encSingle = retSingle.getBvnSearchResult();
            System.out.println("Encrypted response for Single Validation(retSingle.getBvnSearchResult()) >> " + encSingle);
            decrypt = decryptRequest(encSingle);
            System.out.println("Decrypted Xml for Single Validation >> " + decrypt);

        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
        }

        //  String response = "";
        return decrypt;
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

//    private static String verifySingleBVN(java.lang.String bvn, java.lang.String bankCode) throws Exception_Exception {
//        com.nibss.bvn.BVNValidation service = new com.nibss.bvn.BVNValidation();
//        com.nibss.bvn.BVNValidationService port = service.getBVNValidationPort();
//        return port.verifySingleBVN(bvn, bankCode);
//    }
    private static SearchResult validateSingleBVN(java.lang.String searchInput) throws com.unionbank.BVNVer2.Exception_Exception {
        com.unionbank.BVNVer2.BVNValidation service = new com.unionbank.BVNVer2.BVNValidation();
        com.unionbank.BVNVer2.BVNValidationService port = service.getBVNValidationPort();
        return port.validateSingleBVN(searchInput);
    }

    private static SearchResults validateMultipleBVNs(java.lang.String searchInputs) throws com.unionbank.BVNVer2.Exception_Exception {
        com.unionbank.BVNVer2.BVNValidation service = new com.unionbank.BVNVer2.BVNValidation();
        com.unionbank.BVNVer2.BVNValidationService port = service.getBVNValidationPort();
        return port.validateMultipleBVNs(searchInputs);
    }

    private static String verifySingleBVN(String bvn, String bankCode)
            throws Exception_Exception {
        com.nibss.bvn.BVNValidation service = new com.nibss.bvn.BVNValidation();
        com.nibss.bvn.BVNValidationService port = service.getBVNValidationPort();
        return port.verifySingleBVN(bvn, bankCode);
    }

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
        try {
            conn = getConnection();
            BVNValidation service = new BVNValidation();
            BVNValidationService port = service.getBVNValidationPort();
            SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
            securityInteface hh = new securityInteface();
            System.out.println("SSMLib :: SSMLib :: UpdatekeyLocationPublic: " + hh.UpdatekeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: ValidationkeyLocationPublic: " + hh.ValidationkeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: keyLocationPrivate: " + hh.keyLocationPrivate);

          //  String query = "SELECT BVN FROM BVNBULKUPLOADTEST WHERE STATUS IS NULL";
          
            String query = "SELECT BVN FROM BVNBULKUPLOADTESTTIER1 WHERE STATUS IS NULL";
//            String query = "SELECT BVN FROM BVNBULKUPLOADTEST where BVN = '22276520709'";

//String query = "select bvn from bvnbulkuploadtest where bvn in ('22279858577','22417196879','22275188641','22418150494','22335071746','22325636285','22428406753','22355426229','22288998507','22424498183','22217079675','22413751405','22379235667','22417983886','22429438857','22265282953','22302665734','22183856627','22432740079','22432847989','22340169160','22332070069','22409789997','22433294650','22300900277','22165388849','22171885015','22433961097','22433224950','22433848172','22434189779','22434208962','22434003701','22203069060','22432922150','22434182426','22249971765','22347725697','22433764494','22434019548','22183081175','22434279906','22434224003','22434011485','22434202487','22434251559','22434274985','22305691813','22433746296','22434299520','22434305364','22186773383','22375205363','22433788478','22433961288','22433864886','22433677545','22330670331','22433306115','22193687312','22433537892','22434314382','22434289572','22434264144','22268588966','22434240995','22342295083','22245244371','22434293919','22433804338','22434317330','22433606475','22433273734','22433870694','22434345531','22434077256','22346339488','22434318629','22176664802','22434306873','22278976629','22207705142','22416928549','22348864230','22186411492','22393380059','22434180398','22434389045','22434319183','22172363932','22433490579','22434012606','22406731726','22378858984','22439774367','22439496678','22432616053','22440023227','22350741624','22439052865')";
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
                String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>" + bvnumber.trim() + "</BVN></SearchRequest>";

                String encBvnSingle = enc.encryptMessage(single);
                System.out.println("Encrypted Single Request:::::" + encBvnSingle);

                SearchResult retSingle = port.validateSingleBVN(encBvnSingle);
                System.out.println("Output retSingle is>>>> " + retSingle);

                String encSingle = retSingle.getBvnSearchResult();
                System.out.println("Response for Single Validation using NIBSS getBvnSearchResult >> " + encSingle);
                long startTime = System.nanoTime();
                
                System.out.println("Start time is::::: " +startTime);
                vbnResponse = enc.decryptFile(encSingle, password);
                long endTime = System.nanoTime();
                System.out.println("End time is::::: " +endTime);
               // methodToTime();
                long duration = (endTime - startTime);
                System.out.println("The time it takes to execute is:::: " +duration);
                
                System.out.println("vbnResponse ------ >>> " +vbnResponse);
                if(vbnResponse.isEmpty()){
//                       BVNBULKUPLOADTESTTIER1
                        String sqlUpdate2 = "UPDATE BVNBULKUPLOADTESTTIER1 "
                        + "SET STATUS = 'ISSUES' "
                        + "WHERE BVN = '"+bvnumber+"'";
                        
//                        String sqlUpdate2 = "UPDATE BVNBULKUPLOADTEST "
//                        + "SET STATUS = 'ISSUES' "
//                        + "WHERE BVN = '"+bvnumber+"'";
                
                        pst2 = conn.prepareStatement(sqlUpdate2);
                        System.out.println("Query to update the BVN table back FOR ISSUES is>>> " +sqlUpdate2);
                        pst2.executeUpdate();
                    
                }
                else{
                    
                FirstName = getNodeValue("/BVNSearchResult/FirstName", vbnResponse);
                String FirstNameCorrect = FirstName.replace("&", "").replace("'", "");
                System.out.println("First name extracted is>>>>>" + FirstName);
                MiddleName = getNodeValue("/BVNSearchResult/MiddleName", vbnResponse);
                String MiddleNameCorrect = MiddleName.replace("&", "").replace("'", "");
                LastName = getNodeValue("/BVNSearchResult/LastName", vbnResponse);
                String LastNameCorrect = LastName.replace("&", "").replace("'", "");
                DateOfBirth = getNodeValue("/BVNSearchResult/DateOfBirth", vbnResponse);
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
//                BVNBULKUPLOADTESTTIER1
//                String sqlUpdate = "UPDATE BVNBULKUPLOADTEST "
//                        + "SET FIRST_NAME = '" + FirstNameCorrect + "', "
//                        + "MIDDLE_NAME = '" + MiddleNameCorrect + "', "
//                        + "LAST_NAME = '" + LastNameCorrect + "', "
//                        + "DATE_OF_BIRTH = '" + DateOfBirth + "', "
//                        + "PHONE_NUMBER1 = '" + PhoneNumber1 + "', "
//                        + "PHONE_NUMBER2 = '" + PhoneNumber2 + "', "
//                        + "EMAIL_ADD = '" + emailCorrect + "', "
//                        + "MARITAL_STATUS = '" + maritalStatus + "', "
//                        + "GENDER = '" + gender + "', "
//                        + "STATE_ORIGIN = '" + stateOfOrigin + "', "
//                        + "NATIONALITY = '" + Nationality + "', "
//                        + "STATE_RESIDENCE = '" + stateOfResidence + "', "
//                        + "RESIDENTIAL_ADD = '" + residentialAddCorrect + "', "
//                        + "LGA_ORIGIN = '" + lgaoforiginCorrect + "', "
//                        + "LGA_RESIDENCE = '" + lgaofresidenceCorrect + "', "
//                        + "TITLE = '" + title + "', "
//                        + "STATUS = 'EXTRACTED' "
//                        + "WHERE BVN = '" + bvnumber + "'";
                
                String sqlUpdate = "UPDATE BVNBULKUPLOADTESTTIER1 "
                        + "SET FIRST_NAME = '" + FirstNameCorrect + "', "
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
