package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

import dao.UserLoginDao;
import domain.UserLoginDomain;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String lang = request.getParameter("language");
		
		UserLoginDao userLoginDao = new UserLoginDao();
		try {
			UserLoginDomain userLoginDomain = userLoginDao.getUserLoginDomain(user);
			request.removeAttribute("err");

			if (userLoginDomain !=null) {
				if(pass.equals(userLoginDomain.getPassword())){
					HttpSession session = request.getSession();
		            session.setAttribute("user",user);
		            session.setAttribute("lang",lang);
		            session.setAttribute("time",new Date());
		            response.sendRedirect("Welcome.jsp");
				}else{
					request.setAttribute("err", "Error Not Found User");
				     RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
				     view.forward(request, response);
				}
				
			} else {
				request.setAttribute("err", "Error Not Found User");
			     RequestDispatcher view = request.getRequestDispatcher("Login.jsp");
			     view.forward(request, response);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html");
		
	/*	if("ched".equals(user) && "1234".equals(pass)){
			HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("lang",lang);
            session.setAttribute("time",new Date());
            response.sendRedirect("Welcome.jsp");
		}else{
			response.sendRedirect("Login.jsp");
		}*/
	}

}
