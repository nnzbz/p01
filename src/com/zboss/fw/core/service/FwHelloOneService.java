package com.zboss.fw.core.service;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zboss.fw.core.dao.IFwHelloOneDao;
import com.zboss.fw.core.model.FwHelloOne;

@Service
public class FwHelloOneService extends BaseService<FwHelloOne, Integer> {

	@Override
	@Resource(type = IFwHelloOneDao.class)
	protected void setBaseDao(JpaRepository<FwHelloOne, Integer> dao) {
		this.dao = dao;
	}

}
