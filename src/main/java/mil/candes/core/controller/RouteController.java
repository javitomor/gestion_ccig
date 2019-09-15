package mil.candes.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mil.candes.core.configuration.Routes;

@Controller
@RequestMapping(Routes.HOME) // "/home"
public class RouteController {

	
	//   "/ccig"
	@Autowired
	@Qualifier("ccigController")
	CcigController ccigController;
	
	@GetMapping(Routes.mm) // "/home/ccig/mm
	public String ingresarMM() {
		return ccigController.ingresarMM();
	}
}
