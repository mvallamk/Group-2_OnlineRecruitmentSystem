package com.cg.recruitment.util;

public interface QueryMapper {

	String getCandidatePersonalDetailsQuery="select candidatePersonal From CandidatePersonal candidatePersonal where candidatePersonal.candidateId=:candID";
}
