package main.webapp.java.controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	private final String pwd = "password";
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String uPwd = request.getParameter("pwd");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		if(email == null || uPwd == null) {
			response.sendRedirect(request.getContextPath() + "/Login.jsp");
			return;
		}
		
		logger.debug("Login served: {}", email);
		if(uPwd.equals(this.pwd)) {
			try {
				HttpSession session = request.getSession();
				
				session.setAttribute("email", email);
				session.setAttribute("nome", nome);
				session.setAttribute("cognome", cognome);
				session.setAttribute("loggedSince", Calendar.getInstance().getTime().getTime());
				response.sendRedirect(request.getContextPath() + "/Welcome.jsp");
				return;
			}catch (Exception e ) {
				logger.error("Login ERROR:\t{}" , e);
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/LoginError.jsp");
			System.out.println(uPwd);
			return;
		}
		
	}

}
