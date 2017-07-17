package net.yustinus.crud.web.base;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = { "/login", "/" }, method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView loginModel = new ModelAndView();
		if (error != null)
			loginModel.addObject("error", "Invalid Credentials.");
		if (logout != null) {
			loginModel.addObject("logout", "Sesion cleared.");
			SecurityContextHolder.clearContext();			
		}
		loginModel.setViewName("login.zul");
		System.out.println("request mapping : login");
		return loginModel;
	}

	@RequestMapping(value = "/welcome", method = { RequestMethod.GET, RequestMethod.POST })
	public String welcome() {
		System.out.println("request mapping : welcome");
		return "index.zul";
	}

}
