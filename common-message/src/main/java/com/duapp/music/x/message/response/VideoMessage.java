
package com.duapp.music.x.message.response;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Video;

/**
 * �ظ���Ƶ��Ϣ
 * 
 * @author qiuqiu3212
 */
public class VideoMessage extends BaseResMessage {

	/**
	 * ��Ƶ
	 */
	private Video Video;

	public Video getVideo() {

		return Video;
	}

	public void setVideo(Video video) {

		Video = video;
	}
}
