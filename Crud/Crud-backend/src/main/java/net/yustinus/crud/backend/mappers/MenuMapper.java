package net.yustinus.crud.backend.mappers;

import java.util.List;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.dto.MenuDto;

public interface MenuMapper {

	public List<MenuBean> selectAllMenus();
	
	public MenuDto selectMenu(int menuId);
	
	public List<MenuDto> selectBreadcrumb(int childMenuId);
}
