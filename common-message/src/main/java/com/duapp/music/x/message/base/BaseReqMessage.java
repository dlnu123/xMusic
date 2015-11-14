package com.duapp.music.x.message.base;

/**
 * ������Ϣ����
 * 
 * @author qiuqiu3212
 */
public class BaseReqMessage {

	/**
	 * ������΢�ź�
	 */
	private String ToUserName;

	/**
	 * ���ͷ��ʺţ�һ��OpenID��
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
	 * С��Ƶ��Ϣ:shortvideo
	 * ����λ����Ϣ:location
	 * ������Ϣ:link
	 */
	private String MsgType;

	/**
	 * ��Ϣid��64λ����
	 */
	private Long MsgId;

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

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}
}
