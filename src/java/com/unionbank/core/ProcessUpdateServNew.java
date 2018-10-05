/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import static com.unionbank.core.SharePointUpload.client;
import com.unionbank.sharepoint.dao.Response;
import com.unionbank.webpay.db.dao.FileListDao;
import com.unionbank.webpay.db.dao.UploadDao;
import com.unionbank.webpay.parameters.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author aojinadu
 */
public class ProcessUpdateServNew extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:/Files/";
	private Settings settings = Settings.getInstance("");
	String uploadDestination = settings.getProperty("SharepointURLFileUploadLink");
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 30; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			File directory = new File(UPLOAD_DIRECTORY);
			if (!directory.exists()) {
				directory.mkdir();
			}
			/* TODO output your page here. You may use following sample code. */
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			HttpSession session = request.getSession();

			List<FileListDao> ListFileList = (List<FileListDao>) session.getAttribute("FileList");
			if (ListFileList == null) {
				ListFileList = new ArrayList<FileListDao>();
			}
			int countList = ListFileList.size();
			if (countList == 3) {
				session.setAttribute("FileList", ListFileList);
				request.setAttribute("message", "Info! 3 files uploaded, kindly continue to form submission.");
				RequestDispatcher rd = request.getRequestDispatcher("br_dataview.jsp");
				rd.include(request, response);
			} else {
				// process only if its multipart content
				if (isMultipart) {
					System.out.println("got here 1");
					// Create a factory for disk-based file items
					FileItemFactory factory = new DiskFileItemFactory();

					// Create a new file upload handler
					ServletFileUpload upload = new ServletFileUpload(factory);
					upload.setFileSizeMax(MAX_FILE_SIZE);
					upload.setSizeMax(MAX_REQUEST_SIZE);
					try {
						// Parse the request
						List<FileItem> multiparts = upload.parseRequest(request);
						int count = 0;
						for (FileItem item : multiparts) {
							if (!item.isFormField()) {
								count++;
								long size = item.getSize();
								System.out.println("Size of file is >>" + size);
								if (size < THRESHOLD_SIZE) {
									System.out.println("got here 2");
									String name = new File(item.getName()).getName();
									String ext = FilenameUtils.getExtension(name);
									if (ext.contains("pdf") || ext.contains("docx") || ext.contains("doc") || ext.contains("jpg") || ext.contains("jpeg") || ext.contains("msg")) {
										System.out.println("Extension is  >>" + ext);
										String filePath = UPLOAD_DIRECTORY + File.separator + name;
										File storeFile = new File(filePath);
										item.write(storeFile);
										FileListDao FileList = new FileListDao();

										FileList.setFilename(filePath);
										FileList.setFile(storeFile);

										ListFileList.add(FileList);
										countList = ListFileList.size();
										System.out.println("List Contains >> " + countList + " files");
									} else {
										deleteFiles(ListFileList);
										session.setAttribute("FileList", null);
										System.out.println("Error! Incorrect file format");
										request.setAttribute("message", "Error! Invalid file format, only pdf, image, doc/docx allowed");
										RequestDispatcher rd = request.getRequestDispatcher("br_dataview.jsp");
										rd.include(request, response);
									}
								} else {
									deleteFiles(ListFileList);
									session.setAttribute("FileList", null);
									System.out.println("Error! File too large");
									request.setAttribute("message", "Error! File too large, max 3MB each allowed.");
									RequestDispatcher rd = request.getRequestDispatcher("br_dataview.jsp");
									rd.include(request, response);
								}
							}
						}
						if (countList > 0 && countList < 4) {
							session.setAttribute("FileList", ListFileList);
							request.setAttribute("message", "Success! File successfully saved, continue to form submission");
							RequestDispatcher rd = request.getRequestDispatcher("br_dataview.jsp");
							rd.include(request, response);
						} else {
							deleteFiles(ListFileList);
							session.setAttribute("FileList", null);
							request.setAttribute("message", "Error! Limit exceeded, maximum of 3 files allowed");
							RequestDispatcher rd = request.getRequestDispatcher("br_dataview.jsp");
							rd.include(request, response);
						}
					} catch (Exception e) {
						request.setAttribute("message", "Technical Error! Contact Admin for help.");
						RequestDispatcher rd = request.getRequestDispatcher("bvn_verification.jsp");
						rd.include(request, response);
					}
				}
			}
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

	public void deleteFiles(List<FileListDao> ListFileList) {
		if (ListFileList == null) {
		} else {
			if (!ListFileList.isEmpty()) {
				for (FileListDao f : ListFileList) {
					if (f.getFile().isFile()) {
						f.getFile().delete();
					}
				}
			}
		}
	}

	public String SavetoShare(File storeFile) {
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
			} else {
				respCode = respons.getResponseCode();
			}
			System.out.println("====The Link saved is=====" + url);

		} catch (Exception ex) {
			System.out.println("There was an error!!: " + ex.getMessage());
		}
		return url;
	}
}
