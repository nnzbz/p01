package com.zboss.fw.authc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FwAuthcPerson {

	@Id
	@Column(length = 32)
	private String id;
	@Column(length = 50, nullable = false)
	private String name;
	private String brief;
	private String tel;
	private String mob;
	private String fax;
	private String email;
	private String qq;
	@Column(columnDefinition = "varchar(500)")
	private String addr;
	@Column(length = 18)
	private String idCard;
	private Date birthday;
	@ManyToOne(optional = false)
	private FwAuthcGroup fwAuthcGroup;
	private String orderBy;
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

	public void setTel(String param) {
		this.tel = param;
	}

	public String getTel() {
		return tel;
	}

	public void setMob(String param) {
		this.mob = param;
	}

	public String getMob() {
		return mob;
	}

	public void setFax(String param) {
		this.fax = param;
	}

	public String getFax() {
		return fax;
	}

	public void setEmail(String param) {
		this.email = param;
	}

	public String getEmail() {
		return email;
	}

	public void setQq(String param) {
		this.qq = param;
	}

	public String getQq() {
		return qq;
	}

	public void setAddr(String param) {
		this.addr = param;
	}

	public String getAddr() {
		return addr;
	}

	public void setIdCard(String param) {
		this.idCard = param;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setBirthday(Date param) {
		this.birthday = param;
	}

	public Date getBirthday() {
		return birthday;
	}

	public FwAuthcGroup getFwAuthcGroup() {
		return fwAuthcGroup;
	}

	public void setFwAuthcGroup(FwAuthcGroup param) {
		this.fwAuthcGroup = param;
	}

	public void setOrderBy(String param) {
		this.orderBy = param;
	}

	public String getOrderBy() {
		return orderBy;
	}

}