<%-- 
    Document   : t_residentialAddresspop
    Created on : 02-Dec-2016, 14:34:15
    Author     : baadedeji
--%>

<div class="modal fade" id="myModalresident" >

    <div    class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1">Customer Details Modification</h4>
            </div>
            <div class="modal-body">
                <div class="col-md-12">
                    <div class="form-horizontal">
                        <div id="lvDetails_ctrl8_panResident" class="form-group">
                            <label class="col-md-4 control-label">Old Residential Address</label>
                            <div class="col-md-8">
                                <input name="oldresidentadd" type="text" id="oldresidentadd" class=" form-control"  disabled>

                            </div>
                        </div>

                        <div id="lvDetails_ctrl_panResident" class="form-group">
                            <label class="col-md-4 control-label">New Residential Address</label>
                            <div class="col-md-8">
                                <input name="newresidentadd" type="text" id="newresidentadd" class="form-control" >

                            </div>

                        </div>

                        <div id="lvDetails_ctrl_panResidentcomment" class="form-group">
                            <label class="col-md-4 control-label">Comments</label>
                            <div class="col-md-8">
                                <textarea name="oldcommentresidentadd" rows="3" cols="20" id="oldcommentresidentadd" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal-footer">

                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button"  id="btnSaveresidentadd" class="btn btn-success "><span class="glyphicon glyphicon-ok"></span> <strong>SUBMIT</strong></button>

            </div>
        </div>
    </div>
</div>