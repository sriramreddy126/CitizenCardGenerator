package src;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCitizen
 */
@WebServlet("/DeleteCitizen")
public class DeleteCitizen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCitizen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
			String vn=request.getParameter("vn");
			Statement ss2=con.createStatement();
			String sql2="DELETE FROM admin_req where vn="+vn;
			int k1=ss2.executeUpdate(sql2);
			Statement ss1=con.createStatement();
			String sql="DELETE FROM citizen where vn="+vn;
			int k=ss1.executeUpdate(sql);
			Statement ss3=con.createStatement();
			String sql3="DELETE FROM approveman where vn="+vn;
			int k3=ss3.executeUpdate(sql3);
			if(k>0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("citizenRequests.jsp");
				rd.forward(request, response);
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
