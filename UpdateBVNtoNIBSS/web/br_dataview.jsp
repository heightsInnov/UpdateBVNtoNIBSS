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


            <%
                String oldBvNumber = "";
                String oldFirstName = "";
                String oldMiddleName = "";
                String oldLastName = "";
                String oldDateOfBirth = "";
                String oldPhoneNumber = "";
                String oldEmailAdd = "";
                TransactionsDAO mert = (TransactionsDAO) session.getAttribute("mert");

                String transactionid = (String)request.getAttribute("transactionid");
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
                    oldFirstName = mert.getOldFirstName();
                    oldLastName = mert.getOldLastName();
                    oldMiddleName = mert.getOldMiddleName();
                    oldDateOfBirth = mert.getOldDateOfBirth();
                    oldPhoneNumber = mert.getOldPhoneNumber();
                    oldEmailAdd = mert.getOldEmailAdd();

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("got here no return<<>>>" + mert);
                }


                if (oldBvNumber == null) {
                    oldBvNumber = "";
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
                if (oldBvNumber.equals("")) {
                    session.setAttribute("msg-info-signin", "Invalid BVN");
                    response.sendRedirect("bvn_verification.jsp");
                }
                
                UserProfile ursPpee = (UserProfile) session.getAttribute("Urs");
                        String DisplayName = "", Depts = "",branchcode="";
                        
                        
                        try {
                            DisplayName = ursPpee.getDisplayName().getValue();
                            branchcode=ursPpee.getBranchCode().getValue();
                            System.out.println("getEmployeeId<<>> " + ursPpee.getEmployeeId().getValue());
                            System.out.println("getBranchCode<<>> " + ursPpee.getBranchCode().getValue());
                           // Depts = ursPpee.getDepartment().getValue();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                       
                        if (DisplayName== null){
                            DisplayName="";
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
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">BVN Data Update</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="panel-body" style="background-color:#FBFBFB;" >                            

                            <form  id="uploadfl"  method="post" action="UploadServlet"    enctype="multipart/form-data">
                                <input type="hidden" name="bvnumber" value="<%= oldBvNumber%>">
                                  <input type="hidden" name="markerid" value="<%= DisplayName%>">
                                  <input type="hidden" name="branchcode" value="<%=branchcode%>">
                                
                                  
                                <input type="hidden"  id="firstnamefile" name="firstnamefile" value="">
                                <input type="hidden"  id="middlenamefile" name="middlenamefile" value="">
                                <input type="hidden"  id="lastnamefile" name="lastnamefile" value="">
                                <input type="hidden"  id="dobfile" name="dobfile" value="">
                                <input type="hidden"  id="phonenofile" name="phonenofile" value="">
                                <input type="hidden"  id="emailfile" name="emailfile" value="">
                                
                                <input type="hidden" id="login_attempts" name="login_attempts" value="">
                                <input type="hidden" id="transactionid" name="transactionid" value='<%=transactionid%>'>
                                
                                <%@ include file="t_emailpopup.jsp"%>
                                <%@ include file="t_phonepopup.jsp"%>
                                <%@ include file="t_dobpup.jsp"%>
                                <%@ include file="t_lastnmpup.jsp"%>
                                <%@ include file="t_middlenamempup.jsp"%>
                                <%@ include file="t_firstnamempup.jsp"%>
                                <div class="tab-content form-horizontal">
                                    <div id="sectionA" class="tab-pane fade in active">
                                        <div class="form-horizontal">
                                            <div class="col-xs-12">

                                                <div class="row">
                                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                                        <div class="form-group">
                                                            <label for="firstName">BVN: <%= oldBvNumber%></label>
                                                            <p id="demo"></p>

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
                                                                            <th  width="30%" class= "text-left">Field </th>
                                                                            <th width="50%" class="text-left">OldValue</th>
                                                                            <th width="50%" class="text-left">NewValue</th>
                                                                            <th width="50%" class="text-left">Comment</th>
                                                                            <th width="50%" class="text-left">Fileupload</th>

                                                                            <th class="text-left">Edit</th>

                                                                        </tr>
                                                                    </thead>
                                                                    <tbody> 
                                                                        <tr>
                                                                            <td width="350"><B>First Name</B></td>

                                                                            <td  id="ofirstname" width="500"><%= oldFirstName%> </td>
                                                                            <td  id="nfirstname" width="500"></td>
                                                                            <td  id="first_comment" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile" name="myfile"   onchange="myFunction(this.form.login_attempts,this);" />



                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="firstname_btnLaunch"   class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>
                                                                        </tr>

                                                                        <tr>
                                                                            <%
                                                                                //mert.getFirstName()
%>
                                                                            <td width="350"><B>Middle Name</B></td>
                                                                            <td  id="omiddlename" width="500"><%=oldMiddleName%> </td>
                                                                            <td  id="nmiddlename" width="500"></td>
                                                                            <td  id="middlename_comment" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile1" name="myfile1"  onchange="myFunction1(this.form.login_attempts,this);" />

                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="middlename_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>
                                                                        </tr>
                                                                        <tr>

                                                                            <td width="350"><B>Last Name</B></td>
                                                                            <td  id="olastname" width="500"><%= oldLastName%> </td>
                                                                            <td  id="nlastname" width="500"></td>
                                                                            <td  id="lastname_comment" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                 <input type="file"   id="myfile22" name="myfile22"  onchange="myFunction2(this.form.login_attempts,this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="lastname_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>
                                                                        </tr>
                                                                        <tr>

                                                                            <td width="350"><B>Date Of Birth</B></td>
                                                                            <td  id="odateofbirth" width="500"><%= oldDateOfBirth%></td>
                                                                            <td  id="ndateofbirth" width="500"></td>
                                                                            <td  id="dateofbirth_comment" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                <input type="file"   id="myfile33" name="myfile33"  onchange="myFunction3(this.form.login_attempts,this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="dateofbirth_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>
                                                                        </tr>

                                                                        <tr>
                                                                            <%

                                                                            %>
                                                                            <td width="350"><B>Phone Number</B></td>
                                                                            <td  id="ophonenumber" width="500"><%=oldPhoneNumber%></td>
                                                                            <td  id="nphonenumber" width="500"></td>
                                                                            <td  id="phonenumber_comment" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                 <input type="file"   id="myfile44" name="myfile44"  onchange="myFunction4(this.form.login_attempts,this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="phonenumber_btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="350"><B>Email</B></td>
                                                                            <td  id="oemail" width="500"><%=oldEmailAdd%> </td>
                                                                            <td  id="nemail" width="500"></td>
                                                                            <td  id="email_comment" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                                <label class="control-label">Select File</label>
                                                                                 <input type="file"   id="myfile55" name="myfile55"  onchange="myFunction5(this.form.login_attempts,this);" />
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                                <button type="button"    id="btnLaunch" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></button>

                                                                            </td>
                                                                        </tr>
                                                                        
                                                                        <tr>
                                                                            <td width="350"><B>BVN</B></td>
                                                                            <td  id="noemail" width="500"><%=oldBvNumber%> </td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                               
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                               

                                                                            </td>
                                                                        </tr>
                                                                         <tr>
                                                                            <td width="350"><B>Transaction ID</B></td>
                                                                            <td  id="noemail" width="500"><%=transactionid%> </td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                               
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                               

                                                                            </td>
                                                                        </tr>
                                                                        
                                                                        <tr>
                                                                            <td width="350"><B>Maker</B></td>
                                                                            <td  id="noemail" width="500"><%=DisplayName%> </td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                               
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                               

                                                                            </td>
                                                                        </tr>
                                                                        
                                                                        <tr>
                                                                            <td width="350"><B>Branch</B></td>
                                                                            <td  id="noemail" width="500"><%=branchcode%> </td>
                                                                            <td  id="nnemail" width="500"></td>
                                                                            <td  id="nonexist" width="500"></td>
                                                                            <td width="50" style="text-align: center;">  
                                                                               
                                                                            </td>

                                                                            <td width="50" style="text-align: center;">   

                                                                               

                                                                            </td>
                                                                        </tr>

                                                                    </tbody>
                                                                </table>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">                            

                                                    <div class="col-xs-12">

                                                        <button   id="convert-table" type="submit" class="btn btn-primary">SUBMIT</button>
                                                    </div> 

                                                </div> 



                                            </div>  
                                            <br>  






                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>

                        <%@ include file="foot.jsp"%>

                        </body>
                        </html>
