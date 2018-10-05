<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp"%>

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
                    String isContainEst =(String)request.getAttribute("message");
                    
                  //  String isContainEst = (String) session.getAttribute("msg-info-signin");
                    System.out.println("isContainEst first pick <<>." + isContainEst);
                    if (isContainEst == null) {
                        isContainEst = "";
                    }
                 //   session.setAttribute("msg-info-signin", "");
                     request.setAttribute("message", "");
                    
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
                                        <span class="text-right"><h3 style="margin-bottom:0px; margin-top:5px">BVN Data Update</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="panel-body" style="background-color:#FBFBFB; height:400px " >
                            <form action="processor.jsp" method="post">  
                                <input type="hidden" name="command" value="pushservice">
                                <div class="row">

                                    <div class="col-md-4 col-sm-4 col-xm-12">                                
                                        <div class="form-group">
                                            <label for="cbvn">Start BVN Push Service </label>
                                            <!--<input type="text" class="form-control"  name ="cbvn" id="cbvn" autocomplete="off" placeholder="Enter Biometric Verification Number" required>-->
                                        </div>                                
                                    </div>   

                                    <div class="col-md-4 col-sm-4 col-xm-12" style="padding-top:20px">
                                        <button type="submit" class="btn btn-primary">Start Service</button>
                                    </div>               

                                </div>
                                

                            </form>


                        </div>
                    </div>
                </div>


            </div>

            <%@ include file="foot.jsp"%>
    </body>
</html>