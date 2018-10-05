/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import java.io.FileWriter;

/**
 *
 * @author baadedeji
 */
public class BvnLogger {

    static String logFile = "C:\\BVNXMLLogger\\Logs\\ProcessLogs";

public BvnLogger()    {    
}
    
    public static void processLog(String messageType, String direction, String xmlStringresr) {
        System.out.println("messageType <<>>" + messageType);
        java.text.SimpleDateFormat sformatter = new java.text.SimpleDateFormat("yyyy_MM_dd");
        java.text.SimpleDateFormat sformatter2;
        sformatter2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date = sformatter.format(new java.util.Date());
        String current_date2 = sformatter2.format(new java.util.Date());
        try {

            boolean isStoredIntoFlatFile = storeInFlatFile("" + messageType + " " + direction + " " + current_date2 + " " + xmlStringresr + "\n", logFile + "_" + current_date + ".txt");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public static boolean storeInFlatFile(String request, String fileName) {
        boolean isStored = false;

        try {
            FileWriter file = new FileWriter(fileName, true);
            file.write(request);

            file.flush();
            file.close();
            isStored = true;
        } catch (Exception ex) {
            System.out.println("NFPBankInterface :: NIPProcessor :: storeInFlatFile :: Error Occurred...");
            ex.printStackTrace();
        }

        return isStored;
    }
}
