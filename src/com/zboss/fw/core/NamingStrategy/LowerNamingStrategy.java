package com.zboss.fw.core.NamingStrategy;

public class LowerNamingStrategy extends BaseNamingStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8181536879386035623L;

	@Override
	protected String addUnderscores(String name) {
		return super.addUnderscores(name).toLowerCase();
	}

}
