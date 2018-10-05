<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="error.jsp"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.xml.bind.JAXBElement"%>
<%@page import="java.util.List"%>
<%@page import="com.unionbank.webpay.db.dao.TransactionsDAO"%>
<%@page import="javax.imageio.ImageIO" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp"%>
        <script>
			function goBack() {
				window.history.back();
			}
        </script>
		<script>
			function AddNewFile() {
				var defdiv = document.getElementById("DivDefault");
				var count = defdiv.getElementsByTagName("input").length;

				if (count < 3) {
					var newString = '<br/> <div class="row">';
					newString += '<div class="col-md-2">';
					newString += '</div><div class="col-md-3">';
					newString += '<label>Upload Supporting Document: ';
					newString += '</label></div><div class="col-md-4">';
					newString += '<input type="file" id="myFile' + count + '" name="myFile' + count + '" class="form-control" required="true"/>';
					newString += '</div>';
					newString += '</div>';

					defdiv.innerHTML += newString;
					document.getElementById("uploadCount").value = count + 1;
				} else {
					alert("Maximum of 3 uploads allowed!");
				}
			}
		</script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrap">

            <%
				String oldBvNumber = "";
				String oldBankEnrollment = "";
				String title = "";
				String watchlisted = "";
				String oldBranchEnrollment = "";
				String oldFirstName = "";
				String oldMiddleName = "";
				String oldLastName = "";
				String oldDateOfBirth = "";
				String oldPhoneNumber = "";
				String oldEmailAdd = "";
				String oldMaritalStatus = "";
				String oldGender = "";
				String oldStateOfOrigin = "";
				String oldResidentialStatus = "";
				String oldLGA = "";
				String imageUrl = "";
				String fFirstName = "";
				String fMiddleName = "";
				String fLastName = "";
				String fDoB = "";
				String fPhoneNumber = "";
				String fEmailAdd = "";
				String fMaritalStatus = "";
				String fGender = "";
				String fStateOfOrigin = "";
				String fResidentialStatus = "";
				String fLGA = "";
				byte[] image = null;
				//Image image = ImageIO

				TransactionsDAO mert = (TransactionsDAO) session.getAttribute("mert");

				String transactionid = (String) session.getAttribute("transactionid");
//                String transactionid = (String)request.getAttribute("transactionid");
				if (transactionid == null) {
					transactionid = "";
				}
				System.out.println("transactionid<<>>>" + transactionid);
				// String ccfirstname = request.getParameter("ccfirstname");
				/* System.out.println("got here mert<<>>>" + mert);
                 if (mert == null) {
                 session.setAttribute("msg-info-signin", "Invalid BVN");
                 response.sendRedirect("bvn_verification.jsp");
                 }*/

				try {
					oldBvNumber = mert.getOldBvNumber();
					oldBankEnrollment = mert.getBankEnroll();
					title = mert.getTitle();
					watchlisted = mert.getWatchlisted();

					oldBranchEnrollment = mert.getBranchEnroll();
					oldFirstName = mert.getOldFirstName();
					oldLastName = mert.getOldLastName();
					oldMiddleName = mert.getOldMiddleName();
					oldDateOfBirth = mert.getOldDateOfBirth();
					oldPhoneNumber = mert.getOldPhoneNumber();
					oldEmailAdd = mert.getOldEmailAdd();
					oldMaritalStatus = mert.getOldMaritalStatus();
					oldGender = mert.getOldGender();
					oldStateOfOrigin = mert.getOldStateOfOrigin();
					oldResidentialStatus = mert.getOldResidentialStatus();
					oldLGA = mert.getOldLGA();
					image = mert.getImage();

					fFirstName = mert.getfFirstName();
					fMiddleName = mert.getfMiddleName();
					fLastName = mert.getfLastName();
					fDoB = mert.getfDoB();
					fPhoneNumber = mert.getfMobileNumber();
					fEmailAdd = mert.getfEmailAdd();
					fMaritalStatus = mert.getfMaritalStatus();
					fGender = mert.getfSex();
					fStateOfOrigin = mert.getfStateOfOrigin();
					fResidentialStatus = mert.getfResidentAddress();
					fLGA = mert.getfLga();

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("got here no return<<>>>" + mert);
				}

				if (oldBvNumber == null) {
					oldBvNumber = "";
				}

				if (oldBankEnrollment == null) {
					oldBankEnrollment = "";
				}
				if (oldBranchEnrollment == null) {
					oldBranchEnrollment = "";
				}

				if (oldFirstName == null) {
					oldFirstName = "";
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
				if (oldPhoneNumber == null) {
					oldPhoneNumber = "";
				}
				if (oldEmailAdd == null) {
					oldEmailAdd = "";
				}
				if (oldMaritalStatus == null) {
					oldMaritalStatus = "";
				}
				if (title == null) {
					title = "";
				}
				if (watchlisted == null) {
					watchlisted = "";
				}
				if (oldGender == null) {
					oldGender = "";
				}
				if (oldStateOfOrigin == null) {
					oldStateOfOrigin = "";
				}
				if (oldResidentialStatus == null) {
					oldResidentialStatus = "";
				}
				if (oldLGA == null) {
					oldLGA = "";
				}
				if (fFirstName == null) {
					fFirstName = "";
				}
				if (fLastName == null) {
					fLastName = "";
				}
				if (fMiddleName == null) {
					fMiddleName = "";
				}
				if (fDoB == null) {
					fDoB = "";
				}
				if (fPhoneNumber == null) {
					fPhoneNumber = "";
				}
				if (fEmailAdd == null) {
					fEmailAdd = "";
				}
				if (fMaritalStatus == null) {
					fMaritalStatus = "";
				}

				if (fGender == null) {
					fGender = "";
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

				if (oldBvNumber.equals("")) {
					session.setAttribute("msg-info-signin", "Invalid BVN");
					response.sendRedirect("bvn_verification.jsp");
				}

				UserProfile ursPpee = (UserProfile) session.getAttribute("Urs");
				String DisplayName = "", Depts = "", branchcode = "";
				String userEmail = "";

				//UserProfile ursPpee = new UserProfile();
				try {
					// DisplayName = ursPpee.getDisplayName().getValue();
					branchcode = ursPpee.getBranchCode().getValue();
					userEmail = ursPpee.getEmail().getValue();
					System.out.println("getEmployeeId<<>> " + ursPpee.getEmployeeId().getValue());
					System.out.println("getUserEmail<<>> " + ursPpee.getEmail().getValue());
					System.out.println("getBranchCode<<>> " + ursPpee.getBranchCode().getValue());
					Depts = ursPpee.getDepartment().getValue();

					String path = "C:\\ProjectsJava\\UpdateBVNtoNIBSS\\web\\img\\Picture_";
					String Jpeg = ".png";
					imageUrl = path + oldBvNumber + Jpeg;
					System.out.println("The image value is>>>>> " + imageUrl);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				if (DisplayName == null) {
					DisplayName = "";
				}
				if (branchcode == null) {
					branchcode = "";
				}
				if (userEmail == null) {
					userEmail = "";
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
                                    <%@ include file="operator_navBar.jsp"%>
                                    <br>

                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <span class="text-right"><h3 style = "margin-bottom:0px;margin-top:5px">BVN Data Update</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="panel-body" style="background-color:#FBFBFB;" >  

							<form action="ProcessUpdateServNew" method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-4 col-sm-4 col-xm-12">
										<div class="form-group">
											<label for="firstName">BVN: <%=oldBvNumber%></label>
											<p id="demo"></p>
										</div>
									</div>
								</div>
								<div  class="row">
									<div class="col-md-12" id="DivDefault">
										<div class="row">
											<div class="col-md-2"></div>
											<div class="col-md-3">
												<label>Upload Supporting Document:<span style="color: red">*</span> </label>
												<p><i>Max 3 files(3MB each) allowed of format .pdf, .docx, .doc, .jpeg, .jpg, emails</i></p>
											</div>
											<div class="col-md-4">
												<input type="file" id="myFiles" accept=".doc,.pdf,.docx,image/jpeg, image/jpg" title="Max 3 files allowed" name="myFiles" class="form-control" required="true" multiple/>
											</div>
											<div class="col-md-2">
												<input type="submit" id="submit" name="submit" value="Upload" class="btn btn-primary"/>
											</div>
										</div>
									</div>
								</div>
								<br/>
								<%
									String isContainEst = (String) request.getAttribute("message");

									//  String isContainEst = (String) session.getAttribute("msg-info-signin");
									System.out.println("isContainEst first pick <<>." + isContainEst);
									if (isContainEst == null) {
										isContainEst = "";
									}
									//   session.setAttribute("msg-info-signin", "");
									request.setAttribute("message", "");

									if (!isContainEst.equals("") && isContainEst.contains("Success!")) {
										System.out.println("in Upload :::yes message available<<>>" + isContainEst);
								%>
								<div class="alert alert-success text-center alert-dismissable sticky"><button class="close" aria-hidden="true" data-dismiss="alert" type="button">&times;</button><h4><%=isContainEst%></h4></div>
								<%                    } else if (!isContainEst.equals("") && isContainEst.contains("Error!")) {%>
								<div class="alert alert-danger text-center alert-dismissable sticky"><button class="close" aria-hidden="true" data-dismiss="alert" type="button">&times;</button><h4><%=isContainEst%></h4></div>
								<%
									} else if(!isContainEst.equals("") && isContainEst.contains("Info!")) {%>
									<div class="alert alert-info text-center alert-dismissable sticky"><button class="close" aria-hidden="true" data-dismiss="alert" type="button">&times;</button><h4><%=isContainEst%></h4></div>
									<%}else  {
										System.out.println("in Upload :::No message available<<>>" + isContainEst);
									}
								%>
								<br/>
							</form>

                            <form  id="uploadfl"  method="post" action="ProcessUpdateServlet"  enctype="multipart/form-data">
                                <input type="hidden" name="bvnumber" value="<%= oldBvNumber%>">
                                <!--input type="hidden" name="markerid" value="<!%= DisplayName%">-->
                                <input type="hidden" name="markerid" value="<%= userEmail%>">
                                <input type="hidden" name="branchcode" value="<%=branchcode%>">
                                <input type="hidden" name="branchcode" value="<%=userEmail%>">
                                <input type="hidden" id="command" name="command" value="TolaUpdate"/>

                                <!-- Hidden fields for customer data-->
                                <input type="hidden"  id="HEnrollBank" name="HEnrollBank" value="<%= oldBankEnrollment%>">
                                <input type="hidden"  id="HEnrollBranch" name="HEnrollBranch" value="<%= oldBranchEnrollment%>">

                                <input type="hidden"  id="Hofirstname" name="Hofirstname" value="<%= oldFirstName%>">
                                <input type="hidden"  id="Hffirstname" name="Hffirstname" value="<%= fFirstName%>">

                                <input type="hidden"  id="Homiddlename" name="Homiddlename" value="<%=oldMiddleName%>">
                                <input type="hidden"  id="Hfmiddlename" name="Hfmiddlename" value="<%=fMiddleName%>">

                                <input type="hidden"  id="Holastname" name="Holastname" value="<%= oldLastName%>">
                                <input type="hidden"  id="Hflastname" name="Hflastname" value="<%= fLastName%>">

                                <input type="hidden"  id="Hodob" name="Hodob" value="<%= oldDateOfBirth%>">
                                <input type="hidden"  id="Hfdob" name="Hfdob" value="<%= fDoB%>">

                                <input type="hidden"  id="HomStatus" name="HomStatus" value="<%=oldMaritalStatus%>">
                                <input type="hidden"  id="HfmStatus" name="HfmStatus" value="<%=fMaritalStatus%>">

                                <input type="hidden"  id="Hogender" name="Hogender" value="<%=oldGender%>">
                                <input type="hidden"  id="Hfgender" name="Hfgender" value="<%=fGender%>">

                                <input type="hidden"  id="HoSOO" name="HoSOO" value="<%=oldStateOfOrigin%>">
                                <input type="hidden"  id="HfSOO" name="HfSOO" value="<%=fStateOfOrigin%>">

                                <input type="hidden"  id="HoRStatus" name="HoRStatus" value="<%=oldResidentialStatus%>">
                                <input type="hidden"  id="HfRStatus" name="HfRStatus" value="<%= fResidentialStatus%>">

                                <input type="hidden"  id="HoLGA" name="HoLGA" value="<%=oldLGA%>">
                                <input type="hidden"  id="HfLGA" name="HfLGA" value="<%= fLGA%>">

                                <input type="hidden"  id="HoPhone" name="HoPhone" value="<%=oldPhoneNumber%>">
                                <input type="hidden"  id="HfPhone" name="HfPhone" value="<%=fPhoneNumber%>">


                                <input type="hidden"  id="HoEmail" name="HoEmail" value="<%=oldEmailAdd%>">
                                <input type="hidden"  id="HfEmail" name="HfEmail" value="<%=fEmailAdd%>">

                                <input type="hidden"  id="HoTitle" name="HoTitle" value="<%= title%>">

								<input type="hidden" id="uploadCount" name="uploadCount" value="">

                                <input type="hidden" id="transactionid" name="transactionid" value='<%=transactionid%>'>

                                <!-- Files for upload -->
                                <input type="hidden"  id="Onefile" name="Onefile" value="">
                                <input type="hidden"  id="middlenamefile" name="middlenamefile" value="">
                                <input type="hidden"  id="lastnamefile" name="lastnamefile" value="">
                                <input type="hidden"  id="dobfile" name="dobfile" value="">
                                <input type="hidden"  id="phonenofile" name="phonenofile" value="">
                                <input type="hidden"  id="emailfile" name="emailfile" value="">
                                <input type="hidden"  id="maritalstatfile" name="maritalstatfile" value="">
                                <input type="hidden"  id="lgafile" name="lgafile" value="">
                                <input type="hidden" id="resaddressfile" name="resaddressfile" value="">
                                <input type="hidden"  id="sexfile" name="sexfile" value="">
                                <input type="hidden"  id="titlefile" name="titlefile" value="">
                                <input type="hidden"  id="stateoforiginfile" name="stateoforiginfile" value="">
                                <input type="hidden" id="login_attempts" name="login_attempts" value="">


                                <%@ include file="t_emailpopup.jsp"%>
                                <%@ include file="t_phonepopup.jsp"%>
                                <%@ include file="t_dobpup.jsp"%>
                                <%@ include file="t_lastnmpup.jsp"%>
                                <%@ include file="t_middlenamempup.jsp"%>
                                <%@ include file="t_firstnamempup.jsp"%>
                                <%@ include file="t_maritalstatpop.jsp"%>
                                <%@ include file="t_residentialAddresspop.jsp"%>
                                <%@ include file="t_lgapop.jsp"%>
                                <%@ include file="t_genderpop.jsp"%>
                                <%@ include file="t_stateoforiginpop.jsp"%>
                                <%@ include file="t_titlepop.jsp"%>

                                <div class="tab-content form-horizontal">
                                    <div id="sectionA" class="tab-pane fade in active">
                                        <div class="form-horizontal">
                                            <div class="col-xs-12">
                                                <div class="row">
                                                    <div class="col-md-12">
                                                        <div class="table-responsive">
                                                            <div id="upDetails">

                                                                <table  id="mytable" class="table preview-table  table-bordered">
                                                                    <thead class="bg-info">
                                                                        <tr>    
                                                                            <th width="10%" class="text-left">Field</th>
                                                                            <th width="25%" class="text-left">NIBSS</th>
                                                                            <th width="25%" class="text-left">FCUBS</th>
                                                                            <th width="25%" class="text-left">Modification</th>
                                                                            <th width="15%" class="text-left">Comment</th>
                                                                            <!--<th width="50%" class="text-left">FileUpload</th>
                                                                            <th width="50%" class="text-left">Edit</th>-->
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody> 
                                                                        <tr>
                                                                            <td width="200"><B>Bank Of Enrollment</B></td>

                                                                            <td  id="obankenroll" width="500"><%= oldBankEnrollment%> </td>
                                                                            <td  id="mbankenroll" width="500"></td>
                                                                            <td  id="nbankenroll" width="500"></td>
                                                                            <td  id="bnkenroll_comment" width="500"></td>     
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile" name="myfile"   onchange="myFunction(this.form.login_attempts,this);" />

                                                                            </td>

                                                                            <td width="50" style="text-align: center;">-->   

                                                                            <!--button type="button" id="firstname_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                        </td>-->
                                                                        </tr>

                                                                        <tr>
                                                                            <td width="200"><B>Branch Of Enrollment</B></td>

                                                                            <td  id="obranchenroll" width="500"><%= oldBranchEnrollment%> </td>
                                                                            <td  id="fbranchenroll" width="500"></td>
                                                                            <td  id="nbranchenroll" width="500"></td>
                                                                            <td  id="branchenroll_comment" width="500"></td>   
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile" name="myfile"   onchange="myFunction(this.form.login_attempts,this);" />



                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button" id="firstname_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>
                                                                            <td width="50" style="text-align: center;">   

                                                                            <!--button type="button" id="firstname_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                        </td>-->
                                                                        </tr>

                                                                        <tr>
                                                                            <td width="200"><B>First Name</B></td>
                                                                            <td  id="ofirstname" width="500"><%= oldFirstName%></td>
                                                                            <td  id="mfirstname" width="500"><%= fFirstName%></td>
                                                                            <td  id="nfirstname" width="1000"><input type="text" class="form-control" autocomplete="off" pattern="[A-Za-z]{}" name="nfirstnameTxt" style="width: 100%;" id="nfirstnameTxt" /></td>                                                                          
                                                                            <td  id="first_comment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="fnamecommentTxt" style="width: 100%;" id="fnamecommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile" name="myfile" onchange="myFunction(this.form.login_attempts, this);" />
                                                                            </td>
                                                                            <td width="50" style="text-align: center;">  
                                                                                <button type="button" id="firstname_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>
                                                                            </td>-->
                                                                        </tr>                                                                      

                                                                        <tr>
                                                                            <%
																				//mert.getFirstName()
																			%>
                                                                            <td width="200"><B>Middle Name</B></td>
                                                                            <td  id="omiddlename" width="500"><%=oldMiddleName%></td>
                                                                            <td  id="mmiddlename" width="500"><%=fMiddleName%></td>
                                                                            <td  id="nmiddlename" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="nmiddlenameTxt" style="width: 100%;" id="nmiddlenameTxt" /></td>
                                                                            <td  id="middlename_comment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="mnamecommentTxt" style="width: 100%;" id="mnamecommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile1" name="myfile1" onchange="myFunction1(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="middlename_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="200"><B>Last Name</B></td>
                                                                            <td  id="olastname" width="500"><%= oldLastName%> </td>
                                                                            <td  id="flastname" width="500"><%= fLastName%></td>
                                                                            <td  id="nlastname" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="nlastnameTxt" style="width: 100%;" id="nlastnameTxt" /></td>
                                                                            <td  id="lastname_comment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="lnamecommentTxt" style="width: 100%;" id="lnamecommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"  id="myfile22" name="myfile22" onchange="myFunction2(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"  id="lastname_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>
                                                                        <tr>

                                                                            <td width="200"><B>Date Of Birth</B></td>
                                                                            <td  id="odateofbirth" width="500"><%= oldDateOfBirth%></td>
                                                                            <td  id="fdateofbirth" width="500"><%= fDoB%></td>
                                                                            <td  id="ndateofbirth" width="500"><input type="date" class="form-control" name="ndateofbirthTxt" style="width: 100%;" id="ndateofbirthTxt"/></td>
                                                                            <td  id="dateofbirth_comment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="dobcommentTxt" style="width: 100%;" id="dobcommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile33" name="myfile33"  onchange="myFunction3(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="dateofbirth_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>

                                                                        <tr>
                                                                            <td width="200"><B>Marital Status</B></td>
                                                                            <td  id="oldMaritalStatus" width="500"><%=oldMaritalStatus%></td>
                                                                            <td  id="fMaritalStatus" width="500"><%=fMaritalStatus%></td>
                                                                            <!--<td  id="newMaritalStatus" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="newMaritalStatusTxt" style="width: 100%;" id="newMaritalStatusTxt" /></td>-->
																			<td  id="newMaritalStatus" width="500">
																				<select id="newMaritalStatusTxt" name="newMaritalStatusTxt" class="form-control" style="width: 100%;">
																					<option value="-1">--Choose Status--</option>
																					<option value="Single">Single</option>
																					<option value="Married">Married</option>
																					<option value="Divorced">Divorced</option>
																					<option value="Widowed">Widowed</option>
																					<option value="Other">Other</option>
																				</select>
																			</td>
                                                                            <td  id="maritalStatusComment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="mscommentTxt" style="width: 100%;" id="mscommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile44" name="myfile44" onchange="myFunction4(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button" id="maritalStatusComment_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>                                                                                                            

                                                                        <tr>

                                                                            <td width="200"><B>Gender</B></td>
                                                                            <td  id="oldGender" width="500"><%=oldGender%></td>
                                                                            <td  id="fGender" width="500"><%=fGender%></td>
                                                                            <td  id="newGender" width="500">
																				<!--<input type="text" class="form-control" pattern="[A-Za-z]{}" name="newGenderTxt" style="width: 100%;" id="newGenderTxt" />-->
																				<select id="newGenderTxt" name="newGenderTxt" class="form-control" style="width: 100%;">
																					<option value="-1">--Choose Gender--</option>
																					<option value="Male">Male</option>
																					<option value="Female">Female</option>
																				</select>
																			</td>
                                                                            <td  id="commentGender" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="gencommentTxt" style="width: 100%;" id="gencommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile112" name="myfile112"  onchange="myFunction21(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"  id="commentGender_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>

                                                                        <tr>

                                                                            <td width="200"><B>State Of Origin</B></td>
                                                                            <td  id="oldStateOfOrigin" width="500"><%=oldStateOfOrigin%></td>
                                                                            <td  id="fStateOfOrigin" width="500"><%=fStateOfOrigin%></td>
                                                                            <td  id="newStateOfOrigin" width="500"><input type="text" name="newStateOfOriginTxt" class="form-control" pattern="[A-Za-z]{}" style="width: 100%;" id="newStateOfOriginTxt" /></td>
                                                                            <td  id="stateOfOriginComment" width="500"><input type="text" name="sogcommentTxt" class="form-control" pattern="[A-Za-z]{}" style="width: 100%;" id="sogcommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile111" name="myfile111"  onchange="myFunction20(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"  id="stateOfOriginComment_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>

                                                                        <tr>

                                                                            <td width="200"><B>Residential Address</B></td>
                                                                            <td  id="oldResidentialStatus" width="500"><%=oldResidentialStatus%></td>
                                                                            <td  id="fResidentialStatus" width="500"><%= fResidentialStatus%></td>
                                                                            <td  id="newResidentialStatus" width="500"><input type="text" name="nrsTxt" class="form-control" pattern="[A-Za-z]{}" style="width: 100%;" id="nrsTxt" /></td>
                                                                            <td  id="residentialStatusComment" width="500"><input type="text" name="nrscommentTxt" class="form-control" pattern="[A-Za-z]{}" style="width: 100%;" id="nrscommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file" id="myfile77" name="myfile77" onchange="myFunction7(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button" id="residentialStatusComment_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>

                                                                        <tr>

                                                                            <td width="200"><B>LGA Of Origin</B></td>
                                                                            <td  id="oldLGA" width="500"><%=oldLGA%></td>
                                                                            <td  id="fLGA" width="500"><%= fLGA%></td>
                                                                            <td  id="newLGA" width="500"><input type="text" name="nlgaTxt" class="form-control" pattern="[A-Za-z]{}" style="width: 100%;" id="nlgaTxt" /></td>
                                                                            <td  id="lgaComment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="nlgacommentTxt" style="width: 100%;" id="nlgacommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile88" name="myfile88"  onchange="myFunction8(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="lgaComment_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>


                                                                        <tr>
                                                                            <%

                                                                            %>
                                                                            <td width="200"><B>Phone Number</B></td>
                                                                            <td  id="ophonenumber" width="500"><%=oldPhoneNumber%></td>
                                                                            <td  id="fphonenumber" width="500"><%=fPhoneNumber%></td>
                                                                            <td  id="nphonenumber" width="500"><input type="tel" class="form-control" pattern="[0-9]{11}" min="11" max="11" name="nphoneTxt" style="width: 100%;" id="nphoneTxt" /></td>
                                                                            <td  id="phonenumber_comment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="nphonecommentTxt" style="width: 100%;" id="nphonecommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile99" name="myfile99"  onchange="myFunction9(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="phonenumber_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="200"><B>Email</B></td>
                                                                            <td  id="oemail" width="500"><%=oldEmailAdd%> </td>
                                                                            <td  id="femail" width="500"><%=fEmailAdd%></td>
                                                                            <td  id="nemail" width="500"><input type="email" name="nemailTxt" class="form-control" style="width: 100%;" id="nemailTxt" /></td>
                                                                            <td  id="email_comment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="nemailcommentTxt" style="width: 100%;" id="nemailcommentTxt" /></td>
                                                                            <!--<td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile100" name="myfile100"  onchange="myFunction10(this.form.login_attempts, this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>-->
                                                                        </tr>

                                                                        <tr>
                                                                            <td width="200"><B>Title</B></td>

                                                                            <td  id="otitle" width="500"><%= title%> </td>
                                                                            <td  id="ftitle" width="500"></td>
                                                                            <td  id="ntitle" width="500"><input type="text" name="ntitleTxt" class="form-control" pattern="[A-Za-z]{}" style="width: 100%;" id="ntitleTxt" /></td>
                                                                            <td  id="otitle_comment" width="500"><input type="text" class="form-control" pattern="[A-Za-z]{}" name="ntitilecommentTxt" style="width: 100%;" id="ntitilecommentTxt" /></td>     
                                                                            <!--<td width="50" style="text-align: center;">
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile150" name="myfile150"  onchange="myFunction150(this.form.login_attempts, this);" />
                                                                            </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <button type="button"    id="title_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>
                                                                            </td>-->
                                                                        </tr>

                                                                        <tr>
                                                                            <td width="200"><B>BVN</B></td>
                                                                            <td  id="noemail" width="500"><%=oldBvNumber%> </td>
                                                                            <td  id="mnemail" width="500"></td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <!--<td width="50" style="text-align: center;">  

                                                                            </td>

                                                                            <td width="50" style="text-align: center;">
                                                                            </td>-->
                                                                        </tr>

                                                                        <tr>
                                                                            <td width="200"><B>Image</B></td>
                                                                            <td colspan="3"><img alt="bvnimage" src="<%=imageUrl%>" id="pics" width="200" height="200"/></td>
                                                                            <td  id="mnimage" width="500"></td>
                                                                            <!--<td  id="nnimage" width="500"></td>
                                                                            <td  id="nonimage" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  

                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                            </td>-->
                                                                        </tr> 



                                                                        <tr>
                                                                            <td width="200"><B>Transaction ID</B></td>
                                                                            <td  id="noemail" width="500"><%=transactionid%> </td>
                                                                            <td  id="mnemail" width="500"></td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <!--<td width="50" style="text-align: center;">  

                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   
                                                                            </td>-->
                                                                        </tr>                                                                        

                                                                        <tr>
                                                                            <td width="200"><B>Maker</B></td>
                                                                            <td  id="noemail" width="500"><%=userEmail%> </td>
                                                                            <td  id="mnemail" width="500"></td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <!--<td width="50" style="text-align: center;">  

                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                            </td>-->
                                                                        </tr>                                                                       

                                                                        <tr>
                                                                            <td width="200"><B>Branch</B></td>
                                                                            <td  id="noemail" width="500"><%=branchcode%> </td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <td width="50" style="text-align: center;">

                                                                            </td>

                                                                            <!--<td width="50" style="text-align: center;">   

                                                                            </td>-->
                                                                        </tr>

                                                                    </tbody>
                                                                </table>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

												<div class="row">                            
                                                    <div class="col-xs-12">
                                                        <div class="col-md-5"></div>
                                                        <!--<button   id="convert-table" type="submit" class="btn btn-primary">SUBMIT</button>-->
                                                        <div class="col-md-2">
                                                            <input type="submit" id="submit" name="submit" value="Submit" class="btn btn-primary"/>
                                                        </div>
                                                    </div> 
                                                </div>
												<br/>
											</div>  
											<br> 
										</div>
									</div>
								</div>
							</form>
						</div>
						<%@include file="foot.jsp"%>
						</body>
						</html>
