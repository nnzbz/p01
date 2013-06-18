package com.zboss.fw.authc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.zboss.fw.authc.model.FwAuthcPerm;
import java.util.Set;
import javax.persistence.ManyToMany;

@Entity
public class FwAuthcRole {

	@Id
	@Column(length = 32)
	private String id;
	@Column(length = 50, nullable = false)
	private String name;
	private String brief;
	@ManyToMany
	private Set<FwAuthcPerm> fwAuthcPerms;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String param) {
		this.name = param;
	}

	public String getName() {
		return name;
	}

	public void setBrief(String param) {
		this.brief = param;
	}

	public String getBrief() {
		return brief;
	}

	public Set<FwAuthcPerm> getFwAuthcPerms() {
	    return fwAuthcPerms;
	}

	public void setFwAuthcPerms(Set<FwAuthcPerm> param) {
	    this.fwAuthcPerms = param;
	}

}