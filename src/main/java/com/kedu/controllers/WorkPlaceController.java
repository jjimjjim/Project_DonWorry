package com.kedu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dao.WorkPlaceDAO;
import com.kedu.dto.WorkPlaceDTO;

@Controller
@RequestMapping("/workplaces")
public class WorkPlaceController {
	
	@Autowired
	WorkPlaceDAO dao = new WorkPlaceDAO();
	
	@RequestMapping("/insert")
	public String insert(WorkPlaceDTO dto) {
		dao.insertToworkpalce(dto);
		
		return "";
	}

}
