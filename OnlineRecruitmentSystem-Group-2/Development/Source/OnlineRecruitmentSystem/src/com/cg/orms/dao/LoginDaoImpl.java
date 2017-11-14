package com.cg.orms.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.orms.entities.Login;
import com.cg.orms.exception.RecruitmentException;

@Repository
@Transactional
public class LoginDaoImpl implements ILoginDao {

	@PersistenceContext
	EntityManager entityManager;

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
		} catch (Exception e) {
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
			return entityManager.find(Login.class, loginId);
		} catch (Exception e) {
			throw new RecruitmentException("Cannot get Login Details");
		}
	}

}
