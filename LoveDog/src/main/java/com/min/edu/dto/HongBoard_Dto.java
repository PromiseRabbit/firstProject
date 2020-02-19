package com.min.edu.dto;

import java.io.Serializable;

public class HongBoard_Dto implements Serializable{

	
	private static final long serialVersionUID = -6687027730887272141L;
	
	private int seq;
	private String h_regi;
	private String u_id;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private String f_name;
	private String delflag;
	private String regdate;
	private int readcount;
	
	public HongBoard_Dto() {
	}
	
	public HongBoard_Dto(int seq, String h_regi, String u_id, String title, String content, int refer, int step,
			int depth, String f_name, String delflag, String regdate, int readcount) {
		super();
		this.seq = seq;
		this.h_regi = h_regi;
		this.u_id = u_id;
		this.title = title;
		this.content = content;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.f_name = f_name;
		this.delflag = delflag;
		this.regdate = regdate;
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		return "HongBoard_Dto [seq=" + seq + ", h_regi=" + h_regi + ", u_id=" + u_id + ", title=" + title + ", content="
				+ content + ", refer=" + refer + ", step=" + step + ", depth=" + depth + ", f_name=" + f_name
				+ ", delflag=" + delflag + ", regdate=" + regdate + ", readcount=" + readcount + "]";
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRefer() {
		return refer;
	}
	public void setRefer(int refer) {
		this.refer = refer;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	
	
	
	
	
	
}
