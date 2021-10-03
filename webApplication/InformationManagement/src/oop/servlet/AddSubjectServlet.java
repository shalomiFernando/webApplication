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
//import oop.model.Subject;
//import oop.service.ISchoolService;
//import oop.service.SchoolService;
//
//import java.util.*;
//
///**
// * Servlet implementation class LoginServlet
// */
//public class AddSubjectServlet extends HttpServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public AddSubjectServlet() {
//		super();
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("I have an error");
//         
//         String subjectID = request.getParameter("id");
//         Subject subject = null;
//         
//         //This condition is true when the form is displayed to edit an existing teacher
//         if(subjectID != "") {
//        	 ISchoolService iSchoolService = new SchoolService();
//        	 List<Subject> subjectsMatched = iSchoolService.getSubjects(subjectID);
//        	 if(subjectsMatched != null) {
//        	    subject = subjectsMatched.get(0);
//        	 }
//         }
//		 
//		 String destination = "/AddSubject.jsp"; 
//		 request.setAttribute("subject", subject);
//		 		 
//		 RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
//		 rd.forward(request, response); 
//		
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {	
//
//		response.setContentType("text/html");
//		
//		Subject subject = new Subject();
//		
//		subject.setSubjectID(request.getParameter("subjectID").trim());
//		subject.setName(request.getParameter("name").trim());
//		subject.setGrade(Integer.parseInt(request.getParameter("grade").trim()));
//		subject.setDescription(request.getParameter("description").trim());
//		
//		String subjectID = request.getParameter("id");
//
//		System.out.println("I am inside the servlet: " + (subjectID != null));
//		if(subjectID != null) {
//			ISchoolService iSchoolService = new SchoolService();
//			boolean result = iSchoolService.updateSubject(subject);
//			System.out.println("Updated:"+result);
//		}
//		else {				
//			ISchoolService iSchoolService = new SchoolService();
//			iSchoolService.addSubject(subject);
//	    }
//
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListSubjects.jsp");
//		dispatcher.forward(request, response);
//	}
//}
