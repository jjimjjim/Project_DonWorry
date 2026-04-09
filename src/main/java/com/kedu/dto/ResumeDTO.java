package com.kedu.dto;

import java.sql.Timestamp;

public class ResumeDTO {
	private int seq;                 // 이력서 번호
    private String id;               // 아이디
    private String title;            // 제목
    private String preferred_job;     // 희망업종 
    private String working_condition; // 희망 근무 조건
    private String career;           // 경력 여부
    private String career_write;     // 경력 상세
    private String introduction;     // 간단 자기소개
    private String is_show;          // 공개 여부 
    private Timestamp resume_date;   // 이력서 작성시간
    
    private String phone;
    private String email;
    
    
    
    
    public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ResumeDTO() {}
    
	public ResumeDTO(int seq, String id, String title, String preferred_job, String working_condition, String career,
			String career_write, String introduction, String is_show, Timestamp resume_date) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.preferred_job = preferred_job;
		this.working_condition = working_condition;
		this.career = career;
		this.career_write = career_write;
		this.introduction = introduction;
		this.is_show = is_show;
		this.resume_date = resume_date;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPreferred_job() {
		return preferred_job;
	}
	public void setPreferred_job(String preferred_job) {
		this.preferred_job = preferred_job;
	}
	public String getWorking_condition() {
		return working_condition;
	}
	public void setWorking_condition(String working_condition) {
		this.working_condition = working_condition;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getCareer_write() {
		return career_write;
	}
	public void setCareer_write(String career_write) {
		this.career_write = career_write;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getIs_show() {
		return is_show;
	}
	public void setIs_show(String is_show) {
		this.is_show = is_show;
	}
	public Timestamp getResume_date() {
		return resume_date;
	}
	public void setResume_date(Timestamp resume_date) {
		this.resume_date = resume_date;
	}
    
    
	
    
}   