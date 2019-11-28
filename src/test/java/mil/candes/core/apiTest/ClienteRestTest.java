package mil.candes.core.apiTest;

import static org.junit.Assert.*;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.pdfbox.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;


import mil.candes.core.controller.CcigController;
import mil.candes.core.controller.ClienteRest;
import mil.candes.core.model.Mm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRestTest {

	CcigController controlador = new CcigController();

	ClienteRest clienteRest = new ClienteRest();

	@Test
	public void guardarPdfMMTest() throws IOException {
		long[] ejecutivos=new long[2];
		ejecutivos[0]=1;
		ejecutivos[1]=2;
		long[] informativos = new long[2];
		informativos[0]=3;
		informativos[1]=4;
		Path path = Paths.get("/Users/javiermoreno/Downloads/mm/1044.PDF");
		String name = "1044";
		String contentType = "application/pdf";
		
		File file = new File(path.toString());
		FileInputStream input = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile(name, file.getName(), contentType,
				IOUtils.toByteArray(input));

		Mm mensaje = new Mm();
//		mensaje.setPrecedencia(1L);
//		mensaje.setSeguridad(1L);
//		mensaje.setGrupoFechaHora("051558nov19");
//		mensaje.setNumeroRegistro(12L);
//		mensaje.setNumeroControl(13L);
//		mensaje.setNumeroFolio(14L);
//		mensaje.setPromotor(1L);
//		mensaje.setEjecutivos(ejecutivos);
//		mensaje.setInformativos(informativos);
//		mensaje.setTexto("texto del mensaje");
		
		try {
			assertEquals(controlador.guardarMM(mensaje, multipartFile), "/ccig/mm/carga_exitosa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
