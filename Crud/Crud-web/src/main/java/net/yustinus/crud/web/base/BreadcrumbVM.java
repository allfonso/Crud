package net.yustinus.crud.web.base;

import java.util.List;

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
	
	public BreadcrumbVM() {
		// TODO Auto-generated constructor stub
	}
	
	@Init
	@NotifyChange()
	public void init() {
		this.setBreadcrumb(menuService.getBreadcrumb(12));
	}

	public List<MenuDto> getBreadcrumb() {
		return breadcrumb;
	}

	public void setBreadcrumb(List<MenuDto> breadcrumb) {
		this.breadcrumb = breadcrumb;
	}

}
