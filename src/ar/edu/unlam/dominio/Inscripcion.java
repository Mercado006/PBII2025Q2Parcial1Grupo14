package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
	
	private Curso curso;
	private Alumno alumno;
	private List<Integer> notas;

	public Inscripcion(Curso curso, Alumno alumno) {
		this.curso = curso;
		this.alumno = alumno;
		this.notas = new ArrayList<Integer>();
	}

	public Curso getCurso() {
		return curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public List<Integer> getNotas() {
		return notas;
	}

	public void agregarNota(Integer notaUno) {
		this.notas.add(notaUno);
	}

	public Double calcularPromedio() {
		return null;
	}
}
