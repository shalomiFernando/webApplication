//package oop.servlet;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import oop.model.Event;
//import oop.model.Teacher;
//
//import oop.service.SchoolService;
//import oop.service.ISchoolService;
//
///**
// * Servlet implementation class AddEventServlet
// */
//@WebServlet("/AddEventServlet")
//public class AddEventServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddEventServlet() {
//        super();
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		String eventID = request.getParameter("id");
//        Event event = null;
//        if(eventID != "") {
//	         ISchoolService iSchoolService = new SchoolService();;
//	         List<Event> events = iSchoolService.getEvents(eventID);
//	         event = events.get(0);
//        }
//		 
//		 String destination = "/AddEvent.jsp"; 
//		 request.setAttribute("event", event);
//		 		 
//		 RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
//		 rd.forward(request, response);
//	}
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.setContentType("text/html");
//
//		Event event = new Event();
//		
//		event.setEventID(request.getParameter("eventID").trim());
//		event.setName(request.getParameter("name").trim());
//		event.setDescription(request.getParameter("description").trim());
//		event.setLocation(request.getParameter("location").trim());
//		event.setBudget(Float.parseFloat(request.getParameter("budget").trim()));
//		
//		String eventID = request.getParameter("id");
//
//		System.out.println("I am inside the servlet: " + (eventID != null));
//		if(eventID != null) {
//			ISchoolService iSchoolService = new SchoolService();
//			boolean result = iSchoolService.updateEvent(event);
//			System.out.println("Updated:"+result);
//		}
//		else {				
//			ISchoolService iSchoolService = new SchoolService();
//			iSchoolService.addEvent(event);
//	    }
//
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListEvents.jsp");
//		dispatcher.forward(request, response);
//	}
//	
//}
