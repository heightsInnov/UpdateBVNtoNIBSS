
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/holder.js"></script>
<script src="js/jquery.tablesorter.min.js"></script>
<script src="js/jquery.tablesorter.widgets.min.js"></script>
<script src="js/jquery.tablesorter.pager.js"></script>
<script src="js/jquery-ui-1.10.4.custom.min.js"></script>
<script src="js/global.js"></script>
<script src="js/payments.js"></script>
<script src="js/jquery.tabletojson.js"></script>
<script src="js/tabletoBackoffice.js"></script>


<script>
    $(function() {
        $('#btnLaunch').click(function() {
            //Get
             var texto = $('#mytable tr:nth-child(6) td:nth-child(2)').text();
            //Set
            $('#slanditf').val(texto);
            
            $('#myModal').modal('show');
        });

        $('#btnSave').click(function() {          
              var blaa = $('#newemail1').val(); 
               var tcomment = $('#tcomment').val();  
              
              $('#mytable tr:nth-child(6) td:nth-child(3)').html(blaa,1);
              $('#mytable tr:nth-child(6) td:nth-child(4)').html(tcomment,1);
        
            $('#myModal').modal('hide');
        });
    });
</script>

