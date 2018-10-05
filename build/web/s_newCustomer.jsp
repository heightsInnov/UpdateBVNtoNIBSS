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
                            <form   action="process_send.jsp" method="post">  
                                <input type="hidden" name="command" value="sendvalidatn">
                                <h4><span class="label label-default">Customer information</span></h4>
                                <hr>                                  

                                <div class="row">                            
                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <div class="form-group">
                                            <label for="firstName">Old Email</label>
                                            <input type="text" class="form-control" id="firstName"   maxlength="20" name="firstName"  placeholder="Enter user's first name" required autofocus>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">
                                            <label for="lastName">New Email</label>
                                            <input type="text" class="form-control" id="lastName"  maxlength="30" name="lastName"   placeholder="Enter user's last name" required>
                                        </div>                                
                                    </div>   
                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">                                            

                                            <label for="otherName">Reason For Change</label>

                                            <textarea  class="form-control"   placeholder="Optional"  name="otherName" cols="40" rows="5" ></textarea>
                                        </div>
                                    </div>                             
                                </div>  
                                <div class="row">


                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <div class="form-group">
                                            <label for="OldFirstName">Old First Name</label>
                                            <input type="text" class="form-control" id="firstName"   maxlength="50" name="OldFirstName"  placeholder="Enter user's first name" required autofocus>
                                            <input type="checkbox" name="checkbox1" id="checkbox1" value="<?php echo $answer_id;?>" />
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">
                                            <label for="NewFirstName">New First Name</label>
                                            <input type="text" class="form-control" id="NewFirstName"  maxlength="50" name="NewFirstName"   placeholder="Enter New First Name" required>
                                             <input type="checkbox" name="checkbox1" id="checkbox1" value="<?php echo $answer_id;?>" />
                                        </div>                                
                                    </div>   
                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">                                            

                                            <label for="otherName">Reason For Change</label>

                                            <textarea  class="form-control"   placeholder="Optional"  name="otherName" cols="40" rows="5" ></textarea>
                                        </div>
                                    </div>                             
                                </div>  

                                <div class="row">


                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <div class="form-group">
                                            <label for="OldGender">Old Gender</label>
                                            <input type="text" class="form-control" id="OldGender"   maxlength="30" name="OldGender"  placeholder="Enter " required autofocus>
                                        </div>
                                    </div>
                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">
                                            <label for="NewGender">New Gender</label>
                                            <select class="form-control"  name="NewGender" id="NewGender" required>
                                                <option value=""> </option>
                                                <option value="MALE">MALE</option>
                                                <option value="FEMALE">FEMALE</option>                                                
                                            </select>
                                        </div>
                                    </div>       
                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">                                            

                                            <label for="otherName">Reason For Change</label>

                                            <textarea  class="form-control"   placeholder="Optional"  name="otherName" cols="40" rows="5" ></textarea>
                                        </div>
                                    </div>                             
                                </div>  
                                
                                
                                <div class="row">                            

                            <div class="col-md-4 col-sm-4 col-xm-12" style="padding-top:20px">

                                <button type="submit" class="btn btn-primary">NEXT</button>
                            </div> 

                        </div> 


                        </div>  
                        <br>  



                        


                    </div>
                </div>
            </div>


        </div>

        <%@ include file="foot.jsp"%>
    </body>
</html>
