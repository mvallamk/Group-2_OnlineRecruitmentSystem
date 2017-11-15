package com.cg.orms.service;

import java.util.List;

import com.cg.orms.entities.CandidatePersonal;
import com.cg.orms.entities.CandidateQualifications;
import com.cg.orms.entities.CandidateWorkHistory;
import com.cg.orms.entities.JobApplied;
import com.cg.orms.entities.JobRequirements;
import com.cg.orms.entities.Login;
import com.cg.orms.exception.RecruitmentException;

public interface RecruitmentService {
	
	public boolean validateLoginDetails(String loginId, String password) throws RecruitmentException;

	/**
	 * When the user selects search jobs by qualification in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 * 
	 * @throws RecruitmentException
	 */
	List<JobRequirements> getJobsByQualification(String qualificationRequired)
			throws RecruitmentException;

	/**
	 * When the user selects search jobs by position in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 * 
	 * @throws RecruitmentException
	 */
	List<JobRequirements> getJobsByPosition(String positionRequired)
			throws RecruitmentException;

	/**
	 * When the user selects search jobs by Experience in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 * 
	 * @throws RecruitmentException
	 */
	List<JobRequirements> getJobsByExperience(int experienceRequired)
			throws RecruitmentException;

	/**
	 * When the user selects search jobs by location in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 * 
	 * @throws RecruitmentException
	 */
	List<JobRequirements> getJobsByLocation(String jobLocation)
			throws RecruitmentException;

	/**
	 * When the user selects Apply option in jobs.jsp,the program is directed
	 * here and the selected job details will be saved into database.
	 */
	void insertJobApplied(JobApplied jobApplied) throws RecruitmentException;

	/**
	 * When the user registers with valid credentials,the credentials will be
	 * saved by this method,but if the user_id is already taken the it throws an
	 * exception
	 * 
	 * @throws Recruitment
	 *             Exception
	 */
	void signUp(Login signupDetails) throws RecruitmentException;

	/**
	 * When the user is loging in then this method checks if the credentials are
	 * valid or not
	 * 
	 * @throws recruitment
	 *             Exception
	 */
	Login getLoginDetails(String loginId) throws RecruitmentException;

	/**
	 * When the user clicks on save personal details in resume from the program
	 * is directed here and it if there is some error it throws Recruitment
	 * Exception
	 * 
	 * @throws recruitment
	 *             Exception
	 */
	void insertCandidatePersonalDetails(CandidatePersonal candidatePersonalDetails)
			throws RecruitmentException;

	/**
	 * When the user clicks on save Qualification details in resume from the
	 * program is directed here and it if there is some error it throws
	 * Recruitment Exception
	 * 
	 * @throws recruitment
	 *             Exception
	 */
	void insertCandidateQualificationDetails(CandidateQualifications candidateQualificationDetails)
			throws RecruitmentException;

	/**
	 * When the user clicks on save Work History Details details in resume from
	 * the program is directed here and it if there is some error it throws
	 * Recruitment Exception
	 * 
	 * @throws recruitment
	 *             Exception
	 */
	void insertCandidateWorkHistoryDetails(CandidateWorkHistory candidateWorkHistoryDetails)
			throws RecruitmentException;

	/**
	 * When user selects modify personal details the program is directed here
	 * and the personal details are fetched from data base and if it faces an
	 * error it throws recruitment Exception
	 * 
	 * @throws recruitment
	 *             Exception
	 */
	CandidatePersonal getCandidatePersonalDetails(String candidateId)
			throws RecruitmentException;

	/**
	 * When the user makes changes and clicks on save in modify personal details
	 * the program is directed here and the modified details are updated here
	 * and if it faces an error it throws recruitment Exception.
	 * 
	 * @throws Recruitment
	 *             Exception
	 */
	CandidatePersonal modifyCandidatePersonalDetails(
			CandidatePersonal candidatePersonalDetails) throws RecruitmentException;

	/**
	 * * When user selects modify Qualification details the program is directed
	 * here and the Qualification details are fetched from data base and if it
	 * faces an error it throws recruitment Exception
	 * 
	 * @throws recruitment
	 *             Exception
	 */
	CandidateQualifications getCandidateQualificationDetails(String candidateId)
			throws RecruitmentException;

	/**
	 * When the user makes changes and clicks on save in modify Qualification
	 * details the program is directed here and the modified details are updated
	 * here and if it faces an error it throws recruitment Exception.
	 * 
	 * @throws Recruitment
	 *             Exception
	 */
	CandidateQualifications modifyCandidateQualificationDetails(
			CandidateQualifications candidateQualificationDetails)
			throws RecruitmentException;

	/**
	 * When user selects modify Work History details the program is directed
	 * here and the Work History details are fetched from data base and if it
	 * faces an error it throws recruitment Exception
	 * 
	 * @throws recruitment
	 *             Exception
	 */
	CandidateWorkHistory getCandidateWorkHistoryDetails(String candidateId)
			throws RecruitmentException;

	/**
	 * When the user makes changes and clicks on save in modify Work History
	 * details the program is directed here and the modified details are updated
	 * here and if it faces an error it throws recruitment Exception.
	 * 
	 * @throws Recruitment
	 *             Exception
	 */
	CandidateWorkHistory modifyCandidateWorkHistoryDetails(
			CandidateWorkHistory candidateWorkHistoryDetails)
			throws RecruitmentException;
}
