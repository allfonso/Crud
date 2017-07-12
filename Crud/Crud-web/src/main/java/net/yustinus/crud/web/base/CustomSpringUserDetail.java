package net.yustinus.crud.web.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import net.yustinus.crud.backend.beans.UserBean;
import net.yustinus.crud.backend.dto.RoleDto;

public class CustomSpringUserDetail implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4454090092614523090L;
	private UserBean userBean;
	
	public CustomSpringUserDetail() {	
	}
	
	public CustomSpringUserDetail(UserBean userBean) {
		this.setUserBean(userBean);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (this.userBean.getUserProfile().getRoles() !=null) {
			for (RoleDto rd : this.userBean.getUserProfile().getRoles()) {
				authorities.add(new SimpleGrantedAuthority(rd.getRoleName()));
			}
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.userBean.getUserPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userBean.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

}
