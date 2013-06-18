package com.zboss.fw.authc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class FwAuthcUser {

	@Id
	@Column(length = 32)
	private String id;
	@Column(length = 50, nullable = false, unique = true)
	private String code;
	@Column(length = 50, nullable = false)
	private String password;
	@Column(nullable = false)
	private Boolean enabled;
	@OneToOne
	private FwAuthcPerson fwAuthcPerson;
	@ManyToMany
	private Set<FwAuthcRole> fwAuthcRoles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String param) {
		this.password = param;
	}

	public String getPassword() {
		return password;
	}

	public void setEnabled(Boolean param) {
		this.enabled = param;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setCode(String param) {
		this.code = param;
	}

	public String getCode() {
		return code;
	}

	public FwAuthcPerson getFwAuthcPerson() {
		return fwAuthcPerson;
	}

	public void setFwAuthcPerson(FwAuthcPerson param) {
		this.fwAuthcPerson = param;
	}

	public Set<FwAuthcRole> getFwAuthcRoles() {
		return fwAuthcRoles;
	}

	public void setFwAuthcRoles(Set<FwAuthcRole> param) {
		this.fwAuthcRoles = param;
	}

}