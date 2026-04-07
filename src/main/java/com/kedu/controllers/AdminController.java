package com.kedu.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoardsDAO;
import com.kedu.dao.MembersDAO;
import com.kedu.dto.BoardsDTO;
import com.kedu.dto.MembersDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	

	@Autowired
	private MembersDAO dao;
	
	@Autowired
	private BoardsDAO bdao;
	
	@RequestMapping("/admin/admin_main")
	public String adminMain(Model model) {
		
		List<MembersDTO> recentMembersList = dao.getRecentMembers();

	    model.addAttribute("today", "2026-04-06");

	    model.addAttribute("totalMembers", 3300);
	    model.addAttribute("todayJoinCount", 18);

	    model.addAttribute("totalBoards", 1200);
	    model.addAttribute("todayBoardCount", 27);

	    model.addAttribute("unansweredInquiryCount", 23);
	    model.addAttribute("overdueInquiryCount", 6);
	    model.addAttribute("todayInquiryCount", 9);

	    model.addAttribute("businessMemberCount", 323);
	    model.addAttribute("businessMemberPercent", 9.8);
	    model.addAttribute("personalMemberCount", 2977);
	    model.addAttribute("personalMemberPercent", 90.2);

	    model.addAttribute("jobPostCount", 132);
	    model.addAttribute("recruitingJobCount", 98);

	    model.addAttribute("reportCount", 13);
	    model.addAttribute("urgentReportCount", 4);

	    model.addAttribute("visitorChartLabels", Arrays.asList("4/1", "4/2", "4/3", "4/4", "4/5", "4/6", "4/7"));
	    model.addAttribute("visitorChartData", Arrays.asList(120, 148, 162, 155, 180, 176, 190));

	    model.addAttribute("postChartLabels", Arrays.asList("11월", "12월", "1월", "2월", "3월", "4월"));
	    model.addAttribute("boardChartData", Arrays.asList(120, 180, 240, 210, 230, 260));
	    model.addAttribute("inquiryChartData", Arrays.asList(80, 130, 180, 160, 170, 190));

	    model.addAttribute("recentMembers", recentMembersList);

	    return "admin/admin_main";
	}
	
	@RequestMapping("/admin_main")
	public String toAdmin() {
		return "admin/admin_main";
	}
	
	@RequestMapping("/admin_members")
	public String toMembers() {
		
//		dao.getMembersList();
		
		return "admin/admin_members";
	}
	
	@RequestMapping("/admin_boards")
	public String adminBoards(int page, Model model) {
		//회원 게시글 페이지네이션 적용
		List<BoardsDTO> board_mainList =  bdao.mainList(page*5-4,page*5);		
		int recordTotalCount = bdao.mainRecordTotalCount();
		
		model.addAttribute("currentPage",page);
		model.addAttribute("recordCountPerPage",5);
		model.addAttribute("naviCountPerPage",10);
		model.addAttribute("recordTotalCount",recordTotalCount);
		model.addAttribute("board_mainList", board_mainList);
		
		//공지글 페이지 ㄴ
		List<BoardsDTO> notice_mainList =  bdao.adminNoticeList();
		model.addAttribute("notice_mainList",notice_mainList);
		
		return "admin/admin_boards";
	}
	
	@RequestMapping("/admin_board_detail")
	public String admin_board_detail(int seq, int page, Model model){
		BoardsDTO dto = bdao.detail(seq);
		model.addAttribute("dto",dto);
		model.addAttribute("currentPage",page);
		return "admin/admin_board_detail";
	}
	
	@RequestMapping("/admin_board_delete")
	public String delete(int seq, int page) {
		bdao.delete(seq);
		
		return "redirect:/admin/admin_boards?page="+page;
	}
	
	@RequestMapping("/notice_write")
	public String adminWrite() {
		return "admin/notice_write";
	}

	
	@RequestMapping("/admin_inquiry")
	public String toInquiry() {
		return "admin/admin_inquiry";
	}
	
	

}
