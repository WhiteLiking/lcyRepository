package com.vo;


public class User {
	private String userno;
	private String username;
	private String password;
	private int age;
	private String sex;
	private String email;
	private String telephone;	
	private int state; //#×´Ì¬£º0=Î´¼¤»î£¬1=ÒÑ¼¤»î
	private String code; //#¼¤»îÂë
	public User() {
	
	}
	
	public User(String userno, String username, String password, int age, String sex, String email, String telephone,
			int state, String code) {
		super();
		this.userno = userno;
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.telephone = telephone;
		this.state = state;
		this.code = code;
	}

	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [userno=" + userno + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", sex=" + sex + ", email=" + email + ", telephone=" + telephone + ", state=" + state + ", code="
				+ code + "]";
	}

	
}
	

