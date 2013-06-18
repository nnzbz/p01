package com.zboss.fw.authc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FwAuthcGroup {

	@Id
	@Column(length = 32)
	private String id;
	@Column(nullable = false, unique = true)
	private String code;
	@Column(length = 50, nullable = false)
	private String name;
	private String shortName;
	@Column(columnDefinition = "varchar(500)")
	private String fullName;
	private String brief;
	public void setName(String param) {
		this.name = param;
	}

	public String getName() {
		return name;
	}

	public void setId(String param) {
		this.id = param;
	}

	public String getId() {
		return id;
	}

	public void setBrief(String param) {
		this.brief = param;
	}

	public String getBrief() {
		return brief;
	}

	public void setShortName(String param) {
		this.shortName = param;
	}

	public String getShortName() {
		return shortName;
	}

	public void setFullName(String param) {
		this.fullName = param;
	}

	public String getFullName() {
		return fullName;
	}

	public void setCode(String param) {
		this.code = param;
	}

	public String getCode() {
		return code;
	}

}