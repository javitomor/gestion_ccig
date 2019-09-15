package mil.candes.core.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mil.candes.core.configuration.Pages;
import mil.candes.core.configuration.Routes;
import mil.candes.core.configuration.Tools;
import mil.candes.core.model.Mm;

@Controller
public class CcigController {
	
	private Log logger = Tools.getLog(CcigController.class);
	
	@Autowired
	ClienteRest clienteRest;
	
	private void getDatosCargaMM() {
		clienteRest.getDatosCargaMM();
	}
	public List<Mm> getMms(){
		
		
		ArrayList<Mm> mm = new ArrayList<>();
		
		mm.add(new Mm(1,1,5,1,"26AGO19","texto del mensaje","direccion/pdf",LocalDate.now(),"RUTINA","PUBLICO","CCIG","CCIG","CCIG"));
		mm.add(new Mm(2,2,6,1,"26AGO19","texto del mensaje","direccion/pdf",LocalDate.now(),"RUTINA","PUBLICO","CCIG","CCIG","CCIG"));
		mm.add(new Mm(3,3,7,1,"26AGO19","texto del mensaje","direccion/pdf",LocalDate.now(),"RUTINA","PUBLICO","CCIG","CCIG","CCIG"));
		mm.add(new Mm(4,4,8,1,"26AGO19","texto del mensaje","direccion/pdf",LocalDate.now(),"RUTINA","PUBLICO","CCIG","CCIG","CCIG"));
		
		return mm;
		
	}
	
	public String ingresarMM() {	
		
		return Pages.ccigIndex;
	}
	
public ModelAndView mostrarMM() {
	//model.addAttribute("mm", getMms());
	return new ModelAndView();
}
}
