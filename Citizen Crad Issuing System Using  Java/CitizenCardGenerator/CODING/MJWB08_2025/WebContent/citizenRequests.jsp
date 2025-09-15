<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*;"%>
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
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
	Statement sc=con.createStatement();
	String sql="select * from admin_req;";
	ResultSet rs=sc.executeQuery(sql);
	%><table class="w3-table">
	<th>NAME</th><th>VOTER ID</th><th>DATE</th><th>STATUS</th>
	<%
	while(rs.next())
	{
		%><tr><form action="DeleteCitizen" method="get" >
		<td><%=rs.getString(1) %></td><td><input type="hidden" value=<%=rs.getString(2) %> name=vn><%=rs.getString(2) %></td><td><%=rs.getDate(3) %></td><td><%=rs.getString(4) %></td>
		<td><a href=citizenBYadmin.jsp?vn=<%=rs.getString(2)%> class="w3-button w3-teal">View Details</a></td><td><input type="submit"  value=delete class="w3-button w3-teal" ></td>
		</form>
		</tr>
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