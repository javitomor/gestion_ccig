package mil.candes.core.entity;

public class PromotorEntity {
	
	private long id;
	private String descripcion;
	private String correo;

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

	public PromotorEntity(long id, String descripcion, String correo) {
		this.id = id;
		this.descripcion = descripcion;
		this.correo = correo;
	}

	public PromotorEntity() {
	}
	

}
