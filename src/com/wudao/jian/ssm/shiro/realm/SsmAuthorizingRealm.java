package com.wudao.jian.ssm.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 登录验证及授权
 * @author JianWudao
 *
 */
public class SsmAuthorizingRealm extends AuthorizingRealm {
	/**
	 * 验证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		/*转换获取token*/
		UsernamePasswordToken userToken = (UsernamePasswordToken)token;
		String username = userToken.getUsername();
		Object credentials = "123";

		/*根据用户名和密码验证*/
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, credentials , getName());
		return info;
	}

	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> stringPermissions = new HashSet<>();

		/*将授权信息添加到授权变量中*/
		stringPermissions.add("user:add");
		stringPermissions.add("user:delete");
		info.setStringPermissions(stringPermissions );
		return info;
	}
}
