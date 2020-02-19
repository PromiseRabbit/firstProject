package com.min.edu.dto;

public class Ani_Dto {

	String h_name;
	String ani_content;
	String ani_code;
	String h_regi;
	
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getAni_content() {
		return ani_content;
	}
	public void setAni_content(String ani_content) {
		this.ani_content = ani_content;
	}
	public String getAni_code() {
		return ani_code;
	}
	public void setAni_code(String ani_code) {
		this.ani_code = ani_code;
	}
	public String getH_regi() {
		return h_regi;
	}
	public void setH_regi(String h_regi) {
		this.h_regi = h_regi;
	}
	@Override
	public String toString() {
		return "Ani_Dto [h_name=" + h_name + ", ani_content=" + ani_content + ", ani_code=" + ani_code + ", h_regi="
				+ h_regi + "]";
	}
	public Ani_Dto(String h_name, String ani_content, String ani_code, String h_regi) {
		super();
		this.h_name = h_name;
		this.ani_content = ani_content;
		this.ani_code = ani_code;
		this.h_regi = h_regi;
	}
	
	public Ani_Dto() {
		// TODO Auto-generated constructor stub
	}
}