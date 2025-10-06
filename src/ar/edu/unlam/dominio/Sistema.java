package ar.edu.unlam.dominio;

import java.util.HashSet;
import java.util.Set;

public class Sistema {
	
	private Set<Curso> cursos;
	private Set<Profesor> profesores;
	private Set<Alumno> alumnos;
	private Set<Inscripcion> inscripciones;
	
	
	public Sistema() {
		this.cursos = new HashSet<Curso>();
		this.profesores = new HashSet<Profesor>();
		this.alumnos = new HashSet<Alumno>();
		this.inscripciones = new HashSet<Inscripcion>();
	}
	

	public boolean agregarCurso(Curso curso) {
		// TODO Auto-generated method stub
		return this.cursos.add(curso);
	}

	public boolean anadirProfesor(Profesor profesor) {
		// TODO Auto-generated method stub
		return this.profesores.add(profesor);
	}
	
	public boolean anadirAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return this.alumnos.add(alumno);
	}
	
	public boolean anadirAlumnoACurso(Alumno alumno, Curso curso) {
		// TODO Auto-generated method stub
		Inscripcion nuevaInscripcion = new Inscripcion(curso.getIdCurso(), alumno.getDni());
		return this.inscripciones.add(nuevaInscripcion);
	}

	public boolean anadirProfesorACurso(Profesor profesor, Curso curso) {
		// TODO Auto-generated method stub
		for(Profesor p : profesores) {
			if(p.getDni()==profesor.getDni())
				return p.anadirCurso(curso);
		}
		
		return false;
		
	}


	public Set<Curso> getCursos() {
		return cursos;
	}


	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}


	public Set<Profesor> getProfesores() {
		return profesores;
	}


	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}


	public Set<Alumno> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}


	public Set<Inscripcion> getInscripciones() {
		return inscripciones;
	}


	public void setInscripciones(Set<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
	
	



}
