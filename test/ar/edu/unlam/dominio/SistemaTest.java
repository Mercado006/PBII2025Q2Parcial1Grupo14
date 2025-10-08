package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SistemaTest {
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAgregarCursoDevuelveTrue() {
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();

		assertTrue(sistema.agregarCurso(curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirAlumnoACursoDevuelveTrue() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoDisenio(1, "PB2", 20, "Photoshop");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumno(alumno);
		
		assertTrue(sistema.anadirAlumnoACurso(alumno, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConElMetodoAnadirAlumnoACursoDichoMetodoAnadeAlAlumnoALaListaDeAlumnosDelCurso() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoDisenio(1, "PB2", 20, "Photoshop");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumnoACurso(alumno, curso);
		
		assertTrue(curso.getAlumnos().contains(alumno));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConElMetodoAnadirProfesorACursoDichoMetodoActualizaElAtributoProfesorDelCurso() {
		Profesor profesor = new Profesor(24330190, "Pepito", "Suarez");
		Curso curso = new CursoDisenio(1, "PB2", 20, "Photoshop");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, curso);

		assertTrue(curso.getProfesor().equals(profesor));
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirProfesorACursoDevuelveTrue() {
		Profesor profesor = new Profesor(22330190, "Juancito", "Perez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		
		assertTrue(sistema.anadirProfesorACurso(profesor, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConUnaListaDeInscripcionesElMetodoAnadirAlumnoACursoAnadeUnaInscripcionADichaLista() {
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumno(alumno);
		sistema.anadirAlumnoACurso(alumno, curso);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = sistema.getInscripciones().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
	@Test
	public void dadoQueYaExisteUnProfesorAsignadoAlCursoNoSePermiteAsignarloNuevamente() {
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Profesor profesor = new Profesor(22330190, "Juancito", "Perez");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		
		assertTrue(sistema.anadirProfesorACurso(profesor, curso));
		
		assertFalse(sistema.anadirProfesorACurso(profesor, curso));
	}
}