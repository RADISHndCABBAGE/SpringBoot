package com.kfit.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.kfit.demo.bean.Demo;


@Service
public class TestDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/*
	 * 不指定数据源则使用默认数据源
	 */
	public List<Demo> getList(){
		String sql = "select * from demo";
		return (List<Demo>) jdbcTemplate.query(sql, new RowMapper<Demo>(){
			@Override
			public Demo mapRow(ResultSet rs,int rowNum) throws SQLException{
				Demo demo = new Demo();
				demo.setId(rs.getLong("id"));
				demo.setName(rs.getString("name"));
				return demo;
			}
		});
	}
	
	/*
	 * 指定数据源
	 * 在对应的service进行指定
	 */
	public List<Demo> getListByDs1(){
		String sql= "select * from demo";
		return (List<Demo>) jdbcTemplate.query(sql, new RowMapper<Demo>(){
			@Override
			public Demo mapRow(ResultSet rs,int rowNum)throws SQLException{
				Demo demo = new Demo();
				demo.setId(rs.getLong("id"));
				demo.setName(rs.getString("name"));
				return demo;
			}
		});
		
	}
}
