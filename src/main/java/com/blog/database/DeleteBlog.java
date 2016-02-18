package com.blog.database;

import java.util.Collection;
import java.util.Iterator;

import com.blog.blogdata.BlogPojo;

/*
 *  Remove and put back elements from Multimap while iterating
 *  reference from : http://stackoverflow.com/questions/16633985/java-guava-remove-and-put-back-elements-from-multimap-while-iterating
 * 	Asked By: user26372 
 */

public class DeleteBlog {
	DataBase database;
	public String DeleteBlogByID(String userName, int postId)
	{
		try
		{
			database= DataBase.getInstance();
			String key = database.timestampPostId.get(""+postId);
			//detete blogpojo
			Collection values = database.userBlog.get(key);
			Iterator valueIterator = values.iterator();
			while(valueIterator.hasNext()) 
				{  
					BlogPojo blogPojo = (BlogPojo) valueIterator.next(); 
					if(blogPojo.getPostId()==postId) {
						valueIterator.remove();
						// keyIterator.remove();
				}
		  
		  database.userTimestamp.get(userName);
		  Iterator valueIterator1 = values.iterator();
		  while(valueIterator1.hasNext()) 
		  	{
			  	String time =  (String) valueIterator1.next();
			  	if(database.timestampPostId.get(""+postId)==time) {
			  		valueIterator1.remove();
			  	}
		  	}
		  database.timestampPostId.remove(""+postId);
		}
}catch(Exception e){
  	   return null;
}
		return "Success";
}
}