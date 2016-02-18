package com.blog.database;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import com.blog.blogdata.BlogPojo;
import com.blog.signup.SignUpPojo;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

	/*
	 * how to create a multimap using google API 
	 * reference: http://stackoverflow.com/questions/3093863/how-to-create-a-multimapk-v-from-a-mapk-collectionv
	 * Answered By : Kevin Bourrillion
	 */

public class DataBase {

	public int postId;
	public static DataBase database = null;
	public HashMap<String, String> userCred = null;
	public HashMap<HttpSession, String> session = null;
	public HashMap<String, String>imageUrl = null;
	public Multimap<String, BlogPojo>userBlog = null;
	public HashMap<String, String>timestampPostId = null;
	public HashMap<String, SignUpPojo> userData = null;
	public Multimap<String, String>userTimestamp = null;
	
	private DataBase() {
		// TODO Auto-generated constructor stub
		
		userCred = new HashMap<String, String>();
		session = new HashMap<HttpSession, String>();
		imageUrl = new HashMap<String, String>(); 
		userBlog =ArrayListMultimap.create();
		timestampPostId = new HashMap<String, String>(); 
		userData = new HashMap<String, SignUpPojo>();
		userTimestamp =ArrayListMultimap.create();
		
		//initiating veriable
		
		String str = "admin@yahoo.com";
	    String uname = "admin";
	 for (int i = 0; i < 10; i++) {
			Date date = new Date();
			
             SignUpPojo signup= new SignUpPojo(uname, "admin", str, ""+new Date(), "imagesu.jpeg");
			
			if(userData.containsKey(signup.getEmail())==false)
				userData.put(signup.getEmail(), signup);	
			
			if(i>2){
				str = str +i;
			    uname+=i;
			}
			
			if(i==1)
			{
			
			BlogPojo blogtemp = new BlogPojo(" Your loyal satisfied customers are the ones that help keep you in business through their return visits and customer referrals. "+i, ""+date,
					"5 Ways to Turn Satisfied Customers into Brand Advocates",str, postId, uname);
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			
			}
			if(i==2)
			{
				BlogPojo blogtemp = new BlogPojo("Getting off the ground as a new small business is a challenge all its own. Sure, you’ve got great products and a solid business plan.  "+i, ""+date,
						"6 Tips for Getting Exposure for Your Small Business Early On",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			
			if(i==3)
			{
				BlogPojo blogtemp = new BlogPojo("The evolution of content marketing has been entertaining to watch. We’re currently experiencing a permanent shift away from static.   "+i, ""+date,
						"Why Interactive Content is the New Normal",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			
			if(i==4)
			{
				BlogPojo blogtemp = new BlogPojo("While big box brands may have the budget to reach a national audience, small businesses have a distinct advantage on the local stage.   "
						+i, ""+date,
						"Making The Most of Local Search: What To Put In Your Local Listings",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			
			if(i==5)
			{
				BlogPojo blogtemp = new BlogPojo("When you build your own website with user-friendly tools (like Webs, of course) it’s easy create a good website.represented throughout. "
						+i, ""+date,
						"Example Website: Creating a Harmonious Brand on Your Musician Website",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			
			if(i==6)
			{
				BlogPojo blogtemp = new BlogPojo("We’ve talked about how web design is essential to building a better small business website, you want your user to experience.   "
						+i, ""+date,
						"Does Your Website Pass the Mom Test? Learn the 5 Fundamentals of UX.",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			   
			//
			if(i==7)
			{
				BlogPojo blogtemp = new BlogPojo("You’ve failed at being in two places at once, growing that third hand, and having the memory of a full-grown elephant or business owners."
						+i, ""+date,
						"8 Productivity Hacks for Small Business Owners",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			
			if(i==8)
			{
				BlogPojo blogtemp = new BlogPojo("Bringing a few desk gadgets that you love to the office can do wonders for productivity. It is also just a nice stress "
						+i, ""+date,
						"15 Tricks For Being Happy at Work",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			
			if(i==9)
			{
				BlogPojo blogtemp = new BlogPojo("  Unleashing Your Creativity includes a wide range of posts, from short, thought-provoking paragraphs to lengthier how-to articles. "
						+i, ""+date,
						" Unleashing Your Creativity",str, postId, uname);
	
			userBlog.put(blogtemp.getDate(),blogtemp);
			userTimestamp.put(str, blogtemp.getDate());
			timestampPostId.put(""+postId, ""+date);
			postId++;
			userCred.put(str, "admin");
			}
			
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
	 }	
	
	 public static DataBase getInstance() {
	      if(database == null) {
	    	  database = new DataBase();
	      }
	         return database;
	   }
}
	
	






