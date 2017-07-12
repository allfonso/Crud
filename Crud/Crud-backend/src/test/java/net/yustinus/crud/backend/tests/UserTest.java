/**
 * 
 * Copyright (c) 2017, Yustinus Nugroho
 * 
 * This software is created to help SIMPEG division in Badan Kepegawaian Daerah
 * gathering and organizing data from other divisions.
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
package net.yustinus.crud.backend.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.yustinus.crud.backend.beans.UserBean;
import net.yustinus.crud.backend.dto.RoleDto;
import net.yustinus.crud.backend.services.UserService;
import net.yustinus.crud.backend.testutils.BasicTest;

/**
 * @author Yustinus Nugroho
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext-backend.xml" })
public class UserTest extends BasicTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void getUserByUsernameTest() {
		UserBean user = userService.getUserByUsername("yustinus");
		System.out.println("User ID : "+ user.getUserId());
		System.out.println("Username : "+ user.getUsername());
		System.out.println("NIP : "+ user.getNip());
		System.out.println("password : "+ user.getUserPassword());
		System.out.println("last login : "+ user.getLastLogin());
		System.out.println("Is User disable : "+ user.isUserDisable());
		System.out.println("\t Profile ID : "+ user.getUserProfile().getProfileId());
		System.out.println("\t Profile Name : "+ user.getUserProfile().getProfileName());
		System.out.println("\t Profile Disable : "+ user.getUserProfile().isProfileDisable());
		for (RoleDto rd : user.getUserProfile().getRoles()) {
			System.out.println("\t \t Role id : "+ rd.getRoleId());
			System.out.println("\t \t Role Name : "+ rd.getRoleName());
			System.out.println("\t \t Role disable : "+ rd.isRoleDisable());
		}
		System.out.println("\t \t Rode ID : "+ user.getUserProfile().getProfileId());
		Assert.assertNotNull(user);
	}

}
