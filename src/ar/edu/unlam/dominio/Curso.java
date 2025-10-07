package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Set;

public class Curso {
	
	private Integer idCurso;
	private String nombre;
	private Integer capacidad;
	private Set<Alumno> alumnos;
	
	public Curso(Integer idCurso, String nombre, Integer capacidad) {
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.alumnos = new HashSet<>();
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public Boolean anadirAlumno(Alumno alumno) {
		return alumnos.add(alumno);
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
}
