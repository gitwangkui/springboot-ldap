/**   
 * @Description: 
 * @author: uwank171   
 * @date: 2020年10月12日 上午8:25:23 
 *
 */
package com.maple.common;

/**
 * @Description: 常量
 * @author: uwank171
 * @date: 2020年10月12日 上午8:25:23
 * 
 */
public class Constant {

	// LDAP
	// 定制返回属性
	public static final String RETURNED_ATTS[] = {"sAMAccountName", "employeeID", "name", "sn", "givenName",
			"mobile", "telephoneNumber", "ipPhone", "mail", "department", "title", "c" }; 
	
	//LDAP config
    public static final String LDAP_ARRAY_URL = "ldaps://172.28.15.109:636/";
    public static final String LDAP_BASE = "DC=YFCO,DC=YANFENGCO,DC=COM";
    public static final String LDAP_USERNAME = "Monitoring Service";
    public static final String LDAP_PASSWORD = "CAvbphNFFoAvNjKMPY1N";
	
}
