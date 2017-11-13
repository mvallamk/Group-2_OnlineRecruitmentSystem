package com.cg.recruitment.dao;

import com.cg.recruitment.entities.CandidatePersonal;
import com.cg.recruitment.entities.CandidateQualifications;
import com.cg.recruitment.entities.CandidateWorkHistory;
import com.cg.recruitment.exception.RecruitmentException;

public interface IUserDao {

	public abstract void candidPersonal(CandidatePersonal candPers)
			throws RecruitmentException;

	public abstract void candidQualification(CandidateQualifications candQual)
			throws RecruitmentException;

	public abstract void candidWorkHistory(CandidateWorkHistory candHist)
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
}
