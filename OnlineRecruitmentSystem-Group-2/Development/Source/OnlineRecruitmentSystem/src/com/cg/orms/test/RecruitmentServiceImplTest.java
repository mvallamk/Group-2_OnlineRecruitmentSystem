package com.cg.orms.test;

import org.junit.Before;
import org.junit.runner.RunWith;

import com.cg.orms.dao.ILoginDao;
import com.cg.orms.service.IRecruitmentService;
import com.cg.orms.service.RecruitmentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
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
