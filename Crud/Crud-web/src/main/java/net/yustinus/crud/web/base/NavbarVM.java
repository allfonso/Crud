package net.yustinus.crud.web.base;

import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.zk.ui.Executions;

public class NavbarVM {
	
	@GlobalCommand("logout")
	public void logout() {
		Executions.sendRedirect("/login?logout");
	}

}
