/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

/**
 *
 * @author aajibade
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.unionbank.ADService.UserProfile;
import com.unionbank.webpay.parameters.Settings;

/**
 * A Java servlet that handles file upload from client.
 *
 * @author www.codejava.net
 */
public class UploadServletOld extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private Settings settings = Settings.getInstance("");
    String filePath = settings.getProperty("UploadDownloadPath");

    /**
     * handles file upload via HTTP POST method
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // checks if the request actually contains upload file
        String login_attempts = "", transactionid = "", bvnNo = "", makerId = "", branchCode = "", firstnamefile = "", middlenamefile = "";
        String lastnamefile = "", dobfile = "", phonenofile = "", emailfile = "";
        String marstatusfile = "", sexfile = "", stateoforiginfile = "", resaddressfile = "", lgafile = "";
        
//        firstnamefile = "", middlenamefile = "";
//        String lastnamefile = "", dobfile = "", phonenofile = "", emailfile = "";
//        String marstatusfile = "", sexfile = "", stateoforiginfile = "", resaddressfile = "", lgafile = "";
        //if (login_attempts == null) {
        //     login_attempts = "";
        //  }

        Processor pb = new Processor();
        // System.out.println("Request <<<>>>>" + login_attempts);
        HttpSession session = request.getSession();
        UserProfile ursP = (UserProfile) session.getAttribute("Urs");
        String username = "";

        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Request does not contain upload data");
            request.setAttribute("msg-info-signin", "No Attachment!!!");
            System.out.println("Request does not contain upload data");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        // upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);
//a
        // constructs the directory path to store upload file
        //  String uploadPath = getServletContext().getRealPath("")+ File.separator + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        //String uploadPath = "C:\\Users\\aajibade\\Documents\\uploads";
         //String uploadPath = "C:\\Upload2";
         
        String uploadPath = filePath;
//        String uploadPath = "C:\\Users\\baadedeji\\Documents\\Upload\\";
       // String uploadPath = "C:\\Upload";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        System.out.println("got here" + uploadPath);

        try {
            // parses the request's content to extract file data
            List formItems = upload.parseRequest(request);
            Iterator iter = formItems.iterator();

            // iterates over form's fields
            int n = 0;
            while (iter.hasNext()) {
                n++;
                System.out.println("iter.hasNext yes");
                FileItem item = (FileItem) iter.next();
                

                // processes only fields that are not form fields
                System.out.println("(" + n + ") Size check" + item.getSize());
                if (!item.isFormField()) {
                    try {
                        System.out.println("item.isFormField() yes");
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        System.out.println("pth " + filePath);
                        // String filePath = "C:/testupload/" + fileName;
                        System.out.println("filePath<<>> "+filePath);
                        File storeFile = new File(filePath);

                        // saves the file on disk
                        item.write(storeFile);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                if (item.isFormField()) //your code for getting form fields
                {
                    try{
                    System.out.println("This iterate223 ");
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println("<<<>>>>>name: " + name + " <<>>value: " + value);
                    if (name.equalsIgnoreCase("firstnamefile")) {
                        firstnamefile = value;
                    }
                    if (name.equalsIgnoreCase("transactionid")) {
                        transactionid = value;
                    }

                    if (name.equalsIgnoreCase("middlenamefile")) {
                        middlenamefile = value;
                    }
                    if (name.equalsIgnoreCase("lastnamefile")) {
                        lastnamefile = value;
                    }
                    if (name.equalsIgnoreCase("dobfile")) {
                        dobfile = value;
                    }
                    if (name.equalsIgnoreCase("phonenofile")) {
                        phonenofile = value;
                    }
                    if (name.equalsIgnoreCase("emailfile")) {
                        emailfile = value;
                    }
                    if (name.equalsIgnoreCase("marstatusfile")) {
                        marstatusfile = value;
                    }
                    if (name.equalsIgnoreCase("sexfile")) {
                        sexfile = value;
                    }
                    if (name.equalsIgnoreCase("stateoforiginfile")) {
                        stateoforiginfile = value;
                    }
                    if (name.equalsIgnoreCase("resaddressfile")) {
                        resaddressfile = value;
                    }
                    if (name.equalsIgnoreCase("lgafile")) {
                        lgafile = value;
                    }
                    
//                    if (name.equalsIgnoreCase("firstnamefile")) {
//                        firstnamefile = value;
//                    }
//                    if (name.equalsIgnoreCase("transactionid")) {
//                        transactionid = value;
//                    }
//
//                    if (name.equalsIgnoreCase("middlenamefile")) {
//                        middlenamefile = value;
//                    }
//                    if (name.equalsIgnoreCase("lastnamefile")) {
//                        lastnamefile = value;
//                    }
//                    if (name.equalsIgnoreCase("dobfile")) {
//                        dobfile = value;
//                    }
//                    if (name.equalsIgnoreCase("phonenofile")) {
//                        phonenofile = value;
//                    }
//                    if (name.equalsIgnoreCase("emailfile")) {
//                        emailfile = value;
//                    }
//                    if (name.equalsIgnoreCase("marstatusfile")) {
//                        marstatusfile = value;
//                    }
//                    if (name.equalsIgnoreCase("sexfile")) {
//                        sexfile = value;
//                    }
//                    if (name.equalsIgnoreCase("stateoforiginfile")) {
//                        stateoforiginfile = value;
//                    }
//                    if (name.equalsIgnoreCase("resaddressfile")) {
//                        resaddressfile = value;
//                    }
//                    if (name.equalsIgnoreCase("lgafile")) {
//                        lgafile = value;
//                    }
                    
                     } catch (Exception ex) {
                         ex.printStackTrace();
                     }
//String  lastnamefile="",  dobfile="",  phonenofile ="", emailfile="";
                }

            }

           // request.setAttribute("message", "Upload has been done successfully!");
            session.setAttribute("msg-info-signin", "Successfully Saved!");
            request.setAttribute("msg-info-signin", "Successfully Saved!");
            System.out.println("Upload has been done successfully!");
        } catch (Exception ex) {

            System.out.println("There was an error!!: " + ex.getMessage());
            ex.printStackTrace();
            request.setAttribute("message", "There was an error: " + ex.getMessage());
            System.out.println("There was an error: ");
        }
        try {
            pb.updateFileuploadUrl("firstnamefile", transactionid, firstnamefile);
            pb.updateFileuploadUrl("middlenamefile", transactionid, middlenamefile);
            pb.updateFileuploadUrl("lastnamefile", transactionid, lastnamefile);
            pb.updateFileuploadUrl("dobfile", transactionid, dobfile);
            pb.updateFileuploadUrl("phonenofile", transactionid, phonenofile);
            pb.updateFileuploadUrl("emailfile", transactionid, emailfile);            
            pb.updateFileuploadUrl("marstatusfile", transactionid, marstatusfile);
            pb.updateFileuploadUrl("sexfile", transactionid, sexfile);
            pb.updateFileuploadUrl("stateoforiginfile", transactionid, stateoforiginfile);
            pb.updateFileuploadUrl("resaddressfile", transactionid, resaddressfile);
            pb.updateFileuploadUrl("lgafile", transactionid, lgafile);
            
//            pb.updateFileuploadUrl("firstnamefile", transactionid, firstnamefile);
//            pb.updateFileuploadUrl("middlenamefile", transactionid, middlenamefile);
//            pb.updateFileuploadUrl("lastnamefile", transactionid, lastnamefile);
//            pb.updateFileuploadUrl("dobfile", transactionid, dobfile);
//            pb.updateFileuploadUrl("phonenofile", transactionid, phonenofile);
//            pb.updateFileuploadUrl("emailfile", transactionid, emailfile);            
//            pb.updateFileuploadUrl("marstatusfile", transactionid, marstatusfile);
//            pb.updateFileuploadUrl("sexfile", transactionid, sexfile);
//            pb.updateFileuploadUrl("stateoforiginfile", transactionid, stateoforiginfile);
//            pb.updateFileuploadUrl("resaddressfile", transactionid, resaddressfile);
//            pb.updateFileuploadUrl("lgafile", transactionid, lgafile);
        } catch (Exception ex) {
            ex.printStackTrace();
            //  request.setAttribute("message", "There was an error: " + ex.getMessage());
            // System.out.println("There was an error: ");
        }
        try {
            pb.logAuditTrail("3", ursP, transactionid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //pb.logAuditTrail("3", username.trim());
        session.setAttribute("msg-info-signin", "Successfully Saved!");
        getServletContext().getRequestDispatcher("/pendinglist.jsp").forward(request, response);
    }
}