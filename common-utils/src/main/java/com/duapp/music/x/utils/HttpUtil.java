
package com.duapp.music.x.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * ����HTTP���󣬻�ö�Ӧ��Դ
 * 
 * @author qiuqiu3212
 */
public class HttpUtil {

	private static final Logger logger = Logger.getLogger(HttpUtil.class);

	public static String getResource(String requestURL, String params, String method) {

		// ��������Դ������
		HttpURLConnection conn = null;

		// ���������
		OutputStream out = null;

		// ����������
		BufferedReader reader = null;

		// ����Ľ������
		StringBuffer result = null;

		try {
			if (StringUtils.isBlank(requestURL) || StringUtils.isBlank(method)) {
				return null;
			}

			// ����URL����ͨ���ö����ȡ�����������
			URL url = new URL(requestURL);

			// ͨ��URL�����ȡһ�����Ӷ���ͨ���ö���������Ŀ�ĵط������ݣ��Լ�������Ŀ�ĵػ�ȡ��Դ
			conn = (HttpURLConnection) url.openConnection();

			// �����е���Щ�ӿ�ʹ���˷������ļ����������ж��������Դreferer��cookie�Լ�userAgent
			// ���ֱ����ӿڷ���POST�����ʱ�򣬻ᷢ������Ĵ���
			// {"message":"illegal request!","code":403}
			// ���Ϊ�˱ܿ���������������HttpURLConnection������referer��α��referer,�����ƹ�������ɼ�����վ
			// ��ʵԭ��ǳ��򵥾�������������ͷ,ͨ������user-agent�÷�����ʶ�����ǵ����
			// 1��ͨ������useragent�󲿷ֵķ��ɼ�����վ����ͨ����
			// 2���ڶ��ֱȽ��ϸ�ķ�����������Ҫ��������ͷ�е�referer��cookie����վ�Ϳ���ͨ����
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon;)");
			conn.setRequestProperty("referer", "http://music.163.com");
			conn.setRequestProperty("cookie", "http://music.163.com");

			// �������ӵĶ�дȨ�ޡ��û�������ơ����󷽷�
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);

			// �����POST����������������POST�ķ�ʽ���͵�ָ��������λ��
			if ("POST".equalsIgnoreCase(method)) {
				out = conn.getOutputStream();
				out.write(params.getBytes("UTF-8"));
				out.flush();
			}

			// ��ȡ��������
			result = new StringBuffer();
			String temp = null;
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			while ((temp = reader.readLine()) != null) {
				result.append(temp);
			}
		} catch (MalformedURLException e) {
			logger.error("No protocol is specified, or an unknown protocol is found, or requestURL is null.");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			logger.error("The Character Encoding is not supported.");
			e.printStackTrace();
		} catch (IOException e) {
			logger.error("IO stream is wrong.");
			e.printStackTrace();
		} finally {
			// �ر�����
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}

			// �ر������
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					conn = null;
				}
			}

			// �ر�������
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					reader = null;
				}
			}
		}
		return result.toString();
	}
}
