<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="w3.css">
</head>
<body class="w3-center">
<h1 STYLE="font-size: 100px" class="w3-center w3-teal">CITIZEN CARDS</h1>
<form action="CardGenerate" method="get">
<%
try{  
	String vn=request.getParameter("vn");
	System.out.println(vn);
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
	
	String sql="select * from citizen where vn='"+vn+"'";
	PreparedStatement sc=con.prepareStatement(sql);
	//sc.setString(1, vn);
	ResultSet rs=sc.executeQuery(sql);
	
	%>
	<div class="w3-card" style="height: 600px;width: 600px;">
	<h1 class="w3-teal w3-center">CITIZEN CARD</h1>
	<h2>CARD NO:<input type=text name=card></h2>
	<div class="w3-card w3-right" style="height: 350px;width: 250px;">
	<img src="photo.jsp?vn=<%=vn%>" height="350px" width="250px"></div>
	<table class="" >
	<%
	while(rs.next())
	{
		%><tr>
		
		<td>NAME</td><td><input type=text  name=name value=<%=rs.getString(1) %>></td></tr>
		<tr><td>GENDER</td><td><input type=text  name=gen value=<%=rs.getString(8) %>></td></tr>
		<tr><td>DOB</td><td><input type=text  name=dob value=<%=rs.getString(4) %>></td></tr>
		<tr><td>MOBILE NO</td><td><input type=text  name=mob value=<%=rs.getString(2) %>></td></tr>
		<tr><td>BLOOD GROUP</td><td><input type=text  name=bg value=<%=rs.getString(5) %>></td></tr>
		<tr><td>VOTER ID NO</td><td><input type=text  name=vn value=<%=rs.getString(6) %>></td></tr>
		<tr><td>RATIONCARD NO</td><td><input type=text  name=rn value=<%=rs.getString(7) %>></td></tr>
		<tr><td>EMAIL</td><td><input type=text  name=email value=<%=rs.getString(3) %>></td></tr>
		<tr><td>ADDRESS 1</td><td><input type=text  name=v value=<%=rs.getString(9) %>></td></tr>
		<tr><td></td><td><input type=text  name=m value=<%=rs.getString(10) %>></td></tr>
		<tr><td></td><td><input type=text  name=d value=<%=rs.getString(11) %>></td></tr>
		<tr><td></td><td><input type=text  name=s value=<%=rs.getString(12) %>></td></tr>
		<tr><td></td><td><input type=text  name=ads2 value=<%=rs.getString(13) %>></td></tr>

		<tr><td></td><td><input type=hidden  name=pass value=<%=rs.getString(14) %>></td></tr>

		<tr><td></td><td><input type=hidden  name=uid value=<%=rs.getString(16) %>></td></tr>
		<tr><td></td><td><input type=submit class="w3-button w3-teal" value=ISSUE></td></tr>

	<%
	}

	%></table></div></form><%
	
}catch(SQLException e)
{
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
%>
</body>
</html>