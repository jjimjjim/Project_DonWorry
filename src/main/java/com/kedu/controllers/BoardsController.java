package com.kedu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardsController {

	@RequestMapping("/mainboard_list")
	public String toBoard() {
		return "boards/mainboard/mainboard_list";
	}
}
