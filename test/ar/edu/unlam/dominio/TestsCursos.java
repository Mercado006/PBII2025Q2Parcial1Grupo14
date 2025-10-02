package ar.edu.unlam.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestsCursos {
	
	@Test
	public void asignarProfesorAUnCurso() {
		Curso curso = new Curso();
		Profesor profesor = new Profesor(); //esto para mi tiene que ser una relacion 1 a N, siendo profesor la N
		
		assertTrue(profesor.agregarCurso(curso));
	}
	
	@Test
	public void añadirUnAlumnoAlCurso() {
		Curso curso = new Curso();
		Alumno alumno = new Alumno();
		AlumnoCurso unionAlumnoCurso = new AlumnoCurso(); //se crea una clase intermedia, revisar la clase del 01/10
		
		assertTrue(unionAlumnoCurso.añadirAlumnoACurso(curso, alumno));
	}
	
	@Test
	public void dadoNoQuedanCuposEnElCursoNoSePuedeAñadirAlAlumno() {
		Curso curso = new Curso();
		Alumno alumno = new Alumno();
		AlumnoCurso unionAlumnoCurso = new AlumnoCurso();
		
		assertFalse(unionAlumnoCurso.añadirAlumnoACurso(curso, alumno));

	}
}
