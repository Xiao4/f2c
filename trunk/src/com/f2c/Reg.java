package com.f2c;

public class Reg {
	private String Nickname;
	private int Gender;
	private int Province;
	private int City;
	private String ScreenName;
	private String IdCard;
	private String Email;
	private boolean Agreement;
	public String getNickname() {
		return Nickname; 
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public int getProvince() {
		return Province;
	}
	public void setProvince(int province) {
		Province = province;
	}
	public int getCity() {
		return City;
	}
	public void setCity(int city) {
		City = city;
	}
	public String getScreenName() {
		return ScreenName;
	}
	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}
	public String getIdCard() {
		return IdCard;
	}
	public void setIdCard(String idCard) {
		IdCard = idCard;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public boolean isAgreement() {
		return Agreement;
	}
	public void setAgreement(boolean agreement) {
		Agreement = agreement;
	}
}
