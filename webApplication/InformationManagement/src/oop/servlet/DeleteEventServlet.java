//package oop.servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import oop.service.SchoolService;
//import oop.service.ISchoolService;
//
///**
// * Servlet implementation class DeleteEventServlet
// */
//@WebServlet("/DeleteEventServlet")
//public class DeleteEventServlet extends HttpServlet {
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DeleteEventServlet() {
//        super();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html");
//
//		String eventID = request.getParameter("id");			
//		
//		ISchoolService iSchoolService = new SchoolService();
//		iSchoolService.deleteEvent(eventID);
//		
//		System.out.println("I am in the delete servlet");
//
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListEvents.jsp");
//		dispatcher.forward(request, response);
//		
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//				
//	}
//
//}
