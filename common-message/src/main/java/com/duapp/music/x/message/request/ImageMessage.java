package com.duapp.music.x.message.request;

import com.duapp.music.x.message.base.BaseReqMessage;

/**
 * ͼƬ��Ϣ
 * 
 * @author qiuqiu3212
 */
public class ImageMessage extends BaseReqMessage {

	/**
	 * ͼƬ����
	 */
	private String PicUrl;

	/**
	 * ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	 */
	private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
