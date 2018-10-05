<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" %>
<%@include file="tags.jsp"%>
<%@page import="com.unionbank.core.Processor"%>
<%@page import="org.datacontract.schemas._2004._07.ubn_security.UserProfile"%>
<%


    UserProfile ursP = (UserProfile) session.getAttribute("Urs");
    String username = "", Dept = "";
    try {
        username = ursP.getEmail().getValue();
       // Dept = ursP.getDepartment().getValue();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    try {
        Processor pb = new Processor();
        session.invalidate();
        pb.logAuditTrail("2", ursP,"");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("got here :::failed");
    }
    response.sendRedirect(request.getContextPath() + "/login.jsp");

%>