package com.cg.orms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Job_Applied")
public class JobApplied implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String jobId;
	private String candidateId;
	private String compId;

	public String getCompId() {
		return compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	public JobApplied() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobApplied(String jobId, String candidateId) {
		super();
		this.jobId = jobId;
		this.candidateId = candidateId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	@Override
	public String toString() {
		return "JobApplied [id=" + id + ", jobId=" + jobId + ", candidateId="
				+ candidateId + ", compId=" + compId + "]" + "\n";
	}
}
