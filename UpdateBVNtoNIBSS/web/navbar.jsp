<%@page import="org.datacontract.schemas._2004._07.ubn_security.UserProfile"%>
<%@page import="javax.xml.bind.JAXBElement"%>
<%@include file="tags.jsp"%>

<div class="navbar  navbar-inverse navbar-static-top" style="margin-bottom: 0px" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>


        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a class="navbar-brand" href="home.html">Merchant Portal</a></li> 
                    <%

                        UserProfile ursP = (UserProfile) session.getAttribute("Urs");
                        String username = "", Dept = "";
                        if (ursP ==null){
                             response.sendRedirect("login.jsp");
                        }
                        try {
                            username = ursP.getDisplayName().getValue();
                            
                            Dept = ursP.getDepartment().getValue();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        //ObjectFactory factory = new ObjectFactory();
                        // JAXBElement<String> xdisplayName = factory.createString("");
                        // username = xdisplayName.getValue();
                        if (username == null) {
                            username = "";
                        }

                        if (Dept == null) {
                            Dept = "";
                        }

                        System.out.println("username<<<>>>>" + username);
                        //  String name = "";
%>

                <li><p class="navbar-text">Welcome  <%=username%></p></li>                        
                <li><p class="navbar-text">Department:   <%=Dept%></p></li> 
            </ul>
            <ul class="nav navbar-nav navbar-right">


                <li><p class="navbar-text"><img alt="UBN" src="img/unionlogo.png" style="width:150px">&nbsp;&nbsp;&nbsp;&nbsp;</p></li> 


            </ul>
        </div><!-- nav-collapse -->        
    </div>
</div>    
