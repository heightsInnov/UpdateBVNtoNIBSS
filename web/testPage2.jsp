
<html>
    <head>
        <%@ include file="head.jsp"%>

        <title>JSP Page</title>
    </head>

    <body>

        <form id="mainForm" >
            <h1></h1>
            <div class="modal fade" id="myModal">
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
            </div><!-- /.modal -->

            <div id="lvDetails_ctrl8_panDate" class="form-group">

                <label class="col-md-4 control-label">Old Email</label>
                <div class="col-md-8">
                    <input name="rywwy" type="text" id="eeueyy"   value=""  class=" form-control" required="">

                </div>

            </div>
            <button type="button" id="btnLaunch" class="btn btn-primary">Launch Modal</button>
            
            





        </form>

        <%@ include file="foot.jsp"%>
    </body>



