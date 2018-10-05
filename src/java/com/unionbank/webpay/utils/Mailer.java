/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.utils;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author wale_a
 */
public class Mailer {

    private Properties props;
    private Session session;
    private MimeMessage msg;

    /** Creates a new instance of mailer */
    public Mailer() {
        msg = null;
        props = System.getProperties();
        props.put("mail.smtp.host", "172.16.11.22");
       // props.put("mail.smtp.host", "172.16.10.184");
        props.put("mail.smtp.port", "25");
              
        session = Session.getDefaultInstance(props, null);
    }

    public int Send(String SMTPServer,
            String Sender,
            String Recipient,
            String CcRecipient,
            String BccRecipient,
            String Subject,
            String Body,
            String ErrorMessage[],
            String Attachments) {
        // Error status;
        int ErrorStatus = 0;
        // Create some properties and get the default Session;
        msg = new MimeMessage(session);

        try {
            // extracts the senders and adds them to the message.
            // Sender is a comma-separated list of e-mail addresses as per RFC822.
            {
                InternetAddress[] TheAddresses = InternetAddress.parse(Sender);
                msg.addFrom(TheAddresses);
            }

            // Extract the recipients and assign them to the message.
            // Recipient is a comma-separated list of e-mail addresses as per RFC822.
            {
                InternetAddress[] TheAddresses = InternetAddress.parse(Recipient);
                msg.addRecipients(Message.RecipientType.TO, TheAddresses);
            }


            // Extract the Cc-recipients and assign them to the message;
            // CcRecipient is a comma-separated list of e-mail addresses as per RFC822
            if (null != CcRecipient) {
                InternetAddress[] TheAddresses = InternetAddress.parse(CcRecipient);
                msg.addRecipients(Message.RecipientType.CC, TheAddresses);
            }

            // Extract the Bcc-recipients and assign them to the message;
            // BccRecipient is a comma-separated list of e-mail addresses as per RFC822
            if (null != BccRecipient) {
                InternetAddress[] TheAddresses = InternetAddress.parse(BccRecipient);
                msg.addRecipients(Message.RecipientType.BCC, TheAddresses);
            }

            // Subject field
            msg.setSubject(Subject);

            // Create the Multipart to be added the parts to
            Multipart mp = new MimeMultipart();

            // Create and fill the first message part
            {
                MimeBodyPart mbp = new MimeBodyPart();
                mbp.setContent(Body, "text/html");

                // Attach the part to the multipart;
                mp.addBodyPart(mbp);
            }

            // Attach the files to the message
            if (null != Attachments) {
                int StartIndex = 0, PosIndex = 0;
                while (-1 != (PosIndex = Attachments.indexOf("///", StartIndex))) {
                    // Create and fill other message parts;
                    MimeBodyPart mbp = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(Attachments.substring(StartIndex, PosIndex));
                    mbp.setDataHandler(new DataHandler(fds));
                    mbp.setFileName(fds.getName());
                    mp.addBodyPart(mbp);
                    PosIndex += 3;
                    StartIndex = PosIndex;
                }
                // Last, or only, attachment file;
                if (StartIndex < Attachments.length()) {
                    MimeBodyPart mbp = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(Attachments.substring(StartIndex));
                    mbp.setDataHandler(new DataHandler(fds));
                    mbp.setFileName(fds.getName());
                    mp.addBodyPart(mbp);
                }
            }

            // Add the Multipart to the message
            msg.setContent(mp);
            //msg.setContent(Body,"text/html");

            // Set the Date: header
            msg.setSentDate(new Date());

            // Send the message;
            Transport.send(msg);
            System.out.println("EMAIL SENT TO..." + Recipient);
            System.out.println("EMAIL SENT TO >>>>"  + CcRecipient );
            System.out.println("EMAIL SENT TO====" + BccRecipient);
             

        } catch (Exception MsgException) {
            MsgException.printStackTrace();
        }
        return ErrorStatus;
    } // End Send Class
}
