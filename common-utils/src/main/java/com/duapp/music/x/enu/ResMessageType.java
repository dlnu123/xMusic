
package com.duapp.music.x.enu;

/**
 * ��Ӧ�������͵�ö��
 * 
 * @author qiuqiu3212
 */
public enum ResMessageType {

	// ��Ӧ�ı���Ϣ
	RES_MESSAGE_TEXT() {

		@Override
		public String toString() {

			return "text";
		}
	},

	// ��ӦͼƬ��Ϣ
	RES_MESSAGE_IMAGE() {

		@Override
		public String toString() {

			return "image";
		}
	},

	// ��Ӧ������Ϣ
	RES_MESSAGE_VOICE() {

		@Override
		public String toString() {

			return "voice";
		}
	},

	// ��Ӧ��Ƶ��Ϣ
	RES_MESSAGE_VIDEO() {

		@Override
		public String toString() {

			return "video";
		}
	},

	// ��Ӧ������Ϣ
	RES_MESSAGE_MUSIC() {

		@Override
		public String toString() {

			return "music";
		}
	},

	// ��Ӧͼ����Ϣ
	RES_MESSAGE_NEWS() {

		@Override
		public String toString() {

			return "news";
		}
	};
}
