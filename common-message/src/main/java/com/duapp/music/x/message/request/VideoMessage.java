
package com.duapp.music.x.message.request;

import com.duapp.music.x.message.base.BaseReqMessage;

/**
 * ��Ƶ��Ϣ
 * 
 * @author qiuqiu3212
 */
public class VideoMessage extends BaseReqMessage {

	/**
	 * ��Ƶ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	 */
	private String MediaId;

	/**
	 * ��Ƶ��Ϣ����ͼ��ý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	 */
	private String ThumbMediaId;

	public String getMediaId() {

		return MediaId;
	}

	public void setMediaId(String mediaId) {

		MediaId = mediaId;
	}

	public String getThumbMediaId() {

		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {

		ThumbMediaId = thumbMediaId;
	}
}
