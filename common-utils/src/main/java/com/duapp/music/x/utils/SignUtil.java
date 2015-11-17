
package com.duapp.music.x.utils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

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
	 *            ΢�ż���ǩ��
	 * @param timestamp
	 *            ʱ���
	 * @param nonce
	 *            �����
	 * @return ��֤ǩ���Ƿ�ɹ�
	 */
	public static Boolean sign(String signature, String timestamp, String nonce) {

		// �ж�token��timestamp��nonce�Ƿ�Ϊ�գ�Ϊ������֤ǩ��ʧ��
		if (StringUtils.isBlank(signature)) {
			return false;
		}
		if (StringUtils.isBlank(timestamp)) {
			return false;
		}
		if (StringUtils.isBlank(nonce)) {
			return false;
		}

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
