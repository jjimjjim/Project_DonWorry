package com.kedu.dto;

import java.sql.Timestamp;

public class BoardsDTO {
	
	private int seq;
	private String member_nickname;
	private String category;
	private String title;
	private String content;
	private int view_count;
	private Timestamp write_date;
	
	
	
	
	public BoardsDTO() {}
	
	public BoardsDTO(int seq, String member_nickname, String category, String title, String content, int view_count,
			Timestamp write_date) {
		super();
		this.seq = seq;
		this.member_nickname = member_nickname;
		this.category = category;
		this.title = title;
		this.content = content;
		this.view_count = view_count;
		this.write_date = write_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	
	
	

}
