package com.cg.orms.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.orms.dao.RecruitmentDAO;
import com.cg.orms.dao.RecruitmentDAOImpl;
import com.cg.orms.entities.Login;

@RunWith(MockitoJUnitRunner.class)
public class RecruitmentDAOTest {
	@Mock
	private EntityManager entityManager;
	@InjectMocks
	private RecruitmentDAO recruitmentDAOImpl = new RecruitmentDAOImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() throws Exception {
		String loginId = "manoj10987";
		String password = "manojmanoj1!";
		Login testLogin = new Login();
		testLogin.setLoginId(loginId);
		testLogin.setPassword(password);
		testLogin.setType("User");
		Mockito.when(entityManager.find(Login.class, loginId)).thenReturn(
				testLogin);
		assertEquals(testLogin, recruitmentDAOImpl.getLoginDetails(loginId));
		verify(entityManager).find(Login.class, loginId);
	}
}
