package com.kedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.ReportDTO;
@Repository
public class ReportDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int report(ReportDTO dto) {
		String sql = "insert into report values(report_seq.nextval,?,?,?,?,sysdate,'접수')";
		return jdbc.update(sql,dto.getBoards_seq(),dto.getReply_seq(),dto.getMember_id(),dto.getReason());
	}
	public boolean reportCheck(ReportDTO dto) {
		String sql = "select count(*) from report where member_id = ? and boards_seq = ? and nvl(reply_seq,0) = ?";
		Integer reply_seq = (dto.getReply_seq() == null) ? 0 : dto.getReply_seq();
		int result = jdbc.queryForObject(sql,Integer.class,dto.getMember_id(),dto.getBoards_seq(),reply_seq);
		System.out.println(result);
		return result > 0;
	}

}
