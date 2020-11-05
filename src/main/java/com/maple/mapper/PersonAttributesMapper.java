/*
 * @ProjectName: 编程学习
 * @Copyright:   2018 HangZhou Yiyuery Dev, Ltd. All Right Reserved.
 * @address:     http://xiazhaoyang.tech
 * @date:        2018/7/28 18:15
 * @email:       xiazhaoyang@live.com
 * @description: 本内容仅限于编程技术学习使用，转发请注明出处.
 */
package com.maple.mapper;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;

import com.maple.model.Person;

/**
 * <p>
 *
 * </p>
 *
 * @author xiachaoyang
 * @version V1.0
 * @date 2018年10月08日 17:17
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify By: {修改人} 2018年10月08日
 * @modify reason: {方法名}:{原因}
 * ...
 */
public class PersonAttributesMapper implements AttributesMapper<Person> {
    /**
     * Map Attributes to an object. The supplied attributes are the attributes
     * from a single SearchResult.
     *
     * @param attrs attributes from a SearchResult.
     * @return an object built from the attributes.
     * @throws NamingException if any error occurs mapping the attributes
     */
    @Override
    public Person mapFromAttributes(Attributes attrs) throws NamingException {
        Person person = new Person();
//        person.setSn((String)attrs.get("sn").get());
//        person.setCn((String)attrs.get("cn").get());
//        person.setSamaccountname((String)attrs.get("sAMAccountName").get());
//        person.setMail((String)attrs.get("mail").get());
//        person.setMobile((String)attrs.get("mobile").get());
        
        person.setSn(getString(attrs.get("sn")));
        person.setCn(getString(attrs.get("cn")));
        person.setSamaccountname(getString(attrs.get("sAMAccountName")));
        person.setMail(getString(attrs.get("mail")));
        person.setMobile(getString(attrs.get("mobile")));
        
        return person;
    }
    
    private String getString(Attribute att) {
        try {
            if (att == null) {
                return null;
            } else {
                return att.get().toString();
            }
        } catch (Exception ex) {
            return null;
        }
    }
}

