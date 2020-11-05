package com.maple.model;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

/**
 * @Author Generator-center
 * @Date 2020-10-16 08:56:51
 * @Description: 员工信息表
 */
@Entry(objectClasses = {"top","person", "organizationalPerson","user"})
public class Person {
	
	@Id
	private Name dn;
	
	@Attribute(name="sAMAccountName")
	private String samaccountname; // 主键
	
	@Attribute(name="sn")
	private String sn;
	
	/**
	 * 人员姓名
	 */
	@Attribute(name = "cn")
	private String cn;
	
	@Attribute(name="mobile")
	private String mobile;
		
	@Attribute(name="mail")
	private String mail;

	/**
	 * @return the samaccountname
	 */
	public String getSamaccountname() {
		return samaccountname;
	}

	/**
	 * @param samaccountname the samaccountname to set
	 */
	public void setSamaccountname(String samaccountname) {
		this.samaccountname = samaccountname;
	}

	/**
	 * @return the sn
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * @param sn the sn to set
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}

	/**
	 * @return the cn
	 */
	public String getCn() {
		return cn;
	}

	/**
	 * @param cn the cn to set
	 */
	public void setCn(String cn) {
		this.cn = cn;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the dn
	 */
	public Name getDn() {
		return dn;
	}

	/**
	 * @param dn the dn to set
	 */
	public void setDn(Name dn) {
		this.dn = dn;
	}

	@Override
	public String toString() {
		return "Person [samaccountname=" + samaccountname + ", sn=" + sn + ", cn=" + cn + ", mobile="
				+ mobile + ", mail=" + mail + "]";
	}


}
