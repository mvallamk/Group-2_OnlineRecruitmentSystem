package com.cg.recruitment.dao;

import java.util.List;

import com.cg.recruitment.entities.JobApplied;
import com.cg.recruitment.entities.JobRequirements;
import com.cg.recruitment.exception.RecruitmentException;

public interface IRecruitmentDAO {

	public abstract List<JobRequirements> getJobByQual(String qual);

	public abstract List<JobRequirements> getJobByPosition(String pos);

	public abstract List<JobRequirements> getJobByExperience(int exp);

	public abstract List<JobRequirements> getJobByLocation(String loc);

	public abstract void insertApplyJob(JobApplied jobApplied)
			throws RecruitmentException;

}
