
package com.duapp.music.x.message.request;

import com.duapp.music.x.message.base.BaseReqMessage;

/**
 * ������Ϣ
 * 
 * @author qiuqiu3212
 */
public class VoiceMessage extends BaseReqMessage {

	/**
	 * ������Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	 */
	private String MediaId;

	/**
	 * ������ʽ����amr��speex��
	 */
	private String Format;

	public String getMediaId() {

		return MediaId;
	}

	public void setMediaId(String mediaId) {

		MediaId = mediaId;
	}

	public String getFormat() {

		return Format;
	}

	public void setFormat(String format) {

		Format = format;
	}
}
