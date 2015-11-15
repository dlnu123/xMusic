
package com.duapp.music.x.message.request;

import com.duapp.music.x.message.base.BaseReqMessage;

/**
 * ������Ϣ
 * 
 * @author qiuqiu3212
 */
public class LinkMessage extends BaseReqMessage {

	/**
	 * ��Ϣ����
	 */
	private String Title;

	/**
	 * ��Ϣ����
	 */
	private String Description;

	/**
	 * ��Ϣ����
	 */
	private String Url;

	public String getTitle() {

		return Title;
	}

	public void setTitle(String title) {

		Title = title;
	}

	public String getDescription() {

		return Description;
	}

	public void setDescription(String description) {

		Description = description;
	}

	public String getUrl() {

		return Url;
	}

	public void setUrl(String url) {

		Url = url;
	}
}
