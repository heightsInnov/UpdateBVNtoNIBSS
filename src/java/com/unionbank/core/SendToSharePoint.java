/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.unionbank.sharepoint.dao.Response;
import com.unionbank.sharepoint.documents.UploadClient;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author aojinadu
 */
public class SendToSharePoint {

	public static List<String> SharePointSend(String uploadDestination, String fName, Part filePart) {
		String fileName = fName;
		System.out.println("File part NAME is>>>>> " + fileName);
		InputStream inputStream = null;
		String fileLink;
		String respCode;
		String url;
		List<String> resp = new ArrayList<String>();

		try {
			inputStream = filePart.getInputStream();
			Response response = UploadClient.upload(uploadDestination, inputStream, fileName);
			if (!response.isHasError()) {
				fileLink = response.getResponseMessage();
				System.out.println("====The File Link saved into the DB is=====" + fileLink.substring(1, fileLink.length() - 1));
				url = fileLink.substring(1, fileLink.length() - 1);
				respCode = response.getResponseCode();
				
				resp.add(respCode);
				resp.add(url);
			}else{
				respCode = response.getResponseCode();
				resp.add(respCode);
				resp.add("Error uploading file, try again later!");
			}

		} catch (Exception ex) {
			System.out.println("There was an error!!: " + ex.getMessage());
			ex.printStackTrace();
			//request.setAttribute("message", "There was an error: " + ex.getMessage());
			System.out.println("There was an error: ");
		} finally {
			try {
				if (inputStream == null) {
					inputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return resp;
	}
}
