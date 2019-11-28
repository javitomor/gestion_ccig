package mil.candes.core.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mil.candes.core.controller.ClienteRest;
import mil.candes.core.model.Mm;
import mil.candes.core.model.MmListado;
import mil.candes.core.model.Promotor;
import mil.candes.core.model.Seguridad;

@Repository("mmRepository")
public class MmRepository {

//	@Autowired
	ClienteRest api = new ClienteRest();
	
	public List<MmListado> getMensajesMulitares() {
		return api.getMensajesMilitares();
	}
	
	public String  getSeguridad(long id) {
		Seguridad seguridad = api.getSeguridad(id);
		return seguridad.getDescripcion();
	}
	
	public String getPromotor(long id) {
		Promotor promotor = api.getPromotor(id);
		return promotor.getDescripcion();
	}
	
	public Mm getMensajeMilitar(long idMensajeMilitar) {
		return api.getMensajeMilitar(idMensajeMilitar);
	}
	
	public boolean guardarMensajeDesdePdf(List<Object> mensajeMilitarDesarmado) {
		
		return api.guardarMensajeDesdePDF(mensajeMilitarDesarmado);
	}
}
