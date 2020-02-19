package com.min.edu.dto;

public class Reserv_Dto {

    private String seq;
    private String u_id;
    private String h_regi;
    private String r_status;
    private String r_date;
    private String r_content;
    private String r_f_name;
    private String u_email;
    private String u_phone;
    private String h_name;
    private String h_address;
    private String h_mail;
    private String h_phone;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getH_regi() {
        return h_regi;
    }

    public void setH_regi(String h_regi) {
        this.h_regi = h_regi;
    }

    public String getR_status() {
        return r_status;
    }

    public void setR_status(String r_status) {
        this.r_status = r_status;
    }

    public String getR_date() {
        return r_date;
    }

    public void setR_date(String r_date) {
        this.r_date = r_date;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    public String getR_f_name() {
        return r_f_name;
    }

    public void setR_f_name(String r_f_name) {
        this.r_f_name = r_f_name;
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

    public String getH_mail() {
        return h_mail;
    }

    public void setH_mail(String h_mail) {
        this.h_mail = h_mail;
    }

    public String getH_phone() {
        return h_phone;
    }

    public void setH_phone(String h_phone) {
        this.h_phone = h_phone;
    }

    public Reserv_Dto() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Reserv_Dto [seq=" + seq + ", u_id=" + u_id + ", h_regi=" + h_regi + ", r_status=" + r_status
                + ", r_date=" + r_date + ", r_content=" + r_content + ", r_f_name=" + r_f_name + ", u_email=" + u_email
                + ", u_phone=" + u_phone + ", h_name=" + h_name + ", h_address=" + h_address + ", h_mail=" + h_mail
                + ", h_phone=" + h_phone + "]";
    }

    public Reserv_Dto(String seq, String u_id, String h_regi, String r_status, String r_date, String r_content,
                      String r_f_name, String u_email, String u_phone, String h_name, String h_address, String h_mail,
                      String h_phone) {
        super();
        this.seq = seq;
        this.u_id = u_id;
        this.h_regi = h_regi;
        this.r_status = r_status;
        this.r_date = r_date;
        this.r_content = r_content;
        this.r_f_name = r_f_name;
        this.u_email = u_email;
        this.u_phone = u_phone;
        this.h_name = h_name;
        this.h_address = h_address;
        this.h_mail = h_mail;
        this.h_phone = h_phone;
    }

}
