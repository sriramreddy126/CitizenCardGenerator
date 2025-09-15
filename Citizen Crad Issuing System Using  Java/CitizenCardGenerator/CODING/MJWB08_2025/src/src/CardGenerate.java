package src;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CardGenerate
 */
@WebServlet("/CardGenerate")
public class CardGenerate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CardGenerate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String card=request.getParameter("card");
		String name=request.getParameter("name");
		String mob=request.getParameter("mob");
		String mail=request.getParameter("email");
		String dob=request.getParameter("dob");
		String bg=request.getParameter("bg");
		String vn=request.getParameter("vn");
		String rn=request.getParameter("rn");
		String gen=request.getParameter("gen");
		String v1=request.getParameter("v");
		String m1=request.getParameter("m");
		String d1=request.getParameter("d");
		String s1=request.getParameter("s");
		String ads2=request.getParameter("ads2");
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
			String sql="insert into card values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, card);
			ps.setString(2, name);
			ps.setString(3, gen);
			ps.setString(4, dob);
			ps.setString(5, mob);
			ps.setString(6, bg);
			ps.setString(7, vn);
			ps.setString(8, rn);
			ps.setString(9, mail);
			ps.setString(10, v1);
			ps.setString(11, m1);
			ps.setString(12, d1);
			ps.setString(13, s1);
			ps.setString(14, ads2);
			ps.setString(15, uid);
			ps.setString(16, pass);
			java.sql.Timestamp date1 = new java.sql.Timestamp(new java.util.Date().getTime()); 
			ps.setTimestamp(17, date1);
			int i=ps.executeUpdate();
			System.out.println(i);
			if(i==1)
			{
				Statement ss1=con.createStatement();
				sql="DELETE FROM approveman where vn="+vn;
				int k=ss1.executeUpdate(sql);
				Statement ss2=con.createStatement();
				sql="DELETE FROM admin_req where vn="+vn;
				int k1=ss2.executeUpdate(sql);
				response.sendRedirect("cardIssue.jsp?card="+card+"&&vn="+vn);
			}else{
				out.println("Unable to issue");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
