package com.cg.recruitment.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.recruitment.entities.Login;
import com.cg.recruitment.exception.RecruitmentException;

@Repository
@Transactional
public class LoginDaoImpl implements ILoginDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
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
	public Login getLoginDetails(String loginId) throws RecruitmentException {

		
		try {
			return entityManager.find(Login.class, loginId);
		} catch (Exception e) {
			throw new RecruitmentException("Cannot get Login Details");
		}
	}

}
