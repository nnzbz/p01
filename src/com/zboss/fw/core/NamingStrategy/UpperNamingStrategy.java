package com.zboss.fw.core.NamingStrategy;

public class UpperNamingStrategy extends BaseNamingStrategy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5120239724870043147L;

	@Override
	protected String addUnderscores(String name) {
		return super.addUnderscores(name).toUpperCase();
	}

}
