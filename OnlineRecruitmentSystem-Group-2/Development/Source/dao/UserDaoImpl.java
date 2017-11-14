package com.cg.recruitment.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cg.recruitment.entities.CandidatePersonal;
import com.cg.recruitment.entities.CandidateQualifications;
import com.cg.recruitment.entities.CandidateWorkHistory;
import com.cg.recruitment.exception.RecruitmentException;
import com.cg.recruitment.util.QueryMapper;

@Repository
@Transactional
public class UserDaoImpl implements IUserDao {

	@PersistenceContext
	EntityManager entityManager;
	
	private static Logger logger = Logger
			.getLogger(com.cg.recruitment.dao.UserDaoImpl.class);

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
			logger.info("Personal details are saved successfully");
		} catch (Exception e) {
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
	public void candidQualification(CandidateQualifications candQual)
			throws RecruitmentException {
		System.out.println(candQual);
		try {
			entityManager.persist(candQual);
			entityManager.flush();
			logger.info("Qualification details are saved successfully");
		} catch (Exception e) {
			logger.info("Qualification details couldn't be saved");
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
			logger.info("Work History details are saved successfully");
		} catch (Exception e) {
			logger.info("Work History details couldn't be saved");
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
			logger.info("Personal details are retrieved successfully");
			return candidate;
		} catch (Exception e) {
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
	public CandidatePersonal modifycandidPersonal(
			CandidatePersonal candidatePersonal) throws RecruitmentException {
		try {
			logger.info("Personal details modifications begins");
			return entityManager.merge(candidatePersonal);
		} catch (Exception e) {
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
							"select candidateQualifications From CandidateQualifications candidateQualifications where candidateQualifications.candidateId=:candID",
							CandidateQualifications.class);
			query.setParameter("candID", candidateId);
			CandidateQualifications candidate = query.getSingleResult();
			logger.info("Qualification details retrived successfully");
			return candidate;
		} catch (Exception e) {
			logger.info("Qualification details retrieval failed");
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
			logger.info("Qualification details modifications begins");
			return entityManager.merge(candidateQualifications);
		} catch (Exception e) {
			logger.info("Qualification details modifications failed");
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
			logger.info("Work History details retrived successfully");
			return candidate;
		} catch (Exception e) {
			logger.info("Work History details retrival failed");
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
			logger.info("Work History details modifications begins");
			return entityManager.merge(candidateWorkHistory);
		} catch (Exception e) {
			logger.info("Work History details modifications failed");
			throw new RecruitmentException(
					"Cannot Modify Candidate Personal Details");
		}
	}

}
