<%-- 
    Document   : t_titlepop
    Created on : Apr 25, 2018, 3:29:18 PM
    Author     : aojinadu
--%>


<div class="modal fade" id="myModaltitle" >

    <div    class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">Customer Details Modification</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="form-horizontal">
                        <div id="lvDetails_ctrl8_panlga" class="form-group">
                            <label class="col-md-4 control-label">Old Title</label>
                            <div class="col-md-8">
                                <input name="oldtitle" type="text" id="oldtitle" class=" form-control"  disabled>

                            </div>
                        </div>

                        <div id="lvDetails_ctrl_panlga" class="form-group">
                            <label class="col-md-4 control-label">New Title</label>
                            <div class="col-md-8">
                                <input name="newtitle" type="text" id="newtitle" class="form-control" >

                            </div>

                        </div>

                        <div id="lvDetails_ctrl_panlgacoment" class="form-group">
                            <label class="col-md-4 control-label">Comments</label>
                            <div class="col-md-8">
                                <textarea name="oldcommenttitle" rows="3" cols="20" id="oldcommenttitle" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal-footer">

                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button"  id="btnSavetitle" class="btn btn-success "><span class="glyphicon glyphicon-ok"></span> <strong>SUBMIT</strong></button>

            </div>
        </div>
    </div>
</div>
