package com.cg.orms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.orms.dao.RecruitmentDAO;
import com.cg.orms.entities.CandidatePersonal;
import com.cg.orms.entities.CandidateQualifications;
import com.cg.orms.entities.CandidateWorkHistory;
import com.cg.orms.entities.JobApplied;
import com.cg.orms.entities.JobRequirements;
import com.cg.orms.entities.Login;
import com.cg.orms.exception.RecruitmentException;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
	@Autowired
	RecruitmentDAO recruitmentDAOImpl;

	@Override
	public Login getLoginDetails(String loginId) throws RecruitmentException {
		return recruitmentDAOImpl.getLoginDetails(loginId);
	}

	@Override
	public void signUp(Login signupDetails) throws RecruitmentException {
		recruitmentDAOImpl.signUp(signupDetails);
	}

	@Override
	public boolean validateLoginDetails(String loginId, String password)
			throws RecruitmentException {

		if (recruitmentDAOImpl.getLoginDetails(loginId) == null)
			return false;
		else {
			Login loginDetails = recruitmentDAOImpl.getLoginDetails(loginId);
			if (loginDetails.getPassword().equals(password)) {
				return true;
			} else
				return false;
		}
	}

	@Override
	public void insertCandidatePersonalDetails(
			CandidatePersonal candidatePersonalDetails)
			throws RecruitmentException {
		recruitmentDAOImpl
				.insertCandidatePersonalDetails(candidatePersonalDetails);
	}

	@Override
	public void insertCandidateQualificationDetails(
			CandidateQualifications candidateQualificationDetails)
			throws RecruitmentException {
		recruitmentDAOImpl
				.insertCandidateQualificationDetails(candidateQualificationDetails);
	}

	@Override
	public void insertCandidateWorkHistoryDetails(
			CandidateWorkHistory candidateWorkHistoryDetails)
			throws RecruitmentException {
		recruitmentDAOImpl
				.insertCandidateWorkHistoryDetails(candidateWorkHistoryDetails);
	}

	@Override
	public CandidatePersonal getCandidatePersonalDetails(String candidateId)
			throws RecruitmentException {
		return recruitmentDAOImpl.getCandidatePersonalDetails(candidateId);
	}

	@Override
	public CandidatePersonal modifyCandidatePersonalDetails(
			CandidatePersonal candidatePersonalDetails)
			throws RecruitmentException {
		return recruitmentDAOImpl
				.modifyCandidatePersonalDetails(candidatePersonalDetails);
	}

	@Override
	public CandidateQualifications getCandidateQualificationDetails(
			String candidateId) throws RecruitmentException {
		return recruitmentDAOImpl.getCandidateQualificationDetails(candidateId);
	}

	@Override
	public CandidateQualifications modifyCandidateQualificationDetails(
			CandidateQualifications candidateQualificationDetails)
			throws RecruitmentException {
		return recruitmentDAOImpl
				.modifyCandidateQualificationDetails(candidateQualificationDetails);
	}

	@Override
	public CandidateWorkHistory getCandidateWorkHistoryDetails(
			String candidateId) throws RecruitmentException {
		return recruitmentDAOImpl.getCandidateWorkHistoryDetails(candidateId);
	}

	@Override
	public CandidateWorkHistory modifyCandidateWorkHistoryDetails(
			CandidateWorkHistory candidateWorkHistoryDetails)
			throws RecruitmentException {
		return recruitmentDAOImpl
				.modifyCandidateWorkHistoryDetails(candidateWorkHistoryDetails);
	}

	@Override
	public void insertJobApplied(JobApplied jobApplied)
			throws RecruitmentException {
		recruitmentDAOImpl.insertJobApplied(jobApplied);
	}

	@Override
	public List<JobRequirements> getJobsByLocation(String jobLocation)
			throws RecruitmentException {
		return recruitmentDAOImpl.getJobsByLocation(jobLocation);
	}

	@Override
	public List<JobRequirements> getJobsByExperience(int experienceRequired)
			throws RecruitmentException {
		return recruitmentDAOImpl.getJobsByExperience(experienceRequired);
	}

	@Override
	public List<JobRequirements> getJobsByPosition(String positionRequired)
			throws RecruitmentException {
		return recruitmentDAOImpl.getJobsByPosition(positionRequired);
	}

	@Override
	public List<JobRequirements> getJobsByQualification(
			String qualificationRequired) throws RecruitmentException {
		return recruitmentDAOImpl.getJobsByQualification(qualificationRequired);
	}
}
