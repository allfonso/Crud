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
package net.yustinus.crud.web.tests;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.yustinus.crud.backend.beans.EmployeeBean;
import net.yustinus.crud.backend.services.EmployeeService;
import net.yustinus.crud.web.testutils.BasicTest;

/**
 * @author Yustinus Nugroho
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext-backend-test.xml" })
public class EmployeeTest extends BasicTest{

	//@Autowired
	//private SqlSession sqlSession;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void getEmployeeById() {
		EmployeeBean employee = employeeService.searchEmployee(1);
		Assert.assertNotNull(employee);
	}
	
	@Test
	public void addNewEmployee() {
		EmployeeBean employee = new EmployeeBean();
		employee.setName("Tristan Jun");
		employee.setGender('M');
		employee.setAddress("Sleman");
		employee.setAge(2);
		employee.setEmployeeId(2);
		EmployeeBean result = employeeService.addEmployee(employee);
		Assert.assertNotNull(result);
	}
	
	@Test
	public void updateEmployee() {
		EmployeeBean employee = new EmployeeBean();
		employee.setName("Tristan J");
		employee.setGender('M');
		employee.setAddress("Jogja");
		employee.setAge(3);
		employee.setEmployeeId(1);
		EmployeeBean result = employeeService.updateEmployee(employee);
		Assert.assertNotNull(result);
		
	}
	
	@Test
	public void deleteEmployee() {
		EmployeeBean deletedEmployee = employeeService.searchEmployee(1);		
		EmployeeBean result = employeeService.deleteEmployee(deletedEmployee);
		Assert.assertNotNull(result);
		
	}

}
