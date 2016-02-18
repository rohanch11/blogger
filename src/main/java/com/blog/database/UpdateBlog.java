package com.blog.database;

import java.util.Collection;
import java.util.Iterator;

import org.json.JSONObject;

import com.blog.blogdata.BlogPojo;


public class UpdateBlog {

	DataBase database= null;
	
	public UpdateBlog() {
       // TODO Auto-generated constructor stub
		this.database = DataBase.getInstance();
	}
	
	/*
	 * How to read json sent by ajax in servlet
	 * reference from : http://stackoverflow.com/questions/19568142/how-to-read-json-sent-by-ajax-in-servlet
	 * Answered by : Rakesh Soni
	 */
	
	private String[] parseJsonReturnBlogData(JSONObject jObj) {
		// TODO Auto-generated method stub
		
		System.out.println("json in update : "+jObj);
		java.util.Iterator it = jObj.keys(); //gets all the keys	
		
		String data[] = new String[3];
			 while(it.hasNext())
			 {
				 String key = ""+it.next(); // get key
				 data[0]=""+jObj.get(key);
		    
				 key = ""+it.next(); // get key
				 data[1] = (String) jObj.get(key); // get value
		   	
				 key = ""+it.next(); // get key
				 data[2] = (String) jObj.get(key); // get value
			}
		return data;
	}	

	public String UpdateBlogByID(JSONObject jObj)
	{	
		try
		{
			String data[]= parseJsonReturnBlogData(jObj);
			
			int postId= Integer.parseInt(data[1]);
			String key = database.timestampPostId.get(""+postId);
			
			Collection values = database.userBlog.get(key);
			Iterator valueIterator = values.iterator();
			while(valueIterator.hasNext()) 
				{  
					BlogPojo blogPojo = (BlogPojo) valueIterator.next(); 
					if(blogPojo.getPostId()==postId) 
					{
						  blogPojo.setBlogText(data[2]);
						  blogPojo.setPostTitle(data[0]);
						  break;
					}
				}
		}catch(Exception e){
			return null;
		}
			return "Success";
		}
}
