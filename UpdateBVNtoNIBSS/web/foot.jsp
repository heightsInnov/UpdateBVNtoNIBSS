<br>
<div class="footer bg-primary" align="center">
    <footer>
        <p><strong>&copy;2015- All Rights Reserved -Union Bank of Nigeria Plc </strong></p>

    </footer>
</div>
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
<script src="js/tableDatacontrol.js"></script>
<script src="js/tabletoBackoffice.js"></script>
<script src="js/tabletoBackoffice.js"></script>

<script src="js/filetest.js"></script>

<script src="js/bootstrap-datetimepicker.js"></script>


<script>
    function myFunction(loginAttempts,oInput) {
        
        
          var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png",".pdf",".zip",".rar"];
        
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }

                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    oInput.value = "";
                    return false;
                }
            }
        }
        var x = document.getElementById("myFile");
        var txt = "";
        if ('files' in x) {
            if (x.files.length == 0) {
                txt = "Select one or more files.";
            } else {
                for (var i = 0; i < x.files.length; i++) {
                    // txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                    var file = x.files[i];
                    if ('name' in file) {
                        txt += file.name;
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
                txt += "<br>The path of the selected file: " + x.value;

                // If the browser does not support the files property, it will return the path of the selected file instead. 
            }
        }

        //  document.getElementById("demo").innerHTML = txt;
        document.getElementById("Onefile").value = txt;
        /// alert(document.getElementById("firstnamefile").value);
        //  loginAttempts.value = txt;
        //   var myparam = "abc";

        // add hidden field to your form name="myparam" and value="abc"
        //  $('#uploadfl').append('<input type="hidden" name="tmyfile " value=txt />');
        //  $("#receiptsForm").submit(); 

    }
</script>




<script>
    function myFunction1(loginAttempts,oInput) {
        
        
        
        var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png",".pdf",".zip",".rar"];
        
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }

                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    oInput.value = "";
                    return false;
                }
            }
        }
        var x = document.getElementById("myfile1");
        var txt = "";
        if ('files' in x) {
            if (x.files.length == 0) {
                txt = "Select one or more files.";
            } else {
                for (var i = 0; i < x.files.length; i++) {
                    // txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                    var file = x.files[i];
                    if ('name' in file) {
                        txt += file.name;
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
                txt += "<br>The path of the selected file: " + x.value;

                // If the browser does not support the files property, it will return the path of the selected file instead. 
            }
        }

        //  document.getElementById("demo").innerHTML = txt;
        document.getElementById("middlenamefile").value = txt;
        /// alert(document.getElementById("firstnamefile").value);
        //  loginAttempts.value = txt;
        //   var myparam = "abc";

        // add hidden field to your form name="myparam" and value="abc"
        //  $('#uploadfl').append('<input type="hidden" name="tmyfile " value=txt />');
        //  $("#receiptsForm").submit(); 

    }
</script>



<script>
    function myFunction2(loginAttempts,oInput) {
        
        
        var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png",".pdf",".zip",".rar"];
        
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }

                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    oInput.value = "";
                    return false;
                }
            }
        }
        var x = document.getElementById("myfile22");
        var txt = "";
        if ('files' in x) {
            if (x.files.length == 0) {
                txt = "Select one or more files.";
            } else {
                for (var i = 0; i < x.files.length; i++) {
                    // txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                    var file = x.files[i];
                    if ('name' in file) {
                        txt += file.name;
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
                txt += "<br>The path of the selected file: " + x.value;

                // If the browser does not support the files property, it will return the path of the selected file instead. 
            }
        }

        //  document.getElementById("demo").innerHTML = txt;
        document.getElementById("lastnamefile").value = txt;
        /// alert(document.getElementById("firstnamefile").value);
        //  loginAttempts.value = txt;
        //   var myparam = "abc";

        // add hidden field to your form name="myparam" and value="abc"
        //  $('#uploadfl').append('<input type="hidden" name="tmyfile " value=txt />');
        //  $("#receiptsForm").submit(); 

    }
</script>





<script>
    function myFunction3(loginAttempts,oInput) {
        
        
        var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png",".pdf",".zip",".rar"];
        
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }

                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    oInput.value = "";
                    return false;
                }
            }
        }
        var x = document.getElementById("myfile33");
        var txt = "";
        if ('files' in x) {
            if (x.files.length == 0) {
                txt = "Select one or more files.";
            } else {
                for (var i = 0; i < x.files.length; i++) {
                    // txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                    var file = x.files[i];
                    if ('name' in file) {
                        txt += file.name;
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
                txt += "<br>The path of the selected file: " + x.value;

                // If the browser does not support the files property, it will return the path of the selected file instead. 
            }
        }

        // document.getElementById("demo").innerHTML = txt;
        document.getElementById("dobfile").value = txt;
        /// alert(document.getElementById("firstnamefile").value);
        //  loginAttempts.value = txt;
        //   var myparam = "abc";

        // add hidden field to your form name="myparam" and value="abc"
        //  $('#uploadfl').append('<input type="hidden" name="tmyfile " value=txt />');
        //  $("#receiptsForm").submit(); 

    }
</script>




<script>
    function myFunction4(loginAttempts,oInput) {
        
        var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png",".pdf",".zip",".rar"];
        
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }

                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    oInput.value = "";
                    return false;
                }
            }
        }
        var x = document.getElementById("myfile44");
        var txt = "";
        if ('files' in x) {
            if (x.files.length == 0) {
                txt = "Select one or more files.";
            } else {
                for (var i = 0; i < x.files.length; i++) {
                    // txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                    var file = x.files[i];
                    if ('name' in file) {
                        txt += file.name;
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
                txt += "<br>The path of the selected file: " + x.value;

                // If the browser does not support the files property, it will return the path of the selected file instead. 
            }
        }

        // document.getElementById("demo").innerHTML = txt;
        document.getElementById("phonenofile").value = txt;
        /// alert(document.getElementById("firstnamefile").value);
        //  loginAttempts.value = txt;
        //   var myparam = "abc";

        // add hidden field to your form name="myparam" and value="abc"
        //  $('#uploadfl').append('<input type="hidden" name="tmyfile " value=txt />');
        //  $("#receiptsForm").submit(); 

    }
</script>







<script>
    function myFunction5(loginAttempts,oInput) {
        var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png",".pdf",".zip",".rar"];
        
        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }

                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    oInput.value = "";
                    return false;
                }
            }
        }


        
        var x = document.getElementById("myfile55");
        var txt = "";
        if ('files' in x) {
            if (x.files.length == 0) {
                txt = "Select one or more files.";
            } else {
                for (var i = 0; i < x.files.length; i++) {
                    // txt += "<br><strong>" + (i+1) + ". file</strong><br>";
                    var file = x.files[i];
                    if ('name' in file) {
                        txt += file.name;
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
                txt += "<br>The path of the selected file: " + x.value;

                // If the browser does not support the files property, it will return the path of the selected file instead. 
            }
        }

        // document.getElementById("demo").innerHTML = txt;
        document.getElementById("emailfile").value = txt;
        /// alert(document.getElementById("firstnamefile").value);
        //  loginAttempts.value = txt;
        //   var myparam = "abc";

        // add hidden field to your form name="myparam" and value="abc"
        //  $('#uploadfl').append('<input type="hidden" name="tmyfile " value=txt />');
        //  $("#receiptsForm").submit(); 

    }
</script>


<script>

    var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];
    function ValidateSingleInput(oInput) {

        if (oInput.type == "file") {
            var sFileName = oInput.value;
            if (sFileName.length > 0) {
                var blnValid = false;
                for (var j = 0; j < _validFileExtensions.length; j++) {
                    var sCurExtension = _validFileExtensions[j];
                    if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                        blnValid = true;
                        break;
                    }
                }

                if (!blnValid) {
                    alert("Sorry, " + sFileName + " is invalid, allowed extensions are: " + _validFileExtensions.join(", "));
                    oInput.value = "";
                    return false;
                }
            }
        }


        return true;
}

</script>

