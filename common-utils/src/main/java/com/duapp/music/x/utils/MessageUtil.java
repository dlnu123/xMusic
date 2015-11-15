
package com.duapp.music.x.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.duapp.music.x.message.response.ImageMessage;
import com.duapp.music.x.message.response.MusicMessage;
import com.duapp.music.x.message.response.NewsMessage;
import com.duapp.music.x.message.response.TextMessage;
import com.duapp.music.x.message.response.VideoMessage;
import com.duapp.music.x.message.response.VoiceMessage;
import com.duapp.music.x.message.response.model.Article;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

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

	/**
	 * 文本消息对象转换成xml
	 * 
	 * @param textMessage
	 *            文本消息
	 * @return 响应xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {

		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * 图片消息对象转换成xml
	 * 
	 * @param imageMessage
	 *            图片消息
	 * @return 响应xml
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {

		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * 语音消息对象转换成xml
	 * 
	 * @param imageMessage
	 *            语音消息
	 * @return 响应xml
	 */
	public static String voiceMessageToXml(VoiceMessage voiceMessage) {

		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}

	/**
	 * 视频消息对象转换成xml
	 * 
	 * @param imageMessage
	 *            视频消息
	 * @return 响应xml
	 */
	public static String videoMessageToXml(VideoMessage videoMessage) {

		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}

	/**
	 * 音乐消息对象转换成xml
	 * 
	 * @param imageMessage
	 *            音乐消息
	 * @return 响应xml
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {

		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 图文消息对象转换成xml
	 * 
	 * @param imageMessage
	 *            图文消息
	 * @return 响应xml
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {

		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * 扩展xstream，使其支持 CDATA 块
	 */
	private static XStream xstream = new XStream(new XppDriver() {

		public HierarchicalStreamWriter createWriter(Writer out) {

			return new PrettyPrintWriter(out) {

				// 对所有xml 节点的转换都增加CDATA 标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {

					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {

					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}
