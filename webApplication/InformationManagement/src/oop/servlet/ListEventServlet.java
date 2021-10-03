//package oop.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import oop.model.Event;
//import oop.service.SchoolService;
//import oop.service.ISchoolService;
//
///**
// * Servlet implementation for List of Employees
// */
//public class ListEventServlet extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public ListEventServlet() {
//		super();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//      
//		response.setContentType("text/html");
//		request.setAttribute("EventID",null);
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListEvents.jsp");
//		dispatcher.forward(request, response);		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		//text box value
//		String eventID = request.getParameter("EventID");		
//		
//		response.setContentType("text/html");
//		request.setAttribute("EventID",eventID);
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListEvents.jsp");
//		dispatcher.forward(request, response);
//	}
//
//}
