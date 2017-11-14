package com.cg.orms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.orms.dao.ILoginDao;
import com.cg.orms.dao.RecruitmentDAO;
import com.cg.orms.dao.IUserDao;
import com.cg.orms.entities.CandidatePersonal;
import com.cg.orms.entities.CandidateQualifications;
import com.cg.orms.entities.CandidateWorkHistory;
import com.cg.orms.entities.JobApplied;
import com.cg.orms.entities.JobRequirements;
import com.cg.orms.entities.Login;
import com.cg.orms.exception.RecruitmentException;

@Service
public class RecruitmentServiceImpl implements IRecruitmentService {

	@Autowired
	ILoginDao loginDAO;

	@Autowired
	IUserDao userDAO;
	
	@Autowired
	RecruitmentDAO recruitmentDAOImpl;

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
