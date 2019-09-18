package mil.candes.core.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import mil.candes.core.configuration.Pages;
import mil.candes.core.configuration.Tools;
import mil.candes.core.model.Destino;
import mil.candes.core.model.Mm;
import mil.candes.core.model.Precedencia;
import mil.candes.core.model.Promotor;
import mil.candes.core.model.Seguridad;

@Controller
public class CcigController {

	private Log logger = Tools.getLog(CcigController.class);

	@Autowired
	ClienteRest clienteRest;

	private ArrayList<Object> getDatosCargaMM() {
		try {
			ArrayList<Object> datos = new ArrayList<>();

			Destino[] destinos = clienteRest.getDestinos();
			Precedencia[] precedencias = clienteRest.getPrecedencias();
			Promotor[] promotores = clienteRest.getPromotores();
			Seguridad[] seguridades = clienteRest.getSeguridades();

			datos.add(0,destinos);
			datos.add(1, precedencias);
			datos.add(2, promotores);
			datos.add(3, seguridades);

			return datos;
		} catch (JSONException e) {
			logger.error("No se pudo recuperar los DATOS de CARGA");
			e.printStackTrace();
		}
		return null;
	}

	public List<Mm> getMms() {

		ArrayList<Mm> mm = new ArrayList<>();

		mm.add(new Mm(1, 1, 5, 1, "26AGO19", "texto del mensaje", "direccion/pdf", LocalDate.now(), "RUTINA", "PUBLICO",
				"CCIG", "CCIG", "CCIG"));
		mm.add(new Mm(2, 2, 6, 1, "26AGO19", "texto del mensaje", "direccion/pdf", LocalDate.now(), "RUTINA", "PUBLICO",
				"CCIG", "CCIG", "CCIG"));
		mm.add(new Mm(3, 3, 7, 1, "26AGO19", "texto del mensaje", "direccion/pdf", LocalDate.now(), "RUTINA", "PUBLICO",
				"CCIG", "CCIG", "CCIG"));
		mm.add(new Mm(4, 4, 8, 1, "26AGO19", "texto del mensaje", "direccion/pdf", LocalDate.now(), "RUTINA", "PUBLICO",
				"CCIG", "CCIG", "CCIG"));

		return mm;

	}

	
	public ModelAndView cargarMM() {
		ModelAndView mav = new ModelAndView(Pages.ccigCargarMM);
		ArrayList<Object> datos = new ArrayList<>();
		datos = getDatosCargaMM();
		
		List<Destino> destinos = new ArrayList<>();
		for(Destino destino : (Destino[]) datos.get(0)) {
			destinos.add(destino);
		}
		
		List<Precedencia> precedencias = new ArrayList<>();
		for(Precedencia precedencia : (Precedencia[]) datos.get(1)) {
			precedencias.add(precedencia);
		}
		
		List<Promotor> promotores = new ArrayList<>();
		for(Promotor promotor : (Promotor[]) datos.get(2)) {
			promotores.add(promotor);
		}
		
		List<Seguridad> seguridades = new ArrayList<>();
		for(Seguridad seguridad : (Seguridad[]) datos.get(3)) {
			seguridades.add(seguridad);
		}
		
		mav.addObject("destinos", destinos);
		mav.addObject("precedencias", precedencias);
		mav.addObject("promotores", promotores);
		mav.addObject("seguridades", seguridades);
		
		return mav;

	}

	public ModelAndView mostrarMM() {
		// model.addAttribute("mm", getMms());
		return new ModelAndView();
	}
}
