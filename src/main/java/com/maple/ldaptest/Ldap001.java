/**   
 * @Description: 
 * @author: uwank171   
 * @date: 2020年10月15日 上午10:21:07 
 *
 */
package com.maple.ldaptest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.naming.Context;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.Control;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

/**
 * @Description:
 * @author: uwank171
 * @date: 2020年10月15日 上午10:21:07
 * 
 */
public class Ldap001 {

	static String URL = "ldaps://172.28.15.109:636/";
	static String BASEDN = "DC=YFCO,DC=YANFENGCO,DC=COM"; // 根据自己情况进行修改
	static String ROOT = "Monitoring Service"; // 根，根据自己情况修改
	static String PASSWORD = "CAvbphNFFoAvNjKMPY1N";
	static String FACTORY = "com.sun.jndi.ldap.LdapCtxFactory";
	static LdapContext ctx = null;
	static Control[] connCtls = null;

	// 连接
	public static LdapContext getLdapCtx() {

		System.setProperty("javax.net.ssl.trustStore",
				"C:\\Program Files\\Java\\jdk1.8.0_171\\jre\\lib\\security\\cacerts");
		System.setProperty("javax.net.ssl.keyStorePassword", "changeit");

		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, FACTORY);
		env.put(Context.PROVIDER_URL, URL + BASEDN);
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, ROOT); // 管理员
		env.put(Context.SECURITY_CREDENTIALS, PASSWORD); // 管理员密码

		try {
			ctx = new InitialLdapContext(env, connCtls);
			System.out.println("========认证成功===========");

		} catch (javax.naming.AuthenticationException e) {
			System.out.println("认证失败：");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("认证出错：");
			e.printStackTrace();
		}

		return ctx;
	}

	// 关闭资源
	public static void closeLdapCtx(LdapContext ctx) {
		if (ctx != null) {
			try {
				ctx.close();
				System.out.println("== 已关闭资源==");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	}

	// 获取用户
	public static void getLdapUsers2() {
		Map<String,String> map = new HashMap<String, String>();
		try {
			if(ctx != null){
//				NamingEnumeration<NameClassPair> list = ctx.list("dc=sys,dc=com");
				NamingEnumeration<NameClassPair> list = ctx.list("DC=YFCO,DC=YANFENGCO,DC=COM");
				while(list.hasMore()){
					NameClassPair ncp = list.next();
					String cn = ncp.getName();
					if(cn.indexOf("=") != -1){
						int index = cn.indexOf("=");
						cn = cn.substring(index + 1,cn.length());
						map.put(cn, ncp.getNameInNamespace());
					}
				}
			}
		} catch (NamingException e) {
			e.printStackTrace();
			return;
		}
		
		Iterator<Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			System.out.println("Key:"+entry.getKey());
			System.out.println("Value:"+entry.getValue());
		}

	}
	
	public static void getLdapUsers() {
		List<Map<String, Object>> lm = new ArrayList<Map<String, Object>>();
		try {
			// 过滤条件
//			String filter = "(&(objectClass=*)(uid=*))";
			String filter = "(&(objectClass=User)(uid=*))";
			String[] attrPersonArray = { "uid", "userPassword", "displayName", "cn", "sn", "mail", "description" };
			SearchControls searchControls = new SearchControls();// 搜索控件
			searchControls.setSearchScope(2);// 搜索范围
			searchControls.setReturningAttributes(attrPersonArray);
			// 1.要搜索的上下文或对象的名称；2.过滤条件，可为null，默认搜索所有信息；3.搜索控件，可为null，使用默认的搜索控件
			String ssString = "dc=yanfengco,dc=com";
			NamingEnumeration<SearchResult> answer = ctx.search(ssString, filter.toString(), searchControls);
			while (answer.hasMore()) {
				SearchResult result = (SearchResult) answer.next();
				NamingEnumeration<? extends Attribute> attrs = result.getAttributes().getAll();
				Map<String, Object> map = new HashMap<String, Object>();

				while (attrs.hasMore()) {
					Attribute attr = (Attribute) attrs.next();
					if ("userPassword".equals(attr.getID())) {
						Object value = attr.get();
						map.put(attr.getID(), new String((byte[]) value));
					} else {
						map.put(attr.getID(), attr.get());
					}
				}
				if (map != null) {
					System.out.println(map);
					lm.add(map);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) throws Exception {
		LdapContext ctx = getLdapCtx();
//		getLdapUsers();
		getLdapUsers2();
		closeLdapCtx(ctx);
	}

}
