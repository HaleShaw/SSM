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
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

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
		Object credentials = "d7647dfdcc6ec4f7e4e340381d40fc76";

		/*设置加密盐值*/
		ByteSource credentialsSalt=ByteSource.Util.bytes("xiao");

		/*根据用户名、密码验证和盐值*/
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, credentials , credentialsSalt, getName());
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

	/**
	 * 用于测试生成加密后的密码
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleHash sHash = new SimpleHash("MD5", "123", ByteSource.Util.bytes("xiao"),1000);
		System.out.println(sHash);
	}
}
