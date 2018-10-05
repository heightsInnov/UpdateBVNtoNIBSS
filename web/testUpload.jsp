<%-- 
    Document   : testUpload
    Created on : Apr 25, 2018, 9:02:49 AM
    Author     : aojinadu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script>
			$(function () {
				$("input[type='submit']").click(function () {
					var $fileUpload = $("input[type='file']");
					if (parseInt($fileUpload.get(0).files.length) > 3) {
						alert("You can only upload a maximum of 2 files");
					}
				});
			});
			​
		</script>
        <title>Upload</title>
    </head>
    <body>
        <h1>Hello World!</h1>
		<h1>${requestScope.message}</h1>
        <form action="UploadFile" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pathed" value="http://sit-poc:2020/api/upload3/test3"/>
            <input type="hidden" name="transactionid" value="000111"/>
            <input type="file" name="myFiles" id="myFiles" accept=".doc,.pdf,.docx,image/jpeg, image/jpg" multiple/><br/>
            <input type="submit" name="btnSubmit" value="Submit"/>
        </form>

		<br/><br/><br/>
		<form action="UploadFile" method="post" enctype="multipart/form-data">
		<div  class="row">
			<div class="col-md-12" id="DivDefault">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-3">
						<label>Upload Supporting Document:<span style="color: red">*</span> </label>
					</div>
					<div class="col-md-4">
						<input type="file" id="myFiles" accept=".doc,.pdf,.docx,image/jpeg, image/jpg" title="Max 3 files allowed" name="myFiles" class="form-control" required="true" multiple/>
					</div>
				</div>
			</div>
			<br/>
			<div class="row">                            
				<div class="col-xs-12">
					<div class="col-md-5"></div>
					<!--<button   id="convert-table" type="submit" class="btn btn-primary">SUBMIT</button>-->
					<div class="col-md-2">
						<input type="submit" id="submit" name="submit" value="Submit" class="btn btn-primary"/>
					</div>
				</div> 
			</div> 
		</div>
		</form>
    </body>
</html>
