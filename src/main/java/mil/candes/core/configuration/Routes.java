package mil.candes.core.configuration;

public class Routes {
	
	//API
	public final static String API_HOST ="http://localhost:8090/api";
	public final static String API_DATOS_CARGA_MM=API_HOST+"/datoscarga";
	public final static String API_DESTINOS = API_DATOS_CARGA_MM+"/destinos";
	public final static String API_PRECEDENCIAS=API_DATOS_CARGA_MM+"/precedencias";
	public final static String API_PROMOTORES=API_DATOS_CARGA_MM+"/promotores";
	public final static String API_SEGURIDADES=API_DATOS_CARGA_MM+"/seguridades";
	public final static String API_GUARDAR_MM = API_HOST+"/mm/guardar";
	
	//APP
	public final static String HOME = "/home";

	//CCIG
	public final static String ccigHome = "/ccig";
	public final static String mm = ccigHome+"/mm";
	public final static String cargarMM = mm + "/cargarmm";
	public final static String obtenerMM = mm + "/obtenermm";
	public final static String guardarMM = mm + "/guardarmm2";
}
