/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.unionbank.sharepoint.documents.UploadClient;
import com.unionbank.sharepoint.dao.Response;
import com.unionbank.webpay.parameters.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SharePointUpload {

    static Response res = new Response();
    private static Settings settings = Settings.getInstance("");
    public static UploadClient client = new UploadClient();
    private static String sharepointStorage = settings.getProperty("SharepointURLFileUploadLink2");
    private static String password = settings.getProperty("DB_PASSWORD");
    private static String username = settings.getProperty("DB_USER");
    private static String driver = settings.getProperty("DB_DRIVER");
    private static String conString = settings.getProperty("DB_CONNECTION");

    public static String uploadToSharepoint(String uploadedFile, String transId) {
        String fileLink = "";
        String resp = "";

        Response res = new Response();
        res.setResponseMessage(fileLink);
        File inFile = new File(uploadedFile);
        FileInputStream fis = null;
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            fis = new FileInputStream(inFile);

            fileLink = client.upload("http://sit-poc:2020/api/upload/test3", fis, inFile.getName()).getResponseMessage();
            System.out.println("====The File Link saved into the DB is=====" + fileLink.substring(1, fileLink.length() - 1));
            resp = fileLink.substring(1, fileLink.length() - 1);

//            String query = "UPDATE UNCLAIMED_FUNDS "
//                    + "SET FILENAME = '" + resp + "' "
//                    + "WHERE NEW_ACC_NO = '" + accountNumber + "'  AND TRANS_ID = '" + transId + "'";
//
//            try {
//                Class.forName(driver).newInstance();
//                conn = DriverManager.getConnection(conString, username, password);
//                pst = conn.prepareStatement(query);
//                if (pst.executeUpdate() != Statement.EXECUTE_FAILED) {
//
//                } else {
//                    throw new Exception("Empty Prepared Statement");
//                }
//            } catch (Exception e) {
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    public static void main(String[] args) throws FileNotFoundException {

        // the file we want to upload
        String fileLink = "";

        Response res = new Response();
        res.setResponseMessage(fileLink);
        File inFile = new File("C:\\Users\\aojinadu\\Documents\\hello.txt");
        FileInputStream fis = null;
        fis = new FileInputStream(inFile);

        try {
            fileLink = client.upload("http://sit-poc:2020/api/upload/test3", fis, inFile.getName()).getResponseMessage();
            System.out.println("====The File Link saved into the DB is=====" + fileLink.substring(1, fileLink.length() - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //fileLink =  client.upload("http://172.16.11.56:2020/api/upload/test2", fis, inFile.getName()).getResponseMessage();
        //fileLink =  client.upload(sharepointStorage, fis, inFile.getName()).getResponseMessage();
        //System.out.println("====The File Link saved into the DB is=====" +fileLink.substring(1,fileLink.length()-1));
    }
}
