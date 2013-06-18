package com.zboss.fw.core.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zboss.fw.core.service.FwHelloService;

@Controller
public class FwHelloController {
	protected static Logger _logger = Logger.getLogger(FwHelloController.class);

	@Resource
	private FwHelloService fwHelloService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String hello() {
		fwHelloService.test1();
		fwHelloService.test2();
		return "hello";
	}

}
