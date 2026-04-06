package com.kedu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kedu.dao.LocationsDAO;

@Controller
@RequestMapping("/location")
public class LocationsController {
	@Autowired
    private LocationsDAO dao;
	
	@RequestMapping("/getSido")
	@ResponseBody
	public List<String> getSido(){
		return dao.getSidoList();
	}
	
	@RequestMapping("/getGugun")
	@ResponseBody
	public List<String> getGugun(String sido){
		return dao.getGugunList(sido);
	}
	
	@RequestMapping("/getDong")
	@ResponseBody
	public List<String> getDong(String sido, String gugun){
		return dao.getDongList(sido, gugun);
	}
}
