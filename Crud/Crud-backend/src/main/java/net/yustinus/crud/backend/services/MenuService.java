package net.yustinus.crud.backend.services;

import java.util.List;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.beans.MenuDto;

public interface MenuService {
	
	public List<MenuDto> getAllMenus();
	
	public MenuBean getMenu(int menuId);

}
