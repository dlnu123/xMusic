package com.duapp.music.x.utils;

import java.util.Arrays;

/**
 * 验证签名(接入微信公众平台开发)
 * 
 * @author qiuqiu3212
 */
public class SignUtil {

	// 与接口配置信息中的 Token 要一致
	private static final String token = "xMusic";

	/**
	 * 验证签名
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static Boolean sign(String signature, String timestamp, String nonce) {

		// 将token、timestamp、nonce三个参数进行字典序排序
		String[] array = new String[] { token, timestamp, nonce };
		Arrays.sort(array);

		// 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer content = new StringBuffer();
		for (String temp : array) {
			content.append(temp);
		}
		String result = EncryptUtil.digest("SHA-1", content.toString());

		// 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		return result != null ? result.equalsIgnoreCase(signature) : false;
	}
}
