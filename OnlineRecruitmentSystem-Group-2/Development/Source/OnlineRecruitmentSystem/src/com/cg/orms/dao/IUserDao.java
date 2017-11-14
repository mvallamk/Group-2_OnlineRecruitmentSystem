package com.cg.orms.dao;

import com.cg.orms.entities.CandidatePersonal;
import com.cg.orms.entities.CandidateQualifications;
import com.cg.orms.entities.CandidateWorkHistory;
import com.cg.orms.exception.RecruitmentException;

public interface IUserDao {

	/**
	 * When the user clicks on save personal details in resume from the program is
	 * directed here and it if there is some error it throws Recruitment Exception
	 * @throws recruitment Exception
	 */
	public abstract void candidPersonal(CandidatePersonal candPers)
			throws RecruitmentException;

	/**
	 *  When the user clicks on save Qualification details in resume from the program is
	 * directed here and it if there is some error it throws Recruitment Exception
	 * @throws recruitment Exception
	 */
	public abstract void candidQualification(CandidateQualifications candQual)
			throws RecruitmentException;

	/**
	 *  When the user clicks on save Work History Details details in resume from
	 *   the program is directed here and it if there is some error it throws 
	 *   Recruitment Exception
	 * @throws recruitment Exception
	 */
	public abstract void candidWorkHistory(CandidateWorkHistory candHist)
			throws RecruitmentException;

	/**
	 * When user selects modify personal details the program is directed here and 
	 * the personal details are fetched from data base and if it faces an error it throws
	 * recruitment Exception
	 * @throws recruitment Exception
	 */
	CandidatePersonal getCandidatePersonalDetails(String candidateId) throws RecruitmentException;

	/**
	 * When the user makes changes and clicks on save in modify personal details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public abstract CandidatePersonal modifycandidPersonal(
			CandidatePersonal candidatePersonal) throws RecruitmentException;

	/**
	 * * When user selects modify Qualification details the program is directed here and 
	 * the Qualification details are fetched from data base and if it faces an error it
	 *  throws recruitment Exception
	 * @throws recruitment Exception
	 */
	public abstract CandidateQualifications getCandidateQualificationDetails(
			String candidateId) throws RecruitmentException;

	/**
	 * When the user makes changes and clicks on save in modify Qualification details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public abstract CandidateQualifications modifycandidQualifications(
			CandidateQualifications candidateQualifications) throws RecruitmentException;

	/**
	 * When user selects modify Work History details the program is directed here and 
	 * the Work History details are fetched from data base and if it faces an error it
	 *  throws recruitment Exception
	 * @throws recruitment Exception
	 */
	public abstract CandidateWorkHistory getCandidateWorkHistoryDetails(
			String candidateId) throws RecruitmentException;

	/**
	 *  When the user makes changes and clicks on save in modify Work History details 
	 * the program is directed here and the modified details are updated here and
	 * if it faces an error it throws recruitment Exception.
	 * @throws Recruitment Exception
	 */
	public abstract CandidateWorkHistory modifycandidWorkHistory(
			CandidateWorkHistory candidateWorkHistory) throws RecruitmentException;
}
