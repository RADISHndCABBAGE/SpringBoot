package com.kfit.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kfit.config.datasource.dynamic.TargetDataSource;
import com.kfit.demo.bean.Demo;
import com.kfit.demo.dao.TestDao;

@Service
public class TestService {
	@Resource 
	private TestDao testDao;
	/*
	 * 不指定数据源使用默认数据源
	 */
	
	public List<Demo> getList(){
		return testDao.getList();
	}
	
	/*
	 * 指定数据源
	 */
	@TargetDataSource("ds1")
	public List<Demo> getListByDs1(){
		return testDao.getListByDs1();
	}
}
