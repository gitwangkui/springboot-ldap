/*
 * @ProjectName: 编程学习
 * @Copyright:   2018 HangZhou Yiyuery Dev, Ltd. All Right Reserved.
 * @address:     http://xiazhaoyang.tech
 * @date:        2018/7/28 18:15
 * @email:       xiazhaoyang@live.com
 * @description: 本内容仅限于编程技术学习使用，转发请注明出处.
 */
package com.maple.test;


import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.maple.LdapApp;
import com.maple.model.Person;
import com.maple.service.impl.PersonRepoImpl;

/**
 * <p>
 *
 * </p>
 *
 * @author xiachaoyang
 * @version V1.0
 * @date 2018年10月08日 11:47
 * @modificationHistory=========================逻辑或功能性重大变更记录
 * @modify By: {修改人} 2018年10月08日
 * @modify reason: {方法名}:{原因}
 * ...
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={LdapApp.class})
public class LdapTest {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Autowired
    private  PersonRepoImpl personRepo;

    @Before
    public void init(){
    	System.setProperty("javax.net.ssl.trustStore","C:\\Program Files\\Java\\jdk1.8.0_171\\jre\\lib\\security\\cacerts");
		System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
    }
    
    
    @Test
    public void ldapRestTestPart2(){
    	//1.传统查询方式
        personRepo.getAllPersonNamesWithTraditionalWay().forEach(System.out::println);
    	
    }
    
    
    
    
    
    
    
    

//    //@Test
//    public void ldapRestTestPart1(){
//        // 查询所有人员名称
//        personRepo.getAllPersonNames().forEach(p-> System.out.println(p));
//        //荣禧
//        //荣耀
//        //feng_p1
//        //fengzi_0917_1
//        //....
//        // 查询所有人员集合（指定字段映射）
//    	System.out.println("\n==== " + personRepo);
//        List<Person> allPersons = personRepo.getAllPersons();
//        if (allPersons != null) {
//        	allPersons.forEach(p-> System.out.println(p.toString()));
//		} else {
//			System.out.println("\n== allPersons is null");
//		}
//        
//        //Person(personId=null, personName=fengzi_0917_7, orgId=14ed2744-fbd4-4868-8ebc-6b0b94d5ae60, sex=null, mobile=null, email=null, jobNo=null, studentId=null, certType=null, certNo=null, createTime=null, updateTime=null, status=null, disOrder=null, company=null)
//        //Person(personId=null, personName=fengzi_0917_104, orgId=14ed2744-fbd4-4868-8ebc-6b0b94d5ae60, sex=null, mobile=null, email=null, jobNo=null, studentId=null, certType=null, certNo=null, createTime=null, updateTime=null, status=null, disOrder=null, company=null)
//        
//
//        //根据dn查询
//        System.out.println(personRepo.findPersonWithDn("ou=person,dc=coreservice,dc=platform,dc=xxx,dc=com").toString());
//
//        //根据组织ID查询人员
//        personRepo.getPersonNamesByOrgId("14ed2744-fbd4-4868-8ebc-6b0b94d5ae60").forEach(System.out::println);
//        //feng_0925_4687
//        //feng_0925_4693
//        //...
//
//        //传统查询方式
//        personRepo.getAllPersonNamesWithTraditionalWay().forEach(System.out::println);
//        //荣禧
//        //荣福
//        //feng_p1
//        //fengzi_0917_1
//        //....
//
//    }
}

