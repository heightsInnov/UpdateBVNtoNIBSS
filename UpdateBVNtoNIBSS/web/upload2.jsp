<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
    <center>
        <h1>Multiple Files Upload</h1>
        <form  id="uploadfl" method="post" action="UploadServlet"    enctype="multipart/form-data">
            <input type="hidden" id="login_attempts" name="login_attempts" value=''>
            <input type="file" size="50"  id="myfile" name="myfile"  onchange="myFunction(this.form.login_attempts);" /><br />
             <input type="file" size="50" id="myfile1" name="myfile1" /><br />
             <input type="file" size="50"  id="myfile2" name="myfile2"/><br />
             <input type="file" size="50"  id="myfile3" name="myfile3"/><br />
             <input type="file" size="50" id="myfile4" name="myfile4" /><br />
            <br /> 
            
            <input type="submit" value="Upload" />
            
            <p id="demo"></p>
        </form>
    </center>
    
    
    
 <script>
function myFunction(loginAttempts){
    var x = document.getElementById("myfile");
    var txt = "";
    if ('files' in x) {
        if (x.files.length == 0) {
            txt = "Select one or more files.";
        } else {
            for (var i = 0; i < x.files.length; i++) {
               // txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                var file = x.files[i];
                if ('name' in file) {
                    txt +=  file.name;
                }
              //  if ('size' in file) {
              //      txt += "size: " + file.size + " bytes <br>";
              //  }
            }
        }
        
    } 
    else {
        if (x.value == "") {
            txt += "Select one or more files.";
        } else {
            txt += "The files property is not supported by your browser!";
            txt  += "<br>The path of the selected file: " + x.value; // If the browser does not support the files property, it will return the path of the selected file instead. 
        }
    }
    
    document.getElementById("demo").innerHTML = txt;
    loginAttempts.value = txt;
   //   var myparam = "abc";

     // add hidden field to your form name="myparam" and value="abc"
    //  $('#uploadfl').append('<input type="hidden" name="tmyfile " value=txt />');
    //  $("#receiptsForm").submit(); 
    
}
</script>

</body>
</html>