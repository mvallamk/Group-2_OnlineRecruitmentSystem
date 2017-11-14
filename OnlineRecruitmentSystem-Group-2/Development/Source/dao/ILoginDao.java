package com.cg.recruitment.dao;

import com.cg.recruitment.entities.Login;
import com.cg.recruitment.exception.RecruitmentException;

public interface ILoginDao {

	/**
	 * When the user registers with valid credentials,the credentials will be saved
	 * by this method,but if the user_id is already taken the it throws an exception
	 * @throws Recruitment Exception
	 */
	public abstract void signUp(Login loginSignup) throws RecruitmentException;

	/**
	 * When the user is loging in then this method checks if the credentials are valid or not
	 * @throws recruitment Exception
	 */
	public abstract Login getLoginDetails(String loginId)
			throws RecruitmentException;

}
