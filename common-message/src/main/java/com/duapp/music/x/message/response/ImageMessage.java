
package com.duapp.music.x.message.response;

import com.duapp.music.x.message.base.BaseResMessage;
import com.duapp.music.x.message.response.model.Image;

/**
 * �ظ�ͼƬ��Ϣ
 * 
 * @author qiuqiu3212
 */
public class ImageMessage extends BaseResMessage {

	/**
	 * ͼƬ
	 */
	private Image Image;

	public Image getImage() {

		return Image;
	}

	public void setImage(Image image) {

		Image = image;
	}
}
