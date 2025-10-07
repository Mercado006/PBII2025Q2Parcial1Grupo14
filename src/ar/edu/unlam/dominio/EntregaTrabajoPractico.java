package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class EntregaTrabajoPractico extends TrabajoPractico {
	
	private Alumno alumno;
	private Boolean fueCorregido;
	private Integer nota;

	public EntregaTrabajoPractico(Alumno alumno, LocalDate fechaEntrega, Curso cursoAlQuePertenece) {
		super(fechaEntrega, cursoAlQuePertenece);
		this.alumno = alumno;
		this.fueCorregido = false;
		this.nota = null;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public Boolean getFueCorregido() {
		return fueCorregido;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void setFueCorregido(Boolean fueCorregido) {
		this.fueCorregido = fueCorregido;
	}
}
