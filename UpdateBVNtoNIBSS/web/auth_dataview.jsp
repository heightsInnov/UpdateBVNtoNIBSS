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
<%@page import="com.unionbank.core.Processor"%>
<%@page import="com.unionbank.webpay.db.dao.fileUploadData"%>


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
                String firstFirstName = "";
                String firstNameComment = "";

                String oldMiddleName = "";
                String oldLastName = "";
                String oldDateOfBirth = "";
                String oldPhoneNumber = "";
                String oldEmailAdd = "", newmiddleName = "", middleComment = "",
                        newLastName = "", lastnameComment = "", newDateOfBirth = "", commentDOB = "", newphoneNumber = "", phoneComment = "";
                String newemailadd = "", emailcomment = "", requestID = "";


                List<TransactionsDAO> mert = (List<TransactionsDAO>) session.getAttribute("mert");


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




                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("got here no return<<>>>" + mert);
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

                //  

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

                if (oldBvNumber.equals("")) {
                    session.setAttribute("msg-info-signin", "Invalid BVN");
                    response.sendRedirect("authurizer_pendinglist.jsp");
                }
                //requestID

                String firstnamefile = "" , middlenamefile = "", lastnamefile = "",
                        dobfile = "", phonenofile = "", emailfile = "";
                System.out.println("requestID check<<>." + requestID);
                 Processor pb = new Processor();
                try {
                    fileUploadData ddfirstname = new fileUploadData();
                    ddfirstname = pb.getparameter("firstnamefile", requestID);
                    firstnamefile = ddfirstname.getUrlID();
                    if (firstnamefile == null) {
                        firstnamefile = "";
                    }                                        
                    System.out.println("firstnamefile check<<>." + firstnamefile);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("got here no return<<>>>" + mert);
                }
                
                try {
                    fileUploadData ddmiddlenamefile = new fileUploadData();
                    ddmiddlenamefile = pb.getparameter("lastnamefile", requestID);
                    lastnamefile = ddmiddlenamefile.getUrlID();
                    if (lastnamefile == null) {
                        lastnamefile = "";
                    }                                        
                    System.out.println("lastnamefile check<<>." + lastnamefile);
                } catch (Exception e) {
                    e.printStackTrace();                    
                }
                
                try {
                    fileUploadData dddobfile = new fileUploadData();
                    dddobfile = pb.getparameter("dobfile", requestID);
                    dobfile = dddobfile.getUrlID();
                    if (dobfile == null) {
                        dobfile = "";
                    }                                        
                    System.out.println("dobfile check<<>." + dobfile);
                } catch (Exception e) {
                    e.printStackTrace();                    
                }
                
                 try {
                    fileUploadData ddphonenofile = new fileUploadData();
                    ddphonenofile = pb.getparameter("phonenofile", requestID);
                    phonenofile = ddphonenofile.getUrlID();
                    if (phonenofile == null) {
                        phonenofile = "";
                    }                                        
                    System.out.println("phonenofile check<<>." + phonenofile);
                } catch (Exception e) {
                    e.printStackTrace();                    
                }
               
                
                 try {
                    fileUploadData ddlastnamefile = new fileUploadData();
                    ddlastnamefile = pb.getparameter("middlenamefile", requestID);
                    middlenamefile = ddlastnamefile.getUrlID();
                    if (middlenamefile == null) {
                        middlenamefile = "";
                    }                                        
                    System.out.println("middlenamefile check<<>." + middlenamefile);
                } catch (Exception e) {
                    e.printStackTrace();                    
                }
                 
                 try {
                    fileUploadData ddemailfile = new fileUploadData();
                    ddemailfile = pb.getparameter("emailfile", requestID);
                    emailfile = ddemailfile.getUrlID();
                    if (emailfile == null) {
                        emailfile = "";
                    }                                        
                    System.out.println("emailfile check<<>." + emailfile);
                } catch (Exception e) {
                    e.printStackTrace();                    
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
                                    <%@ include file="Admin_navBar.jsp"%>
                                    <br>

                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">BVN Data Update</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="panel-body" style="background-color:#FBFBFB;" >
                            <form id="mainForm" role="form" method="post" action="processor.jsp">
                                <input type="hidden" name="serviceopt" id="serviceopt" value="">
                                <input type="hidden" name="command" id="command" value=""> 
                                <input type="hidden" name="action" id="action" value=""> 
                                <input type="hidden" name="nibss-id" id="nibss-id" value="">
                                <input type="hidden" name="sendamount" id="sendamount" value="">
                                <input type="hidden" name="destcurrency" id="destcurrency" value="">

                                <input type="hidden"  id="firstnamefile" name="firstnamefile" value="<%=firstnamefile%>">
                                <input type="hidden"  id="middlenamefile" name="middlenamefile" value="<%=middlenamefile%>">

                                <input type="hidden"  id="lastnamefile" name="lastnamefile" value="<%=lastnamefile%>">
                                <input type="hidden"  id="dobfile" name="dobfile" value="<%=dobfile%>">
                                <input type="hidden"  id="phonenofile" name="phonenofile" value="<%=phonenofile%>">
                                 <input type="hidden"  id="emailfile" name="emailfile" value="<%=emailfile%>">
                                
                                <%
                                
                                // String firstnamefile = "" , middlenamefile = "", lastnamefile = "", 
                                    //dobfile = "", phonenofile = "", emailfile = "";
                                %>
                                <input type="hidden" name="bvnumber" value="<%= oldBvNumber%>">

                                <div class="tab-content form-horizontal">
                                    <div id="sectionA" class="tab-pane fade in active">
                                        <div class="form-horizontal">
                                            <div class="col-xs-12">

                                                <div class="row">


                                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                                        <div class="form-group">
                                                            <label for="firstName">REQUEST ID:  <%= requestID%></label>

                                                        </div>                                                           


                                                    </div>
                                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                                        <div class="form-group">
                                                            <label for="firstName">BVN: <%= oldBvNumber%></label>

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



                                                                        </tr>
                                                                    </thead>
                                                                    <tbody> 
                                                                        <tr>
                                                                            <td width="350"><B>First Name</B></td>

                                                                            <td  id="ofirstname" width="500"><%= oldFirstName%> </td>
                                                                            <td  id="nfirstname" width="500">  <%= firstFirstName%></td>
                                                                            <td  id="first_comment" width="500"> <%= firstNameComment%> </td>
                                                                            <td  id="first_comment" width="500">
                                                                                <% if (!firstnamefile.equals("")) {
                                                                                %>
                                                                                <a href="DownloadFileServlet?filename=<%=firstnamefile%>"   data-toggle="tooltip" title="Select sender prefered service option">Download</a>

                                                                                <%                                                                                        }
                                                                                %>                                                                                                                                                         
                                                                            </td>


                                                                        </tr>

                                                                        <tr>
                                                                            <%
                                                                                //,newmiddleName="",middleComment="";
%>
                                                                            <td width="350"><B>Middle Name</B></td>
                                                                            <td  id="omiddlename" width="500"><%=oldMiddleName%> </td>
                                                                            <td  id="nmiddlename" width="500"><%=newmiddleName%></td>
                                                                            <td  id="middlename_comment" width="500"><%=middleComment%></td>
                                                                            <td  id="first_comment" width="500">
                                                                                <% if (!middlenamefile.equals("")) {
                                                                                %>
                                                                                <a href="DownloadFileServlet?filename=<%=middlenamefile%>"   data-toggle="tooltip" title="Select sender prefered service option">Download</a>

                                                                                <%                                                                                        }
                                                                                %>                                                                                                                                                         
                                                                            </td>

                                                                        </tr>
                                                                        <tr>

                                                                            <td width="350"><B>Last Name</B></td>
                                                                            <td  id="olastname" width="500"><%= oldLastName%> </td>
                                                                            <td  id="nlastname" width="500"><%= newLastName%></td>
                                                                            <td  id="lastname_comment" width="500"><%= lastnameComment%></td>
                                                                            <td  id="first_comment" width="500">
                                                                                <% if (!lastnamefile .equals("")) {
                                                                                %>
                                                                                <a href="DownloadFileServlet?filename=<%=lastnamefile %>"   data-toggle="tooltip" title="Select sender prefered service option">Download</a>

                                                                                <%                                                                                        }
                                                                                %>                                                                                                                                                         
                                                                            </td>

                                                                        </tr>
                                                                        <tr>

                                                                            <td width="350"><B>Date Of Birth</B></td>
                                                                            <td  id="odateofbirth" width="500"><%= oldDateOfBirth%></td>
                                                                            <td  id="ndateofbirth" width="500"><%= newDateOfBirth%></td>
                                                                            <td  id="dateofbirth_comment" width="500"><%= commentDOB%></td>
                                                                          <td  id="first_comment" width="500">
                                                                                <% if (!dobfile.equals("")) {
                                                                                %>
                                                                                <a href="DownloadFileServlet?filename=<%=dobfile%>"   data-toggle="tooltip" title="Select sender prefered service option">Download</a>

                                                                                <%                                                                                        }
                                                                                %>                                                                                                                                                         
                                                                            </td>

                                                                        </tr>

                                                                        <tr>
                                                                            <%
                                                                                //newphoneNumber="",  phoneComment="";
%>
                                                                            <td width="350"><B>Phone Number</B></td>
                                                                            <td  id="ophonenumber" width="500"><%=oldPhoneNumber%></td>
                                                                            <td  id="nphonenumber" width="500"><%=newphoneNumber%></td>
                                                                            <td  id="phonenumber_comment" width="500"><%=phoneComment%></td>
                                                                           <td  id="first_comment" width="500">
                                                                                <% if (!phonenofile.equals("")) {
                                                                                %>
                                                                                <a href="DownloadFileServlet?filename=<%=phonenofile%>"   data-toggle="tooltip" title="Select sender prefered service option">Download</a>

                                                                                <%                                                                                        }
                                                                                %>                                                                                                                                                         
                                                                            </td>

                                                                        </tr>
                                                                        <tr>

                                                                            <td width="350"><B>Email</B></td>
                                                                            <td  id="oemail" width="500"><%=oldEmailAdd%> </td>
                                                                            <td  id="nemail" width="500"><%=newemailadd%></td>
                                                                            <td  id="phonenumber_comment" width="500"><%=phoneComment%></td>
                                                                           <td  id="first_comment" width="500">
                                                                                <% if (!emailfile.equals("")) {
                                                                                %>
                                                                                <a href="DownloadFileServlet?filename=<%=emailfile%>"   data-toggle="tooltip" title="Select sender prefered service option">Download</a>

                                                                                <%                                                                                        }
                                                                                %>                                                                                                                                                         
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
                                                        <td class="text-left"><button type="button"   onclick=" document.forms[0].elements['destcurrency'].value = '<%=requestID%>';                return true;" nibss-action= "<%=requestID%>" data-toggle="modal" data-target="#approveDialog"  data-toggle="tooltip" title="Approve BVN Update Request" class="btn btn-success btn-sm" ><span class="glyphicon glyphicon-send"></span> <strong>APPROVE /REJECT</strong></button></td>

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

                                        <form id="mainForm2" role="form">
                                            <div class="row">                            
                                                <div class="col-md-4 col-sm-4 col-xm-12">                                
                                                    <div class="form-group">
                                                        <label for="comment"> Authorizer Comment</label>
                                                        <textarea  class="form-control" id="commentt"  rows="6"  name="comment"  required  placeholder="Comment"  >  </textarea>
                                                    </div>                                
                                                </div>  


                                            </div> 
                                        </form>


                                    </div>
                                    <div class="modal-footer">
                                        <button type="button"  data-toggle="tooltip"   nibss-command="approvesend"  title="Approve transaction request" class="btn btn-success nibss-detail-link"><span class="glyphicon glyphicon-ok"></span> <strong>APPROVE TRANSACTION</strong></button>
                                        <button type="button" data-toggle="tooltip"   nibss-command="rejectsend"  title="Reject transaction request" class="btn btn-success nibss-detail-link"><span class="glyphicon glyphicon-ok"></span> <strong>REJECT TRANSACTION</strong></button>


                                    </div>
                                </div>
                            </div>
                        </div>
                        <%@ include file="foot.jsp"%>
                        </body>
                        </html>
