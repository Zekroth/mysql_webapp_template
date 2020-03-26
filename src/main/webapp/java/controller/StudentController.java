package main.webapp.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import main.webapp.java.controller.services.StudentServiceImpl;
import main.webapp.java.model.Studente;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/Student")
public class StudentController extends HttpServlet implements StudentServiceImpl{
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(Login.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException{
		try {
			String operation = request.getParameter("op");
			String mode = request.getParameter("m");
			
			if(operation.equals("c")) {
				
				if(request.getParameter("id") == null) {
					//utente non creato -> redirect pagina di creazione
					response.sendRedirect("/Studente/Crea.jsp");
				}else {
					//utente creato -> verifica dati, redirect home
					if(request.getParameter("id") != "") {
						//Redirect error
					}
					
					//Fine verifiche
					
					Studente s = new Studente(request.getParameter("name"),request.getParameter("surname"));
					
					insertStudent(s);
				}
				
			}else if(operation.equals("r")) {
				if(mode.equals("l")) {
					//Redirect list users
				}else {
					//Redirect find user
					HttpSession session = request.getSession();
					try {
						
						int id = Integer.parseInt(request.getParameter("id"));
						session.setAttribute("displayStudentList", getStudentById(id));
						
					}catch(NumberFormatException e) {
						
						String nome = request.getParameter("name");
						String cognome = request.getParameter("surname");
						
						List<Studente> results = getStudentsBySurname(cognome);
						
						getStudentsByName(nome).forEach(s -> {
							results.add(s);
						});
						
						Set<Studente> unifiedResults = new HashSet<Studente>(results);
						
						
						session.setAttribute("displayStudentList", unifiedResults);
						response.sendRedirect("/Studente/ViewList.jsp");
					}
					
					
					

					
					
				}
			}else if(operation.equals("u")) {
				
			}else if(operation.equals("d")) {
				
			}
		}catch(Exception e) {
			logger.error("Login ERROR:\t{}" , e);
		}
	}

	
	
	

}
