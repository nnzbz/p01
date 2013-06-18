package com.zboss.fw.authc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zboss.fw.authc.model.FwAuthcMenu;

public interface IFwAuthcMenuDao extends JpaRepository<FwAuthcMenu, String> {
	// public FwAuthcUser getByName(String name);

}
