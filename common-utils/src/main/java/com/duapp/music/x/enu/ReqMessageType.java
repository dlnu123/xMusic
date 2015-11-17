
package com.duapp.music.x.enu;

/**
 * 请求数据类型的枚举
 * 
 * @author qiuqiu3212
 */
public enum ReqMessageType {

	// 请求文本消息
	REQ_MESSAGE_TEXT() {

		@Override
		public String toString() {

			return "text";
		}
	},

	// 请求图片消息
	REQ_MESSAGE_IMAGE() {

		@Override
		public String toString() {

			return "image";
		}
	},

	// 请求语音消息
	REQ_MESSAGE_VOICE() {

		@Override
		public String toString() {

			return "voice";
		}
	},

	// 请求视频消息
	REQ_MESSAGE_VIDEO() {

		@Override
		public String toString() {

			return "video";
		}
	},

	// 请求小视频消息
	REQ_MESSAGE_SHORTVIDEO() {

		@Override
		public String toString() {

			return "shortvideo";
		}
	},

	// 请求地理位置消息
	REQ_MESSAGE_LOCATION() {

		@Override
		public String toString() {

			return "location";
		}
	},

	// 请求链接消息
	REQ_MESSAGE_LINK() {

		@Override
		public String toString() {

			return "link";
		}
	};
}
