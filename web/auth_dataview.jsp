<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="com.unionbank.core.FetchRecordsBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="error.jsp"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.xml.bind.JAXBElement"%>
<%@page import="java.util.List"%>
<%@page import="com.unionbank.webpay.db.dao.TransactionsDAO"%>
<%@page import="com.unionbank.core.Processor"%>
<%@page import="com.unionbank.webpay.db.dao.fileUploadData"%>


<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp"%>
        <script>
			function goBack() {
				window.history.back();
			}
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrap">


            <%
				String oldBvNumber = "";
				String oldFirstName = "";
				String firstFirstName = "";
				String firstNameComment = "";

				String oldMiddleName = "";
				String oldLastName = "";
				String oldDateOfBirth = "";
				String oldPhoneNumber = "";
				String oldEmailAdd = "", newmiddleName = "", middleComment = "",
						newLastName = "", lastnameComment = "", newDateOfBirth = "", commentDOB = "", newphoneNumber = "", phoneComment = "";
				String newemailadd = "", emailcomment = "", requestID = "";
				String maker = "";
				String oldMaritalStatus = "", newMaritalStatus = "", maritalstatcomment = "";
				String oldGender = "", newGender = "", gendercomment = "";
				String oldStateOfOrigin = "", newStateOfOrigin = "", stateorigincomment = "";
				String oldResidentialStatus = "", newResidentialStatus = "", residentialStatuscomment = "";
				String oldLGA = "", newLGA = "", lgacomment = "";

				String fFirstName = "", fMiddleName = "", fLastName = "", fDob = "", fMobileNumber = "";
				String fEmailAdd = "", fMaritalStatus = "", fgender = "", fStateOfOrigin = "", fResidentialStatus = "", fLGA = "";
				String bankOfEnrollment = "", branchOfEnrollment = "", title = "", watchlisted = "";
				String fileAddress1 = "", fileAddress2 = "", fileAddress3 = "", newTitle = "", commentTitle = "";

				//List<TransactionsDAO> mert = (List<TransactionsDAO>) session.getAttribute("mert");
				String requestid = request.getParameter("request");
				BigDecimal ReqID = new BigDecimal(requestid);
				FetchRecordsBean fetch = new FetchRecordsBean();
				List<TransactionsDAO> mert = fetch.getRecordsByRequestID(ReqID);
				System.out.println("number of transactionDao in mert is >>" + mert.size());
				try {
					for (TransactionsDAO data2 : mert) {
						oldBvNumber = data2.getBvNumber();
						requestID = data2.getRequestID();
						oldFirstName = data2.getOldFirstName();
						firstFirstName = data2.getNewFirstName();
						firstNameComment = data2.getFirstNameComment();

						System.out.println("In The While firstNameComment " + firstNameComment);
						oldLastName = data2.getOldLastName();
						newLastName = data2.getNewLastName();
						lastnameComment = data2.getLastNameComment();

						oldMiddleName = data2.getOldMiddleName();
						newmiddleName = data2.getNewMiddleName();
						middleComment = data2.getMiddleNameComment();

						oldDateOfBirth = data2.getOldDateOfBirth();
						newDateOfBirth = data2.getNewDateOfBirth();
						commentDOB = data2.getDobComment();

						oldPhoneNumber = data2.getOldPhoneNumber();
						newphoneNumber = data2.getNewPhoneNumber();
						phoneComment = data2.getPhoneNoComment();

						oldEmailAdd = data2.getOldEmailAdd();
						newemailadd = data2.getNewEmailAdd();
						emailcomment = data2.getEmailComment();

						fFirstName = data2.getfFirstName();
						fMiddleName = data2.getfMiddleName();
						fLastName = data2.getfLastName();
						fDob = data2.getfDoB();
						fMobileNumber = data2.getfMobileNumber();
						fEmailAdd = data2.getfEmailAdd();
						maker = data2.getMaker();

						oldMaritalStatus = data2.getOldMaritalStatus();
						newMaritalStatus = data2.getNewMaritalStatus();
						maritalstatcomment = data2.getMaritalStatusComment();
						oldGender = data2.getOldGender();
						System.out.println("Gender >>" + oldGender);
						newGender = data2.getNewGender();
						gendercomment = data2.getCommentGender();
						oldStateOfOrigin = data2.getOldStateOfOrigin();
						newStateOfOrigin = data2.getNewStateOfOrigin();
						stateorigincomment = data2.getStateOfOriginComment();
						oldResidentialStatus = data2.getOldResidentialStatus();
						newResidentialStatus = data2.getNewResidentialStatus();
						residentialStatuscomment = data2.getResidentialStatusComment();
						oldLGA = data2.getOldLGA();
						newLGA = data2.getNewLGA();
						lgacomment = data2.getLgaComment();
						fMaritalStatus = data2.getfMaritalStatus();
						fgender = data2.getfSex();
						fStateOfOrigin = data2.getfStateOfOrigin();
						fResidentialStatus = data2.getfResidentAddress();
						fLGA = data2.getfLga();
						bankOfEnrollment = data2.getBankEnroll();
						branchOfEnrollment = data2.getBranchEnroll();
						fileAddress1 = data2.getFileAddress();
						fileAddress2 = data2.getFileAddress2();
						fileAddress3 = data2.getFileAddress3();

						title = data2.getTitle();
						newTitle = data2.getNewTitle();
						commentTitle = data2.getCommentTitle();

						System.out.println("The title is ******** " + fileAddress1);
//                        watchlisted = data2.getBranchEnroll();

					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("got here no return<<>>>" + mert);
				}
				if (fileAddress1 == null) {
					fileAddress1 = "";
				}
				if (fileAddress2 == null) {
					fileAddress2 = "";
				}
				if (fileAddress3 == null) {
					fileAddress3 = "";
				}
				if (newphoneNumber == null) {
					newphoneNumber = "";
				}
				if (phoneComment == null) {
					phoneComment = "";
				}

				if (middleComment == null) {
					middleComment = "";
				}

				if (newmiddleName == null) {
					newmiddleName = "";
				}

				if (title == null) {
					title = "";
				}
				if (newTitle == null) {
					newTitle = "";
				}

				if (commentTitle == null) {
					commentTitle = "";
				}

				if (watchlisted == null) {
					watchlisted = "";
				}

				if (oldBvNumber == null) {
					oldBvNumber = "";
				}
				if (oldFirstName == null) {
					oldFirstName = "";
				}
				if (firstFirstName == null) {
					firstFirstName = "";
				}
				if (firstNameComment == null) {
					firstNameComment = "";
				}
				if (oldLastName == null) {
					oldLastName = "";
				}
				if (oldMiddleName == null) {
					oldMiddleName = "";
				}
				if (oldDateOfBirth == null) {
					oldDateOfBirth = "";
				}

				if (newDateOfBirth == null) {
					newDateOfBirth = "";
				}
				if (commentDOB == null) {
					commentDOB = "";
				}

				if (newLastName == null) {
					newLastName = "";
				}
				if (lastnameComment == null) {
					lastnameComment = "";
				}

				if (oldPhoneNumber == null) {
					oldPhoneNumber = "";
				}
				if (oldEmailAdd == null) {
					oldEmailAdd = "";
				}

				if (newemailadd == null) {
					newemailadd = "";
				}
				if (emailcomment == null) {
					emailcomment = "";
				}

				if (maker == null) {
					maker = "";
				}
				if (fFirstName == null) {
					fFirstName = "";
				}
				if (fMiddleName == null) {
					fMiddleName = "";
				}
				if (fLastName == null) {
					fLastName = "";
				}
				if (fDob == null) {
					fDob = "";
				}
				if (fMobileNumber == null) {
					fMobileNumber = "";
				}
				if (fEmailAdd == null) {
					fEmailAdd = "";
				}

				if (oldMaritalStatus == null) {
					oldMaritalStatus = "";
				}

				if (newMaritalStatus == null) {
					newMaritalStatus = "";
				}
				if (maritalstatcomment == null) {
					maritalstatcomment = "";
				}

				if (oldGender == null) {
					oldGender = "";
				}

				if (newGender == null) {
					newGender = "";
				}
				if (gendercomment == null) {
					gendercomment = "";
				}
				if (oldStateOfOrigin == null) {
					oldStateOfOrigin = "";
				}
				if (newStateOfOrigin == null) {
					newStateOfOrigin = "";
				}

				if (stateorigincomment == null) {
					stateorigincomment = "";
				}

				if (oldResidentialStatus == null) {
					oldResidentialStatus = "";
				}
				if (newResidentialStatus == null) {
					newResidentialStatus = "";
				}
				if (residentialStatuscomment == null) {
					residentialStatuscomment = "";
				}
				if (oldLGA == null) {
					oldLGA = "";
				}
				if (newLGA == null) {
					newLGA = "";
				}
				if (lgacomment == null) {
					lgacomment = "";
				}
				if (fMaritalStatus == null) {
					fMaritalStatus = "";
				}
				if (fgender == null) {
					fgender = "";
				}
				if (fStateOfOrigin == null) {
					fStateOfOrigin = "";
				}
				if (fResidentialStatus == null) {
					fResidentialStatus = "";
				}
				if (fLGA == null) {
					fLGA = "";
				}
				if (bankOfEnrollment == null) {
					bankOfEnrollment = "";
				}
				if (branchOfEnrollment == null) {
					branchOfEnrollment = "";
				}
				if (oldBvNumber.equals("")) {
					session.setAttribute("msg-info-signin", "Invalid BVN");
					response.sendRedirect("authurizer_pendinglist.jsp");
				}
            %>
            <div class="nibss-full">
                <%@ include file="navbar.jsp"%>
                <br>
                <div class="container">
                    <div class="panel panel-default control-panel">
                        <div class="panel panel-default control-panel" >
                            <div class="panel-heading" style="margin-bottom:0px;">
                                <div class="row">
                                    <%@include file="Admin_navBar.jsp"%>
									<div class="col-md-4 col-sm-4 col-xm-12 pull-right">
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">BVN Data Update(Authorization)</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="panel-body" style="background-color:#FBFBFB;">
                            <form id="mainForm"  name ="mainForm" role="form" method="post" action="processor.jsp">
                                <input type="hidden" name="serviceopt" id="serviceopt" value="">
                                <input type="hidden" name="comment2" id="comment2" value="">
                                <input type="hidden" name="command" id="command" value=""> 
                                <input type="hidden" name="action" id="action" value=""> 
                                <input type="hidden" name="nibss-id" id="nibss-id" value="">
                                <input type="hidden" name="sendamount" id="sendamount" value="">
                                <input type="hidden" name="destcurrency" id="destcurrency" value="">
                                <input type="hidden"  id="myfile" name="myfile" value="<%=fileAddress1%>">
								<input type="hidden"  id="myfile2" name="myfile2" value="<%=fileAddress2%>">
								<input type="hidden"  id="myfile3" name="myfile3" value="<%=fileAddress3%>">
                                <input type="hidden" name="bvnumber" value="<%=oldBvNumber%>">

                                <div class="tab-content form-horizontal">
                                    <div id="sectionA" class="tab-pane fade in active">
                                        <div class="form-horizontal">
                                            <div class="col-xs-12">
                                                <div class="row">
                                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                                        <div class="form-group">
                                                            <label for="firstName">REQUEST ID: <%= requestID%></label>
                                                        </div>  
													</div>
														
                                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                                        <div class="form-group">
                                                            <label for="firstName">BVN: <%= oldBvNumber%></label>

                                                        </div>
                                                    </div>

                                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                                        <div class="form-group">
                                                            <label for="firstName">BANK OF ENROLLMENT: <%= bankOfEnrollment%></label>

                                                        </div>
                                                    </div>
															
                                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                                        <div class="form-group">
                                                            <label for="firstName">BRANCH OF ENROLLMENT: <%= branchOfEnrollment%></label>

                                                        </div>
                                                    </div>
                                                </div>   

                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <div class="table-responsive">
                                                            <div id="upDetails">

                                                                <table  id="mytable" class="table preview-table  table-bordered">
                                                                    <thead class="bg-info">
                                                                        <tr>    
                                                                            <th width="15%" class="text-left">Field </th>
                                                                            <th width="25%" class="text-left">OldValue</th>
                                                                            <th width="25%" class="text-left">FCUBS</th>
                                                                            <th width="25%" class="text-left">NewValue</th>
                                                                            <th width="10%" class="text-left">Comment</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td width="350"><B>Attachment</B></td>
																					<%if (fileAddress1 != "" && fileAddress2 == "" && fileAddress3 == "") {%>
																			<td  id="file" width="2000" colspan="4"><a href="<%=fileAddress1%>" target="_blank" id="downBtn" data-toggle="tooltip" title="Download file">Download</a> </td>
																			<%} else if (!fileAddress1.isEmpty() && !fileAddress2.isEmpty() && fileAddress3.isEmpty()) {%>
                                                                            <td  id="file" width="1000" colspan="2"><a href="<%=fileAddress1%>" target="_blank" id="downBtn" data-toggle="tooltip" title="Download file">Download</a> </td>
																			<td  id="file" width="1000" colspan="2"><a href="<%=fileAddress2%>" target="_blank" id="downBtn" data-toggle="tooltip" title="Download file">Download</a> </td>
																			<%} else if (!fileAddress1.isEmpty() && !fileAddress2.isEmpty() && !fileAddress3.isEmpty()) {%>
																			<td  id="file" width="500" colspan="1"><a href="<%=fileAddress1%>" target="_blank" id="downBtn" data-toggle="tooltip" title="Download file">Download</a> </td>
																			<td  id="file" width="500" colspan="1"><a href="<%=fileAddress2%>" target="_blank" id="downBtn" data-toggle="tooltip" title="Download file">Download</a> </td>
																			<td  id="file" width="500" colspan="1"><a href="<%=fileAddress3%>" target="_blank" id="downBtn" data-toggle="tooltip" title="Download file">Download</a> </td>
																			<td  id="file" width="500" colspan="1"></td>
																			<%}%>
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="350"><B>Title</B></td>
                                                                            <td  id="otitle" width="500"><%= title%> </td>
                                                                            <td  id="ftitle" width="500"></td>
                                                                            <td  id="ntitle" width="500"><%= newTitle%></td>
                                                                            <td  id="commenttitle" width="500"><%= commentTitle%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="350"><B>First Name</B></td>
                                                                            <td  id="ofirstname" width="500"><%= oldFirstName%></td>
                                                                            <td  id="ffirstname" width="500"><%= fFirstName%> </td>
                                                                            <td  id="nfirstname" width="500">  <%= firstFirstName%></td>
                                                                            <td  id="first_comment" width="500"> <%= firstNameComment%> </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="350"><B>Middle Name</B></td>
                                                                            <td  id="omiddlename" width="500"><%=oldMiddleName%> </td>
                                                                            <td  id="fmiddlename" width="500"><%=fMiddleName%> </td>
                                                                            <td  id="nmiddlename" width="500"><%=newmiddleName%></td>
                                                                            <td  id="middlename_comment" width="500"><%=middleComment%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="350"><B>Last Name</B></td>
                                                                            <td  id="olastname" width="500"><%= oldLastName%> </td>
                                                                            <td  id="flastname" width="500"><%= fLastName%> </td>
                                                                            <td  id="nlastname" width="500"><%= newLastName%></td>
                                                                            <td  id="lastname_comment" width="500"><%= lastnameComment%></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="350"><B>Date Of Birth</B></td>
                                                                            <td  id="odateofbirth" width="500"><%= oldDateOfBirth%></td>
                                                                            <td  id="fdateofbirth" width="500"><%= fDob%></td>
                                                                            <td  id="ndateofbirth" width="500"><%= newDateOfBirth%></td>
                                                                            <td  id="dateofbirth_comment" width="500"><%= commentDOB%></td>
                                                                        </tr>

                                                                        <tr>

                                                                            <td width="350"><B>Marital Status</B></td>
                                                                            <td  id="omarstat" width="500"><%= oldMaritalStatus%></td>
                                                                            <td  id="fmarstat" width="500"><%= fMaritalStatus%></td>
                                                                            <td  id="nmarstat" width="500"><%= newMaritalStatus%></td>
                                                                            <td  id="marstat_comment" width="500"><%= maritalstatcomment%></td>
                                                                        </tr>

                                                                        <tr>

                                                                            <td width="350"><B>Gender</B></td>
                                                                            <td  id="ogender" width="500"><%= oldGender%></td>
                                                                            <td  id="fgender" width="500"><%= fgender%></td>
                                                                            <td  id="ngender" width="500"><%= newGender%></td>
                                                                            <td  id="gender_comment" width="500"><%= gendercomment%></td>

                                                                        </tr>

                                                                        <tr>

                                                                            <td width="350"><B>State Of Origin</B></td>
                                                                            <td  id="ostatorigin" width="500"><%= oldStateOfOrigin%></td>
                                                                            <td  id="fstateorigin" width="500"><%= fStateOfOrigin%></td>
                                                                            <td  id="nstateorigin" width="500"><%= newStateOfOrigin%></td>
                                                                            <td  id="stateorigin_comment" width="500"><%= stateorigincomment%></td>

                                                                        </tr>

                                                                        <tr>

                                                                            <td width="350"><B>Residential Address</B></td>
                                                                            <td  id="oresstat" width="500"><%= oldResidentialStatus%></td>
                                                                            <td  id="fresstat" width="500"><%= fResidentialStatus%></td>
                                                                            <td  id="nresstat" width="500"><%= newResidentialStatus%></td>
                                                                            <td  id="resstat_comment" width="500"><%= residentialStatuscomment%></td>

                                                                        </tr>

                                                                        <tr>

                                                                            <td width="350"><B>LGA Of Origin</B></td>
                                                                            <td  id="ogender" width="500"><%= oldLGA%></td>
                                                                            <td  id="fmarstat" width="500"><%= fLGA%></td>
                                                                            <td  id="nmarstat" width="500"><%= newLGA%></td>
                                                                            <td  id="marstat_comment" width="500"><%= lgacomment%></td>

                                                                        </tr>

                                                                        <tr>
                                                                            <%
																				//newphoneNumber="",  phoneComment="";
																			%>
                                                                            <td width="350"><B>Phone Number</B></td>
                                                                            <td  id="ophonenumber" width="500"><%=oldPhoneNumber%></td>
                                                                            <td  id="fphonenumber" width="500"><%=fMobileNumber%></td>
                                                                            <td  id="nphonenumber" width="500"><%=newphoneNumber%></td>
                                                                            <td  id="phonenumber_comment" width="500"><%=phoneComment%></td>

                                                                        </tr>
                                                                        <tr>

                                                                            <td width="350"><B>Email</B></td>
                                                                            <td  id="oemail" width="500"><%=oldEmailAdd%> </td>
                                                                            <td  id="femail" width="500"><%=fEmailAdd%> </td>
                                                                            <td  id="nemail" width="500"><%=newemailadd%></td>
                                                                            <td  id="phonenumber_comment" width="500"><%=phoneComment%></td>

                                                                        </tr>

                                                                        <tr>
                                                                            <td width="350"><B>Maker</B></td>
                                                                            <td  id="noemail" width="500"><%=maker%> </td>
                                                                            <td  id="mnemail" width="500"></td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                        </tr>

                                                                    </tbody>
                                                                </table>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">                            

                                                    <div class="col-xs-12">
                                                        <td class="text-left">
                                                            <button type="button" onclick=" document.forms[0].elements['destcurrency'].value = '<%=requestID%>'; return true;" nibss-action= "<%=requestID%>" data-toggle="modal" data-target="#approveDialog"  data-toggle="tooltip" title="Approve BVN Update Request" class="btn btn-success btn-sm" ><span class="glyphicon glyphicon-send"></span> <strong>APPROVE /REJECT</strong></button></td>
                                                        <button type="button"  data-toggle="tooltip"   nibss-command="returntolist"   class="btn btn-success nibss-detail-link"><span class="glyphicon glyphicon-ok"></span> <strong>RETURN</strong></button>   
                                                    </div> 
                                                </div> 
                                            </div>  
                                            <br>  
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>
                        <div class="modal fade" id="approveDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title" id="myModalLabel1">APPROVE /REJECT TRANSACTION</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div><h4>Authorizer should either Approve or Reject transaction by clicking corresponding Button.Drop your comment too </h4></div>
                                        <br>

                                        <form id="mainForm2" name="mainForm2" role="form">
                                            <div class="row">                            
                                                <div class="col-md-12 col-sm-12 col-xm-12">                                
                                                    <div class="form-group">
                                                        <label for="comment">Authorizer Comment</label>
                                                        <textarea class="form-control" id="comment" rows="6" name="comment" required placeholder="Comment"></textarea>
                                                    </div>                                
                                                </div>  
                                            </div> 
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button"  data-toggle="tooltip"   nibss-command="approvesend" onclick="submitValue()" class="btn btn-success nibss-detail-link">   <span class="glyphicon glyphicon-ok"></span> <strong>APPROVE TRANSACTION</strong> </button>
                                        <button type="button"  data-toggle="tooltip"   nibss-command="rejectsend"  onclick="submitValue2()" class="btn btn-success nibss-detail-link">  <span class="glyphicon glyphicon-ok"></span> <strong>REJECT TRANSACTION</strong> </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@ include file="foot.jsp"%>
                        </body>
                        </html>

                        <script>
							function submitValue()
							{
								//alert("comment===="+document.forms["mainForm2"].elements['comment'].value );
								document.forms["mainForm"].elements['comment2'].value = document.forms["mainForm2"].elements['comment'].value;
								//  alert("comment2================="+document.forms["mainForm"].elements['comment2'].value);
								document.forms["mainForm"].elements['command'].value = "approvesend";

								document.forms["mainForm"].submit();

							}
							function submitValue2()

							{
								//alert("comment===="+document.forms["mainForm2"].elements['comment'].value );
								document.forms["mainForm"].elements['comment2'].value = document.forms["mainForm2"].elements['comment'].value;
								//  alert("comment2================="+document.forms["mainForm"].elements['comment2'].value);
								document.forms["mainForm"].elements['command'].value = "rejectsend";

								document.forms["mainForm"].submit();

							}
                        </script>