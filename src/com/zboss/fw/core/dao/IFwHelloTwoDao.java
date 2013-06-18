package com.zboss.fw.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zboss.fw.core.model.FwHelloTwo;

public interface IFwHelloTwoDao extends JpaRepository<FwHelloTwo, String> {
}
