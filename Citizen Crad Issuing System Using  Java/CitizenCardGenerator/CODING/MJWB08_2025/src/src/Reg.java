package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reg
 */
@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubs
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String mob=request.getParameter("mob");
		String mail=request.getParameter("email");
		String dob=request.getParameter("dob");
		String bg=request.getParameter("bg");
		String vn=request.getParameter("vn");
		String rn=request.getParameter("rn");
		String gen=request.getParameter("gen");
		String v1=request.getParameter("vil1");
		String m1=request.getParameter("mnd1");
		String d1=request.getParameter("dis1");
		String s1=request.getParameter("st1");
		String v2=request.getParameter("vil2");
		String m2=request.getParameter("mnd2");
		String d2=request.getParameter("dis2");
		String s2=request.getParameter("st2");
		String uid=request.getParameter("uid");
		String pass=request.getParameter("pass");
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
			String sql="insert into citizen values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, mob);
			ps.setString(3, mail);
			ps.setString(4, dob);
			ps.setString(5, bg);
			ps.setString(6, vn);
			ps.setString(7, rn);
			ps.setString(8, gen);
			ps.setString(9, v1);
			ps.setString(10, m1);
			ps.setString(11, d1);
			ps.setString(12, s1);
			ps.setString(13, v2+" , "+m2+" , "+d2+" , "+s2);
			ps.setString(14, pass);
			ps.setString(15, "");
			ps.setString(16, uid);
			int i=ps.executeUpdate();
			System.out.println(i);
			if(i==1)
			{
				PreparedStatement ps1=con.prepareStatement("insert into admin_req values(?,?,?,?)");
				ps1.setString(1, name);
				ps1.setString(2, vn);
				java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime()); 
				ps1.setTimestamp(3, date);
				ps1.setString(4, "pending");
				int j=ps1.executeUpdate();
				if(j==1)
				{
					HttpSession hs=request.getSession();
					hs.setAttribute("vn", vn);
					response.sendRedirect("uploadPhoto.jsp");
					out.println("<h1>Registration successfull</h1>");
					out.println("<h3>your request is successfully sended to admin</h3>");
				}else{
					
					RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msgSomthing went wrong to send your request to admin=&&to=Home.html");
					rd.forward(request, response);
				}
			}else{
				
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp?msg=unable to register&&to=Home.html");
				rd.forward(request, response);
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
