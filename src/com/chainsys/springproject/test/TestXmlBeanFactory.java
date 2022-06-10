package com.chainsys.springproject.test;
import org.springframework.beans.factory.xml.XmlBeanFactory; 
import org.springframework.core.io.ClassPathResource;

import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;

import org.springframework.core.io.ClassPathResource;

public class TestXmlBeanFactory {
public static void testA()
{
ClassPathResource res=new ClassPathResource("beans.xml");
XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("Beans.xml")); 
Employee emp=factory.getBean("emp2",Employee.class);
emp.setId(209);
emp.setName("java");
emp.print();
System.out.println(factory.isSingleton("emp"));
System.out.println(factory.getBean("emp") instanceof Employee);
System.out.println(factory.getBean("emp") instanceof Customer);
System.out.println(factory.isPrototype("emp"));
System.out.println(factory.isTypeMatch("emp",Employee.class));
}
}
