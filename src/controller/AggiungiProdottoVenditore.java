package controller;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class CambiaAvatar
 */

@MultipartConfig(maxFileSize = 199999999)
public class AggiungiProdottoVenditore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AggiungiProdottoVenditore() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		   
		  if(!ServletFileUpload.isMultipartContent(request)){
		   out.println("Nothing to upload");
		   return; 
		  }
		  FileItemFactory itemfactory = new DiskFileItemFactory(); 
		  ServletFileUpload upload = new ServletFileUpload(itemfactory);
		  try{
		   List<FileItem>  items = upload.parseRequest(request);
		   for(FileItem item:items){
		     
		    String contentType = item.getContentType();
		    if(!contentType.equals("pic1")){
		     out.println("only png format image files supported");
		     continue;
		    }
		    File uploadDir = new File("C:\\Users\\xblac\\Desktop");
		    File file = File.createTempFile("img",".png",uploadDir);
		    item.write(file);
		 
		    out.println("File Saved Successfully");
		   }
		  }
		  catch(FileUploadException e){
		    
		   out.println("upload fail");
		  }
		  catch(Exception ex){
		    
		   out.println("can't save");
		  }
		 }

}