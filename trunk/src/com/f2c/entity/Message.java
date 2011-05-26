package com.f2c.entity;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.Column;
import org.springframework.util.Id;
import org.springframework.util.Table;

/**
 * 
 * 消息实体对象
 * 
 * @author lihuan
 * 
 */
@Table(name = "T_MESSAGE")
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
	 * 消息状态 0：未发送 1：发送成功
	 */
	private Integer state;
	/**
	 * 发送成功后返回的消息
	 */
	private String resault;

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "FROM_USER_ID")
	public String getFromUserID() {
		return fromUserID;
	}

	public void setFromUserID(String fromUserID) {
		this.fromUserID = fromUserID;
	}

	@Column(name = "TO_USER_ID")
	public String getToUserID() {
		return toUserID;
	}

	public void setToUserID(String toUserID) {
		this.toUserID = toUserID;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "SEND_TIME")
	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "STATE")
	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Column(name = "RESAULT")
	public String getResault() {
		return resault;
	}

	public void setResault(String resault) {
		this.resault = resault;
	}

}
