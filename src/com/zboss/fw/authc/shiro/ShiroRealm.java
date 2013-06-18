/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.zboss.fw.authc.shiro;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.zboss.fw.authc.model.FwAuthcPerm;
import com.zboss.fw.authc.model.FwAuthcRole;
import com.zboss.fw.authc.model.FwAuthcUser;
import com.zboss.fw.authc.service.FwAuthcUserService;
import com.zboss.fw.authc.service.ShiroService;

@Component
@DependsOn({ "IFwAuthcUserDao", "IFwAuthcPermDao" })
public class ShiroRealm extends AuthorizingRealm {
	protected static Logger _logger = Logger.getLogger(ShiroRealm.class);

	@Resource
	private FwAuthcUserService userService;

	@Resource
	private ShiroService shiroService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		FwAuthcUser user = userService.getByCode(token.getUsername());
		if (user == null)
			throw new UnknownAccountException();
		if (!user.getEnabled())
			throw new DisabledAccountException();
		return new SimpleAuthenticationInfo(user.getId(), user.getPassword().toCharArray(), getName());
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// FwAuthcUser user = userService.findOne(principals.getPrimaryPrincipal().toString());
		FwAuthcUser user = shiroService.getCurUser();
		SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
		for (FwAuthcRole role : user.getFwAuthcRoles()) {
			for (FwAuthcPerm perm : role.getFwAuthcPerms()) {
				authInfo.addStringPermission(perm.getUri() + ":" + perm.getAction());
			}
		}

		return authInfo;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		setCredentialsMatcher(new SimpleCredentialsMatcher());
	}

	// /**
	// * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	// */
	// public static class ShiroUser implements Serializable {
	//
	// private static final long serialVersionUID = 1071975543476572033L;
	//
	// public FwAuthcUser user;
	//
	// public ShiroUser(FwAuthcUser user) {
	// this.user = user;
	// }
	//
	// /**
	// * 本函数输出将作为默认的<shiro:principal/>输出.
	// */
	// @Override
	// public String toString() {
	// return user.getFwAuthcPerson().getName();
	// }
	//
	// /**
	// * 重载hashCode,只计算user的Id;
	// */
	// @Override
	// public int hashCode() {
	// return Objects.hashCode(user.getId());
	// }
	//
	// /**
	// * 重载equals,只计算user的Id;
	// */
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// ShiroUser other = (ShiroUser) obj;
	// if (user == null) {
	// if (other.user != null)
	// return false;
	// } else if (!user.getId().equals(other.user.getId()))
	// return false;
	// return true;
	// }
	// }
}
