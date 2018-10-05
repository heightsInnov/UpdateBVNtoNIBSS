package com.unionbank.core;

import com.nibss.bvn.validation.Exception_Exception;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import nfp.ssm.core.SSMLib;

public class securityInteface {

    PBEncrytor Pb = new PBEncrytor();
    private Settings settings = Settings.getInstance("");
    String UpdatekeyLocationPublic = settings.getProperty("UpdatekeyLocationPublic");
    String ValidationkeyLocationPublic = settings.getProperty("ValidationkeyLocationPublic");
    String keyLocationPrivate = settings.getProperty("keyLocationPrivate");
    String password = Pb.PBDecrypt(settings.getProperty("password"));

    public static void main(String[] args) throws Exception_Exception {
        securityInteface hh = new securityInteface();
        System.out.println("SSMLib :: SSMLib :: UpdatekeyLocationPublic: " + hh.UpdatekeyLocationPublic);
        System.out.println("SSMLib :: SSMLib :: ValidationkeyLocationPublic: " + hh.ValidationkeyLocationPublic);
        // tClass.generateKeyPair("aajibade@unionbankng.com", "***MyRedeemerLives7","C:\\testKeys");
        String encript = "848C03C9DD00356EA9C9390103FE331D2C4992DFDAE7EAA4BFAAD41FF42110B50389AEAB8D9108DDA97965C18597BDD484DBF2282F090CE684212DCB166B7D2F5A65F028D77DD0C8F5CDA324FC0C27D4EB9B84B334CC960F11E0FAAE91BDA921FE9D423FB18B967600332A84A03A38BD59E5BD81DE5D3B8289940D2EF5F6D6F720B0F8712F126EE7F81A811D1654C99159F06734E6A5D2E3B8D93BECC3CBE3702AE156FA14BFF24356BDA873EA7A96212582CCFB05A484E9E9DA777F4C9812EF16562B10FE3AB81D476A00453B371953732B347A523B5AB84DE003F9AAA36C996B0D95ACEFD36685C048E7B03DE24B9A5172D481FB33625C5961D98B75C930EFE13CEB76BF332CF15153D8FD526003F4828882014593024984FF30BE24A3E0900F;";
        //  hh.generatePublicAndPrivateKeys();
        //System.out.println("SSMLib :: SSMLib :: publicKeyFileName: " + hh.validationencryptRequest( "11111111111") );
        // System.out.println("SSMLib :: SSMLib :: publicKeyFileName: " + hh.validationencryptRequest( "12941630400") );
//;
        String response = "";
        String bvn = "12941630400", OldEmail = "", NewEmail = "", emailReasonForChange = "", OldFirstName = "", NewFirstName = "", fisrtReasonForChange = "", OldGender = "", NewGender = "", genderReasonForChange = "", OldLastName = "", NewLastName = "",
                lastReasonForChange = "", placeholder = "";
        

        response = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<UpdateDetail>\n"
                + "\n"
                + "	<BVN>22296458679</BVN>	\n"
                + "	<Email OldEmail=''  NewEmail='OBANDEECHOBU@GMAIL.COM' ReasonForChange='OK' />\n"
                + "	<FirstName OldFirstName='EBENEZER' NewFirstName='EMMANUEL' ReasonForChange='OK' />\n"
                + "	<LastName OldLastName='OKANLAWON' NewLastName='OBANDE' ReasonForChange='OK' />\n"
                + "	<LevelOfAccount OldLevelOfAccount='Level 1'   NewLevelOfAccount='Level 1 - Low Level Accounts'  ReasonForChange='OK'  />\n"
                + "	<MiddleName OldMiddleName='ADELEKE' NewMiddleName='ECHOBU' ReasonForChange='OK' />\n"
                + "	<PhoneNumber1 OldPhoneNumber1='08084357777' NewPhoneNumber1='08033322173' ReasonForChange='OK' />\n"
                + "	<DateOfBirth OldDateOfBirth='22-FEB-1965' NewDateOfBirth='05-MAY-1963' ReasonForChange='OK' />\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "</UpdateDetail>";
       // System.out.println("SSMLib :: SSMLib :: update clear cipher: " + response);
        //  System.out.println("SSMLib :: SSMLib :: verifySingleBVN: " +verifySingleBVN(encript, "032"));
        System.out.println("SSMLib :: SSMLib :: publicKeyFileName: " + hh.decryptRequest(encript));

      //  System.out.println("SSMLib :: SSMLib :: : " + hh.updateencryptRequest(response));

        //   System.out.println("SSMLib :: SSMLib :: <<<>>: " + hh.validateBvn( "12941630400") );


    }

    // public void generatePublicAndPrivateKeys() {//C:/Users/aajibade/Documents/BVN_link_update/keys
    //     SSMLib enc = new SSMLib("C:/Users/aajibade/Documents/BVN_link_update/keys/unionbank_public.key", "C:/Users/aajibade/Documents/BVN_link_update/keys/unionbank_private.key");
    //      enc.generateKeyPair("aajibade@unionbankng.com", "***MyRedeemerLives7");
    //  }
    public String validateBvn(String bvn) {
        String encripyValue = "";
        String responseEn = "", decrpt = "";
        try {
            System.out.println("BVN<<>>>>>>> :" + bvn.trim() + "<<>>");
            encripyValue = validationencryptRequest(bvn.trim());
            System.out.println("encripyValueBVN<<>>>>>>> :" + encripyValue);

            responseEn = verifySingleBVN(encripyValue.trim(), "032");
            System.out.println("to decrpt<<>>>>>>> :" + responseEn);
            decrpt = decryptRequest(responseEn.trim());

        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
        }


        //  String response = "";
        return decrpt;
    }

    public String updateencryptRequest(final String dataToEncrypt) {
        //  SSMLib enc = new SSMLib(keyLocation+"/nibss_public.key", "c:/unionbank_private.key");//unionbank_public.key
        SSMLib enc = new SSMLib(UpdatekeyLocationPublic, keyLocationPrivate);//unionbank_public.key

        return enc.encryptMessage(dataToEncrypt);
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

    private static String verifySingleBVN(java.lang.String bvn, java.lang.String bankCode) throws Exception_Exception {
        com.nibss.bvn.validation.BVNValidation service = new com.nibss.bvn.validation.BVNValidation();
        com.nibss.bvn.validation.BVNValidationService port = service.getBVNValidationPort();
        return port.verifySingleBVN(bvn, bankCode);
    }
}
