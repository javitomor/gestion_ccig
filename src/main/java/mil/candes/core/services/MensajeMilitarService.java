package mil.candes.core.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mil.candes.core.configuration.Indexs;
import mil.candes.core.configuration.Pages;
import mil.candes.core.controller.ClienteRest;
import mil.candes.core.model.Destino;
import mil.candes.core.model.Mm;
import mil.candes.core.model.MmListado;
import mil.candes.core.model.Precedencia;
import mil.candes.core.model.Promotor;
import mil.candes.core.model.Seguridad;
import mil.candes.core.repository.MmRepository;

@Service("mensajeMilitarService")
public class MensajeMilitarService {

	@Autowired
	ClienteRest clienteRest;
	@Autowired
	MmRepository mmRepository;
	@Autowired
	DestinoService destinoService;
	@Autowired
	PrecedenciaService precedenciaService;
	@Autowired
	PromotorService promotorService;
	@Autowired
	SeguridadService seguridadService;

	public String guardarMM(Mm mensaje, MultipartFile archivo) {
		try {
			ResponseEntity<String> respuestaGuardarEntidadMM = clienteRest.guardarEntidadMM(mensaje);
			if (respuestaGuardarEntidadMM.getStatusCode() == HttpStatus.CREATED) {

				long idMensajeMilitar = Long.parseLong(respuestaGuardarEntidadMM.getBody().toString());

				ResponseEntity<String> respuestaGuardarArchivoMM = clienteRest.guardarPdfMM(archivo, idMensajeMilitar);

				if ((respuestaGuardarEntidadMM.getStatusCode() == HttpStatus.CREATED)) {
					return Pages.ccigCargarExitosa;
				} else {
					return respuestaGuardarArchivoMM.getBody();
				}
			} else {
				return respuestaGuardarEntidadMM.getBody();
			}
		} catch (Exception e) {
			System.out.println("no se guardo nada");
			e.printStackTrace();

		}
		return "no se pudo guardar";
	}

	public List<MmListado> getMensajesMilitares() {
		List<MmListado> mensajesMilitaresListado = new ArrayList<MmListado>();
		for (MmListado mensaje : mmRepository.getMensajesMulitares()) {
			mensajesMilitaresListado.add(mensaje);
		}
		return mensajesMilitaresListado;
	}

	public List<Object> getDatosCargaMM() {
		List<Object> datos = new ArrayList<>();
		List<Destino> destinos = destinoService.getDestinos();
		List<Precedencia> precedencias = precedenciaService.getPrecedencias();
		List<Promotor> promotores = promotorService.getPromotores();
		List<Seguridad> seguridades = seguridadService.getSeguridades();
		datos.add(Indexs.index_destinos, destinos);
		datos.add(Indexs.index_precedencias, precedencias);
		datos.add(Indexs.index_promotores, promotores);
		datos.add(Indexs.index_seguridades, seguridades);
		return datos;

	}

	public Mm obtenerMensajeMilitar(long idMensajeMilitar) {
		return mmRepository.getMensajeMilitar(idMensajeMilitar);
	}

	public boolean cargarMmDesdePdf(String rutaDirectorioFuente) {

		boolean respuesta = false;
		PDFTextStripper pdfStripper;
		try {
			pdfStripper = new PDFTextStripper();

			File dir = new File(rutaDirectorioFuente);
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.getName().endsWith(".PDF") || file.getName().endsWith(".pdf")) {

					PDDocument pdDocument = PDDocument.load(file);
					String text = pdfStripper.getText(pdDocument);
					pdDocument.close();
					String lineas[] = text.split("\n");
					respuesta = mmRepository.guardarMensajeDesdePdf(desarmarMensajePDF(lineas));

				}
			}

		} catch (IOException e) {
			e.printStackTrace();
			respuesta = false;
		}
		return respuesta;

	}

	public List<Object> desarmarMensajePDF(String[] lineasMensajePDF) {
		String linea = "";
		String texto = "";
		String strDatosSeguridad[] = null;
		List<Object> mensajeMilitarDesarmado = new ArrayList<Object>();

		for (int i = 0; i < lineasMensajePDF.length; i++) {
			linea = lineasMensajePDF[i];
			if (linea.contains("PROMOTOR:")) {
				mensajeMilitarDesarmado.add(Indexs.promotor, linea.substring(10, linea.length()));
			}

			if (linea.contains("EJECUTIVOS:")) {
				mensajeMilitarDesarmado.add(Indexs.ejecutivos, linea.substring(12, linea.length()).split(","));
			}

			if (linea.contains("INFORMATIVOS:")) {
				mensajeMilitarDesarmado.add(Indexs.informativos, linea.substring(14, linea.length()).split(","));
			}

			if (linea.contains("TEXTO") && linea.length() == 5) {
				boolean salidaBucle = true;
				while (salidaBucle) {
					i++;
					texto = texto + " " + lineasMensajePDF[i];
					if (lineasMensajePDF[i + 1].contains("PRECEDENCIA CLASIFICACION DE"))
						salidaBucle = false;
				}
				mensajeMilitarDesarmado.add(Indexs.texto, texto);
			}

			if (linea.contains("GFH NC NR")) {
				strDatosSeguridad = lineasMensajePDF[i + 1].split(" ");
				mensajeMilitarDesarmado.add(Indexs.precedencia, strDatosSeguridad[0]);
				mensajeMilitarDesarmado.add(Indexs.seguridad, strDatosSeguridad[1]);
				mensajeMilitarDesarmado.add(Indexs.GFH, strDatosSeguridad[2]);
				mensajeMilitarDesarmado.add(Indexs.NC, strDatosSeguridad[3]);
				mensajeMilitarDesarmado.add(Indexs.NR, strDatosSeguridad[4]);
			}
			if (linea.contains("ADJUNTOS:")) {
				mensajeMilitarDesarmado.add(Indexs.adjuntos, linea.substring(10, linea.length()).split(";"));
			}
			if (linea.contains("TRANSMITIO:")) {
				mensajeMilitarDesarmado.add(Indexs.transmitio, linea.substring(12, linea.length()));
			}

		}
		return mensajeMilitarDesarmado;

	}
}