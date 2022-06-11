package com.chainsys.springproject.startup;

import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.lifecycle.LifeCycleBean;
import com.chainsys.springproject.test.TestAnnotatonConfig;
import com.chainsys.springproject.test.TestCar;
import com.chainsys.springproject.test.TestClassPathXml;
import com.chainsys.springproject.test.TestXmlBeanFactory;

public class Main {

	public static void main(String[] args) {
		// TestClassPathXml.testPrototype();
		// TestClassPathXml.testBeanwithConstructor();
		// TestClassPathXml.testFactoryMethod();
		// TestClassPathXml.testCalendarFactory();
		// TestClassPathXml.testLunchFactory();
		// TestAnnotatonConfig.testA();
		// TestClassPathXml.testSetterDi();
		// TestXmlBeanFactory.testA();
		// TestCar.firsttest();
//		TestClassPathXml.testLifeCycle();
		// TestClassPathXml.testInitDestoryBean();
		// TestClassPathXml.testAnnotationLc();
//TestClassPathXml.testAutoWire();
		 TestClassPathXml.testAutoWireQualifier();
		//TestAnnotatonConfig.testPhone();
	}

}
