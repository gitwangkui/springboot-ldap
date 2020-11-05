/*
 * @ProjectName: 编程学习
 * @Copyright:   2018 HangZhou Yiyuery Dev, Ltd. All Right Reserved.
 * @address:     http://xiazhaoyang.tech
 * @date:        2018/7/28 18:15
 * @email:       xiazhaoyang@live.com
 * @description: 本内容仅限于编程技术学习使用，转发请注明出处.
 */
package com.maple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
 * @modify reason: {方法名}:{原因} ...
 */
@RestController
public class LdapTestController {

	@Autowired
	private LdapTemplate ldapTemplate;

	@Autowired
	private PersonRepoImpl personRepo;

	@GetMapping("/getAllPersonNames")
	public void getAllPersonNames() {
		System.out.println("\n ===查询所有人员名称getAllPersonNames:");
		personRepo.getAllPersonNames().forEach(p -> System.out.println(p));
	}

	@GetMapping("/getAllPersons")
	public void getAllPersons() {
		System.out.println("\n ===查询所有人员集合（指定字段映射）getAllPersons:");
		personRepo.getAllPersons().forEach(p -> System.out.println(p.toString()));
	}

	// 根据dn查询
	@GetMapping("/findPersonWithDn")
	public void findPersonWithDn() {
		System.out.println("\n ===根据dn查询findPersonWithDn:");
		String string = personRepo.findPersonWithDn("ou=person,dc=coreservice,dc=platform,dc=xxx,dc=com").toString();
		System.out.println(string);
	}

	@GetMapping("/getLdapWay")
	public void getLdapWay() {
		System.out.println("\n ===传统方式查询getLdapWay:");
		List<String> list = personRepo.getAllPersonNamesWithTraditionalWay();
		if (list.isEmpty()) {
			System.out.println("\n list  is  null");
		} else {
			list.forEach(System.out::println);
		}
	}

	@GetMapping("/getBySAMAccountName/{sAMAccountName}")
	public String getBySAMAccountName(@PathVariable("sAMAccountName") String sAMAccountName) {
		System.out.println("\n ===查询人员信息getBySAMAccountName:");
		List<Person> list = personRepo.getBySAMAccountName(sAMAccountName);
		return list.size() > 0 ? list.get(0).toString() : "无结果数据！";
	}

	public void ldapRestTestPart1() {
		// 查询所有人员名称
		// personRepo.getAllPersonNames().forEach(p-> System.out.println(p));
		// 荣禧
		// 荣耀
		// feng_p1
		// fengzi_0917_1
		// ....
		// 查询所有人员集合（指定字段映射）
		// personRepo.getAllPersons().forEach(p-> System.out.println(p.toString()));
		// Person(personId=null, personName=fengzi_0917_7,
		// orgId=14ed2744-fbd4-4868-8ebc-6b0b94d5ae60, sex=null, mobile=null,
		// email=null, jobNo=null, studentId=null, certType=null, certNo=null,
		// createTime=null, updateTime=null, status=null, disOrder=null, company=null)
		// Person(personId=null, personName=fengzi_0917_104,
		// orgId=14ed2744-fbd4-4868-8ebc-6b0b94d5ae60, sex=null, mobile=null,
		// email=null, jobNo=null, studentId=null, certType=null, certNo=null,
		// createTime=null, updateTime=null, status=null, disOrder=null, company=null)

		// 根据dn查询
		System.out
				.println(personRepo.findPersonWithDn("ou=person,dc=coreservice,dc=platform,dc=xxx,dc=com").toString());

		// 根据组织ID查询人员
		// personRepo.getPersonNamesByOrgId("14ed2744-fbd4-4868-8ebc-6b0b94d5ae60").forEach(System.out::println);
		// feng_0925_4687
		// feng_0925_4693
		// ...

		// 传统查询方式
		// personRepo.getAllPersonNamesWithTraditionalWay().forEach(System.out::println);
		// 荣禧
		// 荣福
		// feng_p1
		// fengzi_0917_1
		// ....

	}
}
