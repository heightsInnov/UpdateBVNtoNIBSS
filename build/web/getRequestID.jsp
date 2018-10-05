<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.unionbank.core.FetchRecordsBean"%>
<%@page import="com.unionbank.webpay.db.dao.TransactionsDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.unionbank.ADService.UserProfile"%>
<%@page import="com.unionbank.webpay.parameters.Settings"%>


<%        
    String command = request.getParameter("command");
    System.out.println("command<<>>" + command);
    
    if (command == null) {
        command = "";
    }
    System.out.println("command<<>>" + command);

    if (command.equalsIgnoreCase("fetchRecordsReqID")) {
      
        String requestid = request.getParameter("reqIdT");
        BigDecimal ReqID = new BigDecimal(requestid);
		System.out.println("ReqID BigDec >>" + ReqID);
                
        try {
            System.out.println("Request ID is <<>>>" +ReqID);
            List<TransactionsDAO> mert = null;
            FetchRecordsBean fetch = new FetchRecordsBean();
           
            mert = fetch.getRecordsByRequestID(ReqID);
			System.out.println("Mert Contains >>" + mert.get(0).getOldBvNumber());
            session.setAttribute("mert", mert);
            getServletContext().getRequestDispatcher("/request_details.jsp").forward(request, response);

        } catch (Exception e) {
            session.setAttribute("msg-info-signin", "Error occured");
            response.sendRedirect("fetch_request_id.jsp");
            e.printStackTrace();
        }
//     
//            } else {
//                session.setAttribute("msg-info-signin", "Invalid Login Details");
//                response.sendRedirect("login.jsp");
//            }
//         

        /*  if (username.equalsIgnoreCase("aajibade")) {
         response.sendRedirect("bvn_verification.jsp");
         } else if (username.equalsIgnoreCase("aaajibade")) {
         response.sendRedirect("authurizer_pendinglist.jsp");
         } else {
         session.setAttribute("msg-info-signin", "Invalid Login Details");
         response.sendRedirect("login.jsp");
         }*/
        //returntolist
//    } if (command.equalsIgnoreCase("fetchOpenComplaints")) {
//      
//        String startdate = request.getParameter("startDate");
//        String enddate = request.getParameter("endDate");
//        if (startdate == null) {
//            startdate = "";
//        }
//        if (enddate == null) {
//            enddate = "";
//        }
//        try {
//            System.out.println("got start date<<>>>" + startdate);
//            System.out.println("got end date<<>>>" + enddate);
//            List<ComplaintsDAO> mert = null;
//            FetchRecordsBean fetch = new FetchRecordsBean();
//            mert = fetch.getOpenComplaints(startdate,enddate);
////            System.out.println("got response code <<>>>" + mert.getResponsecode());    
//             session.getAttribute("responseCode");
//             session.setAttribute("mert", mert);
//              getServletContext().getRequestDispatcher("/openComplaints.jsp").forward(request, response);
//           
//
//        } catch (Exception e) {
//            session.setAttribute("msg-info-signin", "Error occured");
//            response.sendRedirect("openComplaintsFetch.jsp");
//            e.printStackTrace();
//        }
    
//    }if (command.equalsIgnoreCase("fetchRecordsReqID")) {
//      
//        String startdate = request.getParameter("startDate");
//        String enddate = request.getParameter("endDate");
//        if (startdate == null) {
//            startdate = "";
//        }
//        if (enddate == null) {
//            enddate = "";
//        }
//        try {
//            System.out.println("got start date<<>>>" + startdate);
//            System.out.println("got end date<<>>>" + enddate);
//            List<CustomersCbnDAO> mert = null;
//            FetchRecordsBean fetch = new FetchRecordsBean();
//            mert = fetch.getCcmpClaimsMgrReport(startdate,enddate);
//            session.getAttribute("responseCode");
//                session.setAttribute("mert", mert);
//                    getServletContext().getRequestDispatcher("/cbnReports.jsp").forward(request, response);
//
//        } catch (Exception e) {
//            session.setAttribute("msg-info-signin", "Error occured");
//            response.sendRedirect("cbnReportsFetch.jsp");
//            e.printStackTrace();
//        }
    }else if (command.equalsIgnoreCase("returntolist")) {

        System.out.println("bvnfield<<>>>");
        getServletContext().getRequestDispatcher("/authurizer_pendinglist.jsp").forward(request, response);


    }else if (command.equalsIgnoreCase("bvnlink2")) {
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
        

        System.out.println("menu1<<>>>" + menu1);
        // session.setAttribute("msg-info-signin", "Invalid Login Details");
        // response.sendRedirect("bvnlinker.jsp");
    
    } else if (command.equalsIgnoreCase("backtolist")) {
        String reqid = request.getParameter("requestid");
        System.out.println("what is nibssi222222d<<>>" + reqid);
        response.sendRedirect("authurizer_pendinglist.jsp");
    }
    //backtolist


%>