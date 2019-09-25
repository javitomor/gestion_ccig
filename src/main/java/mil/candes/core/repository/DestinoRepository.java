package mil.candes.core.repository;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mil.candes.core.controller.ClienteRest;
import mil.candes.core.model.Destino;

@Repository("destinoRepository")
public class DestinoRepository {

	@Autowired
	ClienteRest api;

	public Destino[] getDestinos() {

		try {
			Destino[] destinos = api.getDestinos();
			return destinos;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
