package net.yustinus.crud.backend.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.beans.MenuItemBean;
import net.yustinus.crud.backend.dto.MenuDto;
import net.yustinus.crud.backend.services.MenuService;
import net.yustinus.crud.backend.testutils.BasicTest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext-backend-test.xml" })
public class MenuTest extends BasicTest {

	@Autowired
	private MenuService menuService;

	@Test
	public void getAllMenu() {
		List<MenuBean> menus = menuService.getAllMenus();	
		for (MenuBean mb : menus) {
			System.out.println("Header ID : "+mb.getHeaderMenu().getMenuId());
			System.out.println("Header Name : "+mb.getHeaderMenu().getMenuName());
			for(MenuItemBean mainMenu : mb.getMenus()) {
				System.out.println("\t main menu ID : "+mainMenu.getParentMenu().getMenuId());
				System.out.println("\t main menu Name : "+mainMenu.getParentMenu().getMenuName());
				for (MenuDto cm : mainMenu.getChildMenu()) {
					System.out.println("\t \t child menu ID : "+cm.getMenuId());
					System.out.println("\t \t child menu Name : "+cm.getMenuName());
				}
			}
		}
		Assert.assertEquals(2, menus.size());
	}

	@Test
	public void getBreadcrumb() {
		List<MenuDto> menus = menuService.getBreadcrumb(12);
		Assert.assertEquals(4, menus.size());
	}
}
