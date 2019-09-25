package mil.candes.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mil.candes.core.configuration.Routes;
import mil.candes.core.model.Mm;

@Controller
@RequestMapping(Routes.HOME) // "/home"
public class RouteController {

	// "/ccig"
	@Autowired
	@Qualifier("ccigController")
	CcigController ccigController;

//	CcigController ccigController = new CcigController();
	
	@GetMapping(path = Routes.cargarMM) // "/home/ccig/mm/cargarmm
	public ModelAndView cargarMM() {
//		System.out.println("1a");
		return ccigController.cargarMM();
	}

	@GetMapping(path = Routes.obtenerMM) // FALTA TERMINAR
	public ModelAndView obtenerMM(long id) {
		return ccigController.obtenerMM(id);
	}

	@PostMapping(Routes.guardarMM)
	public String guardarMM(@ModelAttribute Mm mensaje) {
		
//		System.out.println(mensajeMilitar);
		try {
			return ccigController.putMM(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
