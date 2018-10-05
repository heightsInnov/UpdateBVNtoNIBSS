/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import static com.unionbank.core.SharePointUpload.client;
import com.unionbank.sharepoint.dao.Response;
import com.unionbank.webpay.db.dao.BVNformData;
import com.unionbank.webpay.db.dao.FileListDao;
import com.unionbank.webpay.db.dao.UploadDao;
import com.unionbank.webpay.parameters.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aojinadu
 */
@WebServlet("/ProcessUpdateServlet")
@MultipartConfig(maxFileSize = 3145728)
public class ProcessUpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Settings settings = Settings.getInstance("");
	UpdateBVNNow upd = new UpdateBVNNow();
	BVNformData data = new BVNformData();
	Boolean resp = false;
	String uploadDestination = settings.getProperty("SharepointURLFileUploadLink");
	java.util.Date nDate = null;
	java.util.Date fDate = null;
	Date MODDate = null;
	Date NIBSSDate = null;
	private final String UPLOAD_DIRECTORY = "C:/Files/";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

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

		HttpSession session = request.getSession();

		List<FileListDao> ListstoreFile = (List<FileListDao>) session.getAttribute("FileList");

		String transactionid = request.getParameter("transactionid");
		transactionid = transactionid != null ? transactionid : "";

		String bvnumber = request.getParameter("bvnumber");
		bvnumber = bvnumber != null ? bvnumber : "";

		//For SharePoint Upload File
		String totalUpload = "1";
		totalUpload = request.getParameter("uploadCount");
		if (totalUpload != "" && !totalUpload.isEmpty()) {
			totalUpload = totalUpload;
		} else {
			totalUpload = "1";
		}
		int tup = Integer.valueOf(totalUpload);

		System.out.println("upload numbers is >>" + tup);

		//For inserting into table
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

			//Start Upload and Insert if upload is successful.
			List<UploadDao> picspathList = new ArrayList<UploadDao>();
//			List<FileListDao> ListstoreFile = (List<FileListDao>) session.getAttribute("FileList");
			int count = 0;
			if (!ListstoreFile.isEmpty()) {
				for (FileListDao f : ListstoreFile) {
					UploadDao picspath = SavetoShare(f.getFile());
					picspathList.add(picspath);
					count++;
				}
				System.out.println("Count of files >>" + count);
			} else {
				System.out.println("Empty List from session!!!");
			}
			System.out.println("number in picsPathList >>" + picspathList.size());
			System.out.println("number in ListstoreFile >>" + ListstoreFile.size());
			String counts = String.valueOf(count);
			switch (counts) {
				case "1":
					String url = checkNull(picspathList.get(0).getUrl());
					String code = checkNull(picspathList.get(0).getCode());
					if (!code.contains("500")) {
						data.setPicsPath1(url);
						resp = upd.processBVNUpdateRequest(data, bvnumber, transactionid, maker, Branch);
					} else {
						for (FileListDao f : ListstoreFile) {
							if (f.getFile().isFile()) {
								f.getFile().delete();
							}
						}
					}
					break;
				case "2":
					String url1 = checkNull(picspathList.get(0).getUrl());
					String code1 = checkNull(picspathList.get(0).getCode());
					String url2 = checkNull(picspathList.get(1).getUrl());
					String code2 = checkNull(picspathList.get(1).getCode());
					if (!code1.contains("500") || !code2.contains("500")) {
						data.setPicsPath1(url1);
						data.setPicsPath1(url2);
						resp = upd.processBVNUpdateRequest(data, bvnumber, transactionid, maker, Branch);
					} else {
						for (FileListDao f : ListstoreFile) {
							if (f.getFile().isFile()) {
								f.getFile().delete();
							}
						}
					}
					break;
				case "3":
					String url11 = checkNull(picspathList.get(0).getUrl());
					String code11 = checkNull(picspathList.get(0).getCode());
					String url12 = checkNull(picspathList.get(1).getUrl());
					String code12 = checkNull(picspathList.get(1).getCode());
					String url13 = checkNull(picspathList.get(2).getUrl());
					String code13 = checkNull(picspathList.get(2).getCode());
					if (!code11.contains("500") || !code12.contains("500") || !code13.contains("500")) {
						data.setPicsPath1(url11);
						data.setPicsPath2(url12);
						data.setPicsPath3(url13);
						resp = upd.processBVNUpdateRequest(data, bvnumber, transactionid, maker, Branch);
					} else {
						for (FileListDao f : ListstoreFile) {
							if (f.getFile().isFile()) {
								f.getFile().delete();
							}
						}
					}
					break;
				default:
					data.setPicsPath1("");
					data.setPicsPath2("");
					data.setPicsPath3("");
					resp = false;
					break;
			}

			System.out.println("isther <<>>>" + resp);
			if (resp) {//pendinglist
				System.out.println("isther <<>>>2" + resp);
				request.setAttribute("message", "Successfully Saved!");
				response.sendRedirect("pendinglist.jsp");
			} else {
				System.out.println("isther <<>>>2ddddd" + resp);
				session.setAttribute("msg-info-signin", "Invalid BVN");
				request.setAttribute("message", "Transaction was not Saved .Please contact Admin");
				response.sendRedirect("bvn_verification.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("isther <<>>>2eeesd" + resp);
			request.setAttribute("message", "Transaction was not Saved! Proceed by uploading documents before form submission!");
			RequestDispatcher rd = request.getRequestDispatcher("bvn_verification.jsp");
			rd.include(request, response);
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

	public UploadDao SavetoShare(File storeFile) {
		UploadDao resp = new UploadDao();
		String url = "";
		FileInputStream fis = null;
		String fileLink = "";
		String respCode;
		try {
			fis = new FileInputStream(storeFile);
			Response respons = client.upload(uploadDestination, fis, storeFile.getName());
			if (!respons.isHasError()) {
				fileLink = respons.getResponseMessage();
				System.out.println("====The File Link first is=====" + fileLink.substring(1, fileLink.length() - 1));
				url = fileLink.substring(1, fileLink.length() - 1);
				respCode = respons.getResponseCode();

				resp.setCode(respCode);
				resp.setUrl(url);
			} else {
				respCode = respons.getResponseCode();
				resp.setCode(respCode);
				resp.setUrl("Error uploading file, try again later!");
			}
			System.out.println("====The Link saved is=====" + url);

		} catch (Exception ex) {
			System.out.println("There was an error!!: " + ex.getMessage());
			ex.printStackTrace();
//			request.setAttribute("message", "There was an error: " + ex.getMessage());
			System.out.println("There was an error: ");
		}
		return resp;
	}
}
