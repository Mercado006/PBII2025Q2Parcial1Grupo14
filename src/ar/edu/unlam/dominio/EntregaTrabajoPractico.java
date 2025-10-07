package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class EntregaTrabajoPractico extends TrabajoPractico {
	
	private Alumno alumno;
	private Boolean isCorregido;

	public EntregaTrabajoPractico(Alumno alumno, LocalDate fechaLimite, Curso cursoAlQuePertenece) {
		super(fechaLimite, cursoAlQuePertenece);
		this.alumno = alumno;
		this.isCorregido = false;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public Boolean getIsCorregido() {
		return isCorregido;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void setIsCorregido(Boolean isCorregido) {
		this.isCorregido = isCorregido;
	}
}
