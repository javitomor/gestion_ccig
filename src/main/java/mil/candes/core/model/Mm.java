package mil.candes.core.model;

import java.time.LocalDate;


public class Mm {

	private int id;
	private int nr;
	private int nc;
	private int folio;
	private String gfh;
	private String texto;
	private String urlPdf;
	private LocalDate fecha;
	
	private String precedencia;
	private String seguridad;
	private String promotor;
	private String ejecutivos;
	private String informativos;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNr() {
		return nr;
	}
	public void setNr(int nr) {
		this.nr = nr;
	}
	public int getNc() {
		return nc;
	}
	public void setNc(int nc) {
		this.nc = nc;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
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
	public String getEjecutivos() {
		return ejecutivos;
	}
	public void setEjecutivos(String ejecutivos) {
		this.ejecutivos = ejecutivos;
	}
	public String getInformativos() {
		return informativos;
	}
	public void setInformativos(String informativos) {
		this.informativos = informativos;
	}
	public Mm(int id, int nr, int nc, int folio, String gfh, String texto, String urlPdf, LocalDate i,
			String precedencia, String seguridad, String promotor, String ejecutivos, String informativos) {
		super();
		this.id = id;
		this.nr = nr;
		this.nc = nc;
		this.folio = folio;
		this.gfh = gfh;
		this.texto = texto;
		this.urlPdf = urlPdf;
		this.fecha = i;
		this.precedencia = precedencia;
		this.seguridad = seguridad;
		this.promotor = promotor;
		this.ejecutivos = ejecutivos;
		this.informativos = informativos;
	}
	public Mm() {
		
	}
	
	
	
}
