package com.cg.orms.test;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.orms.service.RecruitmentServiceImpl;


public class RecruitmentServiceImplTest {
	@Mock
	private ILoginDao loginDaoImpl;

	@InjectMocks
	private IRecruitmentService recruitmentServiceImpl = new RecruitmentServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
}
}
