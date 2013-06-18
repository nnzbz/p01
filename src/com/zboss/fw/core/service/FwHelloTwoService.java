package com.zboss.fw.core.service;

import javax.annotation.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zboss.fw.core.dao.IFwHelloOneDao;
import com.zboss.fw.core.model.FwHelloTwo;

@Service
public class FwHelloTwoService extends BaseService<FwHelloTwo, Integer> {

	@Override
	@Resource(type = IFwHelloOneDao.class)
	protected void setBaseDao(JpaRepository<FwHelloTwo, Integer> dao) {
		this.dao = dao;
	}

}
