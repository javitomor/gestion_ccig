package mil.candes.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerBasic {

	@GetMapping(path = {"/home","/inicio"})
	public String home() {
		return "index";
	}
	
}
