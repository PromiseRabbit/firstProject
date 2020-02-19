package com.min.edu.dto;

import java.io.Serializable;

public class FreeBoard_Dto implements Serializable{

	private static final long serialVersionUID = -2571731225035031165L;
	
	private int seq;
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
	private String b_type;
	
	private String search_option;
	private String keyword;
	
	public FreeBoard_Dto(String search_option, String keyword) {
		super();
		this.search_option = search_option;
		this.keyword = keyword;
	}

	public FreeBoard_Dto() {
	}

	public FreeBoard_Dto(int seq, String u_id, String title, String content, int refer, int step, int depth,
			String f_name, String delflag, String regdate, int readcount, String b_type) {
		super();
		this.seq = seq;
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
		this.b_type = b_type;
	}

	

	public String getSearch_option() {
		return search_option;
	}

	public void setSearch_option(String search_option) {
		this.search_option = search_option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "FreeBoard_Dto [seq=" + seq + ", u_id=" + u_id + ", title=" + title + ", content=" + content + ", refer="
				+ refer + ", step=" + step + ", depth=" + depth + ", f_name=" + f_name + ", delflag=" + delflag
				+ ", regdate=" + regdate + ", readcount=" + readcount + ", b_type=" + b_type + ", search_option="
				+ search_option + ", keyword=" + keyword + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
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

	public String getB_type() {
		return b_type;
	}

	public String setB_type(String b_type) {
		return this.b_type = b_type;
	}
	
	
	
	
	
	
}
