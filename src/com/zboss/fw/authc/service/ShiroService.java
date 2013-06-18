package com.zboss.fw.authc.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.zboss.fw.authc.constant.LoginResultType;
import com.zboss.fw.authc.model.FwAuthcPerm;
import com.zboss.fw.authc.model.FwAuthcUser;
import com.zboss.fw.core.util.OrderedProperties;

@Service
public class ShiroService {

	protected static Logger _logger = Logger.getLogger(ShiroService.class);

	@Resource
	private FwAuthcUserService userService;
	@Resource
	private FwAuthcPermService permService;

	@Resource
	private ShiroFilterFactoryBean shiroFilterFactoryBean;

	/**
	 * 读取自定义权限内容
	 * 
	 * @return
	 */
	public String loadFilterChainDefinitions() {

		Map<String, String> map = new LinkedHashMap<String, String>();
		addFixedFilter(map);
		addPermsFilter(map);
		map.put("/**", "authc");

		StringBuffer sb = new StringBuffer("");
		for (Map.Entry<String, String> item : map.entrySet()) {
			// 注意/r/n前不能有空格
			sb.append(item.getKey()).append("=").append(item.getValue()).append("\r\n");
		}
		return sb.toString();
	}

	/**
	 * 得到固定权限验证规则串
	 * 
	 * @param map
	 * 
	 * @return
	 */
	private void addFixedFilter(Map<String, String> map) {
		ClassPathResource cp = new ClassPathResource("config/shiro-filter-fix.properties");
		Properties properties = new OrderedProperties();
		try {
			properties.load(cp.getInputStream());
		} catch (IOException e) {
			_logger.error("load classpath:config/shiro-filter-fix.properties error!", e);
			throw new RuntimeException("load classpath:config/shiro-filter-fix.properties error!");
		}
		for (Map.Entry<Object, Object> item : properties.entrySet()) {
			map.put(item.getKey().toString().trim(), item.getValue().toString().trim());
		}
	}

	/**
	 * 生成restful风格功能权限规则
	 * 
	 * @param map
	 * 
	 * @return
	 */
	private void addPermsFilter(Map<String, String> map) {
		List<FwAuthcPerm> perms = permService.findAll();
		for (FwAuthcPerm perm : perms) {
			map.put(perm.getUri().trim(), ("rest[" + perm.getUri() + "]").trim());
		}
	}

	/**
	 * 更新自定义权限内容，此方法加同步锁
	 */
	public synchronized void updateFilterChains() {

		AbstractShiroFilter shiroFilter = null;
		try {
			shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
		} catch (Exception e) {
			_logger.error("getShiroFilter from shiroFilterFactoryBean error!", e);
			throw new RuntimeException("get ShiroFilter from shiroFilterFactoryBean error!");
		}

		PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
		DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

		// 清空老的权限控制
		manager.getFilterChains().clear();

		shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
		shiroFilterFactoryBean.setFilterChainDefinitions(loadFilterChainDefinitions());
		// 重新构建生成
		Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
		for (Map.Entry<String, String> entry : chains.entrySet()) {
			String url = entry.getKey();
			String chainDefinition = entry.getValue().trim().replace(" ", "");
			manager.createChain(url, chainDefinition);
		}
	}

	/**
	 * 登录校验
	 * 
	 * @param name
	 *            用户登录名
	 * @param password
	 *            登录密码（MD5加密后的字符串）
	 * @param vcode
	 *            验证码
	 * @return LoginResult 登录结果
	 * 
	 */
	public LoginResultType login(String name, char[] password, String vcode) {
		try {
			// if (!vcode.equals(SecurityUtils.getSubject().getSession().getAttribute("loginVCode")))
			// return LoginResultType.FAIL_VCODE;
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setUsername(name);
			token.setPassword(password);
			SecurityUtils.getSubject().login(token);
			return LoginResultType.登录成功;
		} catch (UnknownAccountException e) {
			_logger.error(e);
			return LoginResultType.登录名错误;
		} catch (IncorrectCredentialsException e) {
			_logger.error(e);
			return LoginResultType.密码错误;
		} catch (DisabledAccountException e) {
			_logger.error(e);
			return LoginResultType.账号被停用;
		} catch (AuthenticationException e) {
			_logger.error(e);
			return LoginResultType.登录失败;
		} catch (Exception e) {
			_logger.error(e);
			return LoginResultType.登录失败;
		}
	}

	/**
	 * 得到当前用户
	 * 
	 * @return
	 */
	public FwAuthcUser getCurUser() {
		return userService.findOne(SecurityUtils.getSubject().getPrincipal().toString());
	}

}
