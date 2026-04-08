package com.kedu.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.dao.BookmarkDAO;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {
	
	@Autowired
	private BookmarkDAO dao;
	
	@ResponseBody
	@RequestMapping("/toggle")
	public String toggleBookmark(int board_seq,HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		if (loginId == null) return "login_required";

		boolean isExist = dao.isBookmarkExist(board_seq, loginId);

	    if (isExist) {
	        dao.deleteBookmark(board_seq, loginId);
	        return "removed";
	    } else {
	        dao.insertBookmark(board_seq, loginId);
	        return "added";
	    }
	}

}
