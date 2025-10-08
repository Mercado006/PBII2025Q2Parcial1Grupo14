package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CursoTest {
	
	@Test
	public void dadoQueExisteUnCursoElMetodoAnadirAlumnoDevuelveTrue() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		assertTrue(curso.anadirAlumno(alumno));
	}
	
	@Test
	public void dadoQueExisteUnCursoElMetodoAnadirProfesorDevuelveTrue() {
		Profesor profesor = new Profesor(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		assertTrue(sistema.anadirProfesor(profesor));
	}
	
	@Test
	public void dadoQueExisteUnCursoConUnaListaDeAlumnosElMetodoAnadirAlumnoAgregaDichoAlumnoASuLista() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		curso.anadirAlumno(alumno);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = curso.getAlumnos().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
		assertTrue(curso.getAlumnos().contains(alumno));
	}
	
	@Test
	public void dadoQueExisteUnCursoConUnAtributoProfesorElMetodoAnadirProfesorActualizaDichoAtributo() {
		Profesor profesor = new Profesor(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		curso.anadirProfesor(profesor);
		
		Profesor profesorEsperado = profesor;
		Profesor profesorObtenido = curso.getProfesor();
		
		assertEquals(profesorEsperado, profesorObtenido);
	}
	
	@Test
	public void dadoQueExisteUnCursoYQueNoQuedanCuposEnElCursoNoSePuedeAnadirAlAlumno() {
		Curso curso = new CursoProgramacion(1, "PB2", 1, "Java");
		Alumno alumno1 = new Alumno(24330190, "Pepito", "Suarez");
		Alumno alumno2 = new Alumno(23230190, "Jose", "Suarez");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumno(alumno1);
		sistema.anadirAlumno(alumno2);
		sistema.anadirAlumnoACurso(alumno1, curso);
		
		assertFalse(sistema.anadirAlumnoACurso(alumno2, curso));
	}
}
