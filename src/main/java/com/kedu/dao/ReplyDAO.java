package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.ReplyDTO;

@Repository
public class ReplyDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public void insert(ReplyDTO dto){
		String sql = "insert into reply values(reply_seq.nextval,?,?,?,sysdate,?)";
		jdbc.update(sql,dto.getParent_seq(),dto.getMember_id(),dto.getContent(),dto.getRe_reply_seq());
	}
	public List<ReplyDTO> selectByParent_seq(int parent_seq){
		String sql = "select r.seq,r.parent_seq,m.nickname AS member_id,r.content,"
				+ "r.write_date,r.re_reply_seq from reply r join members m "
				+ "on r.member_id = m.id where parent_seq = ? order by 1 desc";
		return jdbc.query(sql,new BeanPropertyRowMapper<ReplyDTO>(ReplyDTO.class),parent_seq);
	}

}
