package com.duapp.music.x.message.base;

/**
 * 响应消息基类
 * 
 * @author qiuqiu3212
 */
public class BaseResMessage {

	/**
	 * 接收方帐号（收到的OpenID）
	 */
	private String ToUserName;

	/**
	 * 开发者微信号
	 */
	private String FromUserName;

	/**
	 * 消息创建时间 （整型）
	 */
	private Long CreateTime;

	/**
	 * 消息类型
	 * 
	 * 文本消息:text
	 * 图片消息:image
	 * 语音消息:voice
	 * 视频消息:video
	 * 音乐消息:music
	 * 图文消息:news
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
