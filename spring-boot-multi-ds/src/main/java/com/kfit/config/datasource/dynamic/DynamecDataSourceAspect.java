package com.kfit.config.datasource.dynamic;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.After;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

import org.springframework.core.annotation.Order;

import org.springframework.stereotype.Component;

@Aspect
@Order(-10)
@Component
public class DynamecDataSourceAspect {
	@Before("@annotation(targetDataSource)")
	public void changeDataSource(JoinPoint point,TargetDataSource targetDataSource)throws Throwable{
//		获取调遣的指定的数据源 
		String dsld = targetDataSource.value();
		if(!DynamicDataSourceContextHolder.containsDataSource(dsld)){
			System.err.println("数据源[{}]不存在，使用默认数据源 > {}"+targetDataSource.value()+point.getSignature());
		}else{
			 System.out.println("UseDataSource : {} > {}"+targetDataSource.value()+point.getSignature());
			 DynamicDataSourceContextHolder.setDataSourceType(targetDataSource.value());
		}
	}
	@After("@annotation(targetDataSource)")
	public void restoreDataSource(JoinPoint point,TargetDataSource targetDataSource){
		System.out.println("RevertDataSource : {} > {}"+targetDataSource.value()+point.getSignature());
		//方法执行完毕后，销毁当前数据源信息，进行垃圾回收
		DynamicDataSourceContextHolder.clearDataSourceType();
	}
}
