package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class TrabajoPractico {
	
	private LocalDate fechaLimite;
	private Curso cursoAlQuePertenece;

	public TrabajoPractico(LocalDate fechaLimite, Curso cursoAlQuePertenece) {
		this.fechaLimite = fechaLimite;
		this.cursoAlQuePertenece = cursoAlQuePertenece;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public Curso getCursoAlQuePertenece() {
		return cursoAlQuePertenece;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public void setCursoAlQuePertenece(Curso cursoAlQuePertenece) {
		this.cursoAlQuePertenece = cursoAlQuePertenece;
	}
	
	public Boolean puedeSerEntregado(LocalDate fechaEntrega) {
	    return fechaEntrega.isBefore(fechaLimite) || fechaEntrega.isEqual(fechaLimite);
	}
}
