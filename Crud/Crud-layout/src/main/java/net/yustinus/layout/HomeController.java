package net.yustinus.layout;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(value="/",method = {RequestMethod.GET, RequestMethod.POST})
	public String homeMapping(Map<String, Object> model) {
		//ModelAndView model = new ModelAndView("home");
		System.out.println("yustinus");
		return "home.zul";		
	}

}
