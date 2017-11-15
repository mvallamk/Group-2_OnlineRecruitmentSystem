package com.cg.orms.exception;

public class RecruitmentException extends Exception {
	private static final long serialVersionUID = 6174197178598014602L;

	public RecruitmentException() {
	}

	public RecruitmentException(String message) {
		super(message);
	}

	public RecruitmentException(Throwable cause) {
		super(cause);
	}

	public RecruitmentException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecruitmentException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
