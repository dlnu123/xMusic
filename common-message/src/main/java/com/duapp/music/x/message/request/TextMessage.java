package com.duapp.music.x.message.request;

import com.duapp.music.x.message.base.BaseReqMessage;

/**
 * �ı���Ϣ
 * 
 * @author qiuqiu3212
 */
public class TextMessage extends BaseReqMessage {

	/**
	 * �ı���Ϣ����
	 */
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
