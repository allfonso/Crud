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
package net.yustinus.crud.backend.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.yustinus.crud.backend.dto.EmployeeDto;
import net.yustinus.crud.backend.mappers.EmployeeMapper;
import net.yustinus.crud.backend.services.EmployeeService;

/**
 * @author Yustinus Nugroho
 *
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	/* (non-Javadoc)
	 * @see net.yustinus.crud.backend.services.EmployeeService#getEmployee(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public EmployeeDto searchEmployee(int employeeId) {
		return this.employeeMapper.getEmployeeById(employeeId);
	}

	/* (non-Javadoc)
	 * @see net.yustinus.crud.backend.services.EmployeeService#deleteEmployee(int)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public EmployeeDto deleteEmployee(EmployeeDto employee) {
		int a = this.employeeMapper.removeEmployee(employee.getEmployeeId());
		if (a < 0)
			return null;
		else 
			return employee; 
	}

	/* (non-Javadoc)
	 * @see net.yustinus.crud.backend.services.EmployeeService#addEmployee(net.yustinus.crud.backend.beans.EmployeeBean)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public EmployeeDto addEmployee(EmployeeDto employee) {
		int a = this.employeeMapper.insertEmployee(employee);
		if (a < 0)
			return null;
		else
			return employee;
	}

	/* (non-Javadoc)
	 * @see net.yustinus.crud.backend.services.EmployeeService#updateEmployee(net.yustinus.crud.backend.beans.EmployeeBean)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public EmployeeDto updateEmployee(EmployeeDto employee) {
		int a = this.employeeMapper.editEmployee(employee);
		if (a < 0)
			return null;
		else
			return employee;
	}

}
