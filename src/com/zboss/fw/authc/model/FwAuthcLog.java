package com.zboss.fw.authc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author 张柏子
 * @creation 2013-5-5
 */
@Entity
public class FwAuthcLog {

	@Id
	@Column(length = 32)
	private String id;
	@Column(length = 50, nullable = false, unique = false)
	private String name;
	private String brief;
	/**
	 * 建立时间
	 */
	private Date createTime;
	/**
	 * 客户端IP
	 */
	private String ip;
	/**
	 * 操作是否成功
	 */
	private Boolean isSuccess;
	/**
	 * 操作用户
	 */
	@ManyToOne(optional = false)
	private FwAuthcUser fwAuthcUser;
	/**
	 * 分类
	 */
	private String category;

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

	public void setLogTime(Date param) {
		this.createTime = param;
	}

	public Date getLogTime() {
		return createTime;
	}

	public void setIp(String param) {
		this.ip = param;
	}

	public String getIp() {
		return ip;
	}

	public void setIsSuccess(Boolean param) {
		this.isSuccess = param;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public FwAuthcUser getFwAuthcUser() {
		return fwAuthcUser;
	}

	public void setFwAuthcUser(FwAuthcUser param) {
		this.fwAuthcUser = param;
	}

	public void setCategory(String param) {
		this.category = param;
	}

	public String getCategory() {
		return category;
	}

}