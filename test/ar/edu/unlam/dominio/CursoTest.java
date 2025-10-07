package ar.edu.unlam.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class CursoTest {
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirAlumnoACursoDevuelveTrue() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		assertTrue(sistema.anadirAlumnoACurso(alumno, curso));
	}
	
	@Test
	public void dadoNoQuedanCuposEnElCursoNoSePuedeAñadirAlAlumno() {
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
	
	@Test	
	public void dadoQueExisteUnCursoConElMetodoRecibirTrabajoPracticoDevuelveFalseSiSeIntentaEntregarDichoTrabajoFueraDeLaFechaEstipuladaEnTrabajoPractico() {
		 Integer dni = 123;
		 String nombre = "nombre";
		 String apellido = "apellido";
		 Alumno alumno = new Alumno(dni, nombre, apellido);
		
		 Profesor profesor = new Profesor(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introduccion a la programaci�n";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(cursoProgramacion);
		sistema.anadirProfesorACurso(profesor, cursoProgramacion);
		sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 21);
		assertFalse(alumno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego));
	}
}
