package com.cg.recruitment.dao;


import com.cg.recruitment.entities.Login;
import com.cg.recruitment.exception.RecruitmentException;

public interface ILoginDao {
	
	
	public abstract void signUp(Login loginSignup) throws RecruitmentException;
	public abstract Login getLoginDetails(String loginId) throws RecruitmentException;


}
