package com.unionbank.core;

import java.io.FileWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MGLogger
{
  static String logFile = "C:\\bvnUpdateService\\log\\bvnUpdate";
  
  public static void processLog(String messageType, String direction, String xmlStringresr)
  {
    boolean isStoredIntoFlatFile;
    System.out.println("messageType <<>>" + messageType);
    SimpleDateFormat sformatter = new SimpleDateFormat("yyyy_MM_dd");
    
    SimpleDateFormat sformatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String current_date = sformatter.format(new Date());
    String current_date2 = sformatter2.format(new Date());
    try
    {
      isStoredIntoFlatFile = storeInFlatFile("" + messageType + " " + direction + " " + current_date2 + " " + xmlStringresr + "\n", logFile + "_" + current_date + ".txt");
    }
    catch (Exception e)
    {
      
      e.printStackTrace();
    }
  }
  
  public static boolean storeInFlatFile(String request, String fileName)
  {
    boolean isStored = false;
    try
    {
      FileWriter file = new FileWriter(fileName, true);
      file.write(request);
      
      file.flush();
      file.close();
      isStored = true;
    }
    catch (Exception ex)
    {
      System.out.println("NFPBankInterface :: NIPProcessor :: storeInFlatFile :: Error Occurred...");
      ex.printStackTrace();
    }
    return isStored;
  }
}
