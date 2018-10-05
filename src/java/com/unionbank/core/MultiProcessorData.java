/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import static com.unionbank.core.ProcessUpdateServlet.checkNull;
import com.unionbank.webpay.db.dao.BVNformData;
import com.unionbank.webpay.parameters.Settings;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author aojinadu
 */
public class MultiProcessorData extends HttpServlet {

	private static final long serialVersionUID = 1L;
	UpdateBVNNow upd = new UpdateBVNNow();
	BVNformData data = new BVNformData();
	Boolean resp = false;
	java.util.Date nDate = null;
	java.util.Date fDate = null;
	Date MODDate = null;
	Date NIBSSDate = null;

	public static String checkNull(String value) {
		String retVal = "";
		if (!value.contains("NULL")) {
			retVal = (!value.isEmpty() || value != null ? value : "");
		}
		return retVal;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			/* TODO output your page here. You may use following sample code. */
			HttpSession session = request.getSession();

			String transactionid = request.getParameter("transactionid");
			transactionid = transactionid != null ? transactionid : "";

			String bvnumber = request.getParameter("bvnumber");
			bvnumber = bvnumber != null ? bvnumber : "";

			String maker = request.getParameter("branchcode");
			String Branch = request.getParameter("branchcode");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

			try {

				data.setMainTxID(checkNull(request.getParameter("transactionid")));
				data.setDisplayname(checkNull(request.getParameter("markerid")));
				data.setBranch(checkNull(request.getParameter("branchcode")));
				data.setOldBvNumber(checkNull(request.getParameter("bvnumber")));

				data.setOldFirstName(checkNull(request.getParameter("Hofirstname")));
				data.setfFirstName(checkNull(request.getParameter("Hffirstname")));
				data.setNewFirstName(checkNull(request.getParameter("nfirstnameTxt")));
				data.setFirstNameComment(checkNull(request.getParameter("fnamecommentTxt")));

				data.setOldMiddleName(checkNull(request.getParameter("Homiddlename")));
				data.setfMiddleName(checkNull(request.getParameter("Hfmiddlename")));
				data.setNewMiddleName(checkNull(request.getParameter("nmiddlenameTxt")));
				data.setMiddleComment(checkNull(request.getParameter("mnamecommentTxt")));

				data.setOldLastName(checkNull(request.getParameter("Holastname")));
				data.setfLastName(checkNull(request.getParameter("Hflastname")));
				data.setNewLastName(checkNull(request.getParameter("nlastnameTxt")));
				data.setLastComment(checkNull(request.getParameter("lnamecommentTxt")));

				String ffDate = request.getParameter("Hodob");
				String nnDate = request.getParameter("ndateofbirthTxt");

				if (!ffDate.isEmpty()) {
					fDate = sdf.parse(checkNull(ffDate));
					NIBSSDate = Date.valueOf(sdf2.format(fDate));
					data.setOldDateConverted(NIBSSDate);
				}
				if (!nnDate.isEmpty()) {
					nDate = sdf2.parse(checkNull(nnDate));
					MODDate = Date.valueOf(sdf2.format(nDate));
					data.setNewDateConverted(MODDate);
				}
				System.out.println("Converted >>" + NIBSSDate + ", " + MODDate);

				data.setOldDOBName(checkNull(ffDate));
				data.setfDob(checkNull(request.getParameter("Hfdob")));
				data.setNewDOBName(checkNull(nnDate));
				data.setDOBComment(checkNull(request.getParameter("dobcommentTxt")));

				data.setOldMaritalStatus(checkNull(request.getParameter("HomStatus")));
				data.setfMaritalstat(checkNull(request.getParameter("HfmStatus")));

				String Mstats = request.getParameter("newMaritalStatusTxt");
				if (!Mstats.equals("-1")) {
					data.setNewMaritalStatus(checkNull(request.getParameter("newMaritalStatusTxt")));
					data.setMaritalStatusComment(checkNull(request.getParameter("mscommentTxt")));
				} else {
					data.setNewMaritalStatus("");
					data.setMaritalStatusComment("");
				}

				data.setOldGender(checkNull(request.getParameter("Hogender")));
				data.setfGender(checkNull(request.getParameter("Hfgender")));

				String gend = request.getParameter("newGenderTxt");
				if (!gend.equals("-1")) {
					data.setNewGender(checkNull(request.getParameter("newGenderTxt")));
					data.setCommentGender(checkNull(request.getParameter("gencommentTxt")));
				} else {
					data.setNewGender("");
					data.setCommentGender("");
				}

				data.setOldStateOfOrigin(checkNull(request.getParameter("HoSOO")));
				data.setfStateOrigin(checkNull(request.getParameter("HfSOO")));
				data.setNewStateOfOrigin(checkNull(request.getParameter("newStateOfOriginTxt")));
				data.setStateOfOriginComment(checkNull(request.getParameter("sogcommentTxt")));

				data.setOldResidentialStatus(checkNull(request.getParameter("HoRStatus")));
				data.setfResidentialadd(checkNull(request.getParameter("HfRStatus")));
				data.setNewResidentialStatus(checkNull(request.getParameter("nrsTxt")));
				data.setResidentialStatusComment(checkNull(request.getParameter("nrscommentTxt")));

				data.setOldLGA(checkNull(request.getParameter("HoLGA")));
				data.setfLga(checkNull(request.getParameter("HfLGA")));
				data.setNewLGA(checkNull(request.getParameter("nlgaTxt")));
				data.setLgaComment(checkNull(request.getParameter("nlgacommentTxt")));

				data.setOldPhoneNumber(checkNull(request.getParameter("HoPhone")));
				data.setfPhoneNumber(checkNull(request.getParameter("HfPhone")));
				data.setNewPhoneNumber(checkNull(request.getParameter("nphoneTxt")));
				data.setPhoneNOComment(checkNull(request.getParameter("nphonecommentTxt")));

				data.setOldEmailAdd(checkNull(request.getParameter("HoEmail")));
				data.setfEmail(checkNull(request.getParameter("HfEmail")));
				data.setNewEmailAdd(checkNull(request.getParameter("nemailTxt")));
				data.setEmailComment(checkNull(request.getParameter("nemailcommentTxt")));

				data.setTitle(checkNull(request.getParameter("HoTitle")));
				data.setNewTitle(checkNull(request.getParameter("ntitleTxt")));
				data.setCommentTitle(checkNull(request.getParameter("ntitilecommentTxt")));

				data.setBankOfEnrollment(checkNull(request.getParameter("HEnrollBank")));
				data.setBranchOfEnrollment(checkNull(request.getParameter("HEnrollBranch")));

				data.setUserEmail(checkNull(request.getParameter("branchcode")));

				session.setAttribute("formData", data);

				RequestDispatcher rd = request.getRequestDispatcher("br_dataview.jsp");
				rd.include(request, response);

				System.out.println("One of this data is >>" + data.getOldMiddleName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
