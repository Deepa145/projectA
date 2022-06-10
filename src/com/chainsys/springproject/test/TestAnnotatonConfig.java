package com.chainsys.springproject.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.appconfig.AppConfig;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
public class TestAnnotatonConfig {
public static void testA()
{
	ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	Employee emp=ac.getBean(Employee.class);
	emp.setId(108);
	emp.setName("Deepa");
	emp.print();
	Employee secondemp=ac.getBean(Employee.class);
}
}
