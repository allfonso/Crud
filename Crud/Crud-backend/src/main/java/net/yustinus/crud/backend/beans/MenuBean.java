package net.yustinus.crud.backend.beans;

public class MenuBean {
	
	private int menuId;
	private String menuName;
	private String menuCaption;
	private String menuUri;
	private String menuIcon;
	private int menuLevel;
	private int menuParent;
	private int menuOrder;
	private boolean disabled;
	private String menuSclass="";
	
	public MenuBean() {
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuCaption() {
		return menuCaption;
	}

	public void setMenuCaption(String menuCaption) {
		this.menuCaption = menuCaption;
	}

	public String getMenuUri() {
		return menuUri;
	}

	public void setMenuUri(String menuUri) {
		this.menuUri = menuUri;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public int getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(int menuLevel) {
		this.menuLevel = menuLevel;
	}

	public int getMenuParent() {
		return menuParent;
	}

	public void setMenuParent(int menuParent) {
		this.menuParent = menuParent;
	}

	public int getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(int menuOrder) {
		this.menuOrder = menuOrder;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getMenuSclass() {
		return menuSclass;
	}

	public void setMenuSclass(String menuSclass) {
		this.menuSclass = menuSclass;
	}
	
}
