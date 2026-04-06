package com.kedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.BoardsDAO;
import com.kedu.dao.MembersDAO;
import com.kedu.dto.BoardsDTO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MembersDAO dao;
	
	@Autowired
	private BoardsDAO bdao;
	
	@RequestMapping("/admin_main")
	public String toAdmin() {
		return "admin/admin_main";
	}
	
	@RequestMapping("/admin_members")
	public String toMembers() {
		
//		dao.getMembersList();
		
		return "admin/admin_members";
	}
	//public List<BoardsDTO> mainList(int start, int end)
	@RequestMapping("/admin_boards")
	public String toBoards(int page, Model model) {
		List<BoardsDTO> board_mainList =  bdao.mainList(page*10-9,page*10);
		
		int recordTotalCount = bdao.recordTotalCount();
		
		model.addAttribute("currentPage",page);
		model.addAttribute("recordCountPerPage",10);
		model.addAttribute("naviCountPerPage",10);
		model.addAttribute("recordTotalCount",recordTotalCount);
		model.addAttribute("board_mainList", board_mainList);
		return "admin/admin_boards";
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
