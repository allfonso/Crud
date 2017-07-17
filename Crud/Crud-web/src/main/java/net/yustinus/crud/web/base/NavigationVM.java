package net.yustinus.crud.web.base;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

import net.yustinus.crud.backend.dto.MenuDto;

public class NavigationVM {
	
	//private String contentUri = "/WEB-INF/pages/home.zul";
	private MenuDto selectedMenu;
		
	@GlobalCommand("navigation")
	@NotifyChange({"contentUri","selectedMenu"})
	public void nav(@BindingParam("menu") MenuDto selectedMenu) {
		this.selectedMenu = selectedMenu;
		System.out.println("NavigationVM : "+this.selectedMenu.getMenuCaption());
	}		
	
	public String getContentUri() {
		if (selectedMenu == null)
			return "/WEB-INF/pages/home.zul";
		else 
			return "/WEB-INF/pages"+selectedMenu.getMenuUri()+".zul";
	}

	public MenuDto getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(MenuDto selectedMenu) {
		this.selectedMenu = selectedMenu;
	}
}
