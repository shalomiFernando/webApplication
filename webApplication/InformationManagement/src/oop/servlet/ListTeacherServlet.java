package oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oop.model.Teacher;
import oop.service.SchoolService;
import oop.service.ISchoolService;

/**
 * Servlet implementation for List of Employees
 */
public class ListTeacherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListTeacherServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      
		response.setContentType("text/html");
		request.setAttribute("TeacherID",null);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListTeachers.jsp");
		dispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String teacherID = request.getParameter("TeacherID");		
		
		response.setContentType("text/html");
		request.setAttribute("TeacherID",teacherID);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListTeachers.jsp");
		dispatcher.forward(request, response);
	}

}
