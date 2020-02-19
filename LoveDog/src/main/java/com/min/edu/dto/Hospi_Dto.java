
package com.min.edu.dto;

import java.io.Serializable;

public class Hospi_Dto implements Serializable{
//병원 DTO
   private static final long serialVersionUID = -5769842329641114866L;
   
   private String h_name   ;
   private String h_address;
   private String h_phone  ;
   private String h_mail   ;
   private String h_regi   ;
   private String u_id     ;
   private String h_enable ;
   private String obj_code ;
   private String main_obj;
   private String main_ani;
   private String ani_code;
   
   public Hospi_Dto() {
      // TODO Auto-generated constructor stub
   }

   public String getH_name() {
      return h_name;
   }

   public void setH_name(String h_name) {
      this.h_name = h_name;
   }

   public String getH_address() {
      return h_address;
   }

   public void setH_address(String h_address) {
      this.h_address = h_address;
   }

   public String getH_phone() {
      return h_phone;
   }

   public void setH_phone(String h_phone) {
      this.h_phone = h_phone;
   }

   public String getH_mail() {
      return h_mail;
   }

   public void setH_mail(String h_mail) {
      this.h_mail = h_mail;
   }

   public String getH_regi() {
      return h_regi;
   }

   public void setH_regi(String h_regi) {
      this.h_regi = h_regi;
   }

   public String getU_id() {
      return u_id;
   }

   public void setU_id(String u_id) {
      this.u_id = u_id;
   }

   public String getH_enable() {
      return h_enable;
   }

   public void setH_enable(String h_enable) {
      this.h_enable = h_enable;
   }

   public String getObj_code() {
      return obj_code;
   }

   public void setObj_code(String obj_code) {
      this.obj_code = obj_code;
   }

   public String getMain_obj() {
      return main_obj;
   }

   public void setMain_obj(String main_obj) {
      this.main_obj = main_obj;
   }

   public String getMain_ani() {
      return main_ani;
   }

   public void setMain_ani(String main_ani) {
      this.main_ani = main_ani;
   }

   public String getAni_code() {
	   return ani_code;
   }
   
   public void setAni_code(String ani_code) {
	   this.ani_code = ani_code;
   }

   
	public Hospi_Dto(String h_name, String h_address, String h_phone, String h_mail, String h_regi, String u_id,
			String h_enable, String obj_code, String main_obj, String main_ani, String ani_code) {
		super();
		this.h_name = h_name;
		this.h_address = h_address;
		this.h_phone = h_phone;
		this.h_mail = h_mail;
		this.h_regi = h_regi;
		this.u_id = u_id;
		this.h_enable = h_enable;
		this.obj_code = obj_code;
		this.main_obj = main_obj;
		this.main_ani = main_ani;
		this.ani_code = ani_code;
	}

	
	@Override
	public String toString() {
		return "Hospi_Dto [h_name=" + h_name + ", h_address=" + h_address + ", h_phone=" + h_phone + ", h_mail=" + h_mail
				+ ", h_regi=" + h_regi + ", u_id=" + u_id + ", h_enable=" + h_enable + ", obj_code=" + obj_code
				+ ", main_obj=" + main_obj + ", main_ani=" + main_ani + ", ani_code=" + ani_code + "]";
	}
   
   

   
   


}