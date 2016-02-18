package com.blog.database;

import com.blog.login.LoginPojo;

public class ValidateUser {
	
DataBase database;
	
	public String validate(LoginPojo login)
	{
		database = DataBase.getInstance();
		try{
		if(database.userCred.get(login.getUserName()).equals(login.getPassword()))
		    return "Success";	
		 
		}catch(Exception E)
		{
			return "Fail";
		}
		return "Fail";
	}	  
}
	

