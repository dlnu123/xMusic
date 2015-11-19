
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
 * 发送HTTP请求，获得对应资源
 * 
 * @author qiuqiu3212
 */
public class HttpUtil {

	private static final Logger logger = Logger.getLogger(HttpUtil.class);

	public static String getResource(String requestURL, String params, String method) {

		// 与网络资源的连接
		HttpURLConnection conn = null;

		// 网络输出流
		OutputStream out = null;

		// 网络输入流
		BufferedReader reader = null;

		// 请求的结果数据
		StringBuffer result = null;

		try {
			if (StringUtils.isBlank(requestURL) || StringUtils.isBlank(method)) {
				return null;
			}

			// 创建URL对象，通过该对象获取与网络的连接
			URL url = new URL(requestURL);

			// 通过URL对象获取一个连接对象，通过该对象向网络目的地发送数据，以及从网络目的地获取资源
			conn = (HttpURLConnection) url.openConnection();

			// 网络中的有些接口使用了防盗链的技术，就是判断浏览器来源referer和cookie以及userAgent
			// 如果直接向接口发送POST请求的时候，会发生下面的错误
			// {"message":"illegal request!","code":403}
			// 因此为了避开防盗链，可以在HttpURLConnection中设置referer来伪造referer,轻松绕过这类防采集的网站
			// 其实原理非常简单就是设置下请求头,通过设置user-agent让服务器识别我们的身份
			// 1、通过设置useragent大部分的防采集的网站可以通过了
			// 2、第二种比较严格的防盗链，还需要设置请求头中的referer和cookie，网站就可以通过了
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon;)");
			conn.setRequestProperty("referer", "http://music.163.com");
			conn.setRequestProperty("cookie", "http://music.163.com");

			// 设置连接的读写权限、用户缓存机制、请求方法
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod(method);

			// 如果是POST请求，则将请求数据以POST的方式发送到指定的网络位置
			if ("POST".equalsIgnoreCase(method)) {
				out = conn.getOutputStream();
				out.write(params.getBytes("UTF-8"));
				out.flush();
			}

			// 获取请求数据
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
			// 关闭连接
			if (conn != null) {
				conn.disconnect();
				conn = null;
			}

			// 关闭输出流
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					conn = null;
				}
			}

			// 关闭输入流
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
