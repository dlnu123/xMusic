package com.duapp.music.x.message.response;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Video;

/**
 * 回复视频消息
 * 
 * @author qiuqiu3212
 */
public class VideoMessage extends BaseResMessage {

	/**
	 * 视频
	 */
	private Video Video;

	public Video getVideo() {
		return Video;
	}

	public void setVideo(Video video) {
		Video = video;
	}
}
