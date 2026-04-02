package com.kedu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kedu.dto.WorkPlaceDTO;
@Repository
public class WorkPlaceDAO {

	@Autowired
	public JdbcTemplate jdbc;
	
	public int insertToworkpalce(WorkPlaceDTO dto) {
		String sql = "insert into workplace ("
                + "seq, id, name, pay_per_hour, pay_type, pay_cycle, payday, "
                + "tax_applied, insurance_applied, work_start_time, work_end_time, workplace_date"
                + ") values (workplace_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, systimestamp)";
		return jdbc.update(sql,
                dto.getId(),
                dto.getName(),
                dto.getPay_per_hour(),
                dto.getPay_type(),
                dto.getPay_cycle(),
                dto.getPayday(),
                dto.getTax_applied(),
                dto.getInsurance_applied(),
                dto.getWork_start_time(),
                dto.getWork_end_time());
	}
	
	
}
