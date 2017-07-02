package net.yustinus.crud.web.speciment;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class SpecimentVM {
	
	private String te;
	
	@Init
	@NotifyChange("te")
	public void init() {
		this.te = "yustinus";
	}
	
	@Command("test")
	@NotifyChange("te")
	public void test() {
		if(this.te.equalsIgnoreCase("yustinus"))
			this.te = "Nugroho";
		else 
			this.te = "Yustinus";
	}

	public String getTe() {
		return te;
	}

	public void setTe(String te) {
		this.te = te;
	}
	
}
