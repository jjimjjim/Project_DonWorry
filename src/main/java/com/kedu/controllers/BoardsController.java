package com.kedu.controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.dao.BoardsDAO;
import com.kedu.dao.FilesDAO;
import com.kedu.dto.BoardsDTO;
import com.kedu.dto.FilesDTO;

@Controller
@RequestMapping("/boards")
public class BoardsController {
	
	@Autowired
	private BoardsDAO dao;
	
	@Autowired
	private FilesDAO fdao;
	

	@RequestMapping("/mainboard_list")
	public String toMainBoard(int page,Model model) {
		
		List<BoardsDTO> mainList =  dao.mainList(page*10-9,page*10);
		
		
		int recordTotalCount = dao.recordTotalCount();
		
		model.addAttribute("currentPage",page);
		model.addAttribute("recordCountPerPage",10);
		model.addAttribute("naviCountPerPage",10);
		model.addAttribute("recordTotalCount",recordTotalCount);
		//model.addAttribute("recordTotalCount",233); // 임시
		model.addAttribute("mainList", mainList);
		
		return "boards/mainboard/mainboard_list";
	}
	
	@RequestMapping("/jobpost")
	public String jobpost() {
		return "boards/jobpost";
	}
	
	@RequestMapping("/toWrite")
	public String toWrite() {
		return "boards/write";
	}
	@RequestMapping("/write")
	public String write(BoardsDTO dto,MultipartFile[] files) {
		System.out.println(dto.getContent() + " : " + dto.getCategory() );
		
		
		int nextVal = dao.seqNextval();
		System.out.println(nextVal);
		dao.insert(nextVal,dto);
		
		
		String savePath = "c:/files";
		File savePathFile = new File(savePath);

		if(!savePathFile.exists()) {
			savePathFile.mkdir();
		}
		for(MultipartFile file : files) {
			if(!file.isEmpty()) { // 비어있는 더미 파일 객체라면 무시
				String oriName = file.getOriginalFilename(); // 파일 원본 이름
				String sysName = UUID.randomUUID() + "_" + oriName; // 중복되지 않게 가공된 파일 이름
				try {
					file.transferTo(new File(savePath+"/"+sysName));
				}catch(Exception e) {
					e.printStackTrace();
					return "error";
				}
				
				fdao.upload(new FilesDTO(0,oriName,sysName,nextVal));
			}	
		}
		
		
		return "redirect:/boards/mainboard_list?page=1";
	}
	@RequestMapping("/detail")
	public String detail(int seq,Model model) {
		BoardsDTO dto = dao.detail(seq);
		
		model.addAttribute("dto",dto);
		
		List<FilesDTO> filesList = fdao.selectByParent_seq(seq);
		model.addAttribute("filesList",filesList);
		return "boards/detail";
	}
	@RequestMapping("/download")
	public void download(HttpServletResponse response,String sysName, String oriName) throws Exception{
		File target = new File("c:/files/" + sysName);
		
		oriName =  new String(oriName.getBytes("utf8"),"ISO-8859-1"); // 한글 깨짐 방지
		response.setHeader("content-disposition","attachment;filename="+oriName);
		
		
		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
				DataOutputStream dos = new DataOutputStream(response.getOutputStream());){

			byte[] fileContents = dis.readAllBytes(); 
			
			dos.write(fileContents);
			dos.flush();
		}
	}
}
