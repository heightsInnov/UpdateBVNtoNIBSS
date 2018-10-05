<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jsp"%>

        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrap">
            <div class="modal fade" id="pitchDialog" tabindex="-1" role="dialog" aria-labelledby="myModalTitle" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalTitle"></h4>
                        </div>
                        <div class="modal-body">
                            <!--div align="center"><img src="img/loading.gif" alt="Loading..."> &nbsp;&nbsp;&nbsp;<strong>Loading supporting document list. Please wait...</strong>		</div-->
                            <div id="pitchDialogBody" class="table-responsive">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="nibss-full">
                <%@ include file="navbar2.jsp"%>

                <br>

                <%

                    String isContainEst = (String) session.getAttribute("msg-info-signin");
                    System.out.println("isContainEst first pick <<>." + isContainEst);
                    if (isContainEst == null) {
                        isContainEst = "";
                    }
                    session.setAttribute("msg-info-signin", "");
                    if (!isContainEst.equals("")) {
                        System.out.println("in serverive :::yes greater tthan zero<<>>" + isContainEst);
                %>
                <div class="alert alert-danger text-center alert-dismissable sticky"><button class="close" aria-hidden="true" data-dismiss="alert" type="button">&times;</button><h4><%=isContainEst%></h4></div>
                <%                    } else {
                        System.out.println("in serverive :::No lesser tthan zero<<>>" + isContainEst);
                    }
                %>

                <div class="container">
                    <div class="panel panel-default control-panel"  >

                        <div class="panel panel-default control-panel" >
                            <div class="panel-heading" style="margin-bottom:0px;">
                                <div class="row">
                                    <%@ include file="operator_navBar2.jsp"%>
                                    <br>

                                    <div class="col-md-4 col-sm-4 col-xm-12">
                                        <span class="text-right"><h3 style="margin-bottom:0px;margin-top:5px">BVN LINKING</h3></span>
                                    </div>
                                </div>
                            </div>
                        </div> 

                        <div class="panel-body" style="background-color:#FBFBFB; height:300px " >                             
                                    <form    name="form1" id="form1"  action="processor.jsp" method="post">  
                                    <input type="hidden" name="command" value="bvnlink">
                                    <div class="row">
                                        <div class="col-md-4 col-sm-4 col-xm-12">                                
                                            <div class="form-group">
                                                <label for="bvnfield">Enter Biometric Verification Number </label>
                                                <input type="text" class="form-control"  name ="bvnfield" id="bvnfield" maxlength="11" placeholder="Enter Biometric Verification Number" required>
                                            </div>                                
                                        </div>   

                                        <div class="col-md-4 col-sm-4 col-xm-12">                                
                                            <div class="form-group">
                                                <label for="NewGender">Bank Name </label>                                             
                                                <select class="form-control"  name="menu1" id="menu1" required>
                                                    <option value=""> - Select a Saved Payment Details - </option>
                                                    <option value="044">ACCESS BANK PLC</option>
                                                    <option value="401">ASO SAVINGS AND LOANS</option>
                                                    <option value="001">CENTRAL BANK OF NIGERIA</option>
                                                    <option value="063">DIAMOND BANK PLC</option>
                                                    <option value="050">ECOBANK NIGERIA PLC</option>
                                                    <option value="084">ENTERPRISE BANK</option>
                                                    <option value="309">FBN MOBILE</option>
                                                    <option value="070">FIDELITY BANK PLC</option>
                                                    <option value="085">FINBANK PLC</option>
                                                    <option value="011">FIRST BANK OF NIGERIA PLC</option>
                                                    <option value="214">FIRST CITY MONUMENT BANK PLC</option>
                                                    <option value="601">FSDH MERCHANT BANK LIMIT</option>
                                                    <option value="030">HERITAGE BANK </option>
                                                    <option value="301">JAIZ BANK PLC</option>
                                                    <option value="402">JUBILEE LIFE MORTGAGE BANK</option>
                                                    <option value="082">KEYSTONE BANK</option>
                                                    <option value="014">MAINSTREET BANK</option>
                                                    <option selected="selected" value="907">NIGERIA INTERBANK SETTLEMENT SYSTEM</option>
                                                    <option value="023">NIGERIA INTERNATIONAL BANK (CITIGROUP)</option>
                                                    <option value="056">OCEANIC BANK INTERNATIONAL PLC</option>
                                                    <option value="327">PAGATECH</option>
                                                    <option value="305">PAYCOM</option>
                                                    <option value="076">SKYE BANK PLC</option>
                                                    <option value="221">STANBIC IBTC BANK PLC</option>
                                                    <option value="304">STANBIC MOBILEMONEY</option>
                                                    <option value="068">STANDARD CHARTERED BANK NIGERIA LTD</option>
                                                    <option value="232">STERLING BANK PLC</option>
                                                    <option value="523">TRUSTBOND MORTGAGE BANK</option>
                                                    <option value="032">UNION BANK OF NIGERIA PLC</option>
                                                    <option value="033">UNITED BANK FOR AFRICA PLC</option>
                                                    <option value="215">UNITY BANK PLC</option>
                                                    <option value="035">WEMA BANK PLC</option>
                                                    <option value="057">ZENITH BANK PLC</option>                                
                                                </select>
                                            </div>
                                        </div>  

                                        <div class="col-md-4 col-sm-4 col-xm-12" style="padding-top:20px">
                                            <button type="submit" class="btn btn-primary">Go</button>
                                        </div>               

                                    </div>


                                </form>


                        </div>
                    </div>
                </div>


            </div>

            <%@ include file="foot.jsp"%>
    </body>
</html>
