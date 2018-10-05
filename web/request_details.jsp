<%@page language="java" contentType="text/html" import ="java.util.List,java.util.ArrayList, java.text.NumberFormat, java.util.Locale" pageEncoding="ISO-8859-1" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.unionbank.webpay.db.dao.TransactionsDAO"%>
<%@page import="com.unionbank.core.FetchRecordsBean"%>

<html lang="en">
    <head>
        <%@ include file="head.jsp"%>
        <title>Request Details</title>
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
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">Request Details</h3></span>
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
									<table id="test" class="table table-striped table-bordered">
										<thead class="bg-info">
											<tr>
												<th>Request ID</th>
												<th>BVN</th>
												<th>Old First Name</th>
												<th>Old Last Name</th>
												<th>Date Of Birth</th>
												<th>Request Date</th>
												<th>Maker</th> 
												<th></th> 
											</tr>
										</thead>
										<tbody>
											<%	String requestID = "", bvn = "", oldlastname = "", oldfirstname = "", maker = "";
												String dateofbirth = null, reqDate = null;
												List<TransactionsDAO> mert = null;
												mert = (ArrayList<TransactionsDAO>) session.getAttribute("mert");
												if (mert != null) {
													for (TransactionsDAO rec : mert) {

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
								<script type="text/javascript">
									// For demo to fit into DataTables site builder...
									$('#example')
											.removeClass('display')
											.addClass('table table-striped table-bordered');
								</script>
						</div>
					</div><!-- end of row -->
				</div>s
				<footer>
					<div class="container">
						<div class="row">
							<div id="copyright" class="col-md-8">
								<ul class="list-inline text-left copyright-links">
									<li><span>Copyright 2017</span><a href="#"> UnionBank Nigeria Plc</a><span> All Rights Reserved. Powered By DEVOPS</span></li> 
								</ul>
							</div> 

						</div>
					</div>
				</footer>

				<script src="js/bootstrap-datepicker.js"></script> 
				<script src="js/jquery-bigtext.js"></script>
				<script src="js/bootstrap-submenu.min.js" defer></script>
				<script type="text/javascript">
									$(document).ready(function () {

										$('#example').DataTable();
										$('.accordion-toggle').on('click', function (event) {
											event.preventDefault();
											// create accordion variables
											var accordion = $(this);
											var accordionContent = accordion.next('.accordion-content');
											var accordionToggleIcon = $(this).children('.toggle-icon');

											// toggle accordion link open class
											accordion.toggleClass("open");
											// toggle accordion content
											accordionContent.slideToggle(250);

											// change plus/minus icon
											if (accordion.hasClass("open")) {
												accordionToggleIcon.html("<i class='fa fa-minus'></i>");
											} else {
												accordionToggleIcon.html("<i class='fa fa-plus'></i>");
											}
										});
										$(".amt").bigText({
											rotateText: null, // Rotates the text by X degrees
											fontSizeFactor: 0.7, // used to give some vertical spacing for letters that overflow the line-height 
											maximumFontSize: null, // limits the maximum font size of your text
											limitingDimension: "both", // In which dimension the font size should be limited. Possible values: "width", "height" or "both". 
											horizontalAlign: "left",
											verticalAlign: "center",
											textAlign: "left"
										});
										$('[data-submenu]').submenupicker();
									});
				</script>
				<% if (request.getAttribute("error") != null) {%>
				<script>
					$(document).ready(function () {
						$('#errorModal').modal('show');
					});

				</script>
				<%}%>
				<% if (request.getAttribute("success") != null) {%>
				<script>
					$(document).ready(function () {
						$('#successModal').modal('show');
					});

				</script>  
				<%}%>
				<% if (request.getAttribute("successdelete") != null) {%>
				<script>
					$(document).ready(function () {
						$('#successDeleteModal').modal('show');
					});

				</script>  
				<%}%>

				<script>
					function myFunction2() {
						document.getElementById("fetchForm2").submit();
					}
					function myFunction3() {
						document.getElementById("logoutform").submit();
					}
					function myFunction() {
						document.getElementById("fetchForm").submit();
					}
				</script>
				<script>
					function exportToExcel() {
						intable = document.getElementById("example");
						this.table = intable.cloneNode(true);
						var cform = document.createElement("form");
						cform.style.display = "none";
						cform.setAttribute("method", "POST");
						cform.setAttribute("action", "exporttoexcel.jsp");
						cform.setAttribute("name", "ExcelForm");
						cform.setAttribute("id", "ExcelForm");
						cform.setAttribute("enctype", "MULTIPART/FORM-DATA");
						cform.encoding = "multipart/form-data";
						var ta = document.createElement("textarea");
						ta.name = "ExcelTable";
						var tabletext = this.table.outerHTML;
						ta.defaultValue = tabletext;
						ta.value = tabletext;
						cform.appendChild(ta);
						intable.parentNode.appendChild(cform);
						cform.submit();
						//clean up
						ta.defaultValue = null;
						ta = null;
						tabletext = null;
						this.table = null;
					}
				</script>
				<script>
					function goBack() {
						window.history.back();
					}
				</script>
				</body>
				</html>