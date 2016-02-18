package com.blog.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.blog.blogdata.BlogPojo;
import com.blog.signup.SignUpPojo;




public class RetriveData {

	DataBase database;
	
	public RetriveData() {
		// TODO Auto-generated constructor stub
		database = DataBase.getInstance();
	}
	
	
	/*
	 * Returning JSON response from Servlet to Javascript/JSP page
	 * referenced from http://stackoverflow.com/questions/6154845/returning-json-response-from-servlet-to-javascript-jsp-page
	 * Answered By : majestica
	 */
	
	private JSONObject createJsonCommonBlogs()
	{
		JSONObject userBlog      = new JSONObject();
		JSONArray  userBlogArray = new JSONArray();
		JSONObject blog = null;
		try
		{
			Set<String> keysTemp = database.userBlog.keySet();
			
			SortedSet<String> keys=new TreeSet<String>(Collections.reverseOrder());
			keys.addAll(keysTemp);
			
			System.out.println("keys : "+keys);
		   for (String key: keys)
		   {
		       Collection<BlogPojo> blogp=database.userBlog.get(key);
		       for(BlogPojo blogpojo :  blogp)
		    		   {
		    	   blog = new JSONObject();
		    	   blog.put("postTitle", blogpojo.getPostTitle());
		    	   blog.put("date", blogpojo.getDate());
		    	   blog.put("userName", blogpojo.getUserName());
		    	   String blogtext = blogpojo.getBlogText();
		    	   
		    	   blog.put("blogText", stringTrimer(blogtext));
		    	   blog.put("imageUrl", database.imageUrl.get(blogpojo.getUserName()));
		    	   blog.put("postId", blogpojo.getPostId());
		      userBlogArray.put(blog);  
		
		    		 }
		   }
		   userBlog.put("commonBlog", userBlogArray);
		 
		}
		catch (JSONException jse)
		{ 
			System.out.println("json parsing error");
		}
		
		return userBlog;
	}
	
	/*
	 * Returning JSON response from Servlet to Javascript/JSP page
	 * referenced from http://stackoverflow.com/questions/6154845/returning-json-response-from-servlet-to-javascript-jsp-page
	 * Answered By : majestica
	 */
	
	private JSONObject createJsonUserBlogs(String userName)
	{
		JSONObject userBlog      = new JSONObject();
		JSONArray  userBlogArray = new JSONArray();
		JSONObject blog = null;
		Set<String> keysTemp = database.userBlog.keySet();
		SortedSet<String> keys=new TreeSet<String>(Collections.reverseOrder());
		keys.addAll(keysTemp);	
		try
		{
			System.out.println("keys for user : "+keys);
		   for (String key: keys)
		   {  
		       Collection<BlogPojo> blogp=database.userBlog.get(key);
		       for(BlogPojo blogpojo :  blogp)
		       {
		    	   if(userName.equals(blogpojo.getEmail()))
		    	   {
		    		   blog = new JSONObject();
		    		   blog.put("posttitle", blogpojo.getPostTitle());
		    		   blog.put("date", blogpojo.getDate());
		    		   blog.put("userName", blogpojo.getUserName());
		    		   String blogtext = blogpojo.getBlogText();
		    		   blog.put("blogText", stringTrimer(blogtext));
		    		   blog.put("imageUrl", database.imageUrl.get(blogpojo.getUserName()));
		    		   blog.put("postId", blogpojo.getPostId());
		    		   userBlogArray.put(blog);  
		    	   }
		    	}
		   }
		   userBlog.put("userBlog", userBlogArray);
		}
		catch (Exception ne)
		{ 
			System.out.println("json parsing error");
		}
		
		return userBlog;
	}
	
	/*
	 * Returning JSON response from Servlet to Javascript/JSP page
	 * referenced from http://stackoverflow.com/questions/6154845/returning-json-response-from-servlet-to-javascript-jsp-page
	 * Answered By : majestica
	 */
	private JSONObject createJsonBlogByID(String userName, int postId)
	{
		
		JSONObject userBlog      = new JSONObject();
		JSONArray  userBlogArray = new JSONArray();
		JSONObject blog = null;
		new ArrayList<String>();	
		try
		{
			String key=database.timestampPostId.get(""+postId);
		       Collection<BlogPojo> blogp=database.userBlog.get(key);
		       for(BlogPojo blogpojo :  blogp)
		       {
		    	  if(blogpojo.getPostId()==postId)
		    	  {
		    	   blog = new JSONObject();
		    	   blog.put("posttitle", blogpojo.getPostTitle());
		    	   blog.put("date", blogpojo.getDate());
		    	   blog.put("userName", blogpojo.getUserName());
		    	   blog.put("blogText", blogpojo.getBlogText());
		    	   blog.put("imageUrl", database.imageUrl.get(blogpojo.getUserName()));
		    	   blog.put("postId", blogpojo.getPostId());
		    	   userBlogArray.put(blog);  
		    	  }
		       }
		   userBlog.put("userBlogById", userBlogArray);
		}
		catch (JSONException jse)
		{ 
			System.out.println("json parsing error");
		}	
		return userBlog;
	}
	
	/*
	 * Returning JSON response from Servlet to Javascript/JSP page
	 * referenced from http://stackoverflow.com/questions/6154845/returning-json-response-from-servlet-to-javascript-jsp-page
	 * Answered By : majestica
	 * Comment : i took logic from above link and made changes
	 */
	private JSONObject createJsonUserData(String userName)
	{
		JSONObject userData  = new JSONObject();	
		try
		{		     
		       userData = new JSONObject();
		       SignUpPojo signup= database.userData.get(userName); 
		       userData.put("userName", signup.getUserName());
		       userData.put("email", signup.getEmail());
		       userData.put("photoUrl", signup.getPhotoURl());
		       userData.put("bDate", signup.getbDate());
		}
		catch (JSONException jse)
		{ 
			System.out.println("json parsing error");
		}
		return userData;
	}
	
	
	public String stringTrimer(String str)
	{
		int len=0;
		if(str.length()>50)
			len = 50;
		else 
			len=str.length();
		
		return str.substring(0, len);
	}
	
	public JSONObject getCommonBlog()
	{
		return createJsonCommonBlogs(); 	
	}
	
	
	public JSONObject getUserBlog(HttpSession session)
	{
	  	String userName =database.session.get(session);
		System.out.println("user : "+userName);	
	  	return createJsonUserBlogs(userName);
	    
	}
	
	public JSONObject getUserData(HttpSession session)
	{
		return createJsonUserData(database.session.get(session));
		
	}
  
	public JSONObject getUserBlogByID(HttpSession session, int postId)
	{
	    return createJsonBlogByID(database.session.get(session), postId);
	}

}
