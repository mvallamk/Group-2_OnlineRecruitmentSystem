package com.cg.orms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.orms.entities.CandidatePersonal;
import com.cg.orms.entities.CandidateQualifications;
import com.cg.orms.entities.CandidateWorkHistory;
import com.cg.orms.entities.JobApplied;
import com.cg.orms.entities.JobRequirements;
import com.cg.orms.entities.Login;
import com.cg.orms.exception.RecruitmentException;
import com.cg.orms.util.QueryMapper;

@Repository
@Transactional
public class RecruitmentDAOImpl implements RecruitmentDAO {
	@PersistenceContext
	EntityManager entityManager;
	private static Logger logger = Logger
			.getLogger(com.cg.orms.dao.RecruitmentDAOImpl.class);

	@Override
	/**
	 * When the user selects search jobs by qualification in searchjobs.jsp,the program 
	 * is directed here and the list of jobs matching the criteria is fetched from database.
	 */
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
	/**
	 * When the user selects search jobs by position in searchjobs.jsp,the program 
	 * is directed here and the list of jobs matching the criteria is fetched from database.
	 */
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
	/**
	 * When the user selects search jobs by Experience in searchjobs.jsp,the program 
	 * is directed here and the list of jobs matching the criteria is fetched from database.
	 */
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
	/**
	 * When the user selects search jobs by location in searchjobs.jsp,the program 
	 * is directed here and the list of jobs matching the criteria is fetched from database.
	 */
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
	/**
	 * When the user selects Apply option in jobs.jsp,the program is directed here 
	 * and the selected job details will be saved into database.
	 */
	public void insertApplyJob(JobApplied jobApplied)
			throws RecruitmentException {

		entityManager.persist(jobApplied);

		entityManager.flush();
		logger.info("Job details for the applied jobs are inserted successfully");
	}

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

	@Override
	/**
	 * When the user clicks on save personal details in resume from the program is
	 * directed here and it if there is some error it throws Recruitment Exception
	 * @throws recruitment Exception
	 */
	public void candidPersonal(CandidatePersonal candPers)
			throws RecruitmentException {
		try {

			entityManager.persist(candPers);
			entityManager.flush();
		} catch (Exception e) {

			throw new RecruitmentException(
					"Can't insert into candidate Personal");
		}
	}

	@Override
	/**
	 *  When the user clicks on save Qualification details in resume from the program is
	 * directed here and it if there is some error it throws Recruitment Exception
	 * @throws recruitment Exception
	 */
	public void candidQualification(CandidateQualifications candQual)
			throws RecruitmentException {
		System.out.println(candQual);
		try {
			entityManager.persist(candQual);
			entityManager.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RecruitmentException(
					"cant insert into candidate Qualification");
		}
	}

	@Override
	/**
	 *  When the user clicks on save Work History Details details in resume from
	 *   the program is directed here and it if there is some error it throws 
	 *   Recruitment Exception
	 * @throws recruitment Exception
	 */
	public void candidWorkHistory(CandidateWorkHistory candHist)
			throws RecruitmentException {
		try {
			entityManager.persist(candHist);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RecruitmentException(
					"cant insert into candidate Work History");
		}

	}

	@Override
	/**
	 * When user selects modify personal details the program is directed here and 
	 * the personal details are fetched from data base and if it faces an error it throws
	 * recruitment Exception
	 * @throws recruitment Exception
	 */
	public CandidatePersonal getCandidatePersonalDetails(String candidateId)
			throws RecruitmentException {
		try {
			TypedQuery<CandidatePersonal> query = entityManager.createQuery(
					QueryMapper.getCandidatePersonalDetailsQuery,
					CandidatePersonal.class);
			query.setParameter("candID", candidateId);
			CandidatePersonal candidate = query.getSingleResult();
			return candidate;
		} catch (Exception e) {
			throw new RecruitmentException(
					"Cannot Fetch Candidate Personal Details");
		}

	}

	@Override
	/**
	 * When the user makes changes and clicks on save in modify personal details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public CandidatePersonal modifycandidPersonal(
			CandidatePersonal candidatePersonal) throws RecruitmentException {
		try {
			return entityManager.merge(candidatePersonal);
		} catch (Exception e) {
			throw new RecruitmentException(
					"Cannot Modify Candidate Personal Details");
		}
	}

	@Override
	/**
	 * * When user selects modify Qualification details the program is directed here and 
	 * the Qualification details are fetched from data base and if it faces an error it
	 *  throws recruitment Exception
	 * @throws recruitment Exception
	 */
	public CandidateQualifications getCandidateQualificationDetails(
			String candidateId) throws RecruitmentException {
		try {
			TypedQuery<CandidateQualifications> query = entityManager
					.createQuery(
							"select candidateQualifications From CandidateQualifications candidateQualifications where candidateQualifications.candidateId=:candID",
							CandidateQualifications.class);
			query.setParameter("candID", candidateId);
			CandidateQualifications candidate = query.getSingleResult();
			return candidate;
		} catch (Exception e) {
			throw new RecruitmentException(
					"Cannot Modify Candidate Personal Details");
		}
	}

	@Override
	/**
	 * When the user makes changes and clicks on save in modify Qualification details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public CandidateQualifications modifycandidQualifications(
			CandidateQualifications candidateQualifications)
			throws RecruitmentException {
		try {
			return entityManager.merge(candidateQualifications);
		} catch (Exception e) {
			throw new RecruitmentException(
					"Cannot Modify Candidate Personal Details");
		}
	}

	@Override
	/**
	 * When user selects modify Work History details the program is directed here and 
	 * the Work History details are fetched from data base and if it faces an error it
	 *  throws recruitment Exception
	 * @throws recruitment Exception
	 */
	public CandidateWorkHistory getCandidateWorkHistoryDetails(
			String candidateId) throws RecruitmentException {

		try {
			TypedQuery<CandidateWorkHistory> query = entityManager
					.createQuery(
							"select candidateWorkHistory From CandidateWorkHistory candidateWorkHistory where candidateWorkHistory.candidateId=:candID",
							CandidateWorkHistory.class);
			query.setParameter("candID", candidateId);
			CandidateWorkHistory candidate = query.getSingleResult();
			return candidate;
		} catch (Exception e) {
			throw new RecruitmentException(
					"Cannot Modify Candidate Personal Details");
		}
	}

	@Override
	/**
	 *  When the user makes changes and clicks on save in modify Work History details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public CandidateWorkHistory modifycandidWorkHistory(
			CandidateWorkHistory candidateWorkHistory)
			throws RecruitmentException {
		try {
			return entityManager.merge(candidateWorkHistory);
		} catch (Exception e) {
			throw new RecruitmentException(
					"Cannot Modify Candidate Personal Details");
		}
	}

}
