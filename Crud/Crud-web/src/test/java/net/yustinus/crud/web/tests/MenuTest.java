package net.yustinus.crud.web.tests;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import net.yustinus.crud.backend.beans.MenuBean;
import net.yustinus.crud.backend.beans.MenuDto;
import net.yustinus.crud.backend.services.MenuService;
import net.yustinus.crud.web.testutils.BasicTest;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext-backend-test.xml" })
public class MenuTest extends BasicTest{
	
	@Autowired
	private MenuService menuService;

	@Test
	public void getAllMenu() {
		
		List<MenuDto> menus = menuService.getAllMenus();
		for (MenuDto md : menus) {
			System.out.println("Parent id : "+md.getParentId());
			System.out.println("Parent name : "+md.getParentMenu().getMenuName());
			System.out.println("Parent icon : "+md.getParentMenu().getMenuIcon());
			
			if (!md.getChildMenu().isEmpty()) {
				for (MenuBean mb : md.getChildMenu()) {
				System.out.println("\t Child id : "+mb.getMenuId());
				System.out.println("\t Child name : "+mb.getMenuName());
				System.out.println("\t Child icon : "+mb.getMenuIcon());
				}
			} 					
		}
		Assert.assertEquals(8, menus.size());
	}
}
