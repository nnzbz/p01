package com.zboss.fw.core.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class FwHelloOne {

	public enum HelloOneEnum {
		你好, HELLO, HI, 喂
	}

	@Id
	@Column(length = 32)
	private String id;
	@Column(length = 200)
	private String stringOne;
	private Integer integerOne;
	private Float floatOne;
	private Double doubleOne;
	private BigDecimal moneyOne;
	private Date dateOne;
	private Boolean boolOne;
	private Long longOne;
	@Enumerated
	private HelloOneEnum enumOne;
	@Lob
	private byte[] blobOne;
	@Lob
	private String clobOne;
	@OneToMany(mappedBy = "fwHelloOne")
	private Set<FwHelloTwo> fwHelloTwos;

	public void setId(String param) {
		this.id = param;
	}

	public String getId() {
		return id;
	}

	public void setStringOne(String param) {
		this.stringOne = param;
	}

	public String getStringOne() {
		return stringOne;
	}

	public void setIntegerOne(Integer param) {
		this.integerOne = param;
	}

	public Integer getIntegerOne() {
		return integerOne;
	}

	public void setFloatOne(Float param) {
		this.floatOne = param;
	}

	public Float getFloatOne() {
		return floatOne;
	}

	public void setDoubleOne(Double param) {
		this.doubleOne = param;
	}

	public Double getDoubleOne() {
		return doubleOne;
	}

	public void setMoneyOne(BigDecimal param) {
		this.moneyOne = param;
	}

	public BigDecimal getMoneyOne() {
		return moneyOne;
	}

	public void setDateOne(Date param) {
		this.dateOne = param;
	}

	public Date getDateOne() {
		return dateOne;
	}

	public void setBoolOne(Boolean param) {
		this.boolOne = param;
	}

	public Boolean getBoolOne() {
		return boolOne;
	}

	public void setLongOne(Long param) {
		this.longOne = param;
	}

	public Long getLongOne() {
		return longOne;
	}

	public void setEnumOne(HelloOneEnum param) {
		this.enumOne = param;
	}

	public HelloOneEnum getEnumOne() {
		return enumOne;
	}

	public void setBlobOne(byte[] param) {
		this.blobOne = param;
	}

	public byte[] getBlobOne() {
		return blobOne;
	}

	public void setClobOne(String param) {
		this.clobOne = param;
	}

	public String getClobOne() {
		return clobOne;
	}

	public void setFwHelloTwos(Set<FwHelloTwo> param) {
		this.fwHelloTwos = param;
	}

	public Set<FwHelloTwo> getFwHelloTwos() {
		return fwHelloTwos;
	}

}
