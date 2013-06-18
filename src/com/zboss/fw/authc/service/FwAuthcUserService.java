package com.zboss.fw.authc.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zboss.fw.authc.dao.IFwAuthcUserDao;
import com.zboss.fw.authc.model.FwAuthcUser;
import com.zboss.fw.core.service.BaseService;

@Service
public class FwAuthcUserService extends BaseService<FwAuthcUser, String> implements IFwAuthcUserDao {

	protected static Logger _logger = Logger.getLogger(FwAuthcUserService.class);

	@Override
	@Resource(type = IFwAuthcUserDao.class)
	protected void setBaseDao(JpaRepository<FwAuthcUser, String> dao) {
		this.dao = dao;
	}

	@Override
	public FwAuthcUser getByCode(String code) {
		return ((IFwAuthcUserDao) dao).getByCode(code);
	}

}
