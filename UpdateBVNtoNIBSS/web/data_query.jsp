<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="error.jsp"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.xml.bind.JAXBElement"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp"%>
        <script>
            function goBack() {
                window.history.back()
            }
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrap">
            <div class="modal fade" id="pitchDialog" tabindex="-1" role="dialog" aria-labelledby="myModalTitle" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalTitle"></h4>
                        </div>
                        <div class="modal-body">
                            <!--div align="center"><img src="img/loading.gif" alt="Loading..."> &nbsp;&nbsp;&nbsp;<strong>Loading supporting document list. Please wait...</strong>		</div-->
                            <div id="pitchDialogBody" class="table-responsive">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="nibss-full">
                <%@ include file="navbar.jsp"%>
                <br>

                <%

                    String isContainEst = (String) session.getAttribute("msg-info-signin");
                    System.out.println("isContainEst first pick <<>." + isContainEst);
                    if (isContainEst == null) {
                        isContainEst = "";
                    }
                    session.setAttribute("msg-info-signin", "");
                    if (!isContainEst.equals("")) {
                        System.out.println("in serverive :::yes greater tthan zero<<>>" + isContainEst);
                %>
                <div class="alert alert-danger text-center alert-dismissable sticky"><button class="close" aria-hidden="true" data-dismiss="alert" type="button">&times;</button><h4><%=isContainEst%></h4></div>
                <%                    } else {
                        System.out.println("in serverive :::No lesser tthan zero<<>>" + isContainEst);
                    }
                %>
                <div class="container">
                    <div class="panel panel-default control-panel"  >
                        <div class="panel panel-default control-panel" >
                            <div class="panel-heading" style="margin-bottom:0px;">
                                <div class="row">
                                    <%@ include file="operator_navBar.jsp"%>
                                    <br>

                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">BVN Customer Update</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="panel-body" style="background-color:#FBFBFB;" >
                            <form   action="processor.jsp" method="post">  
                                <input type="hidden" name="command" value="checkedfields">
                                <input type="hidden" name="ccemail" value="">
                                <h4><span class="label label-default">KINDLY CHECK ALL FIELDS YOU INTEND TO UPDATE</span></h4>
                                <hr>                                  

                                <div class="row">                            
                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="text" class="form-control" id="firstName"   maxlength="50" name="firstName"   value="Email"   disabled>
                                            <input type="checkbox" name="cemail" id="cemail" value="1" />
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">
                                            <label for="firstname">First Name</label>
                                            <input type="text" class="form-control" id="firstname"  maxlength="50" name="firstname"   value="firstname"   disabled>
                                            <input type="checkbox" name="ccfirstname" id="ccfirstname" value="" />
                                        </div>                                
                                    </div>   

                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">
                                            <label for="gender">Gender</label>
                                            <input type="text" class="form-control" id="gender"  maxlength="30" name="gender"  value="Gender"   disabled>
                                            <input type="checkbox" name="cgender" id="cgender" value="" />
                                        </div>                                
                                    </div>   

                                </div>  


                                <div class="row">                            

                                    <div class="col-md-4 col-sm-4 col-xm-12" style="padding-top:20px">

                                        <button type="submit" class="btn btn-primary">SUBMIT</button>
                                    </div> 

                                </div> 


                        </div>  
                        <br>  


<script>
document.getElementById("ccemail").value ="Atyodeji";
</script>



                    </div>
                </div>
            </div>


        </div>
       
      
    </body>
</html>
