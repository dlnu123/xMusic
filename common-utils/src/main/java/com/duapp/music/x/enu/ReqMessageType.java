
package com.duapp.music.x.enu;

/**
 * �����������͵�ö��
 * 
 * @author qiuqiu3212
 */
public enum ReqMessageType {

	// �����ı���Ϣ
	REQ_MESSAGE_TEXT() {

		@Override
		public String toString() {

			return "text";
		}
	},

	// ����ͼƬ��Ϣ
	REQ_MESSAGE_IMAGE() {

		@Override
		public String toString() {

			return "image";
		}
	},

	// ����������Ϣ
	REQ_MESSAGE_VOICE() {

		@Override
		public String toString() {

			return "voice";
		}
	},

	// ������Ƶ��Ϣ
	REQ_MESSAGE_VIDEO() {

		@Override
		public String toString() {

			return "video";
		}
	},

	// ����С��Ƶ��Ϣ
	REQ_MESSAGE_SHORTVIDEO() {

		@Override
		public String toString() {

			return "shortvideo";
		}
	},

	// �������λ����Ϣ
	REQ_MESSAGE_LOCATION() {

		@Override
		public String toString() {

			return "location";
		}
	},

	// ����������Ϣ
	REQ_MESSAGE_LINK() {

		@Override
		public String toString() {

			return "link";
		}
	};
}
