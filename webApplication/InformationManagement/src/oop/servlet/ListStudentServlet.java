package oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStudentServlet
 */
public class ListStudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListStudentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setAttribute("StudentID",null);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListStudents.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
        String studentID = request.getParameter("StudentID");		
		
		response.setContentType("text/html");
		request.setAttribute("StudentID",studentID);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListStudents.jsp");
		dispatcher.forward(request, response);
	}

}
