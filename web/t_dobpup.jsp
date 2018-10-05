<div class="modal fade" id="myModaldob" >

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
                            <label class="col-md-4 control-label">Old Date Of Birth</label>
                            <div class="col-md-8">
                                <input name="olddob" type="text" id="olddob"   class="form-control"  disabled>

                            </div>
                        </div>                       
                   
                        <div id="lvDetails_ctrl_panDate" class="form-group">
                            <label class="col-md-4 cvontrol-label">New Date Of Birth (DD-MMM-YYYY i.e 19-FEB-1981)</label>
                            <div class="col-md-8">
                                <input name="newdob" type="text" id="newdob" class="form-control" >

                            </div>

                        </div>

                        <div id="lvDetails_ctrl_pancoment" class="form-group">
                            <label class="col-md-4 control-label">Comments</label>
                            <div class="col-md-8">
                                <textarea name="oldcommentdob" rows="3" cols="20" id="oldcommentdob" class="form-control"></textarea>
                            </div>
                        </div>


                    </div>
                </div>


            </div>

            <div class="modal-footer">

                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button"  id="btnSavedob" class="btn btn-success "><span class="glyphicon glyphicon-ok"></span> <strong> SUBMIT</strong></button>

            </div>
        </div>
    </div>
</div>
