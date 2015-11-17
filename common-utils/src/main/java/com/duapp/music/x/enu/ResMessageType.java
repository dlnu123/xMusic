
package com.duapp.music.x.enu;

/**
 * 响应数据类型的枚举
 * 
 * @author qiuqiu3212
 */
public enum ResMessageType {

	// 响应文本消息
	RES_MESSAGE_TEXT() {

		@Override
		public String toString() {

			return "text";
		}
	},

	// 响应图片消息
	RES_MESSAGE_IMAGE() {

		@Override
		public String toString() {

			return "image";
		}
	},

	// 响应语音消息
	RES_MESSAGE_VOICE() {

		@Override
		public String toString() {

			return "voice";
		}
	},

	// 响应视频消息
	RES_MESSAGE_VIDEO() {

		@Override
		public String toString() {

			return "video";
		}
	},

	// 响应音乐消息
	RES_MESSAGE_MUSIC() {

		@Override
		public String toString() {

			return "music";
		}
	},

	// 响应图文消息
	RES_MESSAGE_NEWS() {

		@Override
		public String toString() {

			return "news";
		}
	};
}
