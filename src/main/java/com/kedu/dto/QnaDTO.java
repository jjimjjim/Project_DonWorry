package com.kedu.dto;

import java.sql.Timestamp;

public class QnaDTO {
	private int seq;
	private String member_id;
	private String title;
	private String content;
	private String status;
	private Timestamp write_date;
	
	public QnaDTO() {}
	
	public QnaDTO(int seq, String member_id, String title, String content, String status, Timestamp write_date) {
		super();
		this.seq = seq;
		this.member_id = member_id;
		this.title = title;
		this.content = content;
		this.status = status;
		this.write_date = write_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	
	

}
