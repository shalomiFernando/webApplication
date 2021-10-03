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
// * Servlet implementation class DeleteSubjectservlet
// */
//@WebServlet("/DeleteSubjectservlet")
//public class DeleteSubjectServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public DeleteSubjectServlet() {
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
//		String subjectID = request.getParameter("id");			
//		
//		ISchoolService iSchoolService = new SchoolService();
//		iSchoolService.deleteSubject(subjectID);
//
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListSubjects.jsp");
//		dispatcher.forward(request, response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		
//	}
//
//}
