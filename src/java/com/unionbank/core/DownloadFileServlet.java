/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;


 
import com.unionbank.webpay.parameters.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class DownloadFileServlet extends HttpServlet {
    private Settings settings = Settings.getInstance("");
    String filePathDir = settings.getProperty("UploadDownloadPath");
 
    protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        // reads input file from an absolute path
        String filename = request.getParameter("myfile"); 
       
        String filePath = filePathDir+filename;
//        String filePath = "C:\\Users\\baadedeji\\Documents\\Upload\\"+filename;
        //String filePath = "C:\\Upload\\"+filename;
       // String filePath = "C:\\Upload2"+filename;
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);
        
        
        System.out.println("filename<<>> " + filename);
        // if you want to use a relative path to context root:
        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);         
        
        ServletContext context = getServletContext();         
        
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
         
        // modifies response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // forces download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // obtains response's output stream
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();     
    }
}