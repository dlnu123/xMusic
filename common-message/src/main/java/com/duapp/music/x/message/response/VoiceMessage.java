
package com.duapp.music.x.message.response;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Voice;

/**
 * ªÿ∏¥”Ô“Ùœ˚œ¢
 * 
 * @author qiuqiu3212
 */
public class VoiceMessage extends BaseResMessage {

	/**
	 * ”Ô“Ù
	 */
	private Voice Voice;

	public Voice getVoice() {

		return Voice;
	}

	public void setVoice(Voice voice) {

		Voice = voice;
	}
}
