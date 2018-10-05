$(function() { 

    $('#upldBtn').click(function() {
        var contextPath = '';
        var servletName = 'UploadFile';
        var iframe = $('<iframe name="postiframe" id="postiframe" style="display: none" />');
        $("body").append(iframe);

         $("form#yourform").attr('action', contextPath+servletName);
         $("form#yourform").attr('enctype', "multipart/form-data");
         $("form#yourform").attr("target", "postiframe");
         $("form#yourform").attr("file", $('#file').val());

        $('yourform').submit(); //upload button 
             $("#postiframe").load(function () {
                    iframeContents = $("#postiframe")[0].contentWindow.document.body.innerHTML;
                    $("#textarea").html(iframeContents);
                            $.ajax({
                                    type: "GET",
                                    url: contextPath+servletName,
                                    data: "action=download",
                                    async: false,
                                    dataType: "text",
                                    success: function(result) {
                                        //do something
                                    }
                                });
                 });
            }); 
});