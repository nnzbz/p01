package com.zboss.fw.core.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import static javax.persistence.EnumType.STRING;

@Entity
public class FwHelloTwo {

	public enum HelloTwoEnum {
		你好, HELLO, HI, 喂
	}

	@Id
	@Column(length = 32)
	private String id;
	@Column(length = 200)
	private String stringTwo;
	private Integer integerTwo;
	private Float floatTwo;
	private Double doubleTwo;
	private BigDecimal moneyTwo;
	private Date dateTwo;
	private Boolean boolTwo;
	private Long longTwo;
	@Lob
	private byte[] blobTwo;
	@Lob
	private String clobTwo;
	@ManyToOne
	private FwHelloOne fwHelloOne;
	@Enumerated(STRING)
	private HelloTwoEnum enumTwo;

	public void setId(String param) {
		this.id = param;
	}

	public String getId() {
		return id;
	}

	public void setStringTwo(String param) {
		this.stringTwo = param;
	}

	public String getStringTwo() {
		return stringTwo;
	}

	public void setIntegerTwo(Integer param) {
		this.integerTwo = param;
	}

	public Integer getIntegerTwo() {
		return integerTwo;
	}

	public void setFloatTwo(Float param) {
		this.floatTwo = param;
	}

	public Float getFloatTwo() {
		return floatTwo;
	}

	public void setDoubleTwo(Double param) {
		this.doubleTwo = param;
	}

	public Double getDoubleTwo() {
		return doubleTwo;
	}

	public void setMoneyTwo(BigDecimal param) {
		this.moneyTwo = param;
	}

	public BigDecimal getMoneyTwo() {
		return moneyTwo;
	}

	public void setDateTwo(Date param) {
		this.dateTwo = param;
	}

	public Date getDateTwo() {
		return dateTwo;
	}

	public void setBoolTwo(Boolean param) {
		this.boolTwo = param;
	}

	public Boolean getBoolTwo() {
		return boolTwo;
	}

	public void setLongTwo(Long param) {
		this.longTwo = param;
	}

	public Long getLongTwo() {
		return longTwo;
	}

	public void setBlobTwo(byte[] param) {
		this.blobTwo = param;
	}

	public byte[] getBlobTwo() {
		return blobTwo;
	}

	public void setClobTwo(String param) {
		this.clobTwo = param;
	}

	public String getClobTwo() {
		return clobTwo;
	}

	public FwHelloOne getFwHelloOne() {
		return fwHelloOne;
	}

	public void setFwHelloOne(FwHelloOne param) {
		this.fwHelloOne = param;
	}

	public void setEnumTwo(HelloTwoEnum param) {
		this.enumTwo = param;
	}

	public HelloTwoEnum getEnumTwo() {
		return enumTwo;
	}
}