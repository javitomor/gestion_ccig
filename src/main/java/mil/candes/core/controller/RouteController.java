package mil.candes.core.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mil.candes.core.configuration.Pages;
import mil.candes.core.configuration.Routes;
import mil.candes.core.model.Mm;

@Controller
@RequestMapping(Routes.HOME) // "/home"
public class RouteController {

	// "/ccig"
	@Autowired
	@Qualifier("ccigController")
	CcigController ccigController;

	@GetMapping(path = Routes.indexMM) // "/home/ccig/mm/index
	public ModelAndView indexMM() {
		return ccigController.mostrarListaMM();
	}

	@GetMapping(path = Routes.cargarMM) // "/home/ccig/mm/cargarmm
	public ModelAndView cargarMM() {

		return ccigController.mostrarParaCargarMM();
	}

	@GetMapping(Routes.carga_exitosa)
	public String display() {
		return Pages.ccigCargarExitosa;
	}

	@PostMapping(Routes.guardarMM)
	public String guardarMM(@ModelAttribute Mm mensaje, @RequestParam("archivopdf") MultipartFile archivo) {
		return ccigController.guardarMM(mensaje, archivo);
	}
	
	
	@GetMapping(Routes.obtenerMM+"/{id}")
	public ModelAndView mostrarMensajeMilitar(@PathVariable("id") long idMensajeMilitar) {
		return ccigController.mostrarMensajeMilitar(idMensajeMilitar);
	}

//	@GetMapping(path = Routes.obtenerMM) // FALTA TERMINAR
//	public ModelAndView obtenerMM(long id) {
//		return ccigController.obtenerMM(id);
//	}
//	

	@GetMapping("cargarpdf")
	public ModelAndView cargarPDF() {
	try {
		return ccigController.cargarPDF();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	

}
