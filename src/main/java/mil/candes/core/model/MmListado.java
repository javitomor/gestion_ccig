package mil.candes.core.model;


import java.util.Date;
import mil.candes.core.repository.MmRepository;

public class MmListado {
	
	
	MmRepository repositorio = new MmRepository();
	
	private long id;
	private long nr;
	private long nc;
	private long folio;
	private String gfh;
	private String texto;
	private String urlPdf;
	private Date fecha;
	
	private String precedencia;
	private String seguridad;
	private String promotor;
	private String[] ejecutivos;
	private String[] informativos;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNr() {
		return nr;
	}
	public void setNr(long nr) {
		this.nr = nr;
	}
	public long getNc() {
		return nc;
	}
	public void setNc(long nc) {
		this.nc = nc;
	}
	public long getFolio() {
		return folio;
	}
	public void setFolio(long folio) {
		this.folio = folio;
	}
	public String getGfh() {
		return gfh;
	}
	public void setGfh(String gfh) {
		this.gfh = gfh;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrlPdf() {
		return urlPdf;
	}
	public void setUrlPdf(String urlPdf) {
		this.urlPdf = urlPdf;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getPrecedencia() {
		return precedencia;
	}
	public void setPrecedencia(String precedencia) {
		this.precedencia = precedencia;
	}
	public String getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(String seguridad) {
		this.seguridad = seguridad;
	}
	public String getPromotor() {
		return promotor;
	}
	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}
	public String[] getEjecutivos() {
		return ejecutivos;
	}
	public void setEjecutivos(String[] ejecutivos) {
		this.ejecutivos = ejecutivos;
	}
	public String[] getInformativos() {
		return informativos;
	}
	public void setInformativos(String[] informativos) {
		this.informativos = informativos;
	}
//	public MmListado(long id, long nr, long nc, long folio, String gfh, String texto, String urlPdf, Date fecha,
//			String precedencia, String seguridad, String promotor, String[] ejecutivos, String[] informativos) {
//		this.id = id;
//		this.nr = nr;
//		this.nc = nc;
//		this.folio = folio;
//		this.gfh = gfh;
//		this.texto = texto;
//		this.urlPdf = urlPdf;
//		this.fecha = fecha;
//		this.precedencia = precedencia;
//		this.seguridad = seguridad;
//		this.promotor = promotor;
//		this.ejecutivos = ejecutivos;
//		this.informativos = informativos;
//	}
	public MmListado() {
	}
	

}
