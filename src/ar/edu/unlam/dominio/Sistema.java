package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	public Boolean agregarCurso(Curso curso) {
		return this.cursos.add(curso);
	}

	public Boolean anadirProfesor(Profesor profesor) {
		return this.profesores.add(profesor);
	}
	
	public Boolean anadirAlumno(Alumno alumno) {
		return this.alumnos.add(alumno);
	}
	
	public List<Alumno> obtenerAlumnosInscriptosAUnCurso(Curso curso) {
	    List<Alumno> alumnosInscriptos = new ArrayList<>();
	    for (Inscripcion inscripcion : this.inscripciones) {
	        if (inscripcion.getCurso().equals(curso)) {
	            alumnosInscriptos.add(inscripcion.getAlumno());
	        }
	    }
	    return alumnosInscriptos;
	}
	
	public List<Curso> obtenerCursosDeUnAlumno(Alumno alumno) {
	    List<Curso> cursosDelAlumno = new ArrayList<>();
	    for (Inscripcion inscripcion : this.inscripciones) {
	        if (inscripcion.getAlumno().equals(alumno)) {
	            cursosDelAlumno.add(inscripcion.getCurso());
	        }
	    }
	    return cursosDelAlumno;
	}
	
	public Boolean anadirAlumnoACurso(Alumno alumno, Curso curso) {
	    for (Curso cursoAEvaluar : this.cursos) {
	        if (cursoAEvaluar.getIdCurso().equals(curso.getIdCurso()) && cursoAEvaluar.getCapacidad() > cursoAEvaluar.getAlumnos().size()) {
	            if (cursoAEvaluar.getAlumnos().contains(alumno)) {
	                return false;
	            }
	            cursoAEvaluar.anadirAlumno(alumno);
	            Inscripcion inscripcion = new Inscripcion(cursoAEvaluar, alumno);
	            this.inscripciones.add(inscripcion);
	            alumno.anadirInscripcion(inscripcion);
	            return true;
	        }
	    }
	    return false;
	}

	public Boolean anadirProfesorACurso(Profesor profesor, Curso curso) {
	    for (Profesor profesorAEvaluar : this.profesores) {
	        if (profesorAEvaluar.getDni().equals(profesor.getDni())) {
	            for (Curso cursoAEvaluar : this.cursos) {
	                if (cursoAEvaluar.equals(curso)) {
	                    if (profesorAEvaluar.getCursosAsignados().contains(cursoAEvaluar)) {
	                        return false;
	                    }
	                    profesorAEvaluar.anadirCurso(cursoAEvaluar);
	                    cursoAEvaluar.anadirProfesor(profesorAEvaluar);
	                    return true;
	                }
	            }
	        }
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
