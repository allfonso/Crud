package net.yustinus.crud.web.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {		
	
	@RequestMapping(value={"/login","/"}, method={RequestMethod.GET, RequestMethod.POST})
	public String login() {	
		System.out.println("request mapping : login");
		return "login.zul";
	}
	
	@RequestMapping(value="/welcome", method={RequestMethod.GET, RequestMethod.POST})
	public String welcome() {	
		System.out.println("request mapping : welcome");
		return "index.zul";
	}
	
}
