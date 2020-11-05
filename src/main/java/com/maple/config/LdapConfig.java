package com.maple.config;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

import com.maple.common.Constant;
 
/**
 * 配置AD数据源
 */
@Configuration
@EnableLdapRepositories
public class LdapConfig {
	
    @Bean
    public LdapContextSource ldapContextSource() {
    	System.setProperty("javax.net.ssl.trustStore",
				"C:\\Program Files\\Java\\jdk1.8.0_171\\jre\\lib\\security\\cacerts");
		System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
		
        LdapContextSource source = new LdapContextSource();
        source.setUrl(Constant.LDAP_ARRAY_URL);
        source.setBase(Constant.LDAP_BASE);
        source.setUserDn(Constant.LDAP_USERNAME);
        source.setPassword(Constant.LDAP_PASSWORD);
        
        return source;
    }
 
    @Bean
    public LdapTemplate ldapTemplate() {
    	LdapTemplate ldapTemplate = new LdapTemplate(ldapContextSource());
    	ldapTemplate.setIgnorePartialResultException(true);
        return ldapTemplate;
    }
}