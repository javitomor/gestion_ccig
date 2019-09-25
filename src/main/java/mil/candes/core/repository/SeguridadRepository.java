package mil.candes.core.repository;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mil.candes.core.controller.ClienteRest;
import mil.candes.core.model.Seguridad;

@Repository("seguridadRepository")
public class SeguridadRepository {
	
	@Autowired
	ClienteRest api;
	
	public Seguridad[] getSeguridades() {
		
		try {
			Seguridad[] seguridades = api.getSeguridades();
			return seguridades;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
