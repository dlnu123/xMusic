package com.duapp.music.x.message.response;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Music;

/**
 * �ظ�������Ϣ
 * 
 * @author qiuqiu3212
 */
public class MusicMessage extends BaseResMessage {

	/**
	 * ����
	 */
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
