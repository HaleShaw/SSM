package com.wudao.jian.ssm.shiro.realm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * FilterChainDefinitionMap工厂类
 * 用于获取FilterChainDefinitionMap
 * @author JianWudao
 */
public class FilterChainDefinitionMapFactory {
	/**
	 * 获取FilterChainDefinitionMap
	 * @return
	 */
	public Map<String, String> getFilterChainDefinitionMap() {
		/*须用LinkedHashMap,权限须有序*/
		Map<String, String> map = new LinkedHashMap<>();
		map.put("/login", "anon");
		map.put("/login.jsp", "anon");
		map.put("/authorized.jsp", "perms[user:add]");
		map.put("/test01.jsp", "perms[user:delete]");
		map.put("/**", "authc");
		return map;
	}
}
