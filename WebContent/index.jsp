<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dojo/1.6.0/dojo.js"
	type="text/javascript"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Upload File Form</h1>
		<form action="FileUploadHandler" enctype="multipart/form-data" method="post">
			Select<input type="file" name="file2" /> <input
				type="submit" value="Upload" />
		</form>
	</center>
</body>
</html>
