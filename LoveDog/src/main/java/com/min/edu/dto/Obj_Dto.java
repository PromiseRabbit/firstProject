package com.min.edu.dto;

public class Obj_Dto {

	String h_name		;
	String obj_content  ;
	String obj_code     ;
	String h_regi         ;
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public String getObj_content() {
		return obj_content;
	}
	public void setObj_content(String obj_content) {
		this.obj_content = obj_content;
	}
	public String getObj_code() {
		return obj_code;
	}
	public void setObj_code(String obj_code) {
		this.obj_code = obj_code;
	}
	public String getH_regi() {
		return h_regi;
	}
	public void setH_regi(String h_regi) {
		this.h_regi = h_regi;
	}
	@Override
	public String toString() {
		return "Obj_Dto [h_name=" + h_name + ", obj_content=" + obj_content + ", obj_code=" + obj_code + ", h_regi="
				+ h_regi + "]";
	}
	public Obj_Dto(String h_name, String obj_content, String obj_code, String h_regi) {
		super();
		this.h_name = h_name;
		this.obj_content = obj_content;
		this.obj_code = obj_code;
		this.h_regi = h_regi;
	}
	
	public Obj_Dto() {
		// TODO Auto-generated constructor stub
	}
	
}
