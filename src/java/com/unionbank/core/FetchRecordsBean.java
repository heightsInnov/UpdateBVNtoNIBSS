/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.core;

import com.unionbank.webpay.db.dao.TransactionsDAO;
import com.unionbank.webpay.parameters.Settings;
import com.unionbank.webpay.utils.PBEncrytor;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author baadedeji
 */
public class FetchRecordsBean {

	PBEncrytor Pb = new PBEncrytor();
	private Settings settings = Settings.getInstance("");
	String dbUser = settings.getProperty("user-user");
	String dbPassword = Pb.PBDecrypt(settings.getProperty("password-password"));
	String dbURL = settings.getProperty("host-host");

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (session == null) {
			session.invalidate();
			response.sendRedirect("login.jsp");
		} else {

			request.setAttribute("error", "error");
			RequestDispatcher rd = request.getRequestDispatcher("reviewResolveComplaints.jsp");
		}
	}

	public List<TransactionsDAO> getRecordsByRequestID(BigDecimal reqID) {
		List<TransactionsDAO> tTransactionsList = new ArrayList<TransactionsDAO>();
		TransactionsDAO mert = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			String query = "select * from customer_update_req "
					+ "WHERE REQUEST_ID = '" + reqID + "' "
					+ " AND APPROVALSTATUS ='N' "
					+ "ORDER BY RECEIVED_DATE DESC";

			System.out.println("The query<<>>> " + query);

			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			if (pstmt.executeUpdate() != Statement.EXECUTE_FAILED) {
				System.out.println("getRecordsByRequestID successful!");
				rs = pstmt.getResultSet();
			} else {
				throw new Exception("Empty Prepared Statement");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		int count = 0;
		try {
			while (rs.next()) {
				mert = new TransactionsDAO();
				
				mert.setRequestID(rs.getString("REQUEST_ID"));
				
				mert.setTitle(rs.getString("TITLE"));
				mert.setNewTitle(rs.getString("NEWTITLE"));
				mert.setCommentTitle(rs.getString("COMMENTTITLE"));
				
				mert.setOldFirstName(rs.getString("OLDFIRSTNAME"));
				mert.setfFirstName(rs.getString("FFIRSTNAME"));
				mert.setNewFirstName(rs.getString("NEWFIRSTNAME"));
				mert.setFirstNameComment(rs.getString("FIRSTNAMECOMMENT"));
				
				mert.setOldMiddleName(rs.getString("OLDMIDDLENAME"));
				mert.setfMiddleName(rs.getString("FMIDDLENAME"));
				mert.setNewMiddleName(rs.getString("NEWMIDDLENAME"));
				mert.setMiddleNameComment(rs.getString("MIDDLECOMMENT"));
				
				mert.setOldLastName(rs.getString("OLDLASTNAME"));
				mert.setfLastName(rs.getString("FLASTNAME"));
				mert.setNewLastName(rs.getString("NEWLASTNAME"));
				mert.setLastNameComment(rs.getString("LASTNAMECOMMENT"));
				
				mert.setOldDateOfBirth(rs.getString("OLDDATEOFBIRTH"));
				mert.setfDoB(rs.getString("FDOB"));
				mert.setNewDateOfBirth(rs.getString("NEWDATEOFBIRTH"));
				mert.setDobComment(rs.getString("DOBCOMMENT"));
				
				mert.setOldMaritalStatus(rs.getString("OLDMARITALSTATUS"));
				mert.setfMaritalStatus(rs.getString("FMARITALSTATUS"));
				mert.setNewMaritalStatus(rs.getString("NEWMARITALSTATUS"));
				mert.setMaritalStatusComment(rs.getString("MARITALSTATUSCOMMENT"));
				System.out.println("NAmes and aname >>"+ mert.getOldMaritalStatus());
				
				
				mert.setOldGender(rs.getString("OLDGENDER"));
				mert.setfGender(rs.getString("FGENDER"));
				mert.setNewGender(rs.getString("NEWGENDER"));
				mert.setCommentGender(rs.getString("COMMENTGENDER"));
				
				mert.setOldStateOfOrigin(rs.getString("OLDSTATEOFORIGIN"));
				mert.setfStateOfOrigin(rs.getString("FSTATEOFORIGIN"));
				mert.setNewStateOfOrigin(rs.getString("NEWSTATEOFORIGIN"));
				mert.setStateOfOriginComment(rs.getString("STATEOFORIGINCOMMENT"));
				
				mert.setOldResidentialStatus(rs.getString("OLDRESIDENTIALSTATUS"));
				mert.setfResidentAddress(rs.getString("FRESIDENTIALADD"));
				mert.setNewResidentialStatus(rs.getString("NEWRESIDENTIALSTATUS"));
				mert.setResidentialStatusComment(rs.getString("RESIDENTIALSTATUSCOMMENT"));
				
				mert.setOldLGA(rs.getString("OLDLGA"));
				mert.setfLga(rs.getString("FLGA"));
				mert.setNewLGA(rs.getString("NEWLGA"));
				mert.setLgaComment(rs.getString("LGACOMMENT"));
				
				mert.setOldPhoneNumber(rs.getString("OLDPHONENUMBER"));
				mert.setfMobileNumber(rs.getString("FPHONENUMBER"));
				mert.setNewPhoneNumber(rs.getString("NEWPHONENUMBER"));
				mert.setPhoneNoComment(rs.getString("PHONENOCOMMENT"));
				
				mert.setOldEmailAdd(rs.getString("OLDEMAILADD"));
				mert.setfEmailAdd(rs.getString("FEMAIL"));
				mert.setNewEmailAdd(rs.getString("NEWEMAILADD"));
				mert.setEmailComment(rs.getString("EMAILCOMMENT"));
				
				mert.setBvNumber(rs.getString("BVNUMBER"));
				
				mert.setRecieveDate(rs.getString("RECEIVED_DATE"));
				mert.setApprovalStatus(rs.getString("APPROVALSTATUS"));
				mert.setApprovedate(rs.getString("APPROVE_REJECT_DATE"));
				
				mert.setMaker(rs.getString("MARKER"));
				mert.setChecker(rs.getString("CHECKER"));
				mert.setRejectComment(rs.getString("TCOMMENT"));
				
				mert.setFileAddress(rs.getString("UPLOADPATH1"));
				mert.setFileAddress2(rs.getString("UPLOADPATH2"));
				mert.setFileAddress3(rs.getString("UPLOADPATH3"));
				
				
				tTransactionsList.add(mert);
				count++;
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return tTransactionsList;
	}

	public Connection getConnection() {
		Connection connection = null;
		System.out.println("----- Oracle JDBC Connection Testing ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}
		System.out.println("Oracle JDBC Driver Registered!");
		try {
			// conn = DriverManager.getConnection("jdbc:oracle:thin:@172.16.11.45:1521:fcrnov21", "fcrlive", "fcrlive");
			connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
			System.out.println("dburl is>>>>" + dbURL);
			System.out.println("dbUsername is>>>>" + dbUser);

		} catch (Exception e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		if (connection != null) {
			System.out.println("You made it!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}
	
	public static void main(String[] args) {
		List<TransactionsDAO> resp = new ArrayList<TransactionsDAO>();
		BigDecimal bd = BigDecimal.valueOf(521);
		FetchRecordsBean f = new FetchRecordsBean();
		resp = f.getRecordsByRequestID(bd);
		for(TransactionsDAO e : resp){
			System.out.println("NAmes and aname >>"+ e.getfFirstName());
		}
	}
}