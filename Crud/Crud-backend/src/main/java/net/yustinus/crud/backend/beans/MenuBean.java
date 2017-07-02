package net.yustinus.crud.backend.beans;

import java.util.List;

import net.yustinus.crud.backend.dto.MenuDto;

public class MenuBean {
	
	private int headerId;
	private MenuDto headerMenu;
	private List<MenuItemBean> menus;
	
	public MenuBean() {
		// TODO Auto-generated constructor stub
	}

	public int getHeaderId() {
		return headerId;
	}

	public void setHeaderId(int headerId) {
		this.headerId = headerId;
	}

	public MenuDto getHeaderMenu() {
		return headerMenu;
	}

	public void setHeaderMenu(MenuDto headerMenu) {
		this.headerMenu = headerMenu;
	}

	public List<MenuItemBean> getMenus() {
		return menus;
	}

	public void setMenus(List<MenuItemBean> menus) {
		this.menus = menus;
	}	

}
