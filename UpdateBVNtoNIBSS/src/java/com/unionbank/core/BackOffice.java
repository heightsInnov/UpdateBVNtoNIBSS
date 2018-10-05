/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.google.gson.Gson;
import com.unionbank.webpay.db.dao.CustomerData;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class BackOffice extends HttpServlet {

    private static final long serialVersionUID = 1L;
    Processor Pb = new Processor();

    public BackOffice() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bvnumber = request.getParameter("bvnumber");

        String username = request.getParameter("username");
        String branchcode = request.getParameter("branchcode");


        System.out.println(" bvnumber <<>>>" + bvnumber);
        System.out.println(" bvnumber <<>>>" + branchcode);
        System.out.println(" bvnumber <<>>>" + username);
        //  bvnumber= "22153140604";

        String transactionid = request.getParameter("transactionid");

        System.out.println(" transactionid <<>>>" + transactionid);
        boolean isther = false;//
        //////////////////////////////////////////////////////

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // String transactionid="";
        try {
            // parses the request's content to extract file data
            List formItems = upload.parseRequest(request);
            Iterator iter = formItems.iterator();

            // iterates over form's fields
            while (iter.hasNext()) {
                System.out.println("iter.hasNext yes");
                FileItem item = (FileItem) iter.next();


                if (item.isFormField()) //your code for getting form fields
                {
                    System.out.println("This iterate223 ");
                    String name = item.getFieldName();
                    String value = item.getString();
                    System.out.println("<<<>>>>>name: " + name + " <<>>value: " + value);

                    if (name.equalsIgnoreCase("transactionid")) {
                        transactionid = value;
                    }



                }

            }
            System.out.println("<<<>>>>>tranx: " + transactionid);

            request.setAttribute("message", "Upload has been done successfully!");
            System.out.println("Upload has been done successfully!");
        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
            System.out.println("There was an error: ");
        }
        ///////////////////
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String json = "";
        if (br != null) {
            json = br.readLine();
        }
        System.out.println("got json <<>>>" + json);

        Gson gson = new Gson();
        // 2. initiate jackson mapper

        try {
            //  CustomerData obj = gson.fromJson(json, CustomerData.class);
            CustomerData[] obj = gson.fromJson(json, CustomerData[].class);

            System.out.println("got json <<>>>" + obj[0].getField());
            System.out.println("got json <<>>>" + obj[0].getNewValue());
            System.out.println("got json <<>>>" + obj[0].getOldValue());
            System.out.println("got json <<>>>" + obj[0].getFileupload());
            System.out.println("got json <<>>>" + obj[0].getComment());

            System.out.println("got getField <<>>>" + obj[5].getField());
            System.out.println("got getNewValue <<>>>" + obj[5].getNewValue());
            System.out.println("got getOldValue <<>>>" + obj[5].getOldValue());
            System.out.println("got getFileupload <<>>>" + obj[5].getFileupload());
            System.out.println("got getComment <<>>>" + obj[5].getComment());
            isther = Pb.processBVNUpdateRequest(obj, bvnumber, "", branchcode, username);

            System.out.println("isther <<>>>" + isther);
            if (isther) {//pendinglist
                System.out.println("isther <<>>>2" + isther);
                response.sendRedirect("pendinglist.jsp");
            } else {
                System.out.println("isther <<>>>2ddddd" + isther);
                // session.setAttribute("msg-info-signin", "Invalid BVN");
                request.setAttribute("message", "Transaction was not Saved .Please contact Admin");
                response.sendRedirect("bvn_verification.jsp");
            }




        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("isther <<>>>2eeesd" + isther);
            // session.setAttribute("msg-info-signin", "Invalid BVN");
            request.setAttribute("message", "Transaction was not Saved .Please contact Admin" + e.getMessage());
            response.sendRedirect("bvn_verification.jsp");
        }

        // 4. Set response type to JSON
        response.setContentType("application/json");

        // 5. Add article to List<Article>
//        articles.add(article);

        /*        Country countryInfo = getInfo(countryCode);
         JsonElement countryObj = gson.toJsonTree(countryInfo);
         if (countryInfo.getName() == null) {
         myObj.addProperty("success", false);
         } else {
         myObj.addProperty("success", true);
         }
         myObj.add("countryInfo", countryObj);
         out.println(myObj.toString());

         out.close();*/

    }
    //Get Country Information
   /* private Country getInfo(String countryCode) {

     Country country = new Country();
     Connection conn = null;
     PreparedStatement stmt = null;
     String sql = null;

     try {
     Context ctx = (Context) new InitialContext().lookup("java:comp/env");
     conn = ((DataSource) ctx.lookup("jdbc/mysql")).getConnection();

     sql = "Select * from COUNTRY where code = ?";
     stmt = conn.prepareStatement(sql);
     stmt.setString(1, countryCode.trim());
     ResultSet rs = stmt.executeQuery();

     while (rs.next()) {
     country.setCode(rs.getString("code").trim());
     country.setName(rs.getString("name").trim());
     country.setContinent(rs.getString("continent").trim());
     country.setRegion(rs.getString("region").trim());
     country.setLifeExpectancy(rs.getString("lifeExpectancy") == null ? new Double(0) : Double.parseDouble(rs.getString("lifeExpectancy").trim()));
     country.setGnp(rs.getString("gnp") == null ? new Double(0) : Double.parseDouble(rs.getString("gnp").trim()));
     }

     rs.close();
     stmt.close();
     stmt = null;


     conn.close();
     conn = null;

     } catch (Exception e) {
     System.out.println(e);
     } finally {

     if (stmt != null) {
     try {
     stmt.close();
     } catch (SQLException sqlex) {
     // ignore -- as we can't do anything about it here           
     }

     stmt = null;
     }

     if (conn != null) {
     try {
     conn.close();
     } catch (SQLException sqlex) {
     // ignore -- as we can't do anything about it here     
     }

     conn = null;
     }
     }

     return country;

     }*/
}