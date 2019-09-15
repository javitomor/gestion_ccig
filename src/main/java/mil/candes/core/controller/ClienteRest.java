package mil.candes.core.controller;

//import static org.junit.Assert.assertThat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import mil.candes.core.configuration.Routes;

@Controller
public class ClienteRest {
	private boolean validarRespuetaOk(ResponseEntity response) {
		return response.getStatusCode() == HttpStatus.OK ? true :  false;
	}
	
public String getMensajesMilitares() {
	return "";
}


public ResponseEntity<String> getDatosCargaMM() {
	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> response = restTemplate.getForEntity(Routes.API_DATOS_CARGA_MM, String.class);
	return validarRespuetaOk(response)? response : null;
	
}



}
