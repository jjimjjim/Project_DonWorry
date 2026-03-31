package com.kedu.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.commons.EncryptionUtils;
import com.kedu.dao.MembersDAO;

@Controller
@RequestMapping("/members")
public class MembersController {
	
	@Autowired
	private MembersDAO dao;
	
	private EncryptionUtils eu = new EncryptionUtils();
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/members/login";
	}
	
	@RequestMapping("/login")
	public String login(String id, String pw,HttpSession session) {
		
		boolean result = dao.login(id,eu.getSha512(pw));
		if(result) {	
			session.setAttribute("loginId",id);
			session.setAttribute("nickName", dao.getNickname(id));	
		}
		return "redirect:/";	
	}
	@RequestMapping("/toIdSearch")
	public String toIdSearch() {
		return "/members/idSearch";
	}
	@ResponseBody
	@RequestMapping("/idSearch")
	public String idSearch(String name, String email) {
		System.out.println("도착");
		String id = dao.idSearch(name,email);	
		return id;
	}

}
