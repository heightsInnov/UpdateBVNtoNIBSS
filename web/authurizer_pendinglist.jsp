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
                                    <%@ include file="Admin_navBar.jsp"%>
                                    <br>

                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">Pending List</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div>    

                        <div class="panel-body" style="background-color:#FBFBFB;height:650px" >
							<div class="row">
								<div class="col-md-12">
									<form id="mainForm" role="form" method="post" action="processor.jsp">
										<input type="hidden" name="serviceopt" id="serviceopt" value=""> 
										<input type="hidden" name="command" id="command" value=""> 
										<input type="hidden" name="action" id="action" value=""> 
										<input type="hidden" name="nibss-id" id="nibss-id" value="">
										<input type="hidden" name="sendamount" id="sendamount" value="">
										<input type="hidden" name="destcurrency" id="destcurrency" value="">
										<div class="table-responsive">
											<table id="test" class="table table-striped table-bordered">
												<thead class="bg-info">
													<tr>
														<th width="5%">Request ID</th>
														<th width="10%">BVN</th>
														<th width="15%">Old First Name</th>
														<th width="15%">Old Last Name</th>
														<th width="20%">Date Of Birth</th>
														<th width="20%">Request Date</th>
														<th width="15%">Maker</th> 
														<th></th> 
													</tr>
												</thead>
												<tbody>
													<%	String requestID = "", bvn = "", oldlastname = "", oldfirstname = "", maker = "";
														String dateofbirth = null, reqDate = null;
														List<TransactionsDAO> tTransactionsList = null;
														Processor pp = new Processor();
														try {
															tTransactionsList = pp.getPendingList("N");
														} catch (Exception e) {
														}

														if (tTransactionsList != null) {
															for (TransactionsDAO rec : tTransactionsList) {
																requestID = rec.getRequestID();
																bvn = rec.getBvNumber();
																oldfirstname = rec.getOldFirstName();
																oldlastname = rec.getOldLastName();
																dateofbirth = rec.getOldDateOfBirth();
																reqDate = rec.getRecieveDate();
																maker = rec.getMaker();

																if (requestID == null) {
																	requestID = "";
																}

																if (bvn == null) {
																	bvn = "";
																}
																if (oldlastname == null) {
																	oldlastname = "";
																}
																if (oldfirstname == null) {
																	oldfirstname = "";
																}
																if (maker == null) {
																	maker = "";
																}
																if (dateofbirth == null) {
																	dateofbirth = "";
																}
													%>
													<tr>
														<th class="text-right"><%= requestID%></th>
														<td class="text-right"><%= bvn%></td>
														<td class="text-right"><%= oldfirstname%></td>
														<td class="text-right"><%= oldlastname%></td>
														<td class="text-right"><%= dateofbirth%></td>                                            
														<td class="text-right"><%= reqDate%></td> 
														<td class="text-right"><%= maker%></td> 

														<td class="text-left"><a href="auth_dataview.jsp?request=<%=requestID%>"  nibss-command="viewSend" nibss-id= "<%=requestID%>"  nibss-action="searchsender" data-toggle="tooltip" title="View Requests">View</a></td>
													</tr> 
													<%  }
														} else {
															System.out.println("No data in query");
														}
													%>
												</tbody>
											</table>
										</div>
									</form>
								</div>
							</div>
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
