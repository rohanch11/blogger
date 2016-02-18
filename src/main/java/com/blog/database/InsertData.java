package com.blog.database;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.blog.blogdata.BlogPojo;
import com.blog.signup.SignUpPojo;

public class InsertData {
	
	DataBase database= null;
	
	
	public String insertUserProfileData(SignUpPojo signup)
	{
		database= DataBase.getInstance();
			if(database.userData.put(signup.getUserName(), signup)!=null)
				  return "Success";
				
		return "Fail";	
	}
	
	public String insertBlog(HttpSession seassion, JSONObject jObj)
	{
		database= DataBase.getInstance();
		BlogPojo blogpojo = parseJsonReturnBlogData(jObj, seassion);
		SignUpPojo signup= database.userData.get(database.session.get(seassion));
		blogpojo.setEmail(signup.getEmail()); 
		blogpojo.setUserName(signup.getUserName());
		Object blogtext = blogpojo.getBlogText();

		// server validation for 140 characters
		if (blogtext.toString().length() <= 140) {

		if(database.userBlog.put(blogpojo.getDate(), 
				blogpojo)==true);
		if(database.userTimestamp.put(database.session.get(seassion), blogpojo.getDate())==true)
			return "Success";
		}else{
			return "Fail";		
		}
		
		return "Fail";
	}

	/* 
	 * How to read json sent by ajax in servlet
	 * reference from : http://stackoverflow.com/questions/19568142/how-to-read-json-sent-by-ajax-in-servlet
	 * Answered by : Rakesh Soni
	 */
	
	public BlogPojo parseJsonReturnBlogData(JSONObject jObj, HttpSession session) {
		// TODO Auto-generated method stub
		database= DataBase.getInstance();
		java.util.Iterator it = jObj.keys(); //gets all the keys	
		String blogText = null;
		String date = null;
		String postTitle = null;
		 try {
			 while(it.hasNext())
			 	{
				 	String key = ""+it.next(); 
				 	postTitle=""+jObj.get(key);
		    
				 	key = ""+it.next(); 
				 	blogText = (String) jObj.get(key); 
		   	
				 	date =  new Date().toString();
				 	database.session.get(session); 
			 	}
		 	} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 SignUpPojo signup=database.userData.get(database.session.get(session));
		 database.timestampPostId.put(""+database.postId, ""+date);
		return new BlogPojo(blogText, date, postTitle, database.session.get(session), database.postId++,signup.getUserName());
	}	
}
