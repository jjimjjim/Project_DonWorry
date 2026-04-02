package com.kedu.controllers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/files")
public class FilesController {
	// 게시판 이미지 

	@PostMapping("/upload")
	@ResponseBody
	public Map<String, String> upload(@RequestParam("image") MultipartFile file) throws Exception {
		System.out.println("=== 업로드 컨트롤러 시작 ==="); // 👈 이게 콘솔에 찍히는지 확인
	    
	    if (file == null || file.isEmpty()) {
	        System.out.println("파일이 비어있습니다!"); // 👈 혹시 파일이 안 넘어오는지 확인
	        return null;
	    }
		
	    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

	    String path = "C:/upload/";
	    
	    File savePathFile = new File(path);
	    if(!savePathFile.exists()){
	        savePathFile.mkdirs(); 
	    }
	    
	    File dest = new File(path + fileName);
	    
	    file.transferTo(dest);

	    Map<String, String> map = new HashMap<>();
	    map.put("url", "http://10.10.55.87/upload/" + fileName); // ⭐ 이 URL이 핵심

	    return map;
	}
	
}
