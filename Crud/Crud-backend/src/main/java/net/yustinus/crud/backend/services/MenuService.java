package net.yustinus.crud.backend.services;

import java.util.List;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.dto.MenuDto;

public interface MenuService {
	
	public List<MenuBean> getAllMenus();
	
	public MenuDto getMenu(int menuId);
	
	public List<MenuDto> getBreadcrumb(int childMenuId);

}
