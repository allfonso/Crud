package net.yustinus.crud.backend.mappers;

import java.util.List;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.beans.MenuDto;

public interface MenuMapper {

	public List<MenuDto> selectAllMenus();
	
	public MenuBean selectMenu(int menuId);
}
