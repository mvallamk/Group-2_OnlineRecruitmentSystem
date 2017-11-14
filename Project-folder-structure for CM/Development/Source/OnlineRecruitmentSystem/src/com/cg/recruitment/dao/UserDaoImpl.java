package com.cg.recruitment.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
