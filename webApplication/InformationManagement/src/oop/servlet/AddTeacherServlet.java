package oop.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.http.MultipartContent.Part;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.http.MultipartContent.Part;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import oop.model.Teacher;
import oop.service.ISchoolService;
import oop.service.SchoolService;

import java.util.*;

/**
 * Servlet implementation class LoginServlet
 */
public class AddTeacherServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private static final String APPLICATION_NAME = "Teacher Details Management";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final java.io.File CREDENTIALS_FOLDER = new java.io.File(System.getProperty("user.home"), "credentials");
    private static final String CLIENT_SECRET_FILE_NAME = "client_secret.json";
    
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeacherServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         
         String teacherID = request.getParameter("id");
         Teacher teacher = null;
         
         //This condition is true when the form is displayed to edit an existing teacher
         if(teacherID != "") {
        	 ISchoolService iSchoolService = new SchoolService();
        	 List<Teacher> teachersMatched = iSchoolService.getTeachers(teacherID);
        	 if(teachersMatched != null) {
        	    teacher = teachersMatched.get(0);
        	 }
         }
		 
		 String destination = "/AddTeacher.jsp"; 
		 request.setAttribute("teacher", teacher);
		 		 
		 RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		if (request.getParameter("Save") != null) {
			response.setContentType("text/html");
			
			Teacher teacher = new Teacher();
			
			teacher.setTeacherID(request.getParameter("teacherID").trim());
			teacher.setFirstName(request.getParameter("firstName").trim());
			teacher.setLastName(request.getParameter("lastName").trim());
			teacher.setAddress(request.getParameter("address").trim());
			teacher.setQualifications(request.getParameter("qualifications").trim());
			teacher.setGender(request.getParameter("gender").trim());
			teacher.setSalary(Float.parseFloat(request.getParameter("salary").trim()));
			teacher.setNic(request.getParameter("nic").trim());
			teacher.setEmail(request.getParameter("email").trim());
			
			String teacherID = request.getParameter("id");
	
			System.out.println("I am inside the servlet: " + (teacherID != null));
			if(teacherID != null) {
				ISchoolService iSchoolService = new SchoolService();
				boolean result = iSchoolService.updateTeacher(teacher);
				System.out.println("Updated:"+result);
			}
			else {				
				ISchoolService iSchoolService = new SchoolService();
				iSchoolService.addTeacher(teacher);
		    }
	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListTeachers.jsp");
			dispatcher.forward(request, response);
		}
		
		if (request.getParameter("Upload") != null) {
			System.out.println("OAuth is happenning....");
			
			System.out.println("CREDENTIALS_FOLDER: " + CREDENTIALS_FOLDER.getAbsolutePath());
			   
	         // 1: Create CREDENTIALS_FOLDER
	         if (!CREDENTIALS_FOLDER.exists()) {
	            CREDENTIALS_FOLDER.mkdirs();
	 
	            System.out.println("Created Folder: " + CREDENTIALS_FOLDER.getAbsolutePath());
	            System.out.println("Copy file " + CLIENT_SECRET_FILE_NAME + " into folder above.. and rerun this class!!");
	            return;
	         }
	         // 2: Build a new authorized API client service.
	         NetHttpTransport HTTP_TRANSPORT = null;
			 try {
				HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			 } catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
	 
	         // 3: Read client_secret.json file & create Credential object.
	         Credential credential = getCredentials(HTTP_TRANSPORT);
	 
	         // 5: Create Google Drive Service.
	         Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential) //
	                .setApplicationName(APPLICATION_NAME).build();
	 
	         // Print the names and IDs for up to 10 files.
	         FileList result = service.files().list().setPageSize(10).setFields("nextPageToken, files(id, name)").execute();
	         List<File> files = result.getFiles();
	         if (files == null || files.isEmpty()) {
	            System.out.println("No files found.");
	         }else {
	            System.out.println("Files:");
	            for (File file : files) {
	                System.out.printf("%s (%s)\n", file.getName(), file.getId());
	            }
	         }
			
		}
	}
	
	/* Copied content*/
	
	private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
	      
        java.io.File clientSecretFilePath = new java.io.File(CREDENTIALS_FOLDER, CLIENT_SECRET_FILE_NAME);
 
        if (!clientSecretFilePath.exists()) {
            throw new FileNotFoundException("Please copy " + CLIENT_SECRET_FILE_NAME 
                    + " to folder: " + CREDENTIALS_FOLDER.getAbsolutePath());
        }
        // Load client secrets.
        InputStream in = new FileInputStream(clientSecretFilePath);
 
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
 
        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY,
                clientSecrets, SCOPES).setDataStoreFactory(new FileDataStoreFactory(CREDENTIALS_FOLDER))
                        .setAccessType("offline").build();
 
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }
	
	
	private static File _createGoogleFile(String googleFolderIdParent,String contentType, String customFileName,
		 AbstractInputStreamContent uploadStreamContent) throws IOException {

		 File fileMetadata = new File();
		 fileMetadata.setName(customFileName);

		 List<String> parents = Arrays.asList(googleFolderIdParent);
		 fileMetadata.setParents(parents);
			  
		 Drive driveService = GoogleDriveUtils.getDriveService();

		 File file = driveService.files()
			    .create(fileMetadata, uploadStreamContent)
			    .setFields("id, webContentLink, webViewLink, parents")
			    .execute();

		return file;
	 }
	// Create Google File from byte[]
	 public static File createGoogleFile(String googleFolderIdParent,String contentType, String customFileName, byte[] uploadData)
			 throws IOException {
	  
	     AbstractInputStreamContent uploadStreamContent = new ByteArrayContent(contentType, uploadData);
	     return _createGoogleFile(googleFolderIdParent, contentType,customFileName, uploadStreamContent);
	 }
	 
	// Create Google File from java.io.File
	 public static File createGoogleFile(String googleFolderIdParent,String contentType, String customFileName, java.io.File uploadFile) throws IOException {

	     AbstractInputStreamContent uploadStreamContent = new FileContent(contentType, uploadFile);
	     return _createGoogleFile(googleFolderIdParent, contentType,customFileName, uploadStreamContent);
	 }

	 // Create Google File from InputStream
	 public static File createGoogleFile(String googleFolderIdParent,String contentType, String customFileName, InputStream inputStream) throws IOException {

	     AbstractInputStreamContent uploadStreamContent = new InputStreamContent(contentType, inputStream);
	     return _createGoogleFile(googleFolderIdParent, contentType,customFileName, uploadStreamContent);
	 }

	/* private String retrieveFileName(Part part) {
	     String contentDisposition = part.getHeader("content-disposition");
	     String[] items = contentDisposition.split(";");
	     for (String str : items) {
	        if (str.trim().startsWith("filename")) {
	           return str.substring(str.indexOf("=") + 2, str.length() - 1);
	        }
	     }
	     return "";
	 } */

}
