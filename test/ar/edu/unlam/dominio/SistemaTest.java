package ar.edu.unlam.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SistemaTest {
	
	@Test
	public void crearUnCursoYAgregarloAlSistema() {
		Curso curso = new Curso();
		Sistema sistema = new Sistema();

		assertTrue(sistema.agregarCurso(curso));
		
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAñadirAlumnoACursoDevuelveTrue() {
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		
		assertTrue(sistema.añadirAlumnoACurso(alumno, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAñadirProfesorACursoDevuelveTrue() {
		Profesor profesor = new Profesor();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		
		assertTrue(sistema.añadirProfesorACurso(profesor, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConUnaListaDeInscripcionesElMetodoAñadirAlumnoACursoAñadeUnaInscripcionADichaLista() {
		Curso curso = new Curso();
		Alumno alumno = new Alumno();
		
		Sistema sistema = new Sistema();
		
		sistema.añadirAlumnoACurso(alumno, curso);
		
		Integer tamañoEsperado = 1;
		Integer tamañoObtenido = sistema.getInscripciones.size();
		
		assertEquals(tamañoEsperado, tamañoObtenido);
	}
	
}
