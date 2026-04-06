package com.kedu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LocationsDAO {

	@Autowired
	private JdbcTemplate jdbc;
	
	// 시/도 목록 가져옴
    public List<String> getSidoList() {
        String sql = "select distinct sido from locations order by sido";
        return jdbc.queryForList(sql, String.class);
    }
	
    // 시/도의 구/군 목록 가져옴
    public List<String> getGugunList(String sido) {
        String sql = "select distinct gugun from locations where sido = ? and gugun is not null order by gugun";
        return jdbc.queryForList(sql, String.class, sido);
    }
    
    // 시/도 + 구/군의 동 목록 가져옴
    public List<String> getDongList(String sido, String gugun) {
        String sql = "select distinct dong from locations where sido = ? and gugun = ? order by dong";
        return jdbc.queryForList(sql, String.class, sido, gugun);
    }
}
