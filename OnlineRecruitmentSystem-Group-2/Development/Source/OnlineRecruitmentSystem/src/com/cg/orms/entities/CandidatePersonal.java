package com.cg.orms.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CandidatePersonal implements Serializable {

	private static final long serialVersionUID = -4098198709663149494L;

	@Id
	private String candidateId;
	private String candidateName;
	private String address;
	private String emailId;
	private String contactNumber;
	private String maritalStatus;
	private String Gender;
	private String passportNumber;
	private Date dob;

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CandidatePersonal [candidateId=" + candidateId
				+ ", candidateName=" + candidateName + ", address=" + address
				+ ", date=" + dob + ", emailId=" + emailId + ", contactNumber="
				+ contactNumber + ", maritalStatus=" + maritalStatus
				+ ", Gender=" + Gender + ", passportNumber=" + passportNumber
				+ "]" + "\n";
	}

}
