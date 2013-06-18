package com.zboss.fw.authc.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zboss.fw.authc.model.FwAuthcMenu;
import com.zboss.fw.authc.model.FwAuthcUser;
import com.zboss.fw.authc.service.FwAuthcMenuService;
import com.zboss.fw.authc.service.FwAuthcUserService;
import com.zboss.fw.authc.service.ShiroService;

@Controller
@RequestMapping("authc")
public class FwAuthcController {
	protected static Logger _logger = Logger.getLogger(FwAuthcController.class);

	@Resource
	private FwAuthcUserService userService;
	@Resource
	private FwAuthcMenuService menuService;

	@Resource
	private ShiroService shiroService;

	@RequestMapping(value = "/login")
	String login() {
		return "fw/authc/Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	String login(String username, char[] password, String vcode) {
		return shiroService.login(username, password, vcode).toString();
	}

	@RequestMapping(value = "/menus")
	@ResponseBody
	List<FwAuthcMenu> menuList() {
		FwAuthcUser user = shiroService.getCurUser();
		if (user.getCode().equals("admin")) {
			List<FwAuthcMenu> list = menuService.findAll(new Sort("id"));
			return list;
		} else
			return null;
	}

	@RequestMapping(value = "/perms")
	String permsList() {
		return "fw/authc/PermList";
	}
}
