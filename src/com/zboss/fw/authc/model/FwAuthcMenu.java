package com.zboss.fw.authc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import com.zboss.fw.authc.model.FwAuthcPerm;
import javax.persistence.OneToOne;

@Entity
public class FwAuthcMenu {

	@Id
	@Column(length = 32)
	private String id;
	@Column(length = 50, nullable = false)
	private String name;
	private String brief;
	@OneToOne
	private FwAuthcPerm fwAuthcPerm;

	public void setId(String param) {
		this.id = param;
	}

	public String getId() {
		return id;
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

	public FwAuthcPerm getFwAuthcPerm() {
		return fwAuthcPerm;
	}

	public void setFwAuthcPerm(FwAuthcPerm param) {
		this.fwAuthcPerm = param;
	}

}