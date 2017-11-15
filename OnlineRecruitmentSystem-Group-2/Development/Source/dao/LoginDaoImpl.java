package com.cg.recruitment.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.recruitment.entities.Login;
import com.cg.recruitment.exception.RecruitmentException;

@Repository
@Transactional
public class LoginDaoImpl implements ILoginDao {

	@PersistenceContext
	EntityManager entityManager;

	private static Logger logger = Logger
			.getLogger(com.cg.recruitment.dao.LoginDaoImpl.class);

	@Override
	/**
	 * When the user registers with valid credentials,the credentials will be saved
	 * by this method,but if the user_id is already taken the it throws an exception
	 * @throws Recruitment Exception
	 */
	public void signUp(Login loginSignup) throws RecruitmentException {
		try {
			entityManager.persist(loginSignup);
			entityManager.flush();
			logger.info("Sign Up details are saved successfully");
		} catch (Exception e) {
			logger.info("sign up unsuccessful");
			throw new RecruitmentException(
					"UserId already taken. Try Another Id.");
		}
	}

	@Override
	/**
	 * When the user is loging in then this method checks if the credentials are valid or not
	 * @throws recruitment Exception
	 */
	public Login getLoginDetails(String loginId) throws RecruitmentException {

		try {
			logger.info("Fetch operation for login details begins");
			return entityManager.find(Login.class, loginId);
			
		} catch (Exception e) {
			logger.info("Fetch operation for login details unsuccessful");
			throw new RecruitmentException("Cannot get Login Details");			
		}
	}

}
