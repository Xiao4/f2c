package com.f2c.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 消息实体对象
 * 
 * @author lihuan
 * 
 */
@XmlRootElement
public class Message {

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 发送人的ID
	 */
	private String fromUserID;
	/**
	 * 接收人的ID
	 */
	private String toUserID;
	/**
	 * 消息体
	 */
	private String description;
	/**
	 * 发送时间
	 */
	private String sendTime;
	/**
	 * 消息是否成功发送
	 */
	private boolean state;
	/**
	 * 发送成功后返回的消息
	 */
	private String resault;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFromUserID() {
		return fromUserID;
	}

	public void setFromUserID(String fromUserID) {
		this.fromUserID = fromUserID;
	}

	public String getToUserID() {
		return toUserID;
	}

	public void setToUserID(String toUserID) {
		this.toUserID = toUserID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getResault() {
		return resault;
	}

	public void setResault(String resault) {
		this.resault = resault;
	}

}
