package com.cg.orms.service;
/*package com.cg.recruitment.service;

import java.util.List;

import com.cg.recruitment.entities.CandidatePersonal;
import com.cg.recruitment.entities.CandidateQualifications;
import com.cg.recruitment.entities.CandidateWorkHistory;
import com.cg.recruitment.entities.CompanyMaster;
import com.cg.recruitment.entities.HireDetails;
import com.cg.recruitment.entities.JobApplied;
import com.cg.recruitment.entities.JobRequirements;
import com.cg.recruitment.entities.Login;
import com.cg.recruitment.exception.RecruitmentException;

public interface IServiceDaoRec {
	public abstract void signUp(Login loginSignup) throws RecruitmentException;

	boolean validateLoginDetails(String loginId, String password);

	public abstract Login getLoginDetails(String loginId);

	List<JobRequirements> getJobs() throws RecruitmentException;

	public abstract void candidPersonal(CandidatePersonal candpers)
			throws RecruitmentException;

	public abstract void candidQualification(CandidateQualifications candQual)
			throws RecruitmentException;

	public abstract void candidWorkHistory(CandidateWorkHistory candHist)
			throws RecruitmentException;

	public void addCompanyDetails(CompanyMaster companyMaster)
			throws RecruitmentException;

	public void updateCompanyDetails(CompanyMaster companyMaster)
			throws RecruitmentException;

	public void postJobRequirements(JobRequirements jobRequirements)
			throws RecruitmentException;

	public CompanyMaster getCompany(String companyId);

	public abstract List<JobRequirements> getJobByQual(String qual);

	public abstract List<JobRequirements> getJobByPosition(String pos);

	public abstract List<JobRequirements> getJobByExperience(int exp);

	public abstract List<JobRequirements> getJobByLocation(String loc);

	public abstract List<CandidateWorkHistory> getCandidateByQual(String qual);

	public abstract List<CandidateWorkHistory> getCandidateByPosition(String pos);

	public abstract List<CandidateWorkHistory> getCandidateByExperience(int exp);

	public abstract List<JobApplied> getAllAppliedCandidates();

	public abstract void addHiredCandidates(HireDetails hiredetails)
			throws RecruitmentException;

	public abstract void insertApplyJob(JobApplied jobApplied)
			throws RecruitmentException;
}
*/