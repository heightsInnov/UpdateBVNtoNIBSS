



<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.unionbank.core.Processor"%>
<%@page import="com.unionbank.webpay.db.dao.TransactionsDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.unionbank.core.UserManagement"%>
<%@page import="org.datacontract.schemas._2004._07.ubn_security.UserProfile"%>
<%@page import="com.unionbank.webpay.parameters.Settings"%>


<%@include file="tags.jsp"%>


<%
    Processor pb = new Processor();

%>

<script>

    $(document).ready(function() {
        if ($('#cemail').prop('checked'))
        {
            $("#ccemail").text("Hello world!");

            $("#ccemail").val('YES');
        }

    });
</script>

<%
    
     Settings settings = Settings.getInstance("");
    String module = settings.getProperty("module");
    
    
    String command = request.getParameter("command");
    if (command == null) {
        command = "";
    }
    System.out.println("command<<>>" + command);

    if (command.equalsIgnoreCase("checkedfields")) {

        String cemail = request.getParameter("cemail");
        if (cemail == null) {
            cemail = "";
        }
        //
        System.out.println("got here cemail<<>>>" + cemail);



        String ccfirstname = request.getParameter("ccfirstname");
        if (ccfirstname == null) {
            ccfirstname = "";
        }
        System.out.println("got here ccfirstname <<>>>" + ccfirstname);

        String ccemail = request.getParameter("ccemail");
        if (ccemail == null) {
            ccemail = "";
        }
        //ccemail
        System.out.println("got here ccemail<<>>>" + ccemail);

    } else if (command.equalsIgnoreCase("query")) {
        String tMessage = "";
        boolean which = false;
        session.setAttribute("msg-info-signin", "");
        String cbvn = request.getParameter("cbvn");
        if (cbvn == null) {
            cbvn = "";
        }
        try {
            String txnId = pb.gettxnRefsqquence();
            request.setAttribute("transactionid", txnId);
            System.out.println("transactionid<<>>> from back" + txnId);
            System.out.println("got here cbvn 2<<>>>" + cbvn);
            TransactionsDAO mert = new TransactionsDAO();
            mert = pb.getBVNdetails(cbvn);
            if (mert.getResponseCode().equals("00")) {
                System.out.println("got getFirstName <<>>>" + mert.getOldFirstName());
                session.setAttribute("mert", (TransactionsDAO) mert);
                getServletContext().getRequestDispatcher("/br_dataview.jsp").forward(request, response);
            } else {
                session.setAttribute("msg-info-signin", "Invalid BVN");
                response.sendRedirect("bvn_verification.jsp");
            }

        } catch (Exception e) {
            session.setAttribute("msg-info-signin", "Error occured");
            response.sendRedirect("bvn_verification.jsp");

            e.printStackTrace();
        }
        // response.sendRedirect("br_dataview.jsp");


    } else if (command.equalsIgnoreCase("auth")) {
        String username = request.getParameter("username");
        if (username == null) {
            username = "";
        }
        String loginPassword = request.getParameter("loginPassword");
        if (loginPassword == null) {
            loginPassword = "";
        }

        UserManagement Usm = new UserManagement();
        String role = "";
        org.datacontract.schemas._2004._07.ubn_security.UserProfile Urs = new UserProfile();
        //System.out.println("Usr username>>>>>>>>true" + username);
        //System.out.println("Usr loginPassword>>>>>>>>true" + loginPassword);module

       // if (Usm.IsAuthenticate(username.trim(), loginPassword.trim(), "moneygram")) {
         if (Usm.IsAuthenticate(username.trim(), loginPassword.trim(), module)) {
            if (Usm.IscheckExist(username.trim(), module)) {
                System.out.println("Usr authenticated>>>>>>>>true");
                try {
                   // role = Usm.getUsrRolegetRolesForUser(username.trim(), "moneygram");
                     role = Usm.getUsrRolegetRolesForUser(username.trim(),module);
                  //  Urs = Usm.getUsrDetails(username.trim(), "moneygram");
                     Urs = Usm.getUsrDetails(username.trim(), module);
                    session.setAttribute("Urs", (UserProfile) Urs);
              //role = "authoriser";
              //  role = "user";
                    if (role.equalsIgnoreCase("user")) {
                        response.sendRedirect("bvn_verification.jsp");
                    } else if (role.equalsIgnoreCase("authoriser")) {
                        response.sendRedirect("authurizer_pendinglist.jsp");
                    } else {
                        session.setAttribute("msg-info-signin", "User is not profiled for solution");
                        response.sendRedirect("login.jsp");
                    }

                    UserProfile ursP = (UserProfile) session.getAttribute("Urs");

                    try {
                        username = ursP.getEmail().getValue();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    pb.logAuditTrail("1", ursP, "");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                session.setAttribute("msg-info-signin", "Invalid Login Details");
                response.sendRedirect("login.jsp");
            }
        } else {
            session.setAttribute("msg-info-signin", "Invalid Login Details");
            response.sendRedirect("login.jsp");
        }

        /*  if (username.equalsIgnoreCase("aajibade")) {
         response.sendRedirect("bvn_verification.jsp");
         } else if (username.equalsIgnoreCase("aaajibade")) {
         response.sendRedirect("authurizer_pendinglist.jsp");
         } else {
         session.setAttribute("msg-info-signin", "Invalid Login Details");
         response.sendRedirect("login.jsp");
         }*/
        //returntolist
    } else if (command.equalsIgnoreCase("returntolist")) {

        System.out.println("bvnfield<<>>>");
        getServletContext().getRequestDispatcher("/authurizer_pendinglist.jsp").forward(request, response);


    } else if (command.equalsIgnoreCase("authh")) {
        pb.logAuditTrail("1", "aajibade");
        response.sendRedirect("bvn_verification.jsp");

        // response.sendRedirect("authurizer_pendinglist.jsp");
    } else if (command.equalsIgnoreCase("bvnlink2")) {
        session.setAttribute("msg-info-signin", "");
        System.out.println("got here bvnlinker <<>>>");
        String bvnfield = request.getParameter("bvnfield");
        if (bvnfield == null) {
            bvnfield = "";
        }
        System.out.println("bvnfield<<>>>" + bvnfield);


        String menu1 = request.getParameter("menu1");
        if (menu1 == null) {
            menu1 = "";
        }
        String bankname = request.getParameter("bankname");
        if (bankname == null) {
            bankname = "";
        }

        System.out.println("bankname<<>>>" + bankname);
        //
        if (!bvnfield.equals("")) {
            if (!pb.isNumeric(bvnfield)) {//internet_bvnlinker2_upt
                session.setAttribute("msg-info-signin", "BVN should be Numeric");
                response.sendRedirect("internet_bvnlinker2_upt.jsp");

            } else if (bvnfield.length() < 11) {
                session.setAttribute("msg-info-signin", "BVN should be 11digits");
                response.sendRedirect("internet_bvnlinker2_upt.jsp");
            } else {
                pb.processBVNRequest("0042168192", bvnfield, menu1);
                session.setAttribute("msg-info-signin", "BVN has been submitted");
                response.sendRedirect("internet_bvnlinker_upt.jsp");
            }

        } else {
            session.setAttribute("msg-info-signin", "Supply BVN");
            response.sendRedirect("internet_bvnlinker2_upt.jsp");
        }


        System.out.println("menu1<<>>>" + menu1);
        // session.setAttribute("msg-info-signin", "Invalid Login Details");
        // response.sendRedirect("bvnlinker.jsp");

    } else if (command.equalsIgnoreCase("bvnlink")) {
        session.setAttribute("msg-info-signin", "");
        System.out.println("got here bvnlinker <<>>>");
        String bvnfield = request.getParameter("bvnfield");
        if (bvnfield == null) {
            bvnfield = "";
        }
        System.out.println("bvnfield<<>>>" + bvnfield);


        String menu1 = request.getParameter("menu1");
        if (menu1 == null) {
            menu1 = "";
        }
        if (!bvnfield.equals("")) {
            if (!pb.isNumeric(bvnfield)) {
                session.setAttribute("msg-info-signin", "BVN should be Numeric");
                response.sendRedirect("bvnlinker_upt.jsp");

            } else if (bvnfield.length() < 11) {
                session.setAttribute("msg-info-signin", "BVN should be 11digits");
                response.sendRedirect("bvnlinker_upt.jsp");
            } else {
                pb.processBVNRequest("0042168192", bvnfield, "");
                session.setAttribute("msg-info-signin", "BVN has been submitted");
                response.sendRedirect("bvnlinker_upt.jsp");
            }

        } else {
            session.setAttribute("msg-info-signin", "Supply BVN");
            response.sendRedirect("bvnlinker_upt.jsp");
        }


        System.out.println("menu1<<>>>" + menu1);
        // session.setAttribute("msg-info-signin", "Invalid Login Details");
        // response.sendRedirect("bvnlinker.jsp");
    } else if (command.equalsIgnoreCase("int_bvnlink")) {
        //acctnum
        String acctnum = request.getParameter("acctnum");
        if (acctnum == null) {
            acctnum = "";
        }
        if (!acctnum.equals("")) {
            String acctName = "";
            if (!pb.isNumeric(acctnum)) {
                session.setAttribute("msg-info-signin", "Account Number should be Numeric");
                response.sendRedirect("internet_bvnlinker_upt.jsp");

            } else if (acctnum.length() < 10) {
                session.setAttribute("msg-info-signin", "Account Number should be 10digits");
                response.sendRedirect("internet_bvnlinker_upt.jsp");
            } else {
                acctName = pb.getaccountName(acctnum);
                if (acctName == null) {
                    acctName = "";
                }
                if (!acctName.equals("")) {
                    request.getSession().setAttribute("acctnum", acctnum);
                    request.getSession().setAttribute("acctName", acctName);
                    response.sendRedirect("internet_bvnlinker2_upt.jsp");
                } else {
                    session.setAttribute("msg-info-signin", "Invalid Account Number");
                    response.sendRedirect("internet_bvnlinker_upt.jsp");
                }
            }

        } else {
            session.setAttribute("msg-info-signin", "Supply Account Number");
            response.sendRedirect("internet_bvnlinker_upt.jsp");
        }
    } else if (command.equalsIgnoreCase("send")) {
        String destcurrency = request.getParameter("nibss-id");
        System.out.println("destcurrency<<>>>" + destcurrency);
        System.out.println("got here cbvn <<>>>" + destcurrency);
        //TransactionsDAO mert = new TransactionsDAO();
        List<TransactionsDAO> mert = new ArrayList<TransactionsDAO>();
        mert = pb.getPendingListOne("N", destcurrency);
        //  List<TransactionsDAO> tTransactionsList = new ArrayList<TransactionsDAO>();
        //pb.getPendingList();
        //System.out.println("got getFirstName <<>>>" + mert.getOldFirstName());
        session.setAttribute("mert", (List<TransactionsDAO>) mert);
        response.sendRedirect("auth_dataview.jsp");


    } else if (command.equalsIgnoreCase("approvesend")) {
        String nibssid = "";

        UserProfile ursPpee = (UserProfile) session.getAttribute("Urs");
        String DisplayName = "", Depts = "", branchcode = "";
        try {
            DisplayName = ursPpee.getDisplayName().getValue();
            branchcode = ursPpee.getBranchCode().getValue();
            System.out.println("getEmployeeId<<>> " + ursPpee.getEmployeeId().getValue());
            System.out.println("getBranchCode<<>> " + ursPpee.getBranchCode().getValue());
            // Depts = ursPpee.getDepartment().getValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (DisplayName == null) {
            DisplayName = "";
        }

        try {
            nibssid = request.getParameter("destcurrency");
            System.out.println("what is nibssid<<>>" + nibssid);
            Processor pros = new Processor();
            pros.approveDenieFunction(nibssid, "APPROVE", DisplayName, branchcode);
            System.out.println("Was here <>>>>>");
        } catch (Exception e) {

            e.printStackTrace();
        }

        try {
            UserProfile ursP = (UserProfile) session.getAttribute("Urs");
            pb.logAuditTrail("4", ursP, nibssid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        response.sendRedirect("authurizer_pendinglist.jsp");

        // System.out.println("got here approvesend <<>>>" );
    } else if (command.equalsIgnoreCase("rejectsend")) {
        String nibssid = "";
        UserProfile ursPpee = (UserProfile) session.getAttribute("Urs");
        String DisplayName = "", Depts = "", branchcode = "";
        try {
            DisplayName = ursPpee.getDisplayName().getValue();
            branchcode = ursPpee.getBranchCode().getValue();
            System.out.println("getEmployeeId<<>> " + ursPpee.getEmployeeId().getValue());
            System.out.println("getBranchCode<<>> " + ursPpee.getBranchCode().getValue());
            // Depts = ursPpee.getDepartment().getValue();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (DisplayName == null) {
            DisplayName = "";
        }

        try {
            nibssid = request.getParameter("destcurrency");
            System.out.println("what is nibssid<<>>" + nibssid);
            Processor pros = new Processor();
            pros.approveDenieFunction(nibssid, "REJECT", DisplayName, branchcode);
            System.out.println("Was here <>>>>>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UserProfile ursP = (UserProfile) session.getAttribute("Urs");
            pb.logAuditTrail("5", ursP, nibssid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        response.sendRedirect("authurizer_pendinglist.jsp");

    } else if (command.equalsIgnoreCase("backtolist")) {
        String reqid = request.getParameter("requestid");
        System.out.println("what is nibssi222222d<<>>" + reqid);
        response.sendRedirect("authurizer_pendinglist.jsp");
    }
    //backtolist


%>