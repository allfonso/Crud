package net.yustinus.crud.backend.beans;

import java.util.List;

import net.yustinus.crud.backend.dto.MenuDto;

public class BreadcrumbBean {
	
	private List<MenuDto> menus;
	
	public BreadcrumbBean() {
		// TODO Auto-generated constructor stub
	}

	public List<MenuDto> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuDto> menus) {
		this.menus = menus;
	}

}
