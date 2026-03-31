package com.kedu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardsController {

	@RequestMapping("/mainboard_list")
	public String toMainBoard() {
		return "boards/mainboard/mainboard_list";
	}
	
	@RequestMapping("/toWrite")
	public String toWrite() {
		return "boards/write";
	}
}
