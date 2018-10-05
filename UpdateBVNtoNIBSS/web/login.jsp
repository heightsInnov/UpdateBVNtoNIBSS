
<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="shortcut icon" href="ico/favicon.png">

        <title>Login UBN PayPortal</title>
        <style>
            p::first-letter {
                font-size: 200%;
                color: #8A2BE2;
            }
        </style>
        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap-select.css" type="text/css"/>


    </head>
    <%@include file="tags.jsp"%>

    <body>
        <!-- Static navbar -->
        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="navbar-header">
                <a class="navbar-brand" href="home.html"><h1>BVN Portal</h1></a>
            </div>
            <div class="nav navbar-nav navbar-right">
                <li> <p class="navbar-text"><img alt="UBN" src="img/unionlogo.png" style="width:150px">&nbsp;&nbsp;&nbsp;&nbsp;</p></li> 
            </div>

        </div>

        <br>
        <%

            String isContainEst = (String) session.getAttribute("msg-info-signin");
            System.out.println("isContainEst first pick <<>.aa" + isContainEst);
            if (isContainEst == null) {
                isContainEst = "";
            }
            session.setAttribute("msg-info-signin", "");
            if (!isContainEst.equals("")) {
                System.out.println("in service:::yes greater than zero<<>>" + isContainEst);
        %>
        <div class="alert alert-danger text-center alert-dismissable sticky"><button class="close" aria-hidden="true" data-dismiss="alert" type="button">&times;</button><h4><%=isContainEst%></h4></div>
        <%                    } else {
                System.out.println("in service :::No lesser than zero<<>>" + isContainEst);
            }
        %>

        <!-- Main container-->
        <div class="container" style="max-width:400px">
            <div class="panel panel-default">
                <div class="panel-heading"><h3 style="margin-top:10px">Login  Details</h3></div>
                <div class="panel-body">
                    <form role="form" role="form"  action="processor.jsp" method="post">  

                        <input type="hidden" name="command" id="command" value="auth">
                        <input type="hidden" name="action" id="action" value="do">
                        <input type="hidden" name="nibss-id" id="nibss-id" value="thiss">
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="form-group">
                                    <label for="username">User Name</label>
                                    <input type="text" id="username"  name="username" class="form-control" placeholder="Enter Your User Name" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12">
                                <div class="form-group">
                                    <label for="loginPassword">Password</label>
                                    <input type="password"   name="loginPassword" id="loginPassword" class="form-control" placeholder="Password" required>
                                </div>
                            </div>
                        </div>

                        <button class="btn btn-lg btn-primary btn-block" style="margin-top: 10px;" type="submit">Submit</button>

                    </form>
                </div>
            </div>
        </div>
        <hr>
        <div align="center">
            <footer>
                <p>&copy;2015- All Rights Reserved -Union Bank of Nigeria Plc </p>
            </footer>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/holder.js"></script>
    </body>
</html>