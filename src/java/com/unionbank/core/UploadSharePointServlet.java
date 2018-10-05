/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import static com.unionbank.core.SharePointUpload.client;
import com.unionbank.webpay.parameters.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author aojinadu
 */
public class UploadSharePointServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    private Settings settings = Settings.getInstance("");
    String filePath = settings.getProperty("SharepointURLFileUploadLink");
    String password = settings.getProperty("DB_PASSWORD");
    String username = settings.getProperty("DB_USER");
    String driver = settings.getProperty("DB_DRIVER");
    String conString = settings.getProperty("DB_CONNECTION");

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

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
                        System.out.println("item.isFormField() yes");
                        String fileName = new File(item.getName()).getName();
                        
                        String filePath = uploadPath + File.separator + fileName;
                        System.out.println("pth " + filePath);
                        // String filePath = "C:/testupload/" + fileName;
                        System.out.println("filePath<<>> " + filePath);
                        File storeFile = new File(filePath);

                        FileInputStream fis = null;
                        String fileLink = "";
                        // saves the file on sharepoint
                        try {
                            fis = new FileInputStream(storeFile);

                            fileLink = client.upload("http://sit-poc:2020/api/upload/test3", fis, storeFile.getName()).getResponseMessage();
                            System.out.println("====The File Link saved into the DB is=====" + fileLink.substring(1, fileLink.length() - 1));
                            String resp = fileLink.substring(1, fileLink.length() - 1);

                            String query = "UPDATE UNCLAIMED_FUNDS "
                                    + "SET FILENAME = '" + resp + "' ";
                                    //+ "WHERE NEW_ACC_NO = '" + accountNumber + "'  AND TRANS_ID = '" + transId + "'";

                            try {
                                Class.forName(driver).newInstance();
                                conn = DriverManager.getConnection(conString, username, password);
                                pst = conn.prepareStatement(query);
                                if (pst.executeUpdate() != Statement.EXECUTE_FAILED) {

                                } else {
                                    throw new Exception("Empty Prepared Statement");
                                }
                            } catch (Exception e) {
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
