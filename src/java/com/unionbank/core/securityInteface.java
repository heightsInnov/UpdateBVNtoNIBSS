package com.unionbank.core;

import com.nibss.bvn.Exception_Exception;
import com.unionbank.BVNVer2.BVNValidation;
import com.unionbank.BVNVer2.BVNValidationService;
import com.unionbank.BVNVer2.SearchResult;
import com.unionbank.BVNVer2.SearchResults;
import com.unionbank.core.BvnLogger;

import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
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
import nfp.ssm.core.SSMLib;

public class securityInteface {

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
    private  String DB_PASSWORD = settings.getProperty("DB_PASSWORD");

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
   
   public static void main(String[] args)
  {
    securityInteface hh = new securityInteface();
//    System.out.println("SSMLib :: SSMLib :: UpdatekeyLocationPublic: " + hh.UpdatekeyLocationPublic);
//    System.out.println("SSMLib :: SSMLib :: ValidationkeyLocationPublic: " + hh.ValidationkeyLocationPublic);
//    
//    String encript = "848C03C9DD00356EA9C9390103FF7F71EC3C0A20784F871EADF3C41FE6B0A00E0407116B368D1E7477829AC5C27635F0C87C3FAEDEE2EA3EEF19AD8FB0F41CEB0DE50FE89DAC295397A0326EBE9113C3F9EA0F7870ADF2682E7E2AA34743E5C2B12A22EDAF8CB52E6B1D4AF7BC5D3577583B689CE70388B3ABE0049C78C93A682F7BFFE317B80F204C5BD6A2B64DC9C07AA5081C83D07EDCE2DB407317CDD7074F2ED06417EA0A5D4E596C923F26BCC05B0FF84E9465F576B531F67C7C751CAE3954DE7E1AD6A969C19CBE67452C981FBC56B6889FE02B64E85C7DEA6F7D15F6087DDF152100003D0B5CA1A9E9A1CB9EB27CFE0B3B6ADBFBE1D20B52A1D840FF3A216981789E1B74BF0189216207115C7D79F11A05374A52610F8D4A0C7A232C87E54F96F9A8A81C75E8F5B8046537773400DA295EE3CB863D40DD34304966143FC240AFE9A1309DB5FBF8C0FB7D6E972AFA3C1BB69597E157E56F7F7A7DF98FADD4BD002826BE4C34C9B90B9CD03DD73D21D060D04D9147112FB561CF1C6CD9DFCD7294B7787EE77F5FF4EE84EF71C09488937417521F71A239743672D33E253687B80375AFA316EEEA973AD5D336630428C28F3E563613E427E3B728503FE9F5BC07AE47726886E0ADA7;";
//    
//    System.out.println("SSMLib :: SSMLib :: <<<>>: " + hh.validateBvn("22219069425"));

      hh.run();
      //hh.executeBatchBVNs();
  }

    // public void generatePublicAndPrivateKeys() {//C:/Users/aajibade/Documents/BVN_link_update/keys
    //     SSMLib enc = new SSMLib("C:/Users/aajibade/Documents/BVN_link_update/keys/unionbank_public.key", "C:/Users/aajibade/Documents/BVN_link_update/keys/unionbank_private.key");
    //      enc.generateKeyPair("aajibade@unionbankng.com", "***MyRedeemerLives7");
    //  }
    
    public void run(){
        try{
            BVNValidation service = new BVNValidation();
            BVNValidationService port = service.getBVNValidationPort();
            SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
            securityInteface hh = new securityInteface();
            System.out.println("SSMLib :: SSMLib :: UpdatekeyLocationPublic: " + hh.UpdatekeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: ValidationkeyLocationPublic: " + hh.ValidationkeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: keyLocationPrivate: " + hh.keyLocationPrivate);

           // String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>22219069425</BVN></SearchRequest>";
            String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>22451797306</BVN></SearchRequest>";
//            String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>221797306</BVN></SearchRequest>";
                        
            String encBvnSingle = enc.encryptMessage(single);

            System.out.println("Clear text request Single::::: " + single);
            System.out.println("Encrypted Single Request:::::" + encBvnSingle);

            //Call to web service
            try
            {
                SearchResult retSingle = port.validateSingleBVN(encBvnSingle);
                System.out.println("I have done port.validateSingleBVN(encBvnSingle) and the output is>>>> " +port.validateSingleBVN(encBvnSingle));
                System.out.println("Output retSingle is>>>> " +retSingle);
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
                System.out.println("About to decrypt now------");
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
            } catch (Exception e)
            {
                e.printStackTrace();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

       
    }
    
    public String validateBvn(String bvn)
  {
    String encripyValue = "";
    String responseEn = "";String decrpt = "";
    try
    {
      System.out.println("BVN<<>>>>>>> :" + bvn.trim() + "<<>>");
      encripyValue = validationencryptRequest(bvn);
      responseEn = verifySingleBVN(encripyValue, "032");
      decrpt = decryptRequest(responseEn);
    }
    catch (Exception ex)
    {
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
        //String OUTPUT_FILE = "C:\\Users\\baadedeji\\Documents\\NetBeansProjects\\UpdateBVNtoNIBSS\\web\\img\\Picture_"+bvn+".png";
       // String OUTPUT_FILE = "C:\\UpdateBVNtoNIBSS\\web\\img\\Picture_"+bvn+".png";
       // String OUTPUT_FILE = "C:\\UpdateBVNtoNIBSS\\web\\img\\Picture_22222222222.png";
        OutputStream out = new FileOutputStream(OUTPUT_FILE);
        System.out.println("--Moved out of the Output File----");
//        SearchResult src = new SearchResult();
        String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>"+bvn.trim()+"</BVN></SearchRequest>";
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
            System.out.println("validateSingleBVN Result>>>>> " +validateSingleBVN(encryptValueSingle));
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
            System.out.println("Decrypted Xml for Single Validation >> " +decrypt);

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
    throws Exception_Exception
  {
    com.nibss.bvn.BVNValidation service = new com.nibss.bvn.BVNValidation();
    com.nibss.bvn.BVNValidationService port = service.getBVNValidationPort();
    return port.verifySingleBVN(bvn, bankCode);
  }
    
    
  public void executeBatchBVNs(){
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      String BVN = "";      
      Connection conn = null;
      BvnLogger bvn = new BvnLogger();
        try{
            conn = getConnection();
            BVNValidation service = new BVNValidation();
            BVNValidationService port = service.getBVNValidationPort();
            SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
            securityInteface hh = new securityInteface();
            System.out.println("SSMLib :: SSMLib :: UpdatekeyLocationPublic: " + hh.UpdatekeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: ValidationkeyLocationPublic: " + hh.ValidationkeyLocationPublic);
            System.out.println("SSMLib :: SSMLib :: keyLocationPrivate: " + hh.keyLocationPrivate);

            
            String query = "SELECT BVN FROM BVNBULKUPLOADTEST";
       
            pstmt = conn.prepareStatement(query);
            bvn.processLog("log>>>>>Query to fetch from table BVNBULKUPLOADTEST>>>>> ", "", query);
            if (pstmt.execute())
            {
              System.out.println("Executed Successfully!!!");
              rs = pstmt.getResultSet();
              bvn.processLog("log>>>>>Resultset ", "", rs.toString());
              System.out.println("The Query is: " + query);
            }
            else
            {
              System.out.println("Empty prepared Statement!!!");
              throw new Exception("Empty Prepared Statement");
            }
            String bvnumber = null;
            int count = 0;
            rs.getFetchSize();
            while (rs.next())
            {
             count++;
             bvnumber = rs.getString("BVN");
             System.out.println("The BVN is>>>>>  " +bvnumber);
             bvn.processLog("log>>>>>About Entering the method -bvnumber-", "", "bvnumber");
             
            String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>"+bvnumber.trim()+"</BVN></SearchRequest>";
            
            String encBvnSingle = enc.encryptMessage(single);

            System.out.println("Clear text request Single::::: " + single);
            System.out.println("Encrypted Single Request:::::" + encBvnSingle);

                SearchResult retSingle = port.validateSingleBVN(encBvnSingle);
                System.out.println("I have done port.validateSingleBVN(encBvnSingle) and the output is>>>> " +port.validateSingleBVN(encBvnSingle));
                System.out.println("Output retSingle is>>>> " +retSingle);
                
                String encSingle = retSingle.getBvnSearchResult();
                System.out.println("Response for Single Validation using NIBSS getBvnSearchResult >> " + encSingle);
                System.out.println("About to encrypt now------");
                System.out.println("Decrypted Xml for Single Validation >> " + enc.decryptFile(encSingle, password));
                bvn.processLog("log>>>>>The response XML is", "", enc.decryptFile(encSingle, password));
                }
       if (pstmt != null) {
        pstmt.close();
      }
      if (rs != null) {
        rs.close();
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
        if (conn != null)
        {
          conn.close();
          System.out.println("I am closing the connection!!");
        }
      }
      catch (SQLException ex)
      {
        ex.printStackTrace();
      }
    }
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

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }    
    
}
