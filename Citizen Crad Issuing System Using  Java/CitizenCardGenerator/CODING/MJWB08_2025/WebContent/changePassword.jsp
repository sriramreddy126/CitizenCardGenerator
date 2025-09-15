<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="w3.css">
<script>
function goBack() {
    window.history.back();
}
</script>
</head>
<body>
<h1 STYLE="font-size: 100px" class="w3-center w3-teal">CITIZEN CARDS</h1>
<button onclick="goBack()" class="w3-center w3-teal w3-button">Go Back</button>
<div class="w3-card w3-display-middle ">
<h2 class="w3-center w3-teal">CHANGE PASSWORD</h2>
<table class="">
<form action="ChangePassword" method="get">

<tr><td>Enter old password</td><td><input type=text name=old ></td></tr>
<tr><td>New password</td><td><input type=password name=pass></td></tr>
<tr><td>Confirm password</td><td><input type=password></td></tr>
<tr><td><input type=submit value=change class="w3-teal w3-button" ></td><td><input type=reset value=clear class="w3-teal w3-button"></td></tr>
</form>
</table>
</div>
</body>
</html>