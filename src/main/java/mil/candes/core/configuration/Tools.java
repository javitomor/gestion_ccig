package mil.candes.core.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class Tools {

	
	public static Log getLog(Object clase) {
		return LogFactory.getLog(clase.getClass());
	}
}
