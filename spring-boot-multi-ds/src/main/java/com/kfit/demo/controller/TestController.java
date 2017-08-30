package com.kfit.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.demo.bean.Demo;
import com.kfit.demo.service.TestService;


@RestController
public class TestController {

	@Resource
	private TestService testService;
	
	@RequestMapping("/test1")
	public String test1(){
		for(Demo d:testService.getListByDs1()){
			System.out.println(d);
		}
		return "test1";
	}
	
	@RequestMapping("/test")
	public String test(){
		for(Demo d:testService.getList()){
			System.out.println(d);
		}
		return "test";
	}
}
