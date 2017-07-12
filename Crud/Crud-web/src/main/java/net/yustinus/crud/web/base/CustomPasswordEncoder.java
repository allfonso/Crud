package net.yustinus.crud.web.base;

import org.springframework.security.crypto.password.PasswordEncoder;

import net.yustinus.utilities.HashUtility;

public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence plainPassword) {
		// TODO Auto-generated method stub
		return HashUtility.hash(plainPassword.toString());		
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) {
		// TODO Auto-generated method stub
		return HashUtility.verify(arg0.toString(), arg1);
	}

}
