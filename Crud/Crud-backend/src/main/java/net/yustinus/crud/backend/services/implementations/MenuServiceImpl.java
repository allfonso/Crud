package net.yustinus.crud.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.dto.MenuDto;
import net.yustinus.crud.backend.mappers.MenuMapper;
import net.yustinus.crud.backend.services.MenuService;

@Service("menuService")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;

	@Override	
	public List<MenuBean> getAllMenus() {
		return this.menuMapper.selectAllMenus();
	}

	@Override
	public MenuDto getMenu(int menuId) {
		return this.menuMapper.selectMenu(menuId);
	}

	@Override
	public List<MenuDto> getBreadcrumb(int childMenuId) {
		return this.menuMapper.selectBreadcrumb(childMenuId);
	}

}
