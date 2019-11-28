package mil.candes.core.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import mil.candes.core.configuration.Indexs;
import mil.candes.core.configuration.Pages;
import mil.candes.core.model.Mm;
import mil.candes.core.services.MensajeMilitarService;

@Controller
public class CcigController {

//	private Log logger = Tools.getLog(CcigController.class);

	@Autowired
	MensajeMilitarService mensajeMilitarService;

	@Autowired
	ClienteRest api;

//	public ModelAndView obtenerMM(@RequestParam(name = "id", required = true) long id) {
//		ModelAndView mav = new ModelAndView(Pages.ccigMostrarMM);
//
//		return mav;
//	}

	public ModelAndView mostrarParaCargarMM() {
		ModelAndView mav = new ModelAndView(Pages.ccigCargarMM);
		List<Object> datos = new ArrayList<>();
		datos = mensajeMilitarService.getDatosCargaMM();

		mav.addObject("mensajeMilitar", new Mm());
		mav.addObject("destinos", datos.get(Indexs.index_destinos));
		mav.addObject("precedencias", datos.get(Indexs.index_precedencias));
		mav.addObject("promotores", datos.get(Indexs.index_promotores));
		mav.addObject("seguridades", datos.get(Indexs.index_seguridades));

		return mav;

	}

	public ModelAndView mostrarListaMM() {
		ModelAndView mav = new ModelAndView(Pages.ccigIndex);
		mav.addObject("mensajesMilitares", mensajeMilitarService.getMensajesMilitares());
		return mav;
	}

	public String guardarMM(Mm mensaje, MultipartFile archivo) {
		return mensajeMilitarService.guardarMM(mensaje, archivo);
	}

	public ModelAndView mostrarMensajeMilitar(long idMensajeMilitar) {
		return new ModelAndView(Pages.ccigMostrarMM).addObject("mensajeMilitar",
				mensajeMilitarService.obtenerMensajeMilitar(idMensajeMilitar));

	}

	public ModelAndView cargarPDF() throws InvalidPasswordException, IOException {
		String ruta = "/Users/javiermoreno/Downloads/mm/";
		boolean cargados = mensajeMilitarService.cargarMmDesdePdf(ruta);

		if (cargados) {
			return new ModelAndView(Pages.ccigCargarExitosa);
		} else {
			return new ModelAndView(Pages.ccigCargarFallida);
		}

	}
}
