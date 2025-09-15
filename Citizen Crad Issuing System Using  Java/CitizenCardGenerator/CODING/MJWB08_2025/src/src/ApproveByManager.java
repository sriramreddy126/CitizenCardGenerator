package src;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApproveByManager
 */
@WebServlet("/ApproveByManager")
public class ApproveByManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveByManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vn =request.getParameter("vn");
		String ap =request.getParameter("ap");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
			
			String sql="select * from citizen where vn='"+vn+"'";
			PreparedStatement sc=con.prepareStatement(sql);
			//sc.setString(1, vn);
			ResultSet rs=sc.executeQuery(sql);
			if(rs.next())
			{
				String name=rs.getString(1);
				String dst=rs.getString(11);
				PreparedStatement s=con.prepareStatement("insert into approveman values(?,?,?,?,?)");
				s.setString(1, name);
				s.setString(2, vn);
				java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime()); 
				s.setTimestamp(3, date);
				s.setString(4, ap);
				s.setString(5, dst);
				int i=s.executeUpdate();
				if(i==1)
				{
					System.out.println("successfully approve by manager");
					java.sql.Statement s1=con.createStatement();
					int j=s1.executeUpdate("update admin_req set status='approved by distict manager' where vn='"+vn+"'");
					if(j==1)
					{
						Statement ss1=con.createStatement();
						sql="DELETE FROM admintoman where vn="+vn;
						int k=ss1.executeUpdate(sql);
						System.out.println("status upadated successfully");
						RequestDispatcher rd=request.getRequestDispatcher("managerHome.jsp");
						rd.forward(request, response);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
