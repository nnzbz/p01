package com.zboss.fw.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zboss.fw.core.model.FwHelloOne;

public interface IFwHelloOneDao extends JpaRepository<FwHelloOne, String> {
}
