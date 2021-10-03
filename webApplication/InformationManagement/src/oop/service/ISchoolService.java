package oop.service;

import java.util.List;
import java.util.logging.Logger;

//import oop.model.Event;
//import oop.model.Subject;
import oop.model.Teacher;

public interface ISchoolService {
	// Teacher methods by Shalomi Dilki
	
		/** Initialize logger */
		public static final Logger log = Logger.getLogger(ISchoolService.class.getName());

		/**
		 * Add teachers to teacher table
		 * @param teacher
		 */
		public void addTeacher(Teacher teacher);

		/**
		 * Get all list of teachers
		 * @param teacherID
		 * @return List<Teacher>
		 */
		public List<Teacher> getTeachers(String teacherID);
		
		/**
		 * Update existing teacher
		 * @param teacher
		 * 
		 * @return boolean
		 */
		public boolean updateTeacher(Teacher teacher);

		/**
		 * Delete existing teacher
		 * 
		 * @param teacherID
		 */
		 public void deleteTeacher(String teacherID);
		 
		 // Subject methods by Prasadani Jayamaha
		 
	    /**
		 * Add subjects to Subject table
		 * @param subject
		 */
		// public void addSubject(Subject subject);
			
		/**
		 * Get all list of subjects
		 * @param subject
		 * @return List<Subject>
		 */
		// public List<Subject> getSubjects(String subjectID);
		
		/**
		 * Update existing employee
		 * @param employeeID
		 * @param employee
		 * 
		 * @return
		 */
		// public boolean updateSubject(Subject subject);

		/**
		 * Remove existing employee
		 * 
		 * @param employeeID
		 */
		// public void deleteSubject(String subjectID);
				
		
		 // Subject methods by Prasadani Jayamaha
		
		 /**
		 * Add events for events table
		 * @param events
		 */
		
		// public void addEvent(Event event);
			
		 /**
		 * Get all list of events
		 * 
		 * @return ArrayList<Events>
	     */
			
	//	 public List<Event> getEvents(String eventID);
			
		 /**
		 * Update existing event
		 * @param eventID
		 * @param event
		 * 
		 * @return
		 */
		    
	    // public boolean updateEvent(Event event);
		 /**
		 * Remove existing event
		 * 
		 * @param eventID
		 */
		// public void deleteEvent(String eventID);	

}
