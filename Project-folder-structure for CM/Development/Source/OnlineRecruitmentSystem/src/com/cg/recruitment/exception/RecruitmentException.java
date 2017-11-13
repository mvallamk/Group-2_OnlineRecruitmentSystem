package com.cg.recruitment.exception;

public class RecruitmentException extends Exception {

	String message2;
	private static final long serialVersionUID = -2060774632392928876L;

	public RecruitmentException(String message) {
		message2 = message;
	}

	@Override
	public String getMessage() {

		return message2;
	}

}
