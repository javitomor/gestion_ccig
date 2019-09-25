package mil.candes.core.repository;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mil.candes.core.controller.ClienteRest;
import mil.candes.core.model.Promotor;

@Repository("promotorRepository")
public class PromotorRepository {
	
	@Autowired
	ClienteRest api;
	
public Promotor[] getPromotores() {
	
	try {
		Promotor[] promotores = api.getPromotores();
		return promotores;
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
}
}
