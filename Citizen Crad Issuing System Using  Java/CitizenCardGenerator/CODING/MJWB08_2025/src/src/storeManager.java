package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class storeManager
 */
@WebServlet("/storeManager")
public class storeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String mob=request.getParameter("mob");
		String mail=request.getParameter("email");
		String dob=request.getParameter("dob");
		String vn=request.getParameter("vn");
		String gen=request.getParameter("gen");
		String d1=request.getParameter("dis");
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
			String sql="insert into manager values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, mob);
			ps.setString(3, mail);
			ps.setString(4, dob);
			ps.setString(5, vn);
			ps.setString(6, gen);
			ps.setString(7, d1);
			ps.setString(8, uid);
			ps.setString(9, pass);
			int i=ps.executeUpdate();
			System.out.println(i);
			if(i==1)
			{
				
					out.println("<h1>Manager Registration successfull</h1>");
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=Manager Added Successfully&&to=AdminHome.jsp");
					rd.forward(request, response);
				
				}else{
					out.println("<h1>Somthing went wrong to add manager</h1>");
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
