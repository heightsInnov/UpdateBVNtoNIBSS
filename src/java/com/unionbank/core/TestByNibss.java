/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.unionbank.BVNVer2.BVNValidation;
import com.unionbank.BVNVer2.BVNValidationService;
import com.unionbank.BVNVer2.SearchResult;
import com.unionbank.BVNVer2.SearchResults;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import javax.activation.DataHandler;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import nfp.ssm.core.SSMLib;

/**
 *
 * @author unwanyanwu
 */
public class TestByNibss {

    PBEncrytor Pb = new PBEncrytor();
    private Settings settings = Settings.getInstance("");
    final String UpdatekeyLocationPublic = settings.getProperty("UpdatekeyLocationPublic");
    //final String ValidationkeyLocationPublic = settings.getProperty("ValidationkeyLocationPublic");
    // final String keyLocationPrivate = settings.getProperty("keyLocationPrivate");
    final String password = Pb.PBDecrypt(settings.getProperty("password"));

    final static String path = "C:\\BVN_link_update\\keys\\";
    // final static String path2 = "C:\\BVN_link_update\\keys\\ToTest\\";
    final static String ValidationkeyLocationPublic = "C:\\BVN_link_update\\keys\\ToTest\\nibss_public.key";
    final static String keyLocationPrivate = "C:\\BVN_link_update\\keys\\unionbank_live_private.key";

    private static final String OUTPUT_FILE = "C:\\BVN_link_update\\keys\\phototestFile.png";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test();
      //  generateKeys();
    }

    public static void generateKeys() {
//        SSMLib lib = new SSMLib(path + "our_public.key", path + "our_private.key");
//        lib.generateKeyPair("user", "password");
        SSMLib lib = new SSMLib(path + "nibss_public.key", path + "unionbank_live_private.key");
        lib.generateKeyPair("bvnupdate", "bvn2016");
    }

    public static void test() {

        try {

            BVNValidation service = new BVNValidation();
            BVNValidationService port = service.getBVNValidationPort();
            // SSMLib enc = new SSMLib(path + "nibss_public.key", path + "\\our_private.key");
            //   SSMLib enc = new SSMLib(ValidationkeyLocationPublic, keyLocationPrivate);
            SSMLib enc = new SSMLib(path + "nibss_public.key", path + "unionbank_live_private.key");

            //Request for single and multiple search
            String single = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequest><BVN>22222222222</BVN></SearchRequest>";
            String multiple = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchRequests><BVNS>11111111111,22222222222,33333333340</BVNS></SearchRequests>";

            //Encryption of single and multple request strings
            String encBvnSingle = enc.encryptMessage(single);
            String encBvnMultiple = enc.encryptMessage(multiple);

            System.out.println("Clear text request Single::::: " + single);
            System.out.println("Clear text request Multiple::::: " + multiple);
            System.out.println("Encrypted Single Request:::::" + encBvnSingle);
            System.out.println("Encrypted Multiple Request:::::" + encBvnMultiple);

            //Call to web service
//            try
//            {
            OutputStream out = new FileOutputStream(OUTPUT_FILE);

            SearchResult retSingle = port.validateSingleBVN(encBvnSingle);
            SearchResults retMultiple = port.validateMultipleBVNs(encBvnMultiple);

            DataHandler handlerSingle = retSingle.getBinaryImage();

            InputStream in = handlerSingle.getInputStream();
            //byte[] byteArray = org.apache.commons.io.IOUtils.toByteArray(in);

            //File file = new File("C:\\Users\\baadedeji\\Documents\\BVN_link_update\\keys\\photo");
            out = new FileOutputStream(OUTPUT_FILE);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();

//                InputStream is = handlerSingle.getInputStream();
//                System.out.println("hshhhd" +is);                
            //Some bvns have no image currently
            if (handlerSingle != null) {
                System.out.println("Content Type of Single Validation Image >> " + handlerSingle.getContentType());
                System.out.println("Input Stream for Single Validation >> " + handlerSingle.getInputStream());
                System.out.println("handlerSingle.getName(); for Single Validation >> " + handlerSingle.getName());

                // System.out.println("Input Stream for Single Validation >> " + handlerSingle.writeTo(out)); 
            }

            String encSingle = retSingle.getBvnSearchResult();
            System.out.println("Encrypted response for Single Validation >> " + encSingle);
            System.out.println("Decrypted Xml for Single Validation >> " + enc.decryptFile(encSingle, "bvn2016"));

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
            //   }
//            } 
//            catch (Exception e)
//            {
//                e.printStackTrace();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String toXML(Object obj) throws JAXBException {
        String xmlString = null;
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        xmlString = writer.toString();

        return xmlString;
    }
}
