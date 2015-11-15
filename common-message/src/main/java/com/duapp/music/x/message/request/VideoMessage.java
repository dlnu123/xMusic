
package com.duapp.music.x.message.request;

import com.duapp.music.x.message.base.BaseReqMessage;

/**
 * 视频消息
 * 
 * @author qiuqiu3212
 */
public class VideoMessage extends BaseReqMessage {

	/**
	 * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String MediaId;

	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
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
