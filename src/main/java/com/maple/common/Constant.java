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

	// sendMessage
	public static String defaultLanguage = "en-US";
	public static String sendMessage_SMS = "SMS";
	public static String sendMessage_Email = "Email";
	public static String sendMessage_Phone = "Phone";

	// 发送消息的唯一id
	public static final String MESSAGE_ID = "messageId";
	public static final String RECIPENT_ID = "recipentId";
	public static final String PHONE_ID = "phoneId";
	public static final String EMAIL_ID = "emialId";
	public static final String SMS_ID = "SMSId";
	
	public static final String YF_AMP_LOGIN = "yf_apm_login";
	public static final String YF_AMP_LOGIN_NAME = "yanfengops";
	public static final String YF_AMP_LOGIN_PASS = "yanfengops1";
	// 每隔6小时失效一次，重新登录
	public static final Long YF_AMP_LOGIN_TIME = 1000L * 60 * 60 * 6;
	
	
	
	

	// 字符 0-10
	public static final String STRING_EMPTY = "";
	public static final String STRING_0 = "0";
	public static final String STRING_1 = "1";
	public static final String STRING_2 = "2";
	public static final String STRING_3 = "3";
	public static final String STRING_4 = "4";
	public static final String STRING_5 = "5";
	public static final String STRING_6 = "6";
	public static final String STRING_7 = "7";
	public static final String STRING_8 = "8";
	public static final String STRING_9 = "9";
	public static final String STRING_10 = "10";
	
	

	// 返回消息
	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";
	// 操作提示语
	public static final String OPERATION_SUCCESS = "操作成功";
	public static final String OPERATION_FAILED = "操作失败";
	public static final String EMPTY_RECORD = "没有匹配的数据！";
	public static final String RECORD_NOT_FOUND = "未查询到匹配记录";
	public static final String UNKNOW_VALIDATE_ERROR = "未知校验错误信息！";
	public static final String SYSTEM_ERROR = "系统错误";
	public static final String ERROR_DATA_ACCESS = "数据访问错误";
	public static final String RECIPENTNAME_NOT_NULL = "接收者用户信息（GID）不能为空！";
	public static final String RECIPENTNAME_NOT_EXIST = "接收者用户信息（GID）不存在！";
	public static final String SENDTNAME_NOT_NULL = "发送者用户信息（GID）不能为空！";
	public static final String SENDTNAME_NOT_EXIST = "发送者用户信息（GID）不存在！";
	
	
	
	// LDAP
	// 定制返回属性
	public static final String RETURNED_ATTS[] = {"sAMAccountName", "employeeID", "name", "sn", "givenName",
			"mobile", "telephoneNumber", "ipPhone", "mail", "department", "title", "c" }; 
	
	
	// 国际手机号-国家编码
	public static final String COUTRY_CODE_CN = "86";
	
	
	
	
	// 
	public static final String NOT_EMPTY = "NotEmpty";
    public static final String NOT_NULL = "NotNull";
    public static final String NOT_BLANK = "NotBlank";
    public static final String LENGTH = "Length";
    public static final String PATTERN = "Pattern";
    public static final String DECIMALMIN = "DecimalMin";
    public static final String SIZE = "Size";
    public static final String MIN = "Min";
    public static final String MAX = "Max";
    public static final String DIGITS = "Digits";
    
	
	//LDAP config
    public static final String LDAP_ARRAY_URL = "ldaps://172.28.15.109:636/";
    public static final String LDAP_BASE = "DC=YFCO,DC=YANFENGCO,DC=COM";
    public static final String LDAP_USERNAME = "Monitoring Service";
    public static final String LDAP_PASSWORD = "CAvbphNFFoAvNjKMPY1N";
	
	
	
	

}
