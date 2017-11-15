package com.cg.orms.test;

import static org.mockito.Mockito.stub;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.orms.dao.RecruitmentDAO;
import com.cg.orms.entities.Login;
import com.cg.orms.service.RecruitmentService;
import com.cg.orms.service.RecruitmentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RecruitmentServiceImplTest {
	@Mock
	private RecruitmentDAO recruitmentDAOImpl;

	@InjectMocks
	private RecruitmentService recruitmentServiceImpl = new RecruitmentServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testLogin() throws Exception
	{
		String  loginId="manoj10987";
		Login login=new Login();
		stub(recruitmentDAOImpl.getLoginDetails(loginId)).toReturn(login);
		
		 
		 
		
	}
	
	
	
	
	
	
	
}
