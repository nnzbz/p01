package com.zboss.fw.authc.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zboss.fw.authc.dao.IFwAuthcPermDao;
import com.zboss.fw.authc.model.FwAuthcPerm;
import com.zboss.fw.core.service.BaseService;

@Service
public class FwAuthcPermService extends BaseService<FwAuthcPerm, String> implements IFwAuthcPermDao {

	protected static Logger _logger = Logger.getLogger(FwAuthcPermService.class);

	@Override
	@Resource(type = IFwAuthcPermDao.class)
	protected void setBaseDao(JpaRepository<FwAuthcPerm, String> dao) {
		this.dao = dao;
	}

}
