
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
 * ��Ϣ��������
 * 
 * @author qiuqiu3212
 */
public class MessageUtil {

	// �������������Map��
	private static Map<String, String> result = new HashMap<String, String>();

	/**
	 * �������ݽ���
	 * 
	 * @param req
	 *            ��������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXML(HttpServletRequest req) {

		SAXReader reader = new SAXReader();
		InputStream input = null;

		try {
			// ��request��ȡ������
			input = req.getInputStream();
			Document doc = reader.read(input);
			Element root = doc.getRootElement();
			if (root.elements().size() != 0) {
				_recursion(root.elements());
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
	 * �ݹ��ȡxml������(���������е�xml�в�������ͬ�ı�ǩ����˲�ȡ����ĵݹ����ʵ�֣���������ֵ�ø���)
	 * 
	 * @param elements
	 */
	@SuppressWarnings("unchecked")
	private static void _recursion(List<Element> elements) {

		for (Element e : elements) {
			if (e.elements().size() != 0) {
				_recursion(e.elements());
			} else {
				// �������ַ����Ľ����һ�µġ�Ψһ���������getTextTrim��getText�������߿ո�Ĵ���
				// e.getStringValue()��e.getTextTrim()��e.getText()
				result.put(e.getName(), e.getText());
			}
		}
	}

	/**
	 * �ı���Ϣ����ת����xml
	 * 
	 * @param textMessage
	 *            �ı���Ϣ
	 * @return ��Ӧxml
	 */
	public static String textMessageToXml(TextMessage textMessage) {

		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * ͼƬ��Ϣ����ת����xml
	 * 
	 * @param imageMessage
	 *            ͼƬ��Ϣ
	 * @return ��Ӧxml
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {

		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * ������Ϣ����ת����xml
	 * 
	 * @param imageMessage
	 *            ������Ϣ
	 * @return ��Ӧxml
	 */
	public static String voiceMessageToXml(VoiceMessage voiceMessage) {

		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}

	/**
	 * ��Ƶ��Ϣ����ת����xml
	 * 
	 * @param imageMessage
	 *            ��Ƶ��Ϣ
	 * @return ��Ӧxml
	 */
	public static String videoMessageToXml(VideoMessage videoMessage) {

		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}

	/**
	 * ������Ϣ����ת����xml
	 * 
	 * @param imageMessage
	 *            ������Ϣ
	 * @return ��Ӧxml
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {

		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * ͼ����Ϣ����ת����xml
	 * 
	 * @param imageMessage
	 *            ͼ����Ϣ
	 * @return ��Ӧxml
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {

		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * ��չxstream��ʹ��֧�� CDATA ��
	 */
	private static XStream xstream = new XStream(new XppDriver() {

		public HierarchicalStreamWriter createWriter(Writer out) {

			return new PrettyPrintWriter(out) {

				// ������xml �ڵ��ת��������CDATA ���
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
