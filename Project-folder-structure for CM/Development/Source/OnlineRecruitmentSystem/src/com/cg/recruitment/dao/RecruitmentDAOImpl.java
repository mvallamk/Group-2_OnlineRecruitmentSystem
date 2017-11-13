package com.cg.recruitment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.recruitment.entities.JobApplied;
import com.cg.recruitment.entities.JobRequirements;
import com.cg.recruitment.exception.RecruitmentException;

@Repository
@Transactional
public class RecruitmentDAOImpl implements IRecruitmentDAO {

	@PersistenceContext
	EntityManager entityManager;

	private static Logger logger = Logger
			.getLogger(com.cg.recruitment.dao.RecruitmentDAOImpl.class);

	@Override
	public List<JobRequirements> getJobByQual(String qual) {
		TypedQuery<JobRequirements> query = entityManager
				.createQuery(
						"select jobRequirements From JobRequirements jobRequirements where jobRequirements.qualificationRequired=:pQual",
						JobRequirements.class);
		query.setParameter("pQual", qual);
		List<JobRequirements> accList = query.getResultList();
		logger.info("Job list is retrieved successfully by qualification");
		return accList;
	}

	@Override
	public List<JobRequirements> getJobByPosition(String pos) {
		TypedQuery<JobRequirements> query = entityManager
				.createQuery(
						"select jobRequirements From JobRequirements jobRequirements where jobRequirements.positionRequired=:pPos",
						JobRequirements.class);
		query.setParameter("pPos", pos);
		List<JobRequirements> accList = query.getResultList();
		logger.info("Job list is retrieved successfully by position");
		return accList;
	}

	@Override
	public List<JobRequirements> getJobByExperience(int exp) {
		TypedQuery<JobRequirements> query = entityManager
				.createQuery(
						"select jobRequirements From JobRequirements jobRequirements where jobRequirements.experienceRequired<=:pExp",
						JobRequirements.class);
		query.setParameter("pExp", exp);
		List<JobRequirements> accList = query.getResultList();
		logger.info("Job list is retrieved successfully by experience");
		return accList;
	}

	@Override
	public List<JobRequirements> getJobByLocation(String loc) {
		TypedQuery<JobRequirements> query = entityManager
				.createQuery(
						"select jobRequirements From JobRequirements jobRequirements where jobRequirements.jobLocation=:pLoc",
						JobRequirements.class);
		query.setParameter("pLoc", loc);
		List<JobRequirements> accList = query.getResultList();
		logger.info("Job list is retrieved successfully by location");
		return accList;
	}

	@Override
	public void insertApplyJob(JobApplied jobApplied)
			throws RecruitmentException {

		entityManager.persist(jobApplied);

		entityManager.flush();
		logger.info("Job details for the applied jobs are inserted successfully");
	}

}
