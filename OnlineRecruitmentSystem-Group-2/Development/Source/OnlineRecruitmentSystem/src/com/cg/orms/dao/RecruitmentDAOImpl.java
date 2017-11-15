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
	public List<JobRequirements> getJobsByQualification(
			String qualificationRequired) throws RecruitmentException {
		TypedQuery<JobRequirements> query = entityManager.createQuery(
				QueryMapper.getJobsByQualificationQuery, JobRequirements.class);
		query.setParameter("qualificationRequired", qualificationRequired);
		try {
			List<JobRequirements> jobs = query.getResultList();
			logger.info("Job list is retrieved successfully by qualification");
			return jobs;
		} catch (Exception exception) {
			logger.info("Unable to fetch jobs by qualification.");
			throw new RecruitmentException("Cannot Fetch Jobs.");
		}
	}

	@Override
	/**
	 * When the user selects search jobs by position in searchjobs.jsp,the program 
	 * is directed here and the list of jobs matching the criteria is fetched from database.
	 */
	public List<JobRequirements> getJobsByPosition(String positionRequired)
			throws RecruitmentException {
		TypedQuery<JobRequirements> query = entityManager.createQuery(
				QueryMapper.getJobsByPositionQuery, JobRequirements.class);
		query.setParameter("positionRequired", positionRequired);
		try {
			List<JobRequirements> jobs = query.getResultList();
			logger.info("Job list is retrieved successfully by position");
			return jobs;
		} catch (Exception exception) {
			logger.info("Unable to fetch jobs by position.");
			throw new RecruitmentException("Cannot Fetch Jobs.");
		}
	}

	@Override
	/**
	 * When the user selects search jobs by Experience in searchjobs.jsp,the program 
	 * is directed here and the list of jobs matching the criteria is fetched from database.
	 */
	public List<JobRequirements> getJobsByExperience(int experienceRequired)
			throws RecruitmentException {
		TypedQuery<JobRequirements> query = entityManager.createQuery(
				QueryMapper.getJobsByExperienceQuery, JobRequirements.class);
		query.setParameter("experienceRequired", experienceRequired);
		try {
			List<JobRequirements> jobs = query.getResultList();
			logger.info("Job list is retrieved successfully by experience");
			return jobs;
		} catch (Exception exception) {
			logger.info("Unable to fetch jobs by experience.");
			throw new RecruitmentException("Cannot Fetch Jobs.");
		}
	}

	@Override
	/**
	 * When the user selects search jobs by location in searchjobs.jsp,the program 
	 * is directed here and the list of jobs matching the criteria is fetched from database.
	 */
	public List<JobRequirements> getJobsByLocation(String jobLocation)
			throws RecruitmentException {
		TypedQuery<JobRequirements> query = entityManager.createQuery(
				QueryMapper.getJobsByLocationQuery, JobRequirements.class);
		query.setParameter("jobLocation", jobLocation);
		try {
			List<JobRequirements> jobs = query.getResultList();
			logger.info("Job list is retrieved successfully by location");
			return jobs;
		} catch (Exception exception) {
			logger.info("Unable to fetch jobs by location.");
			throw new RecruitmentException("Cannot Fetch Jobs.");
		}
	}

	@Override
	/**
	 * When the user selects Apply option in jobs.jsp,the program is directed here 
	 * and the selected job details will be saved into database.
	 */
	public void insertJobApplied(JobApplied jobApplied)
			throws RecruitmentException {
		try {
			entityManager.persist(jobApplied);
			entityManager.flush();
			logger.info("Job details for the applied jobs are inserted successfully");
		} catch (Exception exception) {
			logger.info("Unable to insert job applied");
			throw new RecruitmentException("Cannot insert job applied");
		}
	}

	
	/**
	 * When the user registers with valid credentials,the credentials will be saved
	 * by this method,but if the user_id is already taken the it throws an exception
	 * @throws Recruitment Exception
	 */
	@Override
	public void signUp(Login signupDetails) throws RecruitmentException {
		try {
			entityManager.persist(signupDetails);
			entityManager.flush();
			logger.info("Sign Up details are saved successfully");
		} catch (Exception exception) {
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
		} catch (Exception exception) {
			logger.info("Fetch operation for login details unsuccessful");
			throw new RecruitmentException("Cannot get Login Details");
		}
	}

	@Override
	/**
	 * When the user clicks on save personal details in resume from the program is
	 * directed here and it if there is some error it throws Recruitment Exception
	 * @throws recruitment Exception
	 */
	public void insertCandidatePersonalDetails(
			CandidatePersonal candidatePersonalDetails)
			throws RecruitmentException {
		try {
			entityManager.persist(candidatePersonalDetails);
			entityManager.flush();
			logger.info("Personal details are saved successfully");
		} catch (Exception exception) {
			logger.info("Personal details couldn't be saved");
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
	public void insertCandidateQualificationDetails(
			CandidateQualifications candidateQualificationDetails)
			throws RecruitmentException {
		System.out.println(candidateQualificationDetails);
		try {
			entityManager.persist(candidateQualificationDetails);
			entityManager.flush();
			logger.info("Qualification details are saved successfully");
		} catch (Exception exception) {
			logger.info("Qualification details couldn't be saved");
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
	public void insertCandidateWorkHistoryDetails(
			CandidateWorkHistory candidateWorkHistoryDetails)
			throws RecruitmentException {
		try {
			entityManager.persist(candidateWorkHistoryDetails);
			entityManager.flush();
			logger.info("Work History details are saved successfully");
		} catch (Exception exception) {
			logger.info("Work History details couldn't be saved");
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
			query.setParameter("candidateId", candidateId);
			CandidatePersonal candidate = query.getSingleResult();
			logger.info("Personal details are retrieved successfully");
			return candidate;
		} catch (Exception exception) {
			logger.info("Personal details retrieval failed");
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
	public CandidatePersonal modifyCandidatePersonalDetails(
			CandidatePersonal candidatePersonalDetails)
			throws RecruitmentException {
		try {
			logger.info("Personal details modifications begins");
			return entityManager.merge(candidatePersonalDetails);
		} catch (Exception exception) {
			logger.info("Personal details modifications failed");
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
							QueryMapper.getCandidateQualificationDetailsQuery,
							CandidateQualifications.class);
			query.setParameter("candidateId", candidateId);
			CandidateQualifications candidate = query.getSingleResult();
			logger.info("Qualification details retrived successfully");
			return candidate;
		} catch (Exception exception) {
			logger.info("Qualification details retrieval failed");
			throw new RecruitmentException(
					"Cannot fetch Qualification Details");
		}
	}

	@Override
	/**
	 * When the user makes changes and clicks on save in modify Qualification details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public CandidateQualifications modifyCandidateQualificationDetails(
			CandidateQualifications candidateQualificationDetails)
			throws RecruitmentException {
		try {
			logger.info("Qualification details modifications begins");
			return entityManager.merge(candidateQualificationDetails);
		} catch (Exception exception) {
			logger.info("Qualification details modifications failed");
			throw new RecruitmentException(
					"Cannot Modify Candidate Qualification Details");
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
			TypedQuery<CandidateWorkHistory> query = entityManager.createQuery(
					QueryMapper.getCandidateWorkHistoryDetailsQuery,
					CandidateWorkHistory.class);
			query.setParameter("candidateId", candidateId);
			CandidateWorkHistory candidate = query.getSingleResult();
			logger.info("Work History details retrived successfully");
			return candidate;
		} catch (Exception exception) {
			logger.info("Work History details retrieval failed");
			throw new RecruitmentException(
					"Cannot fetch Candidate Work History Details");
		}
	}

	@Override
	/**
	 *  When the user makes changes and clicks on save in modify Work History details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws Recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public CandidateWorkHistory modifyCandidateWorkHistoryDetails(
			CandidateWorkHistory candidateWorkHistoryDetails)
			throws RecruitmentException {
		try {
			logger.info("Work History details modifications begins");
			return entityManager.merge(candidateWorkHistoryDetails);
		} catch (Exception exception) {
			logger.info("Work History details modifications failed");
			throw new RecruitmentException(
					"Cannot Modify Candidate Work History Details");
		}
	}
}
