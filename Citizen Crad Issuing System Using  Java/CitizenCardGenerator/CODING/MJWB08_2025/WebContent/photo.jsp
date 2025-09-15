<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page import="java.sql.*"%>
	<%@ page import="java.io.*"%>
	<%
		Blob image = null;
		Connection con = null;
		byte[] imgData = null;
		Statement stmt = null;
		ResultSet rs = null;
		String vn=request.getParameter("vn");
		System.out.println(vn+"hsagdh");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen", "root", "root");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select photo from image where vn ='"+vn+"';");
			if (rs.next()) {
				image = rs.getBlob(1);
				imgData = image.getBytes(1, (int) image.length());
			} else {
				return;
			}
			// display the image
			//response.setContentType("image/jpg");
			OutputStream o = response.getOutputStream();
			o.write(imgData);
			o.flush();
			o.close();
		} catch (Exception e) {
			e.printStackTrace();
			/* out.println("Unable To Display image");
			out.println("Image Display Error=" + e.getMessage());
			 */return;
		} 
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
			
			}
			out.clear();
			out=pageContext.pushBody();
			
	%>
			
	</body>
	</html>	
	