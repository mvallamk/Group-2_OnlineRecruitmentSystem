package com.cg.recruitment.service;

import java.util.List;

import com.cg.recruitment.entities.CandidatePersonal;
import com.cg.recruitment.entities.CandidateQualifications;
import com.cg.recruitment.entities.CandidateWorkHistory;
import com.cg.recruitment.entities.JobApplied;
import com.cg.recruitment.entities.JobRequirements;
import com.cg.recruitment.entities.Login;
import com.cg.recruitment.exception.RecruitmentException;

public interface IRecruitmentService {

	public abstract void signUp(Login loginSignup) throws RecruitmentException;

	public abstract Login getLoginDetails(String loginId) throws RecruitmentException;

	boolean validateLoginDetails(String loginId, String password) throws RecruitmentException;

	public abstract void addCandidatePersonalDetails(CandidatePersonal candidatePersonal)
			throws RecruitmentException;	

	public abstract void addCandidateQualificationDetails(CandidateQualifications candidateQualifications)
			throws RecruitmentException;

	public abstract void addCandidateWorkHistoryDetails(CandidateWorkHistory candidateWorkHistory)
			throws RecruitmentException;

	CandidatePersonal getCandidatePersonalDetails(String candidateId) throws RecruitmentException;

	public abstract CandidatePersonal modifycandidPersonal(
			CandidatePersonal candidatePersonal) throws RecruitmentException;

	public abstract CandidateQualifications getCandidateQualificationDetails(
			String candidateId) throws RecruitmentException;

	public abstract CandidateQualifications modifycandidQualifications(
			CandidateQualifications candidateQualifications) throws RecruitmentException;
	
	public abstract CandidateWorkHistory getCandidateWorkHistoryDetails(
			String candidateId) throws RecruitmentException;
	public abstract CandidateWorkHistory modifycandidWorkHistory(
			CandidateWorkHistory candidateWorkHistory) throws RecruitmentException;

	public abstract void insertApplyJob(JobApplied jobApplied)
			throws RecruitmentException;
	public abstract List<JobRequirements> getJobByQual(String qual);

	public abstract List<JobRequirements> getJobByPosition(String pos);

	public abstract List<JobRequirements> getJobByExperience(int exp);

	public abstract List<JobRequirements> getJobByLocation(String loc);
}
