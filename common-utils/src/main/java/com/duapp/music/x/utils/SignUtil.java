package com.duapp.music.x.utils;

import java.util.Arrays;

/**
 * ��֤ǩ��(����΢�Ź���ƽ̨����)
 * 
 * @author qiuqiu3212
 */
public class SignUtil {

	// ��ӿ�������Ϣ�е� Token Ҫһ��
	private static final String token = "xMusic";

	/**
	 * ��֤ǩ��
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static Boolean sign(String signature, String timestamp, String nonce) {

		// ��token��timestamp��nonce�������������ֵ�������
		String[] array = new String[] { token, timestamp, nonce };
		Arrays.sort(array);

		// �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
		StringBuffer content = new StringBuffer();
		for (String temp : array) {
			content.append(temp);
		}
		String result = EncryptUtil.digest("SHA-1", content.toString());

		// �����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
		return result != null ? result.equalsIgnoreCase(signature) : false;
	}
}
