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
<center>
<div class="w3-card" style="width: 400px;">
<form action="storeManager" method="get">
<h3 style="color: green;background-color: yellow;width: 300px;">---ADD MANAGER HERE---</h3>
<table>
<tr><td>Enter name</td><td><input type="text" name=name></td></tr>
<tr><td>Mobile</td><td><input type="text" name=mob></td></tr>
<tr><td>Email</td><td><input type="text" name=email></td></tr>
<tr><td>DOB</td><td><input type="date" name=dob></td></tr>
<tr><td>VoterId No</td><td><input type="text" name=vn ></td></tr>
<tr><td>Gender</td><td><input type="radio" name=gen value=male>Male <input type="radio" name=gen value=female>Female</td></tr>
<tr><td>District</td><td>
<select name=dis >
<option value="warangal">warangal</option>
<option value="khammam">khammam</option>
<option value="rangareddy">rangareddy</option>
<option value="hyderabad">hyderabad</option>
<option value="janagon">janagon</option>
<option value="mahabubabadh">mahabubabadh</option>
<option value="karimnagar">karimnagar</option>
<option value="nalgonda">nalgonda</option>
</select></tr>
<tr><td>UserId</td><td><input type="text" name=uid> </td></tr>
<tr><td>password</td><td><input type="password" name=pass> </td></tr>
<tr><td><input type="submit" VALUE=ADD  class="w3-teal w3-button"></td><td><input type="reset" class="w3-teal w3-button"></td></tr>
</table>
</form>
</div></center>
</body>
</html>