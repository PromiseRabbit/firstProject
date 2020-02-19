package com.min.edu.dto;

import java.io.Serializable;

public class User_Dto implements Serializable{

	private static final long serialVersionUID = 497744720329239695L;
	
	private String u_id;
	private String u_password;
	private String u_name;
	private String u_email;
	private String u_phone;
	private String u_enable;
	private String u_auth;
	private String f_name;
	
	public User_Dto() {
	}
	
	public User_Dto(String u_id, String u_password, String u_name, String u_email, String u_phone, String u_enable,
			String u_auth, String f_name) {
		super();
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_email = u_email;
		this.u_phone = u_phone;
		this.u_enable = u_enable;
		this.u_auth = u_auth;
		this.f_name = f_name;
	}
	@Override
	public String toString() {
		return "User_Dto [u_id=" + u_id + ", u_password=" + u_password + ", u_name=" + u_name + ", u_email=" + u_email
				+ ", u_phone=" + u_phone + ", u_enable=" + u_enable + ", u_auth=" + u_auth + ", f_name=" + f_name + "]";
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_enable() {
		return u_enable;
	}
	public void setU_enable(String u_enable) {
		this.u_enable = u_enable;
	}
	public String getU_auth() {
		return u_auth;
	}
	public void setU_auth(String u_auth) {
		this.u_auth = u_auth;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	

	
	
	
}