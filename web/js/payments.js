$(document).ready(function() {
   
     $("#ccemail").val( $('#checkbox:checked').length);
    if ($('#cemail').prop('checked'))
        {
           $("#ccemail").val('YES');
           $("#ccemail").text("Hello world!");
        }
             
            });