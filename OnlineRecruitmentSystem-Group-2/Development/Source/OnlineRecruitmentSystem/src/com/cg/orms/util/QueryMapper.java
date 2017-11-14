package com.cg.orms.util;

public interface QueryMapper {

	String getCandidatePersonalDetailsQuery="select candidatePersonal From CandidatePersonal candidatePersonal where candidatePersonal.candidateId=:candidateId";
	String getJobsByQualificationQuery="select jobRequirements From JobRequirements jobRequirements where jobRequirements.qualificationRequired=:qualificationRequired";
	String getJobsByPositionQuery="select jobRequirements From JobRequirements jobRequirements where jobRequirements.positionRequired=:positionRequired";
	String getJobsByExperienceQuery="select jobRequirements From JobRequirements jobRequirements where jobRequirements.experienceRequired<=:experienceRequired";
	String getJobsByLocationQuery="select jobRequirements From JobRequirements jobRequirements where jobRequirements.jobLocation=:jobLocation";
	String getCandidateQualificationDetailsQuery="select candidateQualifications From CandidateQualifications candidateQualifications where candidateQualifications.candidateId=:candidateId";
	String getCandidateWorkHistoryDetailsQuery="select candidateWorkHistory From CandidateWorkHistory candidateWorkHistory where candidateWorkHistory.candidateId=:candidateId";
}
