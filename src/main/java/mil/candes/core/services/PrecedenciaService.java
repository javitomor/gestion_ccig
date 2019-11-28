package mil.candes.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mil.candes.core.model.Precedencia;
import mil.candes.core.repository.PrecedenciaRepository;

@Service("precedenciaService")
public class PrecedenciaService {

	@Autowired
	PrecedenciaRepository precedenciaRepository;
	
	public List<Precedencia> getPrecedencias(){
		
		List<Precedencia> precedencias = new ArrayList<>();
		for (Precedencia precedencia : precedenciaRepository.getPrecedencias()) {
			precedencias.add(precedencia);
		}
		return precedencias;
	}
}
