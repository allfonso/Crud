package net.yustinus.crud.web.base;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;

public class NavigationVM {
	
	String includeSrc = "/WEB-INF/pages/page.zul";
	
	@GlobalCommand("navigation")
	@NotifyChange("includeSrc")
	public void nav(@BindingParam("includeSrc") String page) {
		includeSrc = "/WEB-INF/pages/"+page+".zul";
	}

	public String getIncludeSrc() {
		return includeSrc;
	}

	public void setIncludeSrc(String includeSrc) {
		this.includeSrc = includeSrc;
	}
	
	

}
