/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import static com.unionbank.core.SharePointUpload.client;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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

public class UploadDocServlet extends HttpServlet {

    PBEncrytor Pb = new PBEncrytor();
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private Settings settings = Settings.getInstance("");
    String uploadDestination = settings.getProperty("SharepointURLFileUploadLink");
    String filePath = settings.getProperty("UploadDownloadPath");
    String password = Pb.PBDecrypt(settings.getProperty("password-password"));
    String username = settings.getProperty("user-user");
    String conString = settings.getProperty("host-host");
    String driver = settings.getProperty("DB_DRIVER");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();

        String transactionid = request.getParameter("transactionid");
        transactionid = transactionid != null ? transactionid : "";

        String bvnumber = request.getParameter("bvnumber");
        bvnumber = bvnumber != null ? bvnumber : "";

        Connection conn = null;
        PreparedStatement pst = null;

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

        String uploadPath = filePath;

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
                        System.out.println("item.isFormField() No");
                        String fileName = new File(item.getName()).getName();

                        String filePath = uploadPath + File.separator + fileName;
                        System.out.println("pth " + filePath);
                        // String filePath = "C:/testupload/" + fileName;
                        System.out.println("filePath<<>> " + filePath);
                        File storeFile = new File(filePath);

                        item.write(storeFile);

                        FileInputStream fis = null;
                        String fileLink = "";

                        // saves the file on sharepoint
                        try {
                            fis = new FileInputStream(storeFile);
                            fileLink = client.upload(uploadDestination, fis, storeFile.getName()).getResponseMessage();
                            System.out.println("====The File Link saved into the DB is=====" + fileLink.substring(1, fileLink.length() - 1));

                            String resp = fileLink.substring(1, fileLink.length() - 1);

//                            String query = "UPDATE CUSTOMER_UPDATE_REQ "
//                                    + "SET UPLOADPATH = '" + resp + "' "
//                                    + "WHERE BVNUMBER = '" + bvnumber + "'  AND TXNID = '" + transactionid + "'";
//
//                            Class.forName(driver).newInstance();
//                            conn = DriverManager.getConnection(conString, username, password);
//                            pst = conn.prepareStatement(query);
//                            if (pst.executeUpdate() != Statement.EXECUTE_FAILED) {
//
//                                session.setAttribute("msg-info-signin", "Successfully Saved!");
//                                request.setAttribute("msg-info-signin", "Successfully Saved!");
//                                System.out.println("Upload has been done successfully!");
//                            }
                        } catch (Exception ex) {
                            System.out.println("There was an error!!: " + ex.getMessage());
                            ex.printStackTrace();
                            request.setAttribute("message", "There was an error: " + ex.getMessage());
                            System.out.println("There was an error: ");
                        }
                        //Delete file from local directory
                        if (storeFile.isFile()) {
                            storeFile.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
