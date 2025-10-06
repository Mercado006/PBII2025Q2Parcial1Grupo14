package ar.edu.unlam.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class CursoTest {
	
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
	
	@Test	
	public void dadoQueExisteUnCursoConElMetodoRecibirTrabajoPracticoDevuelveFalseSiSeIntentaEntregarDichoTrabajoFueraDeLaFechaEstipuladaEnTrabajoPractico() {
	// Testea el metodo de Curso recibirTrabajoPractico para que no se puedan entregar trabajos fuera de plazo.
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		
		Curso curso = new Curso();
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor, curso);
		sistema.inscribirAlumno(alumno, curso);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 21);
		assertFalse(alumno.entregarTrabajoPractico(trabajoPractico));
	}
}
