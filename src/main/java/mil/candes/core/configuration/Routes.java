package mil.candes.core.configuration;

//Rutas CCIG Gestion
public class Routes {
	
	//API
	public final static String API_HOST ="http://localhost:8090/api";
	public final static String API_DATOS_CARGA_MM=API_HOST+"/datoscarga";
	public final static String API_DESTINOS = API_DATOS_CARGA_MM+"/destinos/all";
	public final static String API_DESTINO = API_DATOS_CARGA_MM+"/destinos";
	public final static String API_PRECEDENCIAS=API_DATOS_CARGA_MM+"/precedencias";
	public final static String API_PROMOTORES=API_DATOS_CARGA_MM+"/promotor/all";
	public final static String API_SEGURIDADES=API_DATOS_CARGA_MM+"/seguridades";
	public final static String API_SEGURIDAD= API_HOST+"/mm/seguridad/";
	public final static String API_PROMOTOR=API_HOST+"/mm/promotor/";
	public final static String API_GUARDAR_MM = API_HOST+"/mm/guardarentidad";
	public final static String API_GUARDAR_MM_DESDE_PDF=API_HOST+"/mm/guardardesdepdf";
	public final static String API_GUARDAR_ARCHIVO_MM = API_HOST+"/mm/guardararchivo";
	public final static String API_CARGAR_MM_DESDE_PDF = API_HOST+"/mm/cargardepdf";
	public final static String API_GET_PROMOTOR = API_HOST+"/promotor/{descripcion}";
	public final static String API_GET_MENSAJES_MILITARES = API_HOST + "/mm/all";
	public final static String API_GET_MENSAJE_MILITAR = API_HOST+"/mm/";
	
	//APP
	public final static String HOME = "/home";

	//CCIG
	public final static String ccigHome = "/ccig";
	public final static String mm = ccigHome+"/mm";
	public final static String indexMM = mm+"/index";
	public final static String cargarMM = mm + "/cargarmm";
	public final static String obtenerMM = mm + "/obtenermm";
	public final static String guardarMM = mm + "/guardarmm";
	public final static String carga_exitosa = mm + "/display";
	
	
	public static String rutaGuardarArchivoMM(long idMM) {
		return API_GUARDAR_ARCHIVO_MM+"/{"+idMM+"}";
	}
}
