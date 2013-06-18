package com.zboss.fw.authc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FwAuthcPerm {

	@Id
	@Column(length = 32)
	private String id;
	@Column(nullable = false)
	private String uri;
	@Column(nullable = false)
	private String action;
	@Column(length = 50, nullable = false)
	private String name;
	private String brief;
	@ManyToOne(optional = false)
	private FwAuthcPermGroup fwAuthcPermGroup;

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

	public void setUri(String param) {
		this.uri = param;
	}

	public String getUri() {
		return uri;
	}

	public FwAuthcPermGroup getFwAuthcPermGroup() {
		return fwAuthcPermGroup;
	}

	public void setFwAuthcPermGroup(FwAuthcPermGroup param) {
		this.fwAuthcPermGroup = param;
	}

	public void setAction(String param) {
		this.action = param;
	}

	public String getAction() {
		return action;
	}

}