/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.utils;

import com.sun.mail.smtp.SMTPMessage;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author baadedeji
 */
public class EmailUtility {

    public static boolean isValidEmailAddress(String email) {

        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        String to = "baadedeji@unionbankng.com"; //both emails are valid
        String from = "baadedeji@unionbankng.com";
        //String host = "172.16.10.184";
        String host = "172.16.11.22";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "25");
        //properties.setProperty("mail.smtp.port", "587");
        
        properties.setProperty("mail.transport.protocol", "SMTP");
        Session session = Session.getDefaultInstance(properties);

        SMTPMessage smtpMessage = new SMTPMessage(session);
        try {
            smtpMessage.setSender(new InternetAddress(from));
            smtpMessage.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            smtpMessage.setSubject("Hello Test Email");
            smtpMessage.setText("Test Email to check Delivery Report");
            smtpMessage.setReturnOption(SMTPMessage.RETURN_FULL);
            smtpMessage.setNotifyOptions(SMTPMessage.NOTIFY_FAILURE);
            smtpMessage.setNotifyOptions(SMTPMessage.NOTIFY_SUCCESS);

         //   Transport.send(smtpMessage, "treasurybillsrequest", "Treasurybills123");
            Transport.send(smtpMessage, "baadedeji", "Billgates2026");
            //Transport.send(smtpMessage);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error while building smpt email");
        }

    }

    private boolean validateEmail(String email) {

        boolean isValid = false;

        try {

//Create InternetAddress object and validated the email address.
            InternetAddress internetAddress = new InternetAddress(email);

            internetAddress.validate();

            isValid = true;

        } catch (AddressException e) {

            e.printStackTrace();

        }

        return isValid;

    }

    private void printStatus(String email, boolean valid) {

        System.out.println(email + " is " + (valid ? "a" : "not a")
                + " valid email address");
    }

}
