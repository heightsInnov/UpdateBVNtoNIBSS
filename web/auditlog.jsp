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
<%@page import="com.unionbank.webpay.db.dao.AuditDAO"%>

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
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">Audit Log</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div>    

                        <div class="panel-body" style="background-color:#FBFBFB; " >


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
                                                <th class="text-right">AUDIT CODE</th>
                                                <th class="text-right">USER ID</th>
                                                <th class="text-right">DISPLAY NAME </th>
                                                <!--th class="text-right">DEPARTMENT</th>-->
                                                <th class="text-right">EMPLOYEE ID</th>
                                                <th class="text-right">LAST NAME</th>
                                                <th class="text-right">FIRST NAME</th>
                                                
                                                <th class="text-right">MOBILE PHONE</th>
                                                <!--th class="text-right">DATE TIME</th>-->
       </tr>
                                        </thead>
                                        <tfoot class="bg-info">
                                        </tfoot>
                                        <tbody> 

                                            <%

                                                String auditDesc = "", branchcode = "",
                                                        dateTime = "", branchname = "",
                                                        firstName = "", gradeLevel = "",
                                                        mobileNumber = "";
                                                String requestId = "", userId = "", address = "",
                                                        department = "",
                                                        displayName = "",
                                                        employeeId = "",
                                                        lastName = "",
                                                        telephone = "",
                                                        initial = "";
                                                List<AuditDAO> tTransactionsList = null;
                                                Processor pp = new Processor();
                                                try {
                                                    tTransactionsList = pp.getAuditLog();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                System.out.println("tTransactionsList  ????<<>>>" + tTransactionsList);

                                                if (tTransactionsList != null) {
                                                    String authstatus = "", disableStatus = "";
                                                    for (AuditDAO data2 : tTransactionsList) {
                                                      System.out.println("data2.getRequestId()  " + data2.getRequestId());                                                           
                                                        auditDesc = data2.getAuditDesc();
                                                        if (auditDesc==null){
                                                            auditDesc="";
                                                        }
                                                        branchcode = data2.getBranchcode();
                                                        if (branchcode==null){
                                                            branchcode="";
                                                        }
                                                        branchname = data2.getBranchname();
                                                        if (branchname==null){
                                                            branchname="";
                                                        }
                                                        dateTime = data2.getDateTime();
                                                        if (dateTime==null){
                                                            dateTime="";
                                                        }
                                                        firstName = data2.getFirstName();
                                                        if (firstName==null){
                                                            firstName="";
                                                        }
                                                        gradeLevel = data2.getGradeLevel();
                                                        if (gradeLevel==null){
                                                            gradeLevel="";
                                                        }
                                                        mobileNumber = data2.getModileNumber();
                                                         if (mobileNumber==null){
                                                            mobileNumber="";
                                                        }
                                                        requestId = data2.getRequestId();
                                                         if (requestId==null){
                                                            requestId="";
                                                        }
                                                        userId = data2.getUserId();
                                                         if (userId==null){
                                                            userId="";
                                                        }
                                                        address = data2.gettAddress();
                                                        if (address==null){
                                                            address="";
                                                        }
                                                        department = data2.gettDepartment();
                                                        if (department==null){
                                                            department="";
                                                        }
                                                        displayName = data2.gettDisplayName();
                                                         if (displayName==null){
                                                            displayName="";
                                                        }
                                                        employeeId = data2.gettEmployeeId();
                                                        if (employeeId==null){
                                                            employeeId="";
                                                        }
                                                        lastName = data2.gettLastName();
                                                        if (lastName==null){
                                                            lastName="";
                                                        }
                                                        telephone = data2.gettTelephone();
                                                         if (telephone==null){
                                                            telephone="";
                                                        }
                                                        initial = data2.gettInitial();

                                                        if (initial==null){
                                                            initial="";
                                                        }
                                                        /*  <th class="text-right">REQUEST ID</th>
                                                         <th class="text-right">AUDIT DESC</th>
                                                         <th class="text-right">USER ID</th>
                                                         <th class="text-right">DISPLAY NAME </th>
                                                         <th class="text-right">DEPARTMENT</th>
                                                         <th class="text-right">EMPLOYEE ID</th>
                                                         <th class="text-right">LAST NAME</th>
                                                         <th class="text-right">FIRST NAME</th>
                                                         <th class="text-right">TELEPHONE</th>
                                                         <th class="text-right">TELEPHONE</th>
                                                         <th class="text-right">MOBILE PHONE</th>
                                                         <th class="text-right">DATE TIME</th>*/


                                            %>
                                            <tr>
                                                <td class="text-right">  <%=requestId%> </td>    
                                                <td class="text-right">  <%=auditDesc%> </td>                                                
                                                <td class="text-right">  <%=userId%> </td>
                                                <td class="text-right">  <%=displayName%></td>                                               
                                                <!--td class="text-right">  <!--%=department%></td>-->
                                                <td class="text-right">  <%=employeeId%></td> 
                                                <td class="text-right">  <%=lastName%> </td>
                                                <td class="text-right">  <%=firstName%></td>                                               
                                                
                                                <td class="text-right">  <%=mobileNumber%></td>     
                                                <!--td class="text-right">  <!--%=dateTime%></td>-->     



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


        </div>


        <%@ include file="tfoot.jsp"%>


    </body>
</html>
