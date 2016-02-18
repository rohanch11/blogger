package com.blog.login;

import javax.servlet.http.HttpSession;

import com.blog.database.DataBase;
import com.blog.signup.SignUpPojo;

public class CheckSeasion {

	DataBase database = null;
	public String validateSeassion(LoginPojo loginpojo, HttpSession session)
	{
		database= DataBase.getInstance();	
	 
		if(database.session.get(session)!= null)
			   {
		   			//chcek session is already present
		   			return database.session.get(session);
			   }
	   else{
		   			//insert into session
		   			database.session.put(session, loginpojo.getUserName());  
		    		System.out.println("seassion : "+session+"   uname : "+database.session.get(session));
		    		SignUpPojo signup = database.userData.get(database.session.get(session));
		    		System.out.println("username ::  "+signup.getUserName());
		    		return signup.getUserName();
	   }
	}
}
