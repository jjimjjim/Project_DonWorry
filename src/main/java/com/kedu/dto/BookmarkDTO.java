package com.kedu.dto;

import java.sql.Timestamp;

public class BookmarkDTO {
	private Timestamp bm_date;
	private int board_seq;
	private String member_id;
	
	
	public BookmarkDTO() {}
	
	public BookmarkDTO(Timestamp bm_date, int board_seq, String member_id) {
		super();
		this.bm_date = bm_date;
		this.board_seq = board_seq;
		this.member_id = member_id;
	}
	public Timestamp getBm_date() {
		return bm_date;
	}
	public void setBm_date(Timestamp bm_date) {
		this.bm_date = bm_date;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	} 
	
	
	

}
