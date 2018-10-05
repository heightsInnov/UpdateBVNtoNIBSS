<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="error.jsp"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.xml.bind.JAXBElement"%>
<%@page import="java.util.List"%>

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

            <div class="nibss-full">
                <%@ include file="navbar.jsp"%>
                  <div class="container">
                    <div class="panel panel-default control-panel">
                        <div class="panel-body" style="background-color:#FBFBFB;" >
                            <form  id="mainForm" action="" method="post">  
                                <div   class="modal fade" id="approveDialog" tabindex="-1"    role="dialog" aria-labelledby="myModalLabel1" aria-hidden="true">
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
                                                                <input name="slanditf" type="text" id="slanditf"   class="  form-control" required="">

                                                            </div>
                                                        </div>
                                                        <div id="lvDetails_ctrl8_panDate" class="form-group">
                                                            <label class="col-md-4 cvontrol-label">New  Email</label>
                                                            <div class="col-md-8">
                                                                <input name="newemail1" type="text" id="newemail1" class="form-control" required="">

                                                            </div>

                                                        </div>

                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label">Comments</label>
                                                            <div class="col-md-8">
                                                                <textarea name="lvDetails$ctrl8$txtComments" rows="3" cols="20" id="lvDetails_ctrl8_txtComments" class="form-control"></textarea>
                                                            </div>
                                                        </div>


                                                    </div>
                                                </div>


                                            </div>

                                            <div class="modal-footer">

                                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                <button type="button" data-toggle="tooltip"  nibss-command="receivecomplete"  title="Complete transaction request" class="btn btn-success nibss-detail-link"><span class="glyphicon glyphicon-ok"></span> <strong> SUBMIT</strong></button>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="tab-content form-horizontal">
                                    <div id="sectionA" class="tab-pane fade in active">
                                        <div class="form-horizontal">
                                            <div class="col-sm-6">
                                                <h4>Info:</h4>
                                                <div class="row">
                                                    <div class="col-xs-12">
                                                        <div class="table-responsive">
                                                            <div id="upDetails">

                                                                <table class="table preview-table">
                                                                    <tbody> 

                                                                        <tr>
                                                                            <td width="350"><B>Email</B></td>
                                                                            <td width="500">unwanyanwu@nibss.com </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDels_ctrl2_btnEdit"   data-toggle="modal"      data-target="#approveDialog"    nibss-action= "unwanyanwu@nibss.com" data-toggle="tooltip"  href=""><span class="glyphicon glyphicon-pencil"></span></a>

                                                                            </td>



                                                                            <td width="350"><B>First Name</B></td>
                                                                            <td width="500">Uchenna </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>

                                                                            <td width="350"><B>Gender</B></td>
                                                                            <td width="500">Female </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>

                                                                            <td width="350"><B>Gender</B></td>
                                                                            <td width="500">Female </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>



                                                                        </tr>

                                                                        <tr>
                                                                            <td width="350"><B>Last Name</B></td>
                                                                            <td width="500">Nwanyanwu </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>
                                                                            <td width="350"><B>Level Of Account</B></td>
                                                                            <td width="500">Level 1 - Low Level Accounts </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>
                                                                            <td width="350"><B>Lga Of Origin</B></td>
                                                                            <td width="500">Owerri-South </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>

                                                                            <td width="350"><B>Gender</B></td>
                                                                            <td width="500">Female </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>



                                                                        </tr>
                                                                        <tr>
                                                                            <td width="350"><B>Lga Of Residence</B></td>
                                                                            <td width="500">Eti-Osa </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>

                                                                            <td width="350"><B>Marital Status</B></td>
                                                                            <td width="500">Married </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>


                                                                            <td width="350"><B>Middle Name</B></td>
                                                                            <td width="500">Innocent </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>
                                                                            <td width="350"><B>Gender</B></td>
                                                                            <td width="500">Female </td>
                                                                            <td width="50" style="text-align: center;">
                                                                                <a id="lvDetails_ctrl2_btnEdit"  data-toggle="modal"    data-target="#approveDialog"   nibss-action= "" data-toggle="tooltip" title="Approve Payment Schedule" href="javascript:__doPostBack(&#39;lvDetails$ctrl2$btnEdit&#39;,&#39;&#39;)"><span class="glyphicon glyphicon-pencil"></span></a>
                                                                            </td>


                                                                        </tr>


                                                                    </tbody>
                                                                </table>

                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">                            

                                                    <div class="col-md-4 col-sm-4 col-xm-12" style="padding-top:20px">

                                                        <button type="submit" class="btn btn-primary">SUBMIT</button>
                                                    </div> 

                                                </div> 



                                            </div>  
                                            <br>  






                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>

                        <script>
                            function myFunction() {
                                document.getElementById("slanditf").innerHTML = "Hello World";
                            }
                        </script>
                        <%@ include file="foot.jsp"%>
                        </body>
                        </html>
