package com.cg.recruitment.entities;

import org.springframework.beans.factory.annotation.Autowired;

public class Resume {

	@Autowired
	CandidatePersonal candidatePersonal;

	@Autowired
	CandidateQualifications candidateQualifications;

	@Autowired
	CandidateWorkHistory candidateWorkHistory;

	public CandidatePersonal getCandidatePersonal() {
		return candidatePersonal;
	}

	public void setCandidatePersonal(CandidatePersonal candidatePersonal) {
		this.candidatePersonal = candidatePersonal;
	}

	public CandidateQualifications getCandidateQualifications() {
		return candidateQualifications;
	}

	public void setCandidateQualifications(
			CandidateQualifications candidateQualifications) {
		this.candidateQualifications = candidateQualifications;
	}

	public CandidateWorkHistory getCandidateWorkHistory() {
		return candidateWorkHistory;
	}

	public void setCandidateWorkHistory(
			CandidateWorkHistory candidateWorkHistory) {
		this.candidateWorkHistory = candidateWorkHistory;
	}

}
