
package com.duapp.music.x.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * 加密工具类
 * 
 * @author qiuqiu3212
 */
public class EncryptUtil {

	/**
	 * 加密算法
	 * 
	 * @param algorithm
	 *            加密算法
	 * @param orgi
	 *            需要加密的字符串
	 * @return 加密之后的字符串
	 */
	public static String digest(String algorithm, String orgi) {

		MessageDigest md = null;
		String dest = null;
		try {
			md = MessageDigest.getInstance(algorithm);
			md.reset();
			md.update(orgi.getBytes("UTF-8"));
			dest = DatatypeConverter.printHexBinary(md.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			md.reset();
		}
		return dest;
	}
}
