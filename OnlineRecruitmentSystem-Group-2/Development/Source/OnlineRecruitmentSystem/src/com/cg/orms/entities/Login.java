package com.cg.orms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Login implements Serializable {

	private static final long serialVersionUID = -5468237997249019694L;

	@Id
	@Size(min = 8, max = 16, message = "Username can only be 8-16 charaters long")
	@Pattern(regexp = "[A-Za-z0-9]{8,16}", message = "Only char and numbers are allowed")
	String loginId;

	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+])[A-Za-z0-9][A-Za-z0-9!@#$%^&*()_+]{7,15}$", message = "Password must contain atleast one Char,one Digit and one Special Character. It should not start with Special Character")
	@Size(min = 8, max = 16, message = "Password Length can only be between 8-16")
	String password;

	@NotEmpty(message = "Please Select any option")
	String type;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", password=" + password
				+ ", type=" + type + "]";
	}

}
