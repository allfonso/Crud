package net.yustinus.crud.backend.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.yustinus.crud.backend.beans.MenuDto;
import net.yustinus.crud.backend.services.MenuService;
import net.yustinus.crud.backend.testutils.BasicTest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext-backend-test.xml" })
public class MenuTest extends BasicTest{
	
	@Autowired
	private MenuService menuService;

	@Test
	public void getAllMenu() {
		
		List<MenuDto> menus = menuService.getAllMenus();		
		Assert.assertEquals(8, menus.size());
	}
}
