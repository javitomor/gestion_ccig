package mil.candes.core.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class Mm {

	private long id;
	private long nr;
	private long nc;
	private long folio;
	private String gfh;
	private String texto;
	private String urlPdf;
	private LocalDate fecha;
	
	private long precedencia;
	private long seguridad;
	private long promotor;
	private long[] ejecutivos;
	private long[] informativos;
	
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
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public long getPrecedencia() {
		return precedencia;
	}
	public void setPrecedencia(long precedencia) {
		this.precedencia = precedencia;
	}
	public long getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(long seguridad) {
		this.seguridad = seguridad;
	}
	public long getPromotor() {
		return promotor;
	}
	public void setPromotor(long promotor) {
		this.promotor = promotor;
	}
	public long[] getEjecutivos() {
		return ejecutivos;
	}
	public void setEjecutivos(long[] ejecutivos) {
		this.ejecutivos = ejecutivos;
	}
	public long[] getInformativos() {
		return informativos;
	}
	public void setInformativos(long[] informativos) {
		this.informativos = informativos;
	}
	public Mm(long id, long nr, long nc, long folio, String gfh, String texto, String urlPdf, LocalDate fecha,
			long precedencia, long seguridad, long promotor, long[] ejecutivos, long[] informativos) {
		this.id = id;
		this.nr = nr;
		this.nc = nc;
		this.folio = folio;
		this.gfh = gfh;
		this.texto = texto;
		this.urlPdf = urlPdf;
		this.fecha = fecha;
		this.precedencia = precedencia;
		this.seguridad = seguridad;
		this.promotor = promotor;
		this.ejecutivos = ejecutivos;
		this.informativos = informativos;
	}
	
	@Override
	public String toString() {
		return "Mm [id=" + id + ", nr=" + nr + ", nc=" + nc + ", folio=" + folio + ", gfh=" + gfh + ", texto=" + texto
				+ ", urlPdf=" + urlPdf + ", fecha=" + fecha + ", precedencia=" + precedencia + ", seguridad="
				+ seguridad + ", promotor=" + promotor + ", ejecutivos=" + Arrays.toString(ejecutivos)
				+ ", informativos=" + Arrays.toString(informativos) + "]";
	}
	public Mm() {
	}
	
		
	
	
}
