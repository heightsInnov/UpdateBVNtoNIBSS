<%-- 
    Document   : t_maritalstatpop
    Created on : 02-Dec-2016, 14:34:15
    Author     : baadedeji
--%>

<div class="modal fade" id="myModallga" >

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
                            <label class="col-md-4 control-label">Old LGA</label>
                            <div class="col-md-8">
                                <input name="oldlga" type="text" id="oldlga" class=" form-control"  disabled>

                            </div>
                        </div>

                        <div id="lvDetails_ctrl_panlga" class="form-group">
                            <label class="col-md-4 control-label">New LGA</label>
                            <div class="col-md-8">
                                <input name="newlga" type="text" id="newlga" class="form-control" >

                            </div>

                        </div>

                        <div id="lvDetails_ctrl_panlgacoment" class="form-group">
                            <label class="col-md-4 control-label">Comments</label>
                            <div class="col-md-8">
                                <textarea name="oldcommentlga" rows="3" cols="20" id="oldcommentlga" class="form-control"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal-footer">

                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button"  id="btnSavelga" class="btn btn-success "><span class="glyphicon glyphicon-ok"></span> <strong>SUBMIT</strong></button>

            </div>
        </div>
    </div>
</div>