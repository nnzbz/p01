package com.zboss.p01.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class P01DesktopController {
	protected static Logger _logger = Logger.getLogger(P01DesktopController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	String desktop() {
		return "p01/desktop/TreeDesktop";
	}

}
