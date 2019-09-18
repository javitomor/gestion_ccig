package mil.candes.core.model;



public class Destino {
	private long id;

	private String descripcion;

	private String correo;

	
	public Destino() {

	}
	

	public Destino(long id, String descripcion, String correo) {

		this.id = id;
		this.descripcion = descripcion;
		this.correo = correo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
