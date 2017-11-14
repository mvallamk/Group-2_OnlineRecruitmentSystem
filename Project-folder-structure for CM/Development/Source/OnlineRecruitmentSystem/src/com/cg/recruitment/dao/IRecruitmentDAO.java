package com.cg.recruitment.dao;

import java.util.List;

import com.cg.recruitment.entities.JobApplied;
import com.cg.recruitment.entities.JobRequirements;
import com.cg.recruitment.exception.RecruitmentException;

public interface IRecruitmentDAO {

	/**
	 * When the user selects search jobs by qualification in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 */
	public abstract List<JobRequirements> getJobByQual(String qual);

	/**
	 * When the user selects search jobs by position in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 */
	public abstract List<JobRequirements> getJobByPosition(String pos);

	/**
	 * When the user selects search jobs by Experience in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 */
	public abstract List<JobRequirements> getJobByExperience(int exp);

	/**
	 * When the user selects search jobs by location in searchjobs.jsp,the
	 * program is directed here and the list of jobs matching the criteria is
	 * fetched from database.
	 */
	public abstract List<JobRequirements> getJobByLocation(String loc);

	/**
	 * When the user selects Apply option in jobs.jsp,the program is directed
	 * here and the selected job details will be saved into database.
	 */
	public abstract void insertApplyJob(JobApplied jobApplied)
			throws RecruitmentException;

}
