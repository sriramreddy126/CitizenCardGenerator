package src;

import java.io.IOException;
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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String old=request.getParameter("old");
		String pass=request.getParameter("pass");
		HttpSession hs=request.getSession();
		String card=(String)hs.getAttribute("card");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
			Statement sc=con.createStatement();
			String q="select * from card where card_no='"+card+"'";
			ResultSet i=sc.executeQuery(q);
			if(i.next())
			{
				if(i.getString(16).equals(old))
				{
				Statement sc2=con.createStatement();
				String sql2="update card set pwd='"+pass+"'where card_no='"+card+"'";	
				int j=sc2.executeUpdate(sql2);
				if(j>0)
				{
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=Password changed Successfully&&to=citizenHome.jsp");
					rd.forward(request, response);
				}else{
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=somthing went wrong&&to=citizenHome.jsp");
					rd.forward(request, response);
				}
				}else{
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=somthing went wrong&&to=citizenHome.jsp");
					rd.forward(request, response);
				}
			}
			
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
