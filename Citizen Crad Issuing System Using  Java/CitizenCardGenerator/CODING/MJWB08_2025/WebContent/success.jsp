<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="w3.css">
</head>
<body>
<%
String msg=request.getParameter("msg");
String to=request.getParameter("to");

%>
  <div class="w3-container w3-teal" style="height:200px;width:500px;">
        
      <div class="w3-container">
      	<a href="<%=to %>" class="w3-button w3-red w3-display-topleft">close</a><br><br>
        <h1 class="w3-text-white"><%=msg %></h1>
      </div>
  </div>
</body>
</html>