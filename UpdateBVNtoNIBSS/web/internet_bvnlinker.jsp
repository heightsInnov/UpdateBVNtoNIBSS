<%-- 
    Document   : testfile
    Created on : 17-Feb-2015, 15:47:26
    Author     : aajibade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" import="java.sql.*" errorPage="error.jsp"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.xml.bind.JAXBElement"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0117)https://uniononline.unionbankng.com/OnlineBanking/quickteller_billerspay.jsp?ref=D1A10EB1-1DD6-4289-AC6C-6D883591949C -->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr"><head profile="http://gmpg.org/xfn/11"><meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
            <title>Union Bank - BVN Linkage</title>
           
                <link rel="stylesheet" href="css/layout.css" type="text/css">
                    <link href="css/style.css" rel="stylesheet" type="text/css">
                        
                            <head>
                                <%@ include file="head.jsp"%>
                            </head>
                            <body id="top">
                                <link rel="stylesheet" type="text/css" href="css/style(1).css">
                                    <script type="text/javascript" src="css/jquery.js"></script>                                  
                                    <link href="css/style.css" rel="stylesheet" type="text/css">

                                        <div class="wrapper col3">
                                            <div id="mainintro">
                                                <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
                                                    <tbody><tr>

                                                            <td width="34%">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                    <tbody><tr>
                                                                            <td height="27"><div align="right" class="bluetext">BVN Linkage</div></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td class="textsmall"> <div align="right">
                                                                                    12 Oct 2015&nbsp;23:19:25 PM
                                                                                </div></td>
                                                                        </tr>
                                                                    </tbody></table></td></tr>
                                                    </tbody></table>
                                            </div>
                                        </div>
                                        <div class="wrapper col2">
                                            <div id="topbar">
                                                <div id="topnav">
                                                    <ul>
                                                        <li class="active"></li>

                                                        <li class="last"></li>

                                                    </ul>
                                                </div>
                                                <br class="clear">
                                            </div>
                                        </div>


                                        <div class="wrapper col3">
                                            <div id="intro">

                                                <table width="100%" border="0" cellpadding="5" cellspacing="5" class="border">
                                                    <tbody><tr>
                                                            <td><div align="center">
                                                                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                        <tbody><tr>
                                                                                <td><img src="images/spacer.gif" width="250" height="1"></td>
                                                                                <td><img src="images/spacer.gif" width="250" height="1"></td>
                                                                            </tr>
                                                                            <tr>
                                                                                <td valign="top">


                                                                                    <title>Untitled Document</title>
                                                                                    <link href="./Union Bank - Online Banking System_files/style.css" rel="stylesheet" type="text/css">
                                                                                        <link rel="stylesheet" type="text/css" href="./Union Bank - Online Banking System_files/sdmenu.css">
                                                                                            <script type="text/javascript" src="./Union Bank - Online Banking System_files/sdmenu.js">
                                                                                                /***********************************************
                                                                                                 * Slashdot Menu script- By DimX
                                                                                                 * Submitted to Dynamic Drive DHTML code library: http://www.dynamicdrive.com
                                                                                                 * Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
                                                                                                 ***********************************************/
                                                                                            </script>
                                                                                            <script type="text/javascript">
                                                                                                // <![CDATA[
                                                                                                var myMenu;
                                                                                                window.onload = function() {
                                                                                                    myMenu = new SDMenu("my_menu");
                                                                                                    myMenu.init();
                                                                                                };
                                                                                                // ]]>
                                                                                            </script>







                                                                                            </td>
                                                                                            <td valign="top"><table width="650" border="0" cellspacing="0" cellpadding="0">
                                                                                                    <tbody><tr>
                                                                                                            <td width="580" bgcolor="#0399AA" class="birborder"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                                                                                                                    <tbody><tr>

                                                                                                                            <td width="97%" class="textwhite"><div align="left">BVN Linking</div></td>
                                                                                                                        </tr>
                                                                                                                    </tbody></table></td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td>&nbsp;</td>
                                                                                                        </tr>
                                                                                                        <tr>
                                                                                                            <td valign="top" bgcolor="#F0F0F0" class="birborderunion"><table width="100%" border="0" cellspacing="10" cellpadding="10">

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
                                                                                                                    <tbody><tr>
                                                                                                                            <td bgcolor="#FFFFFF" class="birborderunion">
                                                                                                                                <form    name="form1" id="form1" action="processor.jsp" method="post">  
                                                                                                                                    <input type="hidden" name="command" value="int_bvnlink">
                                                                                                                                        <table width="100%" border="0" cellpadding="4" cellspacing="4">
                                                                                                                                            <tbody><tr>
                                                                                                                                                    <td bgcolor="#FF9933" class="textdark"><table width="100%" border="0" cellpadding="5" cellspacing="5" bgcolor="#FFFFFF" class="border">
                                                                                                                                                            <tbody><tr>
                                                                                                                                                                    <td bgcolor="#FFFFFF"><table width="100%" border="0" cellpadding="3" cellspacing="2" bgcolor="#FFFFFF">
                                                                                                                                                                            <tbody>

                                                                                                                                                                                <tr>
                                                                                                                                                                                    <td height="25" align="left" class="txtlightblu"><div align="right" id="bvnfield">Enter Account Number:</div></td>
                                                                                                                                                                                    <td bgcolor="#FFFFFF"><div align="left">
                                                                                                                                                                                            <input name="acctnum" type="text"  id="acctnum" maxlength="10"> 
                                                                                                                                                                                             <span class="txtred">*required</span></div></td>
                                                                                                                                                                                </tr>


                                                                                                                                                                            </tbody></table></td>
                                                                                                                                                                </tr>
                                                                                                                                                            </tbody></table></td>
                                                                                                                                                </tr>
                                                                                                                                                <tr>
                                                                                                                                                    <td valign="top" bgcolor="#FFFFFF" class="textdark"><span class="txtlightblu"><img src="images/spacer.gif" width="10" height="3"></span></td>
                                                                                                                                                </tr>

                                                                                                                                                <tr>
                                                                                                                                                    <td bgcolor="#F0F0F0" class="textdark"><span class="txtlightblu"><img src="images/spacer.gif" width="10" height="3"></span></td>
                                                                                                                                                </tr>

                                                                                                                                                <tr>
                                                                                                                                                    <td bgcolor="#FFFFFF" class="textdark"><div align="left">
                                                                                                                                                            <input name="Submit" type="submit" class="bbutton" value="Submit>>">
                                                                                                                                                                <input type="hidden" name="CSRF_TOKEN" value="4780250432969302143">
                                                                                                                                                                    <input type="hidden" name="paymentcode" id="paymentcode">
                                                                                                                                                                        <input name="ref" type="hidden" id="ref" value="D1A10EB1-1DD6-4289-AC6C-6D883591949C">
                                                                                                                                                                            <input type="hidden" name="consumerfieldvalue" id="consumerfieldvalue">
                                                                                                                                                                                <input type="hidden" name="productname" id="productname">
                                                                                                                                                                                    </div>
                                                                                                                                                                                    </td>
                                                                                                                                                                                    </tr>
                                                                                                                                                                                    </tbody></table>
                                                                                                                                                                                    </form>                          </td>
                                                                                                                                                                                    </tr>
                                                                                                                                                                                    </tbody></table></td>
                                                                                                                                                                                    </tr>

                                                                                                                                                                                    </tbody></table></td>
                                                                                                                                                                                    </tr>
                                                                                                                                                                                    <tr>
                                                                                                                                                                                        <td>&nbsp;</td>
                                                                                                                                                                                        <td>&nbsp;</td>
                                                                                                                                                                                    </tr>
                                                                                                                                                                                    </tbody></table>
                                                                                                                                                                                    </div></td>
                                                                                                                                                                                    </tr>
                                                                                                                                                                                    </tbody></table>
                                                                                                                                                                                    <p>&nbsp;</p>
                                                                                                                                                                                    <p><br class="clear">
                                                                                                                                                                                    </p>
                                                                                                                                                                                    </div>
                                                                                                                                                                                    </div>
                                                                                                                                                                                    <link href="css/style.css" rel="stylesheet" type="text/css">
                                                                                                                                                                                        <div class="wrapper col4"></div>
                                                                                                                                                                                        <div class="wrapper col5"></div>
                                                                                                                                                                                        


                                                                                                                                                                                        <%@ include file="foot1.jsp"%>

                                                                                                                                                                                        </body></html>