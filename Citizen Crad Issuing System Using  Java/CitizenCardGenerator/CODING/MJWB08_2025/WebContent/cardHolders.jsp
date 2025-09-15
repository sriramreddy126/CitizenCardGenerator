<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
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
<button onclick="goBack()" class="w3-center w3-teal w3-button">Go Back</button><a href="login.html" class="w3-button w3-red">logout</a>
<%
try{  

	
	
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
	
	String sql="select * from card";
	PreparedStatement sc=con.prepareStatement(sql);
	//sc.setString(1, vn);
	ResultSet rs=sc.executeQuery(sql);
	
	%>
	
	<table class="w3-table" >
	<tr><th>PHOTO</th><th>CARD NO</th><th>NAME</th><th>DOB</th><TH>ADDRESS</TH><TH>DATE OF ISSUING</TH></tr>
	<%
	while(rs.next())
	{
		%><tr><form action="DeleteCard" method="get"> 
		<td><img src="photo.jsp?vn=<%=rs.getString(7) %>" height="50px" width="50px"><input type="hidden" value=<%=rs.getString(1) %> name=card></td>
		<td><%=rs.getString(1) %></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(10) %>,<%=rs.getString(11) %><br><%=rs.getString(12) %><br><%=rs.getString(13) %>.</td>
		<td><%=rs.getDate(17) %></td>
		<td><input type=submit class="w3-teal w3-button" value=delete></td></form></tr>
		<%
	}
	%></table>
	
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