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
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">Pending List</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div>    

                        <div class="panel-body" style="background-color:#FBFBFB;height:650px" >



                            <div class="table-responsive">
                                <table  id="test"  class="table table-striped table-bordered">
                                    <thead class="bg-info">
                                        <tr>     
                                            <th class="text-right">REQUEST ID</th>
                                            <th class="text-right">BVNUMBER</th>
                                            <th class="text-right">OLD FIRST NAME</th>
                                            <th class="text-right">OLD LAST NAME</th>
                                            <th class="text-right">DATE OF BIRTH</th>
                                            <th class="text-right">REQUEST DATE</th>


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
                                            String bvn = "", oldfirstName = "", oldLastName = "", dateOfBirth = "", requestDate = "";
                                            String requestID="";
                                            List<TransactionsDAO> tTransactionsList = null;
                                            Processor pp = new Processor();
                                            try {
                                                tTransactionsList = pp.getPendingList("N");
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            System.out.println("tTransactionsList  ????<<>>>" + tTransactionsList);

                                            if (tTransactionsList.isEmpty()) {
                                            }
                                            if (tTransactionsList != null) {
                                                String authstatus = "", disableStatus = "";
                                                for (TransactionsDAO data2 : tTransactionsList) {
                                                    requestID=data2.getRequestID();
                                                    bvn = data2.getBvNumber();
                                                    oldfirstName = data2.getOldFirstName();
                                                    oldLastName = data2.getOldLastName();
                                                    dateOfBirth = data2.getOldDateOfBirth();
                                                    requestDate = data2.getRecieveDate();
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
                                                    if (requestID == null) {
                                                        requestID = "";
                                                    }


                                        %>
                                        <tr>
                                             <td class="text-right">  <%=requestID%> </td>                                                
                                            <td class="text-right">  <%=bvn%> </td>                                                
                                            <td class="text-right">  <%=oldfirstName%> </td>
                                            <td class="text-right"> <%=oldLastName%></td>                                               
                                            <td class="text-right"> <%=dateOfBirth%></td>
                                            <td class="text-right"> <%=requestDate%></td>                                                


                                        </tr>
                                        <% }
                                            }
                                        %>


                                    </tbody>
                                </table>

                            </div>   
                            <div class="col-md-4 col-sm-4 col-xm-12" style="padding-top:20px">


                            </div>          

                        </div>
                    </div>
                </div>
            </div>


        </div>


        <%@ include file="tfoot.jsp"%>


    </body>
</html>
