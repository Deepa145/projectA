package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.ScoreBoard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;

public class TestClassPathXml {

	public static void testA() {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Gopika");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// Employee emp = ac.getBean(Employee.class);
		Employee emp = (Employee) ac.getBean("emp");
		emp.setId(101);
		emp.setName("Geetha");
		emp.print();

		Customer c = ac.getBean(Customer.class);
		c.setId(111);
		c.setName("Deepa");
		c.print();
	}

	public static void testLazYinit() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = ac.getBean(Employee.class); // overloaded method of getBean(Class) returns objects of the class
													// employee.Not required type casting.
		Customer c = ac.getBean(Customer.class);// overloaded method of getBean(String) returns object,type casting is
												// required.
		// lazy-init="true" for customer. An object is created now (firstcall to
		// getBean() method for customer.class)
		Employee emp1 = ac.getBean(Employee.class);
		Customer c1 = ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(emp1.hashCode());
		System.out.println(c.hashCode());
		System.out.println(c1.hashCode());
	}

	public static void testPrototype() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Actor hero = ac.getBean(Actor.class);
		Actor comedian = ac.getBean(Actor.class);
		Actor actress = ac.getBean(Actor.class);
		Actor villan = ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(comedian.hashCode());
		System.out.println(actress.hashCode());
		System.out.println(villan.hashCode());
	}

	public static void testBeanwithConstructor() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	}

	public static void testFactoryMethod() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ScoreBoard sb = ac.getBean("sb1", ScoreBoard.class);
		sb.targetScore = 183;
		System.out.println(sb.targetScore);
		ScoreBoard sb2 = ac.getBean("sb2", ScoreBoard.class);
		System.out.println(sb2.targetScore);
	}

	public static void testCalendarFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calendar today = ac.getBean(Calendar.class);
		today.day = 9;
		today.year = 2018;
		today.month = "june";
		System.out.println(today.day);
		System.out.println(today.month);
		System.out.println(today.year);
	}

	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nvsilunch = ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch = ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch = ac.getBean("nilunch", Lunch.class);
		Lunch chlunch = ac.getBean("chlunch", Lunch.class);
		System.out.println("----");
		nvsilunch.serve();
		System.out.println("----");
		vsilunch.serve();
		System.out.println("----");
		nilunch.serve();
		System.out.println("----");
		chlunch.serve();
	}

	public static void testSetterDi() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = ac.getBean("emp2", Employee.class);
		emp.print();
	}

	public static void testLifeCycle() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("Lc.xml");
		LifeCycleBean lcb = ac.getBean(LifeCycleBean.class);
		lcb.print();
		// lcb=null;
		ac.close();
		// ac=null;
		// System.gc();
//	  init-method="" this method is executed immediately after the constructor.
//	 This method can be use to setUp the method before it is ready for service calls
	}

	public static void testInitDestoryBean() {
		ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("Lc.xml");
		InitDesposeBean init = ac.getBean(InitDesposeBean.class);
		init.print();
	}

	public static void testAnnotationLc() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		AnnotationLc ann = ac1.getBean(AnnotationLc.class);
		ann.print();
		ann = null;
		ac1.close();
	}

	public static void testAutoWire() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		Car car = ac1.getBean(Car.class);
		car.move();
		car = null;
		ac1.close();
	}

	public static void testAutoWireQualifier() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		CarServices cs = ac1.getBean(CarServices.class);
	}
}
