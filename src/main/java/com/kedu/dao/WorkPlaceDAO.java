package com.kedu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.WorkPlaceDTO;
@Repository
public class WorkPlaceDAO {

	@Autowired
	public JdbcTemplate jdbc;
	
	public int insertToworkpalce(WorkPlaceDTO dto) {
	    String sql = "INSERT INTO workplace ("
	            + "seq, id, name, pay_per_hour, pay_type, pay_cycle, payday, "
	            + "tax_applied, insurance_applied, employment_insurance, "
	            + "work_start_time, work_end_time, workplace_date"
	            + ") VALUES (workplace_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
	            + "TO_DATE(?, 'HH24:MI'), TO_DATE(?, 'HH24:MI'), sysdate)";

	    return jdbc.update(sql,
	            dto.getId(),
	            dto.getName(),
	            dto.getPay_per_hour(),
	            dto.getPay_type(),
	            dto.getPay_cycle(),
	            dto.getPayday(),
	            dto.getTax_applied(), // 'Y' 또는 'N'
	            dto.getInsurance_applied(), // 4대보험 여부
	            dto.getEmployment_insurance(), // 고용보험 여부
	            dto.getWork_start_time(),
	            dto.getWork_end_time()
	    );
	}
	
	public List<WorkPlaceDTO> selectByMemberId(String memberId) {
	    String sql = "select "
	            + "seq, id, name, pay_per_hour, pay_type, pay_cycle, payday, "
	            + "tax_applied, insurance_applied, employment_insurance, "
	            + "to_char(work_start_time, 'HH24:MI') as work_start_time, "
	            + "to_char(work_end_time, 'HH24:MI') as work_end_time, "
	            + "to_char(workplace_date, 'YYYY-MM-DD HH24:MI:SS') as workplace_date "
	            + "from workplace where id = ?";

	    return jdbc.query(sql, new BeanPropertyRowMapper<>(WorkPlaceDTO.class), memberId);
	}
	
	public WorkPlaceDTO selectBySeq(int seq) {
		String sql = "select * from workplace where seq = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<WorkPlaceDTO>(WorkPlaceDTO.class), seq);
	}
	
	public int update(WorkPlaceDTO dto) {
		String sql = "update workplace set name = ?, pay_per_hour = ?,"
				+ "pay_type = ?, pay_cycle = ?, payday = ?, tax_applied = ?,"
				+ "insurance_applied = ?, employment_insurance = ?, work_start_time = ?, "
				+ "work_end_time = ? where seq = ?";
		return jdbc.update(sql, dto.getName(), dto.getPay_per_hour(), dto.getPay_type(),
					dto.getPay_cycle(), dto.getPayday(), dto.getTax_applied(), 
					dto.getInsurance_applied(), dto.getEmployment_insurance(),
					dto.getWork_start_time(), dto.getWork_end_time(), dto.getSeq());
	}
	
}
