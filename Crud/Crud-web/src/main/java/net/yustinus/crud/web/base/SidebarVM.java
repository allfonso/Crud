package net.yustinus.crud.web.base;

import java.util.List;

import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.services.MenuService;

@VariableResolver(DelegatingVariableResolver.class)
public class SidebarVM {
	
	private List<MenuBean> listMenu;	
	
	@WireVariable
	private MenuService menuService;	

	public SidebarVM() {		
	}
	
	@Init
	@NotifyChange("menuService")
	public void init() {		
		this.setListMenu(menuService.getAllMenus());
	}

	public List<MenuBean> getListMenu() {
		return listMenu;
	}

	public void setListMenu(List<MenuBean> listMenu) {
		this.listMenu = listMenu;
	}	
	
}
