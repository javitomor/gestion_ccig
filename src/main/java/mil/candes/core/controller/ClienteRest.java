package mil.candes.core.controller;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.json.JSONException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import mil.candes.core.configuration.Routes;
import mil.candes.core.configuration.Tools;
import mil.candes.core.model.Destino;
import mil.candes.core.model.Precedencia;
import mil.candes.core.model.Promotor;
import mil.candes.core.model.Seguridad;

@Controller
public class ClienteRest {

	private Log logger = Tools.getLog(CcigController.class);

	private boolean validarRespuetaOk(ResponseEntity<String> response) {
		return response.getStatusCode() == HttpStatus.OK ? true : false;
	}

	public String getMensajesMilitares() {
		return "";
	}

	public Destino[] getDestinos() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> destinosJson = restTemplate.getForEntity(Routes.API_DESTINOS, String.class);
		if (validarRespuetaOk(destinosJson)) {
			try {
				Destino[] destinos = new ObjectMapper().readValue(destinosJson.getBody().toString(), Destino[].class);
				return destinos;
			} catch (IOException e) {
				logger.error("No se pudo obtener los datos de DESTINOS");
				e.printStackTrace();
			}
		}
		logger.error("No se pudo obtener los datos de DESTINOS");
		return null;
	}

	public Precedencia[] getPrecedencias() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> precedenciasJson = restTemplate.getForEntity(Routes.API_PRECEDENCIAS, String.class);
		if (validarRespuetaOk(precedenciasJson)) {
			try {
				Precedencia[] precedencias = new ObjectMapper().readValue(precedenciasJson.getBody().toString(),
						Precedencia[].class);
				return precedencias;
			} catch (IOException e) {
				logger.error("No se pudo obtener los datos de PRECEDENCIAS");
				e.printStackTrace();
			}
		}
		logger.error("No se pudo obtener los datos de PRECEDENCIAS");
		return null;
	}

	public Promotor[] getPromotores() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> promotoresJson = restTemplate.getForEntity(Routes.API_PROMOTORES, String.class);
		if (validarRespuetaOk(promotoresJson)) {
			try {
				Promotor[] promotores = new ObjectMapper().readValue(promotoresJson.getBody().toString(),
						Promotor[].class);
				return promotores;
			} catch (IOException e) {
				logger.error("No se pudo cargar los datos de PROMOTORES");
				e.printStackTrace();
			}
		}
		logger.error("No se pudo cargar los datos de PROMOTORES");
		return null;
	}

	public Seguridad[] getSeguridades() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> seguridadesJson = restTemplate.getForEntity(Routes.API_SEGURIDADES, String.class);
		if (validarRespuetaOk(seguridadesJson)) {
			try {
				Seguridad[] seguridades = new ObjectMapper().readValue(seguridadesJson.getBody().toString(),
						Seguridad[].class);
				return seguridades;
			} catch (IOException e) {
				logger.error("No se pudo cargar los datos de SEGURIDADES");
				e.printStackTrace();
			}
		}
		logger.error("No se pudo cargar los datos de SEGURIDADES");
		return null;

	}

}
