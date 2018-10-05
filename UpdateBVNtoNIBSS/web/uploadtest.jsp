<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="error.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Ajax File Upload with Progress Bar</title>
        <!-- Include jQuery form & jQuery script file. -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.js" ></script>
        <script src="http://malsup.github.com/jquery.form.js" ></script>
        <script src="js/fileUploadScript.js" ></script>
        <!-- Include css styles here -->
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h3>Ajax File Upload with Progress Bar</h3>
        <form id="UploadForm" action="UploadFile" method="post" enctype="multipart/form-data">
            <input type="file" size="30" id="myfile" name="myfile"> 
             <input type="file" multiple="multiple" class="dz-hidden-input" style="visibility: hidden; position: absolute; top: 0px; left: 0px; height: 0px; width: 0px;">
            <input type="submit" value="Upload">
            <div id="progressbox">
                <div id="progressbar"></div>
                <div id="percent">0%</div>
            </div>
            <br />
            <div id="message"></div>
        </form>
           <%@ include file="foot.jsp"%>
    </body>
</html>