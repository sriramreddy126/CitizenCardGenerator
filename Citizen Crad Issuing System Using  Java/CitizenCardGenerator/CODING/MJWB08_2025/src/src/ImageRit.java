package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


/**
 * Servlet implementation class ImageRit
 */
@MultipartConfig(fileSizeThreshold=0,  maxFileSize=5242880, maxRequestSize=20971520)   // 20 MB
@WebServlet("/ImageRit")
public class ImageRit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageRit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request1, HttpServletResponse response1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/citizen","root","root");
		response1.setContentType("text/html");
		System.out.println(request1.getParameter("file1"));
		InputStream inpstm=null;
		PrintWriter ou=response1.getWriter();
		 Part img=request1.getPart("file1");
		if(img!=null)
		{
		
			System.out.println("get img");
			inpstm=img.getInputStream();
		}
	
		System.out.println("set img");
		HttpSession sc=request1.getSession();
		String ui=(String) sc.getAttribute("vn");
		System.out.println("send");
		String sql="insert into image values(?,?,?)";
		PreparedStatement statement=con.prepareStatement(sql);
		  if (inpstm != null) {
              // fetches input stream of the upload file for the blob column
			  statement.setString(1, "fewfm");
			  statement.setString(2,ui);
              statement.setBinaryStream(3, inpstm,(int)img.getSize());
          }
		  int rs=statement.executeUpdate();
		if(rs==1)
		{
			ou.println("registration successfull");
			
			RequestDispatcher rd=request1.getRequestDispatcher("success.jsp?msg='registration successfull'&&to=Home.html");
			rd.forward(request1, response1);
		}else{
			ou.println("UNABLE TO REGISTER");
		}
		//response1.getWriter().append("Served at: ").append(request1.getContextPath());
	
		doGet(request1, response1);
	}catch (SQLException e) {
		e.printStackTrace();
		// TODO: handle exception
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	}

}
