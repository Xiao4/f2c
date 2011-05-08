package com.f2c.entity;

import javax.xml.bind.annotation.XmlRootElement;
/*
import org.springframework.util.Column;
import org.springframework.util.Id;
import org.springframework.util.Table;
*/
/**
 * 
 * 好友关系
 *  
 * @author lihuan
 * 
 */
//@Table(name = "T_FRIEND")
@XmlRootElement
public class Friend {

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 某用户的ID
	 */
	private String userID;
	/**
	 * 某用户的对应的好友ID
	 */
	private String friendID;
	/**
	 * 好友所在组
	 */
	private String friendGroupID;
	/**
	 * 好友状态 1：同意 2：未同意
	 */
	private String state;

//	@Id
//	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	@Column(name = "USER_ID")
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

//	@Column(name = "FRIEND_ID")
	public String getFriendID() {
		return friendID;
	}

	public void setFriendID(String friendID) {
		this.friendID = friendID;
	}

	public String getFriendGroupID() {
		return friendGroupID;
	}

	public void setFriendGroupID(String friendGroupID) {
		this.friendGroupID = friendGroupID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
