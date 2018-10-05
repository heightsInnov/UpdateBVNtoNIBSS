/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author baadedeji
 */
public class RedirectController extends HttpServlet{
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    HttpSession session = request.getSession(false);
    if (session == null)
    {
      session.invalidate();
      response.sendRedirect("request_details.jsp");
    }
    else if (request.getParameter("requestIdT") != null)
    {
      String reqId = request.getParameter("requestIdT");
      String bvn = request.getParameter("bvnT");
      String ofirstname = request.getParameter("firstnameT");
      String olastname = request.getParameter("oldlastnameT");
      String dateofbirth = request.getParameter("dobT");
      String reqdate = request.getParameter("reqdateT");
      String maker = request.getParameter("makerT");
      if (session == null)
      {
        RequestDispatcher rd = request.getRequestDispatcher("request_details.jsp");
        rd.forward(request, response);
      }   
          else
          {
            request.setAttribute("error", "error");
            RequestDispatcher localRequestDispatcher1 = request.getRequestDispatcher("request_details.jsp");
          }
        }
//        request.setAttribute("application_nos", application_nos);
//        request.setAttribute("customer_names", customer_names);
//        request.setAttribute("account_nos", account_nos);
//        request.setAttribute("asset_categorys", asset_categorys);
//        request.setAttribute("vendor_names", vendor_names);
//        request.setAttribute("aset_costs", aset_costs);
//        request.setAttribute("monthly_instalments", monthly_instalments);
//        request.setAttribute("due_dates", due_dates);
//        request.setAttribute("eligibilitys", eligibilitys);
//        request.setAttribute("rm_names", rm_names);
//        request.setAttribute("rm_codes", rm_codes);
//        request.setAttribute("success", "success");
        RequestDispatcher rd = request.getRequestDispatcher("auth_dataview.jsp");
        rd.forward(request, response);
      }

}
