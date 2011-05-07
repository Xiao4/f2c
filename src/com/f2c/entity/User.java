package com.f2c.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/*
import org.springframework.util.Column;
import org.springframework.util.Id;
import org.springframework.util.Table;
*/
/**
 * 
 * 用户实体对象
 * 
 * @author lihuan
 * 
 */
//@Table(name = "T_USER")
@XmlRootElement
public class User {
	/**
	 * 主键
	 */
	private String id;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 是否启用昵称发送短信
	 */
	private boolean nickNameSwitch;
	/**
	 * 性别
	 */
	private String gender;
	/**
	 * 该用户在139的UID
	 */
	private String mobileUID;
	/**
	 * 该用户在139的个性域名
	 */
	private String screenName;
	/**
	 * 该用户在139说客的头像图片地址
	 */
	private String icon;
	/**
	 * 账户到期时间
	 */
	private Date expirationDate;

/*	@Id
	@Column(name = "ID")
	*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
/*
	@Column(name = "MOBILE")
	*/
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isNickNameSwitch() {
		return nickNameSwitch;
	}

	public void setNickNameSwitch(boolean nickNameSwitch) {
		this.nickNameSwitch = nickNameSwitch;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileUID() {
		return mobileUID;
	}

	public void setMobileUID(String mobileUID) {
		this.mobileUID = mobileUID;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
