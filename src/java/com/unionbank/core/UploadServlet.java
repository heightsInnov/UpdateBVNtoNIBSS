/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.unionbank.sharepoint.documents.UploadClient;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 3145728)
public class UploadServlet extends HttpServlet {

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

        Part filePart = request.getPart("myFile");
        String contentDisposition = filePart.getHeader("Content-Disposition");
//        String fName = (contentDisposition.substring(43, contentDisposition.length() - 1));
        String fName = contentDisposition;
        System.out.println("fName value >>>>>>> " + fName);

        String fileName = fName;
        System.out.println("File part NAME is>>>>> " + fileName);
        InputStream inputStream = null;

        Connection conn = null;
        PreparedStatement pst = null;
        String fileLink = "";

        // System.out.println("got here" + uploadPath);
        // saves the file on sharepoint
        try {
            inputStream = filePart.getInputStream();
            fileLink = UploadClient.upload(uploadDestination, inputStream, fileName).getResponseMessage();
            
            System.out.println("====The File Link saved into the DB is=====" + fileLink.substring(1, fileLink.length() - 1));

            String resp = fileLink.substring(1, fileLink.length() - 1);

            String query = "UPDATE CUSTOMER_UPDATE_REQ "
                    + "SET UPLOADPATH = '" + resp + "' "
                    + "WHERE BVNUMBER = '" + bvnumber + "'  AND TXNID = '" + transactionid + "'";
            
            System.out.println("Query to update is:::: "+query);
            
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(conString, username, password);
            pst = conn.prepareStatement(query);
            if (pst.executeUpdate() != Statement.EXECUTE_FAILED) {

                session.setAttribute("msg-info-signin", "Successfully Saved!");
                request.setAttribute("msg-info-signin", "Successfully Saved!");
                System.out.println("Upload has been done successfully!");
            }
        } catch (Exception ex) {
            System.out.println("There was an error!!: " + ex.getMessage());
            ex.printStackTrace();
            request.setAttribute("message", "There was an error: " + ex.getMessage());
            System.out.println("There was an error: ");
        }

        //}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
