package oop.service;

import java.util.ArrayList;
import java.util.List;

//import oop.model.Event;
//import oop.model.Subject;
import oop.model.Teacher;
import oop.util.DataAccessLayer;

public class SchoolService implements ISchoolService{
	
    private DataAccessLayer data;
	
	public SchoolService() {
		data = new DataAccessLayer();
	}
	//Teacher methods by Shalomi Dilki
	
	@Override
	public List<Teacher> getTeachers(String teacherID) {
						
		List<Teacher> teacherList = new ArrayList<Teacher>();
		
		try {
		
		   teacherList = data.getAllTeachers(teacherID);
		}
		catch(Exception ex) {
			System.out.println("Teachers could not be retreived: "+ex.getMessage());			
		}
		
		return teacherList;
	}	
	
	@Override
	public void addTeacher(Teacher teacher) {

		try {
		   data.insertTeacher(teacher);
		}
		catch(Exception ex) {
			System.out.println("Teacher could not be inserted: "+ex.getMessage());			
		}
	}	
	
	@Override
	public void deleteTeacher(String teacherID) {

		try {
		   data.deleteTeacher(teacherID);
		}
		catch(Exception ex) {
			System.out.println("Teacher could not be deleted: "+ex.getMessage());			
		}
	}
	
	@Override
	public boolean updateTeacher(Teacher teacher) {
        boolean result = false;
		try {
		   result = data.updateTeacher(teacher);
		}
		catch(Exception ex) {
		    System.out.println("Teacher could not be updated: "+ex.getMessage());		
		}
		return result;
	}
	
	//Subject methods by Prasadani Jayamaha
	
//	@Override
//	public void addSubject(Subject subject) {
//		
//		try {
//			data.insertSubject(subject);
//		}
//		catch(Exception ex) {
//			System.out.println("Subject could not be inserted: "+ex.getMessage());	
//		}
//	}
//
//	@Override
//	public List<Subject> getSubjects(String subjectID) {
//		
//        List<Subject> subjectList = new ArrayList<Subject>();
//		
//        try {
//		   subjectList = data.getAllSubjects(subjectID);
//        }
//        catch(Exception ex) {
//			System.out.println("Subjects could not be retreived: "+ex.getMessage());	
//		}
//		
//		return subjectList;
//	}
//
//	@Override
//	public boolean updateSubject(Subject subject) {
//		
//		boolean result = false;
//		try {
//		   result = data.updateSubject(subject);
//		}
//		catch(Exception ex) {
//		   System.out.println("Subject could not be updated: "+ex.getMessage());	
//		}
//		return result;
//	}

//	@Override
//	public void deleteSubject(String subjectID) {
//		
//		try {
//			data.deleteSubject(subjectID);
//		}
//		catch(Exception ex) {
//			System.out.println("Subject could not be deleted: "+ex.getMessage());	
//		}
//	}

	//Event methods by Abimani Kumarage
	
//	@Override
//	public List<Event> getEvents(String eventID) {
//		
//        List<Event> eventList = new ArrayList<Event>();
//        
//        try {		
//	    	eventList = data.getAllEvents(eventID);
//        }
//        catch(Exception ex) {
//			System.out.println("Events could not be retreived: "+ex.getMessage());	
//		}
//		
//		return eventList;	
//	}
//	
//	@Override
//	public void addEvent(Event event) {
//
//		try {
//		   data.insertEvent(event);
//		}
//		catch(Exception ex) {
//		   System.out.println("Event could not be inserted: "+ex.getMessage());	
//		}
//	}
//	
//	@Override
//	public boolean updateEvent(Event event) {
//		
//		boolean result = false;
//		try {
//		   result = data.updateEvent(event);
//		}
//		catch(Exception ex) {
//		   System.out.println("Event could not be updated: "+ex.getMessage());	
//		}
//		return result;
//	}
//	
//	@Override
//	public void deleteEvent(String eventID) {
//		
//		try {
//			data.deleteEvent(eventID);
//		}
//		catch(Exception ex) {
//			 System.out.println("Event could not be deleted: "+ex.getMessage());		
//		}
//	}
}
