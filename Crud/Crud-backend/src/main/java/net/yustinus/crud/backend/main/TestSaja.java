/**
 * Copyright (c) 2016, Yustinus Nugroho
 * 
 * This software is created for education only.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *   1. Redistributions of source code must retain the above copyright notice, 
 *      this list of conditions and the following disclaimer.
 * 
 *   2. Let me know if you use this code by email yustinus.nugroho@gmail.com
 *  
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 * Hope this make changes.
 */
package net.yustinus.crud.backend.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.yustinus.crud.backend.beans.EmployeeBean;
import net.yustinus.crud.backend.services.EmployeeService;

/**
 * @author Yustinus Nugroho
 *
 */
@Component
public class TestSaja {
	@Autowired
	private EmployeeService employeeService;
	
	private static ApplicationContext applicationContext;

	/**
	 * @param args
	 */
	
	@Transactional
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		applicationContext = new ClassPathXmlApplicationContext("applicationContext-backend.xml");
		
		TestSaja ts = (TestSaja) applicationContext.getBean("testSaja");
		EmployeeBean eb = ts.getEmployeeService().searchEmployee(1);
		System.out.println(eb.getEmployeeId());
		System.out.println(eb.getName());
		System.out.println(eb.getGender());
		System.out.println(eb.getAddress());
		System.out.println(eb.getAge());
		
		EmployeeBean emp = new EmployeeBean();
		emp.setName("Tristan");
		emp.setGender('M');
		emp.setAddress("Sleman");
		emp.setAge(2);
		emp.setEmployeeId(3);
		ts.getEmployeeService().addEmployee(emp);
		/*ts.getEmployeeService().addEmployee(emp);*/
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
