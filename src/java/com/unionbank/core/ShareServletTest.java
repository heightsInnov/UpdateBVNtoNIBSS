/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author aojinadu
 */
@MultipartConfig
public class ShareServletTest extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			String pathed = request.getParameter("pathed");
			Part filePart = request.getPart("myFile");
			String contentDisposition = filePart.getHeader("Content-Disposition");
			String fName = (contentDisposition.substring(36, contentDisposition.length() - 1));
			System.out.println("fName value >>>>>>> " + fName);
			
			Part filePart1 = request.getPart("myFile1");
			String contentDisposition1 = filePart1.getHeader("Content-Disposition");
			String fName1 = (contentDisposition1.substring(36, contentDisposition.length() - 1));
			System.out.println("fName value >>>>>>> " + fName1);
			
			SendToSharePoint sh = new SendToSharePoint();
			
			List<String> resp = sh.SharePointSend(pathed, fName, filePart);
			System.out.println("Code >>"+ resp.get(0).toString());
			System.out.println("Code >>"+ resp.get(1).toString());
			
			List<String> resp1 = sh.SharePointSend(pathed, fName1, filePart1);
			System.out.println("Code >>"+ resp1.get(0).toString());
			System.out.println("Code >>"+ resp1.get(1).toString());
			
			response.sendRedirect("testUpload.jsp");
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
