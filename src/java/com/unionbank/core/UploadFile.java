/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

/**
 *
 * @author aajibade
 */
import static com.unionbank.core.SharePointUpload.client;
import com.unionbank.sharepoint.dao.Response;
import com.unionbank.webpay.parameters.Settings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@MultipartConfig()
public class UploadFile extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:/Files/";
	private Settings settings = Settings.getInstance("");
	String uploadDestination = settings.getProperty("SharepointURLFileUploadLink");
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

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

				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						long size = item.getSize();
						System.out.println("Size of file is >>" + size);
						if (size < THRESHOLD_SIZE) {
							System.out.println("got here 2");
							String name = new File(item.getName()).getName();
							String ext = FilenameUtils.getExtension(name);
							if (ext.contains("pdf") || ext.contains("docx") || ext.contains("doc") || ext.contains("jpg") || ext.contains("jpeg")) {
								System.out.println("file extension >>" + ext);
								System.out.println("Extension is  >>" + ext);
								String filePath = UPLOAD_DIRECTORY + File.separator + name;
								File storeFile = new File(filePath);
								item.write(storeFile);
								FileInputStream fis = null;
								String fileLink = "";
								String url = "";
								String respCode;
								List<String> resp = new ArrayList<>();
								
								try {
									fis = new FileInputStream(storeFile);
									Response respons = client.upload(uploadDestination, fis, storeFile.getName());
									if (!respons.isHasError()) {
										fileLink = respons.getResponseMessage();
										System.out.println("====The File Link first is=====" + fileLink.substring(1, fileLink.length() - 1));
										url = fileLink.substring(1, fileLink.length() - 1);
										respCode = respons.getResponseCode();

										resp.add(respCode);
										resp.add(url);
									} else {
										respCode = respons.getResponseCode();
										resp.add(respCode);
										resp.add("Error uploading file, try again later!");
									}

									System.out.println("====The Link saved is=====" + fileLink.substring(1, fileLink.length() - 1));
									System.out.println("====The Code Link saved from List is=====" + resp.get(0));
									System.out.println("====The File Link saved from List is=====" + resp.get(1));

									//String resp = fileLink.substring(1, fileLink.length() - 1);
									//System.out.println("Link is this >> " + resp);
								} catch (Exception ex) {
									System.out.println("There was an error!!: " + ex.getMessage());
									ex.printStackTrace();
									request.setAttribute("message", "There was an error: " + ex.getMessage());
									System.out.println("There was an error: ");
								}
								//Delete file from local directory
								if (storeFile.isFile()) {
									storeFile.delete();
								}
							} else {
								System.out.println("Error! Upload file in correct format");
								request.setAttribute("message", "Error! Upload file in correct format");
								response.sendRedirect("testUpload.jsp");
							}
						}
					}
				}
				response.sendRedirect("testUpload.jsp");
				request.setAttribute("message", "Successfully Saved!");
			} catch (Exception e) {
				System.out.println("File upload failed");
			}
		}
	}
}
