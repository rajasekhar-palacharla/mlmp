package com.mlm.model;

import java.io.Serializable;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Nasaramma Velivemula
 * 
 */
@Entity
@Table(name = "webuser")
public class WebUser implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer USER_ID;

	@Column(name = "USER_EMAIL_ID")
	private String USER_EMAIL_ID;

	@Column(name = "USER_PASSWORD")
	@Size(min = 8, max = 25)
	private String USER_PASSWORD;

	@Column(name = "USER_CONTACT_NO")
	private Long USER_CONTACT_NO;

	@Column(name = "USER_ROLE")
	private String USER_ROLE;

	public Integer getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(Integer USER_ID) {
		this.USER_ID = USER_ID;
	}

	public String getUSER_EMAIL_ID() {
		return USER_EMAIL_ID;
	}

	public void setUSER_EMAIL_ID(String USER_EMAIL_ID) {
		this.USER_EMAIL_ID = USER_EMAIL_ID;
	}

	public String getUSER_PASSWORD() {
		return USER_PASSWORD;
	}

	public void setUSER_PASSWORD(String USER_PASSWORD) {
		this.USER_PASSWORD = USER_PASSWORD;
	}

	public Long getUSER_CONTACT_NO() {
		return USER_CONTACT_NO;
	}

	public void setUSER_CONTACT_NO(Long USER_CONTACT_NO) {
		this.USER_CONTACT_NO = USER_CONTACT_NO;
	}

	public String getUSER_ROLE() {
		return USER_ROLE;
	}

	public void setUSER_ROLE(String USER_ROLE) {
		this.USER_ROLE = USER_ROLE;
	}

}
