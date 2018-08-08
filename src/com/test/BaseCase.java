package com.test;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


/**
 * ClassName: BaseCase
 * @Description: 测试类
 * @author Victor
 * @date 2017年6月30日
 */
@Component("baseCase")
public class BaseCase  extends TestCase{
	public Object getBean(String id){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		return  context.getBean(id);
	}

	

}
