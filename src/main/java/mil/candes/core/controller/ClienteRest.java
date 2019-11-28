package mil.candes.core.controller;

import java.io.IOException;

import java.util.Arrays;

import java.util.List;

import org.apache.commons.logging.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mil.candes.core.configuration.Indexs;
import mil.candes.core.configuration.Routes;
import mil.candes.core.configuration.Tools;
import mil.candes.core.model.Destino;
import mil.candes.core.model.Mm;
import mil.candes.core.model.MmListado;
import mil.candes.core.model.Precedencia;
import mil.candes.core.model.Promotor;
import mil.candes.core.model.Seguridad;

@Controller
public class ClienteRest {

	public ClienteRest() {
	}

	private boolean validarRespuetaOk(ResponseEntity<String> response) {
		return response.getStatusCode() == HttpStatus.OK ? true : false;
	}

	public List<MmListado> getMensajesMilitares() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> mensajesJson = restTemplate.getForEntity(Routes.API_GET_MENSAJES_MILITARES,
				String.class);
		if (validarRespuetaOk(mensajesJson)) {
			try {
				MmListado[] mensajesMilitaresArr = new ObjectMapper().readValue(mensajesJson.getBody().toString(),
						MmListado[].class);
				return Arrays.asList(mensajesMilitaresArr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Mm getMensajeMilitar(long idMensajeMilitar) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> jsonMensajeMilitar = restTemplate
				.getForEntity(Routes.API_GET_MENSAJE_MILITAR + idMensajeMilitar, String.class);
		try {
			return new ObjectMapper().readValue(jsonMensajeMilitar.getBody().toString(), Mm.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Mm();
	}

	public Destino[] getDestinos() throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> destinosJson = restTemplate.getForEntity(Routes.API_DESTINOS, String.class);
		if (validarRespuetaOk(destinosJson)) {
			try {
				Destino[] destinos = new ObjectMapper().readValue(destinosJson.getBody().toString(), Destino[].class);
				return destinos;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public Destino getDestino(String descripcion) throws JSONException {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> destinosJson = restTemplate.getForEntity(Routes.API_DESTINO + "/" + descripcion,
				String.class);
		if (validarRespuetaOk(destinosJson)) {
			try {
				Destino destino = new ObjectMapper().readValue(destinosJson.getBody().toString(), Destino.class);
				return destino;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
				e.printStackTrace();
			}
		}

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

				e.printStackTrace();
			}
		}

		return null;
	}

	public Promotor getPromotor(String descripcion) {
		RestTemplate restemplate = new RestTemplate();
		ResponseEntity<String> promotorJson = restemplate.getForEntity(Routes.API_GET_PROMOTOR + "/" + descripcion,
				String.class);
		try {
			Promotor promotor = new ObjectMapper().readValue(promotorJson.getBody().toString(), Promotor.class);
			return promotor;
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	public Promotor getPromotor(long id) {
		RestTemplate restemplate = new RestTemplate();
		ResponseEntity<String> promotorJson = restemplate.getForEntity(Routes.API_PROMOTOR + "{" + id + "}",
				String.class);
		try {
			Promotor promotor = new ObjectMapper().readValue(promotorJson.getBody().toString(), Promotor.class);
			return promotor;
		} catch (IOException e) {

			e.printStackTrace();
		}

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

				e.printStackTrace();
			}
		}

		return null;

	}

	public Seguridad getSeguridad(long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> seguridadJson = restTemplate.getForEntity(Routes.API_SEGURIDAD + "/" + id, String.class);
		if (validarRespuetaOk(seguridadJson)) {
			try {
				Seguridad seguridad = new ObjectMapper().readValue(seguridadJson.getBody().toString(), Seguridad.class);
				return seguridad;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ResponseEntity<String> guardarEntidadMM(Mm mensaje) {

		RestTemplate restTemplate = new RestTemplate();
		String mensajeJson = "";
		try {
			mensajeJson = new ObjectMapper().writeValueAsString(mensaje);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		ResponseEntity<String> responseJson = restTemplate.postForEntity(Routes.API_GUARDAR_MM, mensajeJson,
				String.class);
		return responseJson;
	}

	public boolean guardarMensajeDesdePDF(List<Object> mensajeMilitarDesarmado) {

		JSONObject mensajeDesarmadoJSON = new JSONObject();
		try {

			mensajeDesarmadoJSON.put("promotor", mensajeMilitarDesarmado.get(Indexs.promotor));
			mensajeDesarmadoJSON.put("ejecutivos", mensajeMilitarDesarmado.get(Indexs.ejecutivos));
			mensajeDesarmadoJSON.put("informativos", mensajeMilitarDesarmado.get(Indexs.informativos));
			mensajeDesarmadoJSON.put("texto", mensajeMilitarDesarmado.get(Indexs.texto));
			mensajeDesarmadoJSON.put("precedencia", mensajeMilitarDesarmado.get(Indexs.precedencia));
			mensajeDesarmadoJSON.put("seguridad", mensajeMilitarDesarmado.get(Indexs.seguridad));
			mensajeDesarmadoJSON.put("GFH", mensajeMilitarDesarmado.get(Indexs.GFH));
			mensajeDesarmadoJSON.put("NC", mensajeMilitarDesarmado.get(Indexs.NC));
			mensajeDesarmadoJSON.put("NR", mensajeMilitarDesarmado.get(Indexs.NR));
			mensajeDesarmadoJSON.put("adjuntos", mensajeMilitarDesarmado.get(Indexs.adjuntos));
			mensajeDesarmadoJSON.put("transmitio", mensajeMilitarDesarmado.get(Indexs.transmitio));
			
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responseJson = restTemplate.postForEntity(Routes.API_GUARDAR_MM_DESDE_PDF, mensajeDesarmadoJSON.toString(), String.class);

		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public ResponseEntity<String> guardarPdfMM(MultipartFile archivo, long idMM) throws IOException {

//		String mensajeArchivoJson = new ObjectMapper().writeValueAsString(archivo.getInputStream());

		MultiValueMap<String, Object> parametros = new LinkedMultiValueMap<String, Object>();
		parametros.add("idMensajeMilitar", Long.toString(idMM));
		parametros.add("file", archivo);

		RestTemplate restTemplate = new RestTemplate();
//		System.out.println(mensajeArchivoJson);
		ResponseEntity<String> responseJson = restTemplate.postForEntity(Routes.API_GUARDAR_ARCHIVO_MM, parametros,
				String.class);
		return responseJson;
	}

//	public ResponseEntity<String> cargarMmDesdePdf(List<Mm> mensajes){
//		
//		
//		ResponseEntity<String> responseJson = restTemplate.postForEntity(Routes.rutaGuardarArchivoMM(idMM),mensajeArchivoJson, String.class);
//		return responseJson;
//	}

}
