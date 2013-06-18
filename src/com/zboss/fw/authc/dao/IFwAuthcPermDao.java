package com.zboss.fw.authc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zboss.fw.authc.model.FwAuthcPerm;

public interface IFwAuthcPermDao extends JpaRepository<FwAuthcPerm, String> {

}
