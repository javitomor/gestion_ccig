package mil.candes.core.repository;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mil.candes.core.controller.ClienteRest;
import mil.candes.core.model.Precedencia;

@Repository("precedenciaRepository")
public class PrecedenciaRepository {
	
	@Autowired
	ClienteRest api;
	public Precedencia[] getPrecedencias() {
		
	try {
		Precedencia[] precedencias = api.getPrecedencias();
		return precedencias;
	} catch (JSONException e) {
		System.out.println("no se pudo cargar precedencias");
		e.printStackTrace();
	}
	return null;
	}
}
