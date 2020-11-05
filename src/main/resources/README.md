【告警中心平台】
核心功能时提供接口让其它系统调用，发送报警信息，如短信，邮件，电话等功能。

【注意事项1】
文中jdk环境是oracle jdk且版本为[1.8.0_171],采用其它版本可能会连不上ldap，需注意。
在配置文件中，链接LDAP的需要安装证书。


  ##LDAP证书安装的路径
  net_ssl_trustStore_path: C:\\Program Files\\Java\\jdk1.8.0_171\\jre\\lib\\security\\cacerts
  
证书的路径
【windows环境】
利用管理员命令启动cmd窗口执行
1。安装命令：

	keytool -import -trustcacerts -alias mykey -file C:\2020yanfeng\LDAPSoft\YFCO_BASE64.cer -keystore "C:\Program Files\Java\jdk1.8.0_171\jre\lib\security\cacerts"
2。输入密码：changeit
3。在java文件中配置代码

	System.setProperty("javax.net.ssl.trustStore", "C:\\Program Files\\Java\\jdk1.7.0_67\\jre\\lib\\security\\cacerts");
    System.setProperty("javax.net.ssl.keyStorePassword", "changeit");

【linux环境】
基本操作如上，在java环境中配置
安装命令：

	keytool -import -trustcacerts -alias mykey -file /home/ldap/YFCO_BASE64.cer -keystore "/home/ldap/jdk1.8.0_181/jre/lib/security/cacerts"     

java文件配置代码

	System.setProperty("javax.net.ssl.trustStore", "/home/ldap/jdk1.8.0_181/jre/lib/security/cacerts");
    System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
    
【注意事项2】
如果遇到发送邮件失败，可能要需要修改jdk中的配置文件：https://www.cnblogs.com/lonecloud/p/7484554.html    
    
    
    
    