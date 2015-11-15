
package com.duapp.music.x.message.request;

import com.duapp.music.x.message.base.BaseReqMessage;

/**
 * 文本消息
 * 
 * @author qiuqiu3212
 */
public class TextMessage extends BaseReqMessage {

	/**
	 * 文本消息内容
	 */
	private String Content;

	public String getContent() {

		return Content;
	}

	public void setContent(String content) {

		Content = content;
	}
}
