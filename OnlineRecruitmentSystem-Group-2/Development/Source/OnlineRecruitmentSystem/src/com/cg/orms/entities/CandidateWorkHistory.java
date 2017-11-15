package com.cg.orms.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {@NamedQuery(name = "pos.getAll", query = "select candidateWorkHistory From CandidateWorkHistory candidateWorkHistory  where candidateWorkHistory.positionHeld='se'")})

public class CandidateWorkHistory implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Id
	private String candidateId;
	private String whichEmployer;
	private String contactPerson;
	private String positionHeld;
	private String companyName;
	private Date employmentFrom;
	private Date employmentTo;
	private String reasonForLeaving;
	private String responsibilities;
	private String hrRepName;
	private String hrRepContactNumber;
	
	
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getWhichEmployer() {
		return whichEmployer;
	}
	public void setWhichEmployer(String whichEmployer) {
		this.whichEmployer = whichEmployer;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getPositionHeld() {
		return positionHeld;
	}
	public void setPositionHeld(String positionHeld) {
		this.positionHeld = positionHeld;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getEmploymentFrom() {
		return employmentFrom;
	}
	public void setEmploymentFrom(Date employmentFrom) {
		this.employmentFrom = employmentFrom;
	}
	public Date getEmploymentTo() {
		return employmentTo;
	}
	public void setEmploymentTo(Date employmentTo) {
		this.employmentTo = employmentTo;
	}
	public String getReasonForLeaving() {
		return reasonForLeaving;
	}
	public void setReasonForLeaving(String reasonForLeaving) {
		this.reasonForLeaving = reasonForLeaving;
	}
	public String getResponsibilities() {
		return responsibilities;
	}
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}
	public String getHrRepName() {
		return hrRepName;
	}
	public void setHrRepName(String hrRepName) {
		this.hrRepName = hrRepName;
	}
	public String getHrRepContactNumber() {
		return hrRepContactNumber;
	}
	public void setHrRepContactNumber(String hrRepContactNumber) {
		this.hrRepContactNumber = hrRepContactNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CandidateWorkHistory [candidateId=" + candidateId
				+ ", whichEmployer=" + whichEmployer + ", contactPerson="
				+ contactPerson + ", positionHeld=" + positionHeld
				+ ", companyName=" + companyName + ", employmentFrom="
				+ employmentFrom + ", employmentTo=" + employmentTo
				+ ", reasonForLeaving=" + reasonForLeaving
				+ ", responsibilities=" + responsibilities + ", hrRepName="
				+ hrRepName + ", hrRepContactNumber=" + hrRepContactNumber
				+ "]";
	}

	
	
}
