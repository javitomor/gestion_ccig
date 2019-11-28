package mil.candes.core.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;



public class Mm {

	private long id;
	private long numeroRegistro;
	private long numeroControl;
	private long numeroFolio;
	private String grupoFechaHora;
	private String texto;
	private String archivo;
	private LocalDate fechaAlta;
//	private MultipartFile archivo;
	
	private long precedencia;
	private long seguridad;
	private long promotor;
	private long[] ejecutivo;
	private long[] informativo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(long nr) {
		this.numeroRegistro = nr;
	}
	public long getNumeroControl() {
		return numeroControl;
	}
	public void setNumeroControl(long nc) {
		this.numeroControl = nc;
	}
	public long getNumeroFolio() {
		return numeroFolio;
	}
	public void setNumeroFolio(long folio) {
		this.numeroFolio = folio;
	}
	public String getGrupoFechaHora() {
		return grupoFechaHora;
	}
	public void setGrupoFechaHora(String gfh) {
		this.grupoFechaHora = gfh;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String urlPdf) {
		this.archivo = urlPdf;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fecha) {
		this.fechaAlta = fecha;
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
	public long[] getEjecutivo() {
		return ejecutivo;
	}
	public void setEjecutivo(long[] ejecutivos) {
		this.ejecutivo = ejecutivos;
	}
	public long[] getInformativo() {
		return informativo;
	}
	public void setInformativo(long[] informativos) {
		this.informativo = informativos;
	}
	
//	public MultipartFile getArchivo() {
//		return archivo;
//	}
//	public void setArchivo(MultipartFile archivo) {
//		this.archivo = archivo;
//	}
	
	public Mm(long id, long nr, long nc, long folio, String gfh, String texto, String urlPdf, LocalDate fecha,
//			MultipartFile archivo, 
			long precedencia, long seguridad, long promotor, long[] ejecutivos,
			long[] informativos) {
		this.id = id;
		this.numeroRegistro = nr;
		this.numeroControl = nc;
		this.numeroFolio = folio;
		this.grupoFechaHora = gfh;
		this.texto = texto;
		this.archivo = urlPdf;
		this.fechaAlta = fecha;
//		this.archivo = archivo;
		this.precedencia = precedencia;
		this.seguridad = seguridad;
		this.promotor = promotor;
		this.ejecutivo = ejecutivos;
		this.informativo = informativos;
	}
	public Mm() {
	}
	


	
	
}
