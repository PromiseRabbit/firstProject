package com.min.edu.aop;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AopLogger {

	//전달 받는 아규먼트
	public void before(JoinPoint j) {
		Logger log =LoggerFactory.getLogger(j.getTarget()+"");
		log.info("=====================Start=======================");
		Object[] args=j.getArgs();
		if(args!=null) {
			log.info("Method name:"+j.getSignature().getName());
			for (int i = 0; i < args.length; i++) {
				log.info(i+"번째  args :" +args[i]);
			}
			log.info("Method name :" +j.getSignature().getName());
			
		}
	}
	
	public void afterReturning(JoinPoint j) {

		Logger log =LoggerFactory.getLogger(j.getTarget()+"");
		log.info("======================End========================");
	}
	
	public void daoException(JoinPoint j) {
		Logger log =LoggerFactory.getLogger(j.getTarget()+"");
		log.info("error:\t"+j.getArgs());
		log.info("error:\t"+j.toString());
	}
}
