package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SistemaTest {
	
	@Test
	public void crearUnCursoYAgregarloAlSistema() {
		Curso curso = new Curso(1, "PB2", 20);
		Sistema sistema = new Sistema();

		assertTrue(sistema.agregarCurso(curso));
		
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirAlumnoACursoDevuelveTrue() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new Curso(1, "PB2", 20);
		
		Sistema sistema = new Sistema();
		
		assertTrue(sistema.anadirAlumnoACurso(alumno, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirProfesorACursoDevuelveTrue() {
		Profesor profesor = new Profesor(22330190, "Juancito", "Perez");
		Curso curso = new Curso(1, "PB2", 20);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		
		assertTrue(sistema.anadirProfesorACurso(profesor, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConUnaListaDeInscripcionesElMetodoAnadirAlumnoACursoAnadeUnaInscripcionADichaLista() {
		Curso curso = new Curso(1, "PB2", 20);
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		
		Sistema sistema = new Sistema();
		
		sistema.anadirAlumnoACurso(alumno, curso);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = sistema.getInscripciones().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
	@Test
	public void dadoQueYaExisteUnProfesorAsignadoAlCursoNoSePermiteAsignarloNuevamente() {
		Curso curso = new Curso();
		Profesor profesor = new Profesor();
		Sistema sistema = new Sistema();
		
		assertTrue(sistema.asignarProfesorACurso(profesor, curso));
		assertFalse(sistema.asignarProfesorACurso(profesor, curso));
	}
}