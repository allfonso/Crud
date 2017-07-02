package net.yustinus.crud.backend.beans;

import java.util.List;

import net.yustinus.crud.backend.dto.MenuDto;

public class MenuItemBean {
	
	private int parentId;
	private MenuDto parentMenu;
	private List<MenuDto> childMenu;
	
	public MenuItemBean() {
	}

	public MenuDto getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(MenuDto parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<MenuDto> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<MenuDto> childMenu) {
		this.childMenu = childMenu;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
