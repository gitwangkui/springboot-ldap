/*
 * @ProjectName: 编程学习
 * @Copyright:   2018 HangZhou Yiyuery Dev, Ltd. All Right Reserved.
 * @address:     http://xiazhaoyang.tech
 * @date:        2018/7/28 18:15
 * @email:       xiazhaoyang@live.com
 * @description: 本内容仅限于编程技术学习使用，转发请注明出处.
 */
package com.maple.service.impl;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.stereotype.Service;

import com.maple.mapper.PersonAttributesMapper;
import com.maple.model.Person;
import com.maple.service.IPersonRepo;

/**
 * <p>
 *
 * </p>
 *
 * @author xiachaoyang
 * @version V1.0
 * @date 2018年10月08日 15:24
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify By: {修改人} 2018年10月08日
 * @modify reason: {方法名}:{原因}
 * ...
 */
@Service
public class PersonRepoImpl implements IPersonRepo {

	@Autowired
    private LdapTemplate ldapTemplate;

    /**
     * 查询部分字段集合
     * @return
     */
    @Override
    public List<String> getAllPersonNames() {
    	LdapQuery query = query().where("objectclass").is("person")
    			.and("sAMAccountName").is("uwank171");
    	List<Person> list = ldapTemplate.search(query, new PersonAttributesMapper());
    	list.forEach(pp -> System.out.println(pp.toString()));
    	return ldapTemplate.search(query, (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }

    /**
     * 传统LDAP查询方式 ok
     * @return
     */
    @Override
    public List<String> getAllPersonNamesWithTraditionalWay() {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldaps://172.28.15.109:636/DC=YFCO,DC=YANFENGCO,DC=COM");
        env.put(Context.SECURITY_PRINCIPAL, "Monitoring Service");
        env.put(Context.SECURITY_CREDENTIALS, "CAvbphNFFoAvNjKMPY1N");
        DirContext ctx;
        try {
            ctx = new InitialDirContext(env);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        List<String> list = new LinkedList<String>();
        NamingEnumeration results = null;
        try {
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
            results = ctx.search("", "(objectclass=person)", controls);
            while (results.hasMore()) {
                SearchResult searchResult = (SearchResult) results.next();
                Attributes attributes = searchResult.getAttributes();
                Attribute attr = attributes.get("cn");
                String cn = attr.get().toString();
                list.add(cn);
            }
        } catch (NameNotFoundException e) {
            // The base context was not found.
            // Just clean up and exit.
        } catch (NamingException e) {
            //throw new RuntimeException(e);
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (Exception e) {
                    // Never mind this.
                }
            }
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception e) {
                    // Never mind this.
                }
            }
        }
        return list;
    }

    /**
     * 查询对象映射集合 ok
     * @return
     */
    @Override
    public List<Person> getAllPersons() {
    	List<Person> list = ldapTemplate.search(query()
                .where("objectclass").is("person"), new PersonAttributesMapper());
    	System.err.println("===0==" + list.get(0).toString());
        return list;
    }

    /**
     * 根据DN查询指定人员信息
     * @param dn
     * @return
     */
    @Override
    public Person findPersonWithDn(String dn) {
        return ldapTemplate.lookup(dn, new PersonAttributesMapper());
    }

    /**
     * 组装查询语句
     * @param orgId
     * @return
     */
    @Override
    public  List<String> getPersonNamesByOrgId(String orgId) {
        LdapQuery query = query()
                .base("ou=person,dc=coreservice")
                .attributes("cn", "sn")
                .where("objectclass").is("person")
                .and("orgId").is(orgId);
        return ldapTemplate.search(query,(AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }
    
    
    /**
     * 新增测试
     */
    @Override
	public List<Person> getBySAMAccountName(String sAMAccountName){
    	String ssString = "\"sAMAccountName\", \"sn\",\"cn\",\"mobile\",\"mail\"";
		LdapQuery query = query()
				.attributes("sAMAccountName", "sn","cn","mobile","mail")
//				.attributes(ssString)
				.where("objectclass").is("person")
				.and("sAMAccountName").is(sAMAccountName)
				.and("cn").is("Wang,Kui (EXT,Shanghai,CN)");
//		Person findOne = ldapTemplate.findOne(query, Person.class);
//		System.out.println(findOne.toString());

		List<Person> list = ldapTemplate.search(query, new PersonAttributesMapper());
//		System.out.println(list.get(0).toString());
		list.forEach(p -> System.out.println("\n=2=="+p.toString()));
		
		return list;
    }

}


