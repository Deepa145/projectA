package com.chainsys.projectA.startup;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;
import org.springframework.context.ApplicationContext; // parent
import org.springframework.context.support.ClassPathXmlApplicationContext; // child

public class Main {

	public static void main(String[] args) {
		testB();
         //testA();
	}

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
}
