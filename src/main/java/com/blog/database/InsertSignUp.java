package com.blog.database;

import javax.servlet.http.HttpServletRequest;

import com.blog.signup.SignUpPojo;

public class InsertSignUp {

	public String insertSignUpPojo(HttpServletRequest request, SignUpPojo signuppojo)
	{
		DataBase database;
		database= DataBase.getInstance();
		if(database.userCred.get(signuppojo.getEmail())==null)
		{
			database.userData.put(signuppojo.getEmail(), signuppojo);
			database.session.put(request.getSession(), signuppojo.getEmail());
			database.imageUrl.put(signuppojo.getEmail(), signuppojo.getPhotoURl());
			database.userCred.put(signuppojo.getEmail(), signuppojo.getPassword());
			return signuppojo.getUserName();
		}
		else
		{
			return "Fail";
		}
	}
}
