<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>
<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="error.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.unionbank.webpay.db.dao.TransactionsDAO"%>
<%@page import="com.unionbank.core.Processor"%>


<!DOCTYPE html>
<html>
    <head>

        <%@ include file="head.jsp"%>

        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrap">

            <div class="nibss-full">
                <%@ include file="navbar.jsp"%>
                <br>

                <div class="container">
                    <div class="panel panel-default control-panel"  >
                        <div class="panel panel-default control-panel" >
                            <div class="panel-heading" style="margin-bottom:0px;">
                                <div class="row">
                                    <%@ include file="operator_navBar.jsp"%>
                                    <br>

                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">Approved List</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div>    

                        <div class="panel-body" style="background-color:#FBFBFB;height:650px" >


                            <form id="mainForm" role="form" method="post" action="processor.jsp">
                                <input type="hidden" name="serviceopt" id="serviceopt" value=""> 
                                <input type="hidden" name="command" id="command" value=""> 
                                <input type="hidden" name="action" id="action" value=""> 
                                <input type="hidden" name="nibss-id" id="nibss-id" value="">
                                <input type="hidden" name="sendamount" id="sendamount" value="">
                                <input type="hidden" name="destcurrency" id="destcurrency" value="">
                            <div class="table-responsive">
                                <table  id="test"  class="table table-striped table-bordered">
                                    <thead class="bg-info">
                                        <tr>     
                                            <th class="text-right">REQUEST ID</th>
                                            <th class="text-right">BVNUMBER</th>
                                            <th class="text-right">OLD FIRST NAME</th>
                                            <th class="text-right">OLD LAST NAME</th>
                                            <th class="text-right">APPROVE/REJECT COMMENT</th>
                                            <th class="text-right">DATE OF BIRTH</th>
                                            <th class="text-right">REQUEST DATE</th>
                                            <th class="text-right">APPROVAL DATE</th>    
                                            


                                        </tr>
                                    </thead>
                                    <tfoot class="bg-info">
                                    </tfoot>
                                    <tbody> 

                                        <%
                                            /* <th class="text-right">BVNUMBER</th>
                                             <th class="text-right">OLD FIRST NAME</th>
                                             <th class="text-right">OLD LAST NAME</th>
                                             <th class="text-right">DATE OF BIRTH</th>
                                             <th class="text-right">REQUEST DATE</th>*/
                                            String bvn = "", oldfirstName = "", oldLastName = "", dateOfBirth = "", requestDate = "",requestid="",approveDate="";;
                                            String approve_reject_comment="";//APPROVE_REJECT_DATE
                                            List<TransactionsDAO> tTransactionsList = null;
                                            Processor pp = new Processor();
                                            try {
                                                tTransactionsList = pp.getPendingList("Y");
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            System.out.println("tTransactionsList  ????<<>>>" + tTransactionsList);

                                            if (tTransactionsList.isEmpty()) {
                                            }
                                            if (tTransactionsList != null) {
                                                String authstatus = "", disableStatus = "";
                                                for (TransactionsDAO data2 : tTransactionsList) {
                                                    requestid= data2.getRequestID();
                                                    bvn = data2.getBvNumber();
                                                    oldfirstName = data2.getOldFirstName();
                                                    oldLastName = data2.getOldLastName();
                                                    dateOfBirth = data2.getOldDateOfBirth();
                                                    requestDate = data2.getRecieveDate();
                                                    approveDate = data2.getApprovedate();
                                                   approve_reject_comment= data2.getRejectComment();
                                                    if (approve_reject_comment == null) {
                                                        approve_reject_comment = "";
                                                    }
                                                     if (approveDate == null) {
                                                        approveDate = "";
                                                    }
                                                    if (bvn == null) {
                                                        bvn = "";
                                                    }
                                                    if (oldfirstName == null) {
                                                        oldfirstName = "";
                                                    }
                                                    if (dateOfBirth == null) {
                                                        dateOfBirth = "";
                                                    }
                                                    if (requestDate == null) {
                                                        requestDate = "";
                                                    }
                                                     if (requestid == null) {
                                                        requestid = "";
                                                    }


                                        %>
                                        <tr>
                                            <td class="text-right">  <%=requestid%> </td>    
                                            <td class="text-right">  <%=bvn%> </td>                                                
                                            <td class="text-right">  <%=oldfirstName%> </td>
                                            <td class="text-right"> <%=oldLastName%></td>  
                                            <td class="text-right"> <%=approve_reject_comment%></td> 
                                            <td class="text-right"> <%=dateOfBirth%></td>
                                            <td class="text-right"> <%=requestDate%></td> 
                                            <td class="text-right"> <%=approveDate%></td>
                                              
                                          
                                             


                                        </tr>
                                        <% }
                                            }
                                        %>


                                    </tbody>
                                </table>

                            </div>   
                                        </form>
                            <div class="col-md-4 col-sm-4 col-xm-12" style="padding-top:20px">


                            </div>          

                        </div>
                    </div>
                </div>
            </div>
                                        
                                <div class="modal fade" id="myModal" >

                                    <div    class="modal-dialog">

                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel1">Customer Details Modification</h4>
                                            </div>

                                            <div class="modal-body">

                                                <div class="col-md-12">
                                                    <div class="form-horizontal">
                                                        <div id="lvDetails_ctrl8_panDate" class="form-group">
                                                            <label class="col-md-4 control-label">Old Email</label>
                                                            <div class="col-md-8">
                                                                <input name="slanditf" type="text" id="slanditf"   class="  form-control"  disabled>

                                                            </div>
                                                        </div>
                                                        <div id="lvDetails_ctrl_panDate" class="form-group">
                                                            <label class="col-md-4 cvontrol-label">New Email</label>
                                                            <div class="col-md-8">
                                                                <input name="newemail1" type="text" id="newemail1" class="form-control" >

                                                            </div>

                                                        </div>

                                                        <div id="lvDetails_ctrl_pancoment" class="form-group">
                                                            <label class="col-md-4 control-label">Comments</label>
                                                            <div class="col-md-8">
                                                                <textarea name="tcomment" rows="3" cols="20" id="tcomment" class="form-control"></textarea>
                                                            </div>
                                                        </div>


                                                    </div>
                                                </div>


                                            </div>

                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button"  id="btnSave" class="btn btn-success "><span class="glyphicon glyphicon-ok"></span> <strong> SUBMIT</strong></button>

                                            </div>
                                        </div>
                                    </div>
                                </div>                                        
            <div class="modal fade" id="approveDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel1">DISABLE</h4>
                        </div>
                        <div class="modal-body">
                            <div><h4>Clicking  disable  will stop merchant from participating in payment transactions</h4></div>
                            <br>

                           


                        </div>
                        <div class="modal-footer">
                            <button type="button"  data-toggle="tooltip"   nibss-command="disable"  title="Approve transaction request" class="btn btn-success nibss-detail-link"><span class="glyphicon glyphicon-ok"></span> <strong>DISABLE</strong></button>



                        </div>
                    </div>
                </div>
            </div>

        </div>


        <%@ include file="tfoot.jsp"%>


    </body>
</html>
