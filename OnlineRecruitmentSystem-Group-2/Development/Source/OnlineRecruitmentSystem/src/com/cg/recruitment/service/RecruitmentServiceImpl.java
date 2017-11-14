package com.cg.recruitment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.recruitment.dao.ILoginDao;
import com.cg.recruitment.dao.IRecruitmentDAO;
import com.cg.recruitment.dao.IUserDao;
import com.cg.recruitment.entities.CandidatePersonal;
import com.cg.recruitment.entities.CandidateQualifications;
import com.cg.recruitment.entities.CandidateWorkHistory;
import com.cg.recruitment.entities.JobApplied;
import com.cg.recruitment.entities.JobRequirements;
import com.cg.recruitment.entities.Login;
import com.cg.recruitment.exception.RecruitmentException;

@Service
public class RecruitmentServiceImpl implements IRecruitmentService {

	@Autowired
	ILoginDao loginDAO;

	@Autowired
	IUserDao userDAO;
	
	@Autowired
	IRecruitmentDAO recruitmentDAOImpl;

	@Override
	public Login getLoginDetails(String loginId) throws RecruitmentException {
		return loginDAO.getLoginDetails(loginId);
	}

	@Override
	public void signUp(Login loginSignup) throws RecruitmentException {
		loginDAO.signUp(loginSignup);

	}

	@Override
	public boolean validateLoginDetails(String loginId, String password) throws RecruitmentException {

		if (loginDAO.getLoginDetails(loginId) == null)
			return false;
		else {
			Login loginDetails = loginDAO.getLoginDetails(loginId);
			if (loginDetails.getPassword().equals(password)) {
				return true;
			} else
				return false;
		}
	}

	@Override
	public void addCandidatePersonalDetails(CandidatePersonal candPers)
			throws RecruitmentException {
		userDAO.candidPersonal(candPers);
	}

	@Override
	public void addCandidateQualificationDetails(CandidateQualifications candQual)
			throws RecruitmentException {
		userDAO.candidQualification(candQual);

	}

	@Override
	public void addCandidateWorkHistoryDetails(CandidateWorkHistory candHist)
			throws RecruitmentException {
		userDAO.candidWorkHistory(candHist);

	}

	@Override
	public CandidatePersonal getCandidatePersonalDetails(String candidateId) throws RecruitmentException {
		return userDAO.getCandidatePersonalDetails(candidateId);
	}

	@Override
	public CandidatePersonal modifycandidPersonal(
			CandidatePersonal candidatePersonal) throws RecruitmentException {

		return userDAO.modifycandidPersonal(candidatePersonal);
	}

	@Override
	public CandidateQualifications getCandidateQualificationDetails(
			String candidateId) throws RecruitmentException {

		return userDAO.getCandidateQualificationDetails(candidateId);
	}

	@Override
	public CandidateQualifications modifycandidQualifications(
			CandidateQualifications candidateQualifications) throws RecruitmentException {

		return userDAO.modifycandidQualifications(candidateQualifications);

	}

	@Override
	public CandidateWorkHistory getCandidateWorkHistoryDetails(
			String candidateId) throws RecruitmentException {

		return userDAO.getCandidateWorkHistoryDetails(candidateId);
	}

	@Override
	public CandidateWorkHistory modifycandidWorkHistory(
			CandidateWorkHistory candidateWorkHistory) throws RecruitmentException {

		return userDAO.modifycandidWorkHistory(candidateWorkHistory);
	}
	@Override
	public void insertApplyJob(JobApplied jobApplied)
			throws RecruitmentException {
		recruitmentDAOImpl.insertApplyJob(jobApplied);
	}
	
	@Override
	public List<JobRequirements> getJobByLocation(String loc) {

		return recruitmentDAOImpl.getJobByLocation(loc);
	}
	@Override
	public List<JobRequirements> getJobByExperience(int exp) {

		return recruitmentDAOImpl.getJobByExperience(exp);
	}
	@Override
	public List<JobRequirements> getJobByPosition(String pos) {

		return recruitmentDAOImpl.getJobByPosition(pos);
	}
	@Override
	public List<JobRequirements> getJobByQual(String qual) {
		return recruitmentDAOImpl.getJobByQual(qual);
	}
}
