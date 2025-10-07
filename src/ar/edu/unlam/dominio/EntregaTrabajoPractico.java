package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class EntregaTrabajoPractico {
	
	private Integer id;
	private Alumno alumno;
	private LocalDate fechaEntrega;
	private Curso curso;
	private Integer nota;
	private boolean corregido;
	
	public EntregaTrabajoPractico(Alumno alumno, LocalDate fechaEntrega, Curso curso) {
		this.alumno = alumno;
		this.fechaEntrega = fechaEntrega;
		this.curso = curso;
		this.corregido = false;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public boolean isCorregido() {
		return corregido;
	}

	public void setCorregido(boolean corregido) {
		this.corregido = corregido;
	}
	
	
	

}
