<%@page import="com.unionbank.core.ProcessUpdateServNew"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.unionbank.webpay.db.dao.FileListDao"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" %>
<%@include file="tags.jsp"%>
<%	try {
		List<FileListDao> ListFileList = (List<FileListDao>) session.getAttribute("FileList");
		ProcessUpdateServNew d = new ProcessUpdateServNew();
		d.deleteFiles(ListFileList);
		session.invalidate();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("got here :::failed");
	}
	response.sendRedirect(request.getContextPath() + "/login.jsp");
%>