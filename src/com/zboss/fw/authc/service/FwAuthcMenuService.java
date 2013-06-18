package com.zboss.fw.authc.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zboss.fw.authc.dao.IFwAuthcMenuDao;
import com.zboss.fw.authc.model.FwAuthcMenu;
import com.zboss.fw.core.service.BaseService;

@Service
public class FwAuthcMenuService extends BaseService<FwAuthcMenu, String> implements IFwAuthcMenuDao {

	protected static Logger _logger = Logger.getLogger(FwAuthcMenuService.class);

	@Override
	@Resource(type = IFwAuthcMenuDao.class)
	protected void setBaseDao(JpaRepository<FwAuthcMenu, String> dao) {
		this.dao = dao;
	}

	// @Override
	// public FwAuthcUser getByName(String name) {
	// return ((IFwAuthcUserDao) dao).getByName(name);
	// }

}
