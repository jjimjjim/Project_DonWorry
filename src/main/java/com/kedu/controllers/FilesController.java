package com.kedu.controllers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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

	    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

	    String path = "C:/upload/";
	    
	    File dir = new File(path);
	    if(!dir.exists()){
	        dir.mkdirs();
	    }

	    File dest = new File(path + fileName);
	    file.transferTo(dest);

	    Map<String, String> map = new HashMap<>();
	    map.put("url", "/upload/" + fileName); // ⭐ 핵심

	    return map;
	}
	
	
	
	
	
	
	
//	@PostMapping("/upload")
//	@ResponseBody
//	public Map<String, String> upload(@RequestParam("image") MultipartFile file,HttpServletRequest request) {
//	    Map<String, String> map = new HashMap<>();
//	    
//	    try {
//	        if (file == null || file.isEmpty()) {
//	            System.out.println("파일이 비어있습니다.");
//	            return null;
//	        }
//
//	        System.out.println("파일 수신 성공: " + file.getOriginalFilename());
//
//	        String originalName = file.getOriginalFilename();
//	        String extension = originalName.substring(originalName.lastIndexOf("."));
//	        String fileName = UUID.randomUUID().toString() + extension;
//
//	        String path = "C:/upload/";
//	        File savePathFile = new File(path);
//	        
//	        if(!savePathFile.exists()){
//	            savePathFile.mkdirs(); 
//	        }
//	        
//	       
//	        File dest = new File(path + fileName);
//	        try {
//	            file.transferTo(dest);
//	        } catch (IOException e) {
//	            // 여기서 에러가 나는지 확인!
//	            e.printStackTrace(); 
//	        }
	        
//	     // 추가: 파일이 진짜 생성됐는지 서버가 직접 확인하게 함
//	        if (dest.exists()) {
//	            System.out.println("확인: 파일이 실제 경로에 존재합니다! 크기: " + dest.length() + " bytes");
//	        } else {
//	            System.err.println("경고: 파일 저장 완료라고 떴지만, 실제 파일이 없습니다!");
//	        }
//
//	        System.out.println("파일 저장 완료: " + dest.getAbsolutePath());

	        // URL 반환 (서버 IP 확인 필수)
	        //map.put("url", "http://10.10.55.87/upload/" + fileName); 
	     // request.getContextPath()를 붙여서 정확한 절대 경로를 만들어줍니다.
//	        String url = request.getContextPath() + "/upload/" + fileName;
//	        map.put("url", url);
//	        
//	    } catch (Exception e) {
//	        e.printStackTrace(); // 에러가 나면 콘솔에 빨간 글씨가 뜹니다.
//	    }
//
//	    return map;
//	}
//	
	
	
	
	
	
	
	
	
	

//	@PostMapping("/upload")
//	@ResponseBody
//	public Map<String, String> upload(@RequestParam("image") MultipartFile file) throws Exception {
//	    if (file == null || file.isEmpty()) {
//	        return null;
//	    }
//
//	    // 1. 원본 파일명에서 확장자만 추출 (예: .jpg, .png)
//	    String originalName = file.getOriginalFilename();
//	    String extension = originalName.substring(originalName.lastIndexOf("."));
//
//	    // 2. UUID와 확장자만 결합 (한글/공백 원천 차단)
//	    String fileName = UUID.randomUUID()+"_" + extension;
//	    System.out.println(fileName);
//
//	    String path = "C:/upload/";
//	    File savePathFile = new File(path);
//	    if(!savePathFile.exists()){
//	        savePathFile.mkdirs(); 
//	    }
//	    
//	    File dest = new File(path + fileName);
//	    file.transferTo(dest);
//
//	    Map<String, String> map = new HashMap<>();
//	    // 3. 정확한 경로 반환
//	    map.put("url", "http://10.10.55.87/upload/" + fileName); 
//
//	    return map;
//	}
	
	
	
	
	
	
//	@PostMapping("/upload")
//	@ResponseBody
//	public Map<String, String> upload(@RequestParam("image") MultipartFile file) throws Exception {
//		System.out.println("=== 업로드 컨트롤러 시작 ==="); // 👈 이게 콘솔에 찍히는지 확인
//	    
//	    if (file == null || file.isEmpty()) {
//	        System.out.println("파일이 비어있습니다!"); // 👈 혹시 파일이 안 넘어오는지 확인
//	        return null;
//	    }
//		
//	    //String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
//	    String fileName = UUID.randomUUID().toString() + ".png";
//
//	    String path = "C:/upload/";
//	    
//	    File savePathFile = new File(path);
//	    if(!savePathFile.exists()){
//	        savePathFile.mkdirs(); 
//	    }
//	    
//	    File dest = new File(path + fileName);
//
//	    file.transferTo(dest);
//
//	    Map<String, String> map = new HashMap<>();
//	    map.put("url", "http://10.10.55.87/upload/" + fileName); // ⭐ 이 URL이 핵심
//
//	    return map;
//	}
	
}
