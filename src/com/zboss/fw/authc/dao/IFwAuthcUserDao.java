package com.zboss.fw.authc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zboss.fw.authc.model.FwAuthcUser;

public interface IFwAuthcUserDao extends JpaRepository<FwAuthcUser, String> {
	public FwAuthcUser getByCode(String code);
}
