package com.maple.service;

import java.util.List;

import org.springframework.ldap.core.LdapTemplate;

import com.maple.model.Person;

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
public interface IPersonRepo {

    List<String> getAllPersonNames();

    List<String> getAllPersonNamesWithTraditionalWay();

    List<Person> getAllPersons();

    Person findPersonWithDn(String dn);

    List<String> getPersonNamesByOrgId(String orgId);
    
    List<Person> getBySAMAccountName(String sAMAccountName);
}


