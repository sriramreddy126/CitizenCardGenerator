package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{  
			PrintWriter out=response.getWriter();
		String logtype=request.getParameter("logtype");
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
			
		if(logtype.equals("citizen"))
		{
			Statement sc=con.createStatement();
			String sql="select * from card;";
			ResultSet rs=sc.executeQuery(sql);
			int count=0;
			String card="";
			String vn="";
			while (rs.next()) {
				if(uid.equals(rs.getString(15))&&rs.getString(16).equals(pass))
				{
					count++;
					card=rs.getString(1);
					vn=rs.getString(7);
				}
			}
			if(count>0)
			{
				HttpSession hs=request.getSession();
				hs.setAttribute("card", card);
				response.sendRedirect("citizenHome.jsp?vn="+vn);
			}else			{
				Statement sc2=con.createStatement();
				String sql2="select * from citizen where uid='"+uid+"';";
				ResultSet rs2=sc2.executeQuery(sql2);
				if(rs2.next())
				{
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=your citizen card is not issued&&to=login.html");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=wrong username or password&&to=login.html");
					rd.forward(request, response);
				}
				
				
			} 
		}else if(logtype.equals("admin"))
		{
			if(uid.equals("admin")&&pass.equals("admin123"))
			{
				response.sendRedirect("AdminHome.jsp");
			}else
			{
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=login faild plese check username and password&&to=login.html");
				rd.forward(request, response);
			}
		}else if(logtype.equals("manager"))
		{
			Statement sc=con.createStatement();
			String sql="select * from manager;";
			ResultSet rs=sc.executeQuery(sql);
			int count=0;
			String dst="";
			while (rs.next()) {
				if(uid.equals(rs.getString(8))&&rs.getString(9).equals(pass))
				{
					count++;
					dst=rs.getString(7);
				}
			}
			if(count>0)
			{
				HttpSession hs=request.getSession();
				hs.setAttribute("dst", dst);
				response.sendRedirect("managerHome.jsp");
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=login faild&&to=login.html");
				rd.forward(request, response);
			}
		}
		}catch(ClassNotFoundException e1)
		{
			
		}catch (SQLException e) {
			// TODO: handle exception
		}catch(NullPointerException e)
		{
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=select user type&&to=login.html");
			rd.forward(request, response);
		}
		//out.println(logtype);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
