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
    
    
    
   $(function() {
          $('#phonenumber_btnLaunch').click(function() {
              //Get
               var texto = $('#mytable tr:nth-child(5) td:nth-child(2)').text();
              //Set
              $('#oldphone1').val(texto);
              
              $('#myModalphone').modal('show');
          });
  
          $('#btnSavephone').click(function() {          
                var blaa = $('#newphone1').val(); 
                 var tcomment = $('#tcommentphone').val();  
                
                $('#mytable tr:nth-child(5) td:nth-child(3)').html(blaa,1);
                $('#mytable tr:nth-child(5) td:nth-child(4)').html(tcomment,1);
          
              $('#myModalphone').modal('hide');
          });
    });
    
    
    
    $(function() {
              $('#dateofbirth_btnLaunch').click(function() {
                  //Get
                   var texto = $('#mytable tr:nth-child(4) td:nth-child(2)').text();
                  //Set
                  $('#olddob').val(texto);
                  
                  $('#myModaldob').modal('show');
              });
      
              $('#btnSavedob').click(function() {          
                    var blaa = $('#newdob').val(); 
                     var tcomment = $('#oldcommentdob').val();  
                    
                    $('#mytable tr:nth-child(4) td:nth-child(3)').html(blaa,1);
                    $('#mytable tr:nth-child(4) td:nth-child(4)').html(tcomment,1);
              
                  $('#myModaldob').modal('hide');
              });
    });
    
    
    
    
     $(function() {
                  $('#lastname_btnLaunch').click(function() {
                      //Get
                       var texto = $('#mytable tr:nth-child(3) td:nth-child(2)').text();
                      //Set
                      $('#oldlastname').val(texto);
                      
                      $('#myModallastname').modal('show');
                  });
          
                  $('#btnSavelast').click(function() {          
                        var blaa = $('#newlastname').val(); 
                         var tcomment = $('#oldcommentlastname').val();  
                        
                        $('#mytable tr:nth-child(3) td:nth-child(3)').html(blaa,1);
                        $('#mytable tr:nth-child(3) td:nth-child(4)').html(tcomment,1);
                  
                      $('#myModallastname').modal('hide');
                  });
    });
    
    
    
     $(function() {
                      $('#middlename_btnLaunch').click(function() {
                          //Get
                           var texto = $('#mytable tr:nth-child(2) td:nth-child(2)').text();
                          //Set
                          $('#oldmiddlename').val(texto);
                          
                          $('#myModalmiddlename').modal('show');
                      });
              
                      $('#btnSavemiddle').click(function() {          
                            var blaa = $('#newmiddlename').val(); 
                             var tcomment = $('#middlecomment').val();  
                            
                            $('#mytable tr:nth-child(2) td:nth-child(3)').html(blaa,1);
                            $('#mytable tr:nth-child(2) td:nth-child(4)').html(tcomment,1);
                      
                          $('#myModalmiddlename').modal('hide');
                      });
    });
    
    
    
     $(function() {
                          $('#firstname_btnLaunch').click(function() {
                              //Get
                               var texto = $('#mytable tr:nth-child(1) td:nth-child(2)').text();
                              //Set
                              $('#oldfirstname').val(texto);
                              
                              $('#myModalfirstname').modal('show');
                          });
                  
                          $('#btnSavefirst').click(function() {          
                                var blaa = $('#newfirstname').val(); 
                                 var tcomment = $('#firstcomment').val();  
                                
                                $('#mytable tr:nth-child(1) td:nth-child(3)').html(blaa,1);
                                $('#mytable tr:nth-child(1) td:nth-child(4)').html(tcomment,1);
                          
                              $('#myModalfirstname').modal('hide');
                          });
    });
    
    
    