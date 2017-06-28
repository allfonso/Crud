package net.yustinus.crud.backend.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.beans.MenuDto;
import net.yustinus.crud.backend.mappers.MenuMapper;
import net.yustinus.crud.backend.services.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuMapper menuMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<MenuDto> getAllMenus() {
		return this.menuMapper.selectAllMenus();
	}

	@Override
	public MenuBean getMenu(int menuId) {
		return this.menuMapper.selectMenu(menuId);
	}

}
