/**
 * 
 */
package com.zboss.fw.core.util;

import java.util.UUID;

/**
 * @author 张柏子
 * @creation 2013-5-4
 */
public final class CommonUtil {

	public static String randomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
}
