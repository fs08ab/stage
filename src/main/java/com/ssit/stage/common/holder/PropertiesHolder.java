package com.ssit.stage.common.holder;

import com.ssit.stage.common.constant.ConstantValue;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 参数工具类：在服务启动时读取配置的参数，方便程序中使用
 *
 * @author Fs
 * @since 2017/3/6 18:45
 */
@Component
public class PropertiesHolder {

	// 访问日志配置
	/**
	 * 是否开启访问日志的开关 on：开启；off：关闭
	 */
	public static boolean ACCESS_LOG_SWITCH;

	public static final Set<String> ACCESS_LOG_EXCLUDE_URLS = new HashSet<>();

	public static final Set<String> ACCESS_LOG_ENCRYPT_PARAMS = new HashSet<>();

	// 跨域配置
	/**
	 * 指定可信任的域名来接收响应信息*表示所有
	 */
	public static String ACCESS_CONTROL_ALLOW_ORIGIN;
	/**
	 * 响应方法类型
	 */
	public static String ACCESS_CONTROL_ALLOW_METHODS;
	/**
	 * 在这个时间范围内，所有同类型的请求都将不再发送预检请求而是直接使用此次返回的头作为判断依据，非常有用，大幅优化请求次数
	 */
	public static String ACCESS_CONTROL_MAX_AGE;
	/**
	 * 响应头设置
	 */
	public static String ACCESS_CONTROL_ALLOW_HEADERS;
	/**
	 * 是否允许cookie随请求发送
	 */
	public static String ACCESS_CONTROL_ALLOW_CREDENTIALS;

	// 其他配置
	/**
	 * 默认时间格式
	 */
	public static String DEFAULT_TIME_PATTERN;

	/**
	 * 默认文件保存位置
	 */
	public static String DEFAULT_FILE_DIRECTORY;

	/**
	 * 驿站文件保存位置
	 */
	public static String FILE_DIRECTORY_STAGE;

	/**
	 * 活动文件保存位置
	 */
	public static String FILE_DIRECTORY_ACTIVITY;

	/**
	 * 系统访问路径
	 */
	public static String SERVER_URL;

	@Value("#{properties['access_log_switch']}")
	public void setAccessLogSwitch(String accessLogSwitch) {
		ACCESS_LOG_SWITCH = StringUtils.equalsIgnoreCase("on", accessLogSwitch);
	}

	@Value("#{properties['access_log_exclude_urls']}")
	public void setAccessLogExcludeURLs(String accessLogExcludeURLs) {
		if (StringUtils.isNotBlank(accessLogExcludeURLs)) {
			ACCESS_LOG_EXCLUDE_URLS.addAll(Arrays.asList(accessLogExcludeURLs.split(ConstantValue.STRING_SEPARATOR)));
		}
	}

	@Value("#{properties['access_log_encrypt_params']}")
	public void setAccessLogEncryptParams(String accessLogEncryptParams) {
		if (StringUtils.isNotBlank(accessLogEncryptParams)) {
			ACCESS_LOG_ENCRYPT_PARAMS.addAll(Arrays.asList(accessLogEncryptParams.split(ConstantValue.STRING_SEPARATOR)));
		}
	}

	@Value("#{properties['access_control_allow_origin']}")
	public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
		ACCESS_CONTROL_ALLOW_ORIGIN = accessControlAllowOrigin;
	}

	@Value("#{properties['access_control_allow_methods']}")
	public static void setAccessControlAllowMethods(String accessControlAllowMethods) {
		ACCESS_CONTROL_ALLOW_METHODS = accessControlAllowMethods;
	}

	@Value("#{properties['access_control_max_age']}")
	public void setAccessControlMaxAge(String accessControlMaxAge) {
		ACCESS_CONTROL_MAX_AGE = accessControlMaxAge;
	}

	@Value("#{properties['access_control_allow_headers']}")
	public void setAccessControlAllowHeaders(String accessControlAllowHeaders) {
		ACCESS_CONTROL_ALLOW_HEADERS = accessControlAllowHeaders;
	}

	@Value("#{properties['access_control_allow_credentials']}")
	public void setAccessControlAllowCredentials(String accessControlAllowCredentials) {
		ACCESS_CONTROL_ALLOW_CREDENTIALS = accessControlAllowCredentials;
	}

	@Value("#{properties['default_time_pattern']}")
	public void setDefaultTimePattern(String defaultTimePattern) {
		DEFAULT_TIME_PATTERN = defaultTimePattern;
	}

	@Value("#{properties['default_file_directory']}")
	public void setDefaultFileDirectory(String defaultFileDirectory) {
		DEFAULT_FILE_DIRECTORY = defaultFileDirectory;
	}

	@Value("#{properties['file_directory_stage']}")
	public void setFileDirectoryStage(String fileDirectoryStage) {
		FILE_DIRECTORY_STAGE = fileDirectoryStage;
	}

	@Value("#{properties['file_directory_activity']}")
	public void setFileDirectoryActivity(String fileDirectoryActivity) {
		FILE_DIRECTORY_ACTIVITY = fileDirectoryActivity;
	}

	@Value("#{properties['server_url']}")
	public void setServerUrl(String serverUrl) {
		SERVER_URL = serverUrl;
	}
}
