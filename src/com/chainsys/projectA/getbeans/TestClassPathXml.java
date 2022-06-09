package com.chainsys.projectA.getbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.projectA.beans.Actor;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;

public class TestClassPathXml {

	public static void testA() {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Gopika");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		//Employee emp = ac.getBean(Employee.class);
		Employee emp=(Employee) ac.getBean("emp");
		emp.setId(101);
		emp.setName("Geetha");
		emp.print();
		
		Customer c=ac.getBean(Customer.class);
		c.setId(111);
		c.setName("Deepa");
		c.print();
	}
	public static void testLazYinit()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = ac.getBean(Employee.class); // overloaded method of getBean(Class) returns objects of the class employee.Not required type casting.
		Customer c=ac.getBean(Customer.class);// overloaded method of getBean(String) returns object,type casting is required.
		//lazy-init="true" for customer. An object is created now (firstcall to getBean() method for customer.class)
		Employee emp1 = ac.getBean(Employee.class);
		Customer c1=ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(emp1.hashCode());
		System.out.println(c.hashCode());
		System.out.println(c1.hashCode());
	}
	public static void testPrototype()
	{
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	Actor hero=ac.getBean(Actor.class);
	Actor comedian=ac.getBean(Actor.class);
	Actor actress=ac.getBean(Actor.class);
	Actor villan=ac.getBean(Actor.class);
	System.out.println(hero.hashCode());
	System.out.println(comedian.hashCode());
	System.out.println(actress.hashCode());
	System.out.println(villan.hashCode());
	}
	public static void testBeanwithConstructor()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	}
}
