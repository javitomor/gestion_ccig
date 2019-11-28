package mil.candes.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mil.candes.core.model.Seguridad;
import mil.candes.core.repository.SeguridadRepository;

@Service("seguridadService")
public class SeguridadService {
	
	@Autowired
	SeguridadRepository seguridadRepository;
	
	public List<Seguridad> getSeguridades(){
		List<Seguridad> seguridades = new ArrayList<>();
		for (Seguridad seguridad : seguridadRepository.getSeguridades()) {
			seguridades.add(seguridad);
		}
		return seguridades;
	}

}
