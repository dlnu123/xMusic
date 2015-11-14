package com.duapp.music.x.message.response;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Music;

/**
 * »Ø¸´ÒôÀÖÏûÏ¢
 * 
 * @author qiuqiu3212
 */
public class MusicMessage extends BaseResMessage {

	/**
	 * ÒôÀÖ
	 */
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
