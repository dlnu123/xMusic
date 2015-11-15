
package com.duapp.music.x.message.base;

/**
 * 请求消息基类
 * 
 * @author qiuqiu3212
 */
public class BaseReqMessage {

	/**
	 * 开发者微信号
	 */
	private String ToUserName;

	/**
	 * 发送方帐号（一个OpenID）
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
	 * 小视频消息:shortvideo
	 * 地理位置消息:location
	 * 链接消息:link
	 */
	private String MsgType;

	/**
	 * 消息id，64位整型
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
