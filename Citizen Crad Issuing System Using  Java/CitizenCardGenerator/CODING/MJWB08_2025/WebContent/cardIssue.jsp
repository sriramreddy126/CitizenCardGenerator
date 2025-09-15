<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="w3.css">
</head>
<body>
<h1 STYLE="font-size: 100px" class="w3-center w3-teal">CITIZEN CARDS</h1>
<%
try{  
	String vn=request.getParameter("vn");
	System.out.println(vn);
	String card=request.getParameter("card");
	System.out.println(card);
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
	
	String sql="select * from card where card_no='"+card+"'";
	PreparedStatement sc=con.prepareStatement(sql);
	//sc.setString(1, vn);
	ResultSet rs=sc.executeQuery(sql);
	
	%>
	<div class="w3-card w3-display-middle" style="height: 500px;width: 600px;">
	<h1 class="w3-teal w3-center">CITIZEN CARD</h1>
	<h2>CARD NO:<%=card %></h2>
	<div class="w3-card w3-right" style="height: 350px;width: 250px;">
	<img src="photo.jsp?vn=<%=vn%>" height="350px" width="250px"></div>
	<table class="" >
	<%
	while(rs.next())
	{
		%><tr>
		
		<td>NAME</td><td><%=rs.getString(2) %></td></tr>
		<tr><td>GENDER</td><td><%=rs.getString(3) %></td></tr>
		<tr><td>DOB</td><td><%=rs.getString(4) %></td></tr>
		<tr><td>MOBILE NO</td><td><%=rs.getString(5) %></td></tr>
		<tr><td>BLOOD GROUP</td><td><%=rs.getString(6) %></td></tr>
		<tr><td>VOTER ID NO</td><td><%=rs.getString(7) %></td></tr>
		<tr><td>RATIONCARD NO</td><td><%=rs.getString(8) %></td></tr>
		<tr><td>EMAIL</td><td><%=rs.getString(9) %></td></tr>
		<tr><td>ADDRESS 1</td><td><%=rs.getString(10) %>,<%=rs.getString(11) %><br><%=rs.getString(12) %><br><%=rs.getString(13) %>.</td></tr>
		<tr><td>ASSRESS 2</td><td><%=rs.getString(14) %></td></tr>
		<tr><td>Date of Issuing</td><td><%=rs.getString(11) %></td></tr>
		<%
	}
	%></table>
	</div><a href="AdminHome.jsp" class="w3-button w3-teal">back to home</a>
	<%
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