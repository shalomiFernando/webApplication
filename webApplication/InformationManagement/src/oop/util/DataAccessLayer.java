package oop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

//import oop.model.Event;
//import oop.model.Subject;
import oop.model.Teacher;;


public class DataAccessLayer {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/StudentDB?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    //Teacher SQL Queries by Shalomi Dilki
    
    private static final String INSERT_TEACHERS = "INSERT INTO TEACHER" + "(ID,FirstName,LastName,Address,Qualifications,Gender,Salary,NIC,Email) VALUES" +
            "(?, ?, ?, ?, ?, ?, ?, ?,?);";
    private static final String SELECT_ALL_TEACHERS = "SELECT * FROM TEACHER";
    
    private static final String SELECT_TEACHER_BY_ID = "SELECT * FROM TEACHER WHERE ID =?";
           
    private static final String UPDATE_TEACHERS = "UPDATE TEACHER SET FirstName =?,LastName=?, Address =?, Qualifications =?, Gender =?, Salary=?, NIC=?, Email=? WHERE ID=?;";
    
    private static final String DELETE_TEACHERS = "DELETE FROM TEACHER WHERE ID = ?;";
    
    
    
    //Event SQL Queries by Abimani Kumarage
    
    private static final String INSERT_EVENTS = "INSERT INTO EVENT" + "(ID,Name,Description,Location,Budget) VALUES" +
            " (?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_EVENTS = "SELECT * FROM EVENT";
    
    private static final String SELECT_EVENT_BY_ID = "SELECT * FROM EVENT WHERE ID =?";
    
    private static final String UPDATE_EVENTS = "UPDATE EVENT SET Name= ?, Description =?, Location =?, Budget =? WHERE ID = ?;";
    
    private static final String DELETE_EVENTS = "DELETE FROM EVENT WHERE ID = ?;";
             
    
    //Subject SQL Queries by Prasadani Jayamaha
    
    private static final String INSERT_SUBJECTS = "INSERT INTO SUBJECT" + "(ID,Name,Grade,Description) VALUES " +
            " (?, ?, ?, ?);";
    private static final String SELECT_ALL_SUBJECTS = "SELECT * FROM SUBJECT";
    
    private static final String SELECT_SUBJECT_BY_ID = "SELECT * FROM SUBJECT WHERE ID =?";
    
    private static final String UPDATE_SUBJECTS = "UPDATE SUBJECT SET Name = ?,Grade= ?, Description =? WHERE ID = ?;";
    
    private static final String DELETE_SUBJECTS = "DELETE FROM SUBJECT WHERE ID = ?;";   
    
          
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    
    //Teacher methods by Shalomi Dilki
    
    public void insertTeacher(Teacher teacher) throws SQLException {
        System.out.println(INSERT_TEACHERS);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TEACHERS)) {
            preparedStatement.setString(1, teacher.getTeacherID());
            preparedStatement.setString(2, teacher.getFirstName());
            preparedStatement.setString(3, teacher.getLastName());
            preparedStatement.setString(4, teacher.getAddress());
            preparedStatement.setString(5, teacher.getQualifications());
            preparedStatement.setString(6, teacher.getGender());
            preparedStatement.setFloat(7, teacher.getSalary());
            preparedStatement.setString(8, teacher.getNic());
            preparedStatement.setString(9, teacher.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
       
    
    public boolean deleteTeacher(String id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_TEACHERS);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        catch(SQLException ex) {
        	printSQLException(ex);
        }
        return rowDeleted;
    }
    
    public boolean updateTeacher(Teacher teacher) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_TEACHERS);) {
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getAddress());
            statement.setString(4, teacher.getQualifications());
            statement.setString(5, teacher.getGender());
            statement.setFloat(6, teacher.getSalary());
            statement.setString(7, teacher.getNic());
            statement.setString(8, teacher.getEmail());            
            statement.setString(9, teacher.getTeacherID());
            
            System.out.println("Statement: " + statement);

            rowUpdated = statement.executeUpdate() > 0;
        }
        catch(SQLException ex) {
        	printSQLException(ex);
        }
        return rowUpdated;
    }
            
    public List <Teacher> getAllTeachers(String teacherID) {
        List <Teacher> teachers = new ArrayList <Teacher>();
    	if(teacherID == null) {
	 
	        // Establishing a Connection
	        try (Connection connection = getConnection();
	
	            //Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TEACHERS);) {
	            System.out.println(preparedStatement);
	            //Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	
	            //Process the ResultSet object.
	            while (rs.next()) {
	            	Teacher tc = new Teacher();
	            	tc.setTeacherID(rs.getString("ID"));
	            	tc.setFirstName(rs.getString("FirstName"));
	            	tc.setLastName(rs.getString("LastName"));
	            	tc.setAddress(rs.getString("Address"));
	                tc.setQualifications(rs.getString("Qualifications"));
	                tc.setGender(rs.getString("Gender"));
	                tc.setSalary(rs.getFloat("Salary"));
	                tc.setNic(rs.getString("NIC"));
	                tc.setEmail(rs.getString("Email"));
	                
	                teachers.add(tc);                            
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
    	}
    	else {
    		// Establishing a Connection
	        try (Connection connection = getConnection();
	
	            //Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TEACHER_BY_ID);) {
	        	preparedStatement.setString(1, teacherID);
	            System.out.println(preparedStatement);
	            //Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	
	            //Process the ResultSet object.
	            while (rs.next()) {
	            	Teacher tc = new Teacher();
	            	tc.setTeacherID(rs.getString("ID"));
	            	tc.setFirstName(rs.getString("FirstName"));
	            	tc.setLastName(rs.getString("LastName"));
	            	tc.setAddress(rs.getString("Address"));
	                tc.setQualifications(rs.getString("Qualifications"));
	                tc.setGender(rs.getString("Gender"));
	                tc.setSalary(rs.getFloat("Salary"));
	                tc.setNic(rs.getString("NIC"));
	                tc.setEmail(rs.getString("Email"));
	                
	                teachers.add(tc);                            
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
    	}
        return teachers;
    }
    
    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    // Event methods by Abibani
    
//	public List<Event> getAllEvents(String eventID) {
//		
//		List <Event> events = new ArrayList <Event>();
//    	if(eventID == null) {
//	 
//	        // Establishing a Connection
//	        try (Connection connection = getConnection();
//	
//	            //Create a statement using connection object
//	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EVENTS);) {
//	            System.out.println(preparedStatement);
//	            //Execute the query or update query
//	            ResultSet rs = preparedStatement.executeQuery();
//	
//	            //Process the ResultSet object.
//	            while (rs.next()) {
//	            	Event eve = new Event();
//	            	eve.setEventID(rs.getString("ID"));
//	            	eve.setName(rs.getString("Name"));
//	            	eve.setDescription(rs.getString("Description"));
//	            	eve.setLocation(rs.getString("Location"));
//	            	eve.setBudget(rs.getFloat("Budget"));	               
//	                
//	                events.add(eve);                             
//	            }
//	        } catch (SQLException e) {
//	            printSQLException(e);
//	        }
//    	}
//    	else {
//    		// Establishing a Connection
//	        try (Connection connection = getConnection();
//	
//	            //Create a statement using connection object
//	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EVENT_BY_ID);) {
//	        	preparedStatement.setString(1, eventID);
//	            System.out.println(preparedStatement);
//	            //Execute the query or update query
//	            ResultSet rs = preparedStatement.executeQuery();
//	
//	            //Process the ResultSet object.
//	            while (rs.next()) {
//	            	Event eve = new Event();
//	            	eve.setEventID(rs.getString("ID"));
//	            	eve.setName(rs.getString("Name"));
//	            	eve.setDescription(rs.getString("Description"));
//	            	eve.setLocation(rs.getString("Location"));
//	            	eve.setBudget(rs.getFloat("Budget"));	               
//	                
//	                events.add(eve);                            
//	            }
//	        } catch (SQLException e) {
//	            printSQLException(e);
//	        }
//    	}
//        return events;
//	}
//
//	public void insertEvent(Event event) throws SQLException{
//		
//		System.out.println(INSERT_EVENTS);
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVENTS)) {
//            preparedStatement.setString(1, event.getEventID());
//            preparedStatement.setString(2, event.getName());
//            preparedStatement.setString(3, event.getDescription());
//            preparedStatement.setString(4, event.getLocation());
//            preparedStatement.setFloat(5, event.getBudget());
//            
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//		
//	}
//	
//	public boolean deleteEvent(String id) throws SQLException {
//        boolean rowDeleted = false;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EVENTS);) {
//            statement.setString(1, id);
//            System.out.println(statement);
//            rowDeleted = statement.executeUpdate() > 0;
//        }
//	    catch (SQLException e) {
//            printSQLException(e);
//        }
//        return rowDeleted;
//    }
//
//	public boolean updateEvent(Event event) throws SQLException{
//		
//		boolean rowUpdated = false;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EVENTS);) {           
//            statement.setString(1, event.getName());
//            statement.setString(2, event.getDescription());
//            statement.setString(3, event.getLocation());
//            statement.setFloat(4, event.getBudget());
//            statement.setString(5, event.getEventID());
//            
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//	    catch (SQLException e) {
//             printSQLException(e);
//        }
//        return rowUpdated;
//	}
	
  	
     /* Prasadi -----*/
	
//	public void insertSubject(Subject subject) throws SQLException{
//		
//		System.out.println(INSERT_SUBJECTS );
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SUBJECTS)) {
//            preparedStatement.setString(1, subject.getSubjectID());
//            preparedStatement.setString(2, subject.getName());
//            preparedStatement.setInt(3, subject.getGrade());
//            preparedStatement.setString(4, subject.getDescription());
//            
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//	}
//
//	public List<Subject> getAllSubjects(String stringID) {
//		
//		List <Subject> subjects = new ArrayList<Subject>();
//    	if(stringID == null) {
//	 
//	        // Establishing a Connection
//	        try (Connection connection = getConnection();
//	
//	            //Create a statement using connection object
//	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SUBJECTS);) {
//	            System.out.println(preparedStatement);
//	            //Execute the query or update query
//	            ResultSet rs = preparedStatement.executeQuery();
//	
//	            //Process the ResultSet object.
//	            while (rs.next()) {
//	            	Subject sub = new Subject();
//	            	sub.setSubjectID(rs.getString("ID"));
//	            	sub.setName(rs.getString("Name"));
//	            	sub.setGrade(rs.getInt("Grade"));
//	            	sub.setDescription(rs.getString("Description"));
//	               	                
//	            	subjects.add(sub);                            
//	            }
//	        } catch (SQLException e) {
//	            printSQLException(e);
//	        }
//    	}
//    	else {
//    		// Establishing a Connection
//	        try (Connection connection = getConnection();
//	
//	            //Create a statement using connection object
//	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SUBJECT_BY_ID);) {
//	        	preparedStatement.setString(1, stringID);
//	            System.out.println(preparedStatement);
//	            //Execute the query or update query
//	            ResultSet rs = preparedStatement.executeQuery();
//	
//	            //Process the ResultSet object.
//	            while (rs.next()) {
//	            	Subject sub = new Subject();
//	            	sub.setSubjectID(rs.getString("ID"));
//	            	sub.setName(rs.getString("Name"));
//	            	sub.setGrade(rs.getInt("Grade"));
//	            	sub.setDescription(rs.getString("Description"));
//	               	                
//	            	subjects.add(sub);         
//	            }
//	        } catch (SQLException e) {
//	            printSQLException(e);
//	        }
//    	}
//        return subjects;
//	}
//	
//	 public boolean deleteSubject(String id) throws SQLException {
//	        boolean rowDeleted = false;
//	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SUBJECTS);) {
//	            statement.setString(1, id);
//	            rowDeleted = statement.executeUpdate() > 0;
//	        }
//	        catch(SQLException ex) {
//	        	printSQLException(ex);
//	        }
//	        return rowDeleted;
//	 }
//	
//	public boolean updateSubject(Subject subject) throws SQLException{
//		
//		boolean rowUpdated = false;
//        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SUBJECTS);) {
//            statement.setString(1, subject.getName());
//            statement.setInt(2, subject.getGrade());
//            statement.setString(3, subject.getDescription());
//            statement.setString(4, subject.getSubjectID());
//                        
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        catch(SQLException ex) {
//        	printSQLException(ex);
//        }
//        return rowUpdated;
//	}	
}
