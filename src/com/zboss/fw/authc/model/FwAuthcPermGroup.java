package com.zboss.fw.authc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FwAuthcPermGroup {

	@Id
	@Column(length = 32)
	private String id;
	@Column(nullable = false)
	private String name;
	private String brief;
	@Column(nullable = false)
	private String orderBy;

	public void setId(String param) {
		this.id = param;
	}

	public String getId() {
		return id;
	}

	public void setOrderBy(String param) {
		this.orderBy = param;
	}

	public String getOrderBy() {
		return orderBy;
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

}