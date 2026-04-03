package com.kedu.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kedu.dto.BoardsDTO;

@Repository
public class BoardsDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int seqNextval() {
		String sql = "select boards_seq.nextval from dual";
		return jdbc.queryForObject(sql,Integer.class);
	}
	public void insert(int next,BoardsDTO dto) {
		String sql = "insert into boards values(?,?,?,?,?,0,sysdate)";
		jdbc.update(sql,next,dto.getMember_id(),dto.getCategory(),dto.getTitle(),dto.getContent());
	}
	public List<BoardsDTO> mainList(int start, int end){
		String sql = "SELECT * FROM (\r\n"
				+ "    SELECT \r\n"
				+ "        b.seq, \r\n"
				+ "        m.nickname AS member_id, \r\n"
				+ "        b.category, \r\n"
				+ "        b.title, \r\n"
				+ "        b.content, \r\n"
				+ "        b.view_count, \r\n"
				+ "        b.write_date,\r\n"
				+ "        ROW_NUMBER() OVER(ORDER BY b.seq DESC) AS rn \r\n"
				+ "    FROM boards b \r\n"
				+ "    LEFT JOIN members m ON b.member_id = m.id \r\n"
				+ ") WHERE rn BETWEEN ? AND ?";
		return jdbc.query(sql,new BeanPropertyRowMapper<BoardsDTO>(BoardsDTO.class),start,end);
		
	}
	public int recordTotalCount() {
		String sql = "select count(*) from boards";
		return jdbc.queryForObject(sql,Integer.class);
	}
	public BoardsDTO detail(int seq) {
		String sql = "select b.seq,m.nickname AS member_id,b.category,b.title,b.content,b.view_count,b.write_date"
				+ " from boards b join members m on b.member_id = m.id where seq = ?";
		return jdbc.queryForObject(sql,new BeanPropertyRowMapper<BoardsDTO>(BoardsDTO.class),seq);
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
