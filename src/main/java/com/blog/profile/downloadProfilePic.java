package com.blog.profile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.database.DataBase;

public class downloadProfilePic {

	DataBase database;
	public downloadProfilePic() {
		// TODO Auto-generated constructor stub
	database = DataBase.getInstance();
	
	}
	
	public void downloadImageClientSide(HttpServletRequest request,HttpServletResponse response)
	{
		//ref : http://stackoverflow.com/questions/5509328/display-image-in-jsp-page-from-servlet
		
		
		try{
	        // String fileName = request.getParameter("image");             
	        
	         File file = new File(database.imageUrl.get(
	        		 database.session.get(request.getSession())));
	         FileInputStream fis = new FileInputStream(file);
	         BufferedInputStream bis = new BufferedInputStream(fis);             
	         response.setContentType("image/jpeg");
	         BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
	         for (int data; (data = bis.read()) > -1;) 
	         {
	        //  System.out.println("avb : "+bis.available());
	        	 output.write(data);
	         }               
	      }
	      catch(IOException e){
	}
}
}
