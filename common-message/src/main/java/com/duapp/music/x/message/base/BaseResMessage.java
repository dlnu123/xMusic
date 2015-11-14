package com.duapp.music.x.message.base;

/**
 * ��Ӧ��Ϣ����
 * 
 * @author qiuqiu3212
 */
public class BaseResMessage {

	/**
	 * ���շ��ʺţ��յ���OpenID��
	 */
	private String ToUserName;

	/**
	 * ������΢�ź�
	 */
	private String FromUserName;

	/**
	 * ��Ϣ����ʱ�� �����ͣ�
	 */
	private Long CreateTime;

	/**
	 * ��Ϣ����
	 * 
	 * �ı���Ϣ:text
	 * ͼƬ��Ϣ:image
	 * ������Ϣ:voice
	 * ��Ƶ��Ϣ:video
	 * ������Ϣ:music
	 * ͼ����Ϣ:news
	 */
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
