package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
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
	public void dadoQueExisteUnSistemaElMetodoAnadirAlumnoACursoDevuelveTrue() {
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		
		assertTrue(sistema.anadirAlumnoACurso(alumno, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirProfesorACursoDevuelveTrue() {
		Profesor profesor = new Profesor();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		
		assertTrue(sistema.anadirProfesorACurso(profesor, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConUnaListaDeInscripcionesElMetodoAnadirAlumnoACursoAnadeUnaInscripcionADichaLista() {
		Curso curso = new Curso();
		Alumno alumno = new Alumno();
		
		Sistema sistema = new Sistema();
		
		sistema.anadirAlumnoACurso(alumno, curso);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = sistema.getInscripciones.size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
}
