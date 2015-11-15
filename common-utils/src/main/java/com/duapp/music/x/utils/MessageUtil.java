
package com.duapp.music.x.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 消息处理工具类
 * 
 * @author qiuqiu3212
 */
public class MessageUtil {

	// 请求文本消息
	private static final String REQ_MESSAGE_TEXT = "text";

	// 请求图片消息
	private static final String REQ_MESSAGE_IMAGE = "image";

	// 请求语音消息
	private static final String REQ_MESSAGE_VOICE = "voice";

	// 请求视频消息
	private static final String REQ_MESSAGE_VIDEO = "video";

	// 请求小视频消息
	private static final String REQ_MESSAGE_SHORTVIDEO = "shortvideo";

	// 请求地理位置消息
	private static final String REQ_MESSAGE_LOCATION = "location";

	// 请求链接消息
	private static final String REQ_MESSAGE_LINK = "link";

	// 响应文本消息
	private static final String RES_MESSAGE_TEXT = "text";

	// 响应图片消息
	private static final String RES_MESSAGE_IMAGE = "image";

	// 响应语音消息
	private static final String RES_MESSAGE_VOICE = "voice";

	// 响应视频消息
	private static final String RES_MESSAGE_VIDEO = "video";

	// 响应音乐消息
	private static final String RES_MESSAGE_MUSIC = "music";

	// 响应图文消息
	private static final String RES_MESSAGE_NEWS = "news";

	/**
	 * 请求数据解析
	 * 
	 * @param req
	 *            请求数据
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXML(HttpServletRequest req) {

		// 将解析结果放在Map中
		Map<String, String> result = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		InputStream input = null;

		try {
			// 从request获取输入流
			input = req.getInputStream();
			Document doc = reader.read(input);
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			for (Element e : elements) {
				// 下面三种方法的结果是一致的。唯一的区别就是getTextTrim、getText对于两边空格的处理
				// e.getStringValue()、e.getTextTrim()、e.getText()
				result.put(e.getName(), e.getText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
					input = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}
}
