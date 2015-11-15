
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
 * ��Ϣ��������
 * 
 * @author qiuqiu3212
 */
public class MessageUtil {

	// �����ı���Ϣ
	private static final String REQ_MESSAGE_TEXT = "text";

	// ����ͼƬ��Ϣ
	private static final String REQ_MESSAGE_IMAGE = "image";

	// ����������Ϣ
	private static final String REQ_MESSAGE_VOICE = "voice";

	// ������Ƶ��Ϣ
	private static final String REQ_MESSAGE_VIDEO = "video";

	// ����С��Ƶ��Ϣ
	private static final String REQ_MESSAGE_SHORTVIDEO = "shortvideo";

	// �������λ����Ϣ
	private static final String REQ_MESSAGE_LOCATION = "location";

	// ����������Ϣ
	private static final String REQ_MESSAGE_LINK = "link";

	// ��Ӧ�ı���Ϣ
	private static final String RES_MESSAGE_TEXT = "text";

	// ��ӦͼƬ��Ϣ
	private static final String RES_MESSAGE_IMAGE = "image";

	// ��Ӧ������Ϣ
	private static final String RES_MESSAGE_VOICE = "voice";

	// ��Ӧ��Ƶ��Ϣ
	private static final String RES_MESSAGE_VIDEO = "video";

	// ��Ӧ������Ϣ
	private static final String RES_MESSAGE_MUSIC = "music";

	// ��Ӧͼ����Ϣ
	private static final String RES_MESSAGE_NEWS = "news";

	/**
	 * �������ݽ���
	 * 
	 * @param req
	 *            ��������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXML(HttpServletRequest req) {

		// �������������Map��
		Map<String, String> result = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		InputStream input = null;

		try {
			// ��request��ȡ������
			input = req.getInputStream();
			Document doc = reader.read(input);
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			for (Element e : elements) {
				// �������ַ����Ľ����һ�µġ�Ψһ���������getTextTrim��getText�������߿ո�Ĵ���
				// e.getStringValue()��e.getTextTrim()��e.getText()
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
