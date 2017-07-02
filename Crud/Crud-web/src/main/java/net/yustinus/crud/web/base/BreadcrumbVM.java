package net.yustinus.crud.web.base;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;

import net.yustinus.crud.backend.dto.MenuDto;
import net.yustinus.crud.backend.services.MenuService;

@VariableResolver(DelegatingVariableResolver.class)
public class BreadcrumbVM {

	@WireVariable
	private MenuService menuService;
	private List<MenuDto> breadcrumb;
	private MenuDto selectedMenu;

	public BreadcrumbVM() {
		// TODO Auto-generated constructor stub
	}

	@Init
	@NotifyChange({ "breadcrumb", "selectedMenu" })
	public void init(@BindingParam("smenu") MenuDto selectedMenu) {
		if (selectedMenu == null)
			breadcrumb = menuService.getBreadcrumb(1);
		else {
			this.selectedMenu = selectedMenu;
			breadcrumb = menuService.getBreadcrumb(selectedMenu.getMenuId());
		}
	}

	public List<MenuDto> getBreadcrumb() {
		return breadcrumb;
	}

	public void setBreadcrumb(List<MenuDto> breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

	public MenuDto getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(MenuDto selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

}
