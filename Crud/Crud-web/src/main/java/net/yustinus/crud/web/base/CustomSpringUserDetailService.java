package net.yustinus.crud.web.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.yustinus.crud.backend.beans.UserBean;
import net.yustinus.crud.backend.services.UserService;

@Service
public class CustomSpringUserDetailService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean userBean = userService.getUserByUsername(username);
		return new CustomSpringUserDetail(userBean);
	}

}
