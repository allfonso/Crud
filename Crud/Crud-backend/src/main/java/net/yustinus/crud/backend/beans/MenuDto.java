package net.yustinus.crud.backend.beans;

import java.util.List;

public class MenuDto {
	
	private int parentId;
	private MenuBean parentMenu;
	private List<MenuBean> childMenu;
	
	public MenuDto() {
	}

	public MenuBean getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(MenuBean parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<MenuBean> getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(List<MenuBean> childMenu) {
		this.childMenu = childMenu;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

}
