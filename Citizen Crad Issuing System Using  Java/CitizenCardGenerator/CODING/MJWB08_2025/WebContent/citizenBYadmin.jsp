<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*;" %>
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
	%><table class="w3-table">
	<%
	while(rs.next())
	{
		%><tr>
		
		<td>NAME</td><td><%=rs.getString(1) %></td></tr>
		<tr><td>GENDER</td><td><%=rs.getString(8) %></td></tr>
		<tr><td>DOB</td><td><%=rs.getString(4) %></td></tr>
		<tr><td>MOBILE NO</td><td><%=rs.getString(2) %></td></tr>
		<tr><td>BLOOD GROUP</td><td><%=rs.getString(5) %></td></tr>
		<tr><td>VOTER ID NO</td><td><%=rs.getString(6) %></td></tr>
		<tr><td>RATIONCARD NO</td><td><%=rs.getString(7) %></td></tr>
		<tr><td>EMAIL</td><td><%=rs.getString(3) %></td></tr>
		<tr><td>ADDRESS 1</td><td><%=rs.getString(9) %></td></tr>
		<tr><td></td><td><%=rs.getString(10) %></td></tr>
		<tr><td></td><td><%=rs.getString(11) %></td></tr>
		<tr><td></td><td><%=rs.getString(12) %></td></tr>
		<tr><td>ADDRESS 2</td><td><%=rs.getString(13) %></td></tr>
		<tr><td><a href="StoreToManager?vn=<%=rs.getString(6)%>" class="w3-button w3-teal">pass this request to manager section</a></td></tr>
		

		<%
	}
	%></table><%
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